package Day20150415;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		
		if(root == null)	return res;
        
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int numOfeachLevel = 1;
        int countOfeachLevel = 0;
        
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	numOfeachLevel --;
        	
        	if(node.left != null){
        		queue.offer(node.left);
        		countOfeachLevel ++;
        	}
        	
        	if(node.right != null){
        		queue.offer(node.right);
        		countOfeachLevel ++;
        		
        	}
        	
        	if(numOfeachLevel == 0){
        		res.add(node.val);
        		numOfeachLevel = countOfeachLevel;
        		countOfeachLevel = 0;
        	}
        	
        }
        return res;
    }
}
