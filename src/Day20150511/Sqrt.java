package Day20150511;

 
/**
 * @ClassName: Sqrt
 * @Description: 
 * @author GongJun
 * @date 2015-5-11 下午3:04:38
 * @version V1.0  
 */

public class Sqrt {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(0));
	}
	
	/*
	 * 
	 * naive solution 
	 * Time limit Exceeded
	 */
	public static int mySqrt(int x) {
        int res = 0;
		while(true){
			if(res * res <= x){
				res ++;
			}
			else{
				return res - 1;
			}
		}
    }

	/*
	 * 1.二分查找
	 * 2.牛顿迭代法
	 * 
	 */
	public static int mySqrtSolution2(int x) {
		return 0;
	}
	
}
