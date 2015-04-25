package Day20150411;

import common.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        
        if(root.val == sum && root.left == null && root.right == null) {
        	return true;
        }
        
        boolean leftFind = hasPathSum(root.left, sum - root.val);
        boolean rightFind = hasPathSum(root.right, sum - root.val);
        
        if(leftFind || rightFind)
        	return true;
        else
        	return false;
    }
}
