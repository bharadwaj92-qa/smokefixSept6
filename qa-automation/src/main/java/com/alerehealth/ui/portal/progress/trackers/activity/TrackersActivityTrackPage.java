package com.alerehealth.ui.portal.progress.trackers.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.progress.trackers.weightandbmi.TrackersWeightBMITracPage;

public class TrackersActivityTrackPage extends TrackersActivityBasePage {
	
	@FindBy(xpath ="//a[@class='button btn-primary' and contains(text(),'OK')]")
	private WebElement okButton;
	
	@FindBy(xpath ="//div[@id='buttons save_tracker']//button[@type='submit'  and  contains(text(),'Save')]")
	private WebElement saveButton;
	
	@FindBy(id = "dateEntered")
	private WebElement dateField;
	
	@FindBy(id = "startTimeHour")
	private WebElement hourField;
	
	@FindBy(id = "startTimeMinutes")
	private WebElement minutesField;
	
	@FindBy(xpath = "//div[@class='btn-group bootstrap-select custom-select ampm']//button")
	private WebElement ampmButton;
	
	@FindBy(xpath = "//button[@data-id='heightInches']")
	private WebElement inchesField;
	
	@FindBy(xpath = "//button[@data-id='heightFeet']")
	private WebElement feetField;
	
	@FindBy(id = "comments")
	private WebElement notesField;
	
	@FindBy(id = "weight")
	private WebElement weightField;
	
	@FindBy(id="durationTimeHour")
	private WebElement durationHourField;
	
	@FindBy(id="durationTimeMinutes")
	private WebElement durationMinutesField;
	
     public TrackersWeightBMITracPage clickOkButton(){
		
		waitForElementToBeDisplayed(okButton);
		javaScriptClick(okButton);
		
		return new TrackersWeightBMITracPage();
	}
	
	
	public void clickSaveButtonWithoutEnteringData(){
		
		waitForElementToBeDisplayed(saveButton);
		javaScriptClick(saveButton);
	}
	
    public TrackersActivityJournalPage clickSaveButton(){
    	
    	waitForElementToBeDisplayed(saveButton);
		javaScriptClick(saveButton);
		
		return new TrackersActivityJournalPage();
    }
    
    
    public void enterActivity(String activity){
    	
    	String xpath = "//button[@data-id='activityType']//..//div//span[contains(text(),'"+activity+"')] ";
    	WebElement activityEle = getWebDriver().findElement(By.xpath(xpath));
    	waitForSpecifiedTime(2);
    	javaScriptClick(activityEle);
    	
    }
    
	
    public void enterDate(String date){
		
		dateField.clear();
		waitForSpecifiedTime(2);
		dateField.sendKeys(date);
	}
    
    
	public void enterTime(String time){
		
		String[] splitTime = time.split(":");
		String hour = splitTime[0];
		String minute= splitTime[1].substring(0, 2);
		hourField.clear();
		hourField.sendKeys(hour);
		minutesField.clear();
		minutesField.sendKeys(minute);
		
		
		
		if(time.contains("AM")|| time.contains("am")){
			
			clickAMPMButtonBPTracker("AM");
		}else{
			
			clickAMPMButtonBPTracker("PM");
		}
	
	}
	
	
	public void clickAMPMButtonBPTracker(String amPM){
		
		
		ampmButton.sendKeys(amPM, Keys.ENTER);
		
	}
	
    
 
   public void enterNotesMoreCharacters(String text){
   	
	   notesField.clear();
	  
   	for(int i=0; i<=100; i++){

   		notesField.sendKeys(text);
   	}
   }
   
   
   public void enterWeight(String text){
	   
	   weightField.clear();
	   weightField.sendKeys(text);
   }
   
   
 public void enterNotes(String text){
	   
	 notesField.clear();
	 notesField.sendKeys(text);
	 
   }
   public void enterHeight(String feet,String inch){
	   
	   feetField.clear();
	   feetField.sendKeys(feet);
	   inchesField.clear();
	   inchesField.sendKeys(inch);
	   
   }
   
   
   public void clearFields(){
	   
	   
	   dateField.clear();
	
	   hourField.clear();
	   minutesField.clear();
	 /*  durationHourField.clear();
	   durationMinutesField.clear();
	   notesField.clear();*/
   }
   
   public String getErrorMessage(String errorType){
		
		String id = "";
		errorType = errorType.toUpperCase(); 
   	
   	switch(errorType){
   	
   	case "DATE": {
   		id = "dateEntered-error"; 
   	break; }
   	
   	case "ACTIVITY": {
   		id = "activityType-error"; 
   	break; }	
   	
   	case "HOURS": {id = "startTimeHour-error"; 
   	               break;}
   	
   	case "MINUTES": {id= "startTimeMinutes-error"; 
   	             break;}
   	
   	case "DURATIONHOUR": {id= "durationTimeHour-error"; 
       break;}
   	

   	case "DURATIONMINUTES": {id= "durationTimeMinutes-error"; 
       break;}
   	
	case "WEIGHT": {id= "weight-error";
	               break;
	}
   	
   	case "NOTES" : {id= "comments-error"; 
       break;}
   	
   	
   	}
		
		String xpath = "//div[@id='"+id+"'] ";
		WebElement errorMsg = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(errorMsg);
		return errorMsg.getText().trim();
	}
   
   
   public void enterActivityFields(String field,String value){
	   
	   String xpath = "//label[contains(text(),'"+field+"')]//following-sibling::input";
	   WebElement fieldValue = getWebDriver().findElement(By.xpath(xpath));
	   waitForSpecifiedTime(2);
	   fieldValue.sendKeys(value);
	   
   }
   
   public void enterDuration(String hour, String minutes){
	   
	   durationHourField.clear();
	   durationHourField.sendKeys(hour);
	   durationMinutesField.clear();
	   durationMinutesField.sendKeys(minutes);
   }
   
  
}
