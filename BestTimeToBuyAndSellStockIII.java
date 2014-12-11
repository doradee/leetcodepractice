package solutions;

/*
 * Say you have an array for which the ith element is the price of a given stock 
 * on day i.Design an algorithm to find the maximum profit. You may complete at
 *  most two transactions. Note: You may not engage in multiple transactions 
 *  at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
  
  /* inspired by discussion and 9z */
  /*
   * the idea is DP + partitioning. Scan from left to right to record max profit
   * from 0 to i, then scan from right to left to record max profit from i to
   * end. thus, the max profit of two transaction will be max the sum of these
   * two.
   */
  public static int maxProfit(int[] prices) {
    int profit = 0;
    if (prices == null || prices.length <= 1) {
      return profit;
    }
    int[] left = new int[prices.length];
    int[] right = new int[prices.length];
    /* scan from left to right */
    left[0] = 0;
    int min = prices[0];
    for (int i = 1; i < prices.length; i++) {
      min = Math.min(min, prices[i]);
      left[i] = Math.max(left[i-1], prices[i] - min);
    }
    
    /*scan from right to left */
    right[prices.length - 1] = 0;
    int max = prices[prices.length - 1];
    for (int i = prices.length - 2; i >=0; i--) {
      max = Math.max(max, prices[i]);
      right[i] = Math.max(right[i+1], max - prices[i]);
    }
    for (int i = 0; i < prices.length; i++) {
      profit = Math.max(profit, left[i] + right[i]);
    }
    
    return profit;
  }
}
