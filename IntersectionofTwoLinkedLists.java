package solutions;

/*
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗            
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedLists {
  
  /*
   * learned from the Internet. The trick is if two lists are going to merge,
   * they will have a common sub-list, which shouldn't be longer than either
   * one. So, if two lists have the same length, just move the pointer together;
   * otherwise, longer list should move length-diff more to begin have the same
   * length.
   */
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    /* to get the the same length */
    int lengthA = 0;
    int lengthB = 0;
    ListNode curA = headA;
    ListNode curB = headB;
    while (curA != null) {
      lengthA++;
      curA = curA.next;
    }
    while (curB != null) {
      lengthB++;
      curB = curB.next;
    }
    if (lengthA > lengthB) {
      int diff = lengthA - lengthB;
      while (diff > 0) {
        headA = headA.next;
        diff--;
      }
    } else if (lengthA < lengthB) {
      int diff = lengthB - lengthA;
      while (diff > 0) {
        headB = headB.next;
        diff--;
      }
    }
    /* start from the same length, check each element */
    while (headA != null) {
      if (headA == headB) {
        return headA;
      } else {
        headA = headA.next;
        headB = headB.next;
      }
    }
    return headA;
  }
}
