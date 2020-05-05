package com.alerehealth.ui.callcenter.common.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.alerehealth.fwk.common.CallCenterConstants;

public class CallCenterReportIssuePage extends CallCenterHomePage {
	
	
    @FindBy(id="ReportIssueMainPageErrorCategorySlowness")
    public WebElement reportIssueCategory;
    
    @FindBy(id="ReportIssueMainPageAssistanceNeededI am able to continue working, I am just reporting this error")
    public WebElement reportIssueAssistanceNeeded;
    
    @FindBy(id="ApolloID")
    public WebElement reportIssueOptumID;
    
    @FindBy(id="SeqExpected")
    public WebElement reportIssueexpectingtohappen;
    
    @FindBy(id="SeqOccurred")
    public WebElement reportIssueExactSequence;
    
    @FindBy(id="WorkLocation")
    public WebElement reportIssueWorkLocation;
    
    @FindBy(id="CntSupervisor")
    public WebElement reportIssueCntSupervisor;
    
	@FindBy(xpath= "//*[@class='ui-button-text' and text()='Submit']")
    public WebElement reportIssueSubmit;
    
//	@FindBy(xpath= "//a[contains(text(),'Help.Desk@alere.com')]")
	@FindBy(xpath= "//*[text()='Please take a screenshot of the error and send it to the email address below:']")
    public WebElement reportIssueEmailValidation;
	
	public boolean isEmailTextPresent() {

		try {
			return reportIssueEmailValidation.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
	    
    public CallCenterReportIssuePage clickReportIssueSubmit(){
    	
    	String xpath= "//*[@class='ui-button-text' and text()='Submit']";
    	WebElement reportIssueSubmit= getWebDriver().findElement(By.xpath(xpath));
        javaScriptClick(reportIssueSubmit);
    	
		return null;

    }
    
    public void setCntSupervisor(String cntSupervisor) {

        this.reportIssueCntSupervisor.sendKeys(cntSupervisor);
    }
    
    public void setWorkLocation(String workLocation) {

        this.reportIssueWorkLocation.sendKeys(workLocation);
    }
    
    public void setExactSequence(String exactSequence) {

        this.reportIssueExactSequence.sendKeys(exactSequence);
    }
    
	public void selectSameIssueOption(int indexvalue){
				
		WebElement mySelectOption = getWebDriver().findElement(By.id("IsSameIssueAround"));
		Select elementOption= new Select(mySelectOption);
		elementOption.selectByIndex(indexvalue);
		
	}
    public CallCenterReportIssuePage clickCategoryRadio(){
    	
    	String xpath= "ReportIssueMainPageErrorCategorySlowness";
    	WebElement reportIssueCategoryRadio= getWebDriver().findElement(By.id(xpath));
        javaScriptClick(reportIssueCategoryRadio);
    	
		return null;

    }
    
    public CallCenterReportIssuePage clickAssistanceNeededRadio(){
    	
    	String xpath= "ReportIssueMainPageAssistanceNeededI am able to continue working, I am just reporting this error";
    	WebElement reportIssueAssistanceNeededRadio= getWebDriver().findElement(By.id(xpath));
        javaScriptClick(reportIssueAssistanceNeededRadio);
            	
		return null;

    }
        
    public void setoptumID(String optumID) {

        this.reportIssueOptumID.sendKeys(optumID);
    }

    public void setexpectingtohappen(String SeqExpected) {

        this.reportIssueexpectingtohappen.sendKeys(SeqExpected);
    } 
    
    public void reportIssueWindowValidation (String arg1) throws  InterruptedException, AWTException {
    	
    	String winHandleBefore = getWebDriver().getWindowHandle();
    	System.out.println(winHandleBefore);
    	// Perform the click operation that opens new window
    	clickReportIssueSubmit();

    	Thread.sleep(10000);
    	
    	Robot robot = new Robot(); 
    	
    	robot.keyPress(KeyEvent.VK_ENTER); 
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(10000);
        
        robot.keyPress(KeyEvent.VK_ENTER); 
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(10000);
        switchToNewWindow(winHandleBefore);
        
    	// Perform the actions on new window
    	
    	Assert.assertTrue("Validating ReportIssue Email Text", isEmailTextPresent()); 
 
    	// Close the new window, if that window no more required
    	getWebDriver().close();

    	// Switch back to original browser (first window)
    	getWebDriver().switchTo().window(winHandleBefore);
    }
    
}
