package com.alerehealth.ui.portal.progress.trackers;

import java.util.ArrayList;
import java.util.List;

import com.alerehealth.ui.portal.progress.constants.TrackersConstants;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityBasePage;
import com.alerehealth.ui.portal.progress.trackers.nutrition.TrackersNutritionBasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalBasePage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class TrackersBasePage extends PortalHomePage {
	
	@FindBy(className="fah-heading")
	private WebElement headerText;
	
	@FindBy(xpath="//section[@class='content']")
	private WebElement trackerElements;
	
	
	public TrackersA1CBasePage navigateToA1cPage()
	{
       WebElement trackerElement=findTrackersElement(TrackersConstants.A1C_TRACKER_TEXT);
       
     
      trackerElement.findElement(By.className("buttons")).click();	
       
       return new TrackersA1CBasePage();
	    
	
	}
	
	
	public List<String> getTrackersElementsText()
	{
		String xpath="//div[@class='summary-box-wrapper']//h2";
		
		List<WebElement> trackerElements=getWebDriver().findElements(By.xpath(xpath));
		
		List<String> trackerTextList=new ArrayList<String>();
		
		for(WebElement trackersText:trackerElements)
		{
			trackerTextList.add(trackersText.getText().trim());
		}
		return trackerTextList;
	}
	
	
	public String getTrackerHeaderText()
	{
		return headerText.getText();
	}
	
	private WebElement findTrackersElement(String text)
	{
		
		
		String xpath="//div[@class='summary-box-wrapper']";
		
	   List<WebElement> trackersElmentsList=getWebDriver().findElements(By.xpath(xpath));
	    
	   for(WebElement trackerElement:trackersElmentsList)
	   {
		  
		   if(trackerElement.findElement(By.className("sb-heading")).getText().equals(text))
		   {
			   return trackerElement;
		   }
	   }
	   
	    return null;
	}
	
	public String getTrackersElementButtonText(String element)
	{
		WebElement trackerElement=findTrackersElement(element);
		
	    return 	trackerElement.findElement(By.className("buttons")).getText();
	}
	
	@Override
	public boolean isDisplayed() {

		waitForElementToBeDisplayed(trackerElements);

		return trackerElements.isDisplayed(); 
	}
	
	
	public TrackersNutritionBasePage navigateToNutritionPage()
	{
       WebElement trackerElement=findTrackersElement(TrackersConstants.NUTRITION_TRACKER_TEXT);
       
     
      trackerElement.findElement(By.className("buttons")).click();	
       
       return new TrackersNutritionBasePage();

	}
	
	public TrackersActivityBasePage navigateToActivityPage()
	{
       WebElement trackerElement=findTrackersElement(TrackersConstants.ACTIVITY_TRACKER_TEXT);

      trackerElement.findElement(By.className("buttons")).click();	
       
       return new TrackersActivityBasePage();
	}


}
