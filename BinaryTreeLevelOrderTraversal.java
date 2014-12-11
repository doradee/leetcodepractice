package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */

public class BinaryTreeLevelOrderTraversal {
  
  /*easier solution of same problem II, learned from 9Z */
  public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int currLevelNodeNum = 1;
    int nextLevelNodeNum = 0;
    while (currLevelNodeNum != 0) {
      ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
      nextLevelNodeNum = 0;
      while (currLevelNodeNum != 0) {
        TreeNode node = queue.poll();
        currLevelResult.add(node.val);
        currLevelNodeNum--;
        if (node.left != null) {
          queue.offer(node.left);
          nextLevelNodeNum++;
        }
        if (node.right != null) {
          queue.offer(node.right);
          nextLevelNodeNum++;
        }
      }
      result.add(currLevelResult);
      currLevelNodeNum = nextLevelNodeNum;
    }
    return result;
  }
}
