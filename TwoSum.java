package solutions;

import java.util.Arrays;
import java.util.HashMap;

/*
 Given an array of integers, find two numbers such that they add up to a specific
 target number.
 The function twoSum should return indices of the two numbers such that they 
 add up to the target, where index1 must be less than index2. 
 Please note that your returned answers (both index1 and index2) 
 are not zero-based.
 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSum {
  /* a better solution learned from 9Z */
  public static int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      return null;
    }
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      map.put(numbers[i], i + 1);
    }
    for (int i = 0; i < numbers.length - 1; i++) {
      if (map.containsKey(target - numbers[i])) {
        if (i == map.get(target - numbers[i]) - 1){
          continue;
        } else {
          res[0] = i + 1;
          res[1] = map.get(target - numbers[i]);
          return res;
        }
      }
    }
    return res;
  }
  
  /* Accepted solution. Complexity is o(nlgn) which is better than o(n^2) */
  public static int[] twoSum_Di(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      return null;
    }
    int[] res = new int[2];
    int[] val = new int[2];
    int[] copy = numbers.clone();
    boolean find = false;
    Arrays.sort(copy);
    for (int i = 0; i < copy.length - 1 && copy[i] <= target; i++) {
      if (binarySearch(target - copy[i], i + 1, copy.length - 1, copy)) {
        val[0] = copy[i];
        val[1] = target - copy[i];
        find = true;
        break;
      }
    }
    if (find) {
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == val[0]) {
          if (res[0] == 0) {
            res[0] = i + 1;
          } else {
            res[1] = i + 1;
          }
          continue;
        }
      }
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == val[1]) {
          if (res[0] == 0) {
            res[0] = i + 1;
          } else {
            res[1] = i + 1;
          }
          if (res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
          }
          continue;
        }
      }
    }
    return res;
  }
  
  public static boolean binarySearch(int val, int left, int right, int[] numbers) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (val < numbers[mid]) {
        right = mid - 1;
      } else if (val > numbers[mid]) {
        left = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
  
  /* Straight forward solution. o(n^2). Got TLE of course */
  public static int[] twoSum_TLE(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      return null;
    }
    int[] res = new int[2];
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) {
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }
    return res;
  }
  
  public static void main(String[] args) {
    int[] numbers = { 0, 4, 3, 0 };
    System.out.println(Arrays.toString(twoSum(numbers, 0)));
  }
}
