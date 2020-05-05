package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.progress.constants.TrackersConstants;
import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityBasePage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityGoalPage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityJournalPage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityProgressPage;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityTrackPage;
import com.alerehealth.ui.portal.progress.trackers.weightandbmi.TrackersWeightBMITracPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrackersActivityStepDef {
	
	 PortalHomePage portalHomePage = null;

	  TrackersBasePage trackersBasePage;
	  
	  TrackersActivityTrackPage trackersActivityTrackPage;
	  
	  TrackersActivityBasePage trackersActivityBasePage;
	  
	  TrackersActivityJournalPage trackersActivityJournalPage;
	  
	  TrackersActivityProgressPage trackersActivityProgressPage;
	  
	  TrackersActivityGoalPage trackersActivityGoalPage;
	  
	  TrackersWeightBMITracPage  trackersWeightBMITracPage;
	  
	  String dateErrorMsgInUI;
	  String hourErrorMsgInUI;
	  String minuteErrorMsgInUI;
	  String activityErrorMsgInUI;
	  String noteErrorMsgInUI;
	  String hourDurationErrorMsgInUI;
	  String minuteDurationErrorMsgInUI;
	  
	  String withOutTrackJournalContentInUI;
	  
	  List<String>  activityTabs;
	  
	  String editBoxTextInUI;
	  String deleteBoxTextInUI;
	  
	  String notesTextInUI;
	  
	  String goalHistoryMilesInUI;
	  
	  String goalHistoryWeeksInUI;
	  
	  int sizeAfterAddingTrack;
	  int sizeAfterDeletingTrack;
	  
     Date actualStartDate=null;
      
      Date actualEndDate=null;
      
      Date expectedStartDate=null;
      
      Date expectedEndDate=null;
	  
	
	@When("^User click on Track tab to navigate to Activity Track page and Click on Ok Button$")
	public void user_click_on_Track_tab_to_navigate_to_Activity_Track_page_and_Click_on_Ok_Button() throws Throwable {
		 
		    portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

	        trackersBasePage =	portalHomePage.openTrackersPage();
	        
	        Assert.assertTrue("Trackers Page is displayed",trackersBasePage.isDisplayed());

	        trackersActivityBasePage = trackersBasePage.navigateToActivityPage();
	        
	        Assert.assertTrue("Trackers Activity Page is displayed",trackersActivityBasePage.isDisplayed());
	        
	        trackersActivityTrackPage = trackersActivityBasePage.navigateToTrackTab();
	        
	        Assert.assertTrue("Trackers Activity Track Page is displayed",trackersActivityTrackPage.isDisplayed());
	        
	        trackersWeightBMITracPage = trackersActivityTrackPage.clickOkButton();
	        
	        Assert.assertTrue("Trackers Weight BMI page is displayed",trackersWeightBMITracPage.isDisplayed());
	}
	
	@When("^Enter all Data in WeightBMI track page and navigate to Actvity Track page$")
	public void enter_all_Data_in_WeightBMI_track_page_and_navigate_to_Actvity_Track_page(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String weight = dataMap.get("Weight");
		 String feet = dataMap.get("Feet");
	     String inches = dataMap.get("Inches");
		trackersWeightBMITracPage.enterWeight(weight);
		trackersWeightBMITracPage.enterHeight(feet, inches);
		trackersWeightBMITracPage.clickSaveButton();
		trackersActivityBasePage = trackersWeightBMITracPage.navigateToActivityPage();
		trackersActivityTrackPage = trackersActivityBasePage.navigateToTrackTab();
        Assert.assertTrue("Trackers Activity Track Page is displayed",trackersActivityTrackPage.isDisplayed());
	        
		
	}

	@When("^User click on save Button without entering data to validate error messages in all fields$")
	public void user_click_on_save_Button_without_entering_data_to_validate_error_messages_in_all_fields() throws Throwable {
        
		trackersActivityTrackPage.clearFields();
		trackersActivityTrackPage.clickSaveButtonWithoutEnteringData();
		
		dateErrorMsgInUI = trackersActivityTrackPage.getErrorMessage("Date");
		Assert.assertTrue("Date Error Message displayed",dateErrorMsgInUI.contains(TrackersConstants.TRACKERS_DATE_ERROR_MSG));
		activityErrorMsgInUI = trackersActivityTrackPage.getErrorMessage("Activity");
		Assert.assertTrue("Activity Error Message displayed",activityErrorMsgInUI.contains(TrackersConstants.TRACKERS_ACTIVITY_ERROR_MSG));
		hourErrorMsgInUI = trackersActivityTrackPage.getErrorMessage("Hours");
		Assert.assertTrue("Hour Error Message displayed",hourErrorMsgInUI.contains(TrackersConstants.TRACKERS_HOURS_ERROR_MSG));
		minuteErrorMsgInUI = trackersActivityTrackPage.getErrorMessage("Minutes");
		Assert.assertTrue("Minute Error Message displayed",minuteErrorMsgInUI.contains(TrackersConstants.TRACKERS_MINUTES_ERROR_MSG));
		hourDurationErrorMsgInUI = trackersActivityTrackPage.getErrorMessage("DURATIONHOUR");
		Assert.assertTrue("hourDuration Error Message displayed",hourDurationErrorMsgInUI.contains(TrackersConstants.TRACKERS_DURATION_ERROR_MSG));
		minuteDurationErrorMsgInUI = trackersActivityTrackPage.getErrorMessage("DURATIONMINUTES");
		Assert.assertTrue("minuteDuration Error Message displayed",minuteDurationErrorMsgInUI.contains(TrackersConstants.TRACKERS_DURATION_ERROR_MSG));
		
		trackersActivityTrackPage.enterNotesMoreCharacters("Notes");
		trackersActivityTrackPage.clickSaveButtonWithoutEnteringData();
		 noteErrorMsgInUI=  trackersActivityTrackPage.getErrorMessage("Notes");
		 Assert.assertTrue("notes Error Message displayed",noteErrorMsgInUI.contains(TrackersConstants.TRACKERS_NOTES_ERROR_MSG));
	}

	@When("^Save all data in Activity Track page by clicking on save button which should be navigated to Journal page$")
	public void save_all_data_in_Activity_Track_page_by_clicking_on_save_button_which_should_be_navigated_to_Journal_page(DataTable arg1) throws Throwable {
		
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String dateEntered = dataMap.get("DateEntered");
		 String timeEntered = dataMap.get("Time");
	     String activitySelected = dataMap.get("Activity");
	     String hour = dataMap.get("DurationHours");
	     String minutes = dataMap.get("DurationMinutes");
	    // String calories = dataMap.get("CaloriesBurned");
	     String step = dataMap.get("Steps");
	     String distance = dataMap.get("Distance");
	     String note = dataMap.get("Notes");
	     
	     trackersActivityTrackPage.enterDate(dateEntered);
	     trackersActivityTrackPage.enterActivity(activitySelected);
	     trackersActivityTrackPage.enterTime(timeEntered);
	     trackersActivityTrackPage.enterDuration(hour, minutes);
	 
	     trackersActivityTrackPage.enterNotes(note);
	     trackersActivityJournalPage = trackersActivityTrackPage.clickSaveButton();
	     Assert.assertTrue("Journal Page is displayed",trackersActivityJournalPage.isDisplayed());
	     sizeAfterAddingTrack = trackersActivityJournalPage.getJournalRecordCount();
	}

	@When("^Validate All records should be displayed based on the entry criteria in Journal Page$")
	public void validate_All_records_should_be_displayed_based_on_the_entry_criteria_in_Journal_Page(DataTable arg1) throws Throwable {
	   
    HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String startDate = dataMap.get("StartDate");
		
		String dateToEnter = DateTimeUtils.getCurrentTimeStamp("MM/dd/YYYY");
		
        
        List<String> journalEntires =trackersActivityJournalPage.getJournalEntriesTimeStamp(startDate,dateToEnter);
        
        System.out.println("printing list:"+journalEntires);
        
        String actualStart=null;
        String format="MM/dd/yyyy";
        
        actualStart=journalEntires.get(journalEntires.size()-1).substring(0,10);
        
       
        
        String actualEnd=journalEntires.get(0).substring(0,10);
        try {
               actualStartDate=DateTimeUtils.stringToDate(format, actualStart);
             actualEndDate =DateTimeUtils.stringToDate(format,actualEnd);
               expectedStartDate=DateTimeUtils.stringToDate(format, startDate);
             expectedEndDate=DateTimeUtils.stringToDate(format,dateToEnter);
               
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
	
	@When("^Click on Edit Link of the record to click Yes button on Edit popup$")
	public void click_on_Edit_Link_of_the_record_to_click_Yes_button_on_Edit_popup(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String dateEntered = dataMap.get("DateEntered");
		trackersActivityJournalPage.editEntryFromJournal(dateEntered);
		editBoxTextInUI = trackersActivityJournalPage.getEditBoxText();
		Assert.assertTrue("Edit Box text displayed correctly", editBoxTextInUI.contains(TrackersConstants.TRACKERS_EDIT_BOX_TEXT));
		trackersActivityTrackPage = trackersActivityJournalPage.clickYesButtonEditDialouge();
		Assert.assertTrue("Activty Track Page is displayed",trackersActivityTrackPage.isDisplayed() );
	}

	@When("^validate whether edited record displayed in Journal Page$")
	public void validate_whether_edited_record_displayed_in_Journal_Page(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		     String step = dataMap.get("Steps");
	
	     String note = dataMap.get("Notes");
	     String editedRecord = dataMap.get("RecordEdited");
	
	     trackersActivityTrackPage.enterActivityFields("Steps", step);
	     trackersActivityTrackPage.enterNotes(note);
	     trackersActivityJournalPage = trackersActivityTrackPage.clickSaveButton();
	     Assert.assertTrue("Journal Page is displayed",trackersActivityJournalPage.isDisplayed());
		 Assert.assertTrue(trackersActivityJournalPage.isRecordDisplayed(editedRecord));
		 notesTextInUI = trackersActivityJournalPage.getNotesText(editedRecord);
		Assert.assertTrue("Updated notes text is displayed",notesTextInUI.contains(note));
	}

	@When("^click on Delete Link of the record to click Yes Button to validate deleted record is not displayed in Journal Page$")
	public void click_on_Delete_Link_of_the_record_to_click_Yes_Button_to_validate_deleted_record_is_not_displayed_in_Journal_Page(DataTable arg1) throws Throwable {
              
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String deletedRecord = dataMap.get("DeletedRecord");
		 trackersActivityJournalPage.deleteEntryFromJournal(deletedRecord);
		deleteBoxTextInUI = trackersActivityJournalPage.getDeleteBoxText();
		Assert.assertTrue("Delete Box text displayed correctly", deleteBoxTextInUI.contains(TrackersConstants.TRACKERS_DELETE_BOX_TEXT));
		trackersActivityJournalPage = trackersActivityJournalPage.clickYesButtonDeleteDialogue();
		Assert.assertTrue("Journal Page is displayed",trackersActivityJournalPage.isDisplayed());
	     sizeAfterDeletingTrack=trackersActivityJournalPage.getJournalRecordCount();
	     Assert.assertEquals(sizeAfterAddingTrack-1, sizeAfterDeletingTrack);
	      Assert.assertFalse(trackersActivityJournalPage.isRecordDisplayed(deletedRecord));
		
	}
	
	@When("^User navigate to Activity Trackers Page validate the tabs displayed$")
	public void user_navigate_to_Activity_Trackers_Page_validate_the_tabs_displayed() throws Throwable {
	    
		 portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

	        trackersBasePage =	portalHomePage.openTrackersPage();
	        
	        Assert.assertTrue("Trackers Page is displayed",trackersBasePage.isDisplayed());

	        trackersActivityBasePage = trackersBasePage.navigateToActivityPage();
	        
	        Assert.assertTrue("Trackers Activity Page is displayed",trackersActivityBasePage.isDisplayed());
	        
	        activityTabs =  trackersActivityBasePage.isNavigationTabsDisplayed();
	        
	        System.out.println(activityTabs);
	        
	        Assert.assertTrue(activityTabs.containsAll(Arrays.asList("Goal", "Track", "Progress", "Journal")));
	        
	}

	@When("^Click on Journal tab to validate its content without adding any Goal$")
	public void click_on_Journal_tab_to_validate_its_content_without_adding_any_Goal() throws Throwable {
	   
		trackersActivityJournalPage = trackersActivityBasePage.navigateToJournalPage();
		
		 Assert.assertTrue("Journal Page is displayed",trackersActivityJournalPage.isDisplayed());
		 
		 withOutTrackJournalContentInUI = trackersActivityJournalPage.getJournalContent();
		 
		 Assert.assertTrue("Journal Content is displayed",withOutTrackJournalContentInUI.contains(TrackersConstants.TRACKERS_ACTIVITY_JOURNAL_CONTENT));
	}

	@When("^User navigate to Activity Goal Page and validate the content$")
	public void user_navigate_to_Activity_Goal_Page_and_validate_the_content() throws Throwable {
	 
		trackersActivityGoalPage = trackersActivityBasePage.navigateToGoalPage();
		
		Assert.assertTrue("Goal Page is displayed",trackersActivityGoalPage.isDisplayed());
		
		
	}

	@When("^Click on Edit button Validate the content of three goals and also verify the dropdowns$")
	public void click_on_Edit_button_Validate_the_content_of_three_goals_and_also_verify_the_dropdowns(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		String distanceContent = dataMap.get("Distance");
		
		String durationContent = dataMap.get("Duration");
		
		String stepsContent = dataMap.get("Steps");
		
		trackersActivityGoalPage.clickEditButton();
		
		/*trackersActivityGoalPage.selectGoal("Distance");
		
		trackersActivityGoalPage.selectGoal("Duration");
		
		trackersActivityGoalPage.selectGoal("Steps");
		*/
		
	}

	@Then("^Set the Distance Goal and Click on Save Button which should be changed to Edit Button$")
	public void set_the_Distance_Goal_and_Click_on_Save_Button_which_should_be_changed_to_Edit_Button(DataTable arg1) throws Throwable {
	  
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		 String miles = dataMap.get("Miles");
		 
		 String weeks = dataMap.get("Weeks");
		 
		 trackersActivityGoalPage.selectGoal("Distance");
		
		trackersActivityGoalPage.selectGoalsDropdown("Distance", "MilesDistance", miles);
		
		trackersActivityGoalPage.selectGoalsDropdown("Distance", "WeeksDistanceDuration", weeks);
		
		trackersActivityGoalPage.clickSaveButton();
		
		Assert.assertTrue("Edit Button is displayed",trackersActivityGoalPage.isEditButtonDisplayed());
	}

	@Then("^Click on Journal Tab to verify the added goal details displayed in GoalsHistory$")
	public void click_on_Journal_Tab_to_verify_the_added_goal_details_displayed_in_GoalsHistory(DataTable arg1) throws Throwable {
	  
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
		 String miles = dataMap.get("Miles");
		 
		 String weeks = dataMap.get("Weeks");
		 
		 String dateToEnter = DateTimeUtils.getCurrentTimeStamp("MM/dd/YYYY");
		
		trackersActivityJournalPage = trackersActivityBasePage.navigateToJournalPage();
		
		 Assert.assertTrue("Journal Page is displayed",trackersActivityJournalPage.isDisplayed());
		 
		 trackersActivityJournalPage.selectTrackerDropDown("Goals History");
		 
		 Assert.assertTrue("Goal is displayed",trackersActivityJournalPage.isGoalDisplayed() );
		 
		 
		 goalHistoryMilesInUI = trackersActivityJournalPage.getGoalHistoryData(dateToEnter,miles);
		 Assert.assertTrue("Both are same", goalHistoryMilesInUI.contains(miles));
		 
		 goalHistoryWeeksInUI = trackersActivityJournalPage.getGoalHistoryData(dateToEnter,weeks);
		 Assert.assertTrue("Both are same", goalHistoryWeeksInUI.contains(weeks));
		 
	}


}
