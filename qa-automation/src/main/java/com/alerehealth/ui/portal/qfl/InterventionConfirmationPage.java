package com.alerehealth.ui.portal.qfl;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.settings.ContactInfoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterventionConfirmationPage extends SeleniumPage<InterventionConfirmationPage> {

    @FindBy(id="container--form-one")
    private WebElement interventionPagecontainer;

    @FindBy(xpath = "//*[contains(@class,'btn--primary')]")
    private WebElement continueButton;

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(interventionPagecontainer);
        return interventionPagecontainer.isDisplayed();
    }

    public SaveContactInfoPage clickContinueButton() {

        continueButton.click();

        return new SaveContactInfoPage();

    }
}
