package Day20150430;

 
/**
 * @ClassName: JumpGame
 * @Description: 
 * @author GongJun
 * @date 2015-4-30 下午4:49:15
 * @version V1.0  
 */

public class JumpGame {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,1,1,4};
		System.out.println(canJumpSolution2(a));
	}

	/*
	 * 1.可以向两个方向跳么？
	 * 2.maximum jump length
	 * 
	 * 超时
	 */
	public static boolean canJump(int[] nums) {
		int N = nums.length;
		
        boolean[] flag = new boolean[N];
        
        for(int i = 0; i < N; i ++){
        	if((i + nums[i]) >= N - 1)
        		flag[i] = true;
        }
        
        if(flag[0])
        	return true;
        
        boolean changed = true;

        while(changed){
        	changed = false;
        	
        	for(int i = N - 2; i >= 0; i --){
        		if(!flag[i]){
        			if(isThisTrue(flag, i, nums[i])){
        				flag[i] = true;
        				changed = true;
        				
        			}
        		}
        	}
        	
        	if(flag[0]){
        		return true;
        	}
        }
        
        return false;
    }
	
	
	public static boolean isThisTrue(boolean[] a, int pos, int jump){
		for(int i = pos - jump; i < pos + jump; i ++){
			if(i >= 0 && i < a.length){
				if(a[i]){
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/*
	 * DFS 还是超时，看来有巧妙的解法
	 * 
	 */
	public static boolean canJumpSolution2(int[] nums) {
		return solve(0, nums);		
	}
	
	public static boolean solve(int start,int[] nums){
		if((start + nums[start]) >= nums.length -1){
			return true;
		}
		
		for(int i = 1; i <= nums[start]; i ++){
			if(solve(start + i, nums)){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * DP
	 * 
	 */
	public static boolean canJumpSolution3(int[] nums) {
		if(nums.length == 1)
	        return true;
		
		int global = 0;
		for(int i = 0; i < nums.length -1 && i <= global; i ++){
			global = Math.max(global, i + nums[i]);
			if(global >= nums.length - 1)
				return true;
		}
		
		return false;
		
	}
}
