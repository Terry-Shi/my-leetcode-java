package leetcode;

import static leetcode.ListNodeHelper.*;


public class _024_SwapNodesInPairs {
	public static void main(String[] args) {
		ListNode listNode = stringToListNode("1,2,3,4,5,6");
		System.out.println(listNodeToString(SwapNodesInPairs3(listNode)));
		listNode = stringToListNode("1,2,3,4,5,6");
		System.out.println(listNodeToString(swapPairs(listNode)));
	}

	// 交换整个 Node
	public static ListNode SwapNodesInPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;

		while (p != null && p.next != null && p.next.next != null) {
			ListNode n1 = p.next;
			ListNode n2 = p.next.next;

			n1.next = n2.next;
			n2.next = n1;
			p.next  = n2;

			p = p.next.next;
		}
		return dummy.next;
	}

	// 递归
	public static ListNode SwapNodesInPairs3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode n = head.next; // n 是第二个元素
		head.next = SwapNodesInPairs3(head.next.next); // 第一个Node的next指向剩余队列的开始
		n.next = head; // 第二Node指向第一Node
		return n; // 第二变第一（头）
	}

	 public static ListNode swapPairs(ListNode head) {
	   ListNode dummyNode = new ListNode(0);
	   dummyNode.next = head;
	   ListNode currPos = dummyNode;
	   while (currPos != null && currPos.next != null ) {
    	   ListNode pointTofirst = currPos.next;
    	   ListNode pointToSecond = currPos.next.next;

    	   pointTofirst.next = pointToSecond.next;
    	   pointToSecond.next = pointTofirst;
    	   currPos.next = pointToSecond;
    	   currPos = pointTofirst;
       }
	   return dummyNode.next;
	 }

}
