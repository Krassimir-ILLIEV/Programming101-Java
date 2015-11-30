public class Problem36 {
	//WordFromanbn
    public static boolean is_an_bn(String word){
        int counter=0;
        int counterUniqueLetters=0;
        int[] countAB=new int[2];
        for(int i=0;i<word.length();){
            counter=1;
            counterUniqueLetters++;
            if (counterUniqueLetters>2) return false;
            if(word.charAt(i)!='a' && counterUniqueLetters==1) return false;
            if(word.charAt(i)!='b' && counterUniqueLetters==2) return false;
            while((i+counter<word.length()) && word.charAt(i)==word.charAt(i+counter)){
                counter++;
            }
            countAB[counterUniqueLetters-1]=counter;
            i=i+counter;
        }
        return countAB[0]==countAB[1];
    }
    public static void main(String[] args){
        System.out.println(is_an_bn(""));// = True
        System.out.println(is_an_bn("hack"));// = False
        System.out.println(is_an_bn("aaabb"));// = False
        System.out.println(is_an_bn("aaabbb"));// = True
        System.out.println(is_an_bn("aabbaabb"));// = False
        System.out.println(is_an_bn("bbbaaa"));// = False
        System.out.println(is_an_bn("aaaaabbbbb"));// = True
    }
}
