package Day20150425;

 
/**
 * @ClassName: NextPermutation
 * @Description: 
 * @author GongJun
 * @date 2015-4-25 下午9:15:35
 * @version V1.0  
 */

public class NextPermutation {

	public static void main(String[] args){
		int[] num = {1,2,3};
		nextPermutation(num);
		for(int i = 0; i < num.length; i ++)
			System.out.print(num[i] + " ");
	}
	
	/*
	 * 看了会题目，没看懂到底要做什么。查答案知道原来是求下一个排列。
	 * 比如： 集合是{1 ，2 ，3 ，4， 5},每个排列以及其后续排序流程如下：
	 * 
	 * (1,2,3,4,5) --> (1,2,3,5,4) -->(1,2,4,3,5) -->(1,2,4,5,3) --> (1,2,5,3,4) --> (1,2,5,4,3) --> (1,3,2,4,5) -->>>>>>> (5,4,3,2,1) --->(1,2,3,4,5)
	 * 
	 */
	public static void nextPermutation(int[] num) {
        
		int pos = -1;
		for(int i = num.length - 1; i > 0; i --){
			if(num[i-1] < num[i]){
				pos = i-1;
				break;
			}
		}
		System.out.println(num[pos]);
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
			System.out.println(num[pos]);
			for(int i = pos +1; i <= (pos + 1 + num.length - 1) / 2; i ++){
				int tmp = num[i];
				num[i] = num[num.length - i + pos];
				num[num.length + pos - i ] = tmp;
			}
		}
    }

}
