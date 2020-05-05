package com.alerehealth.ui.portal.settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityGuideLinesPage extends ProfilePage {

    @FindBy(xpath = "//div[contains(@class,'typography')]//*[text()='Community Guidelines']")
    private WebElement communityGuideLines;

    @FindBy(xpath = "//a[@href='profile']")
    private WebElement backLink;

    public ProfilePage clickBack(){

        backLink.click();

       return new ProfilePage();


    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(communityGuideLines);

        return communityGuideLines.isDisplayed();
    }
}
