# Module workspace and automation

Press **Right Shift** to open 33. The startup credit is simply **33**.

## Finding and configuring modules

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:0b8b4973d3eb78cdf3f50feb7f56ed671b229c01f2b1f65921d93b10f5addc21 -->

- The workspace opens on an overview with module counts, quick controls, and links to the library and Visual Studio. Use the scrollable sidebar for categories, All, Favorites, Enabled, and quick access.

<!-- /coderabbit-ai-generated:v1 -->
- Search names, descriptions, and setting titles. Exact name matches appear first.
- Click a module to switch it on or off. Click **Configure** (or right-click the module) to configure it.
- Star a module to keep it in Favorites. Hidden modules stay out of library search results.
- Press **Ctrl+F** (**Command+F** on macOS) to focus the browser search.
- Inside a module, use **Find a setting** to filter controls. The enable switch and Back button are at the top; keybind and feedback controls are in a collapsible section.

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:8b56fb7cdfc6d13cbd3e0303f4cf241f9cbdc39fabf9e64fa2229ca5c89760e0 -->

The default palette uses crimson accents over charcoal cards. Existing saved theme colors remain customizable in the GUI tab. <!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:09f22c9aa88e356d1d972f851a2c0ad030e69d94dc43042cbf1eed898c40c530 -->

In **GUI → Background**, edit **Panel Background**, **Screen Tint**, **Preview Grid**, and **Preview Body** colors; **GUI → Outline → Panel Border** controls card outlines. Defaults retain the existing appearance. The Blur module releases its textures when its fade finishes and recreates them only when needed.

<!-- /coderabbit-ai-generated:v1 -->

<!-- /coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:dd113923fbc4a79c47c7d657257b8365ba8857cfd54dbfece4c15919ad421f9c -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:8a8fcfe89c1eaed08ba3ce8d12aab1b59cc16451c9d2e7ece7bf92a3e9d2fe9f -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:5fa028579ff73a64488e532b2cce0d1400ebf69f5717169106ef202482255262 -->

## Flight: Packet Glide

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:339a861cd7c3179cd7ed0db9aae3d288bde3afb92c076449e8486ba6a061cc7f -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:33217b793b07a6228e6cfbd578ac0d805b96aeeaccabd3c72bc0914a26f397ca -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:22b55ca293d668c68ad45ee291dd2d88a239e6960856fa7c9e4d86634e79c380 -->

Select **PacketGlide** in Flight for tick-based gradual acceleration and configurable idle descent. Speed Cap limits horizontal motion and Vertical Speed Cap limits vertical motion; their defaults are 1.0 and 0.5 blocks per tick. Their combined computed velocity is capped at 1.59 blocks per tick. <!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:3fc5c5b8248c8f1c3395f210466d637446e7b0d6f4d3deea63624645a712b20a -->

Existing Speed Cap values up to 1.59 are retained as the horizontal limit; larger values are not accepted.

<!-- /coderabbit-ai-generated:v1 --> Server tolerances vary.

<!-- /coderabbit-ai-generated:v1 -->

<!-- /coderabbit-ai-generated:v1 -->

<!-- /coderabbit-ai-generated:v1 --> <!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:68043b02b4bd683b286a3bae36850e5b096e682b654df3c88c9908ab0bd6362d -->

PacketGlide pauses its motion and packet rewriting while the client reports active elytra gliding; it does not locally cancel gliding. Minecraft has no stop-gliding command packet.

<!-- /coderabbit-ai-generated:v1 --> Position corrections disable Flight by default. Auto, Abilities and Velocity remain available, and Auto remains the default for saved settings and modules such as Anti Void. This is a configurable approximation, not a verified Argon sequence or a guarantee that a server accepts flight.

## Freecam

<!-- /coderabbit-ai-generated:v1 -->

Freecam moves the camera separately from the real player. Sprint Multiplier and Vertical Multiplier tune camera speed; their defaults preserve the previous speeds. Movement stops while a screen blocks input unless GUI Move permits it. Your player remains subject to normal game physics and server movement.

## Scaffold

<!-- /coderabbit-ai-generated:v1 -->

Scaffold checks falling blocks against the block beneath the placement and revalidates queued rotations before placing. The nearby fallback search is bounded by interaction reach. Existing air-place, tower, hotbar and filter settings remain available; server placement rules still determine whether attempts succeed.

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:4d18030587e6f132a999b06a270a41cac6e70872e54e41d7a0cdcb448b65d7f6 -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:7279a2abed42f98a37d8e5e913aec56ddf179820dd711d69a797a53d2bea70f8 -->

## Data acquisition

The shared IntelBus snapshots loaded section palette indices, heightmaps and block/sky light on the client thread, then hashes and analyzes detached data on the existing worker pool. Section and job caches are bounded; light is evidence, not proof of a base. Chunk unloads and received block or light changes invalidate relevant observations. Block entity packets are recorded in `client33/intel/block-entities.sqlite3`, scoped by hashed server identity and dimension; missing NBT is unknown. Queue overflow or storage failures can leave gaps.

The translation guard identifies non-vanilla keys from installed mod language files and sanitizes matching sign text before decoded packet handlers run. This also affects legitimate sign text using those keys, and does not identify keys absent from installed mod resources. Raw clientbound packet prefixes, timing, server-sent entity positions, tracker metadata and slot updates are bounded session observations. A server cannot send an unknown metadata index that the client protocol cannot decode; withheld entities and blocks cannot be inferred from absent packets. The `.intel` command exposes status, sections, packets, entities, slots and cached block-entity keys. Use the **Config → Data Acquisition** settings to adjust capture, packet prefix size, persistent NBT and section budget.

## Activity ESP and Chunk Probe

<!-- /coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:54d1a931ca7458b59db19f85b70521a9e85641ef0d65ae76b32be48fd7c39f61 -->

Activity ESP marks received block break, place, step and container sounds, selected server-sent particles, and the brightest received block-light value in each 8-block region below a configurable Y. Colors and labels distinguish light from sound and particle observations. Both data and work queues are bounded and expire; changing the light threshold clears the session. Particle effects generated only by the client are not packet observations, and light can come from natural sources. These markers do not establish that a player or base is present.

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:919f1ff434341e6f69b2b19e4b308f24e96e566130209d1b63cd6aa6ecf408bd -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:c18b641302c536acfc2b00a7646b26148c65534dadcd1daa8b1dd67544c58fcf -->

Spawner Info reports the name and text supplied in slot 49 of a manually opened 54-slot menu. It recognizes an item named Spawner Info, or an item whose name matches a spawner menu title and whose lore contains both Stacked and Stored Loot, as in the supplied Iron Golem Spawner example. Spawner Scanner also retains the most recent matching menu observation for the current session; it does not attach a position to that menu. Neither establishes ownership or whether a spawner can be stolen. Spawner Scanner lists top-level keys from server-sent spawner block-entity NBT in newly received chunk and block-entity packets. Its bounded session cache clears on unload or world change. It cannot recover packet NBT from chunks loaded before activation. Missing plugin keys can mean the server omitted them; access and ownership remain unknown until the server format and semantics are verified.

<!-- /coderabbit-ai-generated:v1 -->

<!-- /coderabbit-ai-generated:v1 -->

<!-- /coderabbit-ai-generated:v1 -->

Chunk Probe is an opt-in, single-use movement packet experiment. Configure an X/Z offset and target Y, then enable it (or bind its module key) to attempt the probe and report the current client position one tick later. It stops on a server position correction and does not run while Blink is enabled. The server controls movement and chunk delivery: it may reject the probe, move or disconnect the player, or send no extra chunks. Test only where that behavior is acceptable.

## ESP

<!-- /coderabbit-ai-generated:v1 -->

<!-- /coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:e687bf6d1dbad16a28fbc6bafe66aa2226d5bd332b31b321cfc96e00ba514a34 -->

The 2D renderer interpolates entity bounds, validates projection depth and finite coordinates, and clips boxes to the viewport. Entities crossing the camera plane are omitted to prevent oversized boxes. Health and armor bars, names, health values, and distance labels have separate controls. Names default to Auto, preserving the existing Telemetry label; Always and Off provide explicit control. Ignore Friends and Ignore Invisible apply to all modes, including highlighted targets. Max Distance applies to every mode. Box, Wireframe, Shader, and Glow modes remain available with existing saved settings. The Studio ESP card also links to Tracers for line and off-screen indicators; enable Tracers separately.

<!-- /coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:656cf82ace75b6d8e92ff60a9f443928d42380dc3cc78a5a41d5a61991de1f28 -->

## Fracture Chams

Open **Chams** from quick access or search, select **Fracture** under Through Walls → Shader, select the entity types to show, and enable the module. The material uses moving, irregular gold cells with bright seams and a small halo. Fracture Material controls the two colors, cell size, seam width, halo and animation speed; set speed or halo to zero to disable each effect.

The effect uses the existing through-walls entity mask. Its pattern and halo are screen-space, so cells stay aligned to the screen rather than wrapping around the model, and the halo is not scene lighting or bloom. The original Image and None modes and saved entity selections are preserved.

## KillAura

<!-- /coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:771373836e41a859446fddf2fda6e90f91293090bd8b642cfb6bfcebf90d5a02 -->

Targets come from a nearby spatial query. A bounded priority queue retains the best candidates with scores calculated once per candidate and stable entity-ID tie breaking. Keep Target retains a valid primary target. Field of View limits the horizontal targeting cone. Attack and wall ranges both measure from the player's eyes to the closest point on the target hitbox.

Aim Method defaults to Configured Part, using the existing Aim At choice. Closest Hitbox optionally aims at the nearest interior point of the target bounds, falling back to the configured part when your eyes are inside those bounds. It does not predict future movement or guarantee that the aim point is unobstructed.

Vanilla attack cooldown is used by default. Custom delays use a tick clock that advances while paused; TPS Sync scales custom delays. Weapon switch delay is independent. Queued attacks recheck pause conditions, player/world identity, weapon components and slot, cooldown and target validity immediately before execution. Normal cooldowns are reserved once per tick; zero-delay custom batches retain multiple-target support. Changing ticks or stopping the module invalidates queued work. Swap Back restores a slot only while KillAura still owns the selected slot, preserving a manual slot change. Friend, entity type, age, named/tamed entity, and shield filters still apply.

<!-- /coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:24b557bdf326587808febe0c102d4043e8016695ebd496fa08fd7997169073c3 -->

## Chest Stealer

Enable **Chest Stealer** in Misc or search for it, then open a single or double chest-style container. It moves up to three stacks per tick by default; adjust the batch size and delay in its settings. It waits for container contents, an empty cursor and available inventory space. It pauses while Inventory Tweaks auto steal or auto dump is enabled. Generic chest-style menus can also be used by server plugins.

## Automation

<!-- /coderabbit-ai-generated:v1 -->

- **AutoEat** locks its food choice for the current eating session, honors food components and the blacklist, respects manual item use, and pauses while a screen is open. Full inventory search can borrow an occupied hotbar slot and restore its contents when the inventory still matches the session. It never moves items through an open container or occupied cursor. Manual inventory changes are preserved. AutoGap takes priority and releases AutoEat's resources before starting.
- **AutoTotem** evaluates danger every tick, independently of its inventory movement delay. Strict mode avoids unnecessary damage prediction. Inventory moves wait for the player inventory and an empty cursor; its lock and timers reset on disconnect/deactivation.

## Verification

Use Java 25 and `./gradlew build`. The build's `check` task runs `moduleLogicRegression`, a Java regression harness covering combat/recon boundaries, lifecycle transitions, shared scans, persistence failures, loopback HTTP and visual geometry. `./gradlew runClient` launches a development client for in-game verification.

## Visual Studio and combat effects

The menu uses the existing custom Minecraft GPU pipelines (tested with OpenGL), not ImGui or DX11. It stays integrated with Minecraft input, scaling and resource lifecycle without another native dependency. The animated menu figures are schematic previews, not live player models; use a world to see actual effects. Saved custom theme colors remain in place; reset GUI color settings to use the new crimson defaults.

- **Hologram ESP**: segmented ground orbit, vertical rails and a rising scan band.
- **Constellation ESP**: twin animated helices with bright nodes around each entity.
- **Telemetry ESP**: screen-space brackets, scan line, ruler ticks, entity name/distance and optional health bar.
<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:381bd8a64d959da12767c91e7bbf89bb6c674cb27e88c22ec98cbb44be41e627 -->

- Hologram and Constellation have animation, ground markers, color, target tether, detail, terrain occlusion and entity budget controls. The budget prioritizes highlighted targets, then nearby entities; entity selection and maximum distance still apply. Telemetry has animation and screen-space controls. KillAura's selected target can use the target color. The Studio menu shows controls for the selected mode.

<!-- /coderabbit-ai-generated:v1 -->
- **Combat Visuals**: broken target orbits, scanning band, crown markers, expanding attack rings, radial sparks and a fading movement ribbon. Primary/secondary colors, animation speed, lifetime, size, depth visibility, ring detail and simultaneous burst limit are configurable.
- **Auto third person** is opt-in in Combat Visuals. With both Combat Visuals and KillAura enabled it switches to the rear camera and restores the prior perspective when KillAura/Combat Visuals is disabled. Manual perspective changes yield camera control until the next activation. FreeLook/Freecam take priority. The movement ribbon is visible in third person; a teleport clears it.
- Attack bursts visualize local attack attempts, including manual attacks; they do not claim server-confirmed damage. Effects are bounded and cleared on disconnect/world change/deactivation. Pausing the game pauses effect lifetimes.
- Crimson Hologram, Arctic Constellation and Minimal Telemetry presets change appearance settings only. Enable ESP and Combat Visuals explicitly. Existing entity selections are preserved; ESP defaults to players.
- Scene shortcuts expose the existing Ambience, Fullbright, Camera Tweaks, FreeLook and Hand View controls.

### Quick start

1. Right Shift → Studio → choose a look preset.
2. Click the ESP module row to enable it; choose entities under **All ESP settings**.
3. Enable Combat Visuals and select **Third-person camera** if desired.
4. Configure/enable KillAura independently. The visual module never starts combat for you.
5. Use **All combat visuals** for effect colors, intensity and performance controls.

## Reconnaissance and PvP additions (26.2)

Open **Studio → World Intelligence / PvP Control**, or search these module names.

### Container ESP (`storage-esp`)

Discovery now walks the loaded 26.2 chunk block-entity positions incrementally instead of enumerating every chunk on every rendered frame. It validates entries against the current client world, clears on world changes, deduplicates double chests and includes container entities (chest boats and chest/hopper minecarts). Discovery, cache and render budgets bound work. Block Shader mode is preserved; vehicle storage uses a box overlay. No container contents or unloaded chunks are inferred.

### Faction Intel (`faction-intel`)

Combines claim boundaries and a power tracker. Inputs are received chat (including `/f who` responses), tab header/footer and custom tab names, and the displayed sidebar. It is passive except for the explicitly clicked **Request /f who** button. Records clear on disconnect or dimension change. Claim labels show owner, source and age; power readings retain each source, display the newest reading and flag disagreement rather than average conflicting values. Expiry is configurable. Claim boundaries are drawn at your current feet height; adjacent equal-owner chunks share an outer perimeter. Unknown chunks are not treated as wilderness.

Servers have different text layouts. The default grammar deliberately requires explicit coordinates/names and accepts these **synthetic example formats**:

```text
Claim [-2, 3]: Knights
Knights Power: 20/40
```

It also accepts a `Faction: Knights` line followed within five seconds by `Power: 20/40` from the same source. Claim Pattern takes exactly three capture groups (chunk X, chunk Z, owner); Power Pattern takes exactly three (faction, current power, maximum power). Invalid patterns disable parsing and show a HUD diagnostic. Patterns match whole lines, so normal player chat prefixes do not match.

Text maps accept the following bounded format, with north at the top (decreasing Z), east at the right (increasing X), and `+` identifying the header's chunk coordinate:

```text
Faction Map [-2, 3]
|AA.|
|A+B|
Legend: A=Knights,B=Rivals
```

`+` and unlisted symbols have unknown ownership. A map needs exactly one origin, rectangular rows, a legend, and must arrive within five seconds. This supports explicit textual map data; map-item pixels alone do not establish claim ownership. The map header, row and legend patterns are configurable: header captures chunk X/Z, row captures the grid cells, and repeated legend matches capture a single symbol and faction name. Actual plugin samples are still needed to tune these patterns. Layouts without explicit coordinates, a single `+` origin, or a symbol legend need a server-specific adapter. Text observations are not authoritative server claim APIs.

### Movement Heatmap (`movement-heatmap`)

Aggregates received player movement into bounded horizontal cells. Repeated movement raises intensity; stationary positions, large teleports and expired tracks do not. Half-life, expiry, minimum samples, cell size, render distance and friend/self inclusion are configurable. Cells are drawn at their most recently observed height. Self and friends are excluded by default. Only loaded players can contribute. The map remains in memory for this world session; it never uploads data or writes identifiable movement logs. A hotspot suggests activity, not proof of a base.

### Structure ESP (`structure-esp`)

Uses 26.2's POI registry and section palettes to discover POI blocks in loaded chunks, plus configurable landmark blocks (trial spawners, vaults, spawners and shriekers by default). The incremental scan has a block budget and skips palettes with no matching states. Block removal/unload clears local markers.

It also passively reads `ClientboundDebugChunkValuePacket` / `DebugSubscriptions.STRUCTURES` and `ClientboundDebugBlockValuePacket` / `DebugSubscriptions.POIS`. Structure bounding boxes and debug POIs appear only if the server actually sends these values. Empty updates remove observations; received data expires. It does not request privileged debug subscriptions, infer a seed, or equate a placed marker block with a generated structure. Ordinary multiplayer servers normally provide no structure debug bounds.

### Server-aware melee and shield estimates

KillAura's **Server Cooldown** uses monotonic time, server game-time deltas, sent attack packets and the current weapon's attack-speed delay. It uses a conservative jitter/configured margin and also requires the client cooldown to be ready. Duplicate/reordered time packets cannot refresh the model; stale timing pauses normal attacks. Until timing is sampled it uses a 20 TPS fallback. Constant ping is not subtracted from every cooldown: both successive attack packets experience that latency. Custom Delay remains the explicit override for plugin combat rules. Deferred attacks recheck readiness, so normal cooldown mode attacks one target per cooldown rather than spending the same ready state on several targets.

**Shield Predict** reads the target's received active-hand/item-use state and the item's 26.2 `BLOCKS_ATTACKS` delay component. It estimates use duration in server ticks, adds capped half-ping lead, and checks whether the target faces the attacker. KillAura's Ignore/Break shield rules can use that estimate. Merely holding a shield does not count as blocking. The HUD shows observed main/offhand items and estimated state. Server plugins and custom blocking arcs/disable rules can differ; no hidden shield cooldown or future offhand swap is claimed as known.

### Crystal Aura improvements

- Server Pacing scales configured delays with estimated server tick duration and waits for spawn/removal observations before retrying pending actions, with a bounded latency-aware timeout.
- Deferred actions carry a generation guard and recheck active state, world, pause/range/placement conditions and explosion damage at execution time.
- Health Reserve preserves a configurable amount of health/absorption when Anti Suicide is enabled.
- Damage Advantage optionally requires target damage to exceed self damage by a configured amount.
- Protect Friends rejects predicted explosions above the friend damage cap or predicted lethal friend damage.
- Fast Break now honors the break enable switch, pause state, switch delay and attack budget.

Damage, shield and cooldown decisions are estimates from received state. These changes provide explicit freshness/risk controls and reduce stale actions; outperforming another client would require a controlled multiplayer benchmark.

## Shared infrastructure improvements

Settings saves now write and flush a sibling staging file before replacement. Failed serialization cannot stream a partial file over the saved configuration. Unreadable settings receive a uniquely named recovery copy; if that fails, the original file is protected from subsequent saves during the session. Existing NBT filenames and formats are preserved.

Invalid numeric settings now report an error instead of a false success message. Nonfinite floating-point values are rejected. Clipboard NBT imports have size/allocation limits. Shared TPS consumers use the same monotonic timing estimate as combat.

See `rewrite-status.md` for implementation provenance, reviewed scope, and the remaining full-client rewrite work.

### Inventory and repair automation

Shared inventory actions now own their builder state and are bound to the container menu in which they were created. Slot resolution reads the current menu's actual inventory-backed slots, covering containers without maintaining a table of fixed offsets. Armor helpers use the actual boots-to-helmet inventory order.

AutoReplenish retains an exhausted slot's item template until you edit your inventory, so it can refill when supplies arrive later. It searches ordinary inventory slots and avoids a carried cursor stack. AutoArmor pauses for other container menus/cursor items, understands component-based gliders, and breaks equal-score ties using remaining durability. AutoEXP re-resolves experience bottles after replenishment and immediately before the rotation callback, preventing use of the old source slot; queued throws are cancelled when disabled, paused, or moved to another world. Throw Delay (four ticks by default) leaves time for XP absorption before spending another bottle. Chat and module menus do not erase AutoReplenish's exhausted-slot template; closing an inventory screen refreshes it to respect manual edits.

## Advanced Storage ESP

<!-- coderabbit-ai-generated:v1 -->

<!-- coderabbit-ai-generated-section:v1:1d90b3260f421ae77b690d1c9bfe3ca4b9e3448a9bbe104d82c8b82559a72718 -->

Choose **Storage ESP → Box Style → Hologram** for corner rails, a scanning band and broken locator rings. Corners, Full and Shader remain available. Signature Visuals controls animation, accent and label scale. Closest loaded blocks receive the render budget first. Matching double-chest halves share a box and label. Enable **Vertical Pillars** under Signature Visuals for translucent columns from loaded containers to build height. Their color follows the container, width and maximum opacity are configurable, and opacity fades linearly from full at 32 blocks to zero at 128. Pillar discovery uses this range independently of the box max-distance. Pillars have a separate render budget using the same limit; block containers are prioritized before vehicles. Unloaded chunks cannot be shown.

<!-- /coderabbit-ai-generated:v1 -->

Container Intelligence adds nonoverlapping labels and a reticle inspector. Labels show type/custom name, distance, capacity, observed occupied slots, item totals and observation age. Optional coordinates and separate label distance/count limits keep dense storage areas readable. Point near a container to inspect its registry type, XYZ/chunk/dimension, current block-state properties, and chest block-above obstruction. The block-above check does not detect cats or plugin access rules.

**Contents unknown** means no usable server inventory observation exists. Opening a compatible container records only its server-sent storage slots, excluding player inventory and cursor. Later slot packets update the summary. Predicted inventory clicks are also sampled from the initialized menu because accepted clicks may not produce a slot echo; those summaries explicitly read **Client menu view**, rather than **Server snapshot**. The inspector lists the most numerous item types, custom names, enchanted-stack count and lowest equipment durability. Double chests, normal storage menus and container vehicles are supported. Server plugins can use different menus; compatible menu association is based on your recent interaction and is not an authoritative remote inventory API.

Observations stay in memory for this world session, are limited to 256 containers, and expire after the configured interval (five minutes by default). Replacement/unload invalidates object identity; changes to a paired chest invalidate its old summary. Another player can change contents after you close a container, so every remembered summary shows its age. No automatic opening or hidden-inventory requests are made. Ender-chest observations are the player's own inventory seen through that opened chest, not another player's contents. Clearing the rendering cache also clears content observations. Disabling Remember Contents clears them immediately.

Hide Opened now requires an actual unexpired observed inventory; merely attempting to interact with a blocked container no longer hides it.

InventoryTweaks sorting now plans using copied item components, so custom names, enchantments and other stack metadata are preserved in the plan. Each move checks the same screen/menu and expected source/destination contents; manual changes cancel remaining stale moves. Equal-count tools of the same type place the less-damaged tool first. When Disable in Creative is off, the creative player-inventory tab uses Minecraft's creative click handler and validates the wrapped slots. Item-catalog tabs are not sortable storage; changing tabs cancels an existing plan.
