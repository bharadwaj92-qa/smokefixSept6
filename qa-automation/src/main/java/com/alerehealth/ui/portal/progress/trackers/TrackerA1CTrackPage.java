package com.alerehealth.ui.portal.progress.trackers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class TrackerA1CTrackPage extends TrackersA1CBasePage {
	
	@FindBy(id="a1c")
	private WebElement readingTextBox;
	
	@FindBy(id="comments")
	private WebElement commentsSection;
	
	@FindBy(xpath="//*[@id='buttons save_tracker']/button")
	private WebElement saveButton;
	
	@FindBy(xpath="//small[@data-fv-for='a1c'][@data-fv-result='INVALID']")
     private WebElement readingFieldError;
	
	@FindBy(xpath="//fieldset[@class='form-group dateBox has-error']//small")
	private WebElement dateFieldError;
	
	@FindBy(xpath="//fieldset[@class='form-group inline-text-input has-error']//small[@data-fv-result='INVALID']")
	private List<WebElement> hourMinFieldError;
	
	@FindBy(xpath="//small[@data-fv-for='comments']")
    private WebElement commentFieldError;	
	
	@FindBy(id="dateEntered")
	private WebElement dateField;
	
	@FindBy(id="hour")
	private WebElement hourField;
	
	@FindBy(id="minutes")
	private WebElement minuteField;
	
	@FindBy(id="a1c")
	private WebElement readingField;
	
	@FindBy(id="comments")
	private WebElement commentField;
	
	public void enterA1cReadings(String reading)
	{
		clearText("reading");
		readingTextBox.sendKeys(reading);
	}
	
	public void enterA1cComments(String comments)
	{
	   clearText("comments");
	   commentsSection.sendKeys(comments);
   } 
	
	public TrackersA1cJournalPage clickSaveButton()
	{
		saveButton.click();
		
		return new TrackersA1cJournalPage();
	}
	
	
	
	private List<String> getTimeFiledError()
	{
		List<String> timeerror=new ArrayList<String>();
		
		for(WebElement e:hourMinFieldError)
		{
		
			timeerror.add(e.getText());
		}
		
		
		return timeerror;
	}
	
	
	
	public void clearText(String fieldName)
	{
	
	  if(fieldName.equals("comments"))
			commentField.clear();
		
	  else if(fieldName.equals("reading"))
			readingField.clear();
		
	   else if(fieldName.equals("date"))
			dateField.clear();
	   
	   else if(fieldName.equals("hour"))
		   actionSendKeys(Keys.DELETE, hourField);
	  
	   else if(fieldName.equals("minute"))
	   {
		   actionSendKeys(Keys.chord(Keys.CONTROL,"a"), minuteField);
  	       actionSendKeys(Keys.BACK_SPACE);
	   }   
	}
	
	
	public String getFieldError(String fieldName)
	{
		  if(fieldName.equals("comments"))
			  return commentFieldError.getText();
			
		  else if(fieldName.equals("reading"))
				return readingFieldError.getText();
			
		   else if(fieldName.equals("date"))
			   return dateFieldError.getText();
		  
		   else if(fieldName.equals("hour"))
			   return getTimeFiledError().get(0);
		  
		   else if(fieldName.equals("minute"))
			    return getTimeFiledError().get(1);
		    
			   
		  
		   return null;
	}
	
 
       public void enterTextExceedingLimit()
           {
	    	for(int i=0;i<=126;i++){
	    		
	    		commentField.sendKeys("Text");
	    	}
	    	
	    }

@Override
public boolean isDisplayed() {

return dateField.isDisplayed();

}
       
}
