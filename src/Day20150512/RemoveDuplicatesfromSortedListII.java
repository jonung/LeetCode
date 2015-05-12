package Day20150512;

import common.ListNode;

public class RemoveDuplicatesfromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;
		
		ListNode L = new ListNode(-1);
		L.next = head;
		ListNode  pre = L;
		ListNode pos = head;
		
		while(pos != null){
			int curValue = pos.val;
			int count = 1;
			boolean flag = false;
			while(pos.next != null ){
				pos = pos.next;
				if(pos.val == curValue)
					count ++;
				else{
				    flag = true;
					break;
					
				}
			}
			
			if(!flag){
				if(count == 1)
					break;
				else{
					pre.next = null;
					break;
				}
			}
			else{
				if(count == 1){
					pre = pre.next;
				}
				else
					pre.next = pos;
			}			
			
		}
		
		return L.next;
    }
}
