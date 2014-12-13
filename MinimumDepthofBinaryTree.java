package solutions;

/*
 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the 
 shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
  
  /* Accepted solution. Learned from 9Z */
  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return getMin(root);
  }
  
  public static int getMin(TreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    return Math.min(getMin(root.left), getMin(root.right)) + 1;
  }
}
