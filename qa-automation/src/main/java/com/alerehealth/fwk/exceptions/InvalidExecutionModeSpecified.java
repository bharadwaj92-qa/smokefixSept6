package com.alerehealth.fwk.exceptions;

public class InvalidExecutionModeSpecified extends RuntimeException {

    public InvalidExecutionModeSpecified(String modeSpecified){

        super(modeSpecified+ " is an invalid mode");

    }
}
