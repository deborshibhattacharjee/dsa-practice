package interviews.epam;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NthLongestString {
    /*
     * Use the Java Stream API to return the string at 1-based rank n in
     * descending order of length. Equal-length strings keep their original
     * relative order. Each occurrence gets a rank, including duplicates.
     *
     * Input: a List<String> words of 0 to 100,000 non-null strings, each
     * containing 0 to 100 lowercase English letters, and an int n.
     * Output: an Optional<String> with the requested string, or
     * Optional.empty() if n < 1 or n > words.size().
     *
     * Examples:
     * ["pear", "fig", "kiwi", "banana"], n = 3 -> Optional.of("kiwi")
     * ["cat", "cat", "ox"], n = 2 -> Optional.of("cat")
     * [""], n = 1 -> Optional.of("")
     * ["a", "bb"], n = 3 -> Optional.empty()
     */
    public static Optional<String> nthLongestString(List<String> words, int n) {
        if(n>words.size() || n<=0){
            return Optional.empty();
        }
        return words.stream().sorted(Comparator.comparing(String::length).reversed()).skip(n-1).findFirst();
    }
}
