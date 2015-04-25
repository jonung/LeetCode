package Day20150415;

import java.util.ArrayList;
import java.util.List;

 
/**
 * @ClassName: FindMinimuminRotatedSortedArray
 * @Description: 
 * @author GongJun
 * @date 2015-4-15 下午3:45:22
 * @version V1.0  
 */

public class FindMinimuminRotatedSortedArray {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-15 下午3:45:22
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(3);
		a.add(1);
		a.add(3);
		//a.add(4);
		//System.out.println(findValue(a, 6));
		System.out.println(findMin(a));
	}
	
	/*
	 * 虽然说写出来了，但是主要是通过调试得出，其中的细节没有去了解
	 */
	public static int findMin(List<Integer> nums) {
		if(nums.size() == 1)
			return nums.get(0);
		
		int start = 0;
		int end = nums.size() - 1;
		
		int mid = 0;
		while(start < end){
			
			if(nums.get(start) < nums.get(end)){
				return nums.get(start);
			}
			else{
				mid = start + (end - start) / 2;
				if(nums.get(mid) >= nums.get(start)) {
					start = mid + 1;
				}
				else{
					if(nums.get(mid) > nums.get(mid - 1))
						end = mid - 1;
					else
						start = mid;
				}
				mid = start + (end - start) / 2;
			}
			
		}
		return nums.get(mid);
	}
	
	/*
	 * 重写，最好能将问题形式化
	 */
	public static int findMinRewrite(List<Integer> nums) {
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
			mid = l + (h - l) / 2;
			if(nums.get(mid) > nums.get(h))
				l = mid + 1;
			else
				h = mid;
		}
		
		return nums.get(l);
	}
	
	/*
	 * 更加通用的函数，在旋转的数组中任意一个值，找到返回其下标，没找到返回-1
	 * 
	 */
	public static int findValue(List<Integer> nums , int value){
		if(nums == null || nums.size() == 0)
			return -1;
		
		if(nums.size() == 1){
			return nums.get(0) == value ? 0 : -1;
		}
		
		int lo = 0;
		int hi = nums.size() - 1;
		int mid = 0;
		
		while(lo <= hi){
			mid = lo + (hi - lo) / 2;
			int midValue = nums.get(mid);
			
			if(nums.get(mid) == value)
				return mid;
			
			if(nums.get(lo) < nums.get(hi)){
				if(nums.get(mid) > value){
					hi = mid - 1;
				}
				else
					lo = mid + 1;
			}
			else{
				if(nums.get(mid) > nums.get(hi)){ //mid在左边的情况，
					if(value > midValue){
						lo = mid + 1;
					}
					else{
						if(value > nums.get(hi)){
							hi = mid - 1;
						}
						else{
							lo = mid + 1;
						}
					}
				}
				else{//mid在右边的情况
					if(value < midValue){
						hi = mid - 1;
					}
					else{
						if(value < nums.get(hi)){
							lo = mid + 1;
						}
						else{
							hi = mid -1;
						}
					}
				}
			}
			
		}
		
		return -1;
	}
}
