package Day20150428;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args){
		int[] candidates = {1,1,1,2};
		List<List<Integer>> res = combinationSum2(candidates, 2);
		System.out.println(res.size());
		for(int i = 0; i < res.size(); i ++){
			List<Integer> l = res.get(i);
			for(int j = 0; j < l.size(); j ++){
				System.out.print(l.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * 这个题和combiationSum一样，只不过多了一个限制，每个元素只能取一次。对重复元素的判断是关键。
	 * 做的时候，一直在想能不能和上一题一样，不用去判断res.contains(ele)，再DFS的过程自动完成这个处理，结果折腾了半天都没弄出来。网上的答案果然很简单
	 * 
	 * 
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return res;
		
		Arrays.sort(candidates);//排序的原因是，按一定的顺序取数据，这样就不用判断结果中是否重复，也解决了输出结果按递增输出的要求
		
		solve(res, target, candidates, 0, new ArrayList<Integer>());
		
		return res;
    }
	
	public static void solve(List<List<Integer>> res, int target,int[] candidates, int start, List<Integer> ele){
		
		if(target == 0){
			if(!res.contains(ele))
				res.add(ele);
			return;
		}
		
		for(int i = start; i < candidates.length; i ++){
			
			int cus = candidates[i];
			int newTarget = target - cus;
			if(newTarget < 0)
				break;
			
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(ele);
			l.add(cus);
			solve(res, newTarget, candidates, i + 1, l);
		}
	}
}
