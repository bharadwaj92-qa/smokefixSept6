package com.alerehealth.ui.callcenter.common.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HIPAAScreenPage extends CallCenterToDosPage {
	
	@FindBy(id = "PegaGadget0Ifr")
    public WebElement iframe1;
    
    @FindBy(id = "convIframe")
    public WebElement iframe2;
    
    @FindBy(name = "actionIFrame")
    public WebElement actioniframe;
    
    @FindBy(id = "convIframe_sub")
    public WebElement convsubframe;
    
    @FindBy(xpath = "//input[@id='WarmTransferHIPAA']")
    public WebElement warmTransfer;
    
    @FindBy(xpath = "//button[@id='submitButton']")
    public WebElement submitbtn;
    
    @FindBy(xpath = "//div[contains(@data-node-id,'VerifyParticipant')]//td[contains(text(),'Warm Transfer')]")
    public WebElement warmTransferText;
    
    @FindBy(xpath = "//img[contains(@title,'Click to Update Agent ID')]")
    public WebElement saveImgBtn;
    
    @FindBy(id="PegaGadget0Ifr")
	public WebElement Pega360PageIframe;
    
    @FindBy(xpath = "//select[contains(@id,'ActionOptions')]")
    public WebElement takeActionDropdwn;

    
    public ProgramEnrollmentPage clickOnWarmTransfer() throws Exception{
	        
	    	WebDriverWait WDwait = new WebDriverWait(getWebDriver(), 65);
	    	
	    	try{
	    	switchToDefault();
	    	
	    	switchToFrame(iframe1);
	    	
	    	waitForPageToLoad();
	    	
	    	switchToFrame(convsubframe);
	    	
	    	System.out.println("convframe: "+convsubframe);
	    	
	    	waitForPageToLoad();
	    	
	    	switchToFrame(actioniframe);
	    	
	    	System.out.println("ActionIframe: "+actioniframe);
	    	
	    	waitForPageToLoad();
	    
	    	Thread.sleep(5000);
	    	System.out.println("waiting for warm transfer");
	    	WDwait.until(ExpectedConditions.visibilityOf(warmTransfer));
	    	System.out.println("warm transfer waiting for click");
	    	javaScriptClick(warmTransfer);

	    	System.out.println("Clicked on Warm Trasfer checkbox");
	    	
	    	waitForPageToLoad();
	    	
	    	//submitbtn.click();
	    	}catch (UnhandledAlertException f) {
	    	    try {
	    	        Alert alert = getWebDriver().switchTo().alert();
	    	        String alertText = alert.getText();
	    	        System.out.println("Alert data: " + alertText);
	    	        alert.accept();
	    	    } catch (NoAlertPresentException e) {
	    	        e.printStackTrace();
	    	    }
	    		//WDwait.until(ExpectedConditions.alertIsPresent());
	    	}
	    	 
			WDwait.until(ExpectedConditions.visibilityOf(submitbtn));
	    	
			Thread.sleep(3000);
			javaScriptClick(submitbtn);
	    	
	    	System.out.println("clicked on submit button");
	    	
	    	//Implicitwait();
	    	
	    	waitForSpecifiedTime(60);
	    	//waitForPageToLoad();
	    	
	    	return new ProgramEnrollmentPage();
	    	
	    }

    
    @Override
    public boolean isDisplayed() {
    	try {
		
    		  waitForPageToLoad();
    			
    		   getWebDriver().switchTo().defaultContent();
    			
    		   waitForPageToLoad();
    			
    		   switchToFrame(Pega360PageIframe);
    			
    		   waitForPageToLoad();
    		   
    		   switchToFrame(convsubframe);
        
			waitForElementToBeDisplayed(takeActionDropdwn);
        
			return takeActionDropdwn.isDisplayed();
    	
    	}catch (NoSuchElementException e) {

			return false;
		}

    }
    
    
}
