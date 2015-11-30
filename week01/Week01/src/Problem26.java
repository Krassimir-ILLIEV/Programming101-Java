
public class Problem26 {
	//26. Is String A an anagram of String B?

			//boolean anagram(String A, String B) See http://en.wikipedia.org/wiki/Anagram

			//No HashMaps, hashSets, or such stuff allowed : )

	public static boolean anagram(String A, String B){
		int index;
		if(A.length()!=B.length()) return false;
		for (int i=0; i<A.length();i++){
		   	if((index=B.indexOf(A.charAt(i)))!=-1){
					B=B.substring(0,index)+B.substring(index+1);
					
			} else return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String A="adaam";
		String B="maada";
		System.out.println(anagram(A, B));
				
	}
	

}
