package com.alerehealth.ui.portal.qfl;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EnrollmentQuestionnairePage extends SeleniumPage<EnrollmentQuestionnairePage> {


    @FindBy(name="userForm")
    private WebElement enrollmentQuestionnaireForm;






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


    @Override
    public boolean isDisplayed() {
        waitForElementToBeDisplayed(enrollmentQuestionnaireForm);
        return enrollmentQuestionnaireForm.isDisplayed();
    }
}
