package Day20150513;
import common.ListNode;

public class Partition {
	
	public ListNode partition(ListNode head, int x){
		if(head == null)
			return head;

		ListNode L = new ListNode(-1);
		ListNode tail = L;
		ListNode cur = head;
		ListNode pre = L;

		while(cur != null){
			ListNode tmp = cur;
			cur = cur.next;

			if(tmp.val < x){
				tmp.next = pre.next;
				pre.next = tmp;
				pre = pre.next;

				if(tail.next != null)
					tail = tail.next;
			}	
			else{
				tmp.next = null;
				tail.next = tmp;
				tail = tail.next;
			}
		}

		return L.next;
	}

}
		
