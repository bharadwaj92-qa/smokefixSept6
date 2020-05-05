package com.alerehealth.ui.portal.community;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityNotificationsPage extends PortalHomePage {


    @FindBy(className = "notify-link")
    private WebElement notificationSettingsLink;


    public void clickTab(String tab){

        String xpath = "//div[contains(@class,'tab')]//a[contains(text(),'"+tab+"')]";

        getWebDriver().findElement(By.xpath(xpath)).click();

        String xpathOfActive = "//div[contains(@class,'tab')]//a[contains(text(),'"+tab+"')]//ancestor::li[@class='tab active']";

        waitForComponentTobDisplayed(By.xpath(xpathOfActive));


    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(notificationSettingsLink);

        return notificationSettingsLink.isDisplayed();
    }
    
    

}
