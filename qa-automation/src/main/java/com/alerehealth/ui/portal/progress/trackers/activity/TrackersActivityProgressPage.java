package com.alerehealth.ui.portal.progress.trackers.activity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackersActivityProgressPage extends TrackersActivityBasePage {
	
	@FindBy(xpath="//div[@class='content']//p")
	private WebElement progressPage;
	
    public String getProgressContent(){
		
		waitForElementToBeDisplayed(progressPage);
		
		return progressPage.getText().trim();
	}

	@Override
	public boolean isDisplayed(){
		
		return progressPage.isDisplayed();
	}

}
