package solutions;

/*
 Given two sorted integer arrays A and B, merge B into A as one sorted array.
 Note:
 You may assume that A has enough space (size that is greater or equal to m + n) 
 to hold additional elements from B. 
 The number of elements initialized in A and B are m and n respectively.

 */
public class MergeSortedArray {
  
  /*
   * Accepted. Same as Merge-sort. But this one is not a good solution: What if
   * the requirement is merge in place?
   */
  public static void merge_bad(int A[], int m, int B[], int n) {
    int[] C = new int[m + n];
    int pa = 0;
    int pb = 0;
    for (int i = 0; i < C.length; i++) {
      if (pa < m && pb < n) {
        if (A[pa] <= B[pb]) {
          C[i] = A[pa];
          pa++;
        } else {
          C[i] = B[pb];
          pb++;
        }
      } else if (pa < m) {
        C[i] = A[pa];
        pa++;
      } else {
        C[i] = B[pb];
        pb++;
      }
    }
    for (int i = 0; i < C.length; i++) {
      A[i] = C[i];
    }
  }
  
  /* Improved solution Accepted. Learned from 9Z. Merge In place */
  public static void merge(int A[], int m, int B[], int n) {
    int index = m + n - 1;
    int indexA = m - 1;
    int indexB = n - 1;
    while (indexA >=0 && indexB >=0) {
      if (A[indexA] >= B[indexB]) {
        A[index] = A[indexA];
        indexA--;
      } else {
        A[index] = B[indexB];
        indexB--;
      }
      index--;
    }
    while (indexA>=0) {
      A[index] = A[indexA];
      indexA--;
      index--;
    }
    while (indexB>=0) {
      A[index] = B[indexB];
      indexB--;
      index--;
    }
  }
  
  /* Solution from 9Z. Very compact, but lots of --n used though.*/
  public void merge_9Z(int A[], int m, int B[], int n) {
    int index = m + n;
    while (m > 0 && n > 0) {
        if (A[m - 1] > B[n - 1]) {
            A[--index] = A[--m];
        } else {
            A[--index] = B[--n];
        }
    }
    while (n > 0) {
        A[--index] = B[--n];
    }
}
  
}
