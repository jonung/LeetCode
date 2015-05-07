package Day20150507;

 
/**
 * @ClassName: SpiralMatrixII
 * @Description: 
 * @author GongJun
 * @date 2015-5-7 下午8:29:14
 * @version V1.0  
 */

public class SpiralMatrixII {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        help(0, 0, n, n, res, 1);
        return res;
    }
	
	public void help(int startRow,int startColumn,int mRows, int nColumns,int[][] A,int count){
		
		if(mRows <= 0 || nColumns <= 0)
	        return ;
	        
		for(int i = startColumn; i < (startColumn + nColumns); i ++)
			A[startRow][i] = count++;
		
		if((startRow + 1) == (startRow + mRows)) 
		    return;
		    
		for(int i = startRow + 1; i < (startRow + mRows); i ++)
			A[i][startColumn + nColumns - 1] = count ++;
		
		for(int i = startColumn + nColumns - 2; i >= startColumn; i --)
			A[startRow + mRows - 1][i] = count ++;
		
		if( nColumns == 1)
		    return;
		
		for(int i = startRow + mRows - 2; i > startRow; i --)
			A[i][startColumn] = count ++;
		
		help(startRow + 1, startColumn + 1, mRows - 2, nColumns -2, A,count);
			
	}
}
