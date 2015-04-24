package Day20150416;

public class GasStation {
	
	
	/*
	 * 先用最直接的方法，时间复杂度O(n^2)
	 * 结果超时
	 */
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || gas.length == 0)	return -1;
		
		int start = -1;
		boolean flag = true;
		int N = gas.length;
		int vol = 0;
		
		for(int i = 0; i < N; i ++){
			//从加油站i出发
			start = i;
			vol = vol + gas[i];
			
			int j =i;
			for(j = i + 1; j != i;){
				if(vol >= cost[(j - 1 + N) % N]){
					vol = vol - cost[(j - 1 + N ) % N];
					vol = vol + gas[j];
				}
				else{
					flag = false;
					break;
				}
				
				j = j +1;
				j = j % N;
			}
			
			if(j == i){
				flag = true;
				break;		
			}
		}
		
		if(flag)
			return start;
		else
			return -1;
    }
	
	/*
	 * solution 2
	 * 
	 */
	public int canCompleteCircuitSolution2(int[] gas, int[] cost) {
		if(gas == null || gas.length == 0)	return -1;
		
		int N = gas.length;
		int[] diff = new int[N];
		
		for(int i = 0; i < N; i ++){
			diff[i] = gas[i] - cost[i];
		}
		
		int start = -1;
		for(int i = 0; i < N; i ++){
			//每个站都走一遍
			
			int accu = 0;
			int j= 0;
			for(j = 0 ;  j < N; j ++){
				
				//按照网上说的分情况讨论，不会超时，但结果还是超时
				if((i + j) >= N ){
					accu = accu + diff[i+j - N];
				}
				else{
					accu = accu + diff[i+j];
				}
				
				if(accu < 0)
					break;
			}
			
			if(j == N){
				start = i;
				break;
			}
		}
		return start;
	}
	
	/*
	 * solution 3
	 * 
	 */
	public int canCompleteCircuitSolution3(int[] gas, int[] cost) {
		if(gas == null || gas.length == 0)	return -1;
		
		
		int N = gas.length;
		int[] diff = new int[N];
		for(int i = 0; i < N; i ++)
			diff[i] = gas[i] - cost[i];
		
		if( N == 1)
			return diff[N - 1] >= 0 ? 0 : -1; 
			
		int[] max = new int[N];
		int[] max_pos = new int[N];
		
		int[] min = new int[N];
		
		
		for(int i = 0; i < N; i ++){
			max_pos[i] = i;
			
		}
	
		max[0] = min[0] = diff[0];
		int total = diff[0];
		
		for(int i = 1; i < N; i ++){
			total += diff[i];
			//求最大子序列
			if((max[i -1] + diff[i]) < diff[i] ){
				max[i] = diff[i];
				
			}
			else{
				max[i] = diff[i] + max[i-1];
				max_pos[i] = max_pos[i - 1];
			}
			//求最小子序列
			if((min[i - 1] + diff[i]) > diff[i]){
				min[i] = diff[i];
			}
			else{
				min[i] = diff[i] + min[i-1];
				
			}
			
		}
		
		if(total < 0){
			return -1;
		}
		else{
			int maxPos = 0;
			int minPos = 0;
			int maxValue = max[0];
			int minValue = min[0];
			
			for(int i = 0; i < N; i ++){
				if(max[i] > maxValue){
					maxValue = max[i];
					maxPos = i;
				}
				
				if(min[i] < minValue){
					minValue = min[i];
					minPos = i;
				}
			}
			
			if(maxValue > total - minValue){
				return max_pos[maxPos];
			}
			else
				return (minPos + 1) % N;
		}
	}
	
	/*
	 * 求环形数组的最大（小）子序列和 
	 */
}
