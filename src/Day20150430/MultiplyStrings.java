package Day20150430;

 
/**
 * @ClassName: MultiplyStrings
 * @Description: 
 * @author GongJun
 * @date 2015-4-30 下午2:46:14
 * @version V1.0  
 */

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11";
		String b = "21";
		//System.out.println(add("12345", "246900"));
		System.out.println(multiply(a, b));
		System.out.println(multiplySolution2(a,b));
	}
	
	
	/*
	 * 手动模拟乘法运算
	 * 1.乘
	 * 2.加
	 */
	public static String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0")
        	return "0";
        
        String beiChengshu = num1;
        String chengshu = num2;
        
        if(num1.length() < num2.length() ){
        	beiChengshu = num2;
        	chengshu = num1;
        }
        
        String res = "0";
        for(int i = chengshu.length() - 1; i >= 0; i --){
        	char c = chengshu.charAt(i);
        	//System.out.println(c);
        	String tmp = multiplyOne(beiChengshu, c);
        	//System.out.println(tmp);
        	for(int j = i; j < chengshu.length() - 1; j ++)
        		tmp = tmp + "0";
        	
        	
        	res = add(res, tmp);
        	
        	//System.out.println(res);
        }
        
        return res;
    }
	
	public static String multiplyOne(String s,char c){
		if(c == '0')
			return "0";
		
		int carry = 0;
		String[] aux = new String[s.length()];
		for(int i = s.length() - 1; i >= 0; i --){
			int value = s.charAt(i) - '0';
			value = value * (c - '0') + carry;;
			
			aux[i] = String.valueOf(value % 10);
			carry = value / 10;
		}
		
		StringBuilder sb = new StringBuilder();
		if(carry != 0)
			sb.append(carry);
		
		for(int i = 0 ; i < aux.length; i ++)
			sb.append(aux[i]);
		
		return sb.toString();
	}
	
	public static String add(String num1,String num2){
		if(num1 == null || num1.length() == 0)
			return num2;
		if(num2 == null || num2.length() == 0)
			return num1;
		
		if(num1 == "0")
			return num2;
		
		if(num2 == "0")
			return num1;
		
		int N1 = num1.length();
		int N2 = num2.length();
		
		String[] res = new String[Math.max(N1, N2)];
		int carry = 0;
		
		int count = 1;
		
		while((N1 - count) >=0  || (N2 - count) >= 0){
			//System.out.println("carry " + carry);
			if((N1 - count) >= 0 && (N2 - count) >= 0){
				int tmp = num1.charAt(N1 - count) - '0' + num2.charAt(N2 - count) - '0';
				
				tmp = tmp + carry;
				
				res[res.length - count] = String.valueOf( tmp % 10 );
				carry = tmp / 10;
				
				
			}
			else if((N1 - count) >= 0){
				if(carry == 0){
					res[res.length - count] = String.valueOf( num1.charAt(N1 - count) );
				}
				else{
					int tmp = num1.charAt(N1 - count) - '0' + carry;
					res[res.length - count] = String.valueOf( tmp % 10 );
					carry = tmp / 10;
				}
			}
			else{
				if(carry == 0){
					res[res.length - count] = String.valueOf( num2.charAt(N2 - count) );
				}
				else{
					int tmp = num2.charAt(N2 - count) - '0' + carry;
					res[res.length - count] = String.valueOf( tmp % 10 );
					carry = tmp / 10;
				}
			}
			
			count ++;
		}
		
		StringBuilder sb = new StringBuilder();
		if(carry != 0)
			sb.append(String.valueOf(carry));
		
		for(int i = 0; i < res.length; i ++)
			sb.append(res[i]);
		
		return sb.toString();
	}
	
	/*
	 * 上面的解法比较naive，代码很长，还有更加巧妙的方法
	 * 这种解法可以这么理解，不同位上的数对最终结果的贡献。
	 * 比如说123 * 45
	 * 对个位有贡献只能是3 * 5,对十位有贡献的是3 * 4 和2 * 5，对百位有贡献是1 * 5和2 * 4
	 * 
	 */
	public  static String multiplySolution2(String num1, String num2) {
		if(num1 == "0" || num2 == "0")
        	return "0";
		
		int n1 = num1.length();
		int n2 = num2.length();
		int[] aux = new int[n1 + n2];
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		
		for(int i = 0; i < n1; i ++){
			int a = num1.charAt(i) - '0';
			for(int j = 0; j < n2; j ++){
				int b = num2.charAt(j) - '0';
				aux[i + j] += a * b;
			}
		}
		
		for(int i = 0; i < aux.length; i ++){
			int value = aux[i];
			//System.out.println(value);
			aux[i] = value % 10;
			if(i != aux.length - 1)
				aux[i+1] = aux[i+1] + value / 10;
		}
		
		int pos = aux.length;
		for(int j = aux.length - 1; j >= 0; j --){
			if(aux[j] != 0){
				pos = j;
				break;
			}
		}
		
		if(pos == aux.length)
			return "0";
		else{
			StringBuilder sb = new StringBuilder();
			for(int i = pos; i >= 0; i --){
				sb.append(String.valueOf(aux[i]));
				
			}
			return sb.toString();
		}
		
	}
}
