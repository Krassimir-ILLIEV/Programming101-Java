package _09_Factorial;

public class factorialCycle<N1 extends Number> {

	public N1 factorial(N1 n) {
		N1 f = (N1) (Integer) 1;
		for (int i = 1; i <= n.intValue(); i++) {
			f = (N1) (Integer) (f.intValue() * i);

		}
		return f;
	}

	public static void main(String[] args) {
		System.out.println(new factorialCycle<Integer>().factorial((Integer) 5));
	}
}
