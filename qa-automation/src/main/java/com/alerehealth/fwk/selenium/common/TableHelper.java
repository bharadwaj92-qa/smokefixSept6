package com.alerehealth.fwk.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TableHelper {

   private WebDriver webDriver;
    private WebElement tableElement;
    HashMap<String, Integer> columnIndex = new HashMap<String,Integer>();

    public TableHelper(WebDriver webDriver, WebElement tableElement) {
        this.webDriver = webDriver;
        this.tableElement = tableElement;
    }


    public TableHelper(WebDriver webDriver, String xpath){

        this.webDriver = webDriver;

        tableElement = webDriver.findElement(By.xpath(xpath));

    }


    public  List<String> getColumnNames(){

    	if(columnIndex.size()!=0){
    		
    		return new ArrayList<String>(columnIndex.keySet());
    		
    	}
        List<WebElement> columnEles = tableElement.findElements(By.xpath(".//tr[1]//th"));
        
        List<String> columnName = new ArrayList<String>();
 
        System.out.println("Size of columnElements:"+columnEles.size());
        
     
        
       
        if(columnEles.size()> 0) {
        	
        	 try{
        	
        	columnName.addAll(getValues(columnEles, e -> e.getText().trim()));     	
        	 }
        	 
        	 catch(Exception e1){
        		 
        		   columnEles = tableElement.findElements(By.xpath(".//tr[1]//th"));
        		   columnName.addAll(getValues(columnEles, e -> e.getText()));   
        	 }
        	
             
        }else{

        	System.out.println("Inside else ");
            columnEles = tableElement.findElements(By.xpath(".//tr[1]//td"));

            columnName.addAll(getValues(columnEles, e -> e.getText()));  


        }
        
        int index = 0;
        for(String colName: columnName){
        	index++;
        	columnIndex.put(colName, index);
        	
        }
        return columnName;
    }


    public String getCellValue(String columnName, int rowNumber){

        List<String> colNames = getColumnNames();

        int index = columnIndex.get(columnName);

       //index++;

        List<WebElement> cellElements =   tableElement.findElements(By.xpath(".//tr["+(++rowNumber)+"]/*["+index+"]"));

        List<String> cellValues =  getValues(cellElements, e -> e.getText());
        
        System.out.println(columnName+ ":" + cellValues);

        return cellValues.get(0);

    }

    public int getRowNumber(String columnName, String value){

        HashMap<String,String> valueTo = new HashMap<>();
        valueTo.put(columnName,value);
        return getRowNumber( valueTo).get(0);


    }
    
    public List<Integer> getMultiRowNumber(String columnName, String value){

        HashMap<String,String> valueTo = new HashMap<>();
        valueTo.put(columnName,value);
        return getRowNumber( valueTo);


    }

    public List<Integer> getRowNumber(HashMap<String,String> values){

    	List<Integer> matchingRows = new ArrayList<Integer>();
    	
        List<String> colNames = getColumnNames();

        Set<String> cols = values.keySet();

        List<WebElement> rowElements = tableElement.findElements(By.xpath(".//tr"));

        int rowNumber = -1;

       for(int i=1; i<rowElements.size();i++){

           boolean isMatching = true;

           for(String col: cols){

              int index= columnIndex.get(col);

              WebElement row =  rowElements.get(i);

              WebElement cell = row.findElement(By.xpath(".//td["+index+"]"));

              if(!cell.getText().trim().equals(values.get(col))){

                  isMatching = false;

                  break;

              }
           }

           if(isMatching){

        	   matchingRows.add(i);
               
               
           }


       }
        return matchingRows;

    }


    private List< String > getValues(List<WebElement> elements , Function<WebElement,String > pred) {

    	//System.out.println("in get values"+ elements.size());
    	
        List< String > values = elements.stream().map(pred)
                .collect(Collectors.toList());

        return values;


    }
    


}
