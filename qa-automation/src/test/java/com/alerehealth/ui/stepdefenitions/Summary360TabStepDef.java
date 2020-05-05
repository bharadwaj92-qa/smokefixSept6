package com.alerehealth.ui.stepdefenitions;

import org.junit.Assert;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterDeviceMonitoringPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterSummaryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Summary360TabStepDef {

	public static CallCenterHomePage callCenterHomePage;
	CallCenterOthersHomeMenuPage callCenterOthersHomeMenuPage = null;
	CallCenterSummaryPage callCenterSummaryPage = null;
	CallCenterParticipantHomePage callCenterParticipantHomePage=null;
	
	@When("^User navigates to other page and Search for the participant$")
	public void user_navigates_to_other_page_and_Search_for_the_participant() throws Throwable {

		callCenterHomePage = new CallCenterHomePage();
		
		callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();

		Assert.assertTrue("Validating Others Home Page is available", callCenterOthersHomeMenuPage.isDisplayed());

		callCenterParticipantHomePage = callCenterOthersHomeMenuPage.searchParticipant("P-355267");
		
	}

	@Then("^Validating primary provider details, External referrals,internal referrals of the participant in Summary page$")
	public void validating_primary_provider_details_External_referrals_internal_referrals_of_the_participant_in_Summary_page() throws Throwable {
		callCenterSummaryPage = callCenterParticipantHomePage.selectSummaryTab("Summary");
		
		callCenterSummaryPage.summaryDashboard("Primary Provider");
		
		callCenterSummaryPage.summaryDashboard("Internal Referrals (All)");
		
		callCenterSummaryPage.summaryDashboard("External Referrals (All)");
		
	}

}
