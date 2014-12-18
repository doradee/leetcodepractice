package solutions;

/*
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
  /* Learned from 9Z. Tricky part is after finding nodeM */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    ListNode preM = dummy;
    preM.next = head;
    ListNode nodeM = head;
    int temp = m;
    while (temp > 1) {
      nodeM = nodeM.next;
      preM = preM.next;
      temp--;
    }
    ListNode nodeN = nodeM;
    ListNode postN = nodeM.next;
    temp = n - m;
    while (temp > 0) {
      ListNode tempNode = postN.next;
      postN.next = nodeN;
      nodeN = postN;
      postN = tempNode;
      temp--;
    }
    nodeM.next = postN;
    preM.next = nodeN;
    return dummy.next;
  }
}
