package interviews.epam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class NthLongestStringTest {
    /*
     * Given up to 100,000 non-null strings of 0 to 100 lowercase English
     * letters and an int n, use Streams to return the string at 1-based rank
     * n by descending length. Preserve input order for ties and count
     * duplicates separately. Return Optional.empty() for invalid ranks.
     * Examples: ["pear", "fig", "kiwi", "banana"], 3 -> "kiwi";
     * ["cat", "cat", "ox"], 2 -> "cat"; ["a", "bb"], 3 -> empty.
     */
    private record TestCase(String name, List<String> words, int rank, Optional<String> expected) {}

    public static void main(String[] args) {
        String longestWord = "a".repeat(100);
        TestCase[] cases = new TestCase[]{
                new TestCase("first rank", List.of("a", "bbb", "cc"), 1, Optional.of("bbb")),
                new TestCase("ties keep input order", List.of("pear", "fig", "kiwi", "banana"), 3, Optional.of("kiwi")),
                new TestCase("duplicates count separately", List.of("cat", "cat", "ox"), 2, Optional.of("cat")),
                new TestCase("only word is empty", List.of(""), 1, Optional.of("")),
                new TestCase("rank exceeds size", List.of("a", "bb"), 3, Optional.empty()),
                new TestCase("rank zero", List.of("a", "bb"), 0, Optional.empty()),
                new TestCase("negative rank", List.of("a", "bb"), -1, Optional.empty()),
                new TestCase("empty list", List.of(), 1, Optional.empty()),
                new TestCase("last rank at maximum size", Collections.nCopies(100_000, longestWord),
                        100_000, Optional.of(longestWord))
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                Optional<String> actual = NthLongestString.nthLongestString(test.words(), test.rank());
                if (test.expected().equals(actual)) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    System.out.printf("FAIL %s: expected %s, got %s%n", test.name(), test.expected(), actual);
                }
            } catch (RuntimeException exception) {
                failures++;
                System.out.printf("FAIL %s: expected %s, threw %s%n", test.name(), test.expected(), exception);
            }
        }
        System.out.println((cases.length - failures) + "/" + cases.length + " passed");
        if (failures > 0) {
            throw new AssertionError(failures + " test case(s) failed");
        }
    }
}
