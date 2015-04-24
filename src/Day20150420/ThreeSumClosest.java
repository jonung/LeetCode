package Day20150420;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args){
		int[] a = {1,1,1,0};
		System.out.println(threeSumClosest(a, -100));
	}
	
	/*
	 * 此题做的时候大致思路有，但对细节的处理一直没有把握好，这导致做了好久才终于AC
	 * 1.先对数组排序
	 * 2.对每一个元素，再他的后续元素中查找满足要求的两个数，采用夹逼的原理，不断移动左指针和又指针。
	 * 每移动一次，都要判定三个数之和与target的差值的符号是否发生了转变（由+ 变为 -）；若发生了变化，则对移动前
	 * 的情况进行一次判定，更新res值。
	 * 3.此外，当移动指针使得最终start == end时，我们要判断是因为start加1使得他们相等，还是end减一使得他们相等，以此
	 * 来确定前一个状态是什么，从而对最终的结果进行一次更新。
	 * 
	 */
	public static int threeSumClosest(int[] num, int target) {
        
		if(num == null || num.length <= 2)
			return Integer.MIN_VALUE;
		
		Arrays.sort(num);
		
		int res = num[0] + num[1] + num[2];
		int diff = Math.abs(res - target);
		//System.out.println(diff + " " + res);
		int N = num.length;
		if(N == 3)
			return res;
		
		
		for(int i = 0; i < N -2; i ++){
			int first = num[i];
			
			int start = i + 1;
			int end = N - 1;
			
						
			int pre = first + num[start] + num[end] - target;
						
			while(start < end){
				int sum = first + num[start] + num[end];
				int bac = sum - target;
				
				if(sum == target)
					return target;
				else if(sum < target){
					start ++;
					if(start == end){
						pre = first + num[start - 1] + num[end] - target;
						
					}
				}
				else{
					end --;
					pre = first + num[start] + num[end + 1] -target;
									}
					
				if(pre * bac < 0){
					if(Math.abs(pre) < diff){
						diff =Math.abs(pre);
						res = target + pre;
					}
					pre = bac;
				}
			}
			
			if(Math.abs(pre) < diff){
				diff =Math.abs(pre);
				res = target + pre;
			}

			
		}
		
		return res;
    }
	
	
	/*
	 * 网上别人的解法，好像我把问题搞复杂了，对每次指针的更新直接判定其对结果的影响即可
	 * 
	 */
	public int threeSumClosestSolution2(int[] num, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
 
		Arrays.sort(num);
 
		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				int diff = Math.abs(sum - target);
 
				if(diff == 0) return 0;
 
				if (diff < min) { //每次都进行比较
					min = diff;
					result = sum;
				}
				if (sum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}
 
		return result;
	}

}
