package Day20150513;
import common.ListNode;

public class ReverseLinkedListII {
	
	public ListNode reverseBetween(ListNode head,int m, int n){
		if(head == null || m == n)
			return head;

		ListNode L = new ListNode(-1);
		L.next = head;
		ListNode pre = L;
		ListNode pos = head;

		int len = n - m + 1;
		while(m > 1){
			pos = pos.next;
			pre = pre.next;
			m --;
		}
		pre.next = null;
		

		ListNode tail = pre;
		boolean first = true;

		while(len > 0){
			ListNode tmp = pos;
			pos = pos.next;

			tmp.next = pre.next;
			pre.next = tmp;
			len --;

			if(first){
				tail = tmp;
				first = false;
			}
		}
		
		tail.next = pos;

		return L.next;
	}

}
