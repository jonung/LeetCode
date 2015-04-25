package Day20150415;

import java.util.Stack;

import common.TreeNode;

/*
 * 
 * 一次过
 */
public class BSTIterator {

	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		
		TreeNode p = root;
		while(p != null){
			stack.push(p);
			p = p.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		 if(stack.isEmpty())
			 return false;
		 else
			 return true;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if(node.right != null){
			TreeNode p = node.right;
			while(p != null){
				stack.push(p);
				p = p.left;
			}
		}
		
		return node.val;
	}
}
