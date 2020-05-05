package com.alerehealth.ui.callcenter.mainmenu;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CallCenterAdvancedSearchPage extends CallCenterSmartSearchPage {


    @FindBy(id="home_criteria_table_sub_iframe")
    protected WebElement searchCriteriaIframe;


    @FindBy(id="PID")
    private WebElement optumIDTextField;

    @FindBy(id="SearchButton")
    private WebElement searchButton;


    public void setOptumID(String optumID){

        optumIDTextField.clear();

        optumIDTextField.sendKeys(optumID);

    }

    public void clickSearchButton(){

       // searchButton.click();

        javaScriptClick(searchButton);

        waitForPageToLoad();

    }




    @Override
    public boolean isDisplayed() {

        getWebDriver().switchTo().defaultContent();

        waitForElementToBeDisplayed(searchIconHighlighted);

        switchToFrame(searchCriteriaIframe);

        return optumIDTextField.isDisplayed();
    }
}
