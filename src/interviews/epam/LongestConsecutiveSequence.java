package interviews.epam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    /*
     * Given an unsorted integer array, return the length of the longest
     * sequence of consecutive values. Values may appear anywhere in the
     * array, and duplicates count once.
     *
     * Input: an int[] nums of length 0 to 100,000, with values from
     * -1,000,000,000 to 1,000,000,000 inclusive.
     * Output: an int giving the longest sequence length, or 0 if empty.
     * Time requirement: O(n), where n is the array length.
     *
     * Examples:
     * [100, 4, 200, 1, 3, 2] -> 4
     * [2, 2, 0, -1, 1] -> 4
     * [7, 7, 7] -> 1
     * [] -> 0
     */
    public static int longestConsecutive(int[] nums) {
        int maxCount=0;
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int num : set){
            if(!set.contains(num-1)) {
                int curr = num;
                int count=1;
                while (set.contains(curr+1)){
                    curr = curr+1;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
