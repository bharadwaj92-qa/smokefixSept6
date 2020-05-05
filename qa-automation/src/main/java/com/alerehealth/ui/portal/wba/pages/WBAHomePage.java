package com.alerehealth.ui.portal.wba.pages;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

import java.util.logging.Logger;

public class  WBAHomePage <T extends PortalHomePage> extends PortalHomePage {

    @FindBy(xpath = "//div[@class='component-items']")
    protected WebElement questionnaireDiv;

    @FindBy(xpath = "//form[@name='forms1']//button[text()='Get Started']")
    protected WebElement getStartedButton;

    @FindBy(xpath = "//div[@class='progress--bar']/span")
    protected WebElement progressBar;

    @FindBy(xpath ="//form[@name='forms1']//button[text()='Complete Assessment']")
    public WebElement completeAssessment;
    
    @FindBy(xpath ="//h1[contains(text(),'Take your Health Risk Questionnaire')]")
    public WebElement WBALandingPageText;
    
    @FindBy(xpath ="//h1[contains(text(),'Complete your Health Risk Questionnaire')]")
    public WebElement WBALandingPageTextForCompleteYourHRQ;
    
    
    public WBAStartingPage startQuestionnaire(){


        try {
           // getStartedButton.click();
            
        	javaScriptClick(getStartedButton);
            //System.out.println("get Started");
        }catch (NoSuchElementException noSuchElementException){

            LoggerUtils.warning("Clicking on Complete Assessment button as Get started button isnt  present");
            completeAssessment.click();
        }
        return new WBAStartingPage();

    }

    /*
     * getWBALandingPageText() Method returns the WBALandingPageText based on the Client WBAName
     */
    public String getWBALandingPageText(){
    	
    	String xpath ="//h1[contains(text(),'Take your "+ClientConfiguration.getClientConfiguration().getWBAName()+"')]";
    	return getWebDriver().findElement(By.xpath(xpath)).getText();
    	
    }
    
    /*
     * Method returns the WBALandingPageText for incomplete questionnaire page based on the Client WBAName
     */
    public String getWBALandingPageTextForCompleteYourHRQText(){
    	
    	String xpath ="//h1[contains(text(),'Complete your "+ClientConfiguration.getClientConfiguration().getWBAName()+"')]";
    	
    	return getWebDriver().findElement(By.xpath(xpath)).getText();
    	
    }
    
    /*
     * This method will handle Previous,SaveandExit,Continue button in questionnaire pages.
     */
    public void clickQuestionarieButtons(String button) throws Exception{

    	String xpath="//div[@class='form-btn-group ng-scope']//div[3]/button[contains(.,'"+button+"')]";

        WebElement buttonElement = getWebDriver().findElement(By.xpath(xpath));

        waitForElementToBeEnabled(buttonElement);

        buttonElement.click();

        LoggerUtils.info("Clicked on" +button+ "button in Questionnaire.");
        
        getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
       // return new ReportSummary();

    }
    
    /*
     * This method will verify Previous,SaveandExit,Continue button in questionnaire pages.
     */
    public boolean verifyQuestionarieButtons(String button) throws Exception{

    	String xpath="//div[@class='form-btn-group ng-scope']//div[3]/button[contains(.,'"+button+"')]";

        WebElement buttonElement = getWebDriver().findElement(By.xpath(xpath));

        waitForElementToBeDisplayed(buttonElement);

        return buttonElement.isEnabled();

        }
    
    public ReportSummary clickQuestionarieFinalContinueButtons(String button) throws Exception{

    	String xpath="//div[@class='form-btn-group ng-scope']//div[3]/button[contains(.,'"+button+"')]";

        WebElement buttonElement = getWebDriver().findElement(By.xpath(xpath));

        waitForElementToBeEnabled(buttonElement);

        buttonElement.click();

        LoggerUtils.info("Clicked on" +button+ "button in Questionnaire.");
        
        return new ReportSummary();

    }

    public String getProgressOfWBAQuestionnaire(){

        return progressBar.getText();
    }
    
    

    @Override
    public boolean isDisplayed(){

       return questionnaireDiv.isDisplayed();
    }
    
    /*
     * Click on view report for the user whose questionnaire was completed in home page and navigates 
     * to report summary page
     */
  	public ReportSummary verifyClickReportButton(String buttonName){
      	
  		String xpath = "//button[contains(text(),'"+buttonName+"')]";
      	
  		WebElement buttonNm = getWebDriver().findElement(By.xpath(xpath));
      	
      	String buttonText = buttonNm.getText().trim();
      	
      	LoggerUtils.info("Verified View Report button in WBA Completed state:" +buttonNm.getText());
      	
      	Assert.assertEquals(buttonName, buttonText);
      	
      	buttonNm.click();
      	
      	return new ReportSummary();
  	}
  	
   public void verifyClickButtonTextCompleteAss(String buttonName){
    	
    	String xpath = "//button[contains(text(),'"+buttonName+"')]";
    	
    	WebElement buttonNm = getWebDriver().findElement(By.xpath(xpath));
    	
    	System.out.println("Waiting for button to be clicked: ");
    	
    	//String buttonText = buttonNm.getText().trim();
    	
    	LoggerUtils.info("Verified the Complete Assessment button name in homepage for WBA Engaged state:" +buttonNm.getText());
       	
    	buttonNm.click();
    	
    }
    
    public boolean getverifyCompleteAssButtonText(String buttonName){
    	
    	String xpath = "//button[contains(text(),'"+buttonName+"')]";
  
    	return getWebDriver().findElement(By.xpath(xpath)).isDisplayed();
		  	
    }

}
