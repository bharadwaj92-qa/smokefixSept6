package com.alerehealth.ui.stepdefenitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alerehealth.ui.portal.actionplan.*;
import org.junit.Assert;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.Constants;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActionPlanStepDefinition {
	
	PortalLoginPage portalLoginPage=null;
	PortalHomePage portalhomepage=null;
	ActionPlanQuestionnaireStartingPage actionPlanQuestionnaireStartingPage=null;
	ExcelReader excelReader=null;
	ActionPlanQuestionnairePage questionnairePage=null;
	GoalsHomePage goalsHomePage=null;
	GoalDeadLineSelectionPage goalDeadLineSelectionPage=null;
	GoalSetUpPage goalSetUpPage=null;
	GoalSetupSuccessPage goalSetupSuccessPage=null;
	ActionPlanBannerPage actionPlanBannerPage=null;
	ManageGoalsPage manageGoalsPage=null;
	
	String dateToEnter = DateTimeUtils.getFutureDate("MM/dd/YYYY",10);
	
	@Given("^Login to portal using userName and password actionplan$")
		
	 public void login_to_portal_using_userName_and_password_actionplan(DataTable arg1) throws Throwable {

	        portalLoginPage = new PortalLoginPage();

	        Map dataMap = arg1.asMap(String.class, String.class);

	        String userName = (String) dataMap.get("username");
	        String password = (String) dataMap.get("password");
		
	        LoggerUtils.info("Logging into Web portal using "+ userName + "/" + password);

	        portalhomepage = portalLoginPage.doLogin(userName,password);
	}
	
	@Given("^User navigate to Action Plan Page and clicking on Get Started$")
	public void user_navigate_to_Action_Plan_Page_and_clicking_on_Get_Started() throws Throwable {
		
		portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;
		 
		actionPlanQuestionnaireStartingPage = portalhomepage.openActionPlan();

	    questionnairePage = actionPlanQuestionnaireStartingPage.startActionPlan();
	}
	
	@When("^i complete the Action plan questionnaires from ActionPlan_Tobacco and validating the Focus areas$")
	public void i_complete_the_Action_plan_questionnaires_from_ActionPlan_Tobacco_and_validating_the_Focus_areas() throws Throwable {

		excelReader = new ExcelReader("Smoke_ActionPlan_Questionaire.xlsx","ActionPlan_Tobacco");
		
		excelReader.setStartRow(1);

        goalsHomePage = questionnairePage.answerActionPlanQuestionsFromExcel(excelReader);
        
        List<String> focusAreasFromUI =  goalsHomePage.getOtherFocusAreas();

        List<String> focusAreasExpected = Arrays.asList(new String[]{"Healthier Diet","Active Living","Less Stress"});

        Assert.assertTrue("Other Focus areas after answering questionnaire are as expected",focusAreasExpected.containsAll(focusAreasFromUI));

	}

	@When("^Navigating to GoalDeadLine page and Entering to the GoalSetup Page$")
	public void navigating_to_GoalDeadLine_page_and_Entering_to_the_GoalSetup_Page() throws Throwable {

		goalDeadLineSelectionPage = goalsHomePage.clickChooseCurrentFocus();

        goalDeadLineSelectionPage.setGoalAchievementDate(dateToEnter);
        
        goalSetUpPage = goalDeadLineSelectionPage.clickContinueButton();
      
	}
	
	@When("^Setting all the fields in the GoalSetup page by using below values$")
	public void setting_all_the_fields_in_the_GoalSetup_page_by_using_below_values(DataTable arg1) throws Throwable {

		 Map dataMap = (Map) arg1.asMap(String.class, String.class);

	        String Communication = (String) dataMap.get("communication");
	        String TimeZone = (String) dataMap.get("timezone");
	        String Email = (String) dataMap.get("email");
	        String PrimaryPhone = (String) dataMap.get("primaryphone");
	        String PrimaryPhoneType = (String) dataMap.get("primaryphonetype");
	        String ToCallOnPrimaryPhone = (String) dataMap.get("tocallon");
	        String WhenToCall = (String) dataMap.get("whentocall");
	        String PreferredLanguage = (String) dataMap.get("preferredlanguage");
	        String ToQuitInNext30Days = (String) dataMap.get("toquitinnext30days");
	        String ECigras = (String) dataMap.get("eCigras");
	        String AboutThisProgram = (String) dataMap.get("aboutthisprogram");
	        
	        goalSetUpPage.selectWorkBookCommunication(Communication);

	        goalSetUpPage.selectTimeZone(TimeZone);

	        goalSetUpPage.setEmail(Email);

	        goalSetUpPage.setPrimaryPhone(PrimaryPhone);

	        goalSetUpPage.setPrimaryPhoneType(PrimaryPhoneType);

	        goalSetUpPage.selectPreferedDayToCallOnPrimaryPhone(ToCallOnPrimaryPhone);

	        goalSetUpPage.selectWhenToCall(WhenToCall);

	        goalSetUpPage.selectPreferredLanguage(PreferredLanguage);

	        goalSetUpPage.areYouPlanningToQuitInNext30Days(ToQuitInNext30Days);

	        //String dateToEnter = DateTimeUtils.getFutureDate("MM/DD/YYYY",10);

	        goalSetUpPage.setDate(dateToEnter);

	        goalSetUpPage.doYouUseECigras(ECigras);

	        goalSetUpPage.howDidYouListenAboutThisProgram(AboutThisProgram);
	        
	        List<String> conditions = new ArrayList<String>();
	        conditions.add("None");
	        goalSetUpPage.selectHealthConditions(conditions);

	        goalSetUpPage.doULikeToReceiveText2QuitMessages("No");
	        
	}

	@When("^Navigating to GoalSetupSuccess, Validating Ation Plan banner and Handling GoalReminderPopup$")
	public void navigating_to_GoalSetupSuccess_Validating_Ation_Plan_banner_and_Handling_GoalReminderPopup() throws Throwable {

		goalSetupSuccessPage = goalSetUpPage.clickContinueButton();
		
		actionPlanBannerPage = goalSetupSuccessPage.clickonGoToActionPlan();
		
		actionPlanBannerPage.closeGoalReminderPopup();

	}

	@Then("^Navigating to Manage Goals Page and Validating the Added Goal$")
	public void navigating_to_Manage_Goals_Page_and_Validating_the_Added_Goal() throws Throwable {
		
		 manageGoalsPage = portalhomepage.navigateToManageGoals();
		 
		 List<String> activePlans = manageGoalsPage.getActivePlans();
		 
		 Assert.assertTrue("QFL is added as active goal", activePlans.contains(Constants.MANAGE_GOALS_QFL_HEADING));
		 
	}

	@Then("^Validating the Cancel Goal in Manage Goals$")
	public void validating_the_Cancel_Goal_in_Manage_Goals() throws Throwable {

	    manageGoalsPage.cancelGoal(Constants.MANAGE_GOALS_QFL_HEADING);
	     
	}

	@Given("^User navigate to Action Plan Page,TODO and clicking on Get Started$")
	public void user_navigate_to_Action_Plan_Page_TODO_and_clicking_on_Get_Started() throws Throwable {

		portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;

		actionPlanQuestionnaireStartingPage = portalhomepage.openActionPlan();

		questionnairePage = actionPlanQuestionnaireStartingPage.startActionPlan();
	}

	@When("^i complete the Action plan questionnaires from ActionPlan TODO Tobacco and validating the Focus areas$")
	public void i_complete_the_Action_plan_questionnaires_from_ActionPlan_TODO_Tobacco_and_validating_the_Focus_areas() throws Throwable {


		excelReader = new ExcelReader("Smoke_ActionPlan_Questionaire.xlsx","ActionPlan_Tobacco");

		excelReader.setStartRow(1);

		goalsHomePage = questionnairePage.answerActionPlanQuestionsFromExcel(excelReader);

		List<String> focusAreasFromUI =  goalsHomePage.getOtherFocusAreas();

		List<String> focusAreasExpected = Arrays.asList(new String[]{"Healthier Diet","Active Living","Less Stress"});

		Assert.assertTrue("Other Focus areas after answering questionnaire are as expected",focusAreasExpected.containsAll(focusAreasFromUI));

	}

	@When("^Navigating to GoalSetupSuccess, Validating TODO Action Plan banner and Handling GoalReminderPopup$")
	public void Navigating_to_GoalSetupSuccess_Validating_TODO_Action_Plan_banner_and_Handling_GoalReminderPopup() throws Throwable {

		actionPlanBannerPage = goalSetupSuccessPage.clickonGoToActionPlan();

		actionPlanBannerPage.closeGoalReminderPopup();



	}

	@When("^Navigating to GoalDeadLine page and Add a coach to the Goal$")
	public void navigating_to_GoalDeadLine_page_and_Add_a_coach_to_the_Goal() throws Throwable {

		ActionPlanAddACoachPage actionPlanAddACoachPage = goalsHomePage.clickOtherFocusArea("Healthier Diet");

		ActionPlanSetYourGoal actionPlanSetYourGoal = actionPlanAddACoachPage.clickAddACoachButton();

		actionPlanSetYourGoal.selectGoal("Healthy Eating Plan");

		HealthyEatingPlanPage healthyEatingPlanPage = actionPlanSetYourGoal.proceedToHealthyEatingPlan();

		healthyEatingPlanPage.selectMealPlan("Standard");

		healthyEatingPlanPage.clickContinueButton();

		healthyEatingPlanPage.clickContinueButton();

		goalSetUpPage = healthyEatingPlanPage.clickOnContinueButton();



	}


	@Then("^Validating the download certificate button in Manage Goals page$")
	public void validating_the_download_certificate_button_in_Manage_Goals_page() throws Throwable {


		Assert.assertTrue("Validating Download certificate link is present", manageGoalsPage.isDownloadCertificateLinkIsPresent());

	}


	@When("^Setting all the fields in the GoalSetup page after Adding a Coach by using below values$")
	public void setting_all_the_fields_in_the_GoalSetup_page_after_Adding_a_Coach_by_using_below_values(DataTable arg1) throws Throwable {



		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String Communication = (String) dataMap.get("communication");
		String TimeZone = (String) dataMap.get("timezone");
		String Email = (String) dataMap.get("email");
		String PrimaryPhone = (String) dataMap.get("primaryphone");
		String PrimaryPhoneType = (String) dataMap.get("primaryphonetype");
		String ToCallOnPrimaryPhone = (String) dataMap.get("tocallon");
		String WhenToCall = (String) dataMap.get("whentocall");
		String PreferredLanguage = (String) dataMap.get("preferredlanguage");

		goalSetUpPage.selectWorkBookCommunication(Communication);

		goalSetUpPage.selectTimeZone(TimeZone);

		goalSetUpPage.setEmail(Email);

		goalSetUpPage.setPrimaryPhone(PrimaryPhone);

		goalSetUpPage.setPrimaryPhoneType(PrimaryPhoneType);

		goalSetUpPage.selectPreferedDayToCallOnPrimaryPhone(ToCallOnPrimaryPhone);

		goalSetUpPage.selectWhenToCall(WhenToCall);

		goalSetUpPage.selectPreferredLanguage(PreferredLanguage);

		List<String> conditions = new ArrayList<String>();
		conditions.add("None");


		goalSetupSuccessPage =goalSetUpPage.clickContinueButton();
	}

	@Then("^Navigating to Manage Goals Page and Validating the Health Diet Goal Added$")
	public void navigating_to_Manage_Goals_Page_and_Validating_the_Health_Diet_Goal_Added() throws Throwable {

		CongratulationOnGoalCompletionPage congratulationOnGoalCompletionPage = actionPlanBannerPage.markCurrentGoalAsCompleteFromHeroBanner();

		Assert.assertTrue("Download certificate button is present on Congratulations screen",congratulationOnGoalCompletionPage.isDownloadCertificateButtonPresent());

		manageGoalsPage = congratulationOnGoalCompletionPage.navigateToManageGoals();

	}

	@Then("^Complete the week1 TODO, mark as complete and validate the Milestone Status$")
	public void Complete_the_week1_TODO_mark_as_complete_and_validate_the_Milestone_Status() throws Throwable {


		actionPlanBannerPage.waitForElementToBeDisplayed();

		actionPlanBannerPage.markTasksAsComplete(1);

		actionPlanBannerPage.closeGoalReminderPopup();

		Assert.assertTrue("Validating Milestone is updated", actionPlanBannerPage.isMileStoneComplete(1));

	}

}
