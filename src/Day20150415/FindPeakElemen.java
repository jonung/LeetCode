package Day20150415;

 
/**
 * @ClassName: FindPeakElemen
 * @Description: 
 * @author GongJun
 * @date 2015-4-15 ����2:46:23
 * @version V1.0  
 */

public class FindPeakElemen {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-15 ����2:46:23
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,2,3};
		System.out.println(findPeakElementSolution2(num));
	}
	
	
	
	/*
	 * ��򵥵Ľⷨ����ÿ��Ԫ�غ������ڵ�Ԫ�ؽ��бȽ�
	 * 
	 */
	public static int findPeakElement(int[] num) {
        if(num == null || num.length == 0 )	return -1;
        
        if(num.length == 1)	return 0;
        
        for(int i = 0; i < num.length ; i ++){
        	
        	if(i == 0 ){
        		if(num[i] > num[i+1])
        			return i;
        		else
        			continue;
        	}
        	
        	if(i == num.length - 1 ){
        		if(num[i] > num[i-1])
        			return i;
        		else
        			continue;
        	}
        	
        	if(num[i] > num[i - 1] && num[i] > num[i +  1])
        		return i;
        }
        
        return -1;
    }

	/*
	 * �Ƚⷨһ��΢��һЩ����һЩ�Ƚϴ���
	 * �����num[i] �� num[i+1]�� ��ȵ�������ÿ���
	 */
	public static int findPeakElementSolution2(int[] num) {
		if(num == null || num.length == 0 )	return -1;
        
        if(num.length == 1)	return 0;
        
        for(int i = 0; i < num.length ; i ++){
        	
        	if(i == num.length - 1){
        		if(num[i] > num[i - 1])
        			return i;
        		else
        			return -1;
        	}
        	
        	if(num[i] > num[i + 1])
        		return i;
        	else if(num[i] < num[i+1]){
        		
        	}
        	else{
        		//��ȵ�������ҵ���һ������a[i - 1] < a[i]��i
        		for(int j = i + 1; j < num.length ; j ++){
        			if(num[j-1] < num[j]){
        				i = j -1;
        				break;
        			}
        			else
        				i = j -1;
        		}
        	}
        }
        
        return -1;
	}
	
	/*
	 * 
	 * logn �ⷨ
	 */
	public static int findPeakElementSolution3(int[] num) {
		return -1;
	}
}
