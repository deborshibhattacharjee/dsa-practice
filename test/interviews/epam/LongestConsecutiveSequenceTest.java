package interviews.epam;

import java.util.Arrays;

public class LongestConsecutiveSequenceTest {
    /*
     * Given an unsorted int[] of 0 to 100,000 values between -1,000,000,000
     * and 1,000,000,000, return the length of the longest consecutive
     * sequence in O(n) time. Duplicates count once, and empty input returns 0.
     * Examples: [100, 4, 200, 1, 3, 2] -> 4, [7, 7, 7] -> 1, [] -> 0.
     */
    private record TestCase(String name, int[] input, int expected) {}

    public static void main(String[] args) {
        int[] maximumInput = new int[100_000];
        Arrays.fill(maximumInput, 1);
        for (int i = 50_000; i < maximumInput.length; i++) {
            maximumInput[i] = i - 49_998;
        }
        TestCase[] cases = {
                new TestCase("unsorted values", new int[]{100, 4, 200, 1, 3, 2}, 4),
                new TestCase("duplicates and negative values", new int[]{2, 2, 0, -1, 1}, 4),
                new TestCase("repeated sequence start", new int[]{1, 1, 1, 2, 3}, 3),
                new TestCase("all identical", new int[]{7, 7, 7}, 1),
                new TestCase("empty input", new int[]{}, 0),
                new TestCase("value limits", new int[]{-1_000_000_000, -999_999_999, 1_000_000_000}, 2),
                new TestCase("no consecutive neighbors", new int[]{-5, 3, 9}, 1),
                new TestCase("maximum input with duplicate starts", maximumInput, 50_001)
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                int actual = LongestConsecutiveSequence.longestConsecutive(test.input());
                if (actual == test.expected()) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    System.out.printf("FAIL %s: expected %d, got %d%n", test.name(), test.expected(), actual);
                }
            } catch (RuntimeException exception) {
                failures++;
                System.out.println("FAIL " + test.name() + ": threw " + exception);
            }
        }
        System.out.println((cases.length - failures) + "/" + cases.length + " passed");
        if (failures > 0) {
            throw new AssertionError(failures + " test case(s) failed");
        }
    }
}
