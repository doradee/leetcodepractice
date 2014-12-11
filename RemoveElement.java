package solutions;

/*
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
  /* First try, Failed. Runtime Error - WHY? */
  public int removeElement_fail(int[] A, int elem) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int size = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] != elem) {
        A[size] = A[i];
        size++;
      }
    }
    return size + 1;
  }
  
  /* Second try. Learned from 9z */
  public int removeElement(int[] A, int elem) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int left = 0;
    int right = A.length - 1;
    while(left <= right){
      if (A[left] != elem) {
        left++;
      } else {
        A[left] = A[right];
        right--;
      }
    }
    return right + 1;
  }
}
