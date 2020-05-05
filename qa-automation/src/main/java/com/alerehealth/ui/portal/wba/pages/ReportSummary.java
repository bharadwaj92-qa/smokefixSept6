package com.alerehealth.ui.portal.wba.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.portal.wba.entities.WBAConstants;

public class ReportSummary extends WBAQuestionnairePage{
	
	@FindBy(xpath = "//div[contains(@class,'wba--activity-description')]/p[2]")
    private WebElement ResultSummaryDescription;
	
	@FindBy(xpath = "//div[@class='col-md-3 wba--activity-gauge']//strong[contains(text(),'Overall Wellbeing')]")
    private WebElement OverallWellbeingText;
	
	@FindBy(xpath = "//button[contains(text(),'View Report')]")
    private WebElement viewReportButton;
		
	@FindBy(xpath = "//header[@class='container-header']/h1")
    private WebElement reportSummaryHeader;
	
	/*
	 * This is the getMethod to get the ResultSummaryDescription WebElement
	 */
	public WebElement getResultSummaryDescriptionFromUI() {
		return ResultSummaryDescription;
	}
	
	public WebElement getReportSummaryHeaderFromUI() {
		return reportSummaryHeader;
	}
	
	/*
	 * This Method gets the ResultSummaryDescription from Constant based on the score value
	 * arguments : score
	 */
	public String getResultSummaryDescriptionFromConstant(String score){
		
		String text = "";
		if(Integer.parseInt(score)>=66 && Integer.parseInt(score)<=100){
			text = WBAConstants.WBA_Result_Summary_Description_66_100;
			}
		else if(Integer.parseInt(score)>=33 && Integer.parseInt(score)<=65){
			
			text = WBAConstants.WBA_Result_Summary_Description_33_65;
			}
		else {
			text = WBAConstants.WBA_Result_Summary_Description_0_32;
			}
		text = text.replace("TotalWBScore", score);
		text = text.replace("firstname", getLoggedInUserID());
		LoggerUtils.info("OverAll Srore Summary Text from Sheet ->"+text);
		return text;
		
		
	}
	
	/*
	 * clickOnViewReportButton() - Clicks on ViewReport Button on eportDetails Page
	 */
	public ReportDetailsPage clickOnViewReportButton(){
		
		javaScriptClick(viewReportButton);
		LoggerUtils.info("Clicked on view report button in report summary page");		
		return new ReportDetailsPage();
	}
	
	/*
	 * Getter method for viewReportButton
	 */
	public WebElement getViewReportButton() {
		return viewReportButton;
	}
	
	public String getLoggedInUserID(){
		String xpath = "//li[@class='ogn-header-link-list__account']/a";
		String userID = getWebDriver().findElement(By.xpath(xpath)).getText();
		System.out.println("User ID from Ui"+userID);
		userID = userID.split(" ",2)[0];
		LoggerUtils.info("UserID for LoggedIn User :"+userID);
		return userID;
	}
	
	/*public ReportDetailsPage clickOnViewReportWBAResultsPage(String buttonName){
		
		String xpath = "//button[contains(text(),'"+buttonName+"')]";
      	WebElement buttonNm = getWebDriver().findElement(By.xpath(xpath));
      	
      	String buttonText = buttonNm.getText().trim();
      	
      	LoggerUtils.info("Verified View Report button in WBA Completed state:" +buttonNm.getText());
      	
      	//Assert.assertEquals(buttonName, buttonText);
      	
      	buttonNm.click();
		
		return new ReportDetailsPage();
		
	}*/
	
	@Override
    public boolean isDisplayed() {
		//System.out.println("OverallScore in reportsummary");
		waitForElementToBeDisplayed(OverallWellbeingText);
        return true;
    }
	
}
