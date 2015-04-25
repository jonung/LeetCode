package Day20150410;

 
/**
 * @ClassName: ExcelSheetColumnTitle
 * @Description: 
 * @author GongJun
 * @date 2015-4-10 ÏÂÎç1:03:57
 * @version V1.0  
 */

public class ExcelSheetColumnTitle {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-10 ÏÂÎç1:03:57
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(1));
	}
	
	public static String convertToTitle(int n) {
       StringBuilder sb = new StringBuilder();
      
       while(n > 0){
    	   int k = (n - 1 ) % 26;
    	   sb.append((char)('A' + k));
    	   n = (n - 1) / 26;
       
    	   
       }
       
       StringBuilder res = new StringBuilder();
       for(int i = 0; i < sb.toString().length(); i ++) {
    	   res.append(sb.toString().charAt(sb.toString().length() - i - 1));
       }
       return res.toString();
    }
}
