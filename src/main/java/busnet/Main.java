package busnet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public Date date;

    public Main(Date date) {
        this.date = date;
    }

    public Main() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public static void main(String[] args) {
        Date d = new Date();
//        d.setMonth(12);
//        d.setMinutes(30);
        System.out.println(d);
        SimpleDateFormat format1 = new SimpleDateFormat("hh:mm");
        SimpleDateFormat format2 = new SimpleDateFormat("День dd Месяц MM Год yyyy Время hh:mm");
        System.out.println(format1.format(d)); //25.02.2013 09:03
        System.out.println(format2.format(d)); //День 25 Месяц 02 Год 2013 Время 09:03


        Main main= new Main();
        d.getTime();
        System.out.println("Здесь : " + d);
        Calendar c = new GregorianCalendar();//календарь на текущую дату
        Calendar c2 = new GregorianCalendar(2013, 11, 25);//календарь на 25.11.2013
        c2.add(Calendar.DAY_OF_YEAR, 1); //увеличиваем дату на 1 день
        System.out.println(c2.getTime());// 26.11.2013
        c2.add(Calendar.DAY_OF_YEAR, -1); //уменьшаем дату на 1 день

    }
}
