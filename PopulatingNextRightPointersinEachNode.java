package solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL

 */
class TreeLinkNode {
  
  int val;
  TreeLinkNode left, right, next;
  
  TreeLinkNode(int x) {
    val = x;
  }
}

public class PopulatingNextRightPointersinEachNode {
  
  /*
   * A solution that satisfy more than required. Since this algorithm works for
   * not perfect binary tree as well. However, the memory space used is not
   * constant. The space memory used is o(2^n) n is the depth of the binary
   * tree.
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
  
  /* With the assumption that the binary tree is complete, a simpler solution */
  public static void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    while (root != null && root.left != null) {
      TreeLinkNode temp = root.left;
      while (root != null) {
        if (root.left != null) {
          root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
          root.right.next = root.next.left;
        }
        root = root.next;
      }
      root = temp;
    }
  }
  
  /* Solution from 9Z. More concise */
  public static void connect_9Z(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    TreeLinkNode parent = root;
    TreeLinkNode next = parent.left;
    while (parent != null && next != null) {
      TreeLinkNode prev = null;
      while (parent != null) {
        if (prev == null) {
          prev = parent.left;
        } else {
          prev.next = parent.left;
          prev = prev.next;
        }
        prev.next = parent.right;
        prev = prev.next;
        parent = parent.next;
      }
      parent = next;
      next = parent.left;
    }
  }
}
