package com.alerehealth.ui.portal.progress.trackers.PeakFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class TrackersPeakFlowTrackBasePage extends TrackersPeakFlowBasePage {
	
	
	@FindBy(id = "dateEntered")
	private WebElement dateField;
	
	@FindBy(id = "hour")
	private WebElement hourField;
	
	@FindBy(id = "minutes")
	private WebElement minutesField;
	
	@FindBy(id = "peakFlow")
	private WebElement peakFlowField;
	
	@FindBy(id = "comments")
	private WebElement notesField;
	
	@FindBy(xpath ="//button[@class='button btn-primary']")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//div[@class='btn-group bootstrap-select custom-select ampm']//button")
	private WebElement ampmButton;
	
	
	public void enterPeakFlow(String text){
		
		peakFlowField.clear();
		peakFlowField.sendKeys(text);
	}
	
	public void enterNotes(String text){
		
		notesField.clear();
		notesField.sendKeys(text);
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
	
	public String getErrorMsgOfField(String field){
		String xpath = "";
		switch(field){
		
		case "DateError":{
			xpath = "//small[@data-fv-result = 'INVALID' and @data-fv-for = 'date']";
			break;
		}
		
		case "HourError":{
			
			xpath = "//small[@data-fv-result = 'INVALID' and @data-fv-for = 'hour']";
			break;
		}
		
		case "MinuteError":{
			
			xpath = "//small[@data-fv-result = 'INVALID' and @data-fv-for = 'minuts']";
			break;
		}
		
				
		case "PeakFlowError":{
			
			xpath = "//small[@data-fv-result = 'INVALID' and @data-fv-for = 'peakFlow']";
			break;
		}
		case "NotesError":{
			
			xpath = "//small[@data-fv-result = 'INVALID' and @data-fv-for = 'comments']";
			break;
		}
		}
		
		
		return getWebDriver().findElement(By.xpath(xpath)).getText().trim();
		
	}

	
	
	public TrackersPeakFlowJournalBasePage clickSubmitButton(){
		
		SubmitButton.click();
		
		return new TrackersPeakFlowJournalBasePage();
	}
	
	public void clickSubmitButtonT(){
		
		SubmitButton.click();

	}
	
	
	public void clearFields(){
		
		dateField.clear();
		minutesField.clear();
		hourField.clear();
		notesField.clear();
		peakFlowField.clear();
		
	}
	
	@Override
	public boolean isDisplayed(){
		
		return dateField.isDisplayed();
	}

}
