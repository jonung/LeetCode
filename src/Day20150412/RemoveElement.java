package Day20150412;

public class RemoveElement {
	
	public static void main(String[] args) {
		int[] A = {1,3,2,11,1,5,6,1};
		int size = removeElement(A, 1);
		System.out.println(size);
		
		for(int i = 0; i < size; i ++)
			System.out.print(A[i] + " ");
	}
	
	
	public static int removeElement(int[] A, int elem) {
		if(A == null || A.length == 0)
			return 0;
	  
		int hits = 0;
		for(int i = 0; i < A.length; i ++){
			if(A[i] == elem)
				hits ++;
			else 
				A[i - hits] = A[i];
		}
	  
		return A.length - hits;
  }
}
