package Day20150411;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> raw = new ArrayList<List<Integer>>();
		
		if(root == null)
			return raw;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		int numOfeachLevel = 1;
		int countForEachLevel = 0;
		
		List<Integer> item = new ArrayList<Integer>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			TreeNode first = queue.poll();
			numOfeachLevel --;
			
			item.add(first.val);
			
			
			if(first.left != null){
				queue.offer(first.left);
				countForEachLevel ++;
			}
			if(first.right != null){
				queue.offer(first.right);
				countForEachLevel ++;
			}
			if(numOfeachLevel == 0){
				raw.add(item);
				//for(int i =0; i < item.size(); i ++)
				//	System.out.println(item.get(i));
				item = new ArrayList<Integer>();
				
				numOfeachLevel = countForEachLevel;
				countForEachLevel = 0;
			}
		}
		
		return raw;
    }
}
