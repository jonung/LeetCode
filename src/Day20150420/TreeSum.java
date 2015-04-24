package Day20150420;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TreeSum {

	public static void main(String[] args){
		int[] num = {-1,-1,-1,-1,0,1,1,2,2};
		threeSum(num);
		for(int i = 0; i < res.size(); i ++){
			List<Integer> l = res.get(i);
			for(int j = 0; j < l.size(); j ++)
				System.out.print(l.get(j) + " ");
			System.out.println();
		}
	}
	
	
	/*
	 * 第一遍做的时候大致思想是对，但在遇到重复的三元组时不知道如何处理
	 * 
	 */
	public static List<List<Integer>> res = new ArrayList<List<Integer>>();
	
		
	public static List<List<Integer>> threeSum(int[] num) {
		
		if(num == null || num.length < 3)	return res;
		
		Arrays.sort(num);
		int N = num.length;
		
		
				
		
		for(int i = 0; i < N - 2; i ++){
			
			if(i == 0 || num[i] > num[i -1]){//处理重复的三元组
				int sum = - num[i];
			
				findTwoNums(num, i +1, N - 1, sum);
			}
			
			
		}
		
		
		
		return res;
    }
	
	public static void findTwoNums(int[] num, int start ,int end, int value){
		while(start < end){
			int tmp = num[start] + num[end];
			if(tmp == value){
				List<Integer> triplet = new ArrayList<Integer>();
				triplet.add(-value);
				triplet.add(num[start]);
				triplet.add(num[end]);
				res.add(triplet);
				
				start ++;
				end --;
				
				//处理重复的三元组
				while(start < end && num[end] ==  num[end + 1])
					end --;
				
				while(start < end && num[start] == num[start - 1] )
					start ++;
				
				//
			}
			else if(tmp < value) {
				start ++;
			}
			else{
				end --;
			}
		}
		
	}
}
