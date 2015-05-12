package Day20150512;

public class SortColors {

	public void sortColors(int[] nums) {
		if(nums == null)
			return ;
		
		int[] count = new int[3];
		for(int i = 0; i < nums.length; i ++){
			count[nums[i]] ++;
		}
		
		int pos = 0;
		for(int i = 0; i < 3; i ++){
			while(count[i] > 0){
				nums[pos ++] = i;
				count[i] --;
			}
		}
    }
}
