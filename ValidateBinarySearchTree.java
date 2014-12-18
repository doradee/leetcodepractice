package solutions;

/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys 
 less than the node's key. The right subtree of a node contains 
 only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
  /* Accepted. But there is space for improvement */
  
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left != null && max(root.left, root.left.val) <= root.val) {
      return false;
    }
    if (root.right != null && min(root.right, root.right.val) >= root.val) {
      return false;
    }
    return isValidBST(root.left) && isValidBST(root.right);
  }
  
  private int max(TreeNode root, int max) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    max = max > root.val ? max : root.val;
    return Math.max(max, Math.max(max(root.left, max), max(root.right, max)));
  }
  
  private int min(TreeNode root, int min) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    min = min < root.val? min : root.val;
    return Math.min(min, Math.min(min(root.left, min), min(root.right, min)));
  }
  
  /* 9Z's solution. Very concise. The idea is for BST, inorder traversal should be
   * an ascending order of numbers. thus, only record the last value visited is OK */
  private int lastVal = Integer.MIN_VALUE;
  public boolean isValidBST_9Z(TreeNode root) {
      if (root == null) {
          return true;
      }
      if (!isValidBST(root.left)) {
          return false;
      }
      if (lastVal >= root.val) {
          return false;
      }
      lastVal = root.val;
      if (!isValidBST(root.right)) {
          return false;
      }
      return true;
  }
}
