package Day20150512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
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
			if(i > start && nums[i] == nums[i - 1]) continue;
			else{
				path.add(nums[i]);
				help(res, path, nums, i + 1, level - 1);
				path.remove(path.size() - 1);
			}
			
		}
	}
}
