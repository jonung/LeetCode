package Day20150501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutaions {

	public static void main(String[] args){
		int[] a = {1};
		List<List<Integer>> res = PermutationsII.permuteUnique(null);
		
		for(int i = 0; i < res.size(); i ++){
			List<Integer> l = res.get(i);
			for(int j = 0; j < l.size(); j ++)
				System.out.print(l.get(j) + " ");
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (ArrayList<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size(); ) {
					
					if(l.get(j) == num[i]){
						int m = j + 1;
						for(; m < l.size(); m ++){
							if(num[m] != num[i])
								break;
						}
						
						l.add(m,num[i]);
						ArrayList<Integer> temp = new ArrayList<Integer>(l);
						current.add(temp);
						
						l.remove(m);
						j = m;
					}
					else{
					// + add num[i] to different locations
					l.add(j, num[i]);
					
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove num[i] add
					l.remove(j);
					j ++;
					}
				}
			}
	 
			result = new ArrayList<ArrayList<Integer>>(current);
		}
	 
		return result;
	}

}
