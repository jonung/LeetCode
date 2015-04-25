package Day20150425;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 
/**
 * @ClassName: SubstringwithConcatenationofAllWords
 * @Description: 
 * @author GongJun
 * @date 2015-4-25 下午8:24:29
 * @version V1.0  
 */

public class SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 一开始做这题，以为有其他比较好的解法。想了半天都没想出来，然后就看了答案。
	 * 这里的两点是用到了比较两个map是否相等。
	 * 此外
	 * Integer freq = pattern.get(word);
     * pattern.put(word, freq == null ? 1 : freq + 1);
	 * 用这两行代码会导致超时
	 * 
	 */
	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> res = new ArrayList<Integer>();
        HashMap<String,Integer> pattern = new HashMap<String,Integer>();
        HashMap<String,Integer> each = new HashMap<String,Integer>();
        
        for(String word : words){
        	
        	if(pattern.containsKey(word)){
    			pattern.put(word, pattern.get(word) + 1);
    		}
    		else
    			pattern.put(word, 1);
        	
        	/*Integer freq = pattern.get(word);
        	pattern.put(word, freq == null ? 1 : freq + 1);*/
        }
        
        int wordLen = words[0].length();
        int wordsSize = words.length;
        
        for(int i = 0; i <= s.length() - wordLen * wordsSize; i ++){
        	
        	for(int j = i; j < i + wordLen * wordsSize ; ){
        		String word = s.substring(j,j + wordLen);
        		
        		if(!pattern.containsKey(word))
        			break;
        		
        		if(each.containsKey(word)){
        			each.put(word, each.get(word) + 1);
        		}
        		else
        			each.put(word, 1);
        		/*Integer freq = each.get(word);
        		each.put(word, freq == null ? 1 : freq + 1);
        		*/
        		j = j + wordLen;
        	}
        	
        	if(pattern.equals(each)){
        		res.add(i);
        	}
        	each.clear();
        }
        return res;
    }
}
