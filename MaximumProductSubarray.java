package solutions;

/*
 Find the contiguous subarray within an array (containing at least one number) 
 which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 */

/* Leetcode solution:
 * https://oj.leetcode.com/problems/maximum-product-subarray/solution/
 */
public class MaximumProductSubarray {
  
  /* Inspired by the discussion. Useful application for iterating an array */
  public static int maxProduct(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int res = A[0];
    int max = A[0];
    int min = A[0];
    for (int i = 1; i < A.length; i++) {
      int temp = max;
      max = Math.max(Math.max(temp * A[i], min * A[i]), A[i]);
      min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
      if (max > res) {
        res = max;
      }
    }
    return res;
  }
}
