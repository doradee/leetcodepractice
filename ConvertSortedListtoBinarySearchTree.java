package solutions;

/*
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {
  
  /* Accepted at the first try! Super Happy! */
  public static TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode leftEnd = findLeftEnd(head);
    TreeNode root = new TreeNode(leftEnd.next.val);
    ListNode rightHead = leftEnd.next.next;
    leftEnd.next = null;
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(rightHead);
    return root;
  }
  
  private static ListNode findLeftEnd(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head, fast = head.next, leftEnd = slow;
    while (fast != null && fast.next != null) {
      leftEnd = slow;
      fast = fast.next.next;
      slow = slow.next;
    }
    return leftEnd;
  }
}
