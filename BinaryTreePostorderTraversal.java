package solutions;

import java.util.ArrayList;
import java.util.Stack;

/*
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */
public class BinaryTreePostorderTraversal {
  
  /* most learned from 9Z. */
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (root == null) {
      return res;
    }
    TreeNode pre = null;
    TreeNode curr = root;
    stack.push(root);
    while (!stack.isEmpty()) {
      curr = stack.peek();
      if (pre == null || pre.left == curr|| pre.right == curr) { //going down
        if (curr.left != null) {
          stack.push(curr.left);
        } else if (curr.right != null) {
          stack.push(curr.right);
        }
      } else if (curr.left == pre) { //going  up from left
        if (curr.right != null) {
          stack.push(curr.right);
        }
      } else { //going up from right
        res.add(curr.val);
        stack.pop();
      }
      pre = curr;
    }
    return res;
  }
  
  /* Trivial recursive solution */
  public ArrayList<Integer> postorderTraversal_Recursive(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    postorderT(root, res);
    return res;
  }
  
  private void postorderT(TreeNode root, ArrayList<Integer> res) {
    if (root == null) {
      return;
    }
    postorderT(root.left, res);
    postorderT(root.right, res);
    res.add(root.val);
  }
  
  /* Still recursive, but more compact */
  public ArrayList<Integer> postorderTraversal_Rec_9Z(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    res.addAll(postorderTraversal_Rec_9Z(root.left));
    res.addAll(postorderTraversal_Rec_9Z(root.right));
    res.add(root.val);
    return res;
  }
}
