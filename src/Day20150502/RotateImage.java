package Day20150502;

public class RotateImage {

	public static void main(String[] args){
		int[][] a = {{1,2},{3,4}};
		rotate(a);
		
		for(int i = 0; i < a.length; i ++){
			for(int j = 0; j < a.length; j ++)
				System.out.print(a[i][j] + " ");
			
			System.out.println();
		}
	}
	
	/*
	 * 
	 * naive solution
	 */
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int[][] res = new int[n][n];
		
		for(int i = 0; i < n; i ++){
			for(int  j = 0; j < n; j ++){
				res[i][j] = matrix[n-1-j][i];
			}
		}
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < n; j ++)
				matrix[i][j] = res[i][j];
		
	}
}
