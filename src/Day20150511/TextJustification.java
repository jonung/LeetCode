package Day20150511;

import java.util.ArrayList;
import java.util.List;

 
/**
 * @ClassName: TextJustification
 * @Description: 
 * @author GongJun
 * @date 2015-5-11 下午2:15:32
 * @version V1.0  
 */

public class TextJustification {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = "This is an example of text justification. ";
		String str = "";
		String[] words = str.split(" ");
		
		List<String> res = fullJustify(words, 2);
		
		for(int  i = 0; i < res.size(); i ++)
			System.out.println("|" + res.get(i) + "|");
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0){
        	StringBuilder ss = new StringBuilder();
        	for(int i = 0; i < maxWidth ; i ++)
        		ss.append(" ");
        	res.add(ss.toString());
        	return res;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        
        for(int i = 1; i < words.length; i ++){
        	String word = words[i];
        	if(sb.length() + word.length() + 1 <= maxWidth){
        		sb.append(" ");
        		sb.append(word);
        	}
        	else{
        		//System.out.println(sb.toString());
        		String[] tmp = sb.toString().split(" ");
        		if(tmp.length > 1){
        			int spaceCount = maxWidth - sb.toString().length() + tmp.length - 1;
            		int base = spaceCount / (tmp.length - 1);
            		spaceCount = spaceCount % (tmp.length - 1);
            		
            		StringBuilder line = new StringBuilder();
            		for(int j = 0; j < tmp.length - 1; j ++){
            			line.append(tmp[j]);
            			for(int m = 0; m < base; m ++)
            				line.append(" ");
            			if(spaceCount -- > 0)
            				line.append(" ");
            		}
            		line.append(tmp[tmp.length - 1]);
            		res.add(line.toString());
        		}
        		else{
        			StringBuilder last = new StringBuilder();
            		last.append(tmp[tmp.length - 1]);
            		int count = maxWidth - last.length();
            		
            		for(int m = 0; m < count; m ++)
            			last.append(" ");
            		
            		res.add(last.toString());
        		}
        		
        		sb = new StringBuilder();
        		sb.append(word);
        	}
        }
        
        //处理最后一行
        int count = maxWidth - sb.toString().length();
        for(int i = 0; i < count; i ++)
			sb.append(" ");
        res.add(sb.toString());
        
        
        
        return res;
    }
}
