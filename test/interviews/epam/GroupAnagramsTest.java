package interviews.epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTest {
    /*
     * Group the words with identical letter counts, retaining every occurrence.
     * Input: a String[] of 1 to 10,000 words, each with 0 to 100 lowercase English letters.
     * Output: a List<List<String>>. Groups and their contents can appear in any order.
     * Examples: ["ab", "aab", "ba"] -> [["ab", "ba"], ["aab"]];
     * ["", "", "a"] -> [["", ""], ["a"]].
     */
    private record TestCase(String name, String[] input, List<List<String>> expected) {}

    public static void main(String[] args) {
        String maxWord = "a".repeat(99) + "b";
        String permutation = "b" + "a".repeat(99);
        String[] maxInput = new String[10_000];
        Arrays.fill(maxInput, maxWord);
        maxInput[maxInput.length - 1] = permutation;

        TestCase[] cases = {
                new TestCase("multiple groups", new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(List.of("eat", "tea", "ate"), List.of("tan", "nat"), List.of("bat"))),
                new TestCase("same letters with different counts", new String[]{"ab", "aab", "ba", "aba"},
                        List.of(List.of("ab", "ba"), List.of("aab", "aba"))),
                new TestCase("empty and nonempty words", new String[]{"", "", "a"},
                        List.of(List.of("", ""), List.of("a"))),
                new TestCase("repeated nonempty word", new String[]{"ab", "ab", "ba"},
                        List.of(List.of("ab", "ab", "ba"))),
                new TestCase("single empty word", new String[]{""}, List.of(List.of(""))),
                new TestCase("no anagrams", new String[]{"ab", "ac", "bc"},
                        List.of(List.of("ab"), List.of("ac"), List.of("bc"))),
                new TestCase("maximum input and word lengths", maxInput, List.of(List.of(maxInput)))
        };

        int failures = 0;
        for (TestCase test : cases) {
            try {
                List<List<String>> actual = GroupAnagrams.groupAnagrams(test.input().clone());
                if (actual != null && groupCounts(test.expected()).equals(groupCounts(actual))) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    System.out.println("FAIL " + test.name() + ": groups differ from expected");
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

    private static Map<List<String>, Integer> groupCounts(List<List<String>> groups) {
        Map<List<String>, Integer> counts = new HashMap<>();
        for (List<String> group : groups) {
            List<String> sortedGroup = new ArrayList<>(group);
            sortedGroup.sort(String::compareTo);
            counts.merge(sortedGroup, 1, Integer::sum);
        }
        return counts;
    }
}
