package dsa.arrays;

/**
 * Longest Zigzag Contiguous Segment
 *
 * Given an integer array nums, return the length of the longest contiguous
 * segment where consecutive comparisons strictly alternate between increasing
 * and decreasing. Either direction may come first. Equality breaks the zigzag.
 * A single element is valid, and two unequal adjacent elements form a valid
 * segment of length 2. Elements cannot be skipped.
 *
 * Input: int[] nums
 * Output: the longest valid segment's length as an int
 *
 * Constraints:
 * - 1 <= nums.length <= 100,000
 * - -1,000,000,000 <= nums[i] <= 1,000,000,000
 * - Target: O(N) time and O(1) auxiliary space
 *
 * Examples:
 * - [1, 5, 2, 6, 3] -> 5 (the whole array zigzags)
 * - [1, 2, 3, 2, 4] -> 4 (segment [2, 3, 2, 4])
 * - [4, 4, 4] -> 1 (equality breaks the zigzag)
 * - [7] -> 1 (a single element is valid)
 * - [9, 6, 3] -> 2 (either adjacent pair is valid)
 */
public class LongestZigzagSegment {
    public int longestZigzagSegment(int[] nums) {
        int prevDirection=0, count=1,maxCount=1;
        for(int i=1; i<nums.length; i++){
            int currDirection = Integer.compare(nums[i], nums[i-1]);
            if(currDirection==0){
                count=1;
            } else if(currDirection==-prevDirection){
                count++;
            } else {
                count=2;
            }
            maxCount = Math.max(count, maxCount);
            prevDirection = currDirection;
        }
        return maxCount;
    }
}
