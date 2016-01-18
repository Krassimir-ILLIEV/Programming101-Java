package _24_TimeLord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTime implements TimeFactory {
    final Date date;
    {        date = new Date();
    }
    public MyTime() {

    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd.MM.YY");
        return dateFormat.format(date);

    }
}
