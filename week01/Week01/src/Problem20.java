
public class Problem20 {
	//20. Is this number a palindrome

	//boolean isPalindrome(int argument)
	public static boolean isPalindrome(int argument){
		String s=((Integer) argument).toString();
		for (int i=0;i<s.length()/2;i++){
		if (s.charAt(i)!=s.charAt(s.length()-1-i))
			return false;
	}
	return true;
	}
	public static void main(String[] args){
		System.out.println(isPalindrome(9781879));
	}
}
