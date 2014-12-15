package solutions;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
  
  /*
   * time complexity is O(nlgn), thus, only merge sort or quick sort can serve
   * Since the space complexity is constant, while merge sort use lgn, it is a
   * little bit not perfect.
   */
  /* Learned from 9Z. Good algorithm to be memorized */
  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = findMid(head);
    ListNode right = sortList(mid.next);
    mid.next = null;
    ListNode left = sortList(head);
    return mergeLists(left, right);
  }
  
  public static ListNode findMid(ListNode head) {
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
  
  public static ListNode mergeLists(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        cur.next = head1;
        head1 = head1.next;
      } else {
        cur.next = head2;
        head2 = head2.next;
      }
      cur = cur.next;
    }
    if (head1 != null) {
      cur.next = head1;
    } else {
      cur.next = head2;
    }
    return dummy.next;
  }
}
