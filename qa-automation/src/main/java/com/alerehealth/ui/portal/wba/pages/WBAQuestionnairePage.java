package com.alerehealth.ui.portal.wba.pages;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.wba.entities.WBAQuestionnaireControls;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class WBAQuestionnairePage extends WBAHomePage<WBAQuestionnairePage> {

    @FindBy(xpath = "//question-template[@class='ng-isolate-scope']")
    private WebElement questionnaireRadioButtonsContainer;

    @FindBy(xpath = "//div[contains(@class,'error-box ')]/p")
    private WebElement errorMessage;

    @Override
    public boolean isDisplayed(){

    	waitForElementToBeDisplayed(questionnaireRadioButtonsContainer);

       return questionnaireRadioButtonsContainer.isDisplayed();

    }



    public String getQuestion(){

        WebElement question = getWebDriver().findElement(By.xpath("//*[@id='container--form-one']/header/h2/span"));

        waitForElementToBeDisplayed(question);

        return question.getText();

    }


    public void selectRadioButtonAnswer(String answer){

        String xpath = "//div[@class='col-md-6 col-sm-6 wba-radio-center']//span[contains(.,'"+answer+"')]/preceding-sibling::input[@type='radio']";
        WebElement radioButton = getWebDriver().findElement(By.xpath(xpath));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)(getWebDriver());
        javascriptExecutor.executeScript("arguments[0].click();", radioButton);


    }


    public void selectFixedListRadioButton(String optionText){

        String xpath = "//div[contains(@id,'FixedListSingleSelect')]//label[contains(text(),'"+optionText+"')]";

        WebElement optionRadio = getWebDriver().findElement(By.xpath(xpath));


        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)(getWebDriver());
        javascriptExecutor.executeScript("arguments[0].click();", optionRadio);

    }

    public void setTextFieldValue(String textFieldValue){

        String xpath = "//input[contains(@style,'textfield')]";

        WebElement textField = getWebDriver().findElement(By.xpath(xpath));

        textField.sendKeys(textFieldValue);
        textField.sendKeys(Keys.TAB);

    }

    public String getWBAQuestionnaireSection(){

        String xpath = "//span[contains(@ng-if,'processGroup.Title')]";

        String section = "Finished";
        try{
            section= getWebDriver().findElement(By.xpath(xpath)).getText().trim();

        }
         catch (Exception e) {

           	}
        return section;

    }


    public void selectCheckBox(String optionText) throws Exception{

        String xpath = "//div[contains(@id,'MultiSelectWBA')]//*[contains(text(),'"+optionText+"')]";

        WebElement optionCheck = getWebDriver().findElement(By.xpath(xpath));
        Thread.sleep(2000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)(getWebDriver());
        javascriptExecutor.executeScript("arguments[0].click();", optionCheck);
        System.out.println("Selcted option chkbox:" +optionCheck);
    }

    public List<String> getAllRadioButtonOptionsForQuestion(){

        String xpath = "//div[@class='col-md-6 col-sm-6 wba-radio-center']//span";

        List<String> answerOptions = new ArrayList<String>();

        List<WebElement> radioButtonsLabels = getWebDriver().findElements(By.xpath(xpath));

        LoggerUtils.info("getAllRadioButtonOptionsForQuestion(): No of Radio buttons for current question is "+ radioButtonsLabels.size());

        for(WebElement radioButtonLabel: radioButtonsLabels){

            String radioButtonLabelValue  = radioButtonLabel.getText().trim();

            LoggerUtils.info("getAllRadioButtonOptionsForQuestion(): "+radioButtonLabelValue+ " is one of the answer option");

            answerOptions.add(radioButtonLabelValue);

        }

        return answerOptions;

    }


    public List<String> getAllFixedListOptionsForQuestion(){

        String xpath = "//div[contains(@id,'FixedListSingleSelect')]//label";

        List<String> fixedListOptions = new ArrayList<String>();

        List<WebElement> fixedListRadioButtons = getWebDriver().findElements(By.xpath(xpath));

        LoggerUtils.info("getAllFixedListOptionsForQuestion(): No of Radio buttons for current question is "+ fixedListRadioButtons.size());

        for(WebElement radioButtonLabel: fixedListRadioButtons){

            String radioButtonLabelValue  = radioButtonLabel.getText().trim();

            LoggerUtils.info("getAllRadioButtonOptionsForQuestion(): "+radioButtonLabelValue+ " is one of the answer option");

            fixedListOptions.add(radioButtonLabelValue);

        }

        return fixedListOptions;

    }

    //Devika
    public List<String> getAllCheckboxOptionsForQuestion(){

        String xpath = "//div[contains(@ng-if,'x.AnswerOptions.AnswerOption.length')]//label";

        List<String> checkBoxOptions = new ArrayList<String>();

        List<WebElement> checkBoxbtn = getWebDriver().findElements(By.xpath(xpath));

        LoggerUtils.info("getAllCheckboxOptionsForQuestion(): No of checkboxes for current question is "+ checkBoxbtn.size());

        for(WebElement checkboxLabel: checkBoxbtn){

            String checkboxLabelValue  = checkboxLabel.getText().trim();

            LoggerUtils.info("getAllCheckboxOptionsForQuestion(): "+checkboxLabelValue+ " is one of the answer option");

            checkBoxOptions.add(checkboxLabelValue);

        }

        return checkBoxOptions;

    }

    public void answerWBAQuestionsFromExcel(ExcelReader excelReader) throws Exception {

        int questionsCount = excelReader.getRowCount();

        for (int i = excelReader.getStartRow() + 3; i < questionsCount; i++) {

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

            WBAQuestionnaireControls control = WBAQuestionnaireControls.valueOf(controlType.toUpperCase());

            String option = excelReader.getCellValue("Option to Select", i);


            option = regex(option);

            switch (control) {

                case RADIOBUTTON: {

                    System.out.println(getAllRadioButtonOptionsForQuestion());

                    System.out.println(getAnswerOptions(optionsStringFromExcel));

                    selectRadioButtonAnswer(option);

                    break;
                }
                case FIXEDLIST: {


                    System.out.println(getAllFixedListOptionsForQuestion());

                    System.out.println(getAnswerOptions(optionsStringFromExcel));

                    selectFixedListRadioButton(option);

                    break;
                }
                case CHECKBOX:{

                	System.out.println(getAllCheckboxOptionsForQuestion());

                    System.out.println(getAnswerOptions(optionsStringFromExcel));

                    System.out.println("Selected option in UI:" +option);

                    selectCheckBox(option);

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

                    String values[] = option.split(",");

                    for (String value : values) {

                        LoggerUtils.info("POst split" + value);

                    }

                    break;
                }

                default: {

                    LoggerUtils.info("Header row");
                }

            }


            String wbaSection = excelReader.getCellValue("WBA Section", i);

            String wbaSectionFromUI = getWBAQuestionnaireSection();

            System.out.println("WBA section from EXcel" + wbaSection);
            System.out.println("WBA section from UI" + wbaSectionFromUI);

            //TODO: Put an assert for

            if (!wbaSection.equals(wbaSectionFromUI)) {

                LoggerUtils.error("UI section is" + wbaSectionFromUI + " where as Excel ssheet says " + wbaSection);

            }

            clickQuestionarieButtons("Continue");


        }
    }

        private List<String> getAnswerOptions(String answerOptionFromExcel){

            String answerOptions[] = answerOptionFromExcel.split("\n");

            List<String> answers = new ArrayList<String>();

            for (String answerOption : answerOptions) {

                answerOption = regex(answerOption);

                answers.add(answerOption);

            }
            return answers;
        }

    public String regex(String text){

        return text.replaceAll("\\d\\.","").trim();
    }

    public void setTextFieldValue(String textFieldValue , int index){

        String xpath = "//input[contains(@style,'textfield')]";

        List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

        WebElement textField = textFields.get(index);

        textField.sendKeys(textFieldValue);
        textField.sendKeys(Keys.TAB);

    }

    public void getTextFieldValue(String textFieldValue, int index){

    	String xpath = "//input[contains(@style,'textfield')]";

        List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

        WebElement textField = textFields.get(index);

        textField.getText();
        textField.sendKeys(Keys.TAB);
        textField.getText();
    }


//For Save and Exit logic

public void answerWBAQuestionsFromExcel_SaveandExit(ExcelReader excelReader) throws Exception {

  //  int questionsCount = excelReader.getRowCount();

    for (int i = excelReader.getStartRow() + 3; i <=7; i++) {

        String questionFromUI = getQuestion();
        System.out.println("Question from UI is:" + questionFromUI);

        String questionFromExcel = excelReader.getCellValue("Question Text", i);
        System.out.println("Question from Excel is:" + questionFromExcel);

        if (!questionFromUI.contentEquals(questionFromExcel)) {

            LoggerUtils.error("Question text from UI doesnt match with excel");
            LoggerUtils.warning("questionFromUI:" + questionFromUI);
            LoggerUtils.warning("questionFromExcel:" + questionFromExcel);

        }


        String optionsStringFromExcel = excelReader.getCellValue("Answer Options", i);


        String controlType = excelReader.getCellValue("Control Type", i);

        controlType = ((controlType == null) || (controlType.isEmpty())) ? "HEADER" : controlType;

        WBAQuestionnaireControls control = WBAQuestionnaireControls.valueOf(controlType.toUpperCase());

        String option = excelReader.getCellValue("Option to Select", i);

        option = regex(option);

        switch (control) {

            case RADIOBUTTON: {

                System.out.println(getAllRadioButtonOptionsForQuestion());

                System.out.println(getAnswerOptions(optionsStringFromExcel));

                selectRadioButtonAnswer(option);

                break;
            }
            case FIXEDLIST: {


                System.out.println(getAllFixedListOptionsForQuestion());

                System.out.println(getAnswerOptions(optionsStringFromExcel));

                selectFixedListRadioButton(option);

                break;
            }
            case CHECKBOX:{

            	System.out.println(getAllCheckboxOptionsForQuestion());

                System.out.println(getAnswerOptions(optionsStringFromExcel));

                System.out.println("Selected option in UI:" +option);

                selectCheckBox(option);

                break;

            }
            case TEXTFIELD: {

            	if(option.isEmpty()){
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

                String values[] = option.split(",");

                for (String value : values) {

                    LoggerUtils.info("POst split" + value);

                }
            	}
            	else {

                option = option.trim();

                StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                int index = 0;
                while (stringTokenizer.hasMoreElements()) {

                    String value = (String) stringTokenizer.nextToken();
                    getTextFieldValue(value, index);
                    index++;
                    System.out.println("values:" +value);
                }

            }

            	break;
            }
            default: {

                LoggerUtils.info("Header row");
            }
        }


        String wbaSection = excelReader.getCellValue("WBA Section", i);

        String wbaSectionFromUI = getWBAQuestionnaireSection();

        System.out.println("WBA section from EXcel" + wbaSection);
        System.out.println("WBA section from UI" + wbaSectionFromUI);

        //TODO: Put an assert for

        if (!wbaSection.equals(wbaSectionFromUI)) {

            LoggerUtils.error("UI section is" + wbaSectionFromUI + " where as Excel ssheet says " + wbaSection);

        }

        clickQuestionarieButtons("Continue");


    }

    clickQuestionarieButtons("Previous");
}

/*
 * Creating this method for WBA Validations
 */


    public ReportSummary answerWBAQuestionsFromExcel_WBAValidations(ExcelReader excelReader) throws Exception {

        int questionsCount = excelReader.getRowCount();



        for (int i = excelReader.getStartRow() + 3; i <= questionsCount; i++) {

            String WBAQuestionNumber = excelReader.getCellValue("WBA Question Number", i);
            System.out.println("WBA Question = "+WBAQuestionNumber);
            if(WBAQuestionNumber.equals(null)||WBAQuestionNumber.equals("")){
                break;
            }

            String questionFromUI = getQuestion().trim();
            LoggerUtils.info("Question from UI is:" + questionFromUI);

            String questionFromExcel = excelReader.getCellValue("Question Text", i).trim();
            LoggerUtils.info("Question from Excel is:" + questionFromExcel);

            if (!questionFromUI.contentEquals(questionFromExcel)) {

                LoggerUtils.error("Question text from UI doesnt match with excel");
                LoggerUtils.warning("questionFromUI:" + questionFromUI);
                LoggerUtils.warning("questionFromExcel:" + questionFromExcel);

            }

            Assert.assertEquals("Verifying the Question text --> ",questionFromExcel,questionFromUI);


            String optionsStringFromExcel = excelReader.getCellValue("Answer Options", i);


            String controlType = excelReader.getCellValue("Control Type", i);

            controlType = ((controlType == null) || (controlType.isEmpty())) ? "HEADER" : controlType;

            WBAQuestionnaireControls control = WBAQuestionnaireControls.valueOf(controlType.toUpperCase());

            String option = excelReader.getCellValue("Option to Select", i);
            String validationMessage = excelReader.getCellValue("Validation Message", i);
            String validRange = excelReader.getCellValue("Valid Range", i);


            option = regex(option);

            switch (control) {

                case RADIOBUTTON: {

                    verifyContinueButtonForRequiredAndNotRequired(WBAQuestionNumber);

                    System.out.println(getAllRadioButtonOptionsForQuestion());

                    System.out.println(getAnswerOptions(optionsStringFromExcel));

                    Assert.assertEquals(getAnswerOptions(optionsStringFromExcel),getAllRadioButtonOptionsForQuestion());

                    selectRadioButtonAnswer(option);

                    break;
                }
                case FIXEDLIST: {

                    verifyContinueButtonForRequiredAndNotRequired(WBAQuestionNumber);

                    System.out.println(getAllFixedListOptionsForQuestion());

                    System.out.println(getAnswerOptions(optionsStringFromExcel));

                    Assert.assertEquals(getAnswerOptions(optionsStringFromExcel),getAllFixedListOptionsForQuestion());

                    selectFixedListRadioButton(option);

                    break;
                }
                case CHECKBOX:{

                    verifyContinueButtonForRequiredAndNotRequired(WBAQuestionNumber);

                    System.out.println(getAllCheckboxOptionsForQuestion());

                    System.out.println(getAnswerOptions(optionsStringFromExcel));

                    Assert.assertEquals(getAnswerOptions(optionsStringFromExcel),getAllCheckboxOptionsForQuestion());

                    System.out.println("Selected option in UI:" +option);

                    selectCheckBox(option);

                    break;

                }
                case TEXTFIELD: {
                    option = option.trim();
                    verifyContinueButtonForRequiredAndNotRequired(WBAQuestionNumber);
                    validatingTheTextField(option,validationMessage,validRange);
                    System.out.println("Entering these into textfield**" + option + "**");



                    StringTokenizer stringTokenizer = new StringTokenizer(option, ",");

                    int index = 0;
                    while (stringTokenizer.hasMoreElements()) {

                        String value = (String) stringTokenizer.nextToken();

                        LoggerUtils.info("Entering " + value + " into textfield");

                        setTextFieldValue(value, index);

                        index++;
                    }

                    String values[] = option.split(",");

                    for (String value : values) {

                        LoggerUtils.info("POst split" + value);

                    }

                    break;
                }

                default: {

                    LoggerUtils.info("Header row");
                }

            }


            String wbaSection = excelReader.getCellValue("WBA Section", i);

            String wbaSectionFromUI = getWBAQuestionnaireSection();

            System.out.println("WBA section from EXcel" + wbaSection);
            System.out.println("WBA section from UI" + wbaSectionFromUI);


            Assert.assertEquals(wbaSection.trim(), wbaSectionFromUI.trim());

            if (!wbaSection.equals(wbaSectionFromUI)) {

                LoggerUtils.error("UI section is" + wbaSectionFromUI + " where as Excel ssheet says " + wbaSection);

            }

            clickQuestionarieButtons("Continue");


        }
        return new ReportSummary();
    }




    private void verifyContinueButtonForRequiredAndNotRequired(String WBAQuestionNumber) throws Exception {

        List<String> WBAQuestionNumberList = Arrays.asList(WBAQuestionNumber.split(","));

        if(WBAQuestionNumberList.size()==1){
            validateContinueButton(WBAQuestionNumberList.get(0));
        }
        else{
            for (String WBAQuestionNum : WBAQuestionNumberList) {
                validateContinueButton(WBAQuestionNum);
            }
        }
    }

    private void validateContinueButton(String WBAQuestionNumber) throws Exception{

        List<String> WBANonReqQuestionsFromClientProp = Arrays.asList(ClientConfiguration.getClientConfiguration().getWBANonRquiredQuestions().split(","));
        LoggerUtils.info("Verifying whether the question is Requuired or Not Required ");
        LoggerUtils.info("List of NoN Required questions for Client ** "+ClientConfiguration.getClientConfiguration().getClientName()+" ** is :"+WBANonReqQuestionsFromClientProp);
        if(WBANonReqQuestionsFromClientProp.contains(WBAQuestionNumber)){
            Assert.assertTrue(verifyQuestionarieButtons("Continue"));
            LoggerUtils.info(WBAQuestionNumber+" is Non Required questions so Continue button is enabled");
        }
        else {
            Assert.assertFalse(verifyQuestionarieButtons("Continue"));
            LoggerUtils.info(WBAQuestionNumber+" is Required questions so Continue button is disabled");
        }
    }



    private void validatingTheTextField(String option, String validationMessage, String validRange) {


	String[] optionsToSelect = option.split(",");
	String[] validRanges = validRange.split(",");
	String[] validationMessages = validationMessage.split(",");


    if(optionsToSelect.length==1){
    	LoggerUtils.info("Validating text feilds with outOfRange Data :");
    	String validationMsg = validationMessages[0].replace("minValue", validRanges[0]);
    	validationMsg = validationMsg.replace("maxValue", validRanges[1]);
    	int minValue = (int) Float.parseFloat(validRanges[0]);
    	int maxValue = (int) Float.parseFloat(validRanges[1]);
    	for(int i =0;i<validRanges.length;i++){

    			setTextFieldValueWithOutTab((minValue<maxValue)? minValue-1 :maxValue+1, 0);
    			LoggerUtils.info("Error message from UI : "+errorMessage.getText());
    			LoggerUtils.info("Error message from Excel : "+validationMsg);

    			Assert.assertEquals("Asserting message from UI and Excel : ",validationMsg, errorMessage.getText());
    			clearTextFieldValueWithOutTab(0);
    			minValue = Integer.MAX_VALUE;

      	}

    }
    else {
    	for(int i =0;i<optionsToSelect.length;i++){

    		String[] ranges = validRanges[i].split("-");
    		int minValue = (int) Float.parseFloat(ranges[0]);
	    	int maxValue = (int) Float.parseFloat(ranges[1]);
    		for(int j =0;j<ranges.length;j++){

    	    	String validationMsg = validationMessages[i+1].replace("minValue",ranges[0]);
    	    	validationMsg = validationMsg.replace("maxValue", ranges[1]);
    			setTextFieldValueWithOutTab((minValue<maxValue)? minValue-1 :maxValue+1, i);
    			LoggerUtils.info("Error message from UI : "+errorMessage.getText());
    			LoggerUtils.info("Error message from Excel : "+validationMsg);

    			Assert.assertEquals("Asserting message from UI and Excel : ",validationMsg, errorMessage.getText());
    			clearTextFieldValueWithOutTab(i);
    			minValue = Integer.MAX_VALUE;

      	}
    		findTextFieldAndClickTab();
    	}
	}

}

public void setTextFieldValueWithOutTab(Integer textFieldValue , int index){

    String xpath = "//input[contains(@style,'textfield')]";

    List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

    WebElement textField = textFields.get(index);

    textField.sendKeys(textFieldValue.toString());
    LoggerUtils.info("Entering inValidValue **"+textFieldValue+"**in text feild");
  }

public void clearTextFieldValueWithOutTab(int index){

    String xpath = "//input[contains(@style,'textfield')]";

    List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

    WebElement textField = textFields.get(index);

    textField.clear();
    LoggerUtils.info("Clearing the entered inValidValue");
  }

public void findTextFieldAndClickTab(){

	String xpath = "//input[contains(@style,'textfield')]";

    List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

    WebElement textField = textFields.get(0);

    textField.sendKeys(Keys.TAB);;
    LoggerUtils.info("pressing TAB");
}






}
