package Day20150418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * O(n^2),果然超时
	 * 
	 */
	public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        
        for(int i = 0; i < numbers.length; i ++){
        	int diff = target - numbers[i];
        	
        	boolean find = false;
        	for(int j = i +1; j < numbers.length; j ++){
        		if(numbers[j] == diff){
        			find = true;
        			index[1] = j + 1;
        			break;
        		}
        	}
        	
        	if(find){
        		index[0] = i +1;
        		break;
        	}
        }
        return index;
    }
	
	/*
	 * 解法二，先排序，然后用两个指针分别从首和尾进行移动
	 * O(nlog(n) + 3n)
	 */
	public int[] twoSumSolution2(int[] numbers, int target) {
		int[] index = new int[2];
		
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		
		for(int i = 0;i < numbers.length; i ++){
			List<Integer> list = map.get(numbers[i]);
			if(list == null){
				list = new ArrayList<Integer>();
			}
			list.add(i+1);
			map.put(numbers[i],list);
			
		}
		
		Arrays.sort(numbers);
		
		int start = 0;
		int end = numbers.length - 1;
		
		while(start < end){
			int sum = numbers[start] + numbers[end];
			if(sum == target){
				break;
			}
			else if(sum < target){
				start ++;
			}
			else
				end -- ;
		}
		
		List<Integer> sl = map.get(numbers[start]);
		if(numbers[start] == numbers[end] ){
			 index[0] = sl.get(0);
			 index[1] = sl.get(1);
		}
		else{
			List<Integer> se = map.get(numbers[end]);
			if(sl.get(0) > se.get(0)){
				index[0] = se.get(0);
				index[1] = sl.get(0);
			}
			else{
				index[1] = se.get(0);
				index[0] = sl.get(0);

			}
		}
		return index;
	}
	
	/*
	 * 用map记录每个值及其对应的索引，然后遍历数组，对每一个数在map中查找 （target - numbers[i]）
	 * 结果为两个相同的值时需要注意
	 */
	public int[] twoSumSolution3(int[] numbers, int target) {
		int[] index = new int[2];
		if(numbers==null || numbers.length<2)
			return null;
		
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		
		for(int i = 0;i < numbers.length; i ++){
			List<Integer> list = map.get(numbers[i]);
			if(list == null){
				list = new ArrayList<Integer>();
			}
			list.add(i+1);
			map.put(numbers[i],list);
			
		}

		//直接查找map就行了
		for(int i = 0; i < numbers.length; i ++){
			int diff = target - numbers[i];
			if(map.containsKey(diff)){
				List<Integer> list = map.get(diff);
				if(diff == numbers[i] && list.size() >= 2){ //把if语句放到下面会增加运行时间，在有
						index[0] = list.get(0);				//多个判定条件下，灵活运用 && 操作
						index[1] = list.get(1);
						break;
					
					
				}
				
				if(diff != numbers[i]){
				
					index[0] = i+1;
					index[1] = list.get(0);
					break;
				}
			}	
		}
		
		return index;
	}
	
	
	/*
	 * 
	 * 一边插入一边查找，这解法是最优的
	 */
	public int[] twoSumSolution4(int[] numbers, int target) {
	    int[] res = new int[2];
	    if(numbers==null || numbers.length<2)
	        return null;
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    for(int i=0;i<numbers.length;i++)
	    {
	        if(map.containsKey(target-numbers[i]))
	        {
	            res[0]=map.get(target-numbers[i])+1;
	            res[1]=i+1;
	            return res;
	        }
	        map.put(numbers[i],i);
	    }
	    return null;
	}
}
