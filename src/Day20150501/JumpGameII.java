package Day20150501;

public class JumpGameII {

	public static void main(String[] args){
		int[] a = {1,1};
		System.out.println(jump(a));
	}
	
	
	public static int jump(int[] nums) {
        if(nums.length == 1){
        	return 0;
        }
        
        int max = nums[0];
        int pre = nums[0];
        int jump = 1;
        for(int i = 1; i < nums.length; ){
        	        	
        	if(max >= nums.length - 1)
        		return jump;
        	jump ++;
        	
        	int j = i;
        	for(; j <= pre; j ++){
        		max = Math.max(max, j + nums[j]);
        		
        	}
        	
        	pre = max;
        	i = j;
 
        }
        
        return jump;
    }
}
