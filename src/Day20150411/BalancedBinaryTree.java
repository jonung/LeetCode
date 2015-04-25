package Day20150411;

import common.TreeNode;

public class BalancedBinaryTree {
	
	/*
	 * 解法一
	 * 普通递归解法
	 */
	public static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		
		if(Math.abs( maxDepthOfTree(root.left) - maxDepthOfTree(root.right) ) > 1) 
			return false;
		
		else{
			
			if(isBalanced(root.left) && isBalanced(root.right))
				return true;
			else
				return false;
		}
	}
	
	public static int maxDepthOfTree(TreeNode root){
		if(root == null)
			return 0;
		
		int leftDepth = maxDepthOfTree(root.left);
		int rightDepth = maxDepthOfTree(root.right);
		
		return leftDepth >= rightDepth ? leftDepth + 1 : rightDepth + 1;
	}
	
	/*
	 * 解法二
	 * 解法一首先通过比较两棵子树点高度是否满足要求，然后再递归判断左子树，右子树是否满足要求
	 * 在这个过程中需要频繁调用求树点高度，存在重复计算。
	 * 
	 * 而本解法中巧妙点运用负数（不仅仅是为－1）来标志子树已经不是平衡二叉树。将子树中点结果训练传递到跟节点，
	 * 从而达到减少计算量。
	 */
	public static boolean isBalancedSolution2(TreeNode root){
		if(root == null)
			return true;
		
		if(checkBanlance(root) == -1)
			return false;
		else
			return true;
		
	}
	
	public static int checkBanlance(TreeNode root){
		if(root == null)
			return 0;
		
		int leftHeight = checkBanlance(root.left);
		int rightHeight = checkBanlance(root.right);
		
		if(Math.abs(rightHeight - leftHeight) > 1)
			return -1;
		
		if(leftHeight == -1 || rightHeight == -1){
			return -1;
		}
		else{
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
