package solutions;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
  
  /* This solution is accepted */
  /* This solution has n^2logn complexity. However, it avoids many duplicates:
   * such as: 
   *     first element is positive; 
   *     sum of first two element is positive;
   *     same first element;
   *     same second element;
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
    int[] input = { -3, -3, -2, -1, -1, 0, 0, 0, 1, 2, 3, 4 };
    int[] sorted = { -4, -1, -1, 0, 1, 2 };
    System.out.println(binarysearch(sorted, 3, sorted.length - 1, 2));
    System.out.println(threeSum(input).toString());
  }
}
