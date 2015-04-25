package Day20150415;

 
/**
 * @ClassName: FindPeakElemen
 * @Description: 
 * @author GongJun
 * @date 2015-4-15 下午2:46:23
 * @version V1.0  
 */

public class FindPeakElemen {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-15 下午2:46:23
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,2,3};
		System.out.println(findPeakElementSolution2(num));
	}
	
	
	
	/*
	 * 最简单的解法，对每个元素和他相邻的元素进行比较
	 * 
	 */
	public static int findPeakElement(int[] num) {
        if(num == null || num.length == 0 )	return -1;
        
        if(num.length == 1)	return 0;
        
        for(int i = 0; i < num.length ; i ++){
        	
        	if(i == 0 ){
        		if(num[i] > num[i+1])
        			return i;
        		else
        			continue;
        	}
        	
        	if(i == num.length - 1 ){
        		if(num[i] > num[i-1])
        			return i;
        		else
        			continue;
        	}
        	
        	if(num[i] > num[i - 1] && num[i] > num[i +  1])
        		return i;
        }
        
        return -1;
    }

	/*
	 * 比解法一稍微好一些，少一些比较次数
	 * 最后发现num[i] ≠ num[i+1]， 相等的情况不用考虑
	 */
	public static int findPeakElementSolution2(int[] num) {
		if(num == null || num.length == 0 )	return -1;
        
        if(num.length == 1)	return 0;
        
        for(int i = 0; i < num.length ; i ++){
        	
        	if(i == num.length - 1){
        		if(num[i] > num[i - 1])
        			return i;
        		else
        			return -1;
        	}
        	
        	if(num[i] > num[i + 1])
        		return i;
        	else if(num[i] < num[i+1]){
        		
        	}
        	else{
        		//相等的情况，找到下一个满足a[i - 1] < a[i]的i
        		for(int j = i + 1; j < num.length ; j ++){
        			if(num[j-1] < num[j]){
        				i = j -1;
        				break;
        			}
        			else
        				i = j -1;
        		}
        	}
        }
        
        return -1;
	}
	
	/*
	 * 
	 * logn 解法
	 */
	public static int findPeakElementSolution3(int[] num) {
		return -1;
	}
}
