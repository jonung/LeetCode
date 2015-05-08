package Day20150508;

 
/**
 * @ClassName: UniquePathII
 * @Description: 
 * @author GongJun
 * @date 2015-5-8 下午8:21:59
 * @version V1.0  
 */

public class UniquePathII {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null)
			return 0;
		
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] aux = new int[m][n];
        
        if(obstacleGrid[0][0] == 0)
        	aux[0][0] = 1;
        
        for(int i = 1; i < n; i ++){
        	if(obstacleGrid[0][i] == 0)
        		aux[0][i] = aux[0][i-1];
        	
        }
        
        for(int i = 1; i < m; i ++)
        	if(obstacleGrid[i][0] == 0)
        	aux[i][0] = aux[i-1][0];
        
        for(int i = 1; i < m ; i ++){
        	
        	for(int j = 1; j < n; j ++){
        		if(obstacleGrid[i][j] == 1){
        			aux[i][j] = 0;
        		}
        		else{
        			aux[i][j] = aux[i -1 ][j] +  aux[i][j-1];
        		}
        		 
        	}
        }
        
        return aux[m-1][n-1];
    }
}
