package leetcode;

import static leetcode.ListNodeHelper.*;

public class _021_MergeTwoSortedLists {

  public static void main(String[] args) {
    {
      ListNode node1 = stringToListNode("1,2,4,7,8");
      ListNode node2 = stringToListNode("1,2,4,5");
      System.out.println(listNodeToString(solution(node1, node2)));
    }
    {
      ListNode node1 = stringToListNode("1,2,4,7,8");
      ListNode node2 = stringToListNode("1,2,4,5");
      System.out.println(listNodeToString(mergeTwoLists(node1, node2)));
    }
  }

  public static ListNode solution(ListNode node1, ListNode node2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (node1 != null && node2 != null) {
      if (node1.val < node2.val) {
        curr.next = node1;
        node1 = node1.next;
        curr = curr.next;
      } else {
        curr.next = node2;
        node2 = node2.next;
        curr = curr.next;
      }
    }
    if (node1 != null) {
      curr.next = node1;
    }
    if (node2 != null) {
      curr.next = node2;
    }
    return dummy.next;
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode curr = head;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
        curr = curr.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
        curr = curr.next;
      }
    }
    if (l1 != null) {
      curr.next = l1;
    }
    if (l2 != null) {
      curr.next = l2;
    }
    return head.next;
  }

}
