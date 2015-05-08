package Day20150508;

 
/**
 * @ClassName: ValidNumber
 * @Description: 
 * @author GongJun
 * @date 2015-5-8 下午9:06:47
 * @version V1.0  
 */

public class ValidNumber {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("2e00"));
	}

	/*
	 * 合法字符串示例: ".1"  "01"  "3." "2e0" "-1."
	 * 不合法例子：".e1"
	 */
	public static boolean isNumber(String s) {
        if(s == null)
        	return false;
        
        s = s.trim();
        if(s.length() == 0)
        	return false;
        
        char[] array = s.toCharArray();
        int countDot = 0;
        int countE = 0;
        		
        if(s.length() == 1 && s == ".")
        	return false;
        
        for(int i = 0; i < array.length; i ++){
        	char c = array[i];
        	if( i == 0 && (c == '+' || c == '-'))
        		continue;
        	
        	if(isValidChar(c)){
        		if(c == '.'){
        			if(countDot == 1) // ..
        				return false;
        			countDot ++;
        			
        			if(i >0 && (array[i-1] == '+' || array[i-1] == '-')) //+. -.
        				return false;
        			
        			if(i == 0 && (i+1) == array.length) //.
        				return false;
        		}
        		
        		if(c == 'e' || c == 'E'){
        			if(countE == 1)
        				return false;
        			countE ++;
        			if(i >0 && (array[i-1] == '+' || array[i-1] == '-')) //+e -e
        				return false;
        			
        			if(i == 0 ) //e
        				return false;
        		}
        		
        		
        	}
        	else
        		return false;
        	
        }
        
        return true;
    }
	
	public static boolean isValidChar(char c){
		if(c >= '0' && c <= '9')
			return true;
		
		if(c == '.' || c == 'e' || c == 'E')
			return true;
		
		return false;
		
	}
}
