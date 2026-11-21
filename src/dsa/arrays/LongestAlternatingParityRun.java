package dsa.arrays;

/**
 * Longest Contiguous Run with Alternating Parity
 *
 * Given an integer array nums, return the length of its longest contiguous
 * segment in which every adjacent pair has different parity: one element
 * is even and the other is odd. Elements cannot be skipped.
 * A single element is a valid segment of length 1.
 *
 * Input: int[] nums
 * Output: the longest valid segment's length as an int
 *
 * Constraints:
 * - 1 <= nums.length <= 100,000
 * - 0 <= nums[i] <= 1,000,000,000
 * - Target: O(N) time and O(1) auxiliary space
 *
 * Examples:
 * - [2, 5, 8, 3, 6] -> 5 (the entire array alternates parity)
 * - [2, 4, 7, 10, 12] -> 3 (segment [4, 7, 10])
 * - [1, 3, 5] -> 1 (all elements are odd)
 * - [0, 1, 2, 4, 5, 6, 7] -> 4 (segment [4, 5, 6, 7])
 * - [8] -> 1
 */
public class LongestAlternatingParityRun {
    public int longestAlternatingParityRun(int[] nums) {
        int count=1, maxCount=Integer.MIN_VALUE, prev=nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]%2!=prev%2){
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            prev = nums[i];
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
