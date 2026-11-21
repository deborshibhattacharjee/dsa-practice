package dsa.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of its longest contiguous
 * segment that is entirely strictly increasing or strictly decreasing.
 * Elements cannot be skipped, equal neighbors break a segment, and a single
 * element counts as length 1.
 * Input: int[] nums. Output: the longest valid length as an int.
 * Constraints: length 1 to 100,000; values -1,000,000,000 to 1,000,000,000.
 * Target: O(N) time and O(1) auxiliary space.
 * Examples: [1, 4, 3, 2] -> 3; [5, 2, 3, 4] -> 3; [2, 2, 1] -> 2; [7] -> 1.
 */
public class LongestMonotonicSegmentTest {
    private record TestCase(int[] input, int expected) {}

    public static void main(String[] args) {
        LongestMonotonicSegment solution = new LongestMonotonicSegment();
        int[] increasing = new int[100_000];
        for (int i = 0; i < increasing.length; i++) {
            increasing[i] = i;
        }

        TestCase[] cases = {
                new TestCase(new int[]{1, 4, 3, 2}, 3),
                new TestCase(new int[]{5, 2, 3, 4}, 3),
                new TestCase(new int[]{2, 2, 1}, 2),
                new TestCase(new int[]{7}, 1),
                new TestCase(new int[]{4, 3, 3, 2}, 2),
                new TestCase(new int[]{1, 3, 3, 3, 2}, 2),
                new TestCase(new int[]{4, 4, 4}, 1),
                new TestCase(new int[]{2, 1}, 2),
                new TestCase(new int[]{1, 2}, 2),
                new TestCase(new int[]{2, 2}, 1),
                new TestCase(new int[]{5, 4, 3, 2, 2, 3}, 4),
                new TestCase(new int[]{-1_000_000_000, 0, 1_000_000_000}, 3),
                new TestCase(new int[]{2, 5, 1, 4, 0}, 2),
                new TestCase(increasing, 100_000)
        };

        int failures = 0;
        for (TestCase test : cases) {
            int[] input = test.input();
            String label = input.length <= 10 ? Arrays.toString(input)
                    : "array of length " + input.length;
            try {
                int actual = solution.longestMonotonicSegment(input);
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
