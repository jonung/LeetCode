package Day20150415;

import java.util.ArrayList;
import java.util.List;

 
/**
 * @ClassName: MaximumProductSubarray
 * @Description: 
 * @author GongJun
 * @date 2015-4-15 下午8:57:59
 * @version V1.0  
 */

public class MaximumProductSubarray {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-15 下午8:57:59
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(-1);
		nums.add(-2);
		nums.add(3);
		nums.add(0);
		nums.add(-4);
		//nums.add(-5);
		//System.out.println(maxProduct(nums));
		System.out.println(maxProductSolution2(nums));
	}
	
	/*
	 * 看到的第一眼就觉得应该用DP来解决。dp[i]表示以第i个数结尾的最大乘积。
	 * dp[0] = nums.get(0),
	 * 求dp[i]
	 * 1.如果当前值为0，则dp[i] = 0
	 * 2.如果当前值大于0,dp[i] = max{nums[i] ,nums[i] * dp[i- 1]}
	 * 3.如果小于0,则往前寻找第一个负数，若在查找过程中碰到值0，则直接将dp[i]设为0。否则将
	 *   找到的负数到当前值这一个字串连乘，再考虑2。
	 */
	public static int maxProduct(List<Integer> nums) {
        if(nums == null || nums.size() == 0)	return 0;
        
        if(nums.size() == 1)	return nums.get(0);
        
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        
        for(int i = 1; i < nums.size(); i ++){
        	int cusValue = nums.get(i);
        	if(cusValue > 0) {
        		if(dp[i - 1] <= 0)
        			dp[i] = cusValue;
        		else
        			dp[i] = cusValue * dp[i - 1];
        	}
        	else if(cusValue == 0){
        		dp[i] = 0;
        	}
        	else{
        		for(int m = i - 1; m >= 0; m --){
        			if(nums.get(m) == 0){
        				dp[i] = 0;
        				break;
        			}
        			else if(nums.get(m) < 0){
        				int product = 1;;
        				for(int j = m ; j <= i ; j ++){
        					product = product * nums.get(j);      					
        				}
        				
        				if(m >= 1 && dp[m - 1] > 0){
        					product *= dp[m - 1];
        				}
        				dp[i] = product;
        				
        				break;
        			}
        			
        		}
        	}
        	
        }
        
        int max = dp[0];
        for(int i = 0; i < dp.length; i ++){
        	//System.out.print(dp[i] + " ");
        	if(dp[i] > max)
        		max = dp[i];
        }
        return max;
    }
	
	/*
	 * 
	 * solution 2
	 */
	public static int maxProductSolution2(List<Integer> nums) {
		if(nums == null || nums.size() == 0)	return 0;     
        if(nums.size() == 1)	return nums.get(0);
        
        int[] max = new int[nums.size()];
        int[] min = new int[nums.size()];
        
        max[0] = nums.get(0);
        min[0] = nums.get(0);
        		
        for(int i = 1; i < nums.size(); i ++){
        	int cusValue = nums.get(i);
        	max[i] = Math.max(Math.max(cusValue * max[i -1], cusValue * min[ i -1]), cusValue);
        	min[i] = Math.min(Math.min(cusValue * min[i - 1], cusValue * max[i - 1]), cusValue);
        }
        
        for(int i = 0; i < nums.size(); i ++)
        	System.out.print(max[i] + " ");
        System.out.println();
        for(int i = 0; i < nums.size(); i ++)
        	System.out.print(min[i] + " ");
        System.out.println();
        return max[nums.size() - 1];
	}
}
