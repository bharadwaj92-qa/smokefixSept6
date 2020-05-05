package com.alerehealth.fwk.common;

import static com.alerehealth.fwk.api.utils.DateTimeUtils.getCurrentTimeStamp;
import cucumber.api.Scenario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomLogger {

    Scenario scenario;


    public CustomLogger(Scenario scenario){

        this.scenario = scenario;
    }


    /**
     * Log Info, this is the highest level of logging. Should be used for
     * logging test intent, and actions.
     */
    public void info(String text) {

        String timestamp = getCurrentTimeStamp();
        text = String.format("INFO: [%s] %s", timestamp, text);
        System.out.println("----> " + text);

        scenario.write(String.format("<div style=\"color:green\">%s</div>", text));
    }

    /**
     * Log Debug, this is designed for debug information, used to determine why
     * a test is failing.
     */
    public  void debug(String text) {

        String timestamp = getCurrentTimeStamp();
        text = String.format("DEBUG: [%s] %s", timestamp, text);
        System.out.println("----> " + text);
        scenario.write(String.format("<div>%s</div>", text));
    }

    /**
     * Log A Warning. Use this when something went wrong, but may not be
     * critical for test success. Will show up yellow in the report.
     */
    public  void warning(String text) {

        String timestamp = getCurrentTimeStamp();
        text = String.format("WARNING: [%s] %s", timestamp, text);
        System.out.println("----> " + text);
        scenario.write(String.format("<div style=\"background-color:yellow\">%s</div>", text));
    }

    /**
     * Log errors into report. Will show up in red in report
     * @param text
     */
    public void error(String text) {


        String timestamp = getCurrentTimeStamp();
        text = String.format("ERROR: [%s] %s", timestamp, text);
        System.out.println("!---- " + text);
        scenario.write(String.format("<div style=\"background-color:red; color:white\">%s</div>", text));
    }





    public  void destroyLogs(){

        scenario = null;
    }

    public static File logResponse(String xml, String apiName) throws IOException {

        File file = new File(".\\src\\test\\resources\\api\\response\\"+apiName+".xml" );

        FileWriter fw=new FileWriter(file);

        fw.write(xml);

        fw.flush();

        fw.close();

        return file;


    }
}
