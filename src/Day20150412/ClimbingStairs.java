package Day20150412;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 
	 * DP
	 * 递推式子： f(n) = f(n-1) + f(n-2) s.t f(1) = 1; f(2) = 2
	 */
	
	public int climbStairs(int n) {
        if(n == 0)
        	return 0;
        if(n == 1)
        	return 1;
        if( n == 2 )
        	return 2;
        
        int prepre = 1;
        int pre = 2;
        for(int i = 3; i <= n;i ++){
        	int tmp = prepre + pre;
        	prepre = pre;
        	pre = tmp;
        }
        return pre;
    }
}
