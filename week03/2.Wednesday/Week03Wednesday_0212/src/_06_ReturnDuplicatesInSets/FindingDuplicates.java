package _06_ReturnDuplicatesInSets;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class FindingDuplicates<T extends Comparable> {

	public Set<T> findDuplicates(Set<Set<T>> a) {
		Set<T> intersectionSet = null;
		Set<T> tempSet = null;

		boolean flag = true;
		for (Set s : a) {
			if (flag) {
				intersectionSet = s;
				flag = false;
			} else {
				tempSet = new HashSet<T>();
				for (T t : intersectionSet) {
					if (s.contains(t)) {
						tempSet.add(t);
					}
				}
				if(tempSet.isEmpty()) {return tempSet;}
				intersectionSet = tempSet;
			}
		}
		return intersectionSet;
		
	}

	public static void main(String[] args) {
		Set<Integer> A = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
		Set<Integer> B = new HashSet<Integer>(Arrays.asList(4,5,6));
		Set<Integer> C = new HashSet<Integer>(Arrays.asList(5,6,7,8));
		
		Set<Set<Integer>> E=new HashSet<Set<Integer>>(Arrays.asList(A,B,C));
			
	
		System.out.println((new FindingDuplicates<Integer>()).findDuplicates(E));
		
	}
}
