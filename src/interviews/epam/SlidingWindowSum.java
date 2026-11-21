package interviews.epam;

public class SlidingWindowSum {
    /*
     * Given an integer array nums and an integer k, compute the sum of every
     * contiguous group of exactly k elements.
     *
     * Input: an int[] nums of length n and an int k.
     * Output: a long[] of length n - k + 1 with sums in left-to-right order.
     * Constraints: 1 <= k <= n <= 100,000. Elements may be any Java int.
     *
     * Examples:
     * nums = [2, -1, 3, 4, -2], k = 3 -> [4, 6, 5]
     * nums = [5, -3, 2], k = 1 -> [5, -3, 2]
     * nums = [2147483647, 1], k = 2 -> [2147483648]
     */
    public static long[] windowSums(int[] nums, int k) {
        int start =0 , i=0, sum=0, index=0;
        long ans[] = new long[nums.length];
        while(i<nums.length){
            sum+=nums[i];
            while(i-start+1>=k){
                ans[index++]=sum;
                sum-=nums[start++];
            }
            i++;
        }
        return ans;
    }
}
