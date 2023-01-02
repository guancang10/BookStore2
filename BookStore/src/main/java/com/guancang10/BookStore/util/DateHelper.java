package com.guancang10.BookStore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static Date stringToDate(String date){
        Date result = null;
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
            result = format.parse(date);
        }catch (ParseException ex){

        }
        return result;
    }
}
