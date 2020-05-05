package com.alerehealth.fwk.exceptions;

import com.alerehealth.fwk.excel.ExcelReader;

public class ExcelFileException extends RuntimeException {

    public ExcelFileException(){

        super("Excel file specified couldn't  be accessed");

    }

    public ExcelFileException(String fileName){

        super(fileName+" excel file couldn't be accessed.");

    }

}
