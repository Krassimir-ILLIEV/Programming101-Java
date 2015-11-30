
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
	    
	    private static int dayofweek(int y, int  m, int d)	/* 1 <= m <= 12,  y > 1752 (in the U.K.) */
	    {
	    	m=1;
	    	d=1;
	        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
	        y -= (int) (m < 3); //???
	        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
	    }
	    //Gauss

	    //R(1 + 5R(A-1,4) + 4R(A-1,100) + 6R(A-1,400),7)  NB R=y%m ;A=year
	}

