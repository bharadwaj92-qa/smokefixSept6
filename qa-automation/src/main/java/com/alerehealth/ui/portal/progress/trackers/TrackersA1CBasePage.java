package com.alerehealth.ui.portal.progress.trackers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackersA1CBasePage extends TrackersBasePage {
	
	@FindBy(xpath="//div[@class='segmented-bar clear']//li/a")
	private List<WebElement> a1cTabs;
	
	
	@FindBy(xpath="//div[@class='page columns-sidebar']//h1")
	private WebElement a1cVerficationText;
	
	@FindBy(xpath="//div[contains(@class,'segmented-bar clear')]//*[@class='selected']")
	private WebElement tabVerfication;
	
	
	
	private void selectTopNavigationTabs(String tab)
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
	
	
	
	public TrackerA1CTrackPage navigateToTrackTab()
	{
		selectTopNavigationTabs("Track");
		return new TrackerA1CTrackPage();
	}
	
	public TrackersA1cProgressPage navigateToProgressTab()
	{
		selectTopNavigationTabs("Progress");
		return new TrackersA1cProgressPage();
	}
	
	public TrackersA1cJournalPage navigateToJournalPage()
	{
		selectTopNavigationTabs("Journal");
		return new TrackersA1cJournalPage();
	}
	

	public String getHeaderText()
	{
		return a1cVerficationText.getText();
	}
	
	 public String getSelectedTabText()
	   {
		   return tabVerfication.getText();
	   }
	   
	
	@Override
	public boolean isDisplayed() {
		
		return getWebDriver().findElement(By.xpath("//a[@class='selected icon icon_checkmark'][text()='A1c']")).isDisplayed();
		}
	
	
}
