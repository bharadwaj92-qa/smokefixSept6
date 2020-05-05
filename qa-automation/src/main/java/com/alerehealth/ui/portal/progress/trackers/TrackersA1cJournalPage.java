package com.alerehealth.ui.portal.progress.trackers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class TrackersA1cJournalPage extends TrackersA1CBasePage {
	
	@FindBy(id="a1cJournal_journalStartDate")
	private WebElement journalStartDate;
	
	@FindBy(id="a1cJournal_journalEndDate")
	private WebElement journalEndDate;
	
	@FindBy(id="hour")
	private WebElement hourTextBox;
	
	@FindBy(id="minutes")
	private WebElement minutesTextBox;
	   
	@FindBy(id="journal_data_span_a")
	private List<WebElement> journalEditDeleteLink;
	
	@FindBy(xpath="//div[@id='myModal-journalEdit']//div[@class='buttons']/a")
	private List<WebElement> journalEditPopButtons;
	
	@FindBy(xpath="//div[@id='myModal-journalDelete']//div[@class='buttons']/a")
	private List<WebElement> journalDeletePopUpButtons;
	
	

	public void editRecordinJournal(String reading,String comment)
	{
		journalEditDeleteLink.get(0).click();
		javaScriptClick(journalEditPopButtons.get(0));
	    TrackerA1CTrackPage a1cTrackPage=new TrackerA1CTrackPage();
	    a1cTrackPage.enterA1cReadings(reading);
	    a1cTrackPage.enterA1cComments(comment);
	    a1cTrackPage.clickSaveButton();
	 }
	
	public void deleteRecordInJournal(String timestamp)
	{
		
	getWebDriver().findElements(By.xpath("//li[contains(text(),'"+timestamp+"')]/following-sibling::li[@id='journal_data_span']/a")).get(1).click();
	javaScriptClick(journalDeletePopUpButtons.get(0));
	
	}
	
	
   public void enterStartAndEndDate(String startDate,String endDate)
	{
		journalStartDate.sendKeys(startDate);
		journalEndDate.sendKeys(endDate);
		
	}
   
   public boolean verifyRowsByTimsStamp(String timeStamp)
   {
	   try{
		   WebElement row=getWebDriver().findElement(By.xpath("//li[contains(text(),'"+timeStamp+"')]"));
		   scrollElementIntoView(row);
		 return true;  
	   }
	   catch (NoSuchElementException e) {

         return false;
	}
	        }
   
   public boolean verfiyRowsByReadingValue(String reading)
   {
	   try{
	   WebElement row=getWebDriver().findElement(By.xpath("//dd[contains(text(),'"+ reading+"')]"));
	   scrollElementIntoView(row);
	    return true;
	   }
	   
	   catch (NoSuchElementException e) {
		 return false;
	}
	   
   }
   
   public boolean verfiyRowsByCommentSection(String commmets)
   {
	   try{
		   
	   
	   WebElement row=getWebDriver().findElement(By.xpath("//p[contains(text(),'"+commmets+"')]"));
	   scrollElementIntoView(row);
	   return true;
	       }	   
	   catch (NoSuchElementException e) {
		 return false;
	}
   }
   

   
   
   @Override
public boolean isDisplayed() {
	   
	   return journalStartDate.isDisplayed();
}
	

}
