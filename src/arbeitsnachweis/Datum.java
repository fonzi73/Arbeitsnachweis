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
     // create Calendar instance with actual date
    
        public static void datumPlus(){
        Date montag = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(montag);

        // Erster Tag der Woche Plus 4 Tage
        calendar.add(Calendar.DAY_OF_WEEK, 4);

        Date freitag = calendar.getTime();

        // print out the dates...
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        
        System.out.println("Now:    " + dateFormat.format(montag));
        System.out.println("Future: " + dateFormat.format(freitag));
    }
}
        
       
    
    
   

