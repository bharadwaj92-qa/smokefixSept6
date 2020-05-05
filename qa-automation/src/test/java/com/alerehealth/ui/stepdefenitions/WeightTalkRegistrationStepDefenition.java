package com.alerehealth.ui.stepdefenitions;

import java.util.Map;

import com.alerehealth.fwk.common.HelperUtils;
import org.junit.Assert;

import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanBannerPage;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnaireStartingPage;
import com.alerehealth.ui.portal.actionplan.ActionPlanSetYourGoal;
import com.alerehealth.ui.portal.actionplan.GoalDeadLineSelectionPage;
import com.alerehealth.ui.portal.actionplan.GoalSetUpPage;
import com.alerehealth.ui.portal.actionplan.GoalSetupSuccessPage;
import com.alerehealth.ui.portal.actionplan.ManageGoalsPage;
import com.alerehealth.ui.portal.coaching.WellnessPage;
import com.alerehealth.ui.portal.common.pages.AboutYouSignUpPage;
import com.alerehealth.ui.portal.common.pages.MarketingPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;
import com.alerehealth.ui.portal.common.pages.TOUPage;
import com.alerehealth.ui.portal.registration.CreateLoginIDPage;
import com.alerehealth.ui.portal.registration.ProgramEligibility;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("LossyEncoding")
public class WeightTalkRegistrationStepDefenition {
	
	MarketingPage marketingPage = null;
	SignUpPage signupPage = null;
	AboutYouSignUpPage aboutYouSignupPage = null;
	ProgramEligibility programEligibility = null;
	CreateLoginIDPage createLoginIDPage = null;
	TOUPage touPage = null;
	PortalHomePage portalHomePage = null;
	ActionPlanQuestionnaireStartingPage actionPlanQuestionnaireStartingPage = null;
	ActionPlanQuestionnairePage actionPlanQuestionnairePage = null;
	ExcelReader excelReader = null;
	ActionPlanSetYourGoal actionPlanSetYourGoal = null;
	GoalDeadLineSelectionPage goalDeadLineSelectionPage = null;
	GoalSetUpPage goalSetupPage = null;
	GoalSetupSuccessPage goalSetupSuccessPage = null;
	ActionPlanBannerPage actionPlanBannerPage = null;
	ManageGoalsPage manageGoalsPage = null;
	WellnessPage wellnessPage = null;
	
	@Given("^User Navigate to KLGates Client URL$")
	public void navigate_to_KLGates_Client_URL() throws Throwable {
	    
		 marketingPage = new MarketingPage(); 
	}

	@When("^Register a user with KeyCode option$")
	public void register_a_user_with_KeyCode_option() throws Throwable {
	    
		signupPage = marketingPage.clickGetStartedButton();
		
		signupPage.selectRole("with a Keycode");
		
		signupPage.clickContinueButton();
		
		aboutYouSignupPage = signupPage.fillKeyCodeForm("KLGates");
	}

	@And("^Fill in all the details in Eligibility Form and Create your login Page$")
	public void fill_in_all_the_details_in_Eligibility_Form_and_Create_your_login_Page(DataTable arg1) throws Throwable {
		
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String firstName = (String) dataMap.get("lastName");
		String lastName = (String) dataMap.get("lastName");
		String gender = (String) dataMap.get("gender");
		String dob = (String) dataMap.get("dob");
		String isPregnant = (String) dataMap.get("isPregnant");
		String isUnderDialysis = (String) dataMap.get("isUnderDialysis");
		String diabetesType = (String) dataMap.get("diabetesType");
		String weightlossSurgeryDone = (String) dataMap.get("weightlossSurgeryDone");
		String weightlossSurgeryin12Months = (String) dataMap.get("weightlossSurgeryin12Months");
		String currentHeightFeet = (String) dataMap.get("currentHeightFeet");
		String currentHeghtInches = (String) dataMap.get("currentHeghtInches");
		String currentWeight = (String) dataMap.get("currentWeight");
		//String loginID = (String) dataMap.get("loginID");
		String password = (String) dataMap.get("password");
		String confirmPassword = (String) dataMap.get("confirmPassword");
		String securityQuestion1 = (String) dataMap.get("securityQuestion1");
		String answer1 = (String) dataMap.get("answer1");
		String hint1 = (String) dataMap.get("hint1");
		String securityQuestion2 = (String) dataMap.get("securityQuestion2");
		String answer2 = (String) dataMap.get("answer2");
		String hint2 = (String) dataMap.get("hint2");
		String securityQuestion3 = (String) dataMap.get("securityQuestion3");
		String answer3 = (String) dataMap.get("answer3");
		String hint3 = (String) dataMap.get("hint3");	
		
		programEligibility = aboutYouSignupPage.fillAboutYouFormForKeyCodeNew(firstName+HelperUtils.getRandomNumber(9), lastName, gender, dob);
		
		programEligibility.selectPregnancy(isPregnant);
		
		programEligibility.selectDialysis(isUnderDialysis);
		
		programEligibility.selectDiabetesType(diabetesType);
		
		programEligibility.selectWeightLossSurgery(weightlossSurgeryDone);
		
		programEligibility.WeightLossSurgeryInLast12Months(weightlossSurgeryin12Months);
		
		programEligibility.enterHeightFeet(currentHeightFeet);
		
		programEligibility.enterHeightInches(currentHeghtInches);
		
		programEligibility.enterWeight(currentWeight);
		
		createLoginIDPage = programEligibility.clickContinueButton();
				
		touPage = createLoginIDPage.fillLoginIDForm("test"+ HelperUtils.getRandomNumber(9)+"@gn.com", password, confirmPassword, securityQuestion1, answer1, hint1, securityQuestion2, answer2, hint2, securityQuestion3, answer3, hint3);
		
		portalHomePage = touPage.acceptTerms();

		
	}

	@Then("^User should be taken to Portal Home page$")
	public void user_should_be_taken_to_Portal_Home_page() throws Throwable {
	    
		Assert.assertEquals("Let's finish up your Weight Talk enrollment!", portalHomePage.getHeroBannerTitle());
		
		Assert.assertTrue("Checking for Weight Talk Content Card",portalHomePage.isHealthRiskQuestionnaireContentCardDisplayinHomePage("Weight Talk"));
	}

	@When("^User clicks on Action plan's Active goal and completes mini assessment and navigates to goal set up screen$")
	public void user_clicks_on_Action_plan_s_Active_goal_and_completes_mini_assessment_and_navigates_to_goal_set_up_screen(DataTable arg1) throws Throwable {
	  
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String communicationMode = (String) dataMap.get("communicationMode");
		String addressText = (String) dataMap.get("addressText");
		String cityName = (String) dataMap.get("cityName");
		String state = (String) dataMap.get("state");
		String zip = (String) dataMap.get("zip");
		String country = (String) dataMap.get("country");
		String timezone = (String) dataMap.get("timezone");
		String primaryPhoneNumberToEnter = (String) dataMap.get("primaryPhoneNumberToEnter");
		String primaryPhoneTypeToSelect = (String) dataMap.get("primaryPhoneTypeToSelect");
		String preferredDay = (String) dataMap.get("preferredDay");
		String callOption = (String) dataMap.get("callOption");
		String preferredTime = (String) dataMap.get("preferredTime");
		String language = (String) dataMap.get("language");


		actionPlanQuestionnaireStartingPage = portalHomePage.openActionPlan();
		
		actionPlanQuestionnairePage = actionPlanQuestionnaireStartingPage.startActionPlan();
		
		excelReader = new ExcelReader("Smoke_ActionPlan_Questionaire.xlsx","ActionPlan_WeightTalkFemale");
		
		excelReader.setStartRow(1);

		actionPlanSetYourGoal = actionPlanQuestionnairePage.answerActionPlanQuestionsFromExcelWeightTalk(excelReader);

		actionPlanSetYourGoal.selectGoal("Lose Weight");

		goalDeadLineSelectionPage = actionPlanSetYourGoal.clickContinueButton();
        
        goalSetupPage =  goalDeadLineSelectionPage.clickContinueButton();
        
        goalSetupPage.selectWorkBookCommunication(communicationMode);
        
        goalSetupPage.enterAddress(addressText);
        
        goalSetupPage.enterCity(cityName);
        
        goalSetupPage.selectState(state);
        
        goalSetupPage.enterZipCode(zip);
        
        goalSetupPage.selectCountry(country);
        
        goalSetupPage.selectTimeZone(timezone);
        
        goalSetupPage.setPrimaryPhone(primaryPhoneNumberToEnter);
        
        goalSetupPage.setPrimaryPhoneType(primaryPhoneTypeToSelect);
        
        goalSetupPage.selectPreferedDayToCallOnPrimaryPhone(preferredDay);
        
        goalSetupPage.selectWhenToCall(callOption);
        
        goalSetupPage.selectPreferedTimeToCallOnPrimaryPhone(preferredTime);
        
        goalSetupPage.selectPreferredLanguage(language);
        
        goalSetupSuccessPage = goalSetupPage.clickContinueButton();
		
	}

	@And("^Complete and validate to-dos$")
	public void complete_and_validate_to_dos() throws Throwable {
		
		actionPlanBannerPage = goalSetupSuccessPage.clickonGoToActionPlan();

		actionPlanBannerPage.closeGoalReminderPopup();

		actionPlanBannerPage.waitForElementToBeDisplayed();

		actionPlanBannerPage.markTasksAsComplete(1);

		actionPlanBannerPage.waitForElementToBeDisplayed();

		actionPlanBannerPage.closeGoalReminderPopup();
		
		Assert.assertTrue("Validating that milestone is marked as complete",actionPlanBannerPage.isMileStoneComplete(1));

	}

	@Then("^Validate Add goal is not present in Manage Goals page and 11 calls are present in wellness page$")
	public void validate_Add_goal_is_not_present_in_Manage_Goals_page(DataTable arg1) throws Throwable {
		
		  Map dataMap = (Map) arg1.asMap(String.class, String.class);

		  String coachingCalls = (String) dataMap.get("coachingCalls");
		
		  manageGoalsPage = actionPlanBannerPage.navigateToManageGoals();//;.clickManageGoals();
		  
		  Assert.assertFalse("Check whether add goal button is present on page",manageGoalsPage.isAddGoalsOptionPresent());
		  
		  manageGoalsPage.waitForElementToBeDisplayed();
		  
		  WellnessPage wellnessPage = manageGoalsPage.openCoachingWellness();
		  
		  
		  Assert.assertEquals("Validating 11 Coaching Calls",coachingCalls, wellnessPage.maxCoachingCallnumber());
	    
	}

	@When("^Fill in all the details in Eligibility Form as a Pregnant Patient$")
	public void fill_in_all_the_details_in_Eligibility_Form_as_a_Pregnant_Patient(DataTable arg1) throws Throwable {
	 
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String firstName = (String) dataMap.get("lastName");
		String lastName = (String) dataMap.get("lastName");
		String gender = (String) dataMap.get("gender");
		String dob = (String) dataMap.get("dob");
		String isPregnant = (String) dataMap.get("isPregnant");
		String isUnderDialysis = (String) dataMap.get("isUnderDialysis");
		String diabetesType = (String) dataMap.get("diabetesType");
		String weightlossSurgeryDone = (String) dataMap.get("weightlossSurgeryDone");
		String weightlossSurgeryin12Months = (String) dataMap.get("weightlossSurgeryin12Months");
		String currentHeightFeet = (String) dataMap.get("currentHeightFeet");
		String currentHeghtInches = (String) dataMap.get("currentHeghtInches");
		String currentWeight = (String) dataMap.get("currentWeight");
		
		programEligibility = aboutYouSignupPage.fillAboutYouFormForKeyCodeNew(
				firstName + HelperUtils.getRandomNumber(9), lastName, gender, dob);

		programEligibility.selectPregnancy(isPregnant);

		programEligibility.selectDialysis(isUnderDialysis);

		programEligibility.selectDiabetesType(diabetesType);

		programEligibility.selectWeightLossSurgery(weightlossSurgeryDone);

		programEligibility.WeightLossSurgeryInLast12Months(weightlossSurgeryin12Months);

		programEligibility.enterHeightFeet(currentHeightFeet);

		programEligibility.enterHeightInches(currentHeghtInches);

		programEligibility.enterWeight(currentWeight);

		programEligibility.clickOnContinueButton();

		programEligibility.clickBackButtonOnErrorPage();

		programEligibility.clickOnContinueButton();
		
	}

	@Then("^Pregnancy Ineligibility Error Message should be displayed$")
	public void pregnancy_Ineligibility_Error_Message_should_be_displayed(DataTable arg1) throws Throwable {
	    
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String pregnancyErrorMessage = (String) dataMap.get("pregnancyErrorMessage");
		
		Assert.assertEquals(pregnancyErrorMessage, programEligibility.getErrorMessageText());
		
		programEligibility.clickCloseButtonOnErrorMessage();
		
	}

	@When("^User Fill in all the details in Eligibility Form as a Dialysis Patient$")
	public void user_Fill_in_all_the_details_in_Eligibility_Form_as_a_Dialysis_Patient(DataTable arg1) throws Throwable {
	  
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String firstName = (String) dataMap.get("lastName");
		String lastName = (String) dataMap.get("lastName");
		String gender = (String) dataMap.get("gender");
		String dob = (String) dataMap.get("dob");
		String isPregnant = (String) dataMap.get("isPregnant");
		String isUnderDialysis = (String) dataMap.get("isUnderDialysis");
		String diabetesType = (String) dataMap.get("diabetesType");
		String weightlossSurgeryDone = (String) dataMap.get("weightlossSurgeryDone");
		String weightlossSurgeryin12Months = (String) dataMap.get("weightlossSurgeryin12Months");
		String currentHeightFeet = (String) dataMap.get("currentHeightFeet");
		String currentHeghtInches = (String) dataMap.get("currentHeghtInches");
		String currentWeight = (String) dataMap.get("currentWeight");

		programEligibility = aboutYouSignupPage.fillAboutYouFormForKeyCodeNew(
				firstName + HelperUtils.getRandomNumber(9), lastName, gender, dob);

		programEligibility.selectPregnancy(isPregnant);

		programEligibility.selectDialysis(isUnderDialysis);

		programEligibility.selectDiabetesType(diabetesType);

		programEligibility.selectWeightLossSurgery(weightlossSurgeryDone);

		programEligibility.WeightLossSurgeryInLast12Months(weightlossSurgeryin12Months);

		programEligibility.enterHeightFeet(currentHeightFeet);

		programEligibility.enterHeightInches(currentHeghtInches);

		programEligibility.enterWeight(currentWeight);

		programEligibility.clickOnContinueButton();

		programEligibility.clickBackButtonOnErrorPage();

		programEligibility.clickOnContinueButton();

	}

	@Then("^Dialysis Ineligibility Error Message should be displayed$")
	public void dialysis_Ineligibility_Error_Message_should_be_displayed(DataTable arg1) throws Throwable {
	    
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String dialysisErrorMessage = (String) dataMap.get("dialysisErrorMessage");
				
		Assert.assertEquals(dialysisErrorMessage, programEligibility.getErrorMessageText());

		programEligibility.clickCloseButtonOnErrorMessage();

	}

	@When("^User Fill in all the details in Eligibility Form as a Correct BMI Patient$")
	public void user_Fill_in_all_the_details_in_Eligibility_Form_as_a_Correct_BMI_Patient(DataTable arg1) throws Throwable {

		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String firstName = (String) dataMap.get("lastName");
		String lastName = (String) dataMap.get("lastName");
		String gender = (String) dataMap.get("gender");
		String dob = (String) dataMap.get("dob");
		String isPregnant = (String) dataMap.get("isPregnant");
		String isUnderDialysis = (String) dataMap.get("isUnderDialysis");
		String diabetesType = (String) dataMap.get("diabetesType");
		String weightlossSurgeryDone = (String) dataMap.get("weightlossSurgeryDone");
		String weightlossSurgeryin12Months = (String) dataMap.get("weightlossSurgeryin12Months");
		String currentHeightFeet = (String) dataMap.get("currentHeightFeet");
		String currentHeghtInches = (String) dataMap.get("currentHeghtInches");
		String currentWeight = (String) dataMap.get("currentWeight");

		programEligibility = aboutYouSignupPage.fillAboutYouFormForKeyCodeNew(
				firstName + HelperUtils.getRandomNumber(9), lastName, gender, dob);

		programEligibility.selectPregnancy(isPregnant);

		programEligibility.selectDialysis(isUnderDialysis);

		programEligibility.selectDiabetesType(diabetesType);

		programEligibility.selectWeightLossSurgery(weightlossSurgeryDone);

		programEligibility.WeightLossSurgeryInLast12Months(weightlossSurgeryin12Months);

		programEligibility.enterHeightFeet(currentHeightFeet);

		programEligibility.enterHeightInches(currentHeghtInches);

		programEligibility.enterWeight(currentWeight);

		programEligibility.clickOnContinueButton();

		programEligibility.clickBackButtonOnErrorPage();

		programEligibility.clickOnContinueButton();

	}

	@Then("^BMI Ineligibility Error Message should be displayed$")
	public void bmi_Ineligibility_Error_Message_should_be_displayed(DataTable arg1) throws Throwable {
	    
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String bmiErrorMessage = (String) dataMap.get("bmiErrorMessage");
		
		Assert.assertEquals(bmiErrorMessage, programEligibility.getErrorMessageText());

		programEligibility.clickCloseButtonOnErrorMessage();
		
	}

	@When("^User clicks on Action plan's Active goal and completes mini assessment as a Pregnant patient$")
	public void user_clicks_on_Action_plan_s_Active_goal_and_completes_mini_assessment_as_a_Pregnant_patient() throws Throwable {
	   
		actionPlanQuestionnaireStartingPage = portalHomePage.openActionPlan();

		actionPlanQuestionnairePage = actionPlanQuestionnaireStartingPage.startActionPlan();

		excelReader = new ExcelReader("Smoke_ActionPlan_Questionaire.xlsx", "ActionPlan_WeightTalkPregnant");

		excelReader.setStartRow(1);

		actionPlanQuestionnairePage.answerQuestionsFromExcel(excelReader);
				
	}

	@Then("^Pregnancy Ineligibility Error Message should be displayed for mini assessment$")
	public void pregnancy_Ineligibility_Error_Message_should_be_displayed_for_mini_assessment(DataTable arg1) throws Throwable {
	 
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String pregnancyErrorMessage = (String) dataMap.get("pregnancyErrorFromMiniAssessment");
		
		Assert.assertEquals("Validating Pregnancy error message during mini assessment",pregnancyErrorMessage, actionPlanQuestionnairePage.getErrorMessageText());

		actionPlanQuestionnairePage.clickOnBackButtonAtErrorPage();
	}

	@When("^User completes the mini assessment as a Dialysis patient$")
	public void user_completes_the_mini_assessment_as_a_Dialysis_patient() throws Throwable {
	    
		excelReader = new ExcelReader("Smoke_ActionPlan_Questionaire.xlsx", "ActionPlan_WeightTalkDialysis");

		excelReader.setStartRow(1);

		actionPlanQuestionnairePage.answerQuestionsFromExcel(excelReader);

		
	}

	@Then("^Dialysis Ineligibility Error Message should be displayed for mini assessment$")
	public void dialysis_Ineligibility_Error_Message_should_be_displayed_for_mini_assessment(DataTable arg1) throws Throwable {
	  
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String dialysisErrorMessage = (String) dataMap.get("dialysisErrorFromMiniAssessment");
		
		Assert.assertEquals("Validating Dialysis error message during mini assessment",dialysisErrorMessage, actionPlanQuestionnairePage.getErrorMessageText());

		actionPlanQuestionnairePage.clickOnBackButtonAtErrorPage();
		
	}

	@When("^User completes the mini assessment with correct BMI$")
	public void user_completes_the_mini_assessment_with_correct_BMI() throws Throwable {
		

		excelReader = new ExcelReader("Smoke_ActionPlan_Questionaire.xlsx", "ActionPlan_WeightTalkBMI");

		excelReader.setStartRow(1);

		actionPlanQuestionnairePage.answerQuestionsFromExcel(excelReader);

		
	}

	@Then("^BMI Ineligibility Error Message should be displayed for mini assessment$")
	public void bmi_Ineligibility_Error_Message_should_be_displayed_for_mini_assessment(DataTable arg1) throws Throwable {
		
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String bmiErrorMessage = (String) dataMap.get("bmiErrorFromMiniAssessment");
		
		Assert.assertEquals("Validating BMI error message during mini assessment",bmiErrorMessage, actionPlanQuestionnairePage.getErrorMessageText());

		actionPlanQuestionnairePage.clickOnBackButtonAtErrorPage();

		
	}
}
