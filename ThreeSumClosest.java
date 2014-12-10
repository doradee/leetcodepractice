package solutions;

import java.util.Arrays;

public class ThreeSumClosest {
  
  /*
   * Given an array S of n integers, find three integers in S such that the sum
   * is closest to a given number, target. Return the sum of the three integers.
   * You may assume that each input would have exactly one solution. For
   * example, given array S = {-1 2 1 -4}, and target = 1. The sum that is
   * closest to the target is 2. (-1 + 2 + 1 = 2).
   */
  
  /* This solution is inspired by 九章算法 */
  public static int threeSumClosest(int[] num, int target) {
    int closest = Integer.MAX_VALUE / 2;
    if (num == null || num.length < 3) {
      return closest;
    }
    Arrays.sort(num);
    for (int i = 0; i < num.length - 2; i++) {
      if (i != 0 && num[i] == num[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = num.length - 1;
      while (left < right) {
        int sum = num[i] + num[left] + num[right];
        if (sum == target) {
          return sum;
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
        closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum
            : closest;
      }
    }
    return closest;
  }
}
