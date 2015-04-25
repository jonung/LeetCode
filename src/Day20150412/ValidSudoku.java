package Day20150412;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[9][9];
		String s1 = "..4...63.";
		String s2 = ".........";
		String s3 = "5......9.";
		String s4 = "...56....";
		String s5 = "4.3.....1";
		String s6 = "...7.....";
		String s7 = "...5.....";
		String s8 = ".........";
		String s9 = ".........";
		
		board[0] = s1.toCharArray();
		board[1] = s2.toCharArray();
		board[2] = s3.toCharArray();
		board[3] = s4.toCharArray();
		board[4] = s5.toCharArray();
		board[5] = s6.toCharArray();
		board[6] = s7.toCharArray();
		board[7] = s8.toCharArray();
		board[8] = s9.toCharArray();
		System.out.println(isValidSudoku(board));
	}
	
	/*
	 * 暴力解法
	 * 
	 */
	public static boolean isValidSudoku(char[][] board) {
		if(board == null)
			return false;
		//m X n
		
		int m = board.length;
		int n = board[0].length;
		
		//检查每一行
		System.out.println("行");
		for(int i = 0; i < m; i ++){
			int[] aux = new int[10];
			
			for(int j = 0; j < n; j ++){
				char c = board[i][j];
				if(c != '.')
					aux[Integer.parseInt(String.valueOf(c))] ++;
			}
			
			if(isDuplicated(aux))
				return false;
		}
		System.out.println("列");
		//检查每一列
		for(int i = 0; i < n; i ++){
			int[] aux = new int[10];
			
			for(int j = 0; j < m; j ++){
				char c = board[j][i];
				if(c != '.'){
					//System.out.println(c);
					aux[Integer.parseInt(String.valueOf(c))] ++;
				}
			}
			
			if(isDuplicated(aux))
				return false;
		}
		System.out.println("Don");
		//检查每一个九宫格
		int row = m / 3;
		int column = n /3;
		
		for(int i = 0; i <  row; i ++){
			for(int j = 0; j < column; j ++){
				int x = 3 * i;
				int y = 3 * j;
				int[] aux = new int[10];
				for(int in_i = x; in_i < x + 3; in_i ++){
					for(int in_j = y; in_j < y + 3; in_j ++){
						char c = board[in_i][in_j];
						if(c != '.')
							aux[Integer.parseInt(String.valueOf(c))] ++;
					}
				}
				
				if(isDuplicated(aux))
					return false;
			}
		}
		
		return true;
    }
	
	public static boolean isDuplicated(int[] aux){
		for(int i = 1; i < aux.length;i ++){
			System.out.print( aux[i] + " ");
			if(aux[i] >= 2)
				return true;
		}
		System.out.println();
		return false;
	}
}
