/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author DuongNVPH
 */
public class DateHelper {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public static Date toDate(String date , String... pattern){
        try {
            if (pattern.length > 0) {
                sdf.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateHelper.now(); 
            }
            if (date != null) {
                return sdf.parse(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String toString(Date date ,String... pattern){
        if (pattern.length > 0) {
            sdf.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        if (date != null) {
            return sdf.format(date);
        }
        return null;
    }
    public static Date now(){
        return new Date();
    }
    
}
