package Day20150508;

 
/**
 * @ClassName: AddBinary
 * @Description: 
 * @author GongJun
 * @date 2015-5-8 下午9:54:26
 * @version V1.0  
 */

public class AddBinary {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 从后向前面迭代，迭代max(a.length,b.length)次，在第i次迭代中，a中的字符为
	 * a[a.length - i - i],b中的字符为b[b.length - 1- i]ß
	 * 
	 */
	public String addBinary(String a, String b) {
        if(a == null && b == null)
        	return "";
        if(a == null)
        	return b;
        
        if(b == null)
        	return a;
        
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int carry = 0;;
        int len = Math.max(aa.length, bb.length);    
        int[] res = new int[len];
        int pos = len - 1;
        
        for(int i = 0; i < len; i ++){
        	if(aa.length - 1 - i >= 0 && bb.length - 1 - i >= 0){
        		int c1 = aa[aa.length - 1 -i] - '0'; 
        		int c2 = bb[bb.length -1 - i] - '0';
        		
        		res[pos --] = (carry + c1 + c2) % 2;
        		carry = (carry + c1 + c2) / 2;
        	}
        	else if(aa.length - 1 - i >= 0){
        		int c1 = aa[aa.length - 1- i] - '0';
        		res[pos --] = (carry + c1 ) % 2;
        		carry = (carry + c1) / 2;
        	}
        	else if(bb.length - 1- i >= 0){
        		int c2 = bb[bb.length - 1- i] - '0';
        		res[pos --] = (carry + c2 ) % 2;
        		carry = (carry + c2) / 2;

        	}
        	else{
        		continue;
        	}
        	
        }
        
        StringBuilder sb = new StringBuilder();
        if(carry > 0)
        	sb.append('1');
        
        for(int i = 0; i < res.length; i ++)
        	sb.append(res[i]);
        
        return sb.toString();
    }
}
