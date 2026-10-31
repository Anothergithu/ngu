/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package com.gaspoweredcake.client33.systems.modules.render;

import com.gaspoweredcake.client33.Client33;
import com.gaspoweredcake.client33.settings.*;
import com.gaspoweredcake.client33.systems.modules.Categories;
import com.gaspoweredcake.client33.systems.modules.Module;
import com.gaspoweredcake.client33.utils.render.color.SettingColor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.resources.Identifier;

import java.util.Set;

public class Chams extends Module {
    private final SettingGroup sgThroughWalls = settings.createGroup("Through Walls");
    private final SettingGroup sgPlayers = settings.createGroup("Players");
    private final SettingGroup sgCrystals = settings.createGroup("Crystals");
    private final SettingGroup sgHand = settings.createGroup("Hand");

    // Through walls

    public final Setting<Set<EntityType<?>>> entities = sgThroughWalls.add(new EntityTypeListSetting.Builder()
        .name("entities")
        .description("Select entities to show through walls.")
        .onlyAttackable()
        .build()
    );

    public final Setting<Shader> shader = sgThroughWalls.add(new EnumSetting.Builder<Shader>()
        .name("shader")
        .description("Renders a shader over of the entities.")
        .defaultValue(Shader.Image)
        .build()
    );

    public final Setting<SettingColor> shaderColor = sgThroughWalls.add(new ColorSetting.Builder()
        .name("color")
        .description("The color that the image shader is drawn with.")
        .defaultValue(new SettingColor(157, 111, 255, 150))
        .visible(() -> shader.get() == Shader.Image)
        .build()
    );

    private final SettingGroup sgFracture = settings.createGroup("Fracture material");

    public final Setting<SettingColor> fractureColor = sgFracture.add(new ColorSetting.Builder()
        .name("cell-color").description("Color and opacity of the fractured surface.")
        .defaultValue(new SettingColor(188, 139, 44, 230)).visible(() -> shader.get() == Shader.Fracture).build());
    public final Setting<SettingColor> fractureSeam = sgFracture.add(new ColorSetting.Builder()
        .name("seam-color").description("Color of the bright seams and halo.")
        .defaultValue(new SettingColor(255, 238, 153, 255)).visible(() -> shader.get() == Shader.Fracture).build());
    public final Setting<Double> fractureScale = sgFracture.add(new DoubleSetting.Builder()
        .name("cell-size").description("Approximate cell size in screen pixels.")
        .defaultValue(24).range(6, 80).sliderRange(6, 80).visible(() -> shader.get() == Shader.Fracture).build());
    public final Setting<Double> fractureWidth = sgFracture.add(new DoubleSetting.Builder()
        .name("seam-width").description("Width of the bright seams in screen pixels.")
        .defaultValue(1.3).range(0.3, 5).sliderRange(0.3, 5).visible(() -> shader.get() == Shader.Fracture).build());
    public final Setting<Double> fractureGlow = sgFracture.add(new DoubleSetting.Builder()
        .name("halo").description("Intensity of the soft screen-space edge halo; zero disables it.")
        .defaultValue(0.45).range(0, 1).sliderRange(0, 1).visible(() -> shader.get() == Shader.Fracture).build());
    public final Setting<Double> fractureSpeed = sgFracture.add(new DoubleSetting.Builder()
        .name("animation-speed").description("Speed of the moving cells and seam shimmer; zero makes them static.")
        .defaultValue(0.35).range(0, 2).sliderRange(0, 2).visible(() -> shader.get() == Shader.Fracture).build());

    public final Setting<Boolean> ignoreSelfDepth = sgThroughWalls.add(new BoolSetting.Builder()
        .name("ignore-self")
        .description("Ignores yourself drawing the player.")
        .defaultValue(true)
        .build()
    );

    // Players

    public final Setting<Boolean> players = sgPlayers.add(new BoolSetting.Builder()
        .name("players")
        .description("Enables model tweaks for players.")
        .defaultValue(false)
        .build()
    );

    public final Setting<Boolean> ignoreSelf = sgPlayers.add(new BoolSetting.Builder()
        .name("ignore-self")
        .description("Ignores yourself when tweaking player models.")
        .defaultValue(false)
        .visible(players::get)
        .build()
    );

    public final Setting<Boolean> playersTexture = sgPlayers.add(new BoolSetting.Builder()
        .name("texture")
        .description("Enables player model textures.")
        .defaultValue(false)
        .visible(players::get)
        .build()
    );

    public final Setting<SettingColor> playersColor = sgPlayers.add(new ColorSetting.Builder()
        .name("color")
        .description("The color of player models.")
        .defaultValue(new SettingColor(157, 111, 255, 150))
        .visible(players::get)
        .build()
    );

    public final Setting<Double> playersScale = sgPlayers.add(new DoubleSetting.Builder()
        .name("scale")
        .description("Players scale.")
        .defaultValue(1.0)
        .min(0.0)
        .visible(players::get)
        .build()
    );

    // Crystals

    public final Setting<Boolean> crystals = sgCrystals.add(new BoolSetting.Builder()
        .name("crystals")
        .description("Enables model tweaks for end crystals.")
        .defaultValue(false)
        .build()
    );

    public final Setting<Double> crystalsScale = sgCrystals.add(new DoubleSetting.Builder()
        .name("scale")
        .description("Crystal scale.")
        .defaultValue(0.6)
        .min(0)
        .visible(crystals::get)
        .build()
    );

    public final Setting<Double> crystalsBounce = sgCrystals.add(new DoubleSetting.Builder()
        .name("bounce")
        .description("How high crystals bounce.")
        .defaultValue(0.6)
        .min(0.0)
        .visible(crystals::get)
        .build()
    );

    public final Setting<Double> crystalsRotationSpeed = sgCrystals.add(new DoubleSetting.Builder()
        .name("rotation-speed")
        .description("Multiplies the rotation speed of the crystal.")
        .defaultValue(0.3)
        .min(0)
        .visible(crystals::get)
        .build()
    );

    public final Setting<Boolean> crystalsTexture = sgCrystals.add(new BoolSetting.Builder()
        .name("texture")
        .description("Whether to render crystal model textures.")
        .defaultValue(true)
        .visible(crystals::get)
        .build()
    );

    public final Setting<SettingColor> crystalsColor = sgCrystals.add(new ColorSetting.Builder()
        .name("crystal-color")
        .description("The color of the of the crystal.")
        .defaultValue(new SettingColor(157, 111, 255, 255))
        .visible(crystals::get)
        .build()
    );

    // Hand

    public final Setting<Boolean> hand = sgHand.add(new BoolSetting.Builder()
        .name("enabled")
        .description("Enables tweaks of hand rendering.")
        .defaultValue(false)
        .build()
    );

    public final Setting<Boolean> handTexture = sgHand.add(new BoolSetting.Builder()
        .name("texture")
        .description("Whether to render hand textures.")
        .defaultValue(false)
        .visible(hand::get)
        .build()
    );

    public final Setting<SettingColor> handColor = sgHand.add(new ColorSetting.Builder()
        .name("hand-color")
        .description("The color of your hand.")
        .defaultValue(new SettingColor(157, 111, 255, 150))
        .visible(hand::get)
        .build()
    );

    public static final Identifier BLANK = Client33.identifier("textures/blank.png");

    public Chams() {
        super(Categories.Render, "chams", "Tweaks rendering of entities.");
    }

    public boolean shouldRender(Entity entity) {
        return isActive() && !isShader() && entities.get().contains(entity.getType()) && (entity != mc.player || !ignoreSelfDepth.get());
    }

    public boolean isShader() {
        return isActive() && shader.get() != Shader.None;
    }

    public enum Shader {
        Image,
        None,
        Fracture
    }
}
