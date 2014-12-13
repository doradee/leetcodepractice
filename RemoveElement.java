package solutions;

/*
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
  
  /* First try, Failed. Runtime Error - WHY? */
  public static int removeElement_fail(int[] A, int elem) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int size = 0;
    boolean edited = false;
    for (int i = 0; i < A.length; i++) {
      if (A[i] != elem) {
        A[size] = A[i];
        size++;
        edited = true;
      }
    }
    return (size == A.length - 1 || !edited) ? size : size + 1;
  }
  
  /* Second try. Learned from 9z */
  public static int removeElement_9Z(int[] A, int elem) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int left = 0;
    int right = A.length - 1;
    while (left <= right) {
      if (A[left] != elem) {
        left++;
      } else {
        A[left] = A[right];
        right--;
      }
    }
    return right + 1;
  }
  
  /* Third solution learned from Internet. Most compact */
  public static int removeElement(int[] A, int elem) {
    int len = A.length;
    for (int i = 0 ; i< len; ++i){
        while (A[i]==elem && i< len) {
            A[i]=A[--len];
        }
    }
    return len;
 }
  
  public static void main(String[] args) {
    System.out.println(removeElement_fail(new int[] {}, 0));
    System.out.println(removeElement(new int[] {}, 0));
    int n = 5;
    System.out.println("--n " + --n + "; n " + n);
    System.out.println("n-- " + n-- + "; n " + n);
    System.out.println("++n " + ++n + "; n " + n);
    System.out.println("n++ " + n-- + "; n " + n);
  }
}
