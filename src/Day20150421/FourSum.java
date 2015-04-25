package Day20150421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	/*
	 * 在3sum 外面再套一个循环
	 * 
	 */
	public List<List<Integer>> fourSum(int[] num, int target) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Arrays.sort(num);
		int N = num.length;
		
		for(int i = 0; i < N - 3; i ++){
			if(i == 0 || num[i] > num[i - 1]){
				int newTarget = target - num[i];
				for(int j = i + 1; j < N -2; j ++){
					if(j == i + 1 || num[j] > num[j-1]){
						int newnewTarget = newTarget - num[j];
						
						int start = j + 1;
						int end = N -1;
						
						while(start < end){
							int sum = num[start] + num[end];
							if(sum == newnewTarget){
								List<Integer> l = new ArrayList<Integer>();
								l.add(num[i]);
								l.add(num[j]);
								l.add(num[start]);
								l.add(num[end]);
								res.add(l);
								start ++;
								end --;
								
								while(start < end && num[start] == num[start - 1])
									start ++;
								
								while(start < end && num[end] == num[end + 1])
									end --;
							}
							else if(sum < newnewTarget){
								start ++;
							}
							else{
								end --;
							}
						}
					}
				}
				
			}
		}
		
		return res;
    }
}
