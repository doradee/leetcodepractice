package solutions;

/*
 * Given a binary tree, determine if it is height-balanced.For this problem, 
 * a height-balanced binary tree is defined as a binary tree in which the depth 
 * of the two subtrees of every node never differ by more than 1.
 */

public class BalancedBinaryTree {
  
  /* the code I wrote up */
  public static boolean isBalanced1(TreeNode root) {
    if (root == null) {
        return true;
    }
    return Math.abs(height(root.left) - height(root.right)) <= 1 
        && isBalanced(root.left) && isBalanced(root.right);
  }
  
  private static int height(TreeNode root) {
      if (root == null) {
          return 0;
      }
      return Math.max(1+height(root.left), 1+height(root.right));
  }
  
  /* code from 9Z */
  /* this solution improves time complexity since height(root) will only do once */
  public static boolean isBalanced(TreeNode root) {
    return maxDepth(root) != -1;
  }

  private static int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
        return -1;
    }
    return Math.max(left, right) + 1;
}
}
