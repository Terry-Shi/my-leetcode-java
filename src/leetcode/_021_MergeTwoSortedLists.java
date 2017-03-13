package leetcode;

public class _021_MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode ret = solution(node1, node2);
	}
	
	public static ListNode solution(ListNode node1, ListNode node2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (node1!=null && node2!=null) {
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
		while (node1 != null) {
			 curr.next = node1;
		}
		while (node2 != null) {
			 curr.next = node2;
		}
		return dummy.next;
	}
	
}
