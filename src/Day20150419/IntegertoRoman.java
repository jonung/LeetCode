package Day20150419;

public class IntegertoRoman {

	public static void main(String[] args){
		System.out.println(intToRoman(100));
	}
	
	/*
	 * 简单粗暴
	 */
	public static String intToRoman(int num) {
        if(num == 0)
        	return null;
        
		StringBuilder sb = new StringBuilder();
		
		while(num > 0){
			if(num / 1000 > 0){
				int a = num / 1000;
				for(int i = 0; i < a; i ++)
					sb.append("M");
				
				num = num % 1000;
			}
			else if(num / 100 > 0){
				int a = num / 100;
				//System.out.println(a);
				if(a == 9){
					sb.append("CM");
					
				}
				else if(a >= 5){
					int b = a - 5;
					sb.append("D");
					for(int i = 0; i < b; i ++)
						sb.append("C");
				}
				else if(a == 4){
					sb.append("CD");
				}
				else{
					for(int i = 0; i < a; i ++)
						sb.append("C");
				}
				num = num % 100;
			}
			else if(num / 10 > 0){
				int a = num / 10;
				if(a == 9){
					sb.append("XC");
				}
				else if(a >= 5){
					int b = a - 5;
					sb.append("L");
					for(int i = 0; i < b; i ++)
						sb.append("X");
				}
				else if(a == 4){
					sb.append("XL");
					
				}
				else{
					for(int i = 0; i < a; i ++)
						sb.append("X");
				}
				
				num = num % 10;
			}
			else{
				if(num == 9){
					sb.append("IX");
				}
				else if(num >= 5){
					sb.append("V");
					int b = num - 5;
					for(int i = 0; i < b; i ++)
						sb.append("I");
				}
				else if(num == 4){
					sb.append("IV");
				}
				else{
					for(int i = 0; i < num; i ++)
						sb.append("I");
				}
					
				num = 0;
			}
		}
		
		return sb.toString();
    }
	
	public static String intToRomanModified(int num) {
		if(num <= 0 || num > 3999)
			return null;
		
		StringBuilder sb = new StringBuilder();
		while(num > 0){
			if(num / 1000 > 0){
				int qian = num / 1000;
				for(int i =0; i < qian; i ++)
					sb.append("M");
				
				num = num % 1000;
			}
			else if(num / 100 > 0){
				int bai = num / 100;
				sb.append( convert(bai, "C", "D", "M") );
				num = num % 100;
			}
			else if(num / 10 > 0){
				int shi = num / 10;
				sb.append(convert(shi, "X", "L", "C"));
				num = num % 10;
			}
			else{
				sb.append(convert(num, "I", "V", "X"));
				num = 0;
			}
			
		}
		
		return sb.toString();
	}
	
	public static String convert(int digit,String string, String string2 ,String string3){
		StringBuilder sb = new StringBuilder();
		
		if(digit == 9){
			sb.append(string + string3);
		}
		else if(digit == 4){
			sb.append(string + string2);
		}
		else if(digit >= 5){
			int a = digit - 5;
			sb.append(string2);
			for(int i =0; i < a; i++)
				sb.append(string);
		}
		else{
			for(int i =0; i < digit; i ++)
				sb.append(string);
		}
			
		return sb.toString();
	}
}
