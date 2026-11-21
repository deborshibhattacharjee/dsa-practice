package dsa.arrays;

/**
 * Longest Strictly Increasing Contiguous Run
 *
 * Given an integer array nums, return the length of its longest contiguous
 * segment in which each element is strictly greater than the previous one.
 * Elements must be adjacent; you cannot skip elements. A single element
 * counts as a run of length 1.
 *
 * Input: int[] nums
 * Output: the longest run's length as an int
 *
 * Constraints:
 * - 1 <= nums.length <= 100,000
 * - -1,000,000,000 <= nums[i] <= 1,000,000,000
 * - Target: O(N) time and O(1) auxiliary space
 *
 * Examples:
 * - [1, 3, 5, 4, 7] -> 3 (segment [1, 3, 5])
 * - [2, 2, 2] -> 1 (equal elements do not strictly increase)
 * - [5] -> 1
 * - [5, 4, 1, 2, 3, 4] -> 4 (segment [1, 2, 3, 4])
 */
public class LongestIncreasingRun {
    public int longestIncreasingRun(int[] nums) {
        int maxCount=Integer.MIN_VALUE, count=1, prev=nums[0];
        for (int i=1; i<nums.length; i++){
            if(nums[i]>prev){
                count++;
            } else {
                if(maxCount<count){
                    maxCount = count;
                }
                count=1;
            }
            prev = nums[i];
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
