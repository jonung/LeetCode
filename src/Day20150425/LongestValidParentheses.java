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

	public int longestValidParentheses(String s) {
        
		if(s == null || s.length() == 0)	return 0;
		int max = 0;
		
		int count = 0;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c == '('){
				stack.add(c);
			}
			else{
				if(stack.isEmpty()){
					if(count > max)
						max = count;
					count = 0;
				}
				else{
					stack.pop();
					count = count + 2;
				}
			}
		}
		
		if(count > max)
			max = count;
		
		return max;
    }
}
