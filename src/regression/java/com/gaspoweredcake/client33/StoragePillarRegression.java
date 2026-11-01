package com.gaspoweredcake.client33;

import com.gaspoweredcake.client33.utils.render.StoragePillar;

public final class StoragePillarRegression {
    public static void run() {
        check(StoragePillar.opacity(0) == 1 && StoragePillar.opacity(32) == 1, "Full opacity through 32 blocks");
        check(StoragePillar.opacity(80) == 0.5, "Linear fade halfway through range");
        check(StoragePillar.opacity(128) == 0 && StoragePillar.opacity(160) == 0, "No opacity from 128 blocks onward");
        check(StoragePillar.opacity(Double.NaN) == 0 && StoragePillar.opacity(Double.POSITIVE_INFINITY) == 0, "Nonfinite distances do not render");
        System.out.println("Storage pillar fade regressions passed.");
    }
    private static void check(boolean condition, String message) { if (!condition) throw new AssertionError(message); }
}
