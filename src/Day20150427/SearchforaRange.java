package Day20150427;

public class SearchforaRange {

	public static void main(String[] args){
		int[] a = {0,0,1,1,22};
		int[] aux = searchRangeSolution2(a, 23);
		
		for(int i = 0; i < aux.length; i ++)
			System.out.println(aux[i]);
	}
	
	
	/*
	 * 
	 * 思路：用二分查找找到一个target位置，然后向左向右拓展
	 * 想法简单，但是时间复杂度达不到log(n)的要求
	 * 
	 */
	public static int[] searchRange(int[] nums, int target) {
       int[] res = new int[2];
       res[0] = res[1] = -1;
       if(nums == null || nums.length == 0){
    	      	   return res;
       }
       
       int start = 0;
       int end = nums.length - 1;
       int pos = -1;
       
       while(start <= end){
    	   int mid = start + (end - start) / 2;
    	   if(nums[mid] == target){
    		   pos = mid;
    		   break;
    	   }
    	   else if(nums[mid] < target){
    		   start = mid + 1;
    	   }
    	   else{
    		   end = mid - 1;
    	   }
       }
       
       if(pos != -1){
    	   System.out.println("pos : "+ pos);
    	   for(int i = pos; i >= 0; i --){
    		   if(i == 0 && nums[i] == target){//最左边的情况
    			   res[0] = 0;
    			   break;
    		   }
    		   
    		   if(nums[i] != target){
    			   res[0] = i + 1;
    			   break;
    		   }
    	   }
    	   
    	   for(int i = pos; i < nums.length; i ++){
    		   if(i == nums.length - 1 && nums[i] == target){ //最右边的情况
    			   res[1] = nums.length - 1;
    			   break;
    		   }
    			   
    		   if(nums[i] != target){
    			   res[1] = i - 1;
    			   break;
    		   }
    	   }
       }
    	   
       
       return res;
    }
	
	
	public static int[] searchRangeSolution2(int[] nums, int target) {
		int[] res = new int[2];
	    res[0] = res[1] = -1;
	    if(nums == null || nums.length == 0){
	    	return res;
	    }
	       
	    int start = 0;
	    int end = nums.length - 1;
	    
	    int pos = -1;
	    while(start <= end){
	    	int mid = start + (end - start) / 2;
	    	   if(nums[mid] == target){
	    		   pos = mid;
	    		   break;
	    	   }
	    	   else if(nums[mid] < target){
	    		   start = mid + 1;
	    	   }
	    	   else{
	    		   end = mid - 1;
	    	   }
	    }
	    
	    if(pos == -1)
	    	return res;
	    res[0] = findLeft(0,pos - 1,target,nums);
	    res[1] = findRight(pos + 1,nums.length - 1,target,nums);
	    
	    return res;
	}
	
	
	public static int findLeft(int start,int end,int target,int[] nums){
		if(end < 0)
			return end + 1;
		
		int pos = end + 1;;
		while(start <= end  && end >= 0){
			int mid = start + (end - start) / 2;
	    	if(nums[mid] == target){
	    		pos = mid;
	    		end = pos - 1;
	    	}
	    	
	    	if(nums[mid] < target){
	    		start = mid + 1;
	    	}
		}
		
		return pos;
	}
	
	public static int findRight(int start,int end,int target,int[] nums){
		if(start >= nums.length){
			return start - 1;
			
		}
		
		int pos = start - 1;
		while(start <= end  && start < nums.length){
			int mid = start + (end - start) / 2;
	    	if(nums[mid] == target){
	    		pos = mid;
	    		start = mid + 1;
	    	}
	    	
	    	if(nums[mid] > target){
	    		end = mid - 1;
	    	}
		}
		
		return pos;

		
	}
}
