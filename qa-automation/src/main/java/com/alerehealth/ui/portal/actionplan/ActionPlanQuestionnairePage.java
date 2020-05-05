package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.excel.ExcelReader;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.qfl.NRTMedicationOrderPage;
import com.alerehealth.ui.portal.settings.YourProgramPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class ActionPlanQuestionnairePage extends PortalHomePage {

    @FindBy(name="userForm")
    private WebElement questionaireForm;

    @FindBy(xpath = "//a[contains(@href, 'miniAssessment')]")
    private WebElement backButtonAtErrorPage;

    @FindBy(xpath = "//*[@id='maincontent']/div[2]/p[1]")
    private WebElement getErrorMessageText;

    @FindBy(xpath="//a[contains(@class,'btn--primary')]")
    private WebElement enrollmentCompletedButton;
  
  
    public String getErrorMessageText() {

        return getErrorMessageText.getText().trim();
    }

    public void clickOnBackButtonAtErrorPage() {

        backButtonAtErrorPage.click();
    }

    public void setTextFieldValue(String textToEnter, int index){

        String xpath = "//form[@name='userForm']//input[@type='number']";

        List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

        textFields.get(index).clear();
        textFields.get(index).sendKeys(textToEnter);

    }

    public void setDateFieldValue(String noOfDays){
    	
    	  getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          String xpath = "//form[@name='userForm']//div[@class='input select date  select-pickdate-fix']//input[@id='OHC20']";

          WebElement textFieldDate =  null;

          try {
        	  textFieldDate = getWebDriver().findElement(By.xpath(xpath));
        	  
        	 
        	  
          }catch (NoSuchElementException no){

              xpath = "//form[@name='userForm']//input[@id='dateafter']";

              textFieldDate = getWebDriver().findElement(By.xpath(xpath));
              
          }
          
          int result = Integer.parseInt(noOfDays);
          
    	  textFieldDate.clear();
    	  textFieldDate.sendKeys(DateTimeUtils.getFutureDate("MM/dd/yyyy",result));
          
          getWebDriver().manage().timeouts().implicitlyWait(this.waitDuration, TimeUnit.SECONDS);
        
    }


    public void clickQuestionaireButton(String buttonText){

        String xpath = "//form[@name='userForm']//button";

        List<WebElement> buttons = getWebDriver().findElements(By.xpath(xpath));

        for(WebElement button : buttons){

            if(button.getText().trim().contains(buttonText)){

                //javaScriptClick(button);
                button.click();
                break;
            }
        }

    }

    public String getQuestion(){

        String xpath = "//form[@name='userForm']//span[@class='ng-binding']";

        WebElement question = getWebDriver().findElement(By.xpath(xpath));

        return question.getText().trim();

    }



    public void selectFixedListRadioButton(String optionText){

        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String xpath = "//div[contains(@id,'FixedListSingleSelect')]//label/span[contains(text(),'"+optionText+"')]";

        WebElement optionRadio =  null;

        try {
            optionRadio = getWebDriver().findElement(By.xpath(xpath));
        }catch (NoSuchElementException no){

            xpath = "//div[contains(@id,'FixedListSingleSelect')]//label[contains(text(),'"+optionText+"')]";

            optionRadio = getWebDriver().findElement(By.xpath(xpath));

        }

        javaScriptClick(optionRadio);

        getWebDriver().manage().timeouts().implicitlyWait(this.waitDuration, TimeUnit.SECONDS);

    }

    public void selectOptionFromMultiSelectForMultipleQUestionnaire(String option){

        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        String xpath = "//div[contains(@id,'MultiSelect')]//label[contains(text(),'"+option+"')]";
        WebElement multiSelectOption = null;
        try {
    
            if(isContinueButtonEnabled()==true) {
            
                   System.out.println("Option is already selected");
            }
            
            else  {
            	
            	 multiSelectOption  = getWebDriver().findElement(By.xpath(xpath));
                 javaScriptClick(multiSelectOption);
                 
            }
 
            
        }catch (NoSuchElementException e){
     
           xpath = "//div[contains(@id,'MultiSelect')]//label//span[contains(text(),'"+option+"')]";

            multiSelectOption  = getWebDriver().findElement(By.xpath(xpath));
            
           String value = multiSelectOption.getAttribute("ng-if");
           
           if(value.equals("item.selected == true")){
        	   
        	   System.out.println("Already selected");
           }
           
           else  {
        	   
        		javaScriptClick(multiSelectOption);
           }

        }
     
       
        getWebDriver().manage().timeouts().implicitlyWait(this.waitDuration, TimeUnit.SECONDS);
        
        
    }
    
    public void selectOptionFromMultiSelect(String option){

        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String xpath = "//div[contains(@id,'MultiSelect')]//label[contains(text(),'"+option+"')]";

        WebElement multiSelectOption = null;
        try {
            multiSelectOption  = getWebDriver().findElement(By.xpath(xpath));
        }catch (NoSuchElementException e){

            xpath = "//div[contains(@id,'MultiSelect')]//label//span[contains(text(),'"+option+"')]";

            multiSelectOption  = getWebDriver().findElement(By.xpath(xpath));

        }
        javaScriptClick(multiSelectOption);
        getWebDriver().manage().timeouts().implicitlyWait(this.waitDuration, TimeUnit.SECONDS);
    }
  
    public GoalsHomePage answerActionPlanQuestionsFromExcel(ExcelReader excelReader) throws Exception {

        int questionsCount = excelReader.getRowCount();

        for (int i = excelReader.getStartRow() + 2; i <=questionsCount; i++) {

            String questionFromUI = getQuestion();

            System.out.println("Question from UI is:" + questionFromUI);

            String questionFromExcel = excelReader.getCellValue("Question Text", i);

            if (!questionFromUI.contentEquals(questionFromExcel)) {

                LoggerUtils.error("Question text from UI doesnt match with excel");
                LoggerUtils.warning("questionFromUI:" + questionFromUI);
                LoggerUtils.warning("questionFromExcel:" + questionFromExcel);

            }


            String optionsStringFromExcel = excelReader.getCellValue("Answer Options", i);


            String controlType = excelReader.getCellValue("Control Type", i);

            controlType = ((controlType == null) || (controlType.isEmpty())) ? "HEADER" : controlType;

            ActionPlanControls control = ActionPlanControls.valueOf(controlType.toUpperCase());

            String option = excelReader.getCellValue("Option to Select", i);

            switch (control) {


                case FIXEDLIST: {

                    selectFixedListRadioButton(option);

                    break;
                }
                case DATEFIELD: {

                    setDateFieldValue(option);

                    break;

                }
                case TEXTFIELD: {

                    System.out.println("Entering these into textfield**" + option + "**");

                    option = option.trim();

                    StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                    int index = 0;

                    while (stringTokenizer.hasMoreElements()) {

                        String value = (String) stringTokenizer.nextToken();

                        LoggerUtils.info("Entering " + value + " into textfield");

                        setTextFieldValue(value, index);

                        index++;
                    }

                    break;
                }
                case MULTISELECT:{

                    selectOptionFromMultiSelect(option);

                    break;
                }
                default: {

                    LoggerUtils.info("Header row");
                }
            }

            clickQuestionaireButton("Continue");


        }

        return new GoalsHomePage();

    }
    
    
 public boolean isContinueButtonEnabled(){
	 
	 String xpath = "//form[@name='userForm']//button[contains(text(),'Continue')]";
	 WebElement continueButton =getWebDriver().findElement(By.xpath(xpath));
    	
    	return continueButton.isEnabled();
    }


    public ActionPlanSetYourGoal answerActionPlanQuestionsFromExcelWeightTalk(ExcelReader excelReader) throws Exception {

        answerQuestionsFromExcel(excelReader);

        return new ActionPlanSetYourGoal();

    }

    public void answerQuestionsFromExcel(ExcelReader excelReader) {

        int questionsCount = excelReader.getRowCount();

        for (int i = excelReader.getStartRow() + 2; i <= questionsCount; i++) {

            String questionFromUI = getQuestion();

            System.out.println("Question from UI is:" + questionFromUI);

            String questionFromExcel = excelReader.getCellValue("Question Text", i);

            if (!questionFromUI.contentEquals(questionFromExcel)) {

                LoggerUtils.error("Question text from UI doesnt match with excel");
                LoggerUtils.warning("questionFromUI:" + questionFromUI);
                LoggerUtils.warning("questionFromExcel:" + questionFromExcel);

            }

            String optionsStringFromExcel = excelReader.getCellValue("Answer Options", i);

            String controlType = excelReader.getCellValue("Control Type", i);

            controlType = ((controlType == null) || (controlType.isEmpty())) ? "HEADER" : controlType;

            ActionPlanControls control = ActionPlanControls.valueOf(controlType.toUpperCase());

            String option = excelReader.getCellValue("Option to Select", i);

            switch (control) {

                case FIXEDLIST: {

                    selectFixedListRadioButton(option);

                    break;
                }

                case DATEFIELD: {

                    setDateFieldValue(option);

                    break;

                }
                case TEXTFIELD: {

                    System.out.println("Entering these into textfield**" + option + "**");

                    option = option.trim();

                    StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                    int index = 0;

                    while (stringTokenizer.hasMoreElements()) {

                        String value = (String) stringTokenizer.nextToken();

                        LoggerUtils.info("Entering " + value + " into textfield");

                        setTextFieldValue(value, index);

                        index++;
                    }

                    break;
                }
                case MULTISELECT: {

                    selectOptionFromMultiSelect(option);

                    break;
                }
                default: {

                    LoggerUtils.info("Header row");
                }
            }

            clickQuestionaireButton("Continue");

        }

    }
    public void answerEnrollmentQuestionnaire(ExcelReader excelReader){
    	
    	System.out.println(excelReader.getExcelSheet().getSheetName());

        int questionsCount = excelReader.getRowCount();
        
        System.out.println("Row count" +questionsCount);

        for (int i = excelReader.getStartRow() + 2; i <=questionsCount; i++) {

            String questionFromUI = getQuestion();

            System.out.println("Question from UI is:" + questionFromUI);

            String questionFromExcel = excelReader.getCellValue("Question Text", i);
            
            System.out.println("Question from Excel is:" +questionFromExcel);
            
            //System.out.println(excelReader.getRowCount());

            if (!questionFromUI.contentEquals(questionFromExcel)) {

                LoggerUtils.error("Question text from UI doesnt match with excel");
                LoggerUtils.warning("questionFromUI:" + questionFromUI);
                LoggerUtils.warning("questionFromExcel:" + questionFromExcel);

            }

            
            String optionsStringFromExcel = excelReader.getCellValue("Answer Options", i);


            String controlType = excelReader.getCellValue("Control Type", i);

            controlType = ((controlType == null) || (controlType.isEmpty())) ? "HEADER" : controlType;

            ActionPlanControls control = ActionPlanControls.valueOf(controlType.toUpperCase());

            String option = excelReader.getCellValue("Option to Select", i);

            switch (control) {

                case SELECT: {

                    selectFromDropDown(option);

                    break;

                }

                case DATEFIELD: {

                    setDateFieldValue(option);

                    break;

                }

                case FIXEDLIST: {

                    selectFixedListRadioButton(option);

                    break;
                }
                case TEXTFIELD: {

                    System.out.println("Entering these into textfield**" + option + "**");

                    option = option.trim();

                    StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                    int index = 0;

                    while (stringTokenizer.hasMoreElements()) {

                        String value = (String) stringTokenizer.nextToken();
                        LoggerUtils.info("Entering " + value + " into textfield");

                        setTextFieldValue(value, index);

                        index++;
                    }

                    break;
                }

                case NUMERICFIELD:{

                    System.out.println("Entering these into textfield**" + option + "**");

                    option = option.trim();

                    StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                    int index = 0;

                    while (stringTokenizer.hasMoreElements()) {

                        String value = (String) stringTokenizer.nextToken();

                        LoggerUtils.info("Entering " + value + " into textfield");

                        setNumericTextFieldValue(value, index);

                        index++;
                    }


                    break;
                }

                case MULTISELECT:{

                    selectOptionFromMultiSelect(option);

                    break;
                }
                case CHECKBOX:{

                    System.out.println("Selected option in UI:" +option);

                    selectMobileTOUCheckBox(option);

                    break;

                }

                default: {

                    LoggerUtils.info("Header row");
                }
            }

            clickQuestionaireButton("Continue");


        }

    }
    
    
    public NRTMedicationOrderPage answerEnrollmentQuestionnaireFromExcel(ExcelReader excelReader){
        
        answerEnrollmentQuestionnaire(excelReader);


        return new NRTMedicationOrderPage();
    }
    
    
public NRTMedicationOrderPage answerMultipleEnrollmentQuestionnaireFromExcel(ExcelReader excelReader){
        
	answerMultipleEnrollmentQuestionnaire(excelReader);

	 
	try{
		
   		System.out.println("Checking for Quit now page");
  		String nextXpath="//a[contains(text(),'Next')]";
  		WebElement nextBtn = getWebDriver().findElement(By.xpath(nextXpath));
  		javaScriptClick(nextBtn);
  		waitForSpecifiedTime(4);
  		enrollmentCompletedButton.click();
	    waitForSpecifiedTime(5);
	}

	  catch(Exception e){
		     
		  System.out.println("Quitnow page is not displayed");
		
	}
  

        return new NRTMedicationOrderPage();
    }
    
    
 public void answerMultipleEnrollmentQuestionnaire(ExcelReader excelReader){
    	
    	System.out.println(excelReader.getExcelSheet().getSheetName());

        int questionsCount = excelReader.getRowCount();
        
        System.out.println("Row count" +questionsCount);

        for (int i = excelReader.getStartRow() + 2; i <=questionsCount; i++) {

            String questionFromUI = getQuestion();

            System.out.println("Question from UI is:" + questionFromUI);

            String questionFromExcel = excelReader.getCellValue("Question Text", i);
            
            System.out.println("Question from Excel is:" +questionFromExcel);
            
            //System.out.println(excelReader.getRowCount());

            if (!questionFromUI.contentEquals(questionFromExcel)) {

                LoggerUtils.error("Question text from UI doesnt match with excel");
                LoggerUtils.warning("questionFromUI:" + questionFromUI);
                LoggerUtils.warning("questionFromExcel:" + questionFromExcel);

            }

            
            String optionsStringFromExcel = excelReader.getCellValue("Answer Options", i);


            String controlType = excelReader.getCellValue("Control Type", i);

            controlType = ((controlType == null) || (controlType.isEmpty())) ? "HEADER" : controlType;

            ActionPlanControls control = ActionPlanControls.valueOf(controlType.toUpperCase());

            String option = excelReader.getCellValue("Option to Select", i);

            switch (control) {

                case SELECT: {

                    selectFromDropDown(option);

                    break;

                }

                case DATEFIELD: {

                    setDateFieldValue(option);

                    break;

                }

                case FIXEDLIST: {

                    selectFixedListRadioButton(option);

                    break;
                }
                case TEXTFIELD: {

                    System.out.println("Entering these into textfield**" + option + "**");

                    option = option.trim();

                    StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                    int index = 0;

                    while (stringTokenizer.hasMoreElements()) {

                        String value = (String) stringTokenizer.nextToken();
                        LoggerUtils.info("Entering " + value + " into textfield");

                        setTextFieldValue(value, index);

                        index++;
                    }

                    break;
                }

                case NUMERICFIELD:{

                    System.out.println("Entering these into textfield**" + option + "**");

                    option = option.trim();

                    StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                    int index = 0;

                    while (stringTokenizer.hasMoreElements()) {

                        String value = (String) stringTokenizer.nextToken();

                        LoggerUtils.info("Entering " + value + " into textfield");

                        setNumericTextFieldValue(value, index);

                        index++;
                    }


                    break;
                }

                case MULTISELECT:{

                	selectOptionFromMultiSelectForMultipleQUestionnaire(option);

                    break;
                }
                case CHECKBOX:{

                    System.out.println("Selected option in UI:" +option);

                    selectMobileTOUCheckBox(option);

                    break;

                }

                default: {

                    LoggerUtils.info("Header row");
                }
            }

            clickQuestionaireButton("Continue");


        }

    }
    


   
    public void selectFromDropDown(String option){

        String xpath = "//*[@name='userForm']//select";

        WebElement selectBoxEle = getWebDriver().findElement(By.xpath(xpath));

        Select select = new Select(selectBoxEle);

        select.selectByVisibleText(option);
    }

    public void setNumericTextFieldValue(String textToEnter, int index){

        String xpath = "//form[@name='userForm']//input[@name='NumericInput']";

        List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

        textFields.get(index).clear();
        waitForSpecifiedTime(4);
        textFields.get(index).sendKeys(textToEnter);

    }

    public void selectMobileTOUCheckBox(String optionText){

        String xpath = "//form[@name='userForm']//span[contains(text(), '"+optionText+"')]";

        WebElement optionCheck = getWebDriver().findElement(By.xpath(xpath));

        waitForElementToBeDisplayed(optionCheck);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)(getWebDriver());
        javascriptExecutor.executeScript("arguments[0].click();", optionCheck);

        System.out.println("Selcted option chkbox:" +optionCheck);
    }
    
    
    public PortalHomePage clickEnrollmentCompletedButton(){
    	
    	 enrollmentCompletedButton.click();
    	 
    	 waitForSpecifiedTime(5);

         return new PortalHomePage();
    }
    
    
    
    
    public YourProgramPage clickEnrollCompleteButton(){
    	
   	 enrollmentCompletedButton.click();
   	 
   	 waitForSpecifiedTime(5);

        return new YourProgramPage();
   }

    public PortalHomePage clickEnrollmentCompletionButton(){
    	
          try{
    		
    		enrollmentCompletedButton.click();
    	        
    	}
    	
    	catch(Exception e){
   		     
    		e.printStackTrace();
     		System.out.println("Quit now page displayed");
    		String nextXpath="//a[contains(text(),'Next')]";
    		WebElement nextBtn = getWebDriver().findElement(By.xpath(nextXpath));
    		javaScriptClick(nextBtn);
    		waitForSpecifiedTime(4);
    		enrollmentCompletedButton.click();
	        waitForSpecifiedTime(5);
    		
    	}
        
      
        return new PortalHomePage();
    }
    
    
    public NRTMedicationOrderPage answerEnrollQuestionnaire(ExcelReader excelReader){
  
    	 answerEnrollmentQuestionnaire(excelReader);
    	 
    	try{
    		
       		System.out.println("Checking for Quit now page");
      		String nextXpath="//a[contains(text(),'Next')]";
      		WebElement nextBtn = getWebDriver().findElement(By.xpath(nextXpath));
      		javaScriptClick(nextBtn);
      		waitForSpecifiedTime(4);
      		enrollmentCompletedButton.click();
    	    waitForSpecifiedTime(5);
    	}
  
  	  catch(Exception e){
 		     
  		  System.out.println("Quitnow page is not displayed");
  		
  	}
      
    
      return new NRTMedicationOrderPage();
  }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(questionaireForm);
        return questionaireForm.isDisplayed();
    }
}
