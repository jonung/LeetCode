package Day20150422;

import common.ListNode;

public class SwapNodesinPairs {
	
	public ListNode swapPairs(ListNode head) {
		ListNode L = new ListNode(-1);
		L.next = head;
		
		ListNode pre = L;
		ListNode pos = head;
		
		while(pos != null){
			//处理奇数节点
			if(pos.next == null)
				break;
			
			//交换顺序
			pre.next = pos.next;
			pre = pre.next;
			
			pos.next = pre.next;
			pre.next = pos;
			
			//更新指针
			pre = pos;
			pos = pos.next;
		}
		
		return L.next;
	}
}
