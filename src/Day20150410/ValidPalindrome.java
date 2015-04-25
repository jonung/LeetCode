package Day20150410;

 
/**
 * @ClassName: ValidPalindrome
 * @Description: 
 * @author GongJun
 * @date 2015-4-10 обнГ2:42:22
 * @version V1.0  
 */

public class ValidPalindrome {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-10 обнГ2:42:22
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("1a2"));
	}
	public static boolean isPalindrome(String s) {
		if(s.length() < 2)
			return true;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i < s.length() ; i ++){
        	char c = s.charAt(i);
        	if(Character.isAlphabetic(c) || Character.isDigit(c)){
        		sb.append(Character.toLowerCase(c));
        	}
        }
        
       char[] aux = sb.toString().toCharArray();
       
       if(aux.length >= 1) {
    	   for(int i = 0; i <= aux.length / 2; i ++){
        	   if(aux[i] != aux[aux.length - i - 1])
        		   return false;
           }
       }
      
       
       return true;
    }
}
