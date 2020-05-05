package com.alerehealth.ui.portal.coaching;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Nurse24ChatWindowPage extends NurseAdviceLinePage{


    @FindBy(id="questionTxt")
    private WebElement question;

    @FindBy(xpath = "//button[contains(text(),'Start Chat')]")
    private WebElement startChart;

    @FindBy(xpath="//*[contains(@data-fv-result,'INVALID')]")
    private WebElement starChatValidationMessage;

    String mainWinHandle;

    public void closeChatWindow(){

        getWebDriver().close();

    }

    public void clickOnStartChatButton(){

        startChart.click();
    }

    public String getStartChatValidationMessage(){

        return starChatValidationMessage.getText().trim();
    }



    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(question);

        return question.isDisplayed();
    }
}
