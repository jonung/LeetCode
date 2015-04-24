package Day20150411;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class MinimumDepthofBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(3);
		TreeNode l3 = new TreeNode(4);
		TreeNode l4 = new TreeNode(5);
		TreeNode l5 = new TreeNode(6);
		root.left = l1;
		root.right = l2;
		l2.left = l3;
		l2.right = l4;
		l4.right = l5;
		//System.out.println(minDepth(root));
		//System.out.println(minDepthIterative(root));
		
		/*
		 * balancedBinayTree test
		 */
		
		//System.out.println(BalancedBinaryTree.isBalanced(root) );
		//System.out.println(BalancedBinaryTree.isBalancedSolution2(root));
		
		/*
		 * test for binary tree level order traversal II
		 * 
		 */
		List<List<Integer>> res = BinaryTreeLevelOrderTraversalII.levelOrderBottomSolution2(root);
		for(int i = 0; i < res.size(); i ++){
			List<Integer> item = res.get(i);
			for(int j = 0; j < item.size(); j ++)
				System.out.print(item.get(j) + " ");
			System.out.println();
		}
		
	}
	
	public static int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        
        int leftDepth ;
        int rightDepth;
        
        if(root.left != null && root.right == null)
        	return minDepth(root.left) + 1;
        else if(root.left == null && root.right != null)
        	return minDepth(root.right) + 1;
        else{
        	leftDepth = minDepth(root.left);
        	rightDepth = minDepth(root.right);
        	return leftDepth >= rightDepth ? rightDepth + 1: leftDepth + 1;
        }
        
       
    }
	
	/*
	 * 非递归解法
	 * 用类似广度搜索到方式来遍历二叉树，用到到数据结构为队列
	 * 要点是记录每一层有多少个节点，以此来判断高度是否增一
	 * 
	 */
	
	public static int minDepthIterative(TreeNode root){
		if(root == null)
			return 0;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		int depth = 1;
		int numsOfeachLevel = 1;
		int countForeachLevel = 0;
		
		while(!q.isEmpty()){
			TreeNode item = q.poll();
			
			if(item.left == null && item.right == null){
				return depth;
			}
			numsOfeachLevel --;
			
			if(item.left != null){
				q.offer(item.left);
				countForeachLevel ++;
			}
			
			if(item.right != null){
				q.offer(item.right);
				countForeachLevel ++;
			}
			
			if(numsOfeachLevel == 0) {
				depth ++;
				numsOfeachLevel = countForeachLevel;
				countForeachLevel = 0;
			}
			
		}
		
		return 0;
	}
	
	
}
