package Day20150508;

import common.ListNode;

public class RotateList {

	public static void main(String[] args){
		System.out.println(2000000000 % 3);
	}
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0)
			return head;
		ListNode L = new ListNode(-1);
		L.next = head;
		
		ListNode p = L;
		int len = 0;
		while(p.next != null){
			len ++;
			p = p.next;
		}
			
		k = k % len;
		if(k == 0)
		    return head;
		
		ListNode fast = L;
		ListNode slow = L;
		
		while(k > 0){
			k --;
			fast = fast.next;
		}
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		
		L.next = slow.next;
		slow.next = null;
		fast.next = head;
		
		return L.next;
    }
}
