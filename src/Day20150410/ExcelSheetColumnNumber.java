package Day20150410;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("AC"));
	}
	

	
	public static int titleToNumber(String s) {
	    int res = 0;
	    int N = s.length();
	    for(int i = 0; i < N; i ++){
	    	char c= s.charAt(i);
	    	int num = (int)(c - 'A' + 1);
	    	res = 26 * res + num;
	    }
	    
	    return res;
	}
}
