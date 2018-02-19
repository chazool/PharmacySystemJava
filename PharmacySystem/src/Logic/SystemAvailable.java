/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chazool
 */
public class SystemAvailable {

    private static String DateTime() {
        Date date = new Date();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String StringDate = dateformat.format(date);
        return StringDate;
    }

    public String GetSystemDate() {

        String date = DateTime().substring(0, 10);
        return date;
    }

    public String GetSystemTime() {

        String time = DateTime().substring(11, 16);
        return time;

    }

}
