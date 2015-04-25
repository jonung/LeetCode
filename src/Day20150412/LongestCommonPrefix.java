package Day20150412;

public class LongestCommonPrefix {

	/*
	 * 
	 * 第一次提及出现错误，错误出现在第一行，当数组为空时返回列null，应该为""
	 * java中null表示还没new出对象，就是还没开辟空间；“”表示new出了对象，
	 * 但是这个对象装的是空字符串。
	 * 这里显然是要应对strs[]为空数组的情况，数组为空，但是它已经在堆上开辟了空间。
	 * 所以判空应该是 if (str.length == 0) return “”；
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)	return "";
		
		if(strs.length == 1)	return strs[0];
		
		StringBuilder sb = new StringBuilder();
		
		String base = strs[0];
		for(int i = 0; i < base.length() ; i ++){
			String pre = sb.toString() + String.valueOf(base.charAt(i));
			
			for(int j = 1; j < strs.length; j ++){
				if(!strs[j].startsWith(pre))
					return  sb.toString();
			}
			sb.append(base.charAt(i));
		}
		
		return sb.toString();
    }
}
