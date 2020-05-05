package com.alerehealth.ui.stepdefenitions;

import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.common.CallCenterConstants;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterClientPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Client360TabStepDef {

	public static CallCenterHomePage callCenterHomePage;
	CallCenterOthersHomeMenuPage callCenterOthersHomeMenuPage = null;
	CallCenterParticipantHomePage callCenterParticipantHomePage=null;
	CallCenterClientPage callCenterClientPage = null;
	
	@When("^Navigating to Others tab and search for the participant$")
	public void navigating_to_Others_tab_and_search_for_the_participant() throws Throwable {     
        
		callCenterHomePage = new CallCenterHomePage();
		
		callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();
        
        Assert.assertTrue("Validating Others Home Page is available", callCenterOthersHomeMenuPage.isDisplayed());
        
        callCenterParticipantHomePage = callCenterOthersHomeMenuPage.searchParticipant("P-355267");
        
	}

	@When("^Verify the Client tab is displaying on (\\d+) View and navigating to client Tab$")
	public void verify_the_Client_tab_is_displaying_on_View_and_navigating_to_client_Tab(int arg1) throws Throwable {
        
		callCenterClientPage = callCenterParticipantHomePage.selectClientTab();      
        
        callCenterClientPage.isDisplayed();
        
	}

	@Then("^Verify whether user is able to see the Insurence detail section$")
	public void verify_whether_user_is_able_to_see_the_Insurence_detail_section() throws Throwable {

		String valueFromClientHeaderUI = callCenterClientPage.getTitleOfClientPage();
        
        System.out.println(valueFromClientHeaderUI);
		
        Assert.assertEquals("Validating Insurance Details Text in Client Page", valueFromClientHeaderUI, CallCenterConstants.CLIENT_PAGE_INSURANCEDETAILS_EXPECTEDTEXT);
        
        
	}

	@Then("^Verify Whether Client name and Client ID are displayed in the Insurence details section$")
	public void verify_Whether_Client_name_and_Client_ID_are_displayed_in_the_Insurence_details_section() throws Throwable {

		callCenterClientPage.isexpandmodeInsuranceDetailsPresent();
        
        String valueFromInsuranceSectionClientIDUI = callCenterClientPage.clientInsurancedetailssection("Client ID:");
        
        System.out.println(valueFromInsuranceSectionClientIDUI);
        
        Assert.assertEquals("Validating Client ID is displaying at Insurance Section", valueFromInsuranceSectionClientIDUI, CallCenterConstants.CLIENT_PAGE_INSURANCESECTION_CLIENT_ID_EXPECTEDTEXT);
        
        String valueFromInsuranceSectionClientNameUI = callCenterClientPage.clientInsurancedetailssection("Client Name:");
        
        System.out.println(valueFromInsuranceSectionClientNameUI);
        
        Assert.assertEquals("Validating Client ID is displaying at Insurance Section", valueFromInsuranceSectionClientNameUI, CallCenterConstants.CLIENT_PAGE_INSURANCESECTION_CLIENT_NAME_EXPECTEDTEXT);
        
	}

	@Then("^Verify Whether Client name and Client ID are displayed in the Insurence detail edit section$")
	public void verify_Whether_Client_name_and_Client_ID_are_displayed_in_the_Insurence_detail_edit_section() throws Throwable {
	
		callCenterClientPage.expandOrCollapseSection("Insurance Details Edit","expand");
        
        Assert.assertTrue("Validating Insurence detail section with Expand and collapse option", callCenterClientPage.isclientLabelExpand("Insurance Details Edit"));
        
        List<String> clientInsuranceDetailsEditSectionUI = callCenterClientPage.getTitlesOfClientDetailsEditSection();
        
        System.out.println(clientInsuranceDetailsEditSectionUI);
        
        String CLIENT_PAGE_INSURANCE_DETAILS_EDIT_SECTION_EXPECTEDTEXT = "[Client ID, Client Name]";
        
        boolean isStringExists = clientInsuranceDetailsEditSectionUI.contains(CLIENT_PAGE_INSURANCE_DETAILS_EDIT_SECTION_EXPECTEDTEXT);
        
	}

}
