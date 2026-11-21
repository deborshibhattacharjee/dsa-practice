package interviews.epam;

import java.util.Optional;

public class FirstNonRepeatingCharacterTest {
    /*
     * Given a String of 0 to 100,000 lowercase English letters, use Streams
     * to find the earliest character occurring exactly once in the string.
     * Return an Optional<Character>, empty if there is no qualifying letter.
     * Examples: "swiss" -> 'w', "zabac" -> 'z', "aabb" -> empty, "" -> empty.
     */
    private record TestCase(String name, String input, Optional<Character> expected) {}

    public static void main(String[] args) {
        TestCase[] cases = {
                new TestCase("repeated first letter", "swiss", Optional.of('w')),
                new TestCase("original order", "zabac", Optional.of('z')),
                new TestCase("all repeated", "aabb", Optional.empty()),
                new TestCase("empty string", "", Optional.empty()),
                new TestCase("single letter", "x", Optional.of('x')),
                new TestCase("all distinct", "zyx", Optional.of('z')),
                new TestCase("full alphabet", "zyxwvutsrqponmlkjihgfedcba", Optional.of('z')),
                new TestCase("maximum length, unique letter last", "a".repeat(99_999) + "b", Optional.of('b'))
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                Optional<Character> actual = FirstNonRepeatingCharacter.firstNonRepeatingCharacter(test.input());
                if (test.expected().equals(actual)) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    System.out.printf("FAIL %s: expected %s, got %s%n", test.name(), test.expected(), actual);
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
