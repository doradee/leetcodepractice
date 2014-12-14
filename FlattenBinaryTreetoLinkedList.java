package solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreetoLinkedList {
  /* In-place solution. Very concise. Copied from 9Z */
  private static TreeNode lastNode = null;
  public static void flatten(TreeNode root) {
      if (root == null) {
          return;
      }

      if (lastNode != null) {
          lastNode.left = null;
          lastNode.right = root;
      }

      lastNode = root;
      TreeNode right = root.right;
      flatten(root.left);
      flatten(right);
  }
  
  /* Not an inplace solution. Using queue. Accepted though */
  public static void flatten_Queue(TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    preOrderTraversal(root, queue);
    while(!queue.isEmpty()){
      TreeNode next = queue.poll();
      root.right = next;
      root.left = null;
      root = root.right;
    }
    root.right = null;
    root.left = null;
  }
  
  private static void preOrderTraversal(TreeNode root, Queue<TreeNode> queue){
    if (root == null) {
      return;
    }
    queue.offer(root);
    if (root.left != null) {
      preOrderTraversal(root.left, queue);
    }
    if (root.right != null) {
      preOrderTraversal(root.right, queue);
    }
  }
  /* Not an inplace solution. Using stack. Accepted though */
  public static void flatten_Stack(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      if (curr.right != null) {
        stack.push(curr.right);
      }
      if (curr.left != null) {
        stack.push(curr.left);
      }
      if (!stack.isEmpty()) {
        curr.right = stack.peek();
      } else {
        curr.right = null;
      }
      curr.left = null;
    }
  }
  
}
