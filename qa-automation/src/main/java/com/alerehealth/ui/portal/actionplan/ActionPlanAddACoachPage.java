package com.alerehealth.ui.portal.actionplan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class ActionPlanAddACoachPage extends PortalHomePage{
		
	 @FindBy(xpath = "//*[@class='button primary']")
	 private WebElement addACoachButton;
	 



	 
	 @FindBy(xpath = "//*[@class='button btn-primary left']")
	 private WebElement selectMealPlanRadioContinue;
	

	
	 @FindBy(xpath = "//*[@class='cards__links-li toggle-goal-accomplish']")
	 private WebElement reachedthisgoalButton;
	 
	 @FindBy(xpath = "//*[contains(text(),'Yes, I reached my goal on')]")
	 private WebElement yesReachedGoalButton;
	
	 @FindBy(xpath = "//*[@class='date datepicker hasDatepicker']")
	 private WebElement goalEndDateActionPlan;
	 
	 @FindBy(xpath = "//button[@type='submit']")
	 private WebElement goalEndDateContinue;
	
	  public void clickEndGoalContinueButton(){

		  goalEndDateContinue.click();

	    }
	 
	   
	 public void enterActionPlanGoalEndDate(){

		 goalEndDateActionPlan.sendKeys("08/22/2018");

	    }
	  
	   public void clickYesReachedMyGoal(){

		   yesReachedGoalButton.click();

	    }
	 
	   public void clickreachedthisgoal(){

		   reachedthisgoalButton.click();
		   
		   waitForModelDialogToOpen();

	    }	    
	   
	    public ActionPlanSetYourGoal clickAddACoachButton(){

	    	addACoachButton.click();

	    	return new ActionPlanSetYourGoal();

	    }
	    


	    

	    
	    public void clickMealPlanRadioContinue(){

	    	selectMealPlanRadioContinue.click();
	    	
	    }
	    
	    public ManageGoalsPage clickGoalContinue(){

	    	//goalContinueButton.click();

	    	return new ManageGoalsPage();

	    }
	    
}
