package com.gaspoweredcake.client33;

import com.gaspoweredcake.client33.utils.combat.AttackCycle;
import com.gaspoweredcake.client33.utils.combat.TargetSelection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

final class KillAuraRegression {
    static void run() {
        var random = new Random(33);
        for (int limit : new int[] {1, 2, 8, 100}) {
            for (Integer retained : new Integer[] {null, 42, -1}) {
                var selection = new TargetSelection<Integer>(limit, retained, Comparator.naturalOrder());
                var input = new ArrayList<Integer>();
                for (int i = 0; i < 100; i++) input.add(i);
                java.util.Collections.shuffle(input, random);
                for (int value : input) { selection.add(value); selection.add(value); }
                List<Integer> expected = new ArrayList<>(input.stream().sorted().toList());
                if (retained != null && expected.remove(retained)) expected.addFirst(retained);
                expected = expected.subList(0, Math.min(limit, expected.size()));
                check(selection.result().equals(expected), "streaming selection must equal a full sort with valid retention");
            }
        }
        var empty = new TargetSelection<Integer>(2, 7, Comparator.naturalOrder());
        check(empty.result().isEmpty(), "invalid retained targets must not be synthesized");
        var cycle = new AttackCycle();
        long first = cycle.begin();
        check(cycle.claim(first, false) && !cycle.claim(first, false), "one cooldown cannot be spent twice");
        long next = cycle.begin();
        check(!cycle.claim(first, true), "previous tick callbacks must be discarded");
        check(cycle.claim(next, true) && cycle.claim(next, true), "zero-delay custom batches remain supported");
        cycle.invalidate();
        check(!cycle.claim(next, true), "stop or world exit invalidates pending batches");
        System.out.println("KillAura selection and attack-cycle regressions passed.");
    }
    private static void check(boolean condition, String message) { if (!condition) throw new AssertionError(message); }
}
