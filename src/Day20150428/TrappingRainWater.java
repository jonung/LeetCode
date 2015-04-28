package Day20150428;

 
/**
 * @ClassName: TrappingRainWater
 * @Description: 
 * @author GongJun
 * @date 2015-4-28 下午3:26:59
 * @version V1.0  
 */

public class TrappingRainWater {
	
	public static void main(String[] args){
		int[] a = {4,2,3};
		System.out.println(trap(a));
	}
	
	/*
	 * 本题的关键是想到通过求每个元素两侧的最大值，则每个元素对最终结果的贡献为(MIN(left,right) - height) < 0 ? 0 : MIN(left,right) - height
	 * 
	 * 这个解法需要遍历两次数组，第一遍对right数组赋值，第二遍的时候对left数组赋值，并计算每个元素的存水量
	 * 
	 */
	public static int trap(int[] height) {
		int vol = 0;
		if(height == null || height.length <= 2)
			return vol;
        int N = height.length;
        int[] left = new int[N];
        int[] right = new int[N];
        
        left[0] = height[0];
        right[N-1] = height[N-1];
        
        int max = -1;
        //向右
        for(int i = 0; i < N -1; ){
        	int maxPos = i;
        	for(int j = i; j < N; j ++){
        		if(max < height[j]){
        			max = height[j];
        			maxPos = j;
        		}
        	}
        	
        	while(i <= maxPos){
        		right[i] = max;
        		i ++;
        	}
        	max = -1;//注意清空
        }
        
        max = -1;
        for(int i = N -1; i > 0; ){
        	int maxPos = i;
        	for(int j = i; j >= 0; j --){
        		if(max < height[j]){
        			max = height[j];
        			maxPos = j;
        		}
        	}
        	
        	while(i >= maxPos){
        		left[i] = max;
        		int diff = Math.min(left[i], right[i]) - height[i];
        		if(diff >= 0){
        			vol = vol + diff;
        		}
        		i --;
        	}
        	max = -1;
        }
        
        return vol;
    }
	
	
	/*
	 * 只需遍历一遍数组，详情见收藏的笔记
	 * 
	 */
	public static int trapSolution2(int[] height) {
		int vol = 0;
		if(height == null || height.length <= 2)
			return vol;
		
		int left = 0;
		int right = height.length - 1;
		int secHigh = 0;
		
		while(left < right){
			if(height[left] < height[right]){
				secHigh = Math.max(height[left], secHigh);
				vol += secHigh - height[left];
				left ++;
			}
			else{
				secHigh = Math.max(height[right], secHigh);
				vol += secHigh - height[right];
				right --;
			}
		}
		
		return vol;
	}
	
}
