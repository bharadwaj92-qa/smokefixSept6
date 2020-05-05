package com.alerehealth.ui.portal.qfl;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanControls;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.settings.YourProgramPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.StringTokenizer;

public class NRTMedicationOrderPage extends PortalHomePage {

    @FindBy(name = "webOnlyMedStart")
    private WebElement nrtForm;

    @FindBy(xpath="//a[contains(@class,'btn--primary')]")
    private WebElement enrollmentCompletedButton;

    @FindBy(xpath="//a[contains(@class,'btn--secondary')]")
    private WebElement nrtGetStarted;

    @FindBy(xpath="//*[@title='Home']")
    private WebElement goToHome;

    public void clickEnrollmentCompletedButton(){

        enrollmentCompletedButton.click();
    }
    /*public PortalHomePage clickNRTEnrollmentCompletedButton(){

        enrollmentCompletedButton.click();
        return new PortalHomePage();
    }*/
    public String getNRTMedication(){

        String xpath = "//form[@name='webOnlyMedStart']//header[@class='form-header']";

        WebElement question = getWebDriver().findElement(By.xpath(xpath));

        return question.getText().trim();

    }

    public void selectNRTMedication(String optionText){

        String xpath = "//div[contains(@class,'container-fluid')]//label[contains(text(),'"+optionText.trim()+"')]";

        WebElement optionRadio =  null;

        try {
            optionRadio = getWebDriver().findElement(By.xpath(xpath));
        }catch (NoSuchElementException no){

            xpath = "//div[contains(@class,'container-fluid')]//a[contains(text(),'"+optionText.trim()+"')]";
            //           xpath = "//*[contains(text(),'"+optionText+"')]";

            optionRadio = getWebDriver().findElement(By.xpath(xpath));



        }

        javaScriptClick(optionRadio);


    }
    public void selectFromBehaviourDropDown(String option){

        String xpath = "//*[@title='Behavior']";

        WebElement selectBoxEle = getWebDriver().findElement(By.xpath(xpath));

        Select select = new Select(selectBoxEle);

        select.selectByVisibleText(option);
    }
    public String NRTQuestions(){

        String xpath = "//span[@class='ng-binding']";

        WebElement question = getWebDriver().findElement(By.xpath(xpath));

        return question.getText().trim();

    }

    public void setNumericTextFieldValue(String textToEnter, int index){

        String xpath = "//form[@name='userForm']//input[@name='NumericInput']";

        List<WebElement> textFields = getWebDriver().findElements(By.xpath(xpath));

        textFields.get(index).clear();
        textFields.get(index).sendKeys(textToEnter);

    }

    public void NRTAnswers(String optionText){

        String xpath = "//div[contains(@id,'FixedListSingleSelect')]//label[contains(text(),'"+optionText.trim()+"')]";

        WebElement optionRadio =  null;

        try {
            optionRadio = getWebDriver().findElement(By.xpath(xpath));
        }catch (NoSuchElementException no){

            xpath = "//div[contains(@id,'FixedListSingleSelect')]//label[contains(text(),'"+optionText.trim()+"')]";
            //           xpath = "//*[contains(text(),'"+optionText+"')]";

            optionRadio = getWebDriver().findElement(By.xpath(xpath));

        }

        javaScriptClick(optionRadio);

    }
    public void selectNRTCheckBox(String optionText){

        String xpath = "//div[contains(@id,'MultiSelect')]//*[contains(text(),'"+optionText+"')]";

        WebElement optionCheck = getWebDriver().findElement(By.xpath(xpath));

        waitForElementToBeDisplayed(optionCheck);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)(getWebDriver());
        javascriptExecutor.executeScript("arguments[0].click();", optionCheck);
        System.out.println("Selcted option chkbox:" +optionCheck);
    }

    public void clickNRTButton(String buttonText){

        String xpath = "//button[contains(@class,'btn--primary')]";

        List<WebElement> buttons = getWebDriver().findElements(By.xpath(xpath));

        for(WebElement button : buttons){

            if(button.getText().trim().contains(buttonText)){

                //javaScriptClick(button);
                button.click();
                waitForSpecifiedTime(3);
                break;
            }
        }
    }

    public void clickTobaccoConfirm(String buttonText){

        String xpath = "//*[contains(@href,'tobaccoConfirm')]";
        List<WebElement> buttons = getWebDriver().findElements(By.xpath(xpath));

        for(WebElement button : buttons){

            if(button.getText().trim().contains(buttonText)){

                //javaScriptClick(button);
                button.click();
                break;
            }
        }

    }
    public void selectOptionFromMultiSelect(String option){

        String xpath = "//div[contains(@id,'MultiSelect')]//label[contains(text(),'"+option+"')]";

        WebElement multiSelectOption = null;
        try {
            multiSelectOption  = getWebDriver().findElement(By.xpath(xpath));
        }catch (NoSuchElementException e){

            xpath = "//div[contains(@id,'MultiSelect')]//label//span[contains(text(),'"+option+"')]";

            multiSelectOption  = getWebDriver().findElement(By.xpath(xpath));

        }
        javaScriptClick(multiSelectOption);

    }
    public PortalHomePage nrtQuestionairreSubmit(ExcelReader excelReader){
        selectNRTMedication("Yes");
        clickNRTButton("Continue");
        answerNRTQuestionnaire(excelReader);
        waitForSpecifiedTime(30);
        clickTobaccoConfirm("Continue");
        clickEnrollmentCompletedButton();
        return new PortalHomePage();
    }
    
    public YourProgramPage navigateToProgramConditionForIndividual(){
 
    	javaScriptClick(enrollmentCompletedButton);
    	waitForSpecifiedTime(5);
    	
    	String xpath = "//a[contains(@class,'btn--primary') and contains(text(),'Done')]";
    	WebElement DoneBtn = getWebDriver().findElement(By.xpath(xpath));
    	waitForElementToBeDisplayed(DoneBtn);
    	javaScriptClick(DoneBtn);
    	
    	return new YourProgramPage();
    	
    }
    
    
    public PortalHomePage navigateToPortalHomePageForWebCoach(){
    	
    	javaScriptClick(enrollmentCompletedButton);
    	waitForSpecifiedTime(5);
    	
    	String xpath = "//a[contains(@class,'btn--primary') and contains(text(),'Done')]";
    	WebElement DoneBtn = getWebDriver().findElement(By.xpath(xpath));
    	waitForElementToBeDisplayed(DoneBtn);
    	javaScriptClick(DoneBtn);
    	
    	
    	return new PortalHomePage();
    }
    
/*    public PortalHomePage nrtViaActionPlan(){
        selectFromBehaviourDropDown("Use Quit Medications");
        waitForElementToBeDisplayed(nrtGetStarted);
        nrtGetStarted.click();
        selectNRTMedication("Continue");
        ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLNRTFromActionPlanSheetName);
        excelReader.setStartRow(1);
        answerNRTQuestionnaire(excelReader);
        waitForSpecifiedTime(30);
        clickEnrollmentCompletedButton();
        goToHome.click();
        return new PortalHomePage();
    }*/
    public void answerNRTQuestionnaire(ExcelReader excelReader){

        int questionsCount = excelReader.getRowCount();

        for (int i = excelReader.getStartRow() + 2; i <=questionsCount; i++) {

            String questionFromUI = NRTQuestions();

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

            NRTMedicationControls control = NRTMedicationControls.valueOf(controlType.toUpperCase());

            String option = excelReader.getCellValue("Option to Select", i);

            switch (control) {

                case FIXEDLIST: {

                    NRTAnswers(option);

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

                    selectNRTCheckBox(option);

                    break;

                }
                default: {

                    LoggerUtils.info("Header row");
                }

            }

            clickNRTButton("Continue");


        }

//        clickEnrollmentCompletedButton();
    }
    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(nrtForm);
        return nrtForm.isDisplayed();
    }
}
