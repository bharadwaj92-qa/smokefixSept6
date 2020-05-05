package com.alerehealth.ui.callcenter.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToParentFrame;
import org.openqa.selenium.support.FindBy;

public class CallCenterMyWorkBasketPage extends CallCenterHomePage {

	 @FindBy(xpath = "//a[@id='home_headerbar_icon_mywork_b']//i")
	 private WebElement myWorkIconHighlighted;
	
	 @FindBy(id = "$PpgRepPgSubSectionQ4LEngagementCallsWorkBasketBBB$ppxResults$l1")
	 private WebElement workItemsDueDateHighlighted;
	 
	public void selectMyWorkBasket(String workbasket){
		
		getWebDriver().switchTo().defaultContent();
		switchToFrame(searchCriteriaIframe);
		
		String workbasketXpath = "//*[contains(@title,'"+workbasket+"')]";
//		waitForSpecifiedTime(3000);
		WebElement elementworkbasket = getWebDriver().findElement(By.xpath(workbasketXpath));
		javaScriptClick(elementworkbasket);		
	}

	public void selectTestCasescheckbox(){
		
//		waitForSpecifiedTime(3000);
		switchToFrame(home_results_iframe);
		String testCasesCheckBox = "TestCasesCheck";
		WebElement testcasesCheckBox = getWebDriver().findElement(By.id(testCasesCheckBox));
		javaScriptClick(testcasesCheckBox);	
	}
	
	@Override
	public boolean duedateISDisplayed(){
		
		waitForElementToBeDisplayed(workItemsDueDateHighlighted);
		
		return workItemsDueDateHighlighted.isDisplayed();
		
	}
	
	public boolean isDisplayed(){
		
		waitForElementToBeDisplayed(myWorkIconHighlighted);
		
		return myWorkIconHighlighted.isDisplayed();		
		
	}


}



