package Day20150412;

import common.ListNode;

public class RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		ListNode pre = head;
		ListNode pos = head.next;
		
		while(pos != null) {
			if(pos.val == pre.val){
				pre.next = pos.next;
			}
			else{
				pre = pos;
			}
			pos = pos.next;
		}
		
		return head;
    }
}
