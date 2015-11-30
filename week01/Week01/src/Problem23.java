
public class Problem23 {
	//23. Count number of (non-overlapping) occurrences

	//int countOcurrences(String needle, String haystack) countOcurrences("da", "daaadaadada") => 4
	
	public static int countOcurrences(String needle, String haystack){
		
		int counter=0;
		int index=0;
		int i;
		while ((i=haystack.indexOf(needle,index))>-1){
			counter++;
			index=i+needle.length();
		}
		return counter;
	}

public static void main(String[] args){
	System.out.println(countOcurrences("da", "daaadaadada"));// =>4
}
}
