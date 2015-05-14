package Day20150514;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args){
		grayCode(3);
	}
	
	/*
	 * 枚举 + 检查
	 * 
	 */
	public static List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if(n == 0){ //为0的时候返回0
		    res.add(0);
			return res;
		}		
		int[] aux = new int[n];
		int count = (int) Math.pow(2,n);
		System.out.println("count " + count);
		res.add(array2int(aux));
		
		while(count > 1){
			//System.out.println("count " + count);
			for(int i = aux.length - 1; i >= 0; i --){
				if(aux[i] == 1)
					aux[i] = 0;
				else
					aux[i] = 1;
				
				int ele = array2int(aux);
				
				if(res.contains(ele)){
					if(aux[i] == 1)
						aux[i] = 0;
					else
						aux[i] = 1;
				}
				else{
					//System.out.println(ele);
					res.add(ele);
					count --;
					break;
				}
			}
		}
		
		return res;
    }
	
	public static int array2int(int[] aux){
		int res = aux[0];
		//System.out.print(aux[0] + "  " );
		for(int i = 1; i < aux.length; i ++){
			res = 2 * res + aux[i];
			//System.out.print(aux[i]+ "  ");
		}
		//System.out.println();
		//System.out.println(res);
		return res;
	}
	
	
	/*
	 * 递归解法
	 * 注意观察规律，
	 * 
	 * n = 2 : 0 1 3 2   size = 4;
	 * n = 3 : 0 1 3 2 6(size + 2) 7(size + 3) 5(size + 1) 4(size + 0) 
	 * 
	 */
	public static List<Integer> grayCodeSolution2(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if(n == 0){
			res.add(0);
			return res;
		}
		
		res = grayCodeSolution2(n - 1);
		int size = res.size();
		for(int i = size - 1; i >= 0; i --){
			res.add(res.get(i) + size);
		}
		
		return res;
	}

}
