package com.alerehealth.ui.portal.progress.trackers.nutrition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;


public class TrackersNutritionBasePage extends TrackersBasePage {
   
	@FindBy(xpath = "//a[@class='selected icon icon_checkmark'][text()='Nutrition']")
	private WebElement lnknutrition;
	
	@FindBy(xpath="//div[@class='segmented-bar clear']//li/a")
	private List<WebElement> nutritionTabs;
	
	public void selectTopNavigationTabs(String tab)
	{
		for(WebElement element:nutritionTabs)
		{
			if(element.getText().equals(tab))
				
			{
				javaScriptClick(element);
			     break;
			}
		}
	}
	
	public TrackersNutritionTrackPage navigateToTrackTab()
	{
		selectTopNavigationTabs("Track");
		return new TrackersNutritionTrackPage();
	}
	
	public TrackersNutritionProgressPage navigateToProgressTab()
	{
		selectTopNavigationTabs("Progress");
		return new TrackersNutritionProgressPage();
	}
	
	public TrackersNutritionJournalPage navigateToJournalPage()
	{
		selectTopNavigationTabs("Journal");
		return new TrackersNutritionJournalPage();
	}
	
	public TrackersNutritionGoalPage navigateToGoalPage()
	{
		selectTopNavigationTabs("Goal");
		return new TrackersNutritionGoalPage();
	}
	

	@Override
	public boolean isDisplayed(){
		
		return lnknutrition.isDisplayed();
	}
	

     
	
}
