package com.alerehealth.ui.portal.progress.trackers.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackersActivityGoalPage extends TrackersActivityBasePage {
	
	@FindBy(xpath="//div[@id='FitbitTrackerDiv']")
	private WebElement goalPage;
	
	@FindBy(xpath="//a[@class='button btn-primary tracker-edit']")
	private WebElement editButton;
	
	@FindBy(xpath="//div[@id='buttons save_tracker']/button[@type='submit']")
	private WebElement saveButton;
	
	
	public void clickEditButton(){
		
		waitForElementToBeDisplayed(editButton);
		javaScriptClick(editButton);
		
	}
	
	
    public void clickSaveButton(){
		
		waitForElementToBeDisplayed(saveButton);
		javaScriptClick(saveButton);
		
	}
	
	public boolean isSaveButtonDisplayed(){
		
		return saveButton.isDisplayed();
		
	}
	
   public boolean isEditButtonDisplayed(){
		
		return editButton.isDisplayed();
		
	}
   
   /*
    * goal value can be Distance, Duration and Steps
    */
   public void selectGoal(String goal){
	   
	   String xpath = "//input[@id='"+goal+"']";
	   
	   WebElement goalEle = getWebDriver().findElement(By.xpath(xpath));
	   
	   javaScriptClick(goalEle);
   }
	
	
	public void selectGoalsDropdown(String goal,String goalValue, String value){
		
		
		String id = "";
		
		String goalId="";
		goal = goal.toUpperCase(); 
		
		goalValue = goalValue.toUpperCase();
    	
    	switch(goal){
    	
    	
    	case "DISTANCE" : { goalId = "Distancefs";
        break;
        
    	}
             
    	
    	case "DURATION" : { goalId = "Durationfs";
        break;
        
    	}
    	
    	
    	case "STEPS" : { goalId = "Stepsfs";
        break;
        
    	}
    	
    	}
    	
    	switch(goalValue){
    	
    	case "MILESDISTANCE": {
	        id = "milesPerWeek"; 
            break; }

        case "WEEKSDISTANCEDURATION": {id = "numberOfWeeks"; 
               break;}

       case "DAYSSTEPS" : { id = "daysPerWeekInStepsGoal";
                  break;}
    	
    	
    	case "WEEKSSTEPS": {
    		        id = "numberOfWeeksInStepsGoal"; 
    	            break; }
    	
    	case "DAYSDURATION": {id = "daysPerWeek"; 
    	               break;}
    	
    	case "MINUTESDURATION" : { id = "minutesPerDay";
        break;
        
    	}
    	
    	                
    	}
		
		String xpath = "//fieldset[@id='"+goalId+"']//button[@data-id='"+id+"']//following-sibling::div//span[@class='text' and text()='"+value+"']";
		WebElement optionValue = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(optionValue);
		
	}
	
	
	public void enterSteps(String text){
		
		String xpath="//input[@id='stepsPerDay']";
		WebElement stepEle = getWebDriver().findElement(By.xpath(xpath));
		stepEle.clear();
		stepEle.sendKeys(text);
	}
	

	@Override
	public boolean isDisplayed() {
		
	      return goalPage.isDisplayed();
	
	}

}
