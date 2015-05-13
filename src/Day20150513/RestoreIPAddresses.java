package Day20150513;
import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddresses{

	public List<String> restoreIpAddresses(String s){
		List<String> res = new ArrayList<String>();
		help(res, new StringBuilder(), 3, s, 0);
		return res;
	}

	public void help(List<String> res, StringBuilder path, int level,String s, int start){
		if(start >= s.length())
			return;
		
		if(level == 0){
						
			String word = s.substring(start);
			if(word.length() >=4 )
				return;
			if(word.length() == 3 && Integer.parseInt(word) > 255){
				return;
			}
			
			if(word.length() >= 2){
			    int count = 0;
				for(int j = 0; j < word.length(); j ++){
					if(word.charAt(j) == '0')
						count ++;
					else
						break;
				}
				
				if(count >0)
					return;
			}
			
			path.append(word);
			res.add(path.toString());
			return;			
		}

		
		for(int i = 1; i <=3; i ++){
			if(start + i  > s.length()){
				return;
			}
			String word = s.substring(start,start + i);
			if(i == 3 && Integer.parseInt(word) > 255){
				return;
			}
			
			if(word.length() >= 2){
				int count = 0;
				for(int j = 0; j < word.length(); j ++){
					if(word.charAt(j) == '0')
						count ++;
					else
						break;
				}
				
				if(count > 0)
					return;
			}
						
			
			StringBuilder sb = new StringBuilder();
			sb.append(path.toString());
			sb.append(word);
			sb.append(".");

			help(res,sb,level - 1,s,start + i);
		}
	}

}