package interviews.epam;

public class MaxConsecutiveOnesIII {
    /*
     * Given a binary array nums, return the length of the longest contiguous
     * segment of ones that can be created by flipping at most k zeros to ones.
     *
     * Input: an int[] nums of length 1 to 100,000 containing only 0 and 1,
     * and an int k with 0 <= k <= nums.length.
     * Output: an int giving the maximum segment length, or 0 if no segment
     * of ones can be created.
     *
     * Examples:
     * [1, 0, 1, 1, 0, 1], k = 1 -> 4
     * [1, 1, 0, 1], k = 0 -> 2
     * [0, 0, 0], k = 2 -> 2
     * [0, 0], k = 0 -> 0
     */
    public static int longestOnes(int[] nums, int k) {
        int zeroCount=0, i=0, maxLength=0, start=0;
        while(i<nums.length){
            if(nums[i]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[start++]==0){
                    zeroCount--;
                }
            }
            maxLength = Math.max(maxLength, i-start+1);
            i++;
        }
        return maxLength;
    }
}
