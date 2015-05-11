package Day20150511;

import java.util.ArrayList;
import java.util.List;


 
/**
 * @ClassName: SimplifyPath
 * @Description: 
 * @author GongJun
 * @date 2015-5-11 下午3:30:57
 * @version V1.0  
 */

public class SimplifyPath {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/.";
		System.out.println(simplifyPath(path));
		String[] ss = path.split("/");
		for(int i = 0; i < ss.length; i ++)
			System.out.println(ss[i]);
	}

	public static String simplifyPath(String path) {
		if(path == null || path.length() == 0)
			return "";
		
        String[] arr  = path.split("/");
        List<String> l = new ArrayList<String>();
        
        for(int i = 0; i < arr.length; i ++){
        	String word = arr[i];
        	
        	if(word.equals(".") || word.length() == 0){ //不能用word == ".", "== "表示内存地址一样,"equal"表示值一样
        				
        		continue;
        	}
        	
        	if(word.equals("..")){
        		if(!l.isEmpty())
        			l.remove(l.size() - 1);
        	}
        	else{
        		l.add(word);
        	}
        	
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(int i = 0; i < l.size() - 1; i ++){
        	sb.append(l.get(i));
        	sb.append("/");
        }
        
        if(l.size() >= 1 )
        	sb.append(l.get(l.size() - 1));
        
        return sb.toString();
    }
}
