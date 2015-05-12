package Day20150512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	/*
	 * 
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null  || nums.length == 0)
			return res;
		
		Arrays.sort(nums);
		List<Integer> path = new ArrayList<Integer>();
		for(int i = 0; i <= nums.length; i ++){
			help(res, path, nums, 0, i);
		}
		return res;
	}
	
	public void help(List<List<Integer>> res, List<Integer> path, int[] nums, int start, int level){
		if(level == 0){
			List<Integer> one = new ArrayList<Integer>(path);
			res.add(one);
			return;
		}
		
		if(start + level  > nums.length)
			return;
		
		for(int i = start; i < nums.length; i ++){
			
			path.add(nums[i]);
			help(res, path, nums, i + 1, level - 1);
			path.remove(path.size() - 1);
		}
	}
	
	/*
	 * 位向量法
	 * 对每一个值都有选和不选两种情况
	 * 
	 */
	public List<List<Integer>> subsetsSolution2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		
		help2(res, new ArrayList<Integer>(), nums, 0);
		return res;
 	}
	
	public void help2(List<List<Integer>> res, List<Integer> subset, int[] nums, int cur){
		if(cur == nums.length){
			List<Integer> one = new ArrayList<Integer>(subset);
			res.add(one);
			return;
		}
		
		subset.add(nums[cur]);
		help2(res, subset, nums, cur + 1);
		subset.remove(subset.size() - 1);
		help2(res, subset, nums, cur + 1);
	}
	
	/*
	 * 二进制表示法
	 * 
	 */
	public List<List<Integer>> subsetsSolution3(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		for(int i = 0; i < (1 << nums.length); i ++)
			help3(res, new ArrayList<Integer>(), nums, i);
		
		return res;
	}

	public void help3(List<List<Integer>> res, List<Integer> subset, int[] nums,int NO){
		for(int i = 0; i < nums.length; i ++){
			if( (NO & (1 << i) ) > 0){
				subset.add(nums[i]);
			}
		}
		
		res.add(subset);
	}
}
