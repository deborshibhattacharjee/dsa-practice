package dsa.arrays;

import java.util.Arrays;

public class MaximumProfitTest {
    public static void main(String[] args) {
        MaximumProfit solution = new MaximumProfit();
        int[][] inputs = {
                {7, 1, 5, 3, 6, 4},
                {7, 6, 4, 3, 1},
                {2, 4, 1},
                {5},
                {0},
                {5, 5, 5},
                {1, 2},
                {2, 1},
                {1, 2, 3, 4, 5},
                {3, 3, 1, 1, 4, 4},
                {1, 10, 0, 2},
                {9, 2, 6, 1, 8},
                {0, 1_000_000_000},
                {1_000_000_000, 0},
                {1_000_000_000, 0, 1_000_000_000},
                new int[100_000],
                new int[100_000]
        };
        int[] expected = {5, 0, 2, 0, 0, 0, 1, 0, 4, 3, 9, 7,
                1_000_000_000, 0, 1_000_000_000, 0, 1_000_000_000};
        inputs[16][99_999] = 1_000_000_000;

        int failures = 0;
        for (int i = 0; i < inputs.length; i++) {
            String label = "Case " + (i + 1) + " "
                    + (inputs[i].length <= 10
                    ? Arrays.toString(inputs[i]) : "(length " + inputs[i].length + ")");
            try {
                int actual = solution.maxProfit(inputs[i].clone());
                if (actual == expected[i]) {
                    System.out.println("PASS " + label);
                } else {
                    failures++;
                    System.out.println("FAIL " + label + ": expected "
                            + expected[i] + ", got " + actual);
                }
            } catch (RuntimeException exception) {
                failures++;
                System.out.println("FAIL " + label + ": threw " + exception);
            }
        }
        System.out.println((inputs.length - failures) + "/" + inputs.length + " passed");
        if (failures > 0) {
            throw new AssertionError(failures + " test case(s) failed");
        }
    }
}
