	
public class Problem27{
	//27. Is an anagram of String A a SUBSEQUENCE in B?

    //boolean hasAnagramOf(A,B) Return whether an anagram of String A can be found in String B.

	public static boolean anagram(String A, String B){
		int index;
		
		for (int i=0; i<A.length();i++){
		   	if((index=B.indexOf(A.charAt(i)))!=-1){
					B=B.substring(0,index)+B.substring(index+1);
					
			} else return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String A="adaam";
		String B="maadaaa";
		System.out.println(anagram(A, B));
				
	}
	

}