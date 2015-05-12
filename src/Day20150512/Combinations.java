package Day20150512;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	/*
	 * Time limited Exceeded
	 * 
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n < k )
			return res;
		List<Integer> path = new ArrayList<Integer>();
		
		boolean transfer = false;
		if(k > (n - k)){
			transfer = true;
			k = n - k;
		}
		
		help(res, path, n, k,1);
		
		if(transfer){
			List<List<Integer>> resss = new ArrayList<List<Integer>>();
			for(int i = 0 ; i < res.size(); i ++){
				List<Integer> one = res.get(i);
				int[] nums = new int[n];
				for(int j = 0; j < k; j ++)
					nums[one.get(j) - 1] = 1;
				
				one.clear();
				
				for(int j = 0; j < nums.length; j ++)
					if(nums[j] == 0){
						one.add(j + 1);
					}
				resss.add(one);
			}
			
			return resss;
		}
		else
			return res;
    }
	
	public void help(List<List<Integer>> res, List<Integer> path, int n, int level,int start){
		if(level == 0){
			List<Integer> one = new ArrayList<Integer>(path);
			res.add(one);
			return;
		}
		
		for(int i = start; i <= n ;i ++){
			
			path.add(i);
			
			help(res, path, n, level - 1,start + 1);
			
			path.remove(path.size() - 1);
			
		}
	}
	
}
