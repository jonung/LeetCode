package Day20150511;

 
/**
 * @ClassName: Searcha2DMatrix
 * @Description: 
 * @author GongJun
 * @date 2015-5-11 下午3:51:49
 * @version V1.0  
 */

public class Searcha2DMatrix {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,1}};
		System.out.println(searchMatrix(a, 2));
	}

	/*
	 * 这道题在2015.5.5 微软面试三面的时候被问到，当时没有答上来。
	 * 太可惜了，就差这么几天，要是把这道题做了，结果可能不一样了。
	 * 
	 * 
	 */
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null)
			return false;
		
        return finder(matrix, 0, matrix[0].length - 1, target);
    }
	
	public static boolean finder(int[][] matrix, int startRow, int startColumn,int target){
		
		if(startRow == matrix.length - 1 && startColumn == 0){//边界条件，左下角最后一个点
			if(matrix[startRow][startColumn] == target)
				return true;
			else
				return false;
		}
		
		int newStartRow = -1,newStartColumn = -1;
		
		for(int i = startColumn; i >= 0; i --){
			if(matrix[startRow][i] == target)
				return true;
			
			if(matrix[startRow][i] < target){
				newStartColumn = i;
				break;
			}
		}
		
		if(newStartColumn == -1){//边界条件 这一行都比target大，直接返回false
			return false;
		}
		
		for(int i = startRow; i < matrix.length; i ++){
			if(matrix[i][newStartColumn] == target)
				return true;
			
			if(matrix[i][newStartColumn] > target){
				newStartRow = i;
				break;
			}
		}
		
		if(newStartRow  == -1) // 边界条件 这一列都比target小，直接返回false
			return false;
		
		return finder(matrix,newStartRow,newStartColumn,target); //递归求解子问题 
		
	}
}
