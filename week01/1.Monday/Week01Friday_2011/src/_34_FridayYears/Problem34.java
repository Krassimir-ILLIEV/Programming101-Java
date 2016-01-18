package _34_FridayYears;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Problem34 {
	//34. Friday Years

	//Have you every wondered how many fridays are there in one year?

	//The count can be 52 or 53, depending on the weeks of that year (leap or not) and the start of the year.

	//If an year contains 53 fridays, we call that "A Friday Year"

	//You are to implement a function, called friday_years(String start, String end), where start and end are integers, representing years.

	//The function should return the count of all friday years between [start, end]

	//Examples:

	    //friday_years(1000, 2000) = 178
	    //friday_years(1753, 2000) = 44
	    //friday_years(1990, 2015) = 4



	    private static boolean isLeapYear(int year) {
	    
	        boolean isLeap;
	        isLeap = year % 4 == 0;
	        isLeap = isLeap && year % 100 != 0;
	        isLeap = isLeap || year % 400 == 0;
	        return isLeap;
	    }
	    /*
	    private static int dayOfWeek(int y, int  m, int d)	/* 1 <= m <= 12,  y > 1752 (in the U.K.)
	    {
	    	m=1;
	    	d=1;
	        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
	        if(m<3){
	        	y-=1;
	        }
	        //y -= (int) (m < 3); //???
	        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
	    }
	    //Gauss

	    //R(1 + 5R(A-1,4) + 4R(A-1,100) + 6R(A-1,400),7)  NB R=y%m ;A=year
	    
	    */
	   
	    
	    
	    private static String dayOfweek(int year, int month, int day){
	    Calendar c = Calendar.getInstance();
	    c.set(year, month-1, day);

	    GregorianCalendar g=new GregorianCalendar();
	    g.setGregorianChange(new Date(Long.MIN_VALUE));
	    g.set(year, month-1, day);
	    
	    //int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	    //setGregorianChange()
	    //public void setGregorianChange(Date date)

	    //Sets the GregorianCalendar change date. This is the point when the switch from Julian dates to Gregorian dates occurred. Default is October 15, 1582 (Gregorian). Previous to this, dates will be in the Julian calendar.

	    //To obtain a pure Julian calendar, set the change date to Date(Long.MAX_VALUE). To obtain a pure Gregorian calendar, set the change date to Date(Long.MIN_VALUE).

	    //Parameters:
	       // date - the given Gregorian cutover date.
	   // public void setGregorianChange(Date date)

	    String[] strDays = new String[]{
                "Sunday",
                "Monday",
                "Tuesday",
                "WednesdafridayYearCountery",
                "Thusday",
                "Friday",
                "Saturday"
              };
	   String weekDay=strDays[g.get(Calendar.DAY_OF_WEEK) - 1];  //g or c, choose wisely

	    return weekDay;
	    }
	    
	    
	    
	    public static int friday_years(String start, String end){
	    	int fridayYearCounter=0;
	    	int startYear=Integer.parseInt(start);
	    	int endYear=Integer.parseInt(end);
	    	for(int i=startYear;i<=endYear;i++){
	    		if(dayOfweek(i,1,1).equals("Friday") || (isLeapYear(i) && (dayOfweek(i,1,1).equals("Thusday")))){
	    		//if(Math.abs(i-2016)%7==0 || (isLeapYear(i) && Math.abs(i-2016)%7==)){
	    			fridayYearCounter++;
	    		}
	    	}
	    	return fridayYearCounter;
	    }
	    
	    public static void main(String[] args){
	    	System.out.println(Problem34.friday_years("1000", "2000"));
	    	System.out.println(Problem34.friday_years("1753", "2000"));
	    	System.out.println(Problem34.friday_years("1990", "2015"));
	    	 //friday_years(1000, 2000) = 178
		    //friday_years(1753, 2000) = 44
		    //friday_years(1990, 2015) = 4
	    }
	    }
	

