package Day20150411;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	/*
	 * solution 1
	 * 
	 */
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < raw.size(); i ++){
			res.add(raw.get(raw.size() - i - 1));
				
		}
		return res;
    }
	
	/*
	 * solution 2
	 * 递归解法
	 * 从跟节点开始，记录一个level值，先将本level都值存入res中，然后分别对左右节点调用函数，此时level变为
	 * level ＋ 1， 
	 * 
	 * 最终都需要对结果进行逆序处理
	 */
	public static List<List<Integer>> res = new ArrayList<List<Integer>> ();
	
	public static List<List<Integer>> levelOrderBottomSolution2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		levelTra(root, 0);
		
		for(int i = 0; i < res.size(); i ++){
			result.add(res.get(res.size() - i - 1));
				
		}
		return result;
	}
	
	public static void levelTra(TreeNode root,int level){
		if(root == null)
			return;
		
		if(level == res.size()) {
			List<Integer> item = new ArrayList<Integer>();
			res.add(item);
		}
		
		res.get(level).add(root.val);
		
		levelTra(root.left, level + 1);
		levelTra(root.right, level + 1);
		
	}
	
	
}
