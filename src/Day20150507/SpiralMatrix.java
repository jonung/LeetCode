package Day20150507;

import java.util.ArrayList;
import java.util.List;

 
/**
 * @ClassName: SpiralMatrix
 * @Description: 
 * @author GongJun
 * @date 2015-5-7 下午4:43:29
 * @version V1.0  
 */

public class SpiralMatrix {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
        	return res;
        help(res, 0, 0, matrix.length, matrix[0].length, matrix);
        return res;
    }
	
	public void help(List<Integer> res, int startRow,int startColumn,int mRows, int nColumns,int[][] A){
		
		if(mRows <= 0 || nColumns <= 0)
	        return ;
	        
		for(int i = startColumn; i < (startColumn + nColumns); i ++)
			res.add(A[startRow][i]);
		
		if((startRow + 1) == (startRow + mRows)) 
		    return;
		    
		for(int i = startRow + 1; i < (startRow + mRows); i ++)
			res.add(A[i][startColumn + nColumns - 1]);
		
		for(int i = startColumn + nColumns - 2; i >= startColumn; i --)
			res.add(A[startRow + mRows - 1][i]);
		
		if( nColumns == 1)
		    return;
		for(int i = startRow + mRows - 2; i > startRow; i --)
			res.add(A[i][startColumn]);
		
		help(res, startRow + 1, startColumn + 1, mRows - 2, nColumns -2, A);
			
	}
}
