package solutions;

class ListNode {
  
  int      val;
  ListNode next;
  
  ListNode(int x) {
    val = x;
    next = null;
  }
}

/*
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4 ->
 * 3) + (5 -> 6 -> 4); Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
  
  /*
   * this solution is accepted. However, I made some silly mistakes on iterating
   * linked list. Such as: to move cur forward, i should use: temp.next = cur;
   * temp = cur; but I wrongly used: temp.next = cur; cur = temp;
   */
  public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return null;
    }
    int carry = (l1.val + l2.val) / 10;
    int sum = (l1.val + l2.val) % 10;
    ListNode tempNode = new ListNode(sum);
    ListNode head = tempNode;
    while (l1.next != null) {
      if (l2.next == null) {
        int temp = l1.next.val + carry;
        sum = temp % 10;
        carry = temp / 10;
        l1 = l1.next;
      } else {
        int temp = l1.next.val + l2.next.val + carry;
        sum = temp % 10;
        carry = temp / 10;
        l1 = l1.next;
        l2 = l2.next;
      }
      ListNode cur = new ListNode(sum);
      tempNode.next = cur;
      tempNode = cur;
    }
    while (l2.next != null) {
      int temp = l2.next.val + carry;
      sum = temp % 10;
      carry = temp / 10;
      l2 = l2.next;
      ListNode cur = new ListNode(sum);
      tempNode.next = cur;
      tempNode = cur;
    }
    if (carry == 1) {
      ListNode cur = new ListNode(carry);
      tempNode.next = cur;
      tempNode = cur;
    }
    return head;
  }
  
  /*
   * Here is a more clear solution inspired by 9Z. The idea is the same, but it
   * is more compact and simple to follow
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return null;
    }
    int carry = 0;
    ListNode head = new ListNode(0);
    ListNode point = head;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      point.next = new ListNode(sum % 10);
      carry = sum / 10;
      point = point.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int sum = l1.val + carry;
      point.next = new ListNode(sum % 10);
      carry = sum / 10;
      point = point.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int sum = l2.val + carry;
      point.next = new ListNode(sum % 10);
      carry = sum / 10;
      point = point.next;
      l2 = l2.next;
    }
    if (carry != 0) {
      point.next = new ListNode(carry);
      point = point.next;
    }
    return head.next;
  }
  
  public static void main(String[] args) {
    ListNode a1 = new ListNode(9);
    ListNode b1 = new ListNode(9);
    ListNode b2 = new ListNode(9);
    b1.next = b2;
    ListNode head = addTwoNumbers(b1, a1);
    System.out.print(head.val + " - ");
    while (head.next != null) {
      System.out.print(head.next.val + " - ");
      head = head.next;
    }
  }
}
