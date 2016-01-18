package _22_CheckPalLengthAroundStar;

public class Problem22 {
	//22. Check for palindrome length around '*'

	//int getPalindromeLength(String input)
	public static int getPalindromeLength(String input){
		int starIndex=input.indexOf("*");
	    int lengthRight=input.length()-starIndex-1;
	    int shorterSide=Math.min(starIndex,lengthRight);
		int palindromeLength=0;
	   for (int i=1; i<=shorterSide;i++){
		  if(input.charAt(starIndex-i)==input.charAt(starIndex+i)){
			  palindromeLength++;
		  } else break;
	   }
	    return palindromeLength;
	    
	}

	//getPalindromeLength("taz*zad") => 2
	public static void main(String[] args){
		System.out.println(getPalindromeLength("taz*zad")); 
	}
}
