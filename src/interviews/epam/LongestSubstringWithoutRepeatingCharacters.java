package interviews.epam;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * Given a string s, return the length of its longest contiguous substring
     * in which every character is distinct.
     *
     * Input: a Java String containing 0 to 100,000 printable ASCII characters.
     * Output: an int giving the maximum length. Return 0 for the empty string.
     *
     * Examples:
     * "abcabcbb" -> 3
     * "bbbbb" -> 1
     * "abba" -> 2
     * "" -> 0
     */
    public static int lengthOfLongestSubstring(String s) {
        int start=0, maxLength=0, i=0;
        HashSet<Character> set = new HashSet<>();

        while(i<s.length()){
            while (!set.add(s.charAt(i))){
                set.remove(s.charAt(start++));
            }
            maxLength = Math.max(maxLength, i-start+1);
            i++;
        }

        return maxLength;
    }
}
