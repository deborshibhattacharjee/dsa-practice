package dsa.arrays;

/**
 * Longest Strictly Monotonic Segment
 *
 * Given an integer array nums, return the length of the longest contiguous
 * segment that is entirely strictly increasing or entirely strictly decreasing.
 * Elements cannot be skipped. Equal neighbors break either kind of segment.
 * A single element counts as a valid segment of length 1.
 *
 * Input: int[] nums
 * Output: the longest valid length as an int
 *
 * Constraints:
 * - 1 <= nums.length <= 100,000
 * - -1,000,000,000 <= nums[i] <= 1,000,000,000
 * - Target: O(N) time and O(1) auxiliary space
 *
 * Examples:
 * - [1, 4, 3, 2] -> 3 (segment [4, 3, 2])
 * - [5, 2, 3, 4] -> 3 (segment [2, 3, 4])
 * - [2, 2, 1] -> 2 (segment [2, 1])
 * - [7] -> 1
 */
public class LongestMonotonicSegment {
    public int longestMonotonicSegment(int[] nums) {
        int count = 1;
        int maxCount = 1;
        int prevDirection = 0;

        for (int i = 1; i < nums.length; i++) {
            int currDirection = Integer.compare(nums[i], nums[i - 1]);
            if (currDirection == 0) {
                count = 1;
            } else if (currDirection == prevDirection) {
                count++;
            } else {
                count = 2;
            }

            maxCount = Math.max(maxCount, count);
            prevDirection = currDirection;
        }

        return maxCount;
    }
}
