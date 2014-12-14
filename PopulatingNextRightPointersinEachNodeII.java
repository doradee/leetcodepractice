package solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
  
  /*
   * A solution with o(2^n) extra space, n is the level of binary tree Same code
   * as problem I
   */
  public static void connect_Di(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    queue.offer(root);
    int currLevelNodeNum = 1;
    int nextLevelNodeNum = 0;
    while (!queue.isEmpty()) {
      nextLevelNodeNum = 0;
      while (currLevelNodeNum > 0) {
        TreeLinkNode node = queue.poll();
        currLevelNodeNum--;
        if (currLevelNodeNum > 0) {
          node.next = queue.peek();
        }
        if (node.left != null) {
          queue.offer(node.left);
          nextLevelNodeNum++;
        }
        if (node.right != null) {
          queue.offer(node.right);
          nextLevelNodeNum++;
        }
      }
      currLevelNodeNum = nextLevelNodeNum;
    }
  }
  
  /* A modified solution based on the constant memory solution of I 
   * Learned from 9Z though */
  public static void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    TreeLinkNode next = null;
    TreeLinkNode pre = null;
    while (root != null) {
      while (root != null) {
        /* find start of next level */
        if (next == null) {
          next = root.left != null ? root.left : root.right;
        }
        /* find pre */
        if (root.left != null) {
          if (pre == null) {
            pre = root.left;
          } else {
            pre.next = root.left;
            pre = pre.next;
          }
        }
        if (root.right != null) {
          if (pre == null) {
            pre = root.right;
          } else {
            pre.next = root.right;
            pre = pre.next;
          }
        }
        root = root.next;
      }
      root = next;
    }
  }
}
