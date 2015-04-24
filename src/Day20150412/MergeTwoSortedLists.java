package Day20150412;

import common.ListNode;

public class MergeTwoSortedLists {
	
	/*
	 * 
	 * 归并排序思想,新建一个头节点，每次选区两条链表中最小的元素
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        
        if(l2 == null)
        	return l1;
        
        ListNode head = new ListNode(1);
        ListNode pre = head;
        ListNode p = l1;
        ListNode q = l2;
        
        while(p != null && q != null){
        	if(p.val <= q.val){
        		pre.next = p;
        		p = p.next;
        	}
        	else{
        		pre.next = q;
        		q = q.next;
        		
        	}
        	pre = pre.next;
        		
        		
        }
        
        while(p != null){
        	pre.next = p;
        	p = p.next;
        	pre = pre.next;
        }
        
        while(q != null){
        	pre.next = q;
        	q = q.next;
        	pre = pre.next;
        }
        
        return head.next;
    }
	
	/*
	 * solution 2
	 * 解法二 是利用插入排序的思想，以一个链表为基准，将第二个链表中的元素一个个插入其中
	 */
	
	public ListNode mergeTwoListsSolution2(ListNode l1, ListNode l2) {
		if(l1 == null)	return l2;
		if(l2 == null) 	return l1;
		
		ListNode head = new ListNode(1);
		head.next = l1;
		ListNode pre = head;
		
		while(l2 != null && l1 != null){
			if(l1.val <= l2.val){
				l1 = l1.next;
				
			}
			else{
				ListNode insertNode = l2;
				l2 = l2.next;
				
				insertNode.next = pre.next;
				pre.next = insertNode;
				
			}
			
			pre = pre.next;
		}
		
		if(l2 != null)
			pre.next = l2;
		return head.next;
	}
	
}
