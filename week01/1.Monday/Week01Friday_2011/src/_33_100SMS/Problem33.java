package _33_100SMS;
import java.util.Hashtable;

public class Problem33  {
    
	//SMS100
    private static String[] numberToLetters = { " ", "", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9" };

    private static int[] convertToArray(String str) {
        str = str.replaceAll(" ", "");
        String[] s = str.split(",");
        int[] numbersArray = new int[s.length];
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = Integer.parseInt(s[i]);
        }
        return numbersArray;
    }

    private static String numbersToMessage(int[] inputNumbers) {
        boolean capitalizeNext = false;
        int counter = 0;
        String message = "";
        for (int i = 0; i < inputNumbers.length;) {
            counter = 1;
            while ((i + counter) < inputNumbers.length && inputNumbers[i] == inputNumbers[i + counter]) {
                counter++;
                // System.out.println(counter);
            }
            if (inputNumbers[i] == 1) {
                capitalizeNext = true;
                i++;
                continue;
            } 
            if (inputNumbers[i] == -1) {
                 i++; 
                 continue;
            } 
            String letterGroup = numberToLetters[inputNumbers[i]];
            //System.out.println("lg: " + letterGroup);

            int letterPosition = (counter - 1) % letterGroup.length();
            //System.out.println("lp: " + letterPosition);
            String letter = Character.toString(letterGroup.charAt(letterPosition));
           

            if (capitalizeNext == true) {
                letter=letter.toUpperCase();
                capitalizeNext = false;
            }
            //System.out.println("letter: " + letter);
            message += letter;

            i = i + counter;
        }
        return message;
    }

    public static int[] messageToNumbers(String str){
        Hashtable<String,Integer[]> ht = new Hashtable<String,Integer[]>();
                
        for(int i=0;i<numberToLetters.length;i++){
            String letterGroup=numberToLetters[i];
            for(int j=0; j<letterGroup.length();j++){
                Integer[] numberAndTimes=new Integer[2];
                numberAndTimes[0]=i;
                numberAndTimes[1]=j+1;     
                ht.put(Character.toString(letterGroup.charAt(j)),numberAndTimes);   
            }     
         }
        String messageInNumbers="";
        String letterGroup;
        Integer[] previousLetterArray={-10,-10};
        for(int i=0;i<str.length();i++){
            String upperCase="";
            letterGroup=Character.toString(str.charAt(i));
            if (letterGroup==letterGroup.toUpperCase()){
                letterGroup=letterGroup.toLowerCase();
                upperCase="1,";
            } 
            Integer[] currentLetterArray=ht.get(letterGroup); //contains 3lettergroup and index in it (number of button hits) 
            if(previousLetterArray[0]==currentLetterArray[0]){
                messageInNumbers+="-1,"; 
            }
            previousLetterArray=currentLetterArray;
            messageInNumbers+=upperCase;
            for(int j=0;j<currentLetterArray[1];j++){
            messageInNumbers+=currentLetterArray[0]+",";
        }
        }
        
        return convertToArray(messageInNumbers);

        
    }
    public static void main_decoder(String[] args) {
        int[] a = { 2, 2, -1, 0,-1,2,5, 2, 3, 3, 0, 4, 1, 5 };
        String message = numbersToMessage(a); // = "a"
        System.out.println("message: " +message);
        int[] b={2, -1, 2, 2, -1, 2, 2, 2};
        int[] c={2, 2, 2, 2};
        int[] d={1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 7, 2, 6, 6, 3, 2};
        System.out.println(numbersToMessage(b));
        System.out.println(numbersToMessage(c));
        System.out.println(numbersToMessage(d));
        
        //numbersToMessage([2, -1, 2, 2, -1, 2, 2, 2]); //= "abc"
        //numbersToMessage([2, 2, 2, 2]); //= "a"
        //numbersToMessage([1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 7, 2, 6, 6, 3, 2])
    }
    
    public static void main(String[] args){
        //System.out.println(messageToNumbers("abc")); //= [2, -1, 2, 2, -1, 2, 2, 2])
        //System.out.println(messageToNumbers("AcC"));
    int[] a=messageToNumbers("Vili e Ku4e");
    for(int i=0;i<a.length;i++){
       System.out.print(a[i]+" "); 
    }
    System.out.println();
    
    System.out.println(numbersToMessage(a));
    }
    
}
