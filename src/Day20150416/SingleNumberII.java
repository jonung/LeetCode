package Day20150416;

import java.util.Arrays;

public class SingleNumberII {

	/*
	 * 先排序再查找,但利用额外的空间，主要
	 */
	public int singleNumber(int[] A) {
       if(A.length == 1)
        	return A[0];
        
       Arrays.sort(A);
       
       int count = 0;
       int cusValue = A[0];
       for(int i = 0; i < A.length; i ++){
    	   if(A[i] == cusValue)
    		   count ++;
    	   else{
    		   if(count == 1)
    			   return cusValue;
    		   cusValue = A[i];
    		   count = 1;
    	   }
       }
       
       return A[A.length - 1]; //对最后一个数要特殊处理
    }
	
	
}
