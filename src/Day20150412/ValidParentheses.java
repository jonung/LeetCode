package Day20150412;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "]";
		System.out.println(isValid(s));
	}
	
	/*
	 * 第一次提交错误，错误原因是java stack 若为空，则调用pop是为出现异常，而不是返回null
	 * 所以在弹出时用isempty（）判断栈是否为空
	 * 
	 */
	@SuppressWarnings("null")
	public static boolean isValid(String s) {
		if(s == null && s.length() == 0)	return true;
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[')
				stack.push(c);
			else {
				if(stack.isEmpty())
					return false;
				
				Character pre = stack.pop();
				if(c == ')' && pre != '('){
					
					return false;
				}
				else if(c == ']' && pre != '['){
					return false;
				}
				else if(c == '}' && pre != '{'){
					return false;
				}
				else
					continue;
				
			}
		}
		
		if(!stack.isEmpty())
			return false;
		return true;
    }
}
