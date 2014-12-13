package solutions;

import java.util.Stack;

/*
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following is not:
 1
 / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */
/* from discussion: this problem involves two point:
 consider tree T:  if T is null, then T is symmetric; 
 if T->left is mirror of T->right,then T is symmetric
 mirror:  consider two tree T and R:  if T=R=NULL, then T is mirror of R
 if T and R both not NULL,and T->left is mirror of R->right,
 and T->right is mirror of R->left,then T and R is mirror
 otherwise the mirror relationship cannot estabished
 */
public class SymmetricTree {
  
  /* Inspired by discussion. Recursive solution */
  public static boolean isSymmetric_rec(TreeNode root) {
    return isSymmetricTest(root, root);
  }
  
  public static boolean isSymmetricTest(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null ^ right == null) {
      return false;
    }
    if (left.val != right.val) {
      return false;
    }
    return isSymmetricTest(left.left, right.right)
        && isSymmetricTest(left.right, right.left);
  }
  
  /* Interative solution. Using Stack. Inspired by discussion. Accepted */
  public static boolean isSymmetric(TreeNode root) {
    Stack<TreeNode> nodes = new Stack<TreeNode>();
    if (root == null) {
      return true;
    }
    if (root.left == null ^ root.right == null) {
      return false;
    } else if (root.left == null && root.right == null) {
      return true;
    } else {
      nodes.push(root.left);
      nodes.push(root.right);
    }
    while (!nodes.isEmpty()) {
      if (nodes.size() % 2 != 0) {
        return false;
      }
      TreeNode right = nodes.pop();
      TreeNode left = nodes.pop();
      if (left == null ^ right == null) {
        return false;
      } else if (left != null && right != null) {
        if (left.val != right.val) {
          return false;
        } else {
          if (left.left == null ^ right.right == null) {
            return false;
          } else {
            nodes.push(left.left);
            nodes.push(right.right);
          }
          if (left.right == null ^ right.left == null) {
            return false;
          } else {
            nodes.push(left.right);
            nodes.push(right.left);
          }
        }
      }
    }
    return true;
  }
}
