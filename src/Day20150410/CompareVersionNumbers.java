package Day20150410;

 
/**
 * @ClassName: CompareVersionNumbers
 * @Description: 
 * @author GongJun
 * @date 2015-4-10 обнГ1:39:31
 * @version V1.0  
 */

public class CompareVersionNumbers {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-10 обнГ1:39:31
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.01","1"));
	}
	
	public static int compareVersion(String version1, String version2) {
		//System.out.println(version1);
        String[] pre = version1.split("\\.");
        String[] bac = version2.split("\\.");
       int flag = 0;
       int i;
        for(i = 0; i < pre.length && i < bac.length; i ++){
        	int p = Integer.parseInt(pre[i]);
        	int b = Integer.parseInt(bac[i]);
        	//System.out.println(p + " " + b);
        	if(p < b){
        		flag = -1;
        		break;
        	}
        	
        	if(p > b) {
        		flag = 1;
        		break;
        	}
        	
        }
        
        for(;i < pre.length && flag == 0 && Integer.parseInt(pre[i]) != 0; i++) {
        	flag = 1;
        	
        }
        
        for(;i < bac.length && flag == 0 && Integer.parseInt(bac[i]) != 0; i ++)
        	flag = -1;
        return flag;
    }
}
