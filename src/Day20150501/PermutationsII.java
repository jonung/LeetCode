package Day20150501;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		//res.add(new ArrayList<Integer>());
		if(nums == null || nums.length == 0)
			return res;
        
		List<Integer> collect = new ArrayList<Integer>();
		for(int i : nums)
			collect.add(i);
		
		solve(res, new ArrayList<Integer>(), collect);
		
		return res;
    }
	
	public static void solve(List<List<Integer>> res, List<Integer> ele, List<Integer> collect){
		
		if(collect.isEmpty()){
			res.add(new ArrayList<Integer>(ele));
			//System.out.println("add one");
			return;
		}
		
		HashSet<Integer> hs = new HashSet<Integer>();//用来去重
		
		for(int i = 0; i < collect.size(); i ++){
			int cur = collect.get(i);
			
			if(!hs.contains(cur)){
				hs.add(cur);
				
				ele.add(cur);
				collect.remove(i);
				//System.out.println(ele.size());
				solve(res,ele,collect);
				
				ele.remove(ele.size() - 1);
				collect.add(i, cur);
			}
		}
		
	}
	
}
