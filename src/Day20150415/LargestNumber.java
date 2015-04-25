package Day20150415;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> num = new ArrayList<Integer>();
		num.add(824);
		num.add(938);
		num.add(8247);
		num.add(1399);
		num.add(5607);
		num.add(6973);
		num.add(5703);
		num.add(9609);
		num.add(4398);
		System.out.println(largestNumber(num));
	}

	
	
	/*
	 * 
	 * 错误解法，以后做题还是想清楚再写代码，调式的时候不要简单的只考虑错误的测试用例
	 */
	public static  String largestNumber(List<Integer> num) {
        if(num == null || num.size() == 0)	return "0";
        
        boolean allZeroFalg = true;
        for(int i = 0; i < num.size(); i ++){
        	if(num.get(i) != 0){
        		allZeroFalg = false;
        	}
        }
        
        if(allZeroFalg)
        	return "0";
        
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < num.size(); i ++){
        	
        	StringBuilder sb = new StringBuilder();
        	
        	String key = String.valueOf(num.get(i));
        	
        	sb.append(key);
        	char c = key.charAt(0);
        	//System.out.println(c);
        	
        	//sb.append(key);
        	sb.append(" ");
        	for(int j = key.length(); j < 33; j ++)
        		sb.append(c);
        	//System.out.println(sb.toString());
        	list.add(sb.toString());
        }
        
        
        Collections.sort(list, new Comparator<String>(){
        	public int compare(String p , String q) {
        		String value_p = p.split(" ")[0] + p.split(" ")[1];
        		String value_q = q.split(" ")[0] + q.split(" ")[1];
        		return value_q.compareTo(value_p) ;       	}
        }
        		
        		);
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < list.size(); i ++){
        	String s = list.get(i);
        	//System.out.println(s.split(" ")[0]);
        	res.append(s.split(" ")[0]);
        }
        
        return res.toString();
    }
}
