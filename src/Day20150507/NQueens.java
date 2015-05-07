package Day20150507;

import java.util.ArrayList;
import java.util.List;

 
/**
 * @ClassName: NQueens
 * @Description: 
 * @author GongJun
 * @date 2015-5-7 下午2:40:52
 * @version V1.0  
 */

public class NQueens {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> res = solveNQueensRightAnswer(2);
		for(int i = 0 ; i < res.size(); i ++){
			String[] ss = res.get(i);
			for(int j = 0; j < ss.length; j ++)
				System.out.print(ss[j] + "   ");
			
			System.out.println();
		}
		
	}

	/*
	 * 
	 * 这题犯了一个比较严重的错误，没有弄清楚皇后的走法，皇后可以横着走，竖着走，斜着走，
	 * 而我却错误的认为和“车”的走法一样，只能横着走和竖着走

	 */
	public static List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
			
		if(n == 0)
			return res;
		if(n == 1){
			String[] ele = {"Q"};
			res.add(ele);
			return res;
		}
		
		List<String> one = new ArrayList<String>();
		boolean[] flag = new boolean[n];
		for(int i = 0; i < flag.length; i ++)
			flag[i] = true;
		
		help(res, n, one, flag, n);
		return res;
		
    }
	
	public static void help(List<String[]> res, int level, List<String> path, boolean[] flag,int len){
		if(level == 0){
			String[] ele = list2StringArray(path);
					
			res.add(ele);
			return;
		}
		
		char[] row = new char[len];
		for(int i = 0; i < row.length;i ++)
			row[i] = '.';
		
		for(int i = 0; i < flag.length; i ++){
			if(flag[i]){
				
				flag[i] = false;
				
					
				row[i] = 'Q';
				
				path.add(charArray2String(row));
				
				help(res, level - 1, path, flag, len);
				
				flag[i] = true;
				row[i] = '.';
				path.remove(path.size() - 1);
			}
		}
	}
	
	public static String[] list2StringArray(List<String> l){
		String[] s = new String[l.size()];
		for(int i = 0; i < l.size(); i ++){
			s[i] = l.get(i);
		}
		return s;
	}
	
	public static String charArray2String(char[] c){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < c.length; i ++)
			sb.append(c[i]);
		
		return sb.toString();
		
	}
	
	public static List<String[]> solveNQueensSolution2(int n) {
		List<String[]> res = new ArrayList<String[]>();
		
		if(n == 0)
			return res;
		if(n == 1){
			String[] ele = {"Q"};
			res.add(ele);
			return res;
		}
		
		char[] ele = new char[n];
		for(int i = 0; i < ele.length; i ++)
			ele[i] = '.';
		String[] base = new String[n];
		String[] path = new String[n];
		boolean[] flag = new boolean[n];
		
		for(int i = 0; i < n; i ++){
			ele[i] = 'Q';
			base[i] = charArray2String(ele);
			ele[i] = '.';
			
			flag[i] = true;
		}
		
		
		
		helpSolution2(res, base, path, n, flag);
		return res;
	}
	
	public static void helpSolution2(List<String[]> res, String[] base,String[] ele,int level,boolean[] flag){
		if(level == 0){
			String[] newEle = new String[ele.length];
			for(int i = 0; i < newEle.length; i ++)
				newEle[i] = ele[i];
					
			res.add(newEle);
		}
		
		for(int i = 0; i < flag.length; i ++){
			if(flag[i]){
				
					
				flag[i] = false;
				
				ele[i] = base[i];
				
				helpSolution2(res, base, ele, level - 1, flag);
				
				flag[i] = true;
				
			}
		}
	}
	
	
	
	/*
	 * 
	 * 正确解法
	 */
	public int totalNQueens(int n) {
        return solveNQueensRightAnswer(n).size();
    }
	
	public static List<String[]> solveNQueensRightAnswer(int n){
		List<String[]> res = new ArrayList<String[]>();
		
		
		int[] pos = new int[n];//皇后的位置为(i,pos[i])
		solveNQueensHelper(res,0,pos);
		
		return res;
	}
	
	public static void solveNQueensHelper(List<String[]> res, int row,int[] pos){
		if(row == pos.length){
			String[] ele = new String[pos.length];
			for(int i =0; i < pos.length; i ++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < row; j ++){
					if(j == pos[i])
						sb.append('Q');
					else
						sb.append('.');
				}
				ele[i] = sb.toString();
			}
			res.add(ele);
			return;
		}
		
		for(int i = 0; i < pos.length; i ++){
			pos[row] = i;
			if(!isValid(row,pos)){
				continue;
			}
			
			solveNQueensHelper(res, row + 1, pos);
			
		}
	}
	
	public static boolean isValid(int row, int[] pos){
		for(int i = 0; i < row; i ++){
			if(pos[i] == pos[row])
				return false;
			
			if(Math.abs(row - i) == Math.abs(pos[row] - pos[i]))
				return false;
		}
		
		return true;
	}
}
