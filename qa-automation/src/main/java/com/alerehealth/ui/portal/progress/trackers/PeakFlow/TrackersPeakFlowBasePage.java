package com.alerehealth.ui.portal.progress.trackers.PeakFlow;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;


public class TrackersPeakFlowBasePage extends TrackersBasePage {
	
	@FindBy(xpath="//div[@class='segmented-bar clear']//li/a")
	private List<WebElement> a1cTabs;
	
	@FindBy(xpath = "//a[@class='selected icon icon_checkmark'][text()='Peak Flow']")
	private WebElement peakFlow;
	
	
	
	public void selectTopNavigationTabs(String tab)
	{
		for(WebElement element:a1cTabs)
		{
			if(element.getText().equals(tab))
				
			{
				javaScriptClick(element);
			     break;
			}
		}
	}
	
	public TrackersPeakFlowTrackBasePage navigateToTrackTab()
	{
		selectTopNavigationTabs("Track");
		return new TrackersPeakFlowTrackBasePage();
	}
	
	public TrackersPeakFlowProgressBasePage navigateToProgressTab()
	{
		selectTopNavigationTabs("Progress");
		return new TrackersPeakFlowProgressBasePage();
	}
	
	public TrackersPeakFlowJournalBasePage navigateToJournalPage()
	{
		selectTopNavigationTabs("Journal");
		return new TrackersPeakFlowJournalBasePage();
	}

	@Override
	public boolean isDisplayed(){
		
		return peakFlow.isDisplayed();
	}
	


}
