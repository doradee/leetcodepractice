package solutions;

/*
 Given a sorted linked list, delete all nodes that have duplicate numbers, 
 leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII {
  
  /* Easy problem. But struggled a lot until accepted. Silly mistakes are:
   *    1. using cur == cur.next to see if the value is the same.
   *        the correct condition should be cur.val == cur.next.val
   *    2. the position of pointers are messed up */
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = null;
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        while (head != null && head.val == cur.val) {
          head = head.next;
        }
        cur = head;
      } else {
        pre.next = head;
        pre = head;
        head = head.next;
        cur = head;
      }
    }
    if (cur != null) {
      pre.next = head;
    } else {
      pre.next = null;
    }
    return dummy.next;
  }
  
  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(2);
    n1.next = n2;
    n2.next = n3;
    ListNode res = deleteDuplicates(n1);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}
