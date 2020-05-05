package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.common.CallCenterConstants;

import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterEducationAndGoalsTab;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterGapHistoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GapHistorySmokeTC01StepDef {
	
	
	CallCenterParticipantHomePage callCenterParticipantHomePage;
	
	CallCenterEducationAndGoalsTab callCenterEducationAndGoalsTab = null;
	CallCenterGapHistoryPage callCenterGapHistoryPage = null;

	List<String> partcipantGapCol ;
	
	String careGapInEducation;
	String careGapInGapHistory;
	
	

	@When("^calculate the caregaps in Education Goals$")
	public void calculate_the_caregaps_in_Education_Goals() throws Throwable {
	   
		callCenterParticipantHomePage = new CallCenterParticipantHomePage();
		
	
		callCenterEducationAndGoalsTab = callCenterParticipantHomePage.selectEducationAndGoals();
		
		 Assert.assertTrue("Callcenter EducationAndGoals page displayed",callCenterEducationAndGoalsTab.isDisplayed());
		 
		 careGapInEducation = callCenterEducationAndGoalsTab.getCaregapsCountInEducationGoals();
		 
		
	}

	

	@When("^Click on Gaphistory on three sixty tab to verify the Participant Gaps column Names$")
	public void click_on_Gaphistory_on_three_sixty_tab_to_verify_the_Participant_Gaps_column_Names() throws Throwable {

		callCenterGapHistoryPage = callCenterEducationAndGoalsTab.selectGapHistoryFromEducationPage();
	        
	    Assert.assertTrue("Callcenter Gap history page displayed",callCenterGapHistoryPage.isDisplayed());
	      
	    String valueFromGapHistoryHeaderUI = callCenterGapHistoryPage.getTitleOfGapHistoryPage();
	        
	    System.out.println("Title of GapHistory Page" + valueFromGapHistoryHeaderUI);
			
	    Assert.assertEquals("Validating Participants Gap Text in GapHistory Page", valueFromGapHistoryHeaderUI, CallCenterConstants.GAPHISTORY_PAGE_PARTICIPANTGAPS_EXPECTEDTEXT);
	      
	    careGapInGapHistory = callCenterGapHistoryPage.getGapCount();
	      
	    Assert.assertEquals("Both are same", careGapInEducation,careGapInGapHistory);
        
        partcipantGapCol = callCenterGapHistoryPage.getParticipantGapsColumnNames();
		
      	Assert.assertTrue(partcipantGapCol.containsAll(Arrays.asList("&nbsp;", "GapID", "Gap Name", "Value", "Started", "Last Calcualted")));
	}

	

	@Then("^pagination icons and related text should be displayed$")
	public void pagination_icons_and_related_text_should_be_displayed() throws Throwable {
		
		Assert.assertTrue("First Page Arrow Displayed",callCenterGapHistoryPage.isPaginationIconDisplayed("First Page"));
		Assert.assertTrue("Previous Page Arrow Displayed",callCenterGapHistoryPage.isPaginationIconDisplayed("Previous Page"));
		Assert.assertTrue("Next Page Arrow Displayed",callCenterGapHistoryPage.isPaginationIconDisplayed("Next Page"));
		Assert.assertTrue("Last Page Arrow Displayed",callCenterGapHistoryPage.isPaginationIconDisplayed("Last Page"));
		//Assert.assertTrue("Text Displayed",callCenterGapHistoryPage.textBesideDrpDwn("Rows"));
		Assert.assertTrue("Dropdown and Related Text is displayed",callCenterGapHistoryPage.isPaginationDropDownDisplayed());
		Assert.assertTrue("Dropdown and Related Text is displayed",callCenterGapHistoryPage.validateDisplayingRecordsTxt());
	}

	@Then("^Verify the collapse and Expand mode in ParticipantGaps section$")
	public void verify_the_collapse_and_Expand_mode_in_ParticipantGaps_section() throws Throwable {

	    Assert.assertTrue("It is in Expanded mode", callCenterGapHistoryPage.isLabelExpand("Participant Gaps"));
	    callCenterGapHistoryPage.expandOrCollapseSection("Participant Gaps", "collapse");
	    Assert.assertTrue("It is in collapsed mode", callCenterGapHistoryPage.isLabelCollapse("Participant Gaps"));
	    callCenterGapHistoryPage.expandOrCollapseSection("Participant Gaps", "expand");
	}

	@Then("^Clicking on Refresh Button in Participant Gaps section should navigate to Gap History Page$")
	public void clicking_on_Refresh_Button_in_Participant_Gaps_section_should_navigate_to_Gap_History_Page() throws Throwable {
	
		callCenterGapHistoryPage = callCenterGapHistoryPage.clickRefreshButton();
		 Assert.assertTrue("Callcenter Gap history page displayed",callCenterGapHistoryPage.isDisplayed());
	}



}
