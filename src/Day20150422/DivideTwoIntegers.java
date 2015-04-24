package Day20150422;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -2147483648;
		int b = -2147483647;
		//System.out.println(b - a);
		System.out.println(divide(-2147483648, 2));
	}

	public static int divide(int dividend, int divisor) {
		if(divisor == 0)
			return Integer.MAX_VALUE;
		
		if(dividend == 0)
			return 0;
		
		boolean negative = false;
		int res = 0;
		if(dividend < 0 && divisor > 0){
			divisor = -divisor;
			negative = true;
		}
		else if(dividend > 0 && divisor < 0){
			dividend = -dividend;
			negative = true;
		}
		else if(dividend > 0 && divisor > 0){
			dividend = -dividend;
			divisor = -divisor;
		}
		
		if(divisor == -1){
			int tmp = -dividend;
			if(tmp < 0)
				return Integer.MAX_VALUE;
			else{
				res = tmp;
				return res;
			}
		
		}
		
		if(dividend > divisor)
			return 0;
		else{
			int chushu = divisor;
			int count = 1;
			while(dividend <= divisor){
				res = res + count;
				dividend = dividend - divisor;
				divisor = divisor + divisor;
				count = count + count;
				
				while(dividend > divisor && divisor < chushu){
					divisor = divisor - chushu;
					count --;
				}
				
				
			}
			
			
		}
		
		
		
		if(negative) {
			return -res;
		}
		else{
			return res;
		}
	}
	
	
}
