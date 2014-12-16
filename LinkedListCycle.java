package solutions;

/*
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle {
  
  /* learned from discussion. Floyd's cycle finding algorithm */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head, fast = head.next;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
  
  /* more concise version from 9Z */
  public boolean hasCycle_9Z(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow = head, fast = head;
    do {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    } while (slow != fast);
    return true;
  }
}
