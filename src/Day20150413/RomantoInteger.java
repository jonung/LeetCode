package Day20150413;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "DCCC";
		System.out.println(romanToInt(s));
	}

	@SuppressWarnings("null")
	public static int romanToInt(String s) {
		if(s == null && s.length() == 0)	return 0;
		
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);  
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] arr = s.toCharArray();
        int res = 0;
        int p = 0;
        int q = 1;
        
        for(; p < arr.length && q < arr.length; ){
        	if(map.get(arr[p]) < map.get(arr[q])){
        		res += map.get(arr[q]) - map.get(arr[p]);
        		p = p + 2;
        		q = q + 2;
        	}
        	else{
        		res = res + map.get(arr[p]);
        		p = p + 1;
        		q = q + 1;
        	}
        }
        
        if(p < arr.length)
        	res = res + map.get(arr[p]);
        
        return res;
    }
}
