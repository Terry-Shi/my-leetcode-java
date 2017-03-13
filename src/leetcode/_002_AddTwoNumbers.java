package leetcode;

public class _002_AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(6);
		l1.next.next.next = new ListNode(1);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(2);
		
		ListNode ret = addTwoNumbers(l1, l2);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}

	// l1 和 l2 可能长度不同
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryon = 0;
		ListNode ret = new ListNode(0);
		ListNode currentNode = ret;
		while(true) {
			if ( l1 != null) {
				carryon = carryon + l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carryon = carryon + l2.val;
				l2 = l2.next;
			}
			
			currentNode.val = carryon % 10;
			carryon = carryon / 10;
			
			if (l1 == null && l2 == null) {
                if (carryon != 0) {
				    currentNode.next = new ListNode(carryon);
				} 
                break;
			} else {
				currentNode.next = new ListNode(0);
				currentNode = currentNode.next;
			}
		} 
		return ret;
	}
}
