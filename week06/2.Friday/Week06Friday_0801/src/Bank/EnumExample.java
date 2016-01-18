package Bank;

public class EnumExample {
	
 public enum weekDay{
   MONDAY(1), TUESDAY(2), WEDNESDAY(3);
 
 private int _funFactor;
  
 private weekDay(int factor){
	 _funFactor=factor;
 }
 
 }

 public static void main(String[] args){
	 weekDay wDay=weekDay.TUESDAY;
	 wDay._funFactor=1;
	  wDay=weekDay.WEDNESDAY;
	  
	 
	 System.out.println(wDay.valueOf("TUESDAY"));
	 System.out.println(wDay);

	 System.out.println(wDay._funFactor);
 }

}
