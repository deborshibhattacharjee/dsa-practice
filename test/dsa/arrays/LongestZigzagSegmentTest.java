package dsa.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of its longest contiguous
 * segment whose comparisons strictly alternate between increasing and
 * decreasing. Either direction may come first. Equal neighbors break the
 * segment. One element is valid, as is any unequal adjacent pair.
 * Input: int[] nums. Output: the longest valid length as an int.
 * Constraints: length 1 to 100,000; values -1,000,000,000 to 1,000,000,000.
 * Target: O(N) time and O(1) auxiliary space.
 * Examples: [1, 5, 2, 6, 3] -> 5; [1, 2, 3, 2, 4] -> 4;
 * [4, 4, 4] -> 1; [7] -> 1; [9, 6, 3] -> 2.
 */
public class LongestZigzagSegmentTest {
    private record TestCase(int[] input, int expected) {}

    public static void main(String[] args) {
        LongestZigzagSegment solution = new LongestZigzagSegment();
        int[] alternating = new int[100_000];
        for (int i = 0; i < alternating.length; i++) {
            alternating[i] = i % 2;
        }

        TestCase[] cases = {
                new TestCase(new int[]{1, 5, 2, 6, 3}, 5),
                new TestCase(new int[]{1, 2, 3, 2, 4}, 4),
                new TestCase(new int[]{4, 4, 4}, 1),
                new TestCase(new int[]{7}, 1),
                new TestCase(new int[]{9, 6, 3}, 2),
                new TestCase(new int[]{3, 3}, 1),
                new TestCase(new int[]{3, 1}, 2),
                new TestCase(new int[]{1, 3}, 2),
                new TestCase(new int[]{3, 3, 1, 4}, 3),
                new TestCase(new int[]{4, 2, 2, 7, 3, 8, 9}, 4),
                new TestCase(new int[]{5, 1, 4, 1, 1, 2}, 4),
                new TestCase(new int[]{5, 4, 3, 4, 2}, 4),
                new TestCase(new int[]{-1_000_000_000, 1_000_000_000, -1_000_000_000}, 3),
                new TestCase(alternating, 100_000)
        };

        int failures = 0;
        for (TestCase test : cases) {
            int[] input = test.input();
            String label = input.length <= 10 ? Arrays.toString(input)
                    : "array of length " + input.length;
            try {
                int actual = solution.longestZigzagSegment(input);
                if (actual != test.expected()) {
                    failures++;
                    System.out.println("FAIL " + label + ": expected " + test.expected() + ", got " + actual);
                }
            } catch (RuntimeException exception) {
                failures++;
                System.out.println("FAIL " + label + ": expected " + test.expected() + ", threw " + exception);
            }
        }
        System.out.println((cases.length - failures) + "/" + cases.length + " passed");
        if (failures > 0) {
            throw new AssertionError(failures + " test case(s) failed");
        }
    }
}
