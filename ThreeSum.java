package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
  
  /*
   * Given an array S of n integers, are there elements a, b, c in S such that a
   * + b + c = 0? Find all unique triplets in the array which gives the sum of
   * zero. Note: Elements in a triplet (a,b,c) must be in non-descending order.
   * (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets. For
   * example, given array S = {-1 0 1 2 -1 -4}, A solution set is: (-1, 0, 1)
   * (-1, -1, 2)
   */
  
  /* This solution is accepted */
  /*
   * This solution has n^2logn complexity. However, it avoids many duplicates:
   * such as: first element is positive; sum of first two element is positive;
   * same first element; same second element;
   */
  public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(num);
    for (int i = 0; i < num.length - 2 && num[i] <= 0; i++) {
      if (i >= 1 && (num[i] == num[i - 1])) {
        continue;
      }
      for (int j = i + 1; j < num.length - 1 && (num[i] + num[j] <= 0); j++) {
        // if s[j+1] to s[end] contains -(S[i] + s[j]) add, otherwise give up
        if (j >= i + 2 && (num[j] == num[j - 1])) {
          continue;
        }
        int token = -(num[i] + num[j]);
        if (binarysearch(num, j + 1, num.length - 1, token)) {
          ArrayList<Integer> candidate = new ArrayList<Integer>();
          candidate.add(num[i]);
          candidate.add(num[j]);
          candidate.add(token);
          if (!result.contains(candidate)) {
            result.add(candidate);
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
  
  public static void main(String[] args) {
    int[] input = { -3, 3, 0, 2, -1, -1, 0, 0, 0, -1, 2, 3, 4 };
    System.out.println(threeSum(input).toString());
  }
}
