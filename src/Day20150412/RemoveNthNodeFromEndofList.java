package Day20150412;

import common.ListNode;

public class RemoveNthNodeFromEndofList {
	
	/*
	 * 第一次提交出现错误，
	 *  Runtime Error Message:	Line 18: java.lang.NullPointerException
	 *	Last executed input:	{1}, 1
	 * 
	 * 为解决这个错误，对链表增加列头节点，fast指针首先移动n次，在
	 * fast和low一起移动时，判断对标准为fast.next 不为空
	 * 
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
		ListNode h = new ListNode(1);
		h.next = head;
		ListNode fast = h;
		ListNode low = h;
		
		while(n  > 0){
			fast = fast.next;
			n --;
		}
		
		while(fast.next != null){
			fast = fast.next;
			low = low.next;
		}
		
		low.next = low.next.next;
		
		return h.next;
    }
}
