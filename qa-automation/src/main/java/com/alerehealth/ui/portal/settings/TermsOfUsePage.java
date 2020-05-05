package com.alerehealth.ui.portal.settings;

import com.alerehealth.ui.portal.common.pages.MobileTextMessagingPage;
import com.alerehealth.ui.portal.common.pages.PrivacyPolicyPage;
import com.alerehealth.ui.portal.common.pages.TextToQuitPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermsOfUsePage extends ProfilePage {

    @FindBy(xpath = "//div[@class='ogn__secondary-header ogn-container has-breadcrumbs']//following-sibling::h1")
    private WebElement termsOfUseTitle;

    @FindBy(xpath = "//a[contains(@href,'touprivacy')]")
    private WebElement lnkPrivacy;

    @FindBy(xpath="//a[contains(text(),'Text2Quit')]")
    private WebElement lnkTextToQuit;

    private String mainWinHandle;

    private boolean isPrivacyPolicyWindowOpen = false;
    
    @FindBy(xpath = "//a[contains(text(),'mobile text messaging')]")
    private WebElement lnkMobileMessaging;



    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(termsOfUseTitle);

        return termsOfUseTitle.isDisplayed();
    }

    public TextToQuitPage clickOnText2Quit(){


        mainWinHandle = getWebDriver().getWindowHandle();

        lnkTextToQuit.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        return new TextToQuitPage();


    }

    public PrivacyPolicyPage clickOnPrivacyPolicy(){


        mainWinHandle = getWebDriver().getWindowHandle();

        lnkPrivacy.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        isPrivacyPolicyWindowOpen = true;

        return new PrivacyPolicyPage();
    }
    
    public MobileTextMessagingPage clickOnMobileTextMessaging(){


        mainWinHandle = getWebDriver().getWindowHandle();

        lnkMobileMessaging.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        return new MobileTextMessagingPage();
    }


    public void switchBackToTermsOfUsePage(){

        getWebDriver().switchTo().window(mainWinHandle);

    }



    public boolean isPrivacyPolicyWindowOpened(){

        return isPrivacyPolicyWindowOpen;

    }
    
    
    public String getClientNameOptumHolderPara (String clientName)

    {
        String xpath = (clientName.toLowerCase().equals("Optum")) ? "//p[6]" : "//p[5]";

        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

        String paraContent = clientParagraph.getText().trim();

        System.out.println(paraContent);

        return paraContent;

    }
    
    
    public String getClientNamePronouncedHealthHolderPara (String clientName)

    {
        String xpath = (clientName.toLowerCase().equals("PronouncedHealth")) ? "//p[6]" : "//p[5]";

        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

        String paraContent = clientParagraph.getText().trim();

        System.out.println(paraContent);

        return paraContent;

    }
    
    public String getClientNameUnitedHealthHolderPara (String clientName)

    {
        String xpath = (clientName.toLowerCase().equals("unitedhealthcare")) ? "//p[6]" : "//p[5]";

        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

        String paraContent = clientParagraph.getText().trim();

        System.out.println(paraContent);

        return paraContent;

    }
    
    
    
    

}
