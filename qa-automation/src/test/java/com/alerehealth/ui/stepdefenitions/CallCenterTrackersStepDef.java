package com.alerehealth.ui.stepdefenitions;

import org.junit.Assert;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterMyWorkBasketPage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterTrackersPage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterToDosPage;
import com.alerehealth.ui.callcenter.common.pages.HIPAAScreenPage;
import com.alerehealth.ui.callcenter.common.pages.ProgramEnrollmentPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CallCenterTrackersStepDef {
	
	public static CallCenterHomePage callCenterHomePage = null;
	CallCenterOthersHomeMenuPage callCenterOthersHomeMenuPage = null;
	ProgramEnrollmentPage programEnrollmentPage = null;
	CallCenterTrackersPage callCenterTrackersPage = null;
	CallCenterParticipantHomePage callCenterParticipantHomePage = null;
	CallCenterToDosPage callCenterToDosPage = null;
	HIPAAScreenPage hipaaScreenPage = null;
	
	
	
	@When("^User click on Other tab in right navigation$")
	public void user_click_on_Other_tab_in_right_navigation() throws Throwable {
	    
		callCenterHomePage = new CallCenterHomePage();
		callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();
	}

	@When("^provide participatId and click on create$")
	public void provide_participatId_and_click_on_create() throws Throwable {
		callCenterToDosPage = callCenterOthersHomeMenuPage.searchParticipants("P-242039");
	
	}

	@Then("^enroll the participant to \"([^\"]*)\" program$")
	public void enroll_the_participant_to_program(String programName) throws Throwable {
		hipaaScreenPage = callCenterToDosPage.interactionCallInToDo(programName);
	}

	@When("^user clicks on WarmTransfer checkbox$")
	public void user_clicks_on_WarmTransfer_checkbox() throws Throwable {
		programEnrollmentPage = hipaaScreenPage.clickOnWarmTransfer();
	}

	@When("^answer all questions to enroll$")
	public void answer_all_questions_to_enroll() throws Throwable {
		Assert.assertEquals("If you're interested I can get you started in the coaching program today.", programEnrollmentPage.getAssessmentQ1().getText());
        
		System.out.println("Verified assessment question Q1");
        
        programEnrollmentPage.assessmentQuesLCEnroll();
        
	}
	
	@When("^maximize three sixty tab$")
	public void maximize_three_sixty_tab() throws Throwable {
		callCenterToDosPage.threeSixtytabMaximizing();
	}

	@Then("^click on Trackers in (\\d+) tab$")
	public void click_on_Trackers_in_tab(int arg1) throws Throwable {
        callCenterParticipantHomePage = new CallCenterParticipantHomePage();
		
        //callCenterTrackersPage = callCenterParticipantHomePage.openTrackersTab();
        
     //   callCenterTrackersPage.clickOnTrackers();
        
	}

	@Then("^click on \"([^\"]*)\" tab$")
	public void click_on_tab(String trackertype) throws Throwable {
		callCenterTrackersPage.clickOnTrackerType(trackertype);
	}

	@Then("^set goals under activity tab$")
	public void set_goals_under_activity_tab() throws Throwable {
		callCenterTrackersPage.distanceGoal();
		
	}

	@Then("^click on \"([^\"]*)\"$")
	public void click_on(String saveChangeGoal) throws Throwable {
		callCenterTrackersPage.saveOrChangeGoal(saveChangeGoal);
	}
	
	@Then("^set again goals under activity tab$")
	public void set_again_goals_under_activity_tab() throws Throwable {
		callCenterTrackersPage.distanceChangeGoal();
		
	}

	@Then("^verify Track section by providing duration$")
	public void verify_Track_section_by_providing_duration() throws Throwable {
		callCenterTrackersPage.durationTrack();
	}

	@Then("^verify Tracker History data is saving or not$")
	public void verify_Tracker_History_data_is_saving_or_not() throws Throwable {
		Assert.assertEquals("Trackers History text not equlas!", "Tracker History", callCenterTrackersPage.gettrackerHistorytext().getText().trim());
		callCenterTrackersPage.trackerHistory();
	}
	
	/*
	 * Nutrition in LC Trackers
	 */

	@Then("^set goal under nutrition tab$")
	public void set_goal_under_nutrition_tab() throws Throwable {
	    callCenterTrackersPage.nutritionGoal();
	    
	}

	@Then("^set again goals under nutrition tab$")
	public void set_again_goals_under_nutrition_tab() throws Throwable {
	  callCenterTrackersPage.nutritionChangeGoal();
	  
	}
	
	@Then("^verify Track section by providing data$")
	public void verify_Track_section_by_providing_data() throws Throwable {
	 
		//callCenterTrackersPage.verifyDate();
	   
		callCenterTrackersPage.nutritionTrack();
	   
		verify_Tracker_History_data_is_saving_or_not();
		
		
	}


	
}
