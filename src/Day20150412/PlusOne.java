package Day20150412;

public class PlusOne {
	public static void main(String[] args){
		int[] A = {9,9};
		int[] res = plusOne(A);
		for(int i = 0; i < res.length ; i ++)
			System.out.print(res[i] + " ");
	}
	
	public static int[] plusOne(int[] digits) {
		int[] res = digits;
        int N = digits.length;
        int add = 1;
		for(int i = N -1; i > 0; i --){
			if(add == 0)
				break;
			int ele = digits[i];
			if((ele + add) == 10){
				res[i] = 0;
				add = 1;
			}
			else{
				res[i] = ele + add;;
				add = 0;
			}
			
		}
		
		res[0] = digits[0] + add;
		if(res[0] == 10){
			int[] newRes = new int[res.length + 1];
			newRes[0] = 1;
			newRes[1] = 0;
			for(int i = 2; i < newRes.length; i ++){
				newRes[i] = res[i - 1];
			}
			return newRes;
		}
			
		return res;
    }
	
	public static int[] plusOneSolution2(int[] digits){
		if(digits == null || digits.length == 0)
			return digits;
		
		int carry = 1;
		for(int i = digits.length - 1; i >= 0; i --){
			int digit  = (digits[i] + 1) % 10;
			digits[i] = digit;
			carry = (digits[i] + 1) / 10;
			if(carry == 0)
				return digits;
		}
		
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		
		
//		for(int i = 1; i < res.length - 1; i ++){
//			res[i] = digits[i-1];
//		}
		
		return res;
	}
}
