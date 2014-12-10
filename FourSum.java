package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
  
  /*
   * Given an array S of n integers, are there elements a, b, c, and d in S such
   * that a + b + c + d = target? Find all unique quadruplets in the array which
   * gives the sum of target. Note: Elements in a quadruplet (a,b,c,d) must be
   * in non-descending order. (ie, a ≤ b ≤ c ≤ d) The solution set must not
   * contain duplicate quadruplets. For example, given array S = {1 0 -1 0 -2
   * 2}, and target = 0. A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0,
   * 0, 2)
   */
  
  /* The first attempt got TLE error */
  public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(num);
    for (int i = 0; i < num.length - 3 && num[i] <= target; i++) {
      if (i >= 1 && (num[i] == num[i - 1])) {
        continue;
      }
      for (int j = i + 1; j < num.length - 2 && (num[i] + num[j] <= target); j++) {
        if (j >= i + 2 && (num[j] == num[j - 1])) {
          continue;
        }
        for (int k = j + 1; k < num.length - 1
            && (num[i] + num[j] + num[k] <= target); k++) {
          if (k >= j + 2 && (num[k] == num[k - 1])) {
            continue;
          }
          int token = target - (num[i] + num[j] + num[k]);
          if (binarysearch(num, j + 1, num.length - 1, token)) {
            ArrayList<Integer> candidate = new ArrayList<Integer>();
            candidate.add(num[i]);
            candidate.add(num[j]);
            candidate.add(num[k]);
            candidate.add(token);
            if (!result.contains(candidate)) {
              result.add(candidate);
            }
          }
        }
      }
    }
    return result;
  }
  
  static boolean binarysearch(int[] num, int start, int end, int token) {
    if (start > end) {
      return false;
    }
    int mid = start + (end - start) / 2;
    if (num[mid] == token) {
      return true;
    } else if (num[mid] > token) {
      return binarysearch(num, start, mid - 1, token);
    } else {
      return binarysearch(num, mid + 1, end, token);
    }
  }
}
