package Day20150511;

 
/**
 * @ClassName: SetMatrixZeros
 * @Description: 
 * @author GongJun
 * @date 2015-5-11 下午4:27:59
 * @version V1.0  
 */

public class SetMatrixZeros {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 空间复杂度为O(m + n)
	 * 
	 */
	public void setZeroes(int[][] matrix) {
        if(matrix == null)
        	return;
        int m = matrix.length;
        int n= matrix[0].length;
        
        int[] row = new int[m];
        int[] column = new int[n];
        
        for(int i = 0; i < m; i ++){
        	for(int j = 0; j < n; j ++){
        		if(matrix[i][j] == 0){
        			row[i] = 1;
        			column[j] = 1;
        		}
        	}
        }
        
        for(int i = 0; i < m; i ++){
        	if(row[i] == 1){
        		for(int j = 0; j < n; j ++)
        			matrix[i][j] = 0;
        	}
        }
        
        for(int j = 0; j < n; j ++){
        	if(column[j] == 1){
        		for(int i = 0; i < m; i ++)
        			matrix[i][j] = 0;
        	}
        }
    }
	
	/*
	 * 
	 * 空间复杂度为O(1)
	 * 
	 */
	
	public void setZeroesSolution2(int[][] matrix) {
		if(matrix == null)
        	return;
		
		boolean firstRow = false;
		boolean firstColumn = false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		for(int i = 0; i < m; i ++)
			for(int j = 0; j < n; j ++){
				if(i == 0 && matrix[i][j] == 0) firstRow = true;
				if(j == 0 && matrix[i][j] == 0)	firstColumn =true;
				
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		
		for(int i = 1; i < m; i ++){
			for(int j = 1; j < n; j ++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}
		
		if(firstRow){
			for(int j = 0; j < n; j ++)
				matrix[0][j] = 0;
		}
		
		if(firstColumn){
			for(int i = 0;i < m; i ++)
				matrix[i][0] = 0;
		}
	}
}
