package solutions;

import java.util.ArrayList;

/*
 Given numRows, generate the first numRows of Pascal's triangle.
 For example, given numRows = 5,
 Return
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalsTriangle {
  
  /*
   * Accepted. The idea is add 1 to current level list at first, then add sum of
   * two adjacent elements in pre level list, then add 1 at the end
   */
  public static ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (numRows <= 0) {
      return res;
    }
    ArrayList<Integer> pre = new ArrayList<Integer>();
    pre.add(1);
    res.add(pre);
    if (numRows == 1) {
      return res;
    }
    for (int i = 2; i <= numRows; i++) {
      ArrayList<Integer> cur = new ArrayList<Integer>();
      cur.add(1);
      for (int j = 1; j < pre.size(); j++) {
        cur.add(pre.get(j) + pre.get(j - 1));
      }
      cur.add(1);
      res.add(cur);
      pre = cur;
    }
    return res;
  }
  
  /* Solution from 9Z */
  public ArrayList<ArrayList<Integer>> generate_9Z(int numRows) {
    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    if (numRows == 0) {
        return rst;
    }

    ArrayList<Integer> first = new ArrayList<Integer>();
    first.add(0, 1);
    rst.add(first);

    for (int i = 1; i < numRows; i++) {
        ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
        for (int j = 0; j < i + 1; j++){
            tmp.add(-1);
        }
        ArrayList<Integer> prev = rst.get(i - 1);
        tmp.set(0, prev.get(0));
        tmp.set(i, prev.get(i - 1));
        for (int j = 1; j < i; j++){
            tmp.set(j, prev.get(j - 1)+prev.get(j));
        }
        rst.add(tmp);
    }
    return rst;
}
  public static void main(String[] args) {
    System.out.println(generate(4));
  }
}
