package Day20150427;

public class SearchInsertPosition {

	/*
	 * 
	 * 最近忙项目上线的问题，都没刷题了，睡觉前刷一刷
	 */
	public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
        	return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
        	int mid = start + (end - start) / 2;
        	if(nums[mid] == target)
        		return mid;
        	else if(nums[mid] < target){
        		start = mid + 1;
        	}
        	else{
        		end = mid - 1;
        	}
        }
        
        if(target == nums[start])
        	return start;
        else if(target < nums[start]){
        	return start;
        }
        else
        	return start + 1;
    }
}
