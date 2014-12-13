package solutions;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 Find the minimum element.
 You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
  
  /* o(n) solution. Trivial */
  public static int findMin_ON(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }
    for (int i = 0; i < num.length - 1; i++) {
      if (num[i] > num[i + 1]) {
        return num[i + 1];
      }
    }
    return num[0];
  }
  
  /* o(lgn) solution. */
  public static int findMin(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }
    int left = 0;
    int right = num.length - 1;
    if (num[left] < num[right] || left == right) {
      return num[left];
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (num[left] < num[mid]) {
        left = mid; // the pivot cannot be within left - mid, so discard 0 -
                    // mid;
      } else {
        right = mid; // the pivot cannot be within mid - right, so discard right
                     // - end;
      }
    }
    return num[right + 1];
  }
}
