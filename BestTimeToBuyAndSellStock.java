package solutions;

/*
 * Say you have an array for which the ith element is the price of a given stock 
 * on day i.  If you were only permitted to complete at most one transaction
 *  (ie, buy one and sell one share of the stock), design an algorithm to find 
 *  the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
  
  /* o(n) solution. Inspired by 9Z */
  public static int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int profit = 0;
    if (prices == null || prices.length <= 1) {
      return profit;
    }
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      }
      if (prices[i] - min > profit) {
        profit = prices[i] - min;
      }
    }
    return profit;
  }
}
