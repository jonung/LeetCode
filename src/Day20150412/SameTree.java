package Day20150412;

import common.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		else if(p == null || q == null){
			return false;
		}
		else{
			if(p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
				return true;
			}
			else
				return false;
		}
	}
}
