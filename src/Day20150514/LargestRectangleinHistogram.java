package Day20150514;

public class LargestRectangleinHistogram {

	/*
	 * naive solution
	 * 时间复杂度为O(n^2)
	 * 
	 * 超时
	 */
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		
		int max = -1;
		int N = height.length;
		
		for(int i = 0; i < N; i ++){
			int cur = height[i];
			int count = 1;
			
			for(int j = i -1; j >= 0; j --){
				if(height[j] >= cur)
					count ++;
				else{
					break;
				}
			}
			
			for(int j = i + 1; j < N; j ++){
				if(height[j] >= cur)
					count ++;
				else
					break;
			}
			
			if(max < cur * count)
				max = cur * count;
		}
		
		return max;
    }
	
	public static int largestRectangleAreaSolution2(int[] height) {
		if(height == null || height.length == 0){
			return 0;
		}
		
		int N = height.length;
		int max = -1;
		
		int[] left = new int[N]; //左边比height[i]大的
		int[] right = new int[N]; //右边比height[i]大的
		left[0] = 0;
		right[N-1] = 0;
		
		for(int i = N-2; i >= 0; i --){
			if(height[i] <= height[i+1]){
				int j = i + 1;
				right[i] = 0;
				while(height[i] < height[j] && j < N){
					right[i] += 1;
					j++;
				}
				
				if(height[i] == height[j])
					right[i] = right[i] + right[j] + 1;
				
			}
			else{
				right[i] = 0;
			}
		}
		
		for(int i = 0; i < N; i ++){
			if(i == 0){
				left[i] = 0;
			}
			else{
				left[i] = 0;

				if(height[i] <= height[i-1]){
					int j = i -1;
					while(height[i] < height[j] && j >= 0){
						left[i] += 1;
						j --;
					}
					
					if(height[i] == height[j])
						left[i] = left[i] + left[j] + 1;
				}
				

			}
						
			max = Math.max(max, height[i] * (left[i] + 1 + right[i]));
		}
		
		
		return max;
	}
}
