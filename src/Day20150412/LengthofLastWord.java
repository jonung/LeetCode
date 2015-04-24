package Day20150412;

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "h   w z";
//		String[] arr = s.split(" +");
//		System.out.println(arr.length);
//		for(int i = 0; i < arr.length; i ++)
//			System.out.println(arr[i]);
		
		System.out.println(lengthOfLastWord(" AA   "));
	}

	public static int lengthOfLastWord(String s) {
		String[] arr = s.split(" +"); //多个空格
		if(arr.length == 0 || arr == null)
			return 0;
		return arr[arr.length - 1].length();
    }
}
