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

	public String addBinary(String a, String b) {
        if(a == null && b == null)
        	return "";
        if(a == null)
        	return b;
        
        if(b == null)
        	return a;
        
        int len = Math.max(a.length(), b.length());
        
        
    }
}
