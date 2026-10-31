package com.gaspoweredcake.client33.utils.render;

/** Distance fade for storage pillars. */
public final class StoragePillar {
    private StoragePillar() {}

    public static double opacity(double distance) {
        if (!Double.isFinite(distance) || distance >= 128) return 0;
        if (distance <= 32) return 1;
        return (128 - distance) / 96;
    }
}
