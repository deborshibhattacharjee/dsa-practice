package dsa.arrays;

import java.util.Arrays;

/**
 * Count Turns: Given int[] nums, return the number of elements strictly higher
 * than both immediate neighbors or strictly lower than both. The first and last
 * elements cannot count, and equality with either neighbor excludes an element.
 * Input: int[] nums. Output: the turn count as an int.
 * Constraints: length 1 to 100,000; values -1,000,000,000 to 1,000,000,000.
 * Target: O(N) time and O(1) auxiliary space.
 * Examples: [2, 5, 3, 6, 4] -> 3; [1, 2, 3, 4] -> 0;
 * [2, 5, 5, 3] -> 0; [7] -> 0.
 */
public class CountTurnsTest {
    public static void main(String[] args) {
        CountTurns solution = new CountTurns();
        int[] alternating = new int[100_000];
        for (int i = 0; i < alternating.length; i++) {
            alternating[i] = i % 2;
        }

        int[][] inputs = {
                {2, 5, 3, 6, 4}, {1, 2, 3, 4}, {2, 5, 5, 3}, {7},
                {1, 2}, {1, 3, 2}, {3, 1, 2}, {1, 2, 3, 2},
                {4, 3, 2, 1}, {2, 2, 2}, {-3, -1, -3, -3, -1},
                {-1_000_000_000, 1_000_000_000, -1_000_000_000}, alternating
        };
        int[] expected = {3, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 99_998};

        int failures = 0;
        for (int i = 0; i < inputs.length; i++) {
            int[] input = inputs[i];
            String label = input.length <= 10 ? Arrays.toString(input)
                    : "array of length " + input.length;
            int actual = solution.countTurns(input);
            if (actual != expected[i]) {
                failures++;
                System.out.println("FAIL " + label + ": expected " + expected[i] + ", got " + actual);
            }
        }
        System.out.println((inputs.length - failures) + "/" + inputs.length + " passed");
        if (failures > 0) {
            throw new AssertionError(failures + " test case(s) failed");
        }
    }
}
