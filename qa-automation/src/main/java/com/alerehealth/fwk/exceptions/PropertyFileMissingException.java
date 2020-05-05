package com.alerehealth.fwk.exceptions;

public class PropertyFileMissingException extends RuntimeException {

    public PropertyFileMissingException(){

        super("Propertyfile specified is missing. Please check spelling or see if property file is present");

    }

    public PropertyFileMissingException(String propertyFileName){

        super(propertyFileName+ " Propertyfile specified is missing. Please check spelling or see if property file is present");

    }



}
