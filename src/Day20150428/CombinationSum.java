package Day20150428;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	/*
	 * DFS
	 * 1.先对candidates排序，保证按递增序选取元素
	 * 2.i = start， 每次选取元素的起始点为上一次选取的元素，这样就不用来判重了
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return res;
		
		Arrays.sort(candidates);//排序的原因是，按一定的顺序取数据，这样就不用判断结果中是否重复，也解决了输出结果按递增输出的要求
		
		solve(res, target, candidates, 0, new ArrayList<Integer>());
		
		return res;
    }
	
	public void solve(List<List<Integer>> res, int target,int[] candidates, int start, List<Integer> ele){
		if(target == 0){
			res.add(ele);
			return;
		}
		
		for(int i = start; i < candidates.length; i ++){
			int a = candidates[i];
			int newTarget = target - a;
			if(newTarget < 0)//小于0后，因为后面的数都是正数，所以找不到了。不加这一条会造成无限循环
				return;
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(ele);
			l.add(a);
			
			solve(res, newTarget, candidates, i, l);
		}
	}
}
