package Day20150508;

 
/**
 * @ClassName: UniquePaths
 * @Description: 
 * @author GongJun
 * @date 2015-5-8 下午7:55:52
 * @version V1.0  
 */

public class UniquePaths {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(1,1));
	}

	public static int uniquePaths(int m, int n) {
		if(m == 0 || n == 0 )
			return 0;
		
		if(m == 1 && n == 1)//特殊情况
			return 1;
        int p = m - 1;
        int q = m + n - 2;
        
        if(n < m)
        	p = n -1;
        
        int[] aux = new int[q + 1];
        //System.out.println("len: " + aux.length);
        aux[0] = aux[1] = 1;
        
        for(int i = 2; i <= q; i ++){
        	aux[i] = 1;
        	for(int j = i -1; j >0; j --){
        		aux[j] = aux[j] + aux[j-1];
        		
        	}
        	/*for(int j = 0; j < aux.length; j ++)
        		System.out.print(aux[j] + "  ");
        	System.out.println();*/
        }
        
        return aux[p];
    }
}
