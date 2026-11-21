package interviews.epam;

public class MaxConsecutiveOnesIIITest {
    /*
     * Given a binary int[] of length 1 to 100,000 and 0 <= k <= its length,
     * return the maximum contiguous run length attainable by flipping at
     * most k zeros. Return 0 if no ones can be obtained.
     * Examples: [1, 0, 1, 1, 0, 1], k = 1 -> 4;
     * [1, 1, 0, 1], k = 0 -> 2; [0, 0, 0], k = 2 -> 2.
     */
    private record TestCase(String name, int[] nums, int k, int expected) {}

    public static void main(String[] args) {
        TestCase[] cases = {
                new TestCase("mixed array", new int[]{1, 0, 1, 1, 0, 1}, 1, 4),
                new TestCase("exact budget is valid", new int[]{1, 0, 1}, 1, 3),
                new TestCase("shrink past a one and a zero", new int[]{1, 0, 1, 0, 1, 1}, 1, 4),
                new TestCase("no flips allowed", new int[]{1, 1, 0, 1}, 0, 2),
                new TestCase("all zeros with flips", new int[]{0, 0, 0}, 2, 2),
                new TestCase("all zeros without flips", new int[]{0, 0}, 0, 0),
                new TestCase("all ones with unused budget", new int[]{1, 1, 1}, 2, 3),
                new TestCase("single zero with a flip", new int[]{0}, 1, 1),
                new TestCase("maximum input size and budget", new int[100_000], 100_000, 100_000)
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                int actual = MaxConsecutiveOnesIII.longestOnes(test.nums(), test.k());
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
