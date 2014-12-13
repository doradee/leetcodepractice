package solutions;

/*
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
  
  /* Accepted. Just add a condition that only leaf can return true */
  public static boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null && root.val == sum) {
      return true;
    } else {
      if (root.left != null && root.right != null) {
        return hasPathSum(root.left, sum - root.val)
            || hasPathSum(root.right, sum - root.val);
      } else if (root.left != null) {
        return hasPathSum(root.left, sum - root.val);
      } else if (root.right != null) {
        return hasPathSum(root.right, sum - root.val);
      } else {
        return false;
      }
    }
  }
  
  /* 9Z's solution. More compact and clear */
  public static boolean hasPathSum_9Z(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return sum == root.val;
    }
    return hasPathSum_9Z(root.left, sum - root.val)
        || hasPathSum_9Z(root.right, sum - root.val);
  }
  
  /* first attemp. Misunderstood the question, failed. */
  public static boolean hasPathSum_Failed(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.val == sum) {
      return true;
    } else {
      if (root.left != null && root.right != null) {
        return hasPathSum_Failed(root.left, sum - root.val)
            || hasPathSum_Failed(root.right, sum - root.val);
      } else if (root.left != null) {
        return hasPathSum_Failed(root.right, sum - root.val);
      } else if (root.right != null) {
        return hasPathSum_Failed(root.left, sum - root.val);
      } else {
        return false;
      }
    }
  }
}
