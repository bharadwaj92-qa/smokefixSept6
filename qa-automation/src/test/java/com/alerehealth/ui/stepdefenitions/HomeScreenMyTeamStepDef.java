package com.alerehealth.ui.stepdefenitions;

import org.junit.Assert;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterMyTeamPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class HomeScreenMyTeamStepDef {
	
	public static CallCenterHomePage callCenterHomePage;
	CallCenterMyTeamPage callCenterMyTeamPage = null;
	
	public String defaultValueOfTeamFromUI;
	public String defaultValueOfUserFromUI;
	public String defaultValueOfTaskDateFromUI;
	public String defaultValueOfInteractionType;
    
	public boolean showAllStatesCheckBoxStatusFromUI;
	public boolean eveningCallsCheckBoxStatusFromUI;
	public boolean rescheduledCallsOnlyCheckBoxStatusFromUI;
	public boolean weekendCallsCheckBoxStatusFromUI;
	
	@When("^User navigates to My team page and verify My team tab loaded successfully$")
	public void user_navigates_to_My_team_page_and_verify_My_team_tab_loaded_successfully() throws Throwable {
		
		callCenterHomePage = HomeScreenHeaderStepDef.callCenterHomePage;
		
		callCenterMyTeamPage = callCenterHomePage.openMyTeamPage();
		
	}

	@When("^Verify my team section have drop downs Client,Interaction,Taskdate,User,Team and each drop down has its default value$")
	public void verify_my_team_section_have_drop_downs_Client_Interaction_Taskdate_User_Team_and_each_drop_down_has_its_default_value() throws Throwable {

		defaultValueOfTeamFromUI = callCenterMyTeamPage.getTeam();
		defaultValueOfUserFromUI = callCenterMyTeamPage.getUser();
		defaultValueOfTaskDateFromUI = callCenterMyTeamPage.getTaskDate();
		defaultValueOfInteractionType = callCenterMyTeamPage.getInteractionType();
		
        System.out.println("team  "+ defaultValueOfTeamFromUI );
        System.out.println("user "+ defaultValueOfUserFromUI );
        System.out.println("Task date "+ defaultValueOfTaskDateFromUI);
        System.out.println("Interaction type "+ defaultValueOfInteractionType);

    	showAllStatesCheckBoxStatusFromUI = callCenterMyTeamPage.isShowAllStatesCheckBoxChecked();
    	eveningCallsCheckBoxStatusFromUI = callCenterMyTeamPage.isEveningCallsCheckBoxChecked();
    	rescheduledCallsOnlyCheckBoxStatusFromUI = callCenterMyTeamPage.isRescheduledCallsOnlyCheckBoxChecked();
    	weekendCallsCheckBoxStatusFromUI = callCenterMyTeamPage.isWeekendCallsCheckBoxChecked();
    	
        Assert.assertFalse("Show all states checkbox is unchecked",showAllStatesCheckBoxStatusFromUI);
        Assert.assertFalse("Evening call  checkbox is unchecked",eveningCallsCheckBoxStatusFromUI);
        Assert.assertFalse("Rescheduled calls checkbox is unchecked",rescheduledCallsOnlyCheckBoxStatusFromUI);
        Assert.assertFalse("Weekend calls checkbox is unchecked",weekendCallsCheckBoxStatusFromUI);

        callCenterMyTeamPage.selectTeam("AlereQA");
        callCenterMyTeamPage.selectTaskDate("Next 14 days");
        
	}

	@Then("^Verify the list values and check boxes are reset to default values$")
	public void verify_the_list_values_and_check_boxes_are_reset_to_default_values() throws Throwable {

		callCenterMyTeamPage.clickResetButton();
   
        String postResetValueOfTeamFromUI = callCenterMyTeamPage.getTeam();
        String postResetValueOfUserFromUI = callCenterMyTeamPage.getUser();
        String postResetValueOfTaskDateFromUI = callCenterMyTeamPage.getTaskDate();
        String postResetValueOfInteractionType = callCenterMyTeamPage.getInteractionType();

        boolean postResetshowAllStatesCheckBoxStatusFromUI = callCenterMyTeamPage.isShowAllStatesCheckBoxChecked();
        boolean postReseteveningCallsCheckBoxStatusFromUI = callCenterMyTeamPage.isEveningCallsCheckBoxChecked();
        boolean postResetrescheduledCallsOnlyCheckBoxStatusFromUI = callCenterMyTeamPage.isRescheduledCallsOnlyCheckBoxChecked();
        boolean postResetweekendCallsCheckBoxStatusFromUI = callCenterMyTeamPage.isWeekendCallsCheckBoxChecked();

        Assert.assertEquals("Reset changes back the value of Team", defaultValueOfTeamFromUI,postResetValueOfTeamFromUI);
        Assert.assertEquals("Reset changes back the value of User", defaultValueOfUserFromUI,postResetValueOfUserFromUI);
        Assert.assertEquals("Reset changes back the value of Task date", defaultValueOfTaskDateFromUI,postResetValueOfTaskDateFromUI);
        Assert.assertEquals("Reset changes back the value of Interaction type", defaultValueOfInteractionType,postResetValueOfInteractionType);

        Assert.assertEquals("Reset changes back the value of ShowAll states checkbox", showAllStatesCheckBoxStatusFromUI,postResetshowAllStatesCheckBoxStatusFromUI);
        Assert.assertEquals("Reset changes back the value of Evening calls", eveningCallsCheckBoxStatusFromUI,postReseteveningCallsCheckBoxStatusFromUI);
        Assert.assertEquals("Reset changes back the value of Rescheduled calls ", rescheduledCallsOnlyCheckBoxStatusFromUI,postResetrescheduledCallsOnlyCheckBoxStatusFromUI);
        Assert.assertEquals("Reset changes back the value of Weekend calls", weekendCallsCheckBoxStatusFromUI,postResetweekendCallsCheckBoxStatusFromUI);
        
	}
	
}
