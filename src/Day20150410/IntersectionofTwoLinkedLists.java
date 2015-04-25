package Day20150410;

import common.ListNode;

 
/**
 * @ClassName: IntersectionofTwoLinkedLists
 * @Description: 
 * @author GongJun
 * @date 2015-4-10 ÏÂÎç2:05:02
 * @version V1.0  
 */

public class IntersectionofTwoLinkedLists {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-10 ÏÂÎç2:05:02
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		f.next = c;
		
		ListNode res = getIntersectionNode2(a,f);
		System.out.println(res.val);
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA == null || headB == null)
			return null;
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while(a != null){
        	lenA ++;
        	a = a.next;
        }
        
        while(b != null){
        	lenB ++;
        	b = b.next;
        }
        
        int k = Math.abs(lenA - lenB);
        
        if(lenA > lenB) {
        	a = headA;
        	b = headB;
        }
        else{
        	a = headB;
        	b = headA;
        }
        
        while(k > 0){
        	a= a.next;
        	k --;
        }
        
        while(a != null && b != null) {
        	if(a == b)
        		return a;
        	
        	a = a.next;
        	b = b.next;
        }
        
        return null;
    }
	
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		
		ListNode a = headA;
		ListNode b = headB;
		
		while(true){
			if(a == b)
				return a;
			a = a.next;
			b = b.next;
			
			if(a == null && b != null)
				a = headB;
			
			if(a != null && b == null)
				b = headA;
			
			if(a == null && b == null)
				break;
		}
						
		return null;
	}
}
