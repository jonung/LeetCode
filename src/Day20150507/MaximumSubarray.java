package Day20150507;

 
/**
 * @ClassName: MaximumSubarray
 * @Description: 
 * @author GongJun
 * @date 2015-5-7 下午4:39:05
 * @version V1.0  
 */

public class MaximumSubarray {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int max = nums[0];
        int pre = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
        	pre = Math.max(nums[i], pre + nums[i]);
        	if(pre > max)
        		max = pre;
        }
        
        return max;
    }
}
