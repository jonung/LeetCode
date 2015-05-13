package Day20150513;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class UniqueBinarySearchTreesII {

	/*
	 * 递归解法
	 * 对1~n选取 i作为根节点，求左子树（1~i-1）和右子树 (i+1 ~ n)的解法
	 * 
	 */
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(n == 0)	{ //注意空节点
            TreeNode zero = null;
            res.add(zero);
            return res;
        }
        if(n == 1){
        	TreeNode root = new TreeNode(1);
        	res.add(root);
        	return res;
        }
        return help(1,n);
    }
	
	public List<TreeNode> help(int from, int to){
		List<TreeNode> res = new ArrayList<TreeNode>();
		
		if(from == to){
			TreeNode single = new TreeNode(from);
			res.add(single);
			return res;
		}
		
		if(from > to){//注意空节点
		    TreeNode zero = null;
		    res.add(zero);
			return res;
		}
		
		for(int i = from; i <= to; i ++){
			
			List<TreeNode> left = help(from,i-1);
			List<TreeNode> right = help(i+1,to);
			
			for(int li = 0; li < left.size(); li ++){
				
				for(int ri = 0; ri < right.size(); ri ++){
					TreeNode root = new TreeNode(i); //每种情况的root都是新new的
					
					TreeNode leftRoot = left.get(li); //可以存在一个节点有多个引用指向它
					root.left = leftRoot;
					
					TreeNode rightRoot = right.get(ri);
					root.right = rightRoot;
					
					res.add(root);
				}
			}
		}
		
		return res;
	}
}
