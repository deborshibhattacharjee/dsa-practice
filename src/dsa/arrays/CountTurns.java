package dsa.arrays;

/**
 * Count Turns
 *
 * Given an integer array nums, count the elements that are strictly higher
 * than both immediate neighbors or strictly lower than both immediate neighbors.
 * The first and last elements do not count. An element equal to either neighbor
 * does not count.
 *
 * Input: int[] nums
 * Output: the number of turns as an int
 *
 * Constraints:
 * - 1 <= nums.length <= 100,000
 * - -1,000,000,000 <= nums[i] <= 1,000,000,000
 * - Target: O(N) time and O(1) auxiliary space
 *
 * Examples:
 * - [2, 5, 3, 6, 4] -> 3 (5 and 6 are peaks, and 3 is a valley)
 * - [1, 2, 3, 4] -> 0
 * - [2, 5, 5, 3] -> 0
 * - [7] -> 0
 */
public class CountTurns {
    public int countTurns(int[] nums) {
       int count=0;
       for(int i=1; i<=nums.length-2; i++){
           if ((nums[i]<nums[i-1] && nums[i]<nums[i+1]) || (nums[i]>nums[i-1] && nums[i]>nums[i+1])){
               count++;
           }
       }
       return count;
    }
}
