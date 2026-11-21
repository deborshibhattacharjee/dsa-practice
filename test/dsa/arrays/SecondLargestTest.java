package dsa.arrays;

import java.util.Arrays;

public class SecondLargestTest {
    public static void main(String[] args) {
        SecondLargest solution = new SecondLargest();
        int[][] inputs = {
                {5},
                {5, 5, 5},
                {0, 1},
                {10, 5, 10},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {0, 0},
                {5, 3, 8, 8, 6, 9, 9, 7},
                {12, 35, 1, 10, 34, 1},
                {7, 7, 7},
                {0},
                {1, 0},
                {2, 1, 1, 2},
                {9, 1, 8, 3, 7},
                {1, 2, 1, 2, 3},
                {0, 1_000_000_000},
                {1_000_000_000, 999_999_999, 1_000_000_000},
                new int[100_000],
                new int[100_000]
        };
        int[] expected = {
                -1, -1, 0, 5, 4, 4, -1, 8, 34, -1, -1, 0,
                1, 8, 2, 0, 999_999_999, -1, 999_999_999
        };
        // Maximum-size cases: all zeros, and a distinct pair near the end.
        inputs[18][99_998] = 999_999_999;
        inputs[18][99_999] = 1_000_000_000;

        int failures = 0;
        for (int i = 0; i < inputs.length; i++) {
            String label = "Case " + (i + 1) + " "
                    + (inputs[i].length <= 10
                    ? Arrays.toString(inputs[i]) : "(length " + inputs[i].length + ")");
            try {
                int actual = solution.secondLargest(inputs[i].clone());
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
