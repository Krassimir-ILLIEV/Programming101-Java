package _18_Lucas;

public class Lucas {

        // wrong way to compute Fibonacci
        public static long F(int n) {
            //StdOut.println(n);
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            return F(n - 1) + F(n - 2);
        }

        public static int f_better(int n, int i, int fn1, int fn2) {
            //StdOut.println(i);
            if (i >= n)
                return fn1 + fn2;
            return f_better(n, i + 1, fn1 + fn2, fn1);

        }
        public static int lucas_better(int n, int i, int fn1, int fn2) {
            //StdOut.println(i);
   
            if (i >= n)
                return fn1 + fn2;
            return lucas_better(n, i + 1, fn1 + fn2, fn1);

        }
        public static long f_loop(int n) {
            long fn1=1;
            long fn2=0;
            long temp;
            if (n==0) return 0;
            for(int i=2;i<=n;i++){
               temp=fn2+fn1;
               fn2=fn1;
               fn1=temp;
          }
            return fn1;
        }

        public static int nthLucas(int n){
            if (n == 0)
                return 2;
            if (n == 1)
                return 1;
             return f_better(n,2,1,2);
        }
        
        public static int nthFibonacci(int n){
            if (n == 0)
                return 0;

             return f_better(n,2,1,0);
        }
        
        public static void main(String[] args) {
            //int N = Integer.parseInt(args[0]);
            System.out.println(nthLucas(2));
            System.out.println(nthFibonacci(2));
    /*        StdOut.println(F(N));
            StdOut.println("-----------");
            StdOut.println(f_better(N, 2, 1, 0));
            StdOut.println("-----------");*/
            //StdOut.println(f_loop(N));
        }
    }


