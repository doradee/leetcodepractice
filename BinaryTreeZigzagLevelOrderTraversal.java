package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]

 */
public class BinaryTreeZigzagLevelOrderTraversal {
  
  /* Great! Accepted at the first time */
  public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int currLevelNodesNum = 1;
    int nextLevelNodesNum = 0;
    boolean forward = true;
    while (!queue.isEmpty()) {
      nextLevelNodesNum = 0;
      ArrayList<Integer> curr = new ArrayList<Integer>();
      while (currLevelNodesNum > 0) {
        TreeNode node = queue.poll();
        currLevelNodesNum--;
        if (forward) {
          curr.add(node.val);
        } else {
          curr.add(0, node.val);
        }
        if (node.left != null) {
          queue.offer(node.left);
          nextLevelNodesNum++;
        }
        if (node.right != null) {
          queue.offer(node.right);
          nextLevelNodesNum++;
        }
      }
      res.add(curr);
      forward = !forward;
      currLevelNodesNum = nextLevelNodesNum;
    }
    return res;
  }
}
