package com.alerehealth.ui.stepdefenitions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.progress.constants.TrackersConstants;
import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;
import com.alerehealth.ui.portal.progress.trackers.nutrition.TrackersNutritionBasePage;
import com.alerehealth.ui.portal.progress.trackers.nutrition.TrackersNutritionGoalPage;
import com.alerehealth.ui.portal.progress.trackers.nutrition.TrackersNutritionJournalPage;
import com.alerehealth.ui.portal.progress.trackers.nutrition.TrackersNutritionProgressPage;
import com.alerehealth.ui.portal.progress.trackers.nutrition.TrackersNutritionTrackPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrackersNutritionStepDef {
	
	 PortalHomePage portalHomePage = null;

	  TrackersBasePage trackersBasePage;
	  
	  TrackersNutritionTrackPage trackersNutritionTrackPage;
	  
	  TrackersNutritionBasePage trackersNutritionBasePage;
	  
	  TrackersNutritionJournalPage trackersNutritionJournalPage;
	  
	  TrackersNutritionProgressPage trackersNutritionProgressPage;
	  
	  TrackersNutritionGoalPage trackersNutritionGoalPage;
	  
	  String fruitServingValueUI;
	  String veggiesServingValueUI;
	  String proteinServingValueUI;
	  String dairyServingValueUI;
	  String fatsServingValueUI;
	  String nutsServingValueUI;
	  String sweetsServingValueUI;
	  String grainsServingValueUI;
	  String notesTextInUI;
	  
	  String progressContentInUI;
	  String progressContentAfterTrackInUI;
	  String journalContentInUI;
	  
	  String gaolStep1HeadingInUI;
	  String gaolStep2HeadingInUI;
	  String gaolStep3HeadingInUI;
	  
	  String goalVeggiesHeadingInUI;
	  String goalVeggiesErrorInUI;
	  
	  String editBoxTextInUI;
	  String deleteBoxTextInUI;
	  
	  String dateErrorMsgInUI;
	  String hourErrorMsgInUI;
	  String minuteErrorMsgInUI;
	  String noteErrorMsgInUI;
	  
	  String goalSummaryTextInUI;
	  
	  String goalFruitSummaryTextInUI;
	  String goalVeggieSummaryTextInUI;
	  String goalFatSummaryTextInUI;
	  
	  String heightErrorMsgInUI;
	  
	  String weightErrorMsgInUI;
	  
	  String dateInGoalHistoryInUI;
	  
	  String caloriesInGoalHistoryInUI;
	  
	  int sizeAfterAddingTrack;
	  
	  List<WebElement> recordsDate;
	  
	  Date actualStartDate=null;
      
      Date actualEndDate=null;
      
      Date expectedStartDate=null;
      
      Date expectedEndDate=null;
      
     
      @Then("^click on Progress tab to validate generated graph, dateRange and timeline$")
      public void click_on_Progress_tab_to_validate_generated_graph_dateRange_and_timeline() throws Throwable {
        
    	  trackersNutritionProgressPage = trackersNutritionBasePage.navigateToProgressTab();
    		
    		Assert.assertTrue("Nutrition Trackers Progress page is displayed",trackersNutritionProgressPage.isDisplayed());
    		
    		progressContentAfterTrackInUI = trackersNutritionProgressPage.getProgressContent();
    		
	  		Assert.assertTrue("Progress content with track updation is displayed",progressContentAfterTrackInUI.contains(TrackersConstants.TRACKERS_NUTRITION_PROGESS_TRACKCONTENT));
    		
    		trackersNutritionProgressPage.selectServingDropdown("Fruits");
    		
    		Assert.assertTrue("Fruits Graph is displayed in Nutrition Tracker Progress page   ",trackersNutritionProgressPage.isGraphDisplayed("Fruits"));
            
    		Assert.assertTrue("Timeline is displayed for fruits graph page ",trackersNutritionProgressPage.isTimeLineDisplayed("Fruits", "1w"));
    		
    		Assert.assertTrue("Timeline is displayed for fruits graph page ",trackersNutritionProgressPage.isTimeLineDisplayed("Fruits", "1m"));
    		
    		Assert.assertTrue("Timeline is displayed for fruits graph page ",trackersNutritionProgressPage.isTimeLineDisplayed("Fruits", "3m"));
    		
    		Assert.assertTrue("Timeline is displayed for fruits graph page ",trackersNutritionProgressPage.isTimeLineDisplayed("Fruits", "1y"));
    		
    		Assert.assertTrue("Timeline is displayed for fruits graph page ",trackersNutritionProgressPage.isTimeLineDisplayed("Fruits", "All"));
    		
    		//trackersNutritionProgressPage.selectDate("11", "30");
      }


	  
	
	@When("^User navigate to Trackers page Click on Progress tab it should be navigated to Progress Page$")
	public void user_navigate_to_Trackers_page_Click_on_Progress_tab_it_should_be_navigated_to_Progress_Page() throws Throwable {
		
		   portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

	        trackersBasePage =	portalHomePage.openTrackersPage();
	        
	        Assert.assertTrue("Trackers Page is displayed",trackersBasePage.isDisplayed());

	        trackersNutritionBasePage = trackersBasePage.navigateToNutritionPage();
	        
	        Assert.assertTrue("Trackers Nutrition Page is displayed",trackersNutritionBasePage.isDisplayed());
	        
	        trackersNutritionProgressPage = trackersNutritionBasePage.navigateToProgressTab();
	  		
	  		Assert.assertTrue("Nutrition Trackers Progress page is displayed",trackersNutritionProgressPage.isDisplayed());
	  		
	  		progressContentInUI = trackersNutritionProgressPage.getProgressContent();
	
	  		Assert.assertTrue("Progress content without any track updation is displayed",progressContentInUI.contains(TrackersConstants.TRACKERS_NUTRITION_PROGESS_CONTENT));
	}

	
	
	@Then("^validate the record data that is present in journal should be same as the entered data in Track$")
	public void validate_the_record_data_that_is_present_in_journal_should_be_same_as_the_entered_data_in_Track(DataTable arg1) throws Throwable {
	    
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String dateEntered = dataMap.get("DateEntered");
		 String fruits = dataMap.get("Fruits");
		 String veggies = dataMap.get("Veggies");
	     String wholeGrains = dataMap.get("Wholegrains");
	     String protein = dataMap.get("LeanMeat");
	     String dairy = dataMap.get("LowFat");
	     String fats = dataMap.get("Fats");
	     String nuts = dataMap.get("Nuts");
	     String sweets = dataMap.get("Sweets");
	     String notes = dataMap.get("Notes");
	     
	     
	     
	     fruitServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Fruit");
	     Assert.assertTrue("Data is same",fruitServingValueUI.contains(fruits));
	     veggiesServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Veggie");
	     Assert.assertTrue("Data is same",veggiesServingValueUI.contains(veggies));
	     grainsServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Grains");
	     Assert.assertTrue("Data is same",grainsServingValueUI.contains(wholeGrains));
	     proteinServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Meat");
	     Assert.assertTrue("Data is same",proteinServingValueUI.contains(protein));
	     dairyServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Dairy");
	     Assert.assertTrue("Data is same",dairyServingValueUI.contains(dairy));
	     fatsServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Fats");
	     Assert.assertTrue("Data is same",fatsServingValueUI.contains(fats));
	     nutsServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Nuts");
	     Assert.assertTrue("Data is same",nutsServingValueUI.contains(nuts));
	     sweetsServingValueUI = trackersNutritionJournalPage.getServingsData(dateEntered,"Sweets");
	     Assert.assertTrue("Data is same",sweetsServingValueUI.contains(sweets));
	     notesTextInUI = trackersNutritionJournalPage.getNotesText(dateEntered);
	     Assert.assertTrue("Data is same",notesTextInUI.contains(notes));
	     
	}
	
	@Then("^Validate All records should be displayed based on the entry criteria$")
	public void validate_All_records_should_be_displayed_based_on_the_entry_criteria(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String startDate = dataMap.get("StartDate");
		String endDate = dataMap.get("EndDate");
		
		trackersNutritionJournalPage =trackersNutritionBasePage.navigateToJournalPage();
		
		Assert.assertTrue("Nutrition Journal Page is displayed",trackersNutritionJournalPage.isDisplayed() );
        
        List<String> journalEntires =trackersNutritionJournalPage.getJournalEntriesTimeStamp(startDate,endDate);
        
        System.out.println("printing list:"+journalEntires);
        
        String actualStart=null;
        String format="mm/dd/yyyy";
        
        actualStart=journalEntires.get(journalEntires.size()-1).substring(0,10);
        
        String actualEnd=journalEntires.get(0).substring(0,10);
        try {
               actualStartDate=DateTimeUtils.stringToDate(format, actualStart);
             actualEndDate =DateTimeUtils.stringToDate(format,actualEnd);
               expectedStartDate=DateTimeUtils.stringToDate(format, startDate);
             expectedEndDate=DateTimeUtils.stringToDate(format,endDate);
               
         } catch (Exception e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
               }
        
 if(actualEndDate.before(expectedEndDate)||actualEndDate.equals(expectedEndDate))
               {
                      if(actualStartDate.after(expectedStartDate)||actualStartDate.equals(expectedStartDate))
                     {
                            Assert.assertTrue(true);
                     }
                     
                     else
                            Assert.assertTrue(false);
                     
            }
 else
     Assert.assertTrue(false);
 

		
	}
	
	
	
	@Then("^Save all data in Track page by clicking on save button which should be navigated to Journal page$")
	public void save_all_data_in_Track_page_by_clicking_on_save_button_which_should_be_navigated_to_Journal_page(DataTable arg1) throws Throwable {
	    
		trackersNutritionTrackPage= trackersNutritionBasePage.navigateToTrackTab();
		
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
        
		 String dateEntered = dataMap.get("DateEntered");
		 String timeEntered = dataMap.get("Time");
	     String fruits = dataMap.get("Fruits");
	     String veggies = dataMap.get("Veggies");
	     String wholeGrains = dataMap.get("Wholegrains");
	     String protein = dataMap.get("LeanMeat");
	     String dairy = dataMap.get("LowFat");
	     String fats = dataMap.get("Fats");
	     String nuts = dataMap.get("Nuts");
	     String sweets = dataMap.get("Sweets");
	     String notes = dataMap.get("Notes");
	     
	     trackersNutritionTrackPage.enterDate(dateEntered);
		 trackersNutritionTrackPage.enterTime(timeEntered);
	     trackersNutritionTrackPage.selectServings("fruits",fruits);
	     trackersNutritionTrackPage.selectServings("veggies",veggies);
	     trackersNutritionTrackPage.selectServings("wholeGrains",wholeGrains);
	     trackersNutritionTrackPage.selectServings("protein",protein);
	     trackersNutritionTrackPage.selectServings("dairy",dairy);
	     trackersNutritionTrackPage.selectServings("fats",fats);
	     trackersNutritionTrackPage.selectServings("nuts",nuts);
	     trackersNutritionTrackPage.selectServings("sweets",sweets);
	     trackersNutritionTrackPage.enterNotes(notes);
	     
	     trackersNutritionJournalPage = trackersNutritionTrackPage.clickSaveButton();
		 Assert.assertTrue("Nutrition Trackers Journal Page is displayed",trackersNutritionJournalPage.isDisplayed());
		 sizeAfterAddingTrack =trackersNutritionJournalPage.getJournalRecordCount();
		 System.out.println(sizeAfterAddingTrack);

	}
	
	
	@Then("^Click on Edit Link of the record it should display edit popup$")
	public void click_on_Edit_Link_of_the_record_it_should_display_edit_popup() throws Throwable {
	    
		trackersNutritionJournalPage.editEntryFromJournal("11/29/2018");
		editBoxTextInUI = trackersNutritionJournalPage.getEditBoxText();
		Assert.assertTrue("Edit Box text displayed correctly", editBoxTextInUI.contains(TrackersConstants.TRACKERS_EDIT_BOX_TEXT));
		
	}

	@Then("^Click on Yes button in Edit popup which should be navigated to Track page$")
	public void click_on_Yes_button_in_Edit_popup_which_should_be_navigated_to_Track_page() throws Throwable {
	    
		trackersNutritionTrackPage = trackersNutritionJournalPage.clickYesButtonEditDialouge();
		Assert.assertTrue("Nutrition Track Page is displayed",trackersNutritionTrackPage.isDisplayed() );
	}

	@Then("^Reenter the values click on saveButton record should be present in Journal Page$")
	public void reenter_the_values_click_on_saveButton_record_should_be_present_in_Journal_Page(DataTable arg1) throws Throwable {
	   
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	        
		 String dateEntered = dataMap.get("DateEntered");
		 String timeEntered = dataMap.get("Time");
	     String fruits = dataMap.get("Fruits");
	     String veggies = dataMap.get("Veggies");
	     String wholeGrains = dataMap.get("Wholegrains");
	     String protein = dataMap.get("LeanMeat");
	     String dairy = dataMap.get("LowFat");
	     String fats = dataMap.get("Fats");
	     String nuts = dataMap.get("Nuts");
	     String sweets = dataMap.get("Sweets");
	     String notes = dataMap.get("Notes");
	     
	     trackersNutritionTrackPage.enterDate(dateEntered);
		 trackersNutritionTrackPage.enterTime(timeEntered);
	     trackersNutritionTrackPage.selectServings("fruits",fruits);
	     trackersNutritionTrackPage.selectServings("veggies",veggies);
	     trackersNutritionTrackPage.selectServings("wholeGrains",wholeGrains);
	     trackersNutritionTrackPage.selectServings("protein",protein);
	     trackersNutritionTrackPage.selectServings("dairy",dairy);
	     trackersNutritionTrackPage.selectServings("fats",fats);
	     trackersNutritionTrackPage.selectServings("nuts",nuts);
	     trackersNutritionTrackPage.selectServings("sweets",sweets);
	     trackersNutritionTrackPage.enterNotes(notes);
		
		 trackersNutritionJournalPage = trackersNutritionTrackPage.clickSaveButton();
		 Assert.assertTrue("Nutrition Trackers Journal Page is displayed",trackersNutritionJournalPage.isDisplayed());
		 
	}
	
	 @Then("^Validate edited Record is displayed in the journal page$")
     public void validate_edited_Record_is_displayed_in_the_journal_page(DataTable arg1) throws Throwable {
        
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	        
		 String editedRecord = dataMap.get("RecordEdited");
		  
		 Assert.assertTrue(trackersNutritionJournalPage.isRecordDisplayed(editedRecord));
     }

     

	
	@Then("^Click on delete Link of the record it should display delete popup$")
	public void click_on_delete_Link_of_the_record_it_should_display_delete_popup(DataTable arg1) throws Throwable {
	    
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String deleteDate = dataMap.get("Date");
		trackersNutritionJournalPage.deleteEntryFromJournal(deleteDate);
		deleteBoxTextInUI = trackersNutritionJournalPage.getDeleteBoxText();
		System.out.println(deleteBoxTextInUI);
		Assert.assertTrue("Delete Box text displayed correctly", deleteBoxTextInUI.contains(TrackersConstants.TRACKERS_DELETE_BOX_TEXT));
		
	}

	@Then("^Click on Yes button in Delete popup which should be navigated to Journal page$")
	public void click_on_Yes_button_in_Delete_popup_which_should_be_navigated_to_Journal_page() throws Throwable {
	    
		trackersNutritionJournalPage = trackersNutritionJournalPage.clickYesButtonDeleteDialogue();
		Assert.assertTrue("Nutrition Journal Page is displayed",trackersNutritionJournalPage.isDisplayed() );
	}

	@Then("^Validate whether record is deleted in Journal page$")
	public void validate_whether_record_is_deleted_in_Journal_page(DataTable arg1) throws Throwable {
          
        int sizeAfterDeletingTrack=trackersNutritionJournalPage.getJournalRecordCount();
        
        Assert.assertEquals(sizeAfterAddingTrack-1, sizeAfterDeletingTrack);
        
        HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
        
        String deletedRecord = dataMap.get("DeletedRecord");
		  
	    Assert.assertFalse(trackersNutritionJournalPage.isRecordDisplayed(deletedRecord));

	}
	
	
	@When("^User navigate to Nutrition Track page$")
	public void user_navigate_to_Nutrition_Track_page() throws Throwable {
		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

        trackersBasePage =	portalHomePage.openTrackersPage();
        
        Assert.assertTrue("Trackers Page is displayed",trackersBasePage.isDisplayed());

        trackersNutritionBasePage = trackersBasePage.navigateToNutritionPage();
        
        Assert.assertTrue("Trackers Nutrition Page is displayed",trackersNutritionBasePage.isDisplayed());
        
        trackersNutritionTrackPage = trackersNutritionBasePage.navigateToTrackTab();
        
        Assert.assertTrue("Trackers Nutrition Track Page is displayed",trackersNutritionTrackPage.isDisplayed());
	}

	@Then("^User click on save Button to validate error messages in Nutrition track page$")
	public void user_click_on_save_Button_to_validate_error_messages_in_Nutrition_track_page(DataTable arg1) throws Throwable {
	 
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String dateError = dataMap.get("date");
				String hourError =dataMap.get("hour");
				String minuteError = dataMap.get("minute");
				
				String notesError = dataMap.get("notes");
				trackersNutritionTrackPage.clearFields();
				trackersNutritionTrackPage.clickSaveButtonWithOutEnteringData();
				
				dateErrorMsgInUI = trackersNutritionTrackPage.getErrorMessage("Date");
				Assert.assertTrue("Date Error Message displayed",dateErrorMsgInUI.contains(dateError));
				
				hourErrorMsgInUI = trackersNutritionTrackPage.getErrorMessage("Hours");
				Assert.assertTrue("Hour Error Message displayed",hourErrorMsgInUI.contains(hourError));
				
				minuteErrorMsgInUI = trackersNutritionTrackPage.getErrorMessage("Minutes");
				Assert.assertTrue("Minute Error Message displayed",minuteErrorMsgInUI.contains(minuteError));
				
				 trackersNutritionTrackPage.enterNotesMoreCharacters("Notes");;
				 noteErrorMsgInUI=  trackersNutritionTrackPage.getErrorMessage("Notes");
				 Assert.assertTrue("notes Error Message displayed",noteErrorMsgInUI.contains(notesError));
				
	}
	

	
	@When("^User navigate to Nutrition Goal select the Goal$")
	public void user_navigate_to_Nutrition_Goal_select_the_Goal() throws Throwable {
	   

		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

        trackersBasePage =	portalHomePage.openTrackersPage();
        
        Assert.assertTrue("Trackers Page is displayed",trackersBasePage.isDisplayed());

        trackersNutritionBasePage = trackersBasePage.navigateToNutritionPage();
        
        Assert.assertTrue("Trackers Nutrition Page is displayed",trackersNutritionBasePage.isDisplayed());
        
        trackersNutritionGoalPage = trackersNutritionBasePage.navigateToGoalPage();
        
        Assert.assertTrue("Trackers Nutrition Goal Page is displayed",trackersNutritionGoalPage.isDisplayed());
        
        trackersNutritionGoalPage.selectTrackOption("DAILYGOAL");
        
        trackersNutritionGoalPage.clickContinueSaveButton();
        
	}

	@When("^User should Add the Goal in the Goal Page$")
	public void user_should_Add_the_Goal_in_the_Goal_Page(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String heightFeet = dataMap.get("feet");
		String heightInches = dataMap.get("inches");
		String weight = dataMap.get("weight");
		String active = dataMap.get("How Active are you?");
		String physicalLimitations = dataMap.get("Do you have any physical Limitations?");
		String mealPlan = dataMap.get("Choose your meal plan");
		String calories = dataMap.get("Calories");
		String weeks = dataMap.get("Weeks");
		
		trackersNutritionGoalPage.enterText("FEET", heightFeet);
		
		trackersNutritionGoalPage.enterText("INCHES", heightInches);
		
		trackersNutritionGoalPage.enterText("WEIGHT", weight);
		
		trackersNutritionGoalPage.selectDropdown(active);
		
		trackersNutritionGoalPage.selectDropdown(physicalLimitations);
		
		trackersNutritionGoalPage.selectRadiobtnOrCheckBox(mealPlan);
		
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		trackersNutritionGoalPage.selectDropdown(calories);
		
		trackersNutritionGoalPage.selectDropdown(weeks);
		
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		Assert.assertTrue("Edit Button is displayed", trackersNutritionGoalPage.isEditButtonDisplayed());
		
	}
	
	

	@Then("^User should Edit the Goal which is added in the Goal Page$")
	public void user_should_Edit_the_Goal_which_is_added_in_the_Goal_Page(DataTable arg1) throws Throwable {
	   
				 
				HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
				
				String heightFeet = dataMap.get("feet");
				String heightInches = dataMap.get("inches");
				String weight = dataMap.get("weight");
				String active = dataMap.get("How Active are you?");
				String physicalLimitations = dataMap.get("Do you have any physical Limitations?");
				String mealPlan = dataMap.get("Choose your meal plan");
				String calories = dataMap.get("Calories");
				String weeks = dataMap.get("Weeks");
				
				trackersNutritionGoalPage.clickBackEditButton("EDIT");
				
				trackersNutritionGoalPage.enterText("FEET", heightFeet);
				
				trackersNutritionGoalPage.enterText("INCHES", heightInches);
				
				trackersNutritionGoalPage.enterText("WEIGHT", weight);
				
				trackersNutritionGoalPage.selectDropdown(active);
				
				trackersNutritionGoalPage.selectDropdown(physicalLimitations);
				
				trackersNutritionGoalPage.selectRadiobtnOrCheckBox(mealPlan);
				
				trackersNutritionGoalPage.clickContinueSaveButton();
				
				trackersNutritionGoalPage.selectDropdown(calories);
				
				trackersNutritionGoalPage.selectDropdown(weeks);
				
				trackersNutritionGoalPage.clickContinueSaveButton();
				
				trackersNutritionGoalPage.clickContinueSaveButton();
				
				goalSummaryTextInUI = trackersNutritionGoalPage.getDailyGoalSummaryText();
				
				Assert.assertTrue("Goal Summary Text is updated",goalSummaryTextInUI.contains(calories) );
				
				Assert.assertTrue("Goal Summary Text is updated",goalSummaryTextInUI.contains(weeks) );
	}
	
	
	@When("^User navigate to Trackers page Click on Journal tab it should be navigated to Journal Page$")
	public void user_navigate_to_Trackers_page_Click_on_Journal_tab_it_should_be_navigated_to_Journal_Page() throws Throwable {
	    
		 portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

	        trackersBasePage =	portalHomePage.openTrackersPage();
	        
	        Assert.assertTrue("Trackers Page is displayed",trackersBasePage.isDisplayed());

	        trackersNutritionBasePage = trackersBasePage.navigateToNutritionPage();
	        
	        Assert.assertTrue("Trackers Nutrition Page is displayed",trackersNutritionBasePage.isDisplayed());
	        
	        trackersNutritionJournalPage = trackersNutritionBasePage.navigateToJournalPage();
	  		
	  		Assert.assertTrue("Nutrition Trackers Journal page is displayed",trackersNutritionJournalPage.isDisplayed());
	  		
	        journalContentInUI = trackersNutritionJournalPage.getJournalContent();
	
	  		Assert.assertTrue("Journal content without any track updation is displayed",journalContentInUI.contains(TrackersConstants.TRACKERS_NUTRITION_JOURNAL_CONTENT));

	}

	@When("^Click on Save Button without entering data in Step page error message should be displayed$")
	public void click_on_Save_Button_without_entering_data_in_Step_page_error_message_should_be_displayed(DataTable arg1) throws Throwable {
	 
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String height = dataMap.get("height");
		String weight = dataMap.get("weight");
		//String mealPlan = dataMap.get("mealPlan");
		
		trackersNutritionGoalPage = trackersNutritionBasePage.navigateToGoalPage();
		
		 Assert.assertTrue("Trackers Nutrition Goal Page is displayed",trackersNutritionGoalPage.isDisplayed());
	        
	        trackersNutritionGoalPage.selectTrackOption("DAILYGOAL");
	        
	        trackersNutritionGoalPage.clickContinueSaveButton();
	        
	        gaolStep1HeadingInUI = trackersNutritionGoalPage.getTrackStepsHeading("Step12","Step");
	        
	        Assert.assertTrue("Goal Page Step 1 Heading",gaolStep1HeadingInUI.contains(TrackersConstants.TRACKERS_NUTRITION_TRACK_STEP1_CONTENT));
	        
	        trackersNutritionGoalPage.clearFields("feet");
	        
	        trackersNutritionGoalPage.clearFields("inches");
	        
	        trackersNutritionGoalPage.clearFields("weight");
	        
	        trackersNutritionGoalPage.clickContinueSaveButton();
	        
	        heightErrorMsgInUI = trackersNutritionGoalPage.getErrorMessage("feet");
	        
	        Assert.assertTrue("Height error msg is displayed",heightErrorMsgInUI.contains(height));
	        
	         weightErrorMsgInUI = trackersNutritionGoalPage.getErrorMessage("Weight");
	         
	         Assert.assertTrue("Weight error msg is displayed",weightErrorMsgInUI.contains(weight));
		
	}

	@When("^User should Add the Goal in the Goal Page and also able to see back Button$")
	public void user_should_Add_the_Goal_in_the_Goal_Page_and_also_able_to_see_back_Button(DataTable arg1) throws Throwable {
	 
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String heightFeet = dataMap.get("feet");
		String heightInches = dataMap.get("inches");
		String weight = dataMap.get("weight");
		String active = dataMap.get("How Active are you?");
		String physicalLimitations = dataMap.get("Do you have any physical Limitations?");
		String mealPlan = dataMap.get("Choose your meal plan");
		
		
		trackersNutritionGoalPage.enterText("FEET", heightFeet);
		
		trackersNutritionGoalPage.enterText("INCHES", heightInches);
		
		trackersNutritionGoalPage.enterText("WEIGHT", weight);
		
		trackersNutritionGoalPage.selectDropdown(active);
		
		trackersNutritionGoalPage.selectDropdown(physicalLimitations);
		
		trackersNutritionGoalPage.selectRadiobtnOrCheckBox(mealPlan);
		
		Assert.assertTrue("Back Button is displayed",trackersNutritionGoalPage.isBackButtonDisplayed());
		
		
	}

	@When("^Click on Save Button it should be navigated to Second page$")
	public void click_on_Save_Button_it_should_be_navigated_to_Second_page(DataTable arg1) throws Throwable {
	  
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String calories = dataMap.get("Calories");
		String weeks = dataMap.get("Weeks");
		
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		 gaolStep2HeadingInUI = trackersNutritionGoalPage.getTrackStepsHeading("Step12","Step");
	        
	    Assert.assertTrue("Goal Page Step 2 Heading",gaolStep2HeadingInUI.contains(TrackersConstants.TRACKERS_NUTRITION_TRACK_STEP2_CONTENT));
	        
		trackersNutritionGoalPage.selectDropdown(calories);
		
		trackersNutritionGoalPage.selectDropdown(weeks);
		
		
		
	}

	@When("^Click on Save Button it should be navigated to third page$")
	public void click_on_Save_Button_it_should_be_navigated_to_third_page() throws Throwable {
	         
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		 gaolStep3HeadingInUI = trackersNutritionGoalPage.getTrackStepsHeading("Step3","Step");
	        
		 Assert.assertTrue("Goal Page Step 3 Heading",gaolStep3HeadingInUI.contains(TrackersConstants.TRACKERS_NUTRITION_TRACK_STEP3_CONTENT));
		
		
	}

	@Then("^verfiy Goal summary page$")
	public void verfiy_Goal_summary_page(DataTable arg1) throws Throwable {
		
       HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String calories = dataMap.get("Calories");
		
		String weeks = dataMap.get("Weeks");
		
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		goalSummaryTextInUI = trackersNutritionGoalPage.getDailyGoalSummaryText();
		
		Assert.assertTrue("Goal Summary Text is updated",goalSummaryTextInUI.contains(calories) );
		
		Assert.assertTrue("Goal Summary Text is updated",goalSummaryTextInUI.contains(weeks) );
		
		Assert.assertTrue("Edit Button is displayed", trackersNutritionGoalPage.isEditButtonDisplayed());
		
		
	}

	@Then("^Click on Journal Tab to verify the goal details$")
	public void click_on_Journal_Tab_to_verify_the_goal_details(DataTable arg1) throws Throwable {
		
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
			
			String calories = dataMap.get("Calories");
	    
		 trackersNutritionJournalPage = trackersNutritionBasePage.navigateToJournalPage();
	  		
	  	 Assert.assertTrue("Nutrition Trackers Journal page is displayed",trackersNutritionJournalPage.isDisplayed());
	  	 
	  	trackersNutritionJournalPage.selectTrackerDropDown("Goals History");
	  	
	  	Assert.assertTrue("GoalHistory is displayed",trackersNutritionJournalPage.isGoalDisplayed());
	  	
	  	dateInGoalHistoryInUI=trackersNutritionJournalPage.getDateFromGoalhistory();
	  	
	  	String dateToEnter = DateTimeUtils.getCurrentTimeStamp("MM/dd/YYYY");
	  	
	  	Assert.assertTrue("In Goal History Date is displayed",dateInGoalHistoryInUI.contains(dateToEnter) );
	  	
	  	caloriesInGoalHistoryInUI=trackersNutritionJournalPage.getGoalHistoryData("1200");
	  	
	  	Assert.assertTrue("In Goal History Calories is displayed",caloriesInGoalHistoryInUI.contains(calories) );
	  	
	  	
	}
	
	
	@When("^User navigate to Nutrition Goal select the Goal Fruits and Veggies and validate the content$")
	public void user_navigate_to_Nutrition_Goal_select_the_Goal_Fruits_and_Veggies_and_validate_the_content() throws Throwable {
                   
		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

        trackersBasePage =	portalHomePage.openTrackersPage();
        
        Assert.assertTrue("Trackers Page is displayed",trackersBasePage.isDisplayed());

        trackersNutritionBasePage = trackersBasePage.navigateToNutritionPage();
        
        Assert.assertTrue("Trackers Nutrition Page is displayed",trackersNutritionBasePage.isDisplayed());
        
        trackersNutritionGoalPage = trackersNutritionBasePage.navigateToGoalPage();
        
        Assert.assertTrue("Trackers Nutrition Goal Page is displayed",trackersNutritionGoalPage.isDisplayed());
        
        trackersNutritionGoalPage.selectTrackOption("FRUITSGOAL");
        
        trackersNutritionGoalPage.clickContinueSaveButton();
        
        goalVeggiesHeadingInUI = trackersNutritionGoalPage.getTrackVeggiesGoalHeading();
        
        Assert.assertTrue("Track Veggies Heading is displayed",goalVeggiesHeadingInUI.contains(TrackersConstants.TRACKERS_NUTRITION_VEGGIES_GOAL_CONTENT));
        
        
	}

	@When("^Click on Save Button without selecting any goal error message should be displayed$")
	public void click_on_Save_Button_without_selecting_any_goal_error_message_should_be_displayed(DataTable arg1) throws Throwable {
	    
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
			
		 String goalErrorMsg = dataMap.get("goal");
			 
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		goalVeggiesErrorInUI =trackersNutritionGoalPage.getVeggiesErrorMessage();
		
		Assert.assertTrue("Track Veggies Goal Error is displayed",goalVeggiesErrorInUI.contains(goalErrorMsg));
		
	}

	@When("^Add all the three goals and also able to see back button$")
	public void add_all_the_three_goals_and_also_able_to_see_back_button(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		 String fruitServing = dataMap.get("FruitsServings");
		 String fruitWeeks = dataMap.get("FruitsWeeks");
		 String veggieServing = dataMap.get("VeggiesServings");
		 String veggieWeeks = dataMap.get("VeggiesWeeks");
		 String fatServing = dataMap.get("FatsServings");
		 String fatWeeks = dataMap.get("FatsWeeks");
		
		 trackersNutritionGoalPage.selectTrackOption("FRUITS");
		trackersNutritionGoalPage.selectDailyServingsWeekDropdown("FRUITSERVING", fruitServing);
		trackersNutritionGoalPage.selectDailyServingsWeekDropdown("FRUITSWEEKS", fruitWeeks);
		
		trackersNutritionGoalPage.selectTrackOption("VEGGIES");
		trackersNutritionGoalPage.selectDailyServingsWeekDropdown("VEGETABLESERVING", veggieServing);
		trackersNutritionGoalPage.selectDailyServingsWeekDropdown("VEGETABLESWEEKS", veggieWeeks);
		
		trackersNutritionGoalPage.selectTrackOption("FATS");
		trackersNutritionGoalPage.selectDailyServingsWeekDropdown("FATSERVING", fatServing);
		trackersNutritionGoalPage.selectDailyServingsWeekDropdown("FATSWEEKS", fatWeeks);

		Assert.assertTrue("Back Button is displayed",trackersNutritionGoalPage.isBackButtonDisplayed());

	}

	@Then("^Click on Save Button it should be navigated to GoalSummary Page with the added goals displayed$")
	public void click_on_Save_Button_it_should_be_navigated_to_GoalSummary_Page_with_the_added_goals_displayed(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		 String fruitServing = dataMap.get("FruitsServings");
		 String fruitWeeks = dataMap.get("FruitsWeeks");
		 String veggieServing = dataMap.get("VeggiesServings");
		 String veggieWeeks = dataMap.get("VeggiesWeeks");
		 String fatServing = dataMap.get("FatsServings");
		 String fatWeeks = dataMap.get("FatsWeeks");
		 
		trackersNutritionGoalPage.clickContinueSaveButton();
		
		goalFruitSummaryTextInUI = trackersNutritionGoalPage.getDailyServingGoalSummaryText("fruit");
		
		goalVeggieSummaryTextInUI = trackersNutritionGoalPage.getDailyServingGoalSummaryText("veggie");
		
		goalFatSummaryTextInUI = trackersNutritionGoalPage.getDailyServingGoalSummaryText("fat");
		
		Assert.assertTrue("Goal Summary Fruit Servings is displayed",goalFruitSummaryTextInUI.contains(fruitServing) );
		
		Assert.assertTrue("Goal Summary Fruit Weeks is displayed",goalFruitSummaryTextInUI.contains(fruitWeeks) );
		
		Assert.assertTrue("Goal Summary Veggie Servings is displayed",goalVeggieSummaryTextInUI.contains(veggieServing) );
		
		Assert.assertTrue("Goal Summary Veggie Weeks is displayed",goalVeggieSummaryTextInUI.contains(veggieWeeks) );
		
        Assert.assertTrue("Goal Summary Fat Servings is displayed",goalFatSummaryTextInUI.contains(fatServing) );
		
		Assert.assertTrue("Goal Summary Fat Weeks is displayed",goalFatSummaryTextInUI.contains(fatWeeks) );
		
		Assert.assertTrue("Edit Button is displayed", trackersNutritionGoalPage.isEditButtonDisplayed());
	}

	@Then("^Click on Journal Tab to verify the added goal details in GoalsHistory$")
	public void click_on_Journal_Tab_to_verify_the_added_goal_details_in_GoalsHistory(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		 String fruitServing = dataMap.get("FruitsServings");
		 String fruitWeeks = dataMap.get("FruitsWeeks");
		 String veggieServing = dataMap.get("VeggiesServings");
		 String veggieWeeks = dataMap.get("VeggiesWeeks");
		 String fatServing = dataMap.get("FatsServings");
		 String fatWeeks = dataMap.get("FatsWeeks");
		 
		 trackersNutritionJournalPage = trackersNutritionBasePage.navigateToJournalPage();
	  		
	  	 Assert.assertTrue("Nutrition Trackers Journal page is displayed",trackersNutritionJournalPage.isDisplayed());
	  	 
	  	trackersNutritionJournalPage.selectTrackerDropDown("Goals History");
	  	
	  	Assert.assertTrue("GoalHistory is displayed",trackersNutritionJournalPage.isGoalDisplayed());
	  	
	  	dateInGoalHistoryInUI=trackersNutritionJournalPage.getDateFromGoalhistory();
	  	
	  	String dateToEnter = DateTimeUtils.getCurrentTimeStamp("MM/dd/YYYY");
	  	
		Assert.assertTrue("In Goal History Date is displayed",dateInGoalHistoryInUI.contains(dateToEnter) );
	  	
		fruitServingValueUI = trackersNutritionJournalPage.getGoalHistoryData("fruit");
        
		veggiesServingValueUI = trackersNutritionJournalPage.getGoalHistoryData("veggie");
        
		fatsServingValueUI = trackersNutritionJournalPage.getGoalHistoryData("fat");
        
        Assert.assertTrue("Goal History Fruit Servings is displayed",fruitServingValueUI.contains(fruitServing));
		
		Assert.assertTrue("Goal History Fruit Weeks is displayed",fruitServingValueUI.contains(fruitWeeks));
		
		Assert.assertTrue("Goal History Veggie Servings is displayed",veggiesServingValueUI.contains(veggieServing));
		
		Assert.assertTrue("Goal History Veggie Weeks is displayed",veggiesServingValueUI.contains(veggieWeeks));
		
        Assert.assertTrue("Goal History Fat Servings is displayed",fatsServingValueUI.contains(fatServing) );
		
		Assert.assertTrue("Goal History Fat Weeks is displayed",fatsServingValueUI.contains(fatWeeks) );
		
		
	}



}
