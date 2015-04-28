package Day20150428;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args){
		int[] candidates = {1,1,1,2};
		List<List<Integer>> res = combinationSum(candidates, 2);
		System.out.println(res.size());
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return res;
		
		Arrays.sort(candidates);//排序的原因是，按一定的顺序取数据，这样就不用判断结果中是否重复，也解决了输出结果按递增输出的要求
		
		solve(res, target, candidates, 0, new ArrayList<Integer>());
		
		return res;
    }
	
	public static void solve(List<List<Integer>> res, int target,int[] candidates, int start, List<Integer> ele){
		
		
		
		for(int i = start; i < candidates.length; ){
			int a = candidates[i];
			int dupNum = 1;
			
			for(int m = 0; m < candidates.length; m ++){
				if(candidates[m] == a){
					dupNum ++;
				}
				else{
					break;
				}
			}
			
			if((target % a == 0) && (target / a < dupNum)){
				int b = target / a;
				System.out.println(i);
				i = i + dupNum -b + 1;
				System.out.println(i);
				List<Integer> l = new ArrayList<Integer>();
				l.addAll(ele);
				
				while(b > 0){
					l.add(a);
					b --;
				}
				res.add(l);
				return;
			}
			
			int newTarget = target - a;
			//System.out.println(newTarget);
			if(newTarget < 0)//小于0后，因为后面的数都是正数，所以找不到了。不加这一条会造成无限循环
				return;
			
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(ele);
			l.add(a);
			
			int newStart = i+1;
			
			
			solve(res, newTarget, candidates, newStart, l);
			i ++;
			
			
		}
	}
}
