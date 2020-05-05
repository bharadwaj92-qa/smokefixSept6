package com.alerehealth.ui.stepdefenitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.alerehealth.ui.portal.carereminders.CareReminderPage;
import com.alerehealth.ui.portal.carereminders.CareReminderPrintPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.library.CareReminderLibraryPage;
import com.alerehealth.ui.portal.library.LibraryConstants;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CareRemainderStepDef {
	
	PortalHomePage portalHomePage = null;
	CareReminderPage careReminderPage  = null;
	CareReminderPrintPage careReminderPrintPage = null;
	CareReminderLibraryPage careReminderLibraryPage = null;
	
	int notificationCountFromUserMenu;
	String careReminderTilteFromUI;
	String getSelectedAnswerFromUI;
	int openCareRemindersCount;
	int printCareRemindersCount;
	
	String radioButton;
	
	List<String> careRemindersFromOpenPage ;
	List<String> careRemindersFromPrintPage ;
	List<String> careRemindersFromOpenPageAfterSubmit;
	
	@When("^Click on \"([^\"]*)\"  navigate to CareReminders Page$")
	public void click_on_navigate_to_CareReminders_Page(String arg1) throws Throwable {
		
		  portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
	    
		  portalHomePage.clickOnUserName();
		  
		  notificationCountFromUserMenu =  portalHomePage.getCareReminderNotificationCount();
		 	
		  careReminderPage  = portalHomePage.openCareReminders();
	      
	     
	}

	@Then("^Count of Care Reminders should match with Open Care Reminders$")
	public void count_of_Care_Reminders_should_match_with_Open_Care_Reminders() throws Throwable {

		
		Assert.assertTrue("Validating Care reminder page is open", careReminderPage.isDisplayed());
		
		openCareRemindersCount = careReminderPage.getOpenCRMsgCount();
		
		Assert.assertEquals("Validating Open care reminders match with notification count in user profile", notificationCountFromUserMenu, openCareRemindersCount);
		
		careRemindersFromOpenPage = careReminderPage.getOpenCareAlerts(); 
	}

	@Then("^Click on Print Icon in Open Care Reminders$")
	public void click_on_Print_Icon_in_Open_Care_Reminders() throws Throwable {
		
		
		careReminderPrintPage = careReminderPage.clickPrintIcon();
		
		Assert.assertTrue("Care reminders Print page is launched ",careReminderPrintPage.isDisplayed());
	}

	@Then("^Count of Print Care Reminders should match with Open Care Reminders$")
	public void count_of_Print_Care_Reminders_should_match_with_Open_Care_Reminders() throws Throwable {
	   
		
         printCareRemindersCount = careReminderPrintPage.getPrintRemindersCount();
		
		 Assert.assertEquals("Validating Open care reminders match with Print Care Reminders count ", openCareRemindersCount, printCareRemindersCount);
		
		 careRemindersFromPrintPage = careReminderPrintPage.getPrintCareReminders(); 
		
		
		 Assert.assertEquals("Open Alerts from Care reminder page are present in Print page", careRemindersFromPrintPage,careRemindersFromOpenPage);
		
		
		
	
	}
	
	
	@When("^User is in Open Care Reminders page$")
	public void user_is_in_Open_Care_Reminders_page() throws Throwable {
		
		   portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
		   
		   portalHomePage.clickOnUserName();
	   
		   careReminderPage  = portalHomePage.openCareReminders();
			
		   Assert.assertTrue("Validating Care reminder page is open", careReminderPage.isDisplayed());
			
		   careRemindersFromOpenPage = careReminderPage.getOpenCareAlerts();
			
			
	}

	
	
	@When("^Click on Expand button and Learn more about link navigate to expand BP page$")
	public void click_on_Expand_button_and_Learn_more_about_link_navigate_to_expand_BP_page() throws Throwable {
	    
      
		careReminderPage.expandReminder("blood pressure");
		
		careReminderLibraryPage= careReminderPage.learnMoreAboutReminder("blood pressure");
		
		careReminderTilteFromUI = careReminderLibraryPage.getCareReminderTitle();
		
		Assert.assertTrue("Library description page title is as expected",careReminderTilteFromUI.contains(LibraryConstants.LIBRARY_CAREREMINDER_BP_PAGE_TITLE));
		
		
		careReminderPage  = careReminderLibraryPage.openCareReminders();
		
		Assert.assertTrue("Validating Care reminder page is open", careReminderPage.isDisplayed());
		
		careReminderPage.expandReminder("blood pressure");
		
		
	}

	@When("^Select any of the answer option and click on Submit button$")
	public void select_any_of_the_answer_option_and_click_on_Submit_button(DataTable arg1) throws Throwable {
		
		
	    
         Map dataMap = arg1.asMap(String.class, String.class);

         radioButton = (String) dataMap.get("Radiobutton");
        
         careReminderPage.clickOnRadioBtn(radioButton);
        
		 careReminderPage.clickSubmit();
		
		 Assert.assertTrue("BP decription content is displayed ",careReminderPage.isSuccessDisplayed());		
	}

	@Then("^Above answer option is not present in careList$")
	public void above_answer_option_is_not_present_in_careList() throws Throwable {
		
				
		 careReminderPage  = careReminderPage.openCareReminders();
		 Assert.assertTrue("Validating Care reminder page is open", careReminderPage.isDisplayed());
	   
		
		 careRemindersFromOpenPageAfterSubmit = careReminderPage.getOpenCareAlerts();
		
		 Assert.assertFalse("Care Reminders should not be same",careRemindersFromOpenPageAfterSubmit.containsAll(careRemindersFromOpenPage));
	}

	@Then("^Click on Closed Care Reminders option$")
	public void click_on_Closed_Care_Reminders_option() throws Throwable {
	   
		careReminderPage.clickOnLinkClosed();
		Assert.assertTrue("Closed Reminders is displayed ",careReminderPage.isClosedReminderDisplayed());
		
	}

	@Then("^Above answered BP CR is displayed under closed care Reminder$")
	public void above_answered_BP_CR_is_displayed_under_closed_care_Reminder() throws Throwable {
	   
		Assert.assertTrue("BP CR should be displayed under Closed Reminders",careReminderPage.isClosedReminder("blood pressure"));
	}

	@Then("^Click on Expand button related to BP closed$")
	public void click_on_Expand_button_related_to_BP_closed() throws Throwable {
	    
		careReminderPage.expandReminder("blood pressure");
	   
	}

	@Then("^same answer option should be selected and All answer options should not be editable$")
	public void same_answer_option_should_be_selected_and_All_answer_options_should_not_be_editable() throws Throwable {
	   		
		
		
		Assert.assertTrue("All Answer options Radio Buttons are Disabled",careReminderPage.isAllAnswerOptionsDisabled());
		
		
		getSelectedAnswerFromUI = careReminderPage.getSelectedAnswerOptionForClosedReminder();
		
		Assert.assertTrue("Selected Answer option is same in open and closed reminders",getSelectedAnswerFromUI.contains(radioButton));
		
		
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

