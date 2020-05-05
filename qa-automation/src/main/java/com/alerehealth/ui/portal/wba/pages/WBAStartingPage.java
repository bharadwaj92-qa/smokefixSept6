package com.alerehealth.ui.portal.wba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.common.LoggerUtils;

public class WBAStartingPage extends WBAHomePage<WBAStartingPage> {


    @FindBy(xpath = "//div[@class='body--multi-form']//div[@class='row' and @data-ng-hide='step == -1' ]")
    public WebElement wbaStartingPage;
    @FindBy(xpath = "//*[@id='container--form-one']/header/h2/span")
    public WebElement wbaHeaderText;

    public WBAQuestionnairePage startWBAQuestionnaire() throws Exception {

    	System.out.println("Header Text:" +wbaHeaderText.getText());
        clickQuestionarieButtons("Continue");

        return new WBAQuestionnairePage();

    }
    


    public boolean isDisplayed(){
    	
    	waitForElementToBeDisplayed(wbaStartingPage);

        return wbaStartingPage.isDisplayed();

    }

}
