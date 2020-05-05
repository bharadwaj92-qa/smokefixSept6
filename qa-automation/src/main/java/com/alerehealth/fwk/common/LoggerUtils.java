package com.alerehealth.fwk.common;


import cucumber.api.Scenario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LoggerUtils {


    private static ThreadLocal<CustomLogger> customLoggerThreadLocal = new ThreadLocal<CustomLogger>();


    public static void intializeCustomLogger(Scenario scenario){

        if(customLoggerThreadLocal.get()==null){

            CustomLogger customLogger = new CustomLogger(scenario);

            customLoggerThreadLocal.set(customLogger);
        }

    }

    private static CustomLogger getCustomLogger(){

        if(customLoggerThreadLocal.get()!=null){

           return customLoggerThreadLocal.get();


        }else{

           return null;
        }

    }
    /**
     * Log Info, this is the highest level of logging. Should be used for
     * logging test intent, and actions.
     */
    public static void info(String text) {

        getCustomLogger().info(text);
    }

    /**
     * Log Debug, this is designed for debug information, used to determine why
     * a test is failing.
     */
    public static void debug(String text) {

        getCustomLogger().debug(text);
    }

    /**
     * Log A Warning. Use this when something went wrong, but may not be
     * critical for test success. Will show up yellow in the report.
     */
    public static void warning(String text) {
        getCustomLogger().warning(text);
    }

    /**
     * Log error into report
     * @param text
     */

    public static void error(String text) {

        getCustomLogger().error(text);
    }

    public static void destroyLogs(){

        customLoggerThreadLocal.set(null);

    }

}
