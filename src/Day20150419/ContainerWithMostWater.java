package Day20150419;

public class ContainerWithMostWater {

	/*
	 * 超时
	 */
	public int maxArea(int[] height) {
       if(height == null || height.length <= 1)
    	   return 0;
       
       int max = 0;
       for(int i = 0; i < height.length - 1; i ++){
    	   for(int j = i + 1; j < height.length ; j ++){
    		   int area = (j - i) * Math.min(height[i], height[j]);
    		   if(area > max)
    			   max = area;
    	   }
       }
       
       return max;
    }
	
	
	
}
