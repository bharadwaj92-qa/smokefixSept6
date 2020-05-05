package com.alerehealth.ui.portal.qfl;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanBannerPage;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.StringTokenizer;

public class NRTMedicationOrderViaActionPlan extends PortalHomePage {

    @FindBy(xpath = "//div[contains(@class,'single-step-form')]")
    private WebElement nrtAPForm;

    @FindBy(xpath="//a[contains(@class,'btn--primary')]")
    private WebElement enrollmentCompletedButton;

    @FindBy(xpath="//span[contains(text(),'saving your assessment now...')]")
    private WebElement waitForSavingAssessment;

    public void clickEnrollmentCompletedButton(){

        enrollmentCompletedButton.click();
    }


    /*public PortalHomePage clickNRTEnrollmentCompletedButton(){

        enrollmentCompletedButton.click();

        return new PortalHomePage();
    }*/


   /* public String getNRTMedication(){

        String xpath = "//form[@name='webOnlyMedStart']//header[@class='form-header']";

        WebElement question = getWebDriver().findElement(By.xpath(xpath));

        return question.getText().trim();

    }*/

    public void selectNRTMedication(String optionText){

        String xpath = "//div[contains(@class,'container-fluid')]//label[contains(text(),'"+optionText.trim()+"')]";

        WebElement optionRadio =  null;

        try {
            optionRadio = getWebDriver().findElement(By.xpath(xpath));
        }catch (NoSuchElementException no){

            xpath = "//div[contains(@class,'container-fluid')]//a[contains(text(),'"+optionText.trim()+"')]";

            optionRadio = getWebDriver().findElement(By.xpath(xpath));

        }

        javaScriptClick(optionRadio);

    }



    public String getNRTQuestion(){

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

    public void selectNRTFixedList(String optionText){

        String xpath = "//div[contains(@id,'FixedListSingleSelect')]//label[contains(text(),'"+optionText.trim()+"')]";

        WebElement optionRadio =  null;

        try {
            optionRadio = getWebDriver().findElement(By.xpath(xpath));
        }catch (NoSuchElementException no){

            xpath = "//div[contains(@id,'FixedListSingleSelect')]//label[contains(text(),'"+optionText.trim()+"')]";

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


                button.click();
                break;
            }
        }
    }



    public void clickTobaccoConfirm(String buttonText){

        String xpath = "//*[contains(@href,'tobaccoConfirm')]";
        List<WebElement> buttons = getWebDriver().findElements(By.xpath(xpath));

        for(WebElement button : buttons){

            if(button.getText().trim().contains(buttonText)){

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



    /*public PortalHomePage nrtQuestionairreSubmit(){

        selectNRTMedication("Yes");

        clickNRTButton("Continue");
        ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx","NRTMedication");
        excelReader.setStartRow(1);
        answerNRTQuestionnaire(excelReader);
        clickTobaccoConfirm("Continue");
        clickEnrollmentCompletedButton();
        return new PortalHomePage();
    }*/

    public ActionPlanBannerPage completeNRTActionPlan(ExcelReader excelReader){

        selectNRTMedication("Continue");

        answerNRTQuestionnaire(excelReader);
        waitForSpecifiedTime(40);
//        waitForElementToGoAway(waitForSavingAssessment);
        waitForElementToBeDisplayed(enrollmentCompletedButton);

        clickEnrollmentCompletedButton();

        return new ActionPlanBannerPage();
    }

    public void answerNRTQuestionnaire(ExcelReader excelReader){

        int questionsCount = excelReader.getRowCount();

        for (int i = excelReader.getStartRow() + 2; i <=questionsCount; i++) {

            String questionFromUI = getNRTQuestion();

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

                    selectNRTFixedList(option);

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

        waitForElementToBeDisplayed(nrtAPForm);
        return nrtAPForm.isDisplayed();
    }
}
