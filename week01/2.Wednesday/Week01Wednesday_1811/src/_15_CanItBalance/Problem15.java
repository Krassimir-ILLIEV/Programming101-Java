package _15_CanItBalance;

public class Problem15 {
	//15. Can balance?

			//boolean canBalance(int[] numbers)

			//canBalance({1, 1, 1, 2, 1}) → true canBalance({2, 1, 1, 2, 1}) → false canBalance({10, 10}) → true

			//Return true if there is an element in the array, where you can split the array in half and the sum of left side would be equal to the sum of the right part. 

public static boolean canBalance(int[] numbers){
	int sum=0;
	for(int i=0; i<numbers.length;i++){
		sum +=numbers[i];
	}
	
	if(sum%2!=0) return false;
	sum=sum/2;
	int partialSum=0;
	
	for(int i=0;partialSum<sum;i++){
		partialSum +=numbers[i];
	}
	return (partialSum==sum);
}



public static void main(String[] args){
int[] a={1, 1, 1, 2, 1};
int[] b={2, 1, 1, 2, 1};
int[] c={10, 10};
	System.out.println(canBalance(a)); //→ true 
	System.out.println(canBalance(b));//→ false 
	System.out.println(canBalance(c)); //→ true

	
	}
}
