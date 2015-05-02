package Day20150502;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	
	public static void main(String[] args){
		String[] str2 = {"ab","ba","abc","cba","acb"};
		System.out.println(anagramsSolution2(str2).size());
	}

	/*
	 * 
	 * 超时
	 */
	public List<String> anagrams(String[] strs) {
		int n = strs.length;
		
		Map<String,Map<Character,Integer>> map = new HashMap<String,Map<Character,Integer>>();
		for(int i = 0; i < n; i ++){
			String s = strs[i];
			Map<Character,Integer> m = new HashMap<Character,Integer>();
			
			for(int j = 0; j < s.length(); j ++){
				char c = s.charAt(j);
				if(m.containsKey(c)){
					m.put(c, m.get(c) + 1);
				}
				else
					m.put(c, 1);
			}
			
			map.put(s, m);
		}
		
		
		List<String> res = new ArrayList<String>();
		
		for(int i = 0; i < strs.length; i ++){
			String s = strs[i];
			Map<Character,Integer> m = map.get(s);
			
			boolean insert = true;
			for(int j = 0; j < res.size(); j ++){
				String ss = res.get(j);
				if(map.get(ss).equals(m)){
					insert = false;
					break;
				}
				
			}
			
			if(insert){
				res.add(s);
			}
		}
		
		return res;
    }
	
	public static ArrayList<String> anagramsSolution2(String[] strs) {
        HashMap<String, ArrayList<String>> anagramlist = new HashMap<String, ArrayList<String>>();
        ArrayList<String> results = new ArrayList<String>();
        if (strs == null || strs.length ==0) return results;
        for (String single : strs) {
            char[] temp = single.toCharArray();
            java.util.Arrays.sort(temp);
            String afterprocess = new String(temp);
            if (anagramlist.containsKey(afterprocess)) {
                anagramlist.get(afterprocess).add(single);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(single);
                anagramlist.put(afterprocess, list);
            }
        }
        for (ArrayList<String> each : anagramlist.values()) {
            if (each.size() > 1) { //>1
                results.addAll(each);
            }
        }
        return results;
    }

}
