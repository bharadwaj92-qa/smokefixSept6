package com.alerehealth.fwk.excel;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.exceptions.ExcelFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cvenkat6
 */

public class ExcelReader {

    String excelFileName ;

    String folderPath;

    String sheetName;

    XSSFWorkbook workbook;

    public int getStartRow() {
        return startRow;
    }

    int startRow = 1;


    public ExcelReader(String excelFileName, String sheetName){

        this(".\\src\\test\\resources\\testdata\\", excelFileName,sheetName);


    }

    public ExcelReader(String folderPath, String excelFileName, String sheetName){

        this.folderPath = folderPath+(folderPath.endsWith("\\")? "" : folderPath.endsWith("/")?"":"\\");

        this.excelFileName = (excelFileName+(excelFileName.contains(".xlsx")?"":".xlsx"));

        this.sheetName = sheetName;

        try {
            File excelFile = new File(folderPath + excelFileName);
            FileInputStream fis = new FileInputStream(excelFile);

            workbook = new XSSFWorkbook(fis);
        }
        catch (IOException e){

            throw  new ExcelFileException();
        }

    }

    public XSSFWorkbook getExcelWorkBook(){

        return workbook;

    }

    public XSSFSheet getExcelSheet() {


        return getExcelSheet(this.sheetName);
    }

    public int getRowCount(){

        int lastRow = getExcelSheet().getLastRowNum()+1;

        //XXX: In ScenarioGenerator we will get nullpointer exception as scenario object wont be there
        //XXX: Dont uncomment these lines
       // LoggerUtils.info("getRowCount(): LastRow ="+ lastRow );

       // LoggerUtils.info("getRowCount(): Row count ="+ (lastRow - startRow) );
        return (lastRow);

    }

    public XSSFSheet getExcelSheet(String sheetName){

        return workbook.getSheet(sheetName);
    }

    /**
     * Helper method to retrieve value of specified row's column value
     * @param columnName
     * @param rowNumber
     * @return cell content
     */
    public String getCellValue(String columnName, int rowNumber){

        XSSFSheet xssfSheet = getExcelSheet();

        //Row numbering starts with 0 so decrement by 1
        //Allow user to enter the row number visible to naked eye
        rowNumber = (rowNumber==0)?0:rowNumber-1;

        XSSFRow xssfRow = xssfSheet.getRow(rowNumber);

        int columnIndex = getColumnIndex(columnName);

        XSSFCell cell = xssfRow.getCell(columnIndex);

        String cellValue = "";

        switch (cell.getCellType()) {

            case Cell.CELL_TYPE_STRING: {

                cellValue = cell.getRichStringCellValue().getString();

                break;
            }

            case Cell.CELL_TYPE_NUMERIC: {


                if (DateUtil.isCellDateFormatted(cell)) {


                    cellValue= DateTimeUtils.dateToString(cell.getDateCellValue());

                } else {

                    cellValue = ""+cell.getNumericCellValue();
                }
                break;
            }
            case Cell.CELL_TYPE_BOOLEAN:{

                cellValue = ""+cell.getBooleanCellValue();
                break;
            }

            case Cell.CELL_TYPE_FORMULA: {

                //TODO: In case of formula we need to evaluate the formula. To be implemented in future
                cellValue = cell.getCellFormula();
                break;
            }

        }
        return cellValue;
    }

    /**
     * Helper method to indicate from which row in excel should be considered
     * @param row
     */
    public void setStartRow(int row){

        //Row numbering starts with 0 so decrement by 1
        //Allow user to enter the row number visible to naked eye
        this.startRow = row-1;
    }

    public int getColumnIndex(String columnName){

        int cellIndex = -1;

        XSSFSheet xssfSheet = getExcelSheet();

        XSSFRow row = xssfSheet.getRow(startRow);

        int columnSize = row.getLastCellNum();

        for (int i = 0; i < columnSize ; i++) {

            XSSFCell cell =  row.getCell(i);

            if(cell.getStringCellValue().trim().equals(columnName)){

                cellIndex = i;
                break;

            }
        }

        return cellIndex;

    }


    public List<String> getColumnNames(){

        List<String> columnNameList = new ArrayList<String>();

        XSSFSheet xssfSheet = getExcelSheet();

        XSSFRow row = xssfSheet.getRow(startRow);

        int columnSize = row.getLastCellNum();

        for (int i = 0; i < columnSize ; i++) {

            XSSFCell cell =  row.getCell(i);

            columnNameList.add(cell.getStringCellValue().trim());

        }

        return columnNameList;

    }
}
