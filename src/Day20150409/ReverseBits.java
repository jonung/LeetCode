package Day20150409;

 
/**
 * @ClassName: ReverseBits
 * @Description: 
 * @author GongJun
 * @date 2015-4-9 ÏÂÎç9:55:56
 * @version V1.0  
 */

public class ReverseBits {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-9 ÏÂÎç9:55:56
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(22 ));
	}
	
	public static int reverseBits(int n) {
		int result = 0;;
		int[] aux = new int[32];
		for(int i = 31; i >= 0 && n != 0; i --){
			aux[i] = n % 2;
			n = n / 2;
		}
		
		for(int i = 31; i >= 0; i --){
			result = 2*result + aux[i];
		}
		return result;
	}
	 
}
