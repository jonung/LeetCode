package Day20150409;

 
/**
 * @ClassName: RotateArray
 * @Description: 
 * @author GongJun
 * @date 2015-4-9 обнГ10:16:03
 * @version V1.0  
 */

public class RotateArray {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-9 обнГ10:16:03
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		rotate(a,4);
		for(int i = 0; i < a.length ; i ++)
			System.out.print(a[i]+" ");
	}
	
	public static void rotate(int[] nums, int k) {
		int N = nums.length;
		if(N > 1){
			int n = k % N;
			
	        reverse(nums,N - n,N-1);
	        reverse(nums,0, N - n - 1);
	        reverse(nums,0,N -1);
		}
        
    }
	
	public static void reverse(int[] nums, int begin,int end) {
		
		while(begin < end){
			int tmp = nums[begin];
			nums[begin ++] = nums[end];
			nums[end --] = tmp;
		}
		
	}
}
