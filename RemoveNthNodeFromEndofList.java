package solutions;

/*

 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
/*
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
public class RemoveNthNodeFromEndofList {
  
  /*
   * Inspired by 9Z. The trick is: if the length of the list is l, then l - n is
   * a constant. to get the nth node from the end, is the same as get the l - n
   * node from the beginning.
   * 
   * Mark: Don't be confused by head and head.next. Make sure which one you want
   * 
   * This solution is accepted.
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n < 1) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode marker = dummy;
    /* iterate to n position */
    for (int i = 0; i < n; i++) {
      if (head == null) {
        return null;
      }
      head = head.next;
    }
    /*
     * iterate to the end, and have marker iterate at the same time once
     * iterator reaches the end, the marker will reach l - n position which is
     * the node we are going to delete.
     */
    while (head != null) {
      head = head.next;
      marker = marker.next;
    }
    marker.next = marker.next.next;
    return dummy.next;
  }
}
