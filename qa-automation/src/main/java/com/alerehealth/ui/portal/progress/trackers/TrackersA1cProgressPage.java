package com.alerehealth.ui.portal.progress.trackers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackersA1cProgressPage extends TrackersA1CBasePage{
	
	
	@FindBy(xpath="//div[@id='FitbitTrackerDiv']/div")
	private WebElement a1cGraph;
	
	
	public boolean verifyGraph()
	{
		return a1cGraph.isDisplayed();
	}
	
	@Override
	public boolean isDisplayed() {
	
	return a1cGraph.isDisplayed();
	}

}
