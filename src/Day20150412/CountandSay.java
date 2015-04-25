package Day20150412;

public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5));
	}

	/*
	 * 一次过
	 */
	
	
	public static String countAndSay(int n) {
		
		String initial = "1";
		//if( n == 1)
		//	return initial;
		
		
		int count = n;
		
		while(count > 1){
			
			char cusChar = initial.charAt(0);
			int cusNum = 1;
			
			StringBuilder say = new StringBuilder();
			
			for(int i = 1 ; i < initial.length(); i ++){
				char c = initial.charAt(i);
				if(c == cusChar)
					cusNum ++;
				else{
					say.append(String.valueOf(cusNum));
					say.append(cusChar);
					cusChar = c;
					cusNum = 1;
				}
			}
			
			say.append(String.valueOf(cusNum));
			say.append(cusChar);
			
			initial = say.toString();
			count --;
		}
		
		return initial;
    }
}
