package Day20150411;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class MaximumDepthofBinaryTree {
	
	/*
	 * 
	 * 递归解法见BalancedBinaryTree.maxDepthOfTree(root)
	 */
	
	
	
	/*
	 * 
	 * solution 2
	 */
	public int maxDepth(TreeNode root) {
		
		if(root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		int level = 0;
		int numofeachLevel = 1;
		int countForeachLevel = 0;
		
		while(!q.isEmpty()){
			TreeNode first = q.poll();
			numofeachLevel --;
			
			if(first.left != null){
				q.offer(first.left);
				countForeachLevel ++;
			}
			
			if(first.right != null){
				q.offer(first.right);
				countForeachLevel ++;
			}
				
			if(numofeachLevel == 0){
				numofeachLevel = countForeachLevel;
				countForeachLevel = 0;
				level ++;
			}
			
		}
		
		return level;
	}
}
