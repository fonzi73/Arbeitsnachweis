/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author fonzi
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        

//        System.out.println(Benutzer.getAllBenutzer());
        //Datum.printGregorianCalendarDate();
//        System.out.println(Nachweis.getAllNachweis());
        
//       Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.set(Calendar.DAY_OF_WEEK, 6);
//
//        Date date = cal.getTime();
//        String formattedDate = new SimpleDateFormat("dd.MM.yyyy").format(date);
//        System.out.println(formattedDate);
//        
//        System.out.println(Bericht.getAllBericht().get(1));
        
            System.out.println(Nachweis.getAllNachweis().get(1));
      
 
    }
    
    
    
}
