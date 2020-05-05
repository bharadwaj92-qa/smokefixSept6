package com.alerehealth.ui.portal.qfl;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class QFLStartupPage extends SeleniumPage<QFLStartupPage> {

    @FindBy(xpath = "//div[contains(@class,'hero-marketing-q4l')]")
    private WebElement heroBannerContainer;

    @FindBy(xpath = "//div[contains(@class,'hero-marketing-q4l')]//a[@href='qflCheckAvailableInterventions']")
    private WebElement signUpButton;
    
    @FindBy(xpath = "//div[contains(@class,'ogn__header-right')]//a[@href='qflCheckAvailableInterventions']")
    private WebElement signUpLink;
    
    @FindBy(xpath="//li[contains(@class,'ogn-header-link-list')]//a[@href='login']")
    private WebElement loginLink;

    public QFLStartupPage(){

//       String qflBaseUrl = Configuration.getConfiguration().getQfl_client_url();
        String qflBaseUrl = ClientConfiguration.getClientConfiguration().getPortal_url_qfl();
        qflBaseUrl = qflBaseUrl.replace("<ClientCode>", ClientConfiguration.getClientConfiguration().getQflClientCode());
        qflBaseUrl = qflBaseUrl.replace("<ClientID>", ClientConfiguration.getClientConfiguration().getQflClientID());

        getWebDriver().get(qflBaseUrl);

    }
    public void clickContinueButton(String buttonText){

        String xpath = "//button[contains(@class,'btn--primary')]";

        List<WebElement> buttons = getWebDriver().findElements(By.xpath(xpath));

        for(WebElement button : buttons){

            if(button.getText().trim().contains(buttonText)){

                //javaScriptClick(button);
                button.click();
                break;
            }
        }
    }

    public void checkQFLEligibility(String option){

        String xpath = "//*[@name='checkQFLEligibility']//select";

        WebElement selectBoxEle = getWebDriver().findElement(By.xpath(xpath));

        Select select = new Select(selectBoxEle);

        select.selectByVisibleText(option);
    }

    public InterventionSelectionPage clickSignUp(){

        signUpButton.click();

        return new InterventionSelectionPage();

    }
    public InterventionSelectionPage clickSignUp(String option){

        signUpButton.click();

        if(!option.isEmpty()) {

            checkQFLEligibility(option);

            clickContinueButton("Continue");
        }
        return new InterventionSelectionPage();

    }
    public SignUpPage clickSignUpLink(){

        signUpButton.click();

        return new SignUpPage();

    }
    
    
    public QFLPreSignupPage clickSignUpBtn(){

    	signUpLink.click();
    	waitForSpecifiedTime(4);

        return new QFLPreSignupPage();

    }
    
    public PortalLoginPage clickLoginLink(){

        loginLink.click();

        return new PortalLoginPage();
    }
    
    
    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(heroBannerContainer);
        return heroBannerContainer.isDisplayed();
    }
}
