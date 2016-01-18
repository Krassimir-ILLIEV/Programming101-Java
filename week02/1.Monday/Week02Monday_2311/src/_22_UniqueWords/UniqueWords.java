package _22_UniqueWords;

import java.util.Arrays;
import java.util.Hashtable;

public class UniqueWords {
    public static int uniqueWordsCount(String[] arr) {
        boolean[] covered = new boolean[arr.length];
        int uniqueWords = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!covered[i]){
                uniqueWords++;
               for (int j = i+1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    covered[j] = true;
                } 
            }
        }
        }
        return uniqueWords;
    }
    
    public static int uniqueWordsCount_lazy(String[] arr){
       // System.out.println(arr.length);
        if(arr.length==0) return 0;
        Arrays.sort(arr);
        int counter=1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                counter++;
            }
        }
        return counter;
    }
    
    public static int uniqueWordsCount_hash(String[] arr){
        Hashtable<String, Integer> ht=new Hashtable<String, Integer>();
        for(int i=0;i<arr.length;i++){
            if(!ht.containsKey(arr[i])) {
                ht.put(arr[i],0);
            }
                ht.put(arr[i],ht.get(arr[i])+1);
            
        }
        return ht.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueWordsCount(new String[] { "apple", "banana", "apple", "pie" }));
        // == 3
        System.out.println(uniqueWordsCount(new String[] { "java", "java", "java", "android" }));
        // == 2
        System.out.println(uniqueWordsCount(new String[] { "HELLO!", "HELLO!", "HELLO!", "HELLO!" }));
        // == 1
    }
}
