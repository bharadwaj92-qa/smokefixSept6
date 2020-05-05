    package com.alerehealth.ui.portal.progress.trackers.nutrition;
    
	

import org.openqa.selenium.By;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	public class TrackersNutritionGoalPage extends TrackersNutritionBasePage {

		@FindBy(xpath="//div[@id='FitbitTrackerDiv']")
		private WebElement goalPage;

		@FindBy(xpath="//h3[text()='Goal Summary']//following-sibling::p[1]")
		private WebElement goalSummary;

		@FindBy(xpath="//div[@id='buttons save_tracker']/button[@type='submit']")
		private WebElement continueButton;
		

		@FindBy(xpath ="//a[@class='button btn-secondary' and contains(text(),'BACK')]")
		private WebElement backButton;


		
		public void enterText(String value, String enterData){
			
			String id = "";
			value = value.toUpperCase(); 
	    	
	    	switch(value){
	    	
	    	case "FEET": {
	    		        id = "heightFeet"; 
	    	            break; }
	    	
	    	case "INCHES": {id = "heightInches"; 
	    	               break;}
	    	
	    	case "WEIGHT" : {id="weight";
	    	               break;}
	    	
	    	
	    	}
			
			String xpath = "//input[@id='"+id+"']";
			WebElement textAreaEle = getWebDriver().findElement(By.xpath(xpath));
			waitForElementToBeDisplayed(textAreaEle);
			textAreaEle.clear();
			waitForSpecifiedTime(2);
			textAreaEle.sendKeys(enterData);
			
			
		}
		
		
		
		public void selectDropdown(String option){
			
			String xpath = "//ul[@class='dropdown-menu inner']//span[text()='"+option+"']";
			WebElement optionValue = getWebDriver().findElement(By.xpath(xpath));
			javaScriptClick(optionValue);
			
		}
		
		public void selectRadiobtnOrCheckBox(String value){
			
			String xpath = "//label[contains(text(),'"+value+"')]";
			WebElement optionValue = getWebDriver().findElement(By.xpath(xpath));
			waitForElementToBeDisplayed(optionValue);
			javaScriptClick(optionValue);
			
		}

		public void clickContinueSaveButton()
		{
		javaScriptClick(continueButton);

		}

		public void clickBackEditButton(String buttonValue)
		{
			
			String xpath = "//div[@id='buttons save_tracker']/a[contains(text(),'"+buttonValue+"')]";
			WebElement buttonEle = getWebDriver().findElement(By.xpath(xpath));
			waitForElementToBeDisplayed(buttonEle);
		   javaScriptClick(buttonEle);
		}

        /*
         * This method is used for selecting goals as DailyCalories,DailyServings and also if we select Daily servings
         * then also to select the track option as Fruits,Veggies,and Fats
         */
		
		public void selectTrackOption(String GoalValue){
			
			String id = "";
			GoalValue = GoalValue.toUpperCase(); 
	    	
	    	switch(GoalValue){
	    	
	    	case "DAILYGOAL": {
	    		        id = "dailyCaloriesGoal"; 
	    	            break; }
	    	
	    	case "FRUITSGOAL": {id = "trackFatsFruitsVegetablesGoal"; 
	    	               break;}
	    	
	    	case "FRUITS" : { id = "nutrition-fruits";
            break;
            
	    	}
	    	case "VEGGIES" : { id = "nutrition-vegetables";
	    	                break;
	    	}
	    	                
	    	case "FATS" : { id = "nutrition-fats";
            break;
	    	}             
	    	                
	    	                
	    	}

			String xpath = "//input[@id='"+id+"']";
			WebElement selGoal = getWebDriver().findElement(By.xpath(xpath));
			javaScriptClick(selGoal);
		}
		
		
		public boolean isEditButtonDisplayed(){
			
			String xpath = "//div[@id='buttons save_tracker']/a[contains(text(),'EDIT')]";
			
			WebElement buttonEle = getWebDriver().findElement(By.xpath(xpath));
			waitForElementToBeDisplayed(buttonEle);
			
			return buttonEle.isDisplayed();
		}
		
		
		public String getDailyGoalSummaryText(){
	    	  
	    	  waitForElementToBeDisplayed(goalSummary);
	    	  
	    	  return goalSummary.getText().trim();
	      }
		
		
		public String getDailyServingGoalSummaryText(String serving){
			
			
			String xpath = "//label[contains(text(),'"+serving+"')]//following-sibling::p";
			
			WebElement servingsGoalSummary = getWebDriver().findElement(By.xpath(xpath));
	    	  
	    	  waitForElementToBeDisplayed(servingsGoalSummary);
	    	  
	    	  return servingsGoalSummary.getText().trim();
	      }
		
		
		
		public String getTrackStepsHeading(String tagValue,String text){
			
			
			String id = "";
				
			tagValue = tagValue.toUpperCase(); 
		    	
		    	switch(tagValue){
		    	
		    	case "STEP12": {
		    		id = "h2"; 
		    	break; }
		    	
		    	case "STEP3": {id = "h3"; 
		    	               break;}
		    	
		    	}
		    	
		    	String xpath = "//div[@id='FitbitTrackerDiv']//"+id+"[contains(text(),'"+text+"')]  ";
		    	WebElement headingEle = getWebDriver().findElement(By.xpath(xpath));
		    	waitForElementToBeDisplayed(headingEle);
				
				return headingEle.getText().trim();
			}
			
        
		
		  public boolean isBackButtonDisplayed(){
	    	  
	    	  return backButton.isDisplayed();
	      }
	      
	      
		  public void clearFields(String value){
				
				
				String id = "";
				value = value.toUpperCase(); 
		    	
		    	switch(value){
		    	
		    	case "FEET": {
    		        id = "heightFeet"; 
    	            break; }
    	
    	    case "INCHES": {id = "heightInches"; 
    	               break;}
		    	
		    	case "WEIGHT" : {id="weight";
		    	               break;}
		    	
		    	
		    	}
				
				String xpath = "//input[@id='"+id+"']";
				WebElement textAreaEle = getWebDriver().findElement(By.xpath(xpath));
				textAreaEle.clear();
			}
		  
		  
		  public String getErrorMessage(String errorType){
				
				String id = "";
				errorType = errorType.toUpperCase(); 
		    	
		    	switch(errorType){
		    	
		    	
		    	case "FEET": {
		    		        id = "heightFeet"; 
		    	            break; }
		    	
		    	case "INCHES": {id = "heightInches"; 
		    	               break;}
		    	
		    	case "WEIGHT": {id = "weight"; 
		    	               break;}
		    	
		    	case "MEAL": {id= "dietStandard"; 
		    	             break;}
		    	
		    	
		    	}
				
				String xpath = "//input[@id='"+id+"']//..//div[@class='popover-content']";
				WebElement errorMsg = getWebDriver().findElement(By.xpath(xpath));
				waitForElementToBeDisplayed(errorMsg);
				return errorMsg.getText().trim();
			}
		      
		  

		@Override
		public boolean isDisplayed() {
			
		      return goalPage.isDisplayed();
		
		}
		
		public String getTrackVeggiesGoalHeading(){
			
			String xpath = "//div[@id='FitbitTrackerDiv']//p ";
			WebElement veggiesGoalContent = getWebDriver().findElement(By.xpath(xpath));
			waitForElementToBeDisplayed(veggiesGoalContent);
			
			return veggiesGoalContent.getText().trim();
		}
		
		
		public String getVeggiesErrorMessage(){
			
			String xpath = " //div[@id='trackerNutritionGoal.trackFruitsSelected-error']";
			WebElement errMsg = getWebDriver().findElement(By.xpath(xpath));
			return errMsg.getText().trim();
		}
		
		
       /**
        * 
        * @param serving is taken as id of Servings or weeks for Fruits, veggies and fats
        * @param value is taken as number of servings or weeks for Fruits,veggies and fats
        */
		public void selectDailyServingsWeekDropdown(String serving,String value){
			
			
			String id = "";
			serving = serving.toUpperCase(); 
	    	
	    	switch(serving){
	    	
	    	case "FRUITSERVING": {
		        id = "fruits-servings"; 
	            break; }
	
	        case "VEGETABLESERVING": {id = "vegetable-servings"; 
	               break;}
	
	       case "FATSERVING" : { id = "fats-servings";
                      break;}
	    	
	    	
	    	case "FRUITSWEEKS": {
	    		        id = "fruits-weeks"; 
	    	            break; }
	    	
	    	case "VEGETABLESWEEKS": {id = "vegetable-weeks"; 
	    	               break;}
	    	
	    	case "FATSWEEKS" : { id = "fats-weeks";
            break;
            
	    	}
	                             
	    	}
			
			String xpath = "//button[@data-id='"+id+"']//following-sibling::div//span[text()='"+value+"']";
			WebElement optionValue = getWebDriver().findElement(By.xpath(xpath));
			javaScriptClick(optionValue);
			
		}
		
		
	}


