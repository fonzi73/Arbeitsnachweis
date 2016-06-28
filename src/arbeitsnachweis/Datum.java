/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author fonzi
 */
public class Datum {

    public static String datumMontag() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return formattedDate;

    }

public static String datumFreitag() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, 6);
        Date date = cal.getTime();
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return formattedDate;

    } 
}
