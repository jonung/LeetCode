package Day20150418;

import common.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        
        ListNode head = null;
        ListNode p = null;
        
        int carry = 0;
        int flag = 1;
        while(l1 != null || l2 != null){
        	
        	int val = 0;
        	if(l1 != null && l2 != null){
        		val = (l1.val + l2.val + carry) % 10;
        		carry = (l1.val + l2.val + carry) / 10;
        		l1 = l1.next;
        		l2 = l2.next;
        	}
        	else if(l1 != null){
        		val = (l1.val + carry) % 10;
        		carry = (l1.val + carry) / 10;
        		l1 = l1.next;
        	}
        	else{
        		val = (l2.val + carry) % 10;
        		carry = (l2.val + carry) / 10;
        		l2 = l2.next;
        	}
        	
        	if(flag == 1){
        		head = new ListNode(val);
        		p = head;
        		flag = 0;
        	}
        	else{
        		ListNode node = new ListNode(val);
        		p.next = node;
        		p = p.next;
        	}
        	
        }
        		
        if(carry == 1){
        	ListNode node = new ListNode(1);
        	p.next = node;
        }
        return head;
    }
	
	/*
	 * 
	 * 
	 */
	
	public ListNode addTwoNumbersModified(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode head = new ListNode(-1);//头结点，处理链表的时候最好能够借助头结点，比较方便
		ListNode pre = head;
		
		int carry = 0;
		int sum = 0;
		
		while(l1 != null || l2 != null || carry != 0){
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				
				sum += l2.val;
				l2 = l2.next;
			}
			
			if(carry == 1){
				sum += carry;
			}
			
			ListNode node = new ListNode(sum % 10);
			pre.next = node;
			pre = pre.next;
			
			carry = sum / 10;
			sum = 0;
		}
		
		return head.next;
	}
}
