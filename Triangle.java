package solutions;

import java.util.ArrayList;

/*
 Given a triangle, find the minimum path sum from top to bottom. 
 Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, 
 where n is the total number of rows in the triangle.
 */
public class Triangle {
  
  /*
   * Accepted solution. The idea is all right. But stuck in indexes of pre and
   * cur. be sure to clear about size of list, and index of elements.
   */
  public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }
    ArrayList<Integer> pre = new ArrayList<Integer>();
    pre.add(triangle.get(0).get(0));
    if (triangle.size() == 1) {
      return triangle.get(0).get(0);
    }
    for (int i = 1; i < triangle.size(); i++) {
      ArrayList<Integer> current = new ArrayList<Integer>();
      current.add(pre.get(0) + triangle.get(i).get(0));
      for (int j = 0; j < pre.size() - 1; j++) {
        current.add(Math.min(pre.get(j + 1), pre.get(j))
            + triangle.get(i).get(j + 1));
      }
      current.add(pre.get(pre.size() - 1)
          + triangle.get(i).get(triangle.get(i).size() - 1));
      pre = current;
    }
    int minTotal = Integer.MAX_VALUE;
    for (int i : pre) {
      if (i < minTotal) {
        minTotal = i;
      }
    }
    return minTotal;
  }
  
  /* 9Z's solution. Easier to understand. But space complexity is o(n^2) */
  public int minimumTotal_9Z(ArrayList<ArrayList<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }
    int n = triangle.size();
    int[][] sum = new int[n][n];
    for (int i = 0; i < n; i++) {
      sum[n - 1][i] = triangle.get(n - 1).get(i);
    }
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1])
            + triangle.get(i).get(j);
      }
    }
    return sum[0][0];
  }
  
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> l1 = new ArrayList<Integer>();
    l1.add(-1);
    ArrayList<Integer> l2 = new ArrayList<Integer>();
    l2.add(2);
    l2.add(3);
    ArrayList<Integer> l3 = new ArrayList<Integer>();
    l3.add(1);
    l3.add(-1);
    l3.add(-1);
    triangle.add(l1);
    triangle.add(l2);
    triangle.add(l3);
    System.out.println(minimumTotal(triangle));
  }
}
