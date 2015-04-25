package Day20150422;

import common.ListNode;

public class ReverseNodesinkGroup {
	
	public static void main(String[] args){
				
		ListNode l = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		l.next = l1;
		l1.next = l2;
		l = reverseKGroup(l, 2);
		while(l != null){
			System.out.println(l.val);
			l = l.next;
		}
	}
	@SuppressWarnings("null")
	public static ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode L = new ListNode(-1);
		L.next = head;
		
		ListNode fast = L;
		ListNode low = L;
		
		ListNode pos = head;
		ListNode tail = null;
		
		int count = k;
		while(count > 0 && fast != null){
			fast = fast.next;
			count --;
		}
		
		
		while(fast != null){
			
			low.next = null;
			while(count < k){
				ListNode tmp = pos;
				pos = pos.next;
				
				tmp.next = low.next;
				low.next = tmp;
				
				if(tail == null)
					tail = tmp;
				
				count ++;
			}
			
			fast = tail;
			tail.next = pos;
			
			tail = null;
			
			while(count > 0 && fast != null){
				fast = fast.next;
				low = low.next;
				count --;
			}
		}
		
		return L.next;
	}
}
