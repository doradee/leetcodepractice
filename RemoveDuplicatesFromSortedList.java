package solutions;

/*

 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedList {
  
  /* Accepted. Trivial but can be improved. The while inside while is confusing*/
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    while (cur.next != null) {
      while (cur.next != null && cur.val == cur.next.val) {
        cur.next = cur.next.next;
      }
      if (cur.next != null) {
        cur = cur.next;
      }
    }
    return head;
  }
  
  /* Better solution inspired by 9Z */
  public ListNode deleteDuplicates_Better(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
}
