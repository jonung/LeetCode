package Day20150422;

import java.util.Comparator;
import java.util.PriorityQueue;

import common.ListNode;

public class MergekSortedLists {

	/*
	 * 直接的想法，两两归并排序，果然超时
	 * 
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0)
			return null;
		
		int N = lists.length;
		
		while(N > 1){
			int count  = 0;
			int i = 0;
			for(; i < N && (i + 1) < N;){
				ListNode l1 = lists[i];
				ListNode l2 = lists[i];
				
				lists[count ++] = mergeSort(l1,l2);
				i = i +2;
			}
			
			if(i < N)
				lists[count ++] = lists[i];
			
			N = count;
		}
		
		return lists[0];
    }
	
	public ListNode mergeSort(ListNode l1, ListNode l2){
		ListNode L = new ListNode(-1);
		ListNode p = L;
		
		while(l1 != null || l2 != null){
			
			if(l1 == null){
				p.next = l2;
				l2 = l2.next;
				//p = p.next;
			}	
			else if(l2 == null){
				p.next = l1;
				l1 = l1.next;
				//p = p.next;
			}
			else{
				if(l1.val < l2.val){
					p.next = l1;
					l1 = l1.next;
					
				}
				else{
					p.next = l2;
					l2 = l2.next;
				}
			}
			p = p.next;
		}
		
		return L.next;
	}
	
	/*
	 * 解法二
	 * 设数组长度为N,则维护一个长度为N的优先队列，首先把每条链表的首节点插入，
	 * 在队列不为空的情况，弹出最小的节点，将其后续的节点插入，当队列为空时就得到了所求
	 * 时间复杂度为O(cn),c为优先队列调整的时间，空间复杂度为O(N),
	 * 
	 */
	public static Comparator<ListNode> valComparator = new Comparator<ListNode>(){
		 
		@Override
		public int compare(ListNode o1, ListNode o2) {
			// TODO Auto-generated method stub
			return (o1.val - o2.val);
		}
    };
    
	public ListNode mergeKListsSolution2(ListNode[] lists) {
		if(lists == null || lists.length == 0)
			return null;
		
		ListNode L = new ListNode(-1);
		ListNode pre = L;
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,valComparator);
		for(int i = 0; i < lists.length; i ++){
			if(lists[i] != null)
				pq.add(lists[i]);
		}
		
		while(!pq.isEmpty()){
			ListNode node = pq.poll();
			pre.next = node;
			pre = pre.next;
			
			if(node.next != null)
				pq.offer(node.next);
		}
		
		return L.next;
	}

	
}
