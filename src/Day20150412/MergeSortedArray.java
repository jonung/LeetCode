package Day20150412;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[1000];
		int m = 3;
		A[0] = 4;
		//for(int i = 0; i < m; i ++)
		//	A[i] = i;
		int[] B = {6,5,4,3,2,1};
		
		
		merge(A,1,B,B.length);
		for(int i = 0; i < m + B.length ; i++)
			System.out.print(A[i] + " ");
	}
	
	/*
	 * 分析： 有序数组没有指明是递增对还是递减的
	 * 
	 */
	public static void merge(int A[], int m, int B[], int n) {
        if(n == 0)
        	return;
        	
        if(m == 0){
        	for(int i = 0; i < n; i ++)
        		A[i] = B[i];
        	return ;
        }
		
        if(m == 1 && n == 1){
        	//默认是递增序列
        	if(A[0] > B[0]) {
        		A[1] = A[0];
        		A[0] = B[0];
        	}
        	else{
        		A[1] = B[0];
        	}
        	return;
        }
        
        boolean flag = true; //flag为true表示是递增，为false表示递减
        
        if(m > 1){
        	flag = (A[m - 1] > A[0]) ? true : false; 
        }
        else{
        	flag = (B[n - 1] > B[0]) ? true : false; 
        }
     
        if(flag) {
        	//序列是递增序列
        	if(A[m - 1] <= B[0]){
        		for(int i = 0; i < n; i ++)
        			A[m + i] = B[i];
        	}
        	
        	if(A[0] >= B[n - 1]) {
        		for(int i = 0; i < m; i ++)
        			A[n + i] = A[i];
        		
        		for(int i = 0; i < n; i ++)
        			A[i] = B[i];
        	}
        	else{
        		int a = m - 1;
        		int b = n - 1;
        		int count = 0;
        		
        		while(a >= 0 && b>= 0){
        			if(A[a] >= B[b]) {
        				A[m + n -1 - count] = A[a];
        				a --;
        			}
        			else{
        				A[m + n - 1 - count] = B[b];
        				b --;
        			}
        			count ++;
        		}
        		
        		while(a >= 0) {
        			A[m + n - 1 - count] = A[a];
        			a -- ;
        			count ++;
        		}
        		
        		while(b >= 0){
        			A[m + n - 1 - count] = B[b];
        			b --;
        			count ++;
        		}
        	}
        }else{
        	//序列是递减序列
        	if(A[m - 1] >= B[0]){
        		for(int i = 0; i < n; i ++)
        			A[m + i] = B[i];
        	}
        	
        	if(A[0] <= B[n - 1]) {
        		for(int i = 0; i < m; i ++)
        			A[n + i] = A[i];
        		
        		for(int i = 0; i < n; i ++)
        			A[i] = B[i];
        	}
        	else{
        		int a = m - 1;
        		int b = n - 1;
        		int count = 0;
        		while(a >= 0 && b>= 0){
        			if(A[a] <= B[b]) {
        				A[m + n -1 - count] = A[a];
        				a --;
        			}
        			else{
        				A[m + n - 1 - count] = B[b];
        				b --;
        			}
        			count ++;
        		}
        		
        		while(a >= 0) {
        			A[m + n - 1 - count] = A[a];
        			a -- ;
        			count ++;
        		}
        		
        		while(b >= 0){
        			A[m + n - 1 - count] = B[b];
        			b --;
        			count ++;
        		}
        	}
        }
    }
}
