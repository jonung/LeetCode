package Day20150512;

public class RemoveDuplicatesfromSortedArrayII {

	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        
        int count = 1;
        int curVal = nums[0];
        
        int step = 0;
        int len = 1;
        for(int i = 1; i < nums.length ; i ++){
        	if(nums[i] == curVal){
        		if(count == 2){
        			step ++;
        			continue;
        		}
        		else{
        			nums[i-step] = nums[i];
        			count ++;
        			len ++;
        		}
        	}
        	else{
        		nums[i-step] = nums[i];
        		curVal = nums[i];
        		count  = 1;
        		len ++;
        	}
        }
        	
        return len;
    }
}
