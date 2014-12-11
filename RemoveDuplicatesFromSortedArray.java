package solutions;

/*
 Given a sorted array, remove the duplicates in place such that each element 
 appear only once and return the new length.

 Do not allocate extra space for another array, 
 you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {
  
  /* Accepted. Trivial */
  public int removeDuplicates(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int index = 1;
    for (int i = 1; i < A.length; i++) {
      if (A[i - 1] != A[i]) {
        A[index] = A[i];
        index++;
      }
    }
    return index;
  }
  
  /* Solution from 9Z */
  public int removeDuplicates_9Z(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int size = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] != A[size]) {
        A[++size] = A[i];
      }
    }
    return size + 1;
  }
}
