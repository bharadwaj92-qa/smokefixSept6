package com.alerehealth.fwk.api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

    public static String getCurrentTimeStamp(){

        return getCurrentTimeStamp("yyyy-MM-dd hh:mm:ss");
    }


    public static String  getCurrentTimeStamp(String format){

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        String timestamp = sdf.format(date);

        return timestamp;
    }



    /**
     * Helper method to convert String to Date in
     * @param date in yyyy-MM-dd HH:mm:ss
     * @return Date Object
     * @throws ParseException
     */

    public static Date stringToDate(String date) throws ParseException{

        return stringToDate("yyyy-MM-dd HH:mm:ss" , date);

    }

    /**
     * Helper method to convert String to Date in
     * @param toFormat of date
     * @param date
     * @return Date Object
     * @throws ParseException
     */
    public static Date stringToDate(String toFormat, String date) throws ParseException{

        SimpleDateFormat formatter1=new SimpleDateFormat(toFormat);

        Date dateOBj =formatter1.parse(date);

        return dateOBj;

    }

    /**
     * Helper method to convert date to String in yyyy-MM-dd HH:mm:ss format
     * @param date to convert
     * @return date as String in yyyy-MM-dd HH:mm:ss format
     */

    public static String dateToString(Date date){

        return dateToString("yyyy-MM-dd HH:mm:ss",  date);
    }


    /**
     * Helper method to convert date to String
     * @param format desired format
     * @param date to convert
     * @return date as String in specified format
     */
    public static String dateToString(String format, Date date){

        SimpleDateFormat formatter1=new SimpleDateFormat(format);

        return formatter1.format(date);


    }


    public static String getFutureDate(int noOfDaysFromCurrentDate){

        return getFutureDate("yyyy-MM-dd HH:mm:ss",  noOfDaysFromCurrentDate);

    }

    public static String getFutureDate(String format, int noOfDaysFromCurrentDate){

        Calendar calendar = Calendar.getInstance();

        //calendar.setTime(new Date());

        calendar.add(Calendar.DAY_OF_MONTH, noOfDaysFromCurrentDate);

        DateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(calendar.getTime());
    }


    /**
     * Helper method to check whether date is a past date or not
     * @param date to validate
     * @return true or false based on whether date is prior to current date or not
     * @throws ParseException
     */

    public static boolean isPastDate(String date) throws ParseException {

        System.out.println("isPastDate() : Date to validate " + date);

        Date paramDate = stringToDate(date);

        Date currentDate = new Date();

        return paramDate.before(currentDate);

    }


    public static String getDOB(int age){

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.YEAR , -age);

        Date date = calendar.getTime();

       return DateTimeUtils.dateToString("MM/dd/yyyy",date);

    }


    public static String getNextDay(String inputdateFormat, String date, String outputDateFormat) throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat(inputdateFormat);

        Date dateObj = sdf.parse(date);

        Calendar c = Calendar.getInstance();

        c.setTime(dateObj);

        c.add(Calendar.DATE, 1);  // number of days to add

        SimpleDateFormat outDateSdf = new SimpleDateFormat(outputDateFormat);

        return  outDateSdf.format(c.getTime());
    }

    public static String getNextDay( String date, String outputDateFormat) throws Exception {

        return getNextDay("yyyy-MM-dd HH:mm:ss", date,  outputDateFormat);
    }


    /**
     * Helper method to process dates from DB and send it in yyyy-MM-dd HH:mm:ss
     * @param dateFromDb
     * @return date in  yyyy-MM-dd HH:mm:ss
     * @throws ParseException
     */
    public static String processDBDate(String dateFromDb) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date dateObj = sdf.parse(dateFromDb);

        SimpleDateFormat sdfExpected = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdfExpected.format(dateObj) ;
    }


    /**
     * Helper method to get Current date in desired format
     * @param format
     * @return
     */
    public static String getCurrentTime(String format){

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Calendar c = Calendar.getInstance();

        return  sdf.format(c.getTime());
    }


    /**
     * Helper method to caluclate difference between 2 dates in "yyyy-MM-dd" format
     * @param strStartDate
     * @param strEndDate
     * @return difference between 2 dates
     * @throws Exception
     */
    public static int getDifferenceinDaysBetweenDates(String strStartDate, String strEndDate) throws Exception{

        Date startDate = DateTimeUtils.stringToDate(strStartDate);

        Date endDate = DateTimeUtils.stringToDate(strEndDate);


        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        int diff = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;

    }


    /**
     * Helper method to convert date in a format to format specified in outputDateFormat parameter
     * @param inputDateFormat
     * @param date
     * @param outputDateFormat
     * @return date in expected format
     * @throws ParseException
     */
    public static String changeDateFormat(String inputDateFormat, String date, String outputDateFormat) throws ParseException {

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat);

        Date dateTobeConverted = inputFormat.parse(date);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat);

        return outputFormat.format(dateTobeConverted);

    }

    public static int getDifferenceinDaysBetweenDates(String strStartDate, String strEndDate,String format) throws Exception{

        Date startDate = DateTimeUtils.stringToDate(format,strStartDate);

        Date endDate = DateTimeUtils.stringToDate(format,strEndDate);

        System.out.println(endDate);


        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        int diff = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;

    }
}
