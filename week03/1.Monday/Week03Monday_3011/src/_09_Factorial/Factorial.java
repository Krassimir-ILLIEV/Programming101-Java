package _09_Factorial;

public class Factorial {

	public static <T1 extends Number> Number f(T1 t) {
		Double tt = Math.abs(t.doubleValue());
		if (tt - 1 <= 0)
			return tt;
		return t.doubleValue() * (Double) f(t.doubleValue() - 1);
	}

	public static void main(String[] args) {
		System.out.println(Factorial.<Double> f(new Double(-0.5)));
	}
}
