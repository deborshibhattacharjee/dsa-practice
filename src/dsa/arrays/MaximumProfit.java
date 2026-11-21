package dsa.arrays;

/**
 * Maximum Profit from One Buy and One Sell
 *
 * Given an integer array prices, where prices[i] is a stock's price on day i,
 * return the maximum profit from at most one purchase followed by one sale
 * on a strictly later day. Return 0 if no profitable transaction exists.
 *
 * Input: int[] prices
 * Output: maximum profit as an int
 *
 * Constraints:
 * - 1 <= prices.length <= 100,000
 * - 0 <= prices[i] <= 1,000,000,000
 * - Target: O(N) time and O(1) auxiliary space
 *
 * Examples:
 * - [7, 1, 5, 3, 6, 4] -> 5 (buy at 1, then sell at 6)
 * - [7, 6, 4, 3, 1] -> 0 (no profitable transaction)
 * - [2, 4, 1] -> 2 (buy at 2, then sell at 4)
 * - [5] -> 0 (no later day to sell)
 */
public class MaximumProfit {
    public int maxProfit(int[] prices) {
        int maxProfit=0, smallest=prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i]>smallest){
                maxProfit = Math.max(maxProfit, prices[i]-smallest);
            } else {
                smallest = prices[i];
            }
        }
        return maxProfit;
    }
}
