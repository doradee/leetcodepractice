package solutions;

/*
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {
  
  /* Accepted */
  public static int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    return sumNumbersCal(root, sum);
  }
  
  public static int sumNumbersCal(TreeNode root, int sum) {
    if (root.left == null && root.right == null) {
      return sum * 10 + root.val;
    } else if (root.left != null && root.right == null) {
      sum = sum * 10 + root.val;
      return sumNumbersCal(root.left, sum);
    } else if (root.left == null && root.right != null) {
      sum = sum * 10 + root.val;
      return sumNumbersCal(root.right, sum);
    } else {
      sum = sum * 10 + root.val;
      return sumNumbersCal(root.left, sum) + sumNumbersCal(root.right, sum);
    }
  }
  
  /* Solution from 9Z. More concise. */
  public static int sumNumbers_9Z(TreeNode root) {
    return sumNumbers_9Zcal(root, 0);
  }
  
  public static int sumNumbers_9Zcal(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    sum = root.val + sum * 10;
    if (root.left == null && root.right == null) {
      return sum;
    }
    return sumNumbers_9Zcal(root.left, sum) + sumNumbers_9Zcal(root.right, sum);
  }
}
