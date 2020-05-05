package com.alerehealth.ui.portal.qfl;


import com.alerehealth.fwk.selenium.common.SeleniumPage;

import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SaveContactInfoPage extends SeleniumPage<SaveContactInfoPage> {

    @FindBy(id="saveEnrollment")
    private WebElement saveEnrollmentForm;


    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    private WebElement continueButton;


    public void setTextField(String labelName , String text){

        String xpath = "//input[@type='text' and @aria-label='"+labelName+"']";

        getWebDriver().findElement(By.xpath(xpath)).clear();
        getWebDriver().findElement(By.xpath(xpath)).sendKeys(text);


    }

    public void selectDropDown(String labelName, String option){

        String xpath = "//form[@id='saveEnrollment']//select[@aria-label='"+labelName+"']";

        WebElement selectBoxWebEle = getWebDriver().findElement(By.xpath(xpath));

        Select select = new Select(selectBoxWebEle);

        select.selectByVisibleText(option);
    }

    public void selectRadioOption(String label, String option){

        String xpath = "//*[contains(text(),'"+label+"')]/../..//input[@type='radio' and @value='"+option+"']";

        getWebDriver().findElement(By.xpath(xpath)).click();

    }


    public ActionPlanQuestionnairePage clickContinue(){


        waitForElementToBeEnabled(continueButton);

        continueButton.click();

        waitForSpecifiedTime(40);
        return new ActionPlanQuestionnairePage();
    }
    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(saveEnrollmentForm);

        return saveEnrollmentForm.isDisplayed();
    }


}
