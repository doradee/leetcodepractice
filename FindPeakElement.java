package solutions;

/*
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], 
 find a peak element and return its index.

 The array may contain multiple peaks, 
 in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element 
 and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {
  
  /* Accepted. */
  public static int findPeakElement(int[] num) {
    if (num == null || num.length == 0) {
      return -1;
    }
    int low = 0, high = num.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (num[mid] < num[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
  
  public static void main(String[] args) {
    int[] input = {-8, 1, 3, 2, 1, 7, 1};
    System.out.println(findPeakElement(input));
  }
}
