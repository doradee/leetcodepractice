package solutions;

import java.util.ArrayList;
import java.util.Stack;

/*
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
  \
   2
  /
 3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
  
  /* Iterative solution using stack */
  public static ArrayList<Integer> preorderTraversal (TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node != null) {
        res.add(node.val);
      } else {
        continue;
      }
      stack.push(node.right);
      stack.push(node.left);
    }
    return res;
  }
  
  /* Trivial solution using recursion */
  public static ArrayList<Integer> preorderTraversal_Recursive(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    preorderT(root, res);
    return res;
  }
  
  private static void preorderT(TreeNode root, ArrayList<Integer> res) {
    if (root == null) {
      return;
    }
    res.add(root.val);
    preorderT(root.left, res);
    preorderT(root.right, res);
  }
}
