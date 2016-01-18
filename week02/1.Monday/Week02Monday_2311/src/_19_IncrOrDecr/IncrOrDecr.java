package _19_IncrOrDecr;

public class IncrOrDecr {
    public static boolean IsIncreasing(int[] sequence) {
        for (int i = 0; i < sequence.length-1; i++) {
            if (!(sequence[i] < sequence[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsDecreasing(int[] sequence) {
    for (int i = 0; i < sequence.length-1; i++) {
        if (!(sequence[i] > sequence[i + 1])) {
            return false;
        }
    }
    return true;
    }

    public static void main(String[] args){
        System.out.println(IsIncreasing(new int[] {1,2,3,5}));
        System.out.println(IsDecreasing(new int[] {3,2,1}));
    }
}
