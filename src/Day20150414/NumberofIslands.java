package Day20150414;

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = new char[3][3];
		//System.out.println(grid.length);
		grid[0] = "111".toCharArray();
		grid[1] = "010".toCharArray();
		grid[2] = "111".toCharArray();
		//grid[3] = "00011".toCharArray();
		
		System.out.println(numIslands(grid));
		/*
		for(int i = 0; i < grid.length; i ++){
			for(int j = 0; j < grid[0].length; j ++)
				System.out.print(grid[i][j] + " ");
		
			System.out.println();
		}
		*/
 	}
	
	/*
	 * 正确解法，以后再遇到这种探索性的题时，要自然的想到用递归来做
	 * 
	 */
	public static int numIslands(char[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0)	
			return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		
		for(int i = 0; i < m; i ++){
			
			for(int j = 0; j < n; j ++){
				if(grid[i][j] != '1')
					continue;
				else{
					count ++;
					modifyArray(grid, i, j);
				}
			}
		}
		
		return count;
	}
	
	public static void modifyArray(char[][] grid, int i, int j){
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)	return;
		
		if(grid[i][j] != '1')	
			return;
		
		grid[i][j] = '2';
		
		modifyArray(grid, i - 1, j);
		modifyArray(grid, i + 1, j);
		modifyArray(grid, i, j - 1);
		modifyArray(grid, i, j + 1);
	}
	
	/*
	 * 
	 * 错误解法
	 */
	public static int numIslandsMistake(char[][] grid) {
        if(grid == null || grid.length == 0)	return 0;
        
        int count = 0;
        int m = grid.length;
        
        int	n= grid[0].length;
        
        for(int i = 0; i < m; i ++){
        	for(int j = 0; j < n; j ++){
        		if(grid[i][j] == '1') {
        			count ++;
        			//System.out.println(count);
        			char c = (char) (count + '1');
        			grid[i][j] = c;
        			//System.out.println(c);
        			
        			for(int in_j = j + 1; in_j < n; in_j ++){
        				
        				if(grid[i][in_j] == '1'){
        					if(grid[i][in_j - 1] == c)
        						grid[i][in_j] = c;
        				}
        				
        			}
        			
        			for(int in_i = i + 1; in_i < m; in_i ++){
        				for(int in_j = 0; in_j < n ; in_j ++){
        					
        					if(grid[in_i][in_j] == '1'){
        						if( ((in_i - 1 >= 0) && grid[in_i - 1][in_j] == c) || 
        								((in_j - 1 >= 0 ) && grid[in_i][in_j - 1] == c))
        							
        							grid[in_i][in_j] = c;
        						
        						
        					}
        					
        				}
        			}
        			/*
        			for(int x_i = 0; x_i < grid.length; x_i ++){
        				for(int x_j = 0; x_j < grid[0].length; x_j ++)
        					System.out.print(grid[x_i][x_j] + " ");
        			
        				System.out.println();
        			}
        			
        			System.out.println();
        			*/
        			i = -1;
        			break;
        		}
        	}
        }
        
        return count;
    }
}
