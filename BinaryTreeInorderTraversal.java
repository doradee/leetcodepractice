package solutions;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

 */
public class BinaryTreeInorderTraversal {
  
  /* This is the trival solution */
  public static ArrayList<Integer> inorderTraversal1(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    inorderTraversal(root, result);
    return result;
  }
  
  public static void inorderTraversal (TreeNode root, ArrayList<Integer> result) {
    if (root.left != null) {
      inorderTraversal(root.left, result);
    }
    result.add(root.val);
    if (root.right != null) {
      inorderTraversal(root.right, result);
    }
  }
  
  /* This is another solution using iteration and queue 
   * Inspired by azheanda */
  
  public static ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
     if(node != null) {
       stack.push(node);
       node = node.left;
     } else {
       node = stack.pop();
       result.add(node.val);
       node = node.right;
     }
    }
    return result;
  }
  
  public static void main(String[] args) {
    TreeNode l1 = new TreeNode(1);
    TreeNode l21 = new TreeNode(2);
    TreeNode l22 = new TreeNode(3);
    l1.left = null;
    l1.right = l21;
    l21.left = l22;
    System.out.println(inorderTraversal(l1).toString());
  }
}
