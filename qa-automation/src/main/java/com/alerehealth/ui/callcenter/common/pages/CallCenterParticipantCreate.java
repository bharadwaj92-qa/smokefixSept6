package com.alerehealth.ui.callcenter.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CallCenterParticipantCreate extends CallCenterHomePage {

	@FindBy(xpath = "//a[@id='home_headerbar_icon_other_b']//i")
	private WebElement otherIconHighlighted;

	@FindBy(xpath = "//*[contains(@name,'$PCreateInt$pParticipantID')]")
	private WebElement createParticipant;

	@FindBy(xpath = "//*[contains(@title,'Create Interaction')]/..//following-sibling::span//span[text()='Create']")
	private WebElement createButtonClick;
	
	
	
	public void enterParticipantID(String participantID) {

		switchToFrame(home_results_iframe);

		waitForElementToBeDisplayed(createParticipant);

		createParticipant.clear();

		createParticipant.sendKeys(participantID);

		createParticipant.sendKeys(Keys.ENTER);

	}
	
	public void clickCreateButton(){
		
		waitForElementToBeDisplayed(createButtonClick);
		
//		WebElement testcasesCheckBox = getWebDriver().findElement(By.xpath(createButtonClick));
		javaScriptClick(createButtonClick);	
		
	}
	

	@Override
	public boolean isDisplayed() {

		waitForElementToBeDisplayed(otherIconHighlighted);
		return otherIconHighlighted.isDisplayed();

	}
}
