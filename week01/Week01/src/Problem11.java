
public class Problem11 {

	// 11. Raise an integer to a power of another

	// long pow(int a, int b)

	// Write a O(log(b)) solution.
	public static long pow(int a, int b){
		String binary="";
		long result=1;
	for(int i=b;i>0;){
		binary=i%2+binary;
		i=i/2;
	}
	int[] powersOfa=new int[binary.length()];
	powersOfa[0]=a;


	for (int i=0;i<binary.length()-1;i++){
		powersOfa[i+1] =powersOfa[i]*powersOfa[i];
		
	}
	//for (int j=0;j<binary.length();j++){
		//System.out.println(j+" "+powersOfa[j]);
	//}

	for(int k=0;k<binary.length();k++){
		//System.out.println(powersOfa[k]+" "+(binary.charAt(k)-'0'));
		if(binary.charAt(k)=='1'){
		result *=powersOfa[k];
		//System.out.println("result "+result);
		}
	}
		
	return result;

	}
	public static long pow_lazy(int a, int b) { //~(b/2)
		long result = 1;
		
			for (int i = 1; i <= b / 2; i++) {

				result *= a;
			}
			result *= result;
			
			if (b % 2 == 0) {
		 
	return result; }
			else return result*a;
	}
	

	public static void main(String[] args) {
int a=5;
int b=5;
System.out.println(pow(a,b));
	}
}
