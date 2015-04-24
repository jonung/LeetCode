package Day20150419;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args){
		String s = "abab";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	/*
	 * 虽然能通过，但是主要调用了java的String内置的一些方法
	 * 用lastIndexOf来查找重复的字符串，然后用subString方法组成新的字符串
	 */
	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0)	return 0;
		
		int max = 1;
		String subStr = String.valueOf(s.charAt(0));
		for(int i = 1; i < s.length(); i ++){
			int pos = subStr.lastIndexOf(s.charAt(i));//
			subStr = subStr.substring(pos + 1) + s.charAt(i);
			if(subStr.length() > max)
				max = subStr.length();
		}
		
		return max;
    }
	
	/*
	 * 本题也是一个比较简单的DP问题，f(n)表示以第n个字符结尾的最长字串长度，不妨设该字串为s（k ~ n）
	 * f(n+1)时，如果s(n+1) 不在 s(k ~n)中，则f(n+1) = f(n) + 1,字串为s(k,n+1);
	 * 如果在s(k~n)中，找到其位置p,此时新的字串为s(p+1 ~ n+1),则f(n+1) = n - p + 1;
	 * 所以对每一个n都要维护一个字串或窗口，然后判断下一个字符是否在这个窗口中出现，以此采取相应的措施。
	 * 
	 * 解法一虽然思路和上面说的一样，用一个字串串subStr来显示的维护窗口，但是要不断的进行字符串查找操作，拼接操作。
	 * 考虑用hahsset来维护窗口
	 * 
	 * 时间复杂度o(n),空间复杂度o(字符的个数);
	 * 
	 */
	public static int lengthOfLongestSubstringSolution2(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int max = 0;
		HashSet<Character> window = new HashSet<Character>();
		
		int walker = 0;
		int runner = 0;
		
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(window.contains(c)){
				//更新max
				if(window.size() > max)
					max = window.size();
				
				while(runner <= walker){
					char dup = s.charAt(runner);
					window.remove(dup);
					runner ++;
					if(dup == c)
						break;
				}
				
			}
						
			window.add(c);
			walker ++;
		}
		
		
		return max > window.size() ? max : window.size();//整个字符串都没有重复的情况
	}
}
