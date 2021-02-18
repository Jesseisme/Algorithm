package linkList;

public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				cur.next = l2;
				return head.next;
			} else if (l2 == null) {
				cur.next = l1;
				return head.next;
			} else if (l2.val > l1.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
		}
		return head.next;
	}
}
