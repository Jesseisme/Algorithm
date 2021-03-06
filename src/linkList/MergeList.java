package linkList;

public class MergeList {
	public static ListNode SortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode sortList1 = SortList(head);
		ListNode sortList2 = SortList(midNext);
		return mergeTwoLists(sortList1, sortList2);
	}

	private static ListNode getMid(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast, slow;
		fast = head;
		slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
				cur=cur.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
				cur=cur.next;
			}
		}
		return head.next;
	}

	public static void main(String ar[]) {
		ListNode one = new ListNode(3);
		ListNode two = new ListNode(2);
		ListNode thres = new ListNode(4);
		one.next = two;
		two.next = thres;
		ListNode res = SortList(one);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
