package solutions;

import java.util.ArrayList;
import java.util.HashMap;

/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

public class UniqueBinarySearchTreesII {
  /* Learned from 9Z. */
  public ArrayList<TreeNode> generateTrees(int n) {
    return generateTrees(1, n);
  }
  
  private ArrayList<TreeNode> generateTrees(int start, int end) {
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    if (start > end) {
      res.add(null);
      return res;
    }
    for (int i = start; i <= end; i++) {
      ArrayList<TreeNode> left = generateTrees(start, i - 1);
      ArrayList<TreeNode> right = generateTrees(i+1, end);
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;
          res.add(root);
        }
      }
    }
    return res;
  }
}
