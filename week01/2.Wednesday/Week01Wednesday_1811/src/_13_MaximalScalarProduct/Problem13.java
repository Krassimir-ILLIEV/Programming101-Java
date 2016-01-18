package _13_MaximalScalarProduct;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem13 {
	//Maximalscalarproduct
    private static int maxSum;
private static int[] aRef,bRef;
    public static int maximalScalarSum(int[] a, int[] b){
        if(a.length!=b.length) {
            System.out.println("the two vectors have incompative lengths");
        
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i]*b[i];
        }
        return sum;
    }
    
    private static void swap(int[] a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    private static void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        } System.out.println();
    }
    
    private static int multiplyVectors(int[] a, int[] b){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i]*b[i];
        }
        return sum;
    }
    
    private static void permutateTest(int[] a, int n){
  
            if(n==1) { 
                System.out.print("*****");
                printArray(a);

                return;
           }
            for(int i=0;i<n;i++){
                swap(a,i,n-1);
                System.out.println("------"+(n-1)+"-----");
                printArray(a);
                permutateTest(a,n-1);
                swap(a,i,n-1); 
            }
           
        }
        
    
    private static void permutate(int[] a, int n){
        if(n==1) {
            if (a==aRef){
                permutate(bRef,bRef.length);
            } else { 
                int currentSum=multiplyVectors(aRef,bRef);
                if(currentSum>maxSum) {
                    maxSum=currentSum;
                }
                System.out.println("----");
                printArray(aRef);
                printArray(bRef);
                System.out.println("----:"+currentSum);
            }
            
            return;
        
        }
        for(int i=0;i<n;i++){
            swap(a,i,n-1); 
            permutate(a,n-1);
            swap(a,i,n-1); 
        }
       
    }
    
    private static int maximalScalarSum_perm(int[] a, int[] b){
        aRef=a;
        bRef=b;
        maxSum=0;
        permutate(a,a.length);
        return maxSum;
    }
    
    public static void main(String[] args){
        int[] a={4,3,2};
        int[] b={1,2,3};
        //System.out.println(maximalScalarSum(a,b));
        //System.out.println(maximalScalarSum_perm(a,b));
        //permutate(b,3);
        permutateTest(b,3);
    }
}
