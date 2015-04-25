package Day20150418;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

	/*
	 * 没做出来
	 * 
	 */
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null && s.length() == 0)	return res;
        
        
        return res;
    }
	
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
