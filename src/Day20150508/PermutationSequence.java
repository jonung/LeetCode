package Day20150508;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args){
		System.out.println(getPermutation(3, 4));
		
	}
	
	public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
             
        int[] nums = new int[n];
        for(int i = 0; i < n; i ++)
        	nums[i] = i +1;
        while(k-- > 1)
        	nextPermutation(nums);
        
        for(int i = 0; i < n; i ++)
        	sb.append(nums[i]);
        return sb.toString();
    }
	
	public static void nextPermutation(int[] num) {
        
		int pos = -1;
		for(int i = num.length - 1; i > 0; i --){
			if(num[i-1] < num[i]){
				pos = i-1;
				break;
			}
		}
		//System.out.println(num[pos]);
		if(pos == -1){
			for(int i = 0; i <= ( num.length -1 )/ 2 / 2; i ++){
				int tmp = num[i];
				num[i] = num[num.length -1 - i];
				num[num.length - i - 1] = tmp;
			}
		}
		else{
			
			for(int i = num.length - 1; i > pos; i --){
				if(num[i] > num[pos]){
					int tmp = num[i];
					num[i] = num[pos];
					num[pos] = tmp;
					break;
				}
			}
			//System.out.println(num[pos]);
			for(int i = pos +1; i <= (pos + 1 + num.length - 1) / 2; i ++){
				int tmp = num[i];
				num[i] = num[num.length - i + pos];
				num[num.length + pos - i ] = tmp;
			}
		}
    }

}
