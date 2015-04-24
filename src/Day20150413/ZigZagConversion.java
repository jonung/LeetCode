package Day20150413;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABC";
		System.out.println(convert(s, 2));
	}
	
	/*
	 * 此题一开始没有搞清楚题意，对最终输出对形式不弄清楚，从而导致错误。
	 * 此题按给定数字，按z字形输出，画出草图，模拟各个位置对值，找出其中的规律就比较容易求解了
	 * 
	 */
	public static String convert(String s, int nRows) {
        if(s == null || s.length() == 0 || nRows == 0)	return "";
        
        if(nRows == 1)	return s;
        
        StringBuilder sb = new StringBuilder();
        int start = 0;
        
        for(int i = 0; i < nRows; i ++){
        	start = i;
        	
        	if(i == 0 || (i != 0 && i == nRows - 1)){
        		while(start < s.length()) {
        			char c = s.charAt(start);
        			sb.append(c);
        			start = start + 2 * (nRows - 1);
        			
        		}
        	}
        	else{
        		int tag = 1;
        		while(start < s.length()){
        			char c = s.charAt(start);
        			sb.append(c);
        			
        			if(tag == 1){
        				start = start + 2 * (nRows - i - 1);
        				tag = 0;
        			}
        			else{
        				start = start + 2*nRows - 2 - 2 * (nRows - i - 1);
        				tag = 1;
        			}
        		}
        	}
        	
        }
        
        return sb.toString();
    }
}
