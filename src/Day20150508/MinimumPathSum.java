package Day20150508;

 
/**
 * @ClassName: MinimumPathSum
 * @Description: 
 * @author GongJun
 * @date 2015-5-8 下午8:35:23
 * @version V1.0  
 */

public class MinimumPathSum {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid) {
        if(grid == null)
        	return 0;
        
		int m = grid.length;
		int n = grid[0].length;
		
		for(int i = 1; i < n; i ++)
			grid[0][i] = grid[0][i-1] + grid[0][i];
		
		for(int j = 1; j < m; j ++)
			grid[j][0] = grid[j-1][0] + grid[j][0];
		
		for(int i = 1; i < m; i ++)
			for(int j = 1; j < n; j ++){
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
			
		return grid[m-1][n-1];
    }
}
