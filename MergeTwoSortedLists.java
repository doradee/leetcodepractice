package solutions;

/*
 Merge two sorted linked lists and return it as a new list. 
 The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
  
  /* Accepted. Trivial */
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    if (l1 == null ^ l2 == null) {
      return l1 == null ? l2 : l1;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 != null) {
      cur.next = l1;
    } else {
      cur.next = l2;
    }
    return dummy.next;
  }
  
  public static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + ",");
      head = head.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(1);
    printList(l1);
    printList(l2);
    ListNode res = mergeTwoLists(l1, l2);
    printList(res);
  }
}
