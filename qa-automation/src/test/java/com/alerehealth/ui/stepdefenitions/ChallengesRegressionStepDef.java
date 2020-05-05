package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.library.LibraryConstants;
import com.alerehealth.ui.portal.progress.challenges.AddEditChallengePage;
import com.alerehealth.ui.portal.progress.challenges.AvailableChallengesPage;
import com.alerehealth.ui.portal.progress.challenges.ChallengesBasePage;
import com.alerehealth.ui.portal.progress.challenges.ChallengesCompletedPage;
import com.alerehealth.ui.portal.progress.challenges.MissedChallengesPage;
import com.alerehealth.ui.portal.progress.challenges.UpcomingChallengesPage;
import com.alerehealth.ui.portal.progress.constants.ChallengesConstants;
import com.alerehealth.ui.portal.rewards.CreditPage;
import com.alerehealth.ui.portal.rewards.HistoryPage;
import com.alerehealth.ui.portal.rewards.JoinAChallengePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChallengesRegressionStepDef {
	
	
	PortalHomePage portalhomepage = null;

	ChallengesBasePage challengesBasePage = null;

	CreditPage creditPage = null;

	AvailableChallengesPage availableChallengesPage = null;
	
	AddEditChallengePage addEditChallengePage = null;
	
	ChallengesCompletedPage challengesCompletedPage = null;
	
	UpcomingChallengesPage upcomingChallengesPage = null;
	
	MissedChallengesPage  missedChallengesPage = null;
	
	JoinAChallengePage joinAChallengePage = null;
	
	HistoryPage historyPage = null;
	
	String challenge = null;
	
	String confirmChangesTextInUI;
	
	String confirmChangesTextInExpected;
	
	String titleCompletedChallengeInUI;
	
	String contentCompletedChallengeInUI;
	
	String creditCountInUI;
	
	String contentJoinChallengeInUI;
	
	int maximumDigitsInFormFieldInUI;
	
	List<String> availableChallengesTitles;
	
	List<String> missedChallenges;
	
	List<String> upcomingChallenges;
	
	String  creditValueInChallenges;
	String creditValueInCreditsPage;
	String creditValueInHistory;
	
	String dateValueInUI;
	String maxStepsPerDayInUI;
	String stepsEntryDeadLine;
	String creditInUI;
	String deadLineMouseHoverTextInUI;
	
	@Given("^Click on Challenges content card which is navigated to Available Challenges Page$")
	public void click_on_Challenges_content_card_which_is_navigated_to_Available_Challenges_Page() throws Throwable {
	   
		portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;
		
		availableChallengesPage = portalhomepage.clickJoinChallengeContentCard();

		Assert.assertTrue("Available Challenge Page is displayed", availableChallengesPage.isDisplayed());

	}


	@When("^Click on GetStarted Button in Available Challenges Page Back to Challenges link should display$")
	public void click_on_GetStarted_Button_in_Available_Challenges_Page_Back_to_Challenges_link_should_display(DataTable arg1) throws Throwable {
	  
		Map<String, String> data = arg1.asMap(String.class, String.class);

		challenge = data.get("challenge name");

	   addEditChallengePage = availableChallengesPage.startChallenge(challenge);
	   
	   Assert.assertTrue("Challenges DashBoard is displayed", addEditChallengePage.isDisplayed());
	   
	   Assert.assertTrue("Back to Challenges link is displayed",addEditChallengePage.isBackToChallengesLnkDisplayed());
		
	}

	@When("^Challenge Attributes such as date, credits earned should be displayed$")
	public void challenge_Attributes_such_as_date_credits_earned_should_be_displayed() throws Throwable {
	    
		dateValueInUI = addEditChallengePage.getChallengeAttributes("Date");
		Assert.assertTrue("Date  is displayed ",dateValueInUI.equals(ChallengesConstants.CHALLENGE_DATE));
		maxStepsPerDayInUI = addEditChallengePage.getChallengeAttributes("MaxStepsPerDay");
		Assert.assertTrue("Maximum Steps Per Day is displayed ",maxStepsPerDayInUI.equals(ChallengesConstants.CHALLENGE_MAXSTEPS_PER_DAY));
		stepsEntryDeadLine=addEditChallengePage.getChallengeAttributes("StepsEntryDeadLine");
		Assert.assertTrue("stepsEntryDeadLine is displayed ",stepsEntryDeadLine.equals(ChallengesConstants.CHALLENGE_DEADLINE));
		creditInUI = addEditChallengePage.getCredits();
		Assert.assertTrue("Credits should be displayed",creditInUI.equals(ChallengesConstants.CHALLENGE_CREDIT_EARNED));
	}
	
	@When("^validate learn more, less link and mousehover on the Deadline link is displayed$")
	public void validate_learn_more_less_link_and_mousehover_on_the_Deadline_link_is_displayed() throws Throwable {
	    
		addEditChallengePage.clickLearnMoreOrLess("Learn More");
		Assert.assertTrue("Learn more challenge description is displayed", addEditChallengePage.isLearnMoreDescriptionDisplayed());
		addEditChallengePage.clickLearnMoreOrLess("Less");
		deadLineMouseHoverTextInUI = addEditChallengePage.getMouseHoverText();
		Assert.assertTrue("Deadline link mouse hover text should be displayed",deadLineMouseHoverTextInUI.equals(ChallengesConstants.CHALLENGE_MINUTES_DEADLINE_MOUSEHOVER_LINK));
		
	}
	
	@When("^validate whether mousehover on the Deadline link is displayed$")
	public void validate_whether_mousehover_on_the_Deadline_link_is_displayed() throws Throwable {
		deadLineMouseHoverTextInUI = addEditChallengePage.getMouseHoverText();
		Assert.assertTrue("Deadline link mouse hover text should be displayed",deadLineMouseHoverTextInUI.equals(ChallengesConstants.CHALLENGE_STEPS_DEADLINE_MOUSEHOVER_LINK));
	}

	@When("^Add or Enter any data in Challenges DashBoard Page click on Back To Challenges without saving it$")
	public void add_or_Enter_any_data_in_Challenges_DashBoard_Page_click_on_Back_To_Challenges_without_saving_it(DataTable arg1) throws Throwable {
         
		Map<String, String> data = arg1.asMap(String.class, String.class);
		
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));
		
		String dateFromUI = addEditChallengePage.getDisplayDate();
		
		System.out.println(dateFromUI);
		
		String dateExpected = DateTimeUtils.getCurrentTime("EEEEEEEE, MMMM d, yyyy");
		
		System.out.println(dateExpected);

		Assert.assertEquals("Validating date is equal to current date", dateExpected, dateFromUI);
		
		addEditChallengePage.clickAddButton();
		
		addEditChallengePage.enterSteps(data.get("steps"));

	}
	

	@Then("^Validation message should be displayed$")
	public void validation_message_should_be_displayed() throws Throwable {
	    
		confirmChangesTextInUI = addEditChallengePage.getConfirmChangesPopupByClickingBackToChallenges();
		
		System.out.println(confirmChangesTextInUI);
		
		Assert.assertTrue("Confirm Changes popup text is displayed ",confirmChangesTextInUI.equals(ChallengesConstants.CHALLENGES_CONFIRM_POPUP_MESSAGE));

	}
	
	
	@When("^Click on Completed Challenges link verify the message displayed$")
	public void click_on_Completed_Challenges_link_verify_the_message_displayed() throws Throwable {
        
		challengesBasePage = new ChallengesBasePage();
		challengesCompletedPage = challengesBasePage.navigateToCompletedPage();
		Assert.assertTrue(challengesBasePage.isDisplayed());
		titleCompletedChallengeInUI = challengesCompletedPage.getCompletedPageVerficationText();
		Assert.assertTrue("Completed challenge Title is displayed ",titleCompletedChallengeInUI.equals(ChallengesConstants.COMPLETED_CHALLENGE_TITLE));
		contentCompletedChallengeInUI = challengesCompletedPage.getCompletedPageContentVerficationText();
		Assert.assertTrue("Completed challenge content is displayed ",contentCompletedChallengeInUI.equals(ChallengesConstants.COMPLETED_CHALLENGE_CONTENT));
		
	}

	@When("^Click on Missed challenge link verify the Earning Activity displayed$")
	public void click_on_Missed_challenge_link_verify_the_Earning_Activity_displayed() throws Throwable {
	    
		missedChallengesPage = challengesBasePage.navigateToMissedPage();
		
		missedChallenges = missedChallengesPage.getMissedChallengesTitles();
		
		Assert.assertTrue(missedChallenges.containsAll(Arrays.asList("Fresh Focus Challenge","Finding Financial Wellness Challenge","Be the Change Challenge")));
		
	}

	@Then("^Upcoming challenges should display as Earning Activity$")
	public void upcoming_challenges_should_display_as_Earning_Activity() throws Throwable {
	    
		upcomingChallengesPage =challengesBasePage.navigateToUpcomingPage();
		
		upcomingChallenges = upcomingChallengesPage.getUpcomingChallengesTitles();

		//Assert.assertTrue(upcomingChallenges.containsAll(Arrays.asList("Maintain Don’t Gain Challenge")));
		
		availableChallengesPage = challengesBasePage.navigateToAvailablePage();
		
		Assert.assertTrue("Available Challenge Page is displayed", availableChallengesPage.isDisplayed());
		
	}


	@When("^Click  on Add Button to validate textbox and cancel button$")
	public void click_on_Add_Button_to_validate_textbox_and_cancel_button() throws Throwable {
	 
		addEditChallengePage.clickAddButton();
		Assert.assertTrue("Add Textbox and Cancel Button is displayed",addEditChallengePage.isTextboxAndCancelBtnDisplayed());

	}

	@When("^Click on Cancel Button where default view with Add Button should be displayed$")
	public void click_on_Cancel_Button_where_default_view_with_Add_Button_should_be_displayed() throws Throwable {
	  
		addEditChallengePage.clickCancelBtn();
		Assert.assertTrue("Add Button is displayed",addEditChallengePage.isDisplayed());
		
	}

	@When("^Start the Challenge$")
	public void start_the_Challenge(DataTable arg1) throws Throwable {
	 
		
		Map<String, String> data = arg1.asMap(String.class, String.class);

		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));

		addEditChallengePage.clickAddButton();

		addEditChallengePage.enterSteps(data.get("steps"));

		addEditChallengePage.clickSubmit();

		Assert.assertEquals("Validating success message when valid date is entered", addEditChallengePage.getSuccessMessage(), ChallengesConstants.CHALLENGES_DATE_TEXT_SUCCESS_MESSAGE);
        
		addEditChallengePage.clickBackArrowOrDatePicker("Backarrow");
		
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));

		addEditChallengePage.clickAddButton();

		addEditChallengePage.enterSteps(data.get("steps1"));
		
		addEditChallengePage.clickSubmit();
		
		maximumDigitsInFormFieldInUI = addEditChallengePage.getMaxDigitsInFormField();
		
		 Assert.assertEquals("Validating maximum digits in form field", maximumDigitsInFormFieldInUI, ChallengesConstants.CHALLENGE_MAXIMUM_DIGITS_ENTERED);
	}

	
	
	@Then("^validate credits count and Update Button in Available Page$")
	public void validate_credits_count_and_Update_Button_in_Available_Page() throws Throwable {
	 
		creditCountInUI = addEditChallengePage.getTotalCreditsFooter("footer1");
		Assert.assertTrue("Credits displayed are same as added",creditCountInUI.equals(ChallengesConstants.CHALLENGES_CREDITED_COUNT));
		
		availableChallengesPage = addEditChallengePage.navigateBackToChallengesPage();
		String buttonText = availableChallengesPage.getButtonTextOfChallenge(challenge);

		Assert.assertEquals("Verfying whether get started button text changed to update in challenges page", buttonText, ChallengesConstants.UPDATE_BUTTON_TEXT);
	}
	
	
	@When("^User click on Rewards it is navigated to Credits Page$")
	public void user_click_on_Rewards_it_is_navigated_to_Credits_Page() throws Throwable {
		
		portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;
        
		creditPage = portalhomepage.openCreditPage();
	}

	@When("^Click on GetStarted Button in Join Challenge Card$")
	public void click_on_GetStarted_Button_in_Join_Challenge_Card() throws Throwable {
	   
		joinAChallengePage = creditPage.navigateToJoinChallenge();
		Assert.assertTrue("Join A Challenge dashboard is displayed",joinAChallengePage.isDisplayed());
	}

	@When("^Join Challenge content should be displayed$")
	public void join_Challenge_content_should_be_displayed() throws Throwable {
	    
		contentJoinChallengeInUI = joinAChallengePage.getContentJoinChallenge();
		Assert.assertTrue("Join A Challenge content is as expected",contentJoinChallengeInUI.contains(ChallengesConstants.JOIN_A_CHALLENGE_CONTENT));

	}


	@When("^Click on Get started button in Join Challenge page to validate titles in Available Page$")
	public void click_on_Get_started_button_in_Join_Challenge_page_to_validate_titles_in_Available_Page() throws Throwable {
	   
		challengesBasePage = joinAChallengePage.clickGetStartedBtn();
		Assert.assertTrue("Challenges page is displayed",challengesBasePage.isDisplayed());
		availableChallengesPage = challengesBasePage.navigateToAvailablePage();
		availableChallengesTitles = availableChallengesPage.getAvailablePageTitlesVerficationText();
		Assert.assertTrue(availableChallengesTitles.containsAll(Arrays.asList("Step It Up Challenge", "1st Quarter Physical Activity Tracking_Test")));
		
	}
	
	@Then("^successfully complete all credits for an available challenge$")
	public void successfully_complete_all_credits_for_an_available_challenge(DataTable arg1) throws Throwable{
	 
		Map<String, String> data = arg1.asMap(String.class, String.class);

		challenge = data.get("challenge name");

	   addEditChallengePage = availableChallengesPage.startChallenge(challenge);
	   
	   addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value2"));
	   
	   addEditChallengePage.clickBackArrowOrDatePicker("Backarrow");
       
       addEditChallengePage.enterStepsToCompleteCredits(data.get("steps"));
       
       creditValueInChallenges = addEditChallengePage.getCredits();
       
       System.out.println(creditValueInChallenges);
       
       addEditChallengePage.navigateBackToChallengesPage();
              
	}
	
	@Then("^Rewards Credit and History page where credit score should be same as credits in Challenge page$")
	public void rewards_Credit_and_History_page_where_credit_score_should_be_same_as_credits_in_Challenge_page() throws Throwable {
	   
		creditPage = portalhomepage.openCreditPage();
		
		Assert.assertTrue("History page in Rewards is displayed", creditPage.isDisplayed());
		
		creditValueInCreditsPage = creditPage.getCreditScore();
		
		Assert.assertTrue("Credit Score in Challenges and Rewards Credits Page should be same",creditValueInChallenges.equals(creditValueInCreditsPage));
		
		historyPage = creditPage.clickEarningHistory();
		
		Assert.assertTrue("History page in Rewards is displayed", historyPage.isDisplayed());
		
		historyPage = portalhomepage.openHistoryPage();
		
		Assert.assertTrue("History page in Rewards is displayed", historyPage.isDisplayed());
		
		creditValueInHistory = historyPage.getChallengeCreditsInHistory("Step It Up Challenge");
		
		Assert.assertTrue("Credit Score in Challenges and Rewards history Page should be same",creditValueInChallenges.equals(creditValueInHistory));

	}

	@Then("^Add or Enter any data in Challenges DashBoard Page toggle from Daily to weekly and back arrow confirm save data message should be displayed$")
	public void add_or_Enter_any_data_in_Challenges_DashBoard_Page_toggle_from_Daily_to_weekly_and_back_arrow_confirm_save_data_message_should_be_displayed(DataTable arg1) throws Throwable {
	    

		Map<String, String> data = arg1.asMap(String.class, String.class);

		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));

		addEditChallengePage.clickAddButton();

		addEditChallengePage.enterSteps(data.get("Minutes"));
		
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value2"));
		
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));
		
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		
		 addEditChallengePage = addEditChallengePage.clickButtonInConfirmationPopup("No");
		
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value2"));
		
		addEditChallengePage.clickAddButton();

		addEditChallengePage.enterSteps(data.get("Minutes"));
		
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));
		
		Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		
		addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		
		addEditChallengePage.clickBackArrowOrDatePicker("Backarrow");

        Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		
		addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		
		addEditChallengePage.clickBackArrowOrDatePicker("DatePicker");
		
		addEditChallengePage.selectCurrentDate();
		
        Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		
		addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		
	}

	@Then("^Click on Footer links such as contacts, privacy,Terms,Accessibility confirm save data message should be displayed$")
	public void click_on_Footer_links_such_as_contacts_privacy_Terms_Accessibility_confirm_save_data_message_should_be_displayed() throws Throwable {
	    
	    addEditChallengePage.clickOnFooterItems("Contact");
        Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
        addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
        
		addEditChallengePage.clickOnFooterItems("Privacy");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
	     addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		
		addEditChallengePage.clickOnFooterItems("Accessibility");
		Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
	     addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		
		addEditChallengePage.clickOnFooterItems("Terms");
		Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
	     addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		
		addEditChallengePage.clickOnFooterItems("Site Map");
		Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
	    addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		
	}

	@Then("^Click on learn more or less link confirm save data message should not be displayed$")
	public void click_on_learn_more_or_less_link_confirm_save_data_message_should_not_be_displayed() throws Throwable {
	  
		addEditChallengePage.clickLearnMoreOrLess("Learn More");
		Assert.assertTrue("Learn more challenge description is displayed", addEditChallengePage.isLearnMoreDescriptionDisplayed());
		addEditChallengePage.clickLearnMoreOrLess("Less");
	}

	@Then("^Click on all the drop downs from top navigation Like ActionPlan, Progress, library confirm save data message should be displayed$")
	public void click_on_all_the_drop_downs_from_top_navigation_Like_ActionPlan_Progress_library_confirm_save_data_message_should_be_displayed() throws Throwable {
	   
		 addEditChallengePage.clickDropDownfromTopNavigation("Progress");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clickDropDownfromTopNavigation("Rewards");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clickDropDownfromTopNavigation("Coaching");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clickDropDownfromTopNavigation("Library");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clickDropDownfromTopNavigation("Health Promotion Programs");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clickDropDownfromTopNavigation("Member Resource Center");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clickDropDownfromTopNavigation("Community");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
	}

	@Then("^Click on Cient Name, Client Logo, Help, Credits Link, Credits Value, Avatar confirm save data message should be displayed$")
	public void click_on_Cient_Name_Client_Logo_Help_Credits_Link_Credits_Value_Avatar_confirm_save_data_message_should_be_displayed() throws Throwable {
	   
		 addEditChallengePage.clickOnUserName();
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clientLogo();
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
		 addEditChallengePage.clickOnHelpOrCredits("Help", "Help");
	     Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
			
		 addEditChallengePage.clickOnHelpOrCredits("Credits","Credits");
		 Assert.assertTrue("Confirm Changes popup text is displayed ",addEditChallengePage.isConfirmationDialogDisplayed());
		 addEditChallengePage = addEditChallengePage.closeConfirmationDialogMessage();
		 
	}


}
