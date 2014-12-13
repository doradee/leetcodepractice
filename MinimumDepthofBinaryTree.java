package solutions;

/*
 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the 
 shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
  
  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
  }
}
