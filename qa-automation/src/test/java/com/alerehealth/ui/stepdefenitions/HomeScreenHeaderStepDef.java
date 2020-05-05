package com.alerehealth.ui.stepdefenitions;

import java.util.Map;

import org.junit.Assert;

import com.alerehealth.fwk.common.CallCenterConstants;
import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterLoginPage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterMyWorkBasketPage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterReportIssuePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeScreenHeaderStepDef {
	
	CallCenterLoginPage callCenterLoginPage = null;
	public static CallCenterHomePage callCenterHomePage;
	CallCenterReportIssuePage callCenterReportIssuePage = null;
	CallCenterMyWorkBasketPage callCenterMyWorkBasketPage = null;
			
	@Given("^Login to the CallCenter application with below valid credentials and select specific role$")
	public void login_to_the_CallCenter_application_with_below_valid_credentials_and_select_specific_role(DataTable arg1) throws Throwable {

		Map dataMap = (Map) arg1.asMap(String.class, String.class);

        String Username = (String) dataMap.get("username");
        String Password = (String) dataMap.get("password");
        String Role = (String) dataMap.get("role");
        
        callCenterLoginPage = new CallCenterLoginPage();

		callCenterHomePage = callCenterLoginPage.doLogin(Username,Password,Role);
        
	}
	
//	@Given("^Login to the CallCenter application with valid credentials and select specific role$")
//	public void login_to_the_CallCenter_application_with_valid_credentials_and_select_specific_role() throws Throwable {
//	   
//		callCenterLoginPage = new CallCenterLoginPage();
//
//		callCenterHomePage = callCenterLoginPage.doLogin("devivxa","Reset!123456","Health Coach");
//	}

	@When("^Verify the client Name with its respective Logo dispaly on header$")
	public void verify_the_client_Name_with_its_respective_Logo_dispaly_on_header() throws Throwable {
	  
//		callCenterHomePage = new CallCenterHomePage();
//		
//		callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();
		
		Assert.assertTrue("Optum Client Logo Displayed in Login page", callCenterHomePage.isClientLogoIsPresent());
		
	}

	@Then("^Verify Logged Clinician name, Phrases, Im Available to work,Get Next ,Report Issue, Logoff on Homescreen header$")
	public void verify_Logged_Clinician_name_Phrases_Im_Available_to_work_Get_Next_Report_Issue_Logoff_on_Homescreen_header() throws Throwable {
	   
		String HeaderPhrasesActualText = callCenterHomePage.getTitleOfheaderPhrases();
	    
	    Assert.assertEquals("Validating Phrases Header Text", HeaderPhrasesActualText, CallCenterConstants.HEADER_PHRASES_EXPECTEDTEXT);
	    
	    String HeaderGetNextActualText = callCenterHomePage.getTitleOfheaderGetNext();
	    
	    Assert.assertEquals("Validating GetNext Header Text", HeaderGetNextActualText, CallCenterConstants.HEADER_GETNEXT_EXPECTEDTEXT);
	    	    
	    String HeaderIsAvailableToWorkActualText = callCenterHomePage.getTitleOfheaderIsAvailableToWork();
	    
	    Assert.assertEquals("Validating AvailabletoWork Header Text", HeaderIsAvailableToWorkActualText, CallCenterConstants.HEADER_ISAVAILABLETOWORK_EXPECTEDTEXT);
	    	        
	    String HeaderReportIssueActualText = callCenterHomePage.getTitleOfheaderReportIssue();
	    
	    Assert.assertEquals("Validating ReportIssue Header Text", HeaderReportIssueActualText, CallCenterConstants.HEADER_REPORTISSUE_EXPECTEDTEXT);
	    	    	    
	    String HeaderLogoffActualText = callCenterHomePage.getTitleOfheaderLogoff();
	    
	    Assert.assertEquals("Validating logoff Header Text", HeaderLogoffActualText, CallCenterConstants.HEADER_ISLOGOUT_EXPECTEDTEXT);
	    
	    String HeaderUserNameActualText = callCenterHomePage.getTitleOfheaderUserName();
	    	    
	    Assert.assertEquals("Validating UserName Header Text", HeaderUserNameActualText, Configuration.getConfiguration().getC3UserDisplayName());
	    
	}

	@Then("^Verify I m Available to work, Get Next check boxs displying in Homescreen header$")
	public void verify_I_m_Available_to_work_Get_Next_check_boxs_displying_in_Homescreen_header() throws Throwable {
	   
		Assert.assertTrue("Validating GetNext checkbox in Login page", callCenterHomePage.isGetNextCheckBoxPresent());
		
		Assert.assertTrue("Validating AvailabletoWork checkbox in Login page", callCenterHomePage.isAvailableToWorkCheckBoxCheckBoxPresent());
		
	}

	@When("^Click on the Report Issue link$")
	public void click_on_the_Report_Issue_link() throws Throwable {
		
		callCenterReportIssuePage = callCenterHomePage.clickReportIssueLink();
		
	}

	@When("^Setting all the fields in the ReportIssue pop up$")
	public void setting_all_the_fields_in_the_ReportIssue_pop_up(DataTable arg1) throws Throwable {
		    
	    callCenterReportIssuePage.clickCategoryRadio();
	    
	    callCenterReportIssuePage.clickAssistanceNeededRadio();
	    
	    Map dataMap = (Map) arg1.asMap(String.class, String.class);

        String Optumid = (String) dataMap.get("optumid");
        String Expectingtohappen = (String) dataMap.get("expectingtohappen");
        String Exactsequence = (String) dataMap.get("exactsequence");
        String Supervisor = (String) dataMap.get("supervisor");
        String Worklocation = (String) dataMap.get("worklocation");
        
        callCenterReportIssuePage.setoptumID(Optumid);
	    
	    callCenterReportIssuePage.setexpectingtohappen(Expectingtohappen);
	    
	    callCenterReportIssuePage.setExactSequence(Exactsequence);
	    
	    callCenterReportIssuePage.setCntSupervisor(Supervisor);
	    
	    callCenterReportIssuePage.setWorkLocation(Worklocation);
	    
	    callCenterReportIssuePage.selectSameIssueOption(1);
        
	}

	@Then("^Verify report an issue is submitted successfully$")
	public void verify_report_an_issue_is_submitted_successfully() throws Throwable {
	 
		String argu=null;
	    callCenterReportIssuePage.reportIssueWindowValidation(argu);
	    
	}

	@When("^Select GetNext CheckBox and navigate to My Work Page$")
	public void select_GetNext_CheckBox_and_navigate_to_My_Work_Page() throws Throwable {

		callCenterHomePage.clickGetNextCheckBox();
		
		callCenterMyWorkBasketPage =  callCenterHomePage.openMyWorkPage();
        
        
	}

	@When("^Select Test Cases checkbox in My Work page$")
	public void select_Test_Cases_checkbox_in_My_Work_page() throws Throwable {

		callCenterMyWorkBasketPage.selectTestCasescheckbox();
		
	}

	@Then("^Select Q(\\d+)L Engagement Calls from My work basket$")
	public void select_Q_L_Engagement_Calls_from_My_work_basket(int arg1) throws Throwable {

		callCenterMyWorkBasketPage.selectMyWorkBasket("Q4L Engagement Calls");
		
	}

	@Then("^Validate the duedate is displayed to that clinician$")
	public void validate_the_duedate_is_displayed_to_that_clinician() throws Throwable {

		callCenterHomePage.duedateISDisplayed();
		
	}
		

}
