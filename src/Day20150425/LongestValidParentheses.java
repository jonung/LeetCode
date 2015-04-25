package Day20150425;

import java.util.Stack;

 
/**
 * @ClassName: LongestValidParentheses
 * @Description: 
 * @author GongJun
 * @date 2015-4-25 下午10:04:02
 * @version V1.0  
 */

public class LongestValidParentheses {

	public static void main(String[] args){
		String s = ")()())";
		System.out.println(longestValidParentheses(s));
	}
	
	
	/*
	 * 第一遍做的时候，想的太简单，用栈来操作，但是对()()(()这种情况不知道hi如何处理， 输出 为6
	 * 
	 * 仔细思考过后，发现该题和最长递增子序列类似，考虑用DP来解决
	 * f(i）表示以位置i结尾的字符串满足题意的长度，显然有f('(') = 0，因为'('不可能是一个有效的括号序列的结尾，必须以
	 * ')'结尾。
	 * 
	 * 现在我们考虑位置i为')'，若s[i-1] == '(',则aux[i] = aux[i] + 2,再考虑s[i-2],若s[i-2] == ')',
	 * 										则aux[i] = aux[i] + aux[i-2];
	 * 
	 * 					若s[i-1] == ')',若s[i - aux[i-1] -1] = '(',则 aux[i] = aux[i-1] + 2;
	 * 									最后aux[i] = aux[i] + aux[i - aux[i- aux[i-1] -2]	
	 * 
	 * 
	 * 
	 */
	public static int longestValidParentheses(String s) {
        
		
		if(s == null || s.length() == 0)	return 0;
		int max = 0;
		
		int[] aux = new int[s.length()];
		
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c == '('){
				aux[i] = 0;
			}
			else{
				if( i == 0){
					aux[i] = 0;
				}
				else{
					char pre = s.charAt(i - 1);
					if(pre == '('){
						if(i-2 >= 0){
							aux[i] = 2 + aux[i-2];
						}
						else{
							aux[i] = 2;
						}
					}
					else{
						if(aux[i-1] > 0){
							int pos = i - aux[i-1] -1;
							if(pos < 0){
								aux[i] = 0;
							}
							else{
								if(s.charAt(pos) == ')')
									aux[i] = 0;
								else{
									aux[i] = aux[i-1] + 2;
									if(pos - 1 >= 0){
										aux[i] = aux[i] + aux[pos -1];
									}
								}
							}
						}
						else{
							aux[i] = 0;
						}
					}
				}
				
			}
		}
		
		for(int i = 0; i < aux.length; i ++){
			if(aux[i] > max)
				max = aux[i];
		}
		return max;
    }
	
	/*
	 * 
	 * 别人的解法，就只用了栈这个数据结构，就是多了一个变量lastleft
	 * 
	 * 代码不长
	 * 
	 */
	public class Solution {
	    public int longestValidParentheses(String s) {
	        int Maxlen = 0;
	        int lastleft = 0;
	        Stack<Integer> lefts = new Stack<Integer>();
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') { //new element is '('
	                lefts.push(i);
	            }
	            else { //new element is ')'
	                if (lefts.empty()) { // ')' is not matched, denote this index, as a dividing node
	                    lastleft = i + 1;
	                }
	                else { // ')' is matched
	                    lefts.pop();
	                    if (lefts.empty()) { // no more '(' left in Stack lefts
	                        Maxlen = Math.max(Maxlen, i - lastleft + 1);
	                    }
	                    else {
	                        Maxlen = Math.max(Maxlen, i - lefts.peek());
	                    }
	                }
	            }
	        }
	        return Maxlen;
	    }
	}
}
