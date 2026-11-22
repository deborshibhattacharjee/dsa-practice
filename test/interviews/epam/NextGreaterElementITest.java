package interviews.epam;

import java.util.Arrays;

public class NextGreaterElementITest {
    /*
     * Given distinct int arrays nums1 and nums2 with every nums1 value in
     * nums2, return the first strictly greater value to the right in nums2
     * for each query, or -1 if absent, in nums1 order.
     * Constraints: 1 <= nums1.length <= nums2.length <= 1,000; values 0 to 10,000.
     * Example: [4, 1, 2] and [1, 3, 4, 2] -> [-1, 3, -1].
     */
    private record TestCase(String name, int[] queries, int[] values, int[] expected) {}

    public static void main(String[] args) {
        int[] maximumInput = new int[1_000];
        Arrays.setAll(maximumInput, i -> i);
        TestCase[] cases = {
                new TestCase("query order and missing answers", new int[]{4, 1, 2},
                        new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                new TestCase("single value", new int[]{0}, new int[]{0}, new int[]{-1}),
                new TestCase("nearest greater, not largest", new int[]{2},
                        new int[]{2, 3, 5}, new int[]{3}),
                new TestCase("several smaller candidates", new int[]{5, 4, 1, 2},
                        new int[]{5, 1, 2, 4, 6}, new int[]{6, 6, 2, 4}),
                new TestCase("no greater values", new int[]{2, 3, 1},
                        new int[]{3, 2, 1}, new int[]{-1, -1, -1}),
                new TestCase("value boundaries", new int[]{10_000, 0},
                        new int[]{0, 10_000}, new int[]{-1, 10_000}),
                new TestCase("maximum input size", new int[]{998, 999, 0},
                        maximumInput, new int[]{999, -1, 1})
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                int[] actual = NextGreaterElementI.nextGreaterElement(test.queries(), test.values());
                if (Arrays.equals(test.expected(), actual)) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    System.out.printf("FAIL %s: expected %s, got %s%n",
                            test.name(), Arrays.toString(test.expected()), Arrays.toString(actual));
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
