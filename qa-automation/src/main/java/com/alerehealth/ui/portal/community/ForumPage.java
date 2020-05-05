package com.alerehealth.ui.portal.community;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForumPage extends PortalHomePage {


    @FindBy(xpath = "//div[contains(@class, 'main--forum')]")
    private WebElement forumPageMainContainer;



    public void clickTab(String tab){

        String xpath = "//div[contains(@class,'tab')]//a[contains(text(),'"+tab+"')]";

        getWebDriver().findElement(By.xpath(xpath)).click();

        String xpathOfActive = "//div[contains(@class,'tab')]//a[contains(text(),'"+tab+"')]//ancestor::li[@class='tab active']";

        waitForComponentTobDisplayed(By.xpath(xpathOfActive));


    }


    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(forumPageMainContainer);
        return forumPageMainContainer.isDisplayed();
    }
    
    public CommunityNotificationsPage openCommunityNotificationsPage(){

    	navigateInTopMenu("Community>Notifications");
//        clickMenuItem("Community>Notifications");

        return new CommunityNotificationsPage();

    }
}
