package interviews.epam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatingCharacter {
    /*
     * Use the Java Stream API to find the first character that occurs exactly
     * once in the entire string. First means earliest in the original string.
     *
     * Input: a String s with 0 to 100,000 lowercase English letters.
     * Output: an Optional<Character> containing the first non-repeating
     * character, or Optional.empty() if none exists.
     *
     * Examples: "swiss" -> 'w', "zabac" -> 'z', "aabb" -> empty, "" -> empty.
     */
    public static Optional<Character> firstNonRepeatingCharacter(String s) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }
        return hashMap.entrySet().stream()
                .filter(entry-> entry.getValue()==1).map(Map.Entry::getKey).findFirst();
    }
}
