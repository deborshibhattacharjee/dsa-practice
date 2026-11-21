package interviews.epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /*
     * Group words into anagrams. Two words are anagrams if they contain the
     * same letters with the same counts. Keep every occurrence of each word.
     *
     * Input: a String[] words containing 1 to 10,000 strings. Each string
     * contains 0 to 100 lowercase English letters.
     * Output: a List<List<String>> containing the groups. Groups and words
     * within each group may appear in any order.
     *
     * Examples (one valid output each):
     * ["eat", "tea", "tan", "ate", "nat", "bat"]
     *   -> [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
     * ["ab", "aab", "ba", "aba"] -> [["ab", "ba"], ["aab", "aba"]]
     * ["", "", "a"] -> [["", ""], ["a"]]
     */
    public static List<List<String>> groupAnagrams(String[] words) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(String word:words){
            char ch[] = word.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);

            hashMap.computeIfAbsent(sortedString, k-> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(hashMap.values());
    }
}
