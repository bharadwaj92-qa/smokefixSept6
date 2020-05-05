package com.alerehealth.ui.portal.progress.trackers.nutrition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TrackersNutritionTrackPage extends TrackersNutritionBasePage {
	
	@FindBy(id = "dateEntered")
	private WebElement dateField;
	
	@FindBy(id = "hour")
	private WebElement hourField;
	
	@FindBy(id = "minutes")
	private WebElement minutesField;
	
	@FindBy(xpath = "//div[@class='btn-group bootstrap-select custom-select ampm']//button")
	private WebElement ampmButton;
	
	@FindBy(id = "comments")
	private WebElement notesField;
	
	@FindBy(xpath ="//div[@id='save_tracker']//button[@type='submit'  and  contains(text(),'Save')]")
	private WebElement saveButton;
	
	
    public void enterNotes(String text){
		
		notesField.clear();
		notesField.sendKeys(text);
	}
    
    
    public void enterNotesMoreCharacters(String text){
    	
    	notesField.clear();
    	for(int i=0; i<=100; i++){
    		
    		notesField.sendKeys(text);
    	}
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
	
	
	public void selectServings(String option,String value){
		
		String xpath = "//button[@data-id='"+option+"']//..//div[@class='dropdown-menu open']//span[text()='"+value+"']";
		WebElement servingValue = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(servingValue);
		
	}
	
	
	public TrackersNutritionJournalPage clickSaveButton()
	{
		javaScriptClick(saveButton);
		
		return new TrackersNutritionJournalPage();
	}
	
	
	
	public String getErrorMessage(String errorType){
		
		String id = "";
		errorType = errorType.toUpperCase(); 
    	
    	switch(errorType){
    	
    	case "DATE": {
    		id = "dateEntered-error"; 
    	break; }
    	
    	case "HOURS": {id = "hour-error"; 
    	               break;}
    	
    	case "MINUTES": {id= "minutes-error"; 
    	             break;}
    	
    	case "NOTES" : {id= "comments-error"; 
        break;}
    	
    	
    	}
		
		String xpath = "//div[@id='"+id+"'] ";
		WebElement errorMsg = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(errorMsg);
		return errorMsg.getText().trim();
	}
	
	public void clickSaveButtonWithOutEnteringData(){
		
		javaScriptClick(saveButton);
	}
	
      public void clearFields(){
		
		dateField.clear();
		minutesField.clear();
		hourField.clear();
		notesField.clear();
		
	}
      

      
      @Override
  	public boolean isDisplayed() {

  		return dateField.isDisplayed();
  	}

}
