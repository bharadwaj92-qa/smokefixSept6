package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.ui.portal.qfl.InterventionConfirmationPage;
import com.alerehealth.ui.portal.qfl.SaveContactInfoPage;
import com.alerehealth.ui.portal.settings.TermsOfUsePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TOUPage extends PortalBasePage<TOUPage> {

    @FindBy(id="acceptTou")
    public WebElement acceptTouCheckbox;

    @FindBy(id="acceptTerms_0")
    public WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'mobile text messaging')]")
    private WebElement lnkMobileMessaging;

    private String mainWinHandle;
    private boolean isTermsOfUsePrintWindowOpen = false;
    private boolean isPrivacyPolicyWindowOpen = false;
    

    @FindBy(xpath = "//a[contains(@href,'touprivacy')]")
    private WebElement lnkPrivacy;

    @FindBy(className="printable-version")
    private WebElement lnkPrintableVersion;


    @FindBy(xpath="//a[contains(text(),'Text2Quit')]")
    private WebElement lnkTextToQuit;

    public void clickOnContinueButton(){

        continueButton.click();
    }
    
    public boolean isContinueButtonEnabled(){
    	
    	return continueButton.isEnabled();
    }


    public void checkAcceptTermsCheckbox(){

        //Click on checkbox isnt working as its a hidden element
       // acceptTouCheckbox.click();

        acceptTouCheckbox.findElement(By.xpath(".//following-sibling::label")).click();

      //  "//*[@id='acceptTou']/following-sibling::label"

    }

    public PortalHomePage acceptTerms(){

        checkAcceptTermsCheckbox();

        waitForElementToBeEnabled(continueButton);
        
        isContinueButtonEnabled();

        clickOnContinueButton();

        return  new PortalHomePage();

    }

    public PrintableTermsOfUsePage clickOnPrintableVersion(){

        mainWinHandle = getWebDriver().getWindowHandle();

        waitForElementToBeDisplayed(lnkPrintableVersion);

        lnkPrintableVersion.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        isTermsOfUsePrintWindowOpen =true;

        return new PrintableTermsOfUsePage();

    }

    public void switchBackToTermsOfUsePage(){

        getWebDriver().switchTo().window(mainWinHandle);

    }

    public MobileTextMessagingPage clickOnMobileTextMessaging(){


        mainWinHandle = getWebDriver().getWindowHandle();

        lnkMobileMessaging.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        return new MobileTextMessagingPage();
    }



    public void clickOnFooterLink(String footerLink){



        String xpath = "//a[@href='"+footerLink+"']";

        WebElement lnkFooter = getWebDriver().findElement( By.xpath(xpath));

        waitForElementToBeDisplayed(lnkFooter);
        lnkFooter.click();

    }

    public TermsOfUsePage clickOnFooterTerms(){


        mainWinHandle = getWebDriver().getWindowHandle();

        clickOnFooterLink("termsofuse");

        return new TermsOfUsePage();

    }

    public PrivacyPolicyPage clickOnPrivacyPolicy(){


        mainWinHandle = getWebDriver().getWindowHandle();

        lnkPrivacy.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        isPrivacyPolicyWindowOpen = true;

        return new PrivacyPolicyPage();
    }

    public TextToQuitPage clickOnText2Quit(){


        mainWinHandle = getWebDriver().getWindowHandle();

        lnkTextToQuit.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        return new TextToQuitPage();


    }

    public SaveContactInfoPage acceptTermsAndNavigateToContactInfoPage(){

        checkAcceptTermsCheckbox();

        waitForElementToBeEnabled(continueButton);

        clickOnContinueButton();
        
        try{
        	
        	String xpath = "//div[@class='btn btn--primary btn--continue']";
        	WebElement continueBtn = getWebDriver().findElement(By.xpath(xpath));
        	javaScriptClick(continueBtn);
        }
        
        catch(Exception e){
        	
        	System.out.println("Element not found");
        }

        return new SaveContactInfoPage();
    }
    
  
    
    

    public InterventionConfirmationPage accpetTermsAndNavigateToInterventionConfirmationScreen(){

        checkAcceptTermsCheckbox();

        waitForElementToBeEnabled(continueButton);

        clickOnContinueButton();

        return new InterventionConfirmationPage();


    }


    @Override
    public boolean isDisplayed() {

        scrollElementIntoView(acceptTouCheckbox);

        return continueButton.isDisplayed();

    }


}
