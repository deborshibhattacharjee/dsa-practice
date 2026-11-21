package interviews.epam;

public class LongestSubstringWithoutRepeatingCharactersTest {
    /*
     * Given a Java String of 0 to 100,000 printable ASCII characters, return
     * the length of the longest contiguous substring with distinct characters.
     * The output is an int, and the empty string returns 0.
     * Examples: "abcabcbb" -> 3, "bbbbb" -> 1, "abba" -> 2, "" -> 0.
     */
    private record TestCase(String name, String input, int expected) {}

    public static void main(String[] args) {
        TestCase[] cases = {
                new TestCase("empty string", "", 0),
                new TestCase("single character", "a", 1),
                new TestCase("all distinct", "abcde", 5),
                new TestCase("all identical", "bbbbb", 1),
                new TestCase("repeating groups", "abcabcbb", 3),
                new TestCase("duplicate inside the window", "abba", 2),
                new TestCase("longest window at the end", "dvdf", 3),
                new TestCase("space, punctuation, and case", "a A!a", 4),
                new TestCase("maximum input length", "ab".repeat(50_000), 2)
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                int actual = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(test.input());
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
