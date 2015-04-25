package Day20150416;

public class SingleNumber {

	/*
	 * 超时，在最坏情况下可能会达到O(n^2),还学改进
	 */
	public int singleNumber(int[] A) {
		if(A.length == 1)
			return A[0];
		
		int fill = A[0];
		
		for(int i = 0; i < A.length ; i ++){
			
			if(i != 0 && A[i] == fill){
				continue;
			}
			
			int pair = -1;
			for(int j = i + 1; j < A.length; j ++){
				if(A[j] == A[i]){
					pair = j;
					break;
				}
			}
			
			if(pair == -1){
				return A[i];
			}
			else{
				A[i] = A[pair] = fill;
			}
		}
		
		return -1;
    }
	
	/*
	 * 这个程序用了个小技巧：一个整数和它本身异或之后得到值是0，0与其他整数异或得到的是这个整数本身
	 * 
	 */
	public int singleNumberSolution2(int[] A) {
		return -1;
	}

}
