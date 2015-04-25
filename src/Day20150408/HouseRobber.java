package Day20150408;

 
/**
 * @ClassName: HouseRobber
 * @Description: 
 * @author GongJun
 * @date 2015-4-8 обнГ3:37:11
 * @version V1.0  
 */

public class HouseRobber {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-8 обнГ3:37:11
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1,1,2};
		System.out.println(rob(a));
	}

	public static int rob(int[] num) {
        int N = num.length; 
        if(N == 0)
        	return 0;
        if(N == 1)
        	return num[N - 1];
        
        int d0 = num[0];
        int d1 = max(num[0],num[1]);
        for(int i = 2; i < N; i ++){
        	int cur = max(d1,d0 + num[i]);
        	d0 = d1;
        	d1 = cur;
        }
        
        return d1;
    }
	
	public static int max(int a, int b){
		if(a >= b)
			return a;
		else
			return b;
	}
}
