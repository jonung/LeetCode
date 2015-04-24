package Day20150412;

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * solution 1
	 * 利用java api可直接得到结果
	 * 明显不是本题考察的地方，需要自己实现字符串查找算法
	 */
	public int strStr(String haystack, String needle) {
        
		if(haystack == null)
			return -1;
		
		if(needle == null)
			return -1;
		int index = haystack.indexOf(needle);
		return index;
    }
}
