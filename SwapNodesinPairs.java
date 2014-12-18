package solutions;

/*
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values 
 in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
  /* Accepted. Space for improvement though */
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    while (head != null && head.next != null) {
      ListNode temp = head.next;
      pre.next = temp;
      head.next = temp.next;
      temp.next = head;
      pre = head;
      head = head.next;
    }
    return dummy.next;
  }
  
  /* Solution from 9Z. More concise. */
  public ListNode swapPairs_9Z(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    ListNode point = new ListNode(0);
    point.next = head;
    head = point;
    while(point.next != null && point.next.next != null) {
        ListNode tmp = point.next.next.next;
        point.next.next.next = point.next;
        point.next = point.next.next;
        point.next.next.next = tmp;
        point = point.next.next;
    }
    return head.next;
}
}
