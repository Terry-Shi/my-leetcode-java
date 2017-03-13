package leetcode;

public class _024_SwapNodesInPairs {
	public static void main(String[] args) {
		
		ListNode dummy = new ListNode(0);
		ListNode l1 = new ListNode(1);
		dummy.next = l1;
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		
		ListNode ret = SwapNodesInPairs3(l1);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
	
	/**
	 * 交换Node中的value
	 * @param head
	 * @return
	 */
	public static ListNode SwapNodesInPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		while (head != null && head.next != null) {
			int temp = head.val; 
			head.val = head.next.val;
			head.next.val = temp;
			
			head = head.next.next;
		}
		return dummy.next;
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
	
	
}
