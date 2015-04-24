package Day20150412;

import java.util.LinkedList;
import java.util.Queue;
import common.TreeNode;

public class SemmtricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * solution 1
	 * 递归解法
	 * 
	 */
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
        	return true;
        
        return isSymmetric(root.left, root.right);
    }
	
	public boolean isSymmetric(TreeNode p, TreeNode q) {
		if(p == null)
			return q == null;
		
		if(q == null)
			return p == null;
		
		if(p.val == q.val){
			return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
		}
		else
			return false;
    }
	
	
	/*
	 * solution 2
	 * 迭代解法
	 * 广度遍历节点对两棵子树，一一进行比较
	 * 
	 */
	 
	 
	 public boolean isSymmtricSolution2(TreeNode root){
		 if(root == null)
			 return true;
		 
		 if(root.left == null && root.right != null)
			 return false;
		 
		 if(root.left != null && root.right == null)
			 return false;
		 
		 if(root.left == null && root.right == null)
			 return true;
		 
		 Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		 Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
		 
		 leftQueue.offer(root.left);
		 rightQueue.offer(root.right);
		 
		 while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			 TreeNode left = leftQueue.poll();
			 TreeNode right = rightQueue.poll();
			 
			 if(left.val != right.val) 
				 return false;
			 else{
				 
				 if((left.left == null) ^ (right.right == null)) //异或运算，减少书写
					 return false;
				 
				 
				 if(left.left != null && right.right != null){
					 leftQueue.offer(left.left);
					 rightQueue.offer(right.right);
				 }
				 //
				 if((left.right == null) ^ (right.left == null))
					 return false;
				 
				 if(left.right != null && right.left != null){
					 leftQueue.offer(left.right);
					 rightQueue.offer(right.left);
				 }
					 
			 }
		 }
		
		 return true;
	 }
}
