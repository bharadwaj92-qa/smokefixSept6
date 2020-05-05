package com.alerehealth.ui.portal.progress.trackers.activity;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityGoalPage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityJournalPage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityProgressPage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityTrackPage;

public class TrackersActivityBasePage extends TrackersBasePage {
    
	
	@FindBy(xpath = "//a[@class='selected icon icon_checkmark'][text()='Activity']")
	private WebElement lnkactivity;
	
	@FindBy(xpath="//div[@class='segmented-bar clear']//li/a")
	private List<WebElement> activityTabs;
	
	public void selectTopNavigationTabs(String tab)
	{
		for(WebElement element:activityTabs)
		{
			if(element.getText().equals(tab))
				
			{
				javaScriptClick(element);
			     break;
			}
		}
	}
	
	public List<String> isNavigationTabsDisplayed(){
		
		List<String>  tabs = new ArrayList<String>();
		
		for(WebElement element:activityTabs)
		{
			
			String value = element.getText().trim();
			tabs.add(value);
		}
		
		return tabs;
	}
	
	public TrackersActivityTrackPage navigateToTrackTab()
	{
		selectTopNavigationTabs("Track");
		return new TrackersActivityTrackPage();
	}
	
	public TrackersActivityProgressPage navigateToProgressTab()
	{
		selectTopNavigationTabs("Progress");
		return new TrackersActivityProgressPage();
	}
	
	public TrackersActivityJournalPage navigateToJournalPage()
	{
		selectTopNavigationTabs("Journal");
		return new TrackersActivityJournalPage();
	}
	
	public TrackersActivityGoalPage navigateToGoalPage()
	{
		selectTopNavigationTabs("Goal");
		return new TrackersActivityGoalPage();
	}
	

	@Override
	public boolean isDisplayed(){
		
		return lnkactivity.isDisplayed();
	}
	

}
