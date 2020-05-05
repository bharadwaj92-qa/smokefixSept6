    package com.alerehealth.ui.callcenter.mainmenu;



import com.alerehealth.fwk.selenium.common.TableHelper;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.NoSuchElementException;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
  

    public class CallCenterInteractionsPage extends CallCenterHomePage {
    	
    	
    	private TableHelper tableHelper ;
    	
    	
        @FindBy(id="f360h")
        private WebElement interactionsTabFrame;

        @FindBy(id="SearchInput")
        private WebElement searchInputSection;
        
        @FindBy(xpath="//span[contains(text(),'Interaction Log Search Inputs')]")
        private WebElement interactionTitle;
        

        @FindBy(xpath="//table[@pl_prop_class='Alere-FW-Apollo-Data-InteractionLog']")
		 private WebElement interactionLogResultTableElement;


        public void selectCheckBoxOfSection(String section, String checkBox){

            WebElement rowElement = null;
            try {
                rowElement  = getRowElementOfSearchInput(section);

            }catch (NoSuchElementException nse){

                rowElement=  getNextRowElementOfSearchInput(section);
            }

            WebElement checkBoxEle = getCheckBoxInRowBasedOnLabel(rowElement,checkBox);

            if(!checkBoxEle.isSelected()){

                checkBoxEle.click();
            }

        }

        private WebElement getRowElementOfSearchInput(String label){

            String xpath = "//table[@id='SearchInput']//label[text()='"+label+"']/ancestor::td[contains(@class,'standard_bold_dataLabel')]/..";

            WebElement rowElement = getWebDriver().findElement(By.xpath(xpath));

            return rowElement;

        }
        

        public void selectDropDownValueOfSection(String section, String value){

            String xpath = "(.//table[@id='SearchInput']//label[text()='"+section+"']/ancestor::td[contains(@class,'standard_bold_dataLabel')]/following-sibling::td)[1]//select";
            WebElement selectEle =  getWebDriver().findElement(By.xpath(xpath));

            Select select = new Select(selectEle);
            select.selectByVisibleText(value);

        }


        private WebElement getNextRowElementOfSearchInput(String label){

            String xpath = "(//table[@id='SearchInput']//label[text()='"+label+"']/ancestor::td[contains(@class,'standard_bold_dataLabel')]/..//following-sibling::tr)[1]";

            WebElement rowElement = getWebDriver().findElement(By.xpath(xpath));

            return rowElement;

        }

        private WebElement getCheckBoxInRowBasedOnLabel(WebElement rowElement , String checkBoxLabel){

            String xpath = "(.//label[text()='"+checkBoxLabel+"']/ancestor::td[contains(@class,'standard_dataLabelWrite')]//preceding-sibling::td)[last()]//input[@type='checkbox']";
            WebElement checkBox = rowElement.findElement(By.xpath(xpath));
            

            return checkBox;
        }




        public void clickSearch(){

            String xpath = "//button[@title='Search']";

            WebElement searchButton = getWebDriver().findElement(By.xpath(xpath));

            javaScriptClick(searchButton);

            waitForPageToLoad();

        }
        
        
        public void clickReset(){
        	
        	 String xpath = "//button[@name='SearchInteractionTypes_newInteractionLog_5']//div[contains(text(),'Reset')]";

             WebElement resetButton = getWebDriver().findElement(By.xpath(xpath));
             
             waitForElementToBeDisplayed(resetButton);

             javaScriptClick(resetButton);

             waitForPageToLoad();
        }

        public void closeInteractionLogSection(){

            String xpath = "//button[@title='Close']";

            WebElement closeButton = getWebDriver().findElement(By.xpath(xpath));

            javaScriptClick(closeButton);
        }

     
        @Override
        public boolean isDisplayed() {
            getWebDriver().switchTo().defaultContent();
            
            switchToFrame(pegaGadgetFrame360Tab);

            waitForPageToLoad();

            switchToFrame(interactionsTabFrame);

            waitForPageToLoad();


            return searchInputSection.isDisplayed();

        }
        
        public String  getTitleOfInteractionPage(){
        	
        	waitForElementToBeDisplayed(interactionTitle);
        	
            return interactionTitle.getText().trim();
        }

        public Boolean isjQueryLoaded()  {

            JavascriptExecutor js=(JavascriptExecutor)getWebDriver();
            return (Boolean) js.executeScript("return !!window.jQuery;");
        }
        
        public TableHelper getTableHelper() {
			return tableHelper;
		}

		public void setTableHelper(TableHelper tableHelper) {
			this.tableHelper = tableHelper;
		}
		
        
        
        public List<String>  getInteractionLogColumnNames(){
	    	
	    	setTableHelper(new TableHelper(getWebDriver(),interactionLogResultTableElement));
	    	
	    	List<String> cols = tableHelper.getColumnNames();
	    	
	    	System.out.println("Interaction Log result section  Column Names:" + cols);
	    	
	    	//waitForSpecifiedTime(8);
	    	
	    	return cols;
	    	
	    	
	    }
        
        
        public List<String> getInteractionLogResultsRowDataValue(String colName,String colValue, String colName1,String colName2){
            
        	setTableHelper(new TableHelper(getWebDriver(),interactionLogResultTableElement));
            List<Integer> value = tableHelper.getMultiRowNumber(colName,colValue);
            System.out.println("Row numbers:" + value);
            
            List<String>  interactionValues = new ArrayList<String>();
           
            for(Integer row: value){
            
            System.out.println(colName + ":" + colValue);
            interactionValues.add(tableHelper.getCellValue(colName1, row));
            interactionValues.add(tableHelper.getCellValue(colName2, row));
            
        }
            
            System.out.println(interactionValues);
            
            return interactionValues;
           }
        
        
    
    }
