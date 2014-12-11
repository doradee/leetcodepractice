package solutions;

/*
 * Say you have an array for which the ith element is the price of a given stock
 *  on day i.Design an algorithm to find the maximum profit. You may complete 
 *  as many transactions as you like (ie, buy one and sell one share of 
 *  the stock multiple times). However, you may not engage in multiple 
 *  transactions at the same time (ie, you must sell the stock before 
 *  you buy again).
 */
public class BestTimeToBuyAndSellStockII {
  
  /*
   * idea: compare next price with current one. If it is higher, I can make
   * profit by sell next day or buy today. If not, no profit can be earned.
   * Inspired by 9z.
   */
  public static int maxProfit(int[] prices) {
    int profit = 0;
    if (prices == null || prices.length <= 1) {
      return profit;
    }
    for (int i = 0; i < prices.length - 1; i++) {
      int diff = prices[i + 1] - prices[i];
      profit = diff > 0 ? profit + diff : profit;
    }
    return profit;
  }
}
