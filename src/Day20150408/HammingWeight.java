package Day20150408;

 
/**
 * @ClassName: HammingWeight
 * @Description: 
 * @author GongJun
 * @date 2015-4-8 ÏÂÎç7:07:55
 * @version V1.0  
 */

public class HammingWeight {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-8 ÏÂÎç7:07:55
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		int a = 43261596;
	}
	
	public static int hammingWeight(int n) {
        int count = 0;
        while(n > 0 ){
        	if(n % 2 == 1)
        		count ++;
        	n = n / 2;
        }
        return count;
    }
	
	 public int hammingWeight1(int n) {
	        int re = 0;
	        
	        while(0 != n)
	        {
	            n = n&(n - 1);
	            ++re;
	        }

	        return re;
	    }
}
