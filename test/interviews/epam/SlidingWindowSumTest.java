package interviews.epam;

import java.util.Arrays;

public class SlidingWindowSumTest {
    private record TestCase(String name, int[] input, int k, long[] expected) {}

    public static void main(String[] args) {
        int[] largestInput = new int[100_000];
        Arrays.fill(largestInput, Integer.MAX_VALUE);
        TestCase[] cases = {
                new TestCase("overlapping windows", new int[]{2, -1, 3, 4, -2}, 3, new long[]{4, 6, 5}),
                new TestCase("size one", new int[]{5, -3, 2}, 1, new long[]{5, -3, 2}),
                new TestCase("single element", new int[]{Integer.MIN_VALUE}, 1, new long[]{Integer.MIN_VALUE}),
                new TestCase("whole array", new int[]{2, 3, 4}, 3, new long[]{9}),
                new TestCase("zero sums", new int[]{0, 0, 0}, 2, new long[]{0, 0}),
                new TestCase("above int range", new int[]{Integer.MAX_VALUE, 1}, 2, new long[]{2_147_483_648L}),
                new TestCase("below int range", new int[]{Integer.MIN_VALUE, -1, 2}, 2, new long[]{-2_147_483_649L, 1}),
                new TestCase("maximum input size", largestInput, largestInput.length, new long[]{214_748_364_700_000L})
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                long[] actual = SlidingWindowSum.windowSums(test.input(), test.k());
                if (Arrays.equals(test.expected(), actual)) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    long[] preview = actual == null ? null : Arrays.copyOf(actual, Math.min(actual.length, 8));
                    System.out.printf("FAIL %s: expected %s, got %s (actual length %s)%n",
                            test.name(), Arrays.toString(test.expected()), Arrays.toString(preview),
                            actual == null ? "null" : actual.length);
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
