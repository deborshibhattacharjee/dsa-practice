package dsa.arrays;

import java.util.Arrays;

/**
 * Longest Contiguous Run with Alternating Parity: given int[] nums, return
 * the longest contiguous segment length whose adjacent elements have different
 * parity. Elements cannot be skipped; a single element counts as length 1.
 * Input: int[] nums. Output: length as an int.
 * Constraints: length 1 to 100,000; values 0 to 1,000,000,000.
 * Target: O(N) time and O(1) auxiliary space.
 * Examples: [2, 5, 8, 3, 6] -> 5; [2, 4, 7, 10, 12] -> 3;
 * [1, 3, 5] -> 1; [0, 1, 2, 4, 5, 6, 7] -> 4; [8] -> 1.
 */
public class LongestAlternatingParityRunTest {
    public static void main(String[] args) {
        LongestAlternatingParityRun solution = new LongestAlternatingParityRun();
        int[][] inputs = {
                {2, 5, 8, 3, 6}, {2, 4, 7, 10, 12}, {1, 3, 5},
                {0, 1, 2, 4, 5, 6, 7}, {8}, {0}, {1},
                {2, 4, 6}, {2, 3}, {3, 2}, {2, 2}, {3, 3},
                {2, 3, 4, 4}, {2, 3, 4, 4, 5},
                {2, 2, 3, 4, 5}, {2, 3, 4, 6, 7, 8, 9, 10, 12},
                {1_000_000_000, 999_999_999, 0},
                {0, 1_000_000_000},
                new int[100_000], new int[100_000], new int[100_000]
        };
        int[] expected = {5, 3, 1, 4, 1, 1, 1, 1, 2, 2, 1, 1,
                3, 3, 4, 5, 3, 1, 1, 100_000, 99_999};
        for (int i = 0; i < 100_000; i++) {
            inputs[19][i] = i % 2;
            inputs[20][i] = i % 2;
        }
        inputs[20][99_999] = 0;
        int failures = 0;
        for (int i = 0; i < inputs.length; i++) {
            String label = "Case " + (i + 1) + " "
                    + (inputs[i].length <= 10 ? Arrays.toString(inputs[i])
                    : "(length " + inputs[i].length + ")");
            try {
                int actual = solution.longestAlternatingParityRun(inputs[i].clone());
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
