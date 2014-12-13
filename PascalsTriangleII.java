package solutions;

import java.util.ArrayList;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
  
  /* Accepted. Extra space needed is O(k) - 1 for index, k - 1 for pre list */
  public static ArrayList<Integer> getRow(int rowIndex) {
    ArrayList<Integer> pre = new ArrayList<Integer>();
    if (rowIndex < 0) {
      return pre;
    }
    pre.add(1);
    if (rowIndex == 0) {
      return pre;
    }
    int index = 1;
    
    while (index <= rowIndex) {
      ArrayList<Integer> cur = new ArrayList<Integer>();
      cur.add(1);
      for (int i = 1; i < pre.size(); i++) {
        cur.add(pre.get(i - 1) + pre.get(i));
      }
      cur.add(1);
      index++;
      pre = cur;
    }
    return pre;
  }
  
  public static void main(String[] args) {
    System.out.println(getRow(3).toString());
  }
}
