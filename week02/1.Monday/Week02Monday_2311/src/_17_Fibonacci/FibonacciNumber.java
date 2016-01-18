package _17_Fibonacci;
public class FibonacciNumber {

    public static int fibonacci(int n) {
       if (n <2)
            return 1;

        int fib1 = fibonacci(n - 2);
        int fib2 = fibonacci(n - 1) + fib1;
        return fib2;

    }

    public static int fibonacci_alt(int n) {
        int g = 0;
        int f = 1;
        if (n<2) return f;
        for(int i=1;i<n;i++){
        f = f + g;
        g = f - g;

        }
        return f;

    }

    public static long fibNumber(int n) {
        String fibonacciString = "";
        for (int i = 0; i <= n; i++) {
            fibonacciString += fibonacci(i);
        }
        return Long.parseLong(fibonacciString);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci_alt(4));
        System.out.println(fibonacci(8));
        System.out.println(fibNumber(3));
        System.out.println(fibNumber(10));
    }
}
