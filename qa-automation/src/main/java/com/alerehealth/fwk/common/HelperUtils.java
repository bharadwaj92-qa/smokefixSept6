package com.alerehealth.fwk.common;

import cucumber.api.DataTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HelperUtils {

    public static HashMap<String,String> convertDataTableToHashMap(DataTable dataTable){

        Map<String, String> rows = dataTable.asMap(String.class, String.class);

        HashMap<String,String> data = new HashMap<String, String>(rows);

        return data;

    }

    public static String getRandomNumber(int noOfDigits){     
        
        long time = System.currentTimeMillis();
        
        String randomNUmber = ""+ time;

        return randomNUmber.substring(0,noOfDigits);


    }
}