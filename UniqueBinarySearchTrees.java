package solutions;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {
  
  /* classic DP problem. Accetped */
  public int numTrees(int n) {
    if (n <= 2) {
      return n;
    }
   int[] record = new int[n + 1];
   record[0] = 1;
   numTrees(n, record);
   return record[n];
  }
  
  private int numTrees(int n, int[] record) {
    if (record[n - 1] != 0) {
      return record[n - 1];
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += numTrees(i, record) * numTrees(n - i - 1, record);
    }
    record[n] = sum;
    return sum;
  }
}
