package Day20150415;

import java.util.List;

 
/**
 * @ClassName: FindMinimuminRotatedSortedArrayII
 * @Description: 
 * @author GongJun
 * @date 2015-4-15 下午8:40:08
 * @version V1.0  
 */

public class FindMinimuminRotatedSortedArrayII {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-15 下午8:40:08
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findMin(List<Integer> nums) {
		if(nums.size() == 1)
			return nums.get(0);
		
		int l = 0;
		int h = nums.size() - 1;		
		int mid = 0;
		
		while(l != h ){
			if(nums.get(l) < nums.get(h)){
				h = l;
				continue;
			}
			if(nums.get(l) == nums.get(h)){ //相等，hi往左边移动一步，去掉一个重复的值
				h = h -1;
				continue;
			}
			mid = l + (h - l) / 2;
			if(nums.get(mid) > nums.get(h))
				l = mid + 1;
			else
				h = mid;
		}
		
		return nums.get(l);
	}
}
