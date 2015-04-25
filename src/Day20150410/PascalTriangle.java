package Day20150410;

import java.util.ArrayList;
import java.util.List;

 
/**
 * @ClassName: PascalTriangle
 * @Description: 
 * @author GongJun
 * @date 2015-4-10 обнГ2:59:59
 * @version V1.0  
 */

public class PascalTriangle {

	/**
	 * @Function: main
	 * @Description: TODO
	 * @param @param args    
	 * @return void    
	 * @date 2015-4-10 обнГ2:59:59
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<List<Integer>> r = generate(1);
		for(int i = 0; i < r.size(); i ++){
			List<Integer> tmp = r.get(i);
			for(int j = 0; j < tmp.size(); j ++)
				System.out.print(tmp.get(j) + " ");
			System.out.println();
		}*/
		
		List<Integer> l = getRow2(2);
		for(int i = 0; i < l.size(); i ++)
			System.out.print(l.get(i) + " ");
	}
	
	public static List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
        for(int i = 0; i < numRows; i ++) {
        	List<Integer> item = new ArrayList<Integer>();
        	item.add(1);
        	      	
        	if(item.size() < i + 1) {
        		for(int m = 2; m < i+ 1; m ++) {
        			int data = res.get(i-1).get(m -1) + res.get(i - 1).get( m - 2);
        			item.add(data);
        		}
        	}
        	
        	if(item.size() < i + 1)
        		item.add(1);
        	
        	res.add(item);
        }
        
        return res;
    }
	
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> res = generate(rowIndex + 1);
		return res.get(rowIndex); 
    }
	
	public static List<Integer> getRow2(int rowIndex) {
		
		if(rowIndex < 0)
			return null;
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i <= rowIndex; i ++){
			if( i == 0)
				res.add(1);
			else {
				for(int j = res.size() - 1; j > 0; j --){
					res.set(j, res.get(j - 1) + res.get(j));				
				}
				res.add(1);
			}
			
		}
		
		return res;
    }
}
