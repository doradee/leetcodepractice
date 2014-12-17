package solutions;

/*
 Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.
 */
public class BinaryTreeMaximumPathSum {
  
  /* Learned from Discussion board. The idea is keep tracking two max values.
   * One is local max, which includes root; the other is global max, 
   * which doesn't have to include root node */
  
  static int max = Integer.MIN_VALUE;
  public static int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    max  = root.val;
    maxPathSumFinder(root);
    return max;
  }
  
  private static int maxPathSumFinder(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMax = maxPathSumFinder(root.left);
    int rightMax = maxPathSumFinder(root.right);
    int localMax = Math.max(root.val, Math.max(leftMax, rightMax) + root.val);
    max = Math.max(max, Math.max(localMax, leftMax + rightMax + root.val));
    return localMax;
  }
}
