package Day20150419;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args){
		String s = "bb";
		System.out.println(longestPalindromeSolution2(s));
	}

	/*
	 * O(n^3)解法
	 * 
	 */
	@SuppressWarnings("null")
	public String longestPalindrome(String s) {
		if(s == null && s.length() == 0)
			return "";
		
		if(s.length() == 1)
			return s;
		
		int maxLength = 0;
		String maxLongestPal = "";
		
		int N = s.length();
		for(int i = 0; i < N; i ++){
			for(int j = i + 1; j < N; j++ ){ //若最大回文串长度为1，则存在N个这样的回文，题目说只有唯一一个，所以长度为一的回文串不需要考虑了
				String cusStr = s.substring(i, j + 1);
				int len = j - i + 1;
				
				if(isPalindrome(cusStr) && len > maxLength){
					maxLongestPal = cusStr;
					maxLength = len;
				}
				
			}
		}
		
		return maxLongestPal;
	}
	
	
	/*
	 * 用动态规划来做，在输入全部为a，还是出现了超时
	 * 时间：O(n^2) 空间 ： O(n^2)
	 */
	
	@SuppressWarnings("null")
	public static String longestPalindromeSolution2(String s) {
		if(s == null && s.length() == 0)
			return "";
		
		if(s.length() == 1)
			return s;
		
		int N = s.length();
		int[][] aux = new int[N][N];
		
		//for(int i = 0; i < N; i ++){
		//	aux[i][i] = 1;
	    //}
		
		int maxLength = 0;
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < N; i ++){
			for(int j = i; j < N; j ++){
				if(j == i){
					aux[i][j] = 0;
				}
				else if(j == i + 1){
					if(s.charAt(i) == s.charAt(j)){
						aux[i][j] = 1;
					}
				}
				else{
					if(s.charAt(i) == s.charAt(j) && aux[i+1][j-1] == 1){
						aux[i][j] = 1;
					}
				}
				
				if(aux[i][j] == 1){
					if((j - i + 1) > maxLength){
						maxLength = j -i + 1;
						start = i;
						end = j;
					}
				}
				
			}
		}
		
				
		return s.substring(start, end + 1);
	}
	
	
	
	/*
	 * 
	 */
	public boolean isPalindrome(String s){
		if(s == null || s.length() == 0)	return false;
		
		int start = 0;
		int end = s.length() - 1;
		
		while(start <= end){
			if(s.charAt(start) == s.charAt(end)){
				start ++;
				end --;
			}
			else{
				return false;
			}
		}
		return true;
	}
}
