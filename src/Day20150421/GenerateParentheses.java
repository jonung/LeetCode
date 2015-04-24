package Day20150421;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

	public static void main(String[] args){
		List<String> res = generateParenthesisSolution2(2);
		for(int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}
	
	/*
	 * 最笨的办法，在字母表{（， ）}中取6次，把所有可能列出来，然后再来验证每中情况的合法性。
	 * 
	 */
	public static List<String> generateParenthesis(int n) {
		
		String[] aux = {"(",")"};
		List<String> res = new ArrayList<String>();
		recursion(res, "", 2 * n, aux);
		return res;
	}
	
	
	 
	
	public static void recursion(List<String> l, String cus,int n ,String[] aux){
		
		if(cus.length() < n){
			for(String s : aux){
				
				String ss = cus + s;
				
				recursion(l, ss, n, aux);
			}
		}
		
		if(cus.length() == n){
			if(!l.contains(cus) && isLegal(cus)){
				l.add(cus);
			}
		}
	}
	
	public static boolean isLegal(String s) {
		boolean flag = true;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c == '('){
				stack.push(c);
			}
			else{
				if(stack.isEmpty()){
					flag = false;
					break;
				}
				else{
					char top = stack.pop();
					if(top != '('){
						flag = false;
						break;
					}
				}
			}
		}
		
		if(!stack.isEmpty())
			return false;
		return flag;
	}
	
	/*
	 *改进后的解法，在递归的函数中用l和r来代表当前时刻左括号和右括号的剩余次数
	 *
	 * 
	 */
	public static List<String> generateParenthesisSolution2(int n) {
		
		List<String> res = new ArrayList<String>();
		helper(n, n, "", res);
		return res;
	}

	public static void helper(int l, int r, String cus, List<String> list){
		if(l > r)
			return;
		
		if( l == 0 && r == 0)
			list.add(cus);
		
		if(l > 0) {
			helper(l - 1, r, cus + "(", list);
		}
		
		if(r > 0){
			helper(l, r - 1, cus + ")", list);
		}
	}
}
