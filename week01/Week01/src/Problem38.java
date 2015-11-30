
public class Problem38 {
//ZeroInsertion
    public static long zero_insert(int n) { //int range is too small
        String s = ((Integer) n).toString();
        String result = "";
        for (int i = 0; i < s.length()-1; i++) {
            result +=s.charAt(i);
            if (s.charAt(i) == s.charAt(i + 1)) {
                result +="0";
            } else if ((Character.getNumericValue(s.charAt(i))+
                    Character.getNumericValue(s.charAt(i + 1)))%10==0) {
                result +="0";
            }
        } 
        result+=s.charAt(s.length()-1);
        return Long.parseLong(result);
    }

    public static void main(String[] args) {
System.out.println(zero_insert(55));

System.out.println(zero_insert(116457));// = 10160457
System.out.println(zero_insert(55555555));// = 505050505050505
System.out.println(zero_insert(1));// = 1
System.out.println(zero_insert(6446));// = 6040406

    }
}
