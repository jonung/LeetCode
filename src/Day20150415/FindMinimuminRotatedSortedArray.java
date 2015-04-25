package Day20150415;

import java.util.ArrayList;
import java.util.List;

 
/**
 * @ClassName: FindMinimuminRotatedSortedArray
 * @Description: 
 * @author GongJun
 * @date 2015-4-15 ����3:45:22
 * @version V1.0  
 */

public class FindMinimuminRotatedSortedArray {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-15 ����3:45:22
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
	 * ��Ȼ˵д�����ˣ�������Ҫ��ͨ�����Եó������е�ϸ��û��ȥ�˽�
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
	 * ��д������ܽ�������ʽ��
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
	 * ����ͨ�õĺ���������ת������������һ��ֵ���ҵ��������±꣬û�ҵ�����-1
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
				if(nums.get(mid) > nums.get(hi)){ //mid����ߵ������
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
				else{//mid���ұߵ����
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
