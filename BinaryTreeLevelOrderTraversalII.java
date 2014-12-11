package solutions;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  
  int      val;
  TreeNode left;
  TreeNode right;
  
  TreeNode(int x) {
    val = x;
  }
}

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

public class BinaryTreeLevelOrderTraversalII {
  
  /* This is the classic solution. Inspired by 9Z */
  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
        currLevelNodeNum--;
        currLevelResult.add(node.val);
        if(node.left != null) {
          nextLevelNodeNum++;
          queue.offer(node.left);
        }
        if (node.right !=null) {
          nextLevelNodeNum++;
          queue.offer(node.right);
        }
      }
      /*public void add(int index, E element) 
       * Inserts the specified element at the specified position in this list. 
       * Shifts the element currently at that position (if any) and any 
       * subsequent elements to the right (adds one to their indices).
       */
      result.add(0, currLevelResult);
      currLevelNodeNum = nextLevelNodeNum;
    }
    return result;
  }
}
