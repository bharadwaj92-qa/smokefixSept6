package com.alerehealth.ui.portal.coaching;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.usermenu.MessagesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NurseAdviceLinePage extends PortalHomePage{

    @FindBy(id="chatPop")
    private WebElement startChat;

    @FindBy(xpath = "//a[contains(@class,'messageCenterlink')]")
    private WebElement messageCenterLink;

    @FindBy(xpath = "//*[@class='coach-guide-description']//h2")
    private WebElement welcomeMsg;

    private String mainWinHandle;

    private boolean bchatWindowOpen = false;

    public Nurse24ChatWindowPage clickStartChat(){

      mainWinHandle = getWebDriver().getWindowHandle();

      startChat.click();

      waitForNewWindowToOpen(1);

      switchToNewWindow(mainWinHandle);
      
      bchatWindowOpen=true;

      return new Nurse24ChatWindowPage();

    }

    public boolean isChatWindowOpened(){

        return bchatWindowOpen;

    }

    /**
     * Helper method to switch back to nurse advice line page
     */
    public void switchBackToNurseAdviceLinePage(){

        getWebDriver().switchTo().window(mainWinHandle);

    }

    public MessagesPage openMessageCenter(){

        messageCenterLink.click();

        return new MessagesPage();
    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(startChat);
        return startChat.isDisplayed();
    }
    
    public String getNurse24PageWelcomeText(){

        return welcomeMsg.getText().trim();
    }
}
