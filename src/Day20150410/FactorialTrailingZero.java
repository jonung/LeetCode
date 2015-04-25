package Day20150410;

public class FactorialTrailingZero {
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(28));
		
	}
	
	//超时
	public static int trailingZeroes(int n) {
        int count = 0;
        int x = 5;
        while(x <= n){
        	count += n / x;
        	x = x * 5;
        }
        return count;
    }
	//通过，分母每次除以5只需一次除法，除以25，125。。。会涉及多次除法运算，从而超时
	public static int solution(int n){
		int fives = 0;  
		
        while(n / 5> 0) {  
            n = n / 5;  
            fives += n;  
        }  
        return fives;
	}
}
