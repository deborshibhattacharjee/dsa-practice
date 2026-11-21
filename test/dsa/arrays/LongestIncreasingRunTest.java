package dsa.arrays;

import java.util.Arrays;

/**
 * Tests for Longest Strictly Increasing Contiguous Run.
 * Input: int[] nums; output: length of the longest adjacent strictly increasing
 * segment. A single element counts as length 1; equal values break a run.
 * Constraints: 1 <= length <= 100,000; values between -1,000,000,000 and
 * 1,000,000,000. Target: O(N) time and O(1) auxiliary space.
 * Examples: [1, 3, 5, 4, 7] -> 3; [2, 2, 2] -> 1; [5] -> 1;
 * [5, 4, 1, 2, 3, 4] -> 4.
 */
public class LongestIncreasingRunTest {
    public static void main(String[] args) {
        LongestIncreasingRun solution = new LongestIncreasingRun();
        int[][] inputs = {
                {1, 3, 5, 4, 7}, {2, 2, 2}, {5},
                {5, 4, 1, 2, 3, 4}, {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1}, {1, 3, 3, 4}, {1, 2, 3, 0},
                {5, 1, 2, 3, 4}, {1, 2}, {2, 1}, {0},
                {-5, -3, -1, -4, -2}, {0, 1, 0, 1, 0, 1},
                {1, 2, 3, 0, 1, 2, 3, 4, -1},
                {-1_000_000_000, 1_000_000_000},
                {1_000_000_000, -1_000_000_000},
                new int[100_000], new int[100_000], new int[100_000]
        };
        int[] expected = {3, 1, 1, 4, 5, 1, 2, 3, 4, 2, 1, 1, 3, 2,
                5, 2, 1, 1, 100_000, 1};
        for (int i = 0; i < 100_000; i++) {
            inputs[18][i] = i;
            inputs[19][i] = 100_000 - i;
        }
        int failures = 0;
        for (int i = 0; i < inputs.length; i++) {
            String label = "Case " + (i + 1) + " "
                    + (inputs[i].length <= 10 ? Arrays.toString(inputs[i])
                    : "(length " + inputs[i].length + ")");
            try {
                int actual = solution.longestIncreasingRun(inputs[i].clone());
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
