package Day20150513;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreeInorderTraversal {

	/*
	 * iteratively method
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode top = stack.peek();
		while(top.left != null){
			stack.push(top.left);
			top = top.left;
		}
		
		while(!stack.isEmpty()){
						
			top = stack.pop();
			res.add(top.val);
			
			if(top.right != null){
				stack.push(top.right);
				top = top.right;
				
				while(top.left != null){
					stack.push(top.left);
					top = top.left;
				}
			}
		}
		
		return res;
    }
	
	/*
	 * 更简练的写法
	 * 
	 */
	public List<Integer> inorderTraversalSolution2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)	return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			if(root != null){
				stack.push(root);
				root = root.left;
			}
			else{
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
}
