package Day20150428;

 
/**
 * @ClassName: FirstMissingPositive
 * @Description: 
 * @author GongJun
 * @date 2015-4-28 下午2:01:46
 * @version V1.0  
 */

public class FirstMissingPositive {

	public static void main(String[] args){
		int[] a = {3,4,-1,1};
		System.out.println(firstMissingPositiveModified(a));
	}
	
	public static int firstMissingPositive(int[] nums) {
        
		for(int i = 0; i < nums.length; i ++){
			if(nums[i] > nums.length || nums[i] < 0)
				nums[i] = 0;
			
		}
		
		int tmp = 0;
		for(int i = 0; i < nums.length; i ++){
			int cus = nums[i];
			
			if(cus != 0){
				if(cus != (i + 1)){
					nums[i] = 0;
					if(nums[cus -1] == cus){
						
					}
					else{
						tmp = nums[cus - 1];
						nums[cus -1] = cus;
						
					}
					
					while(tmp != 0){
						int a = nums[tmp - 1];
						if(a == tmp){
							tmp = 0;
						}
						else{
							nums[tmp -1] = tmp;
							tmp = a;
						}
						//System.out.println("tmp " + tmp);
					}
				}
			}
		}
		
		for(int i = 0; i < nums.length; i ++){
			//System.out.println(nums[i]);
			if(nums[i] == 0)
				return (i + 1);
		}
		
		return nums.length + 1;
    }
	
	/*
	 * Naive的方法肯定是sort这个数组，但那样要用O(NlongN)的时间；第二种思路是用哈希表映射，Mapping all positive integers to a hash table and iterate from 1 to the length of the array to find out the first missing one，但哈希表是O(N)的space. 那怎么做呢？

	不能开辟非常数的额外空间，就需要在原数组上操作，思路是交换数组元素，让数组中index为i的位置存放数值(i+1)。最后如果哪个数组元素违反了A[i]=i+1即说明i+1就是我们要求的第一个缺失的正数。具体操作如下：

	if A[i] is positive, say we have A[i] = x, we know it should be in slot A[x-1]! That is to say, we can swap A[x-1] with A[i] so as to place x into the right place.
	if A[i] is non-positive, 0, or A[i]>A.length, ignore it;
	if A[i] == A[A[i]-1], we do not swap, two cases, 1. Maybe A[i] = i+1, A[i]is correct; 2. though A[i] is not correct like [1, 1] index 1, but A[0] == A[1], swap A[1] with A[0] will only give rise to infinite loop
	 */
	public static int firstMissingPositiveModified(int[] nums) {
		int tmp = 0;
		for(int i = 0; i < nums.length; i ++){
			int cus = nums[i];
			if(cus <= 0 || cus > nums.length){
				nums[i] = 0;
			}
			else{
				if(cus != (i + 1)){
					nums[i] = 0;
					if(nums[cus - 1] != cus){
						tmp = nums[cus-1];
						nums[cus - 1] = cus;
					}
					
					while(tmp > 0){
						int a = nums[tmp - 1];
						if(a == tmp){
							tmp = 0;
						}
						else{
							nums[tmp -1] = tmp;
							tmp = a;
						}
						
					}
				}
			}
			
			
		}
		
		for(int i = 0; i < nums.length; i ++){
			if(nums[i] == 0)
				return (i + 1);
		}	
		return nums.length + 1;
	}
}
