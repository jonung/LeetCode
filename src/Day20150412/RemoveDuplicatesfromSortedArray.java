package Day20150412;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {1,1,2,2,3,3,4,4,5};
		//int n = removeDuplicates(A);
		//for(int i)
			//System.out.println(i);
	}
	
	
	public static int removeDuplicates(int[] A) {
		if(A ==null || A.length == 0)
			return 0;
		
		int cusValue = A[0];
		int start = 1;
		for(int i = 1; i < A.length; i ++){
			if(A[i] != cusValue){
				A[start ++] = A[i];
				cusValue = A[i];
			}
				
		}
		
		return start;
    }
}
