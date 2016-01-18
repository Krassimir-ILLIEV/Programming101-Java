package _12_FindTheOnlyNumberOddTimes;

import java.awt.List;
import java.util.Enumeration;
import java.util.Hashtable;


public class Problem12 {
	//12. Find the only number, that occurs odd times in an array

	//int getOddOccurrence(int... array)

	//Every element in array will occur an even amount of times. There will be exactly one element Example: {1,2,2,1,3,4,3,4,4,6,5,6,5} => 4 occurs only an odd number of times.
	
	public static int getOddOccurrence(int[] a){
		Hashtable<Integer,Integer> ht=new Hashtable<Integer,Integer>();
		for(int i=0;i<a.length;i++){
			if(ht.containsKey(a[i])) {

				ht.remove(a[i]);
			} else ht.put(a[i],0);
			}
		//System.out.println(ht.size());
		 Enumeration <Integer> e=ht.keys();
		 if (e.hasMoreElements()) return e.nextElement();
		 
		 return -1;
		 }
	
	
	
	
	public static int getOddOccurrence_lazy(int[] a){ //works only if there are no 0s in array
		int[][] aux=new int[a.length][2];
		
		
			for(int j=0;j<a.length;j++){
				for (int k=0;k<a.length;k++){
					if (a[j]==aux[k][0]) {
						aux[k][1]++; break;
					} else if(aux[k][0]==0) {
						aux[k][0]=a[j]; 
						aux[k][1]++;
						break;
					}
					}
				}
		
			for (int i=0;i<a.length;i++){
				if(aux[i][1]%2!=0) 
					return aux[i][0]; 
			}
			return -1;
					//List set=new List();
					
		
						
				}
	public static void main(String[] args) {
int[] a={1,2,2,1,3,4,3,4,4,6,5,6,5};
System.out.println(getOddOccurrence(a));

	}

}
