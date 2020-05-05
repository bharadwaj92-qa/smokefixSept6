package com.alerehealth.ui.stepdefenitions;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.progress.challenges.*;
import com.alerehealth.ui.portal.progress.constants.ChallengesConstants;
import com.alerehealth.ui.portal.rewards.CreditPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.junit.Assert;

import com.alerehealth.fwk.api.utils.DateTimeUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

public class ChallengesStepDef {


	ClientConfiguration clientConfiguration = ClientConfiguration.getClientConfiguration();

	PortalHomePage portalhomepage = null;

	ChallengesBasePage challengesBasePage = null;

	CreditPage creditPage = null;
	
	AddEditChallengePage addEditChallengePage = null;

	AvailableChallengesPage availableChallengesPage = null;

	ChallengesCompletedPage challengesCompletedPage = null;

	MissedChallengesPage challnegesMissedPage = null;

	UpcomingChallengesPage challengesUpcomingPage = null;

	String challenge = null;

	@Given("^I login into portal with logid as \"([^\"]*)\",password as \"([^\"]*)\" and navigate to challenges$")
	public void i_login_into_portal_with_logid_as_password_as_and_navigate_to_challenges(String arg1, String arg2) throws Throwable {

		PortalLoginPage portalLoginPage = new PortalLoginPage();

		portalhomepage = portalLoginPage.doLogin(arg1, arg2);

		challengesBasePage = portalhomepage.navigateToChallengesPage();

	}


	@When("^I validate all left navigation links are working$")
	public void i_validate_all_left_navigation_links_are_working() throws Throwable {

		portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;
		
		challengesBasePage = portalhomepage.navigateToChallengesPage();
		
		challengesUpcomingPage = challengesBasePage.navigateToUpcomingPage();

		Assert.assertTrue("Upcoming challenges page is displayed", challengesUpcomingPage.isDisplayed());

		challnegesMissedPage = challengesUpcomingPage.navigateToMissedPage();

		Assert.assertTrue("Missed challenges page is displayed", challnegesMissedPage.isDisplayed());

		challengesCompletedPage = challengesUpcomingPage.navigateToCompletedPage();

		Assert.assertTrue("Completed challenges page is displayed", challengesCompletedPage.isDisplayed());

		availableChallengesPage = challengesCompletedPage.navigateToAvailablePage();

		Assert.assertTrue("Available challenges page is displayed", availableChallengesPage.isDisplayed());

	}

	@When("^i start a challenge$")
	public void i_start_a_challenge(DataTable arg1) throws Throwable {

		Map<String, String> data = arg1.asMap(String.class, String.class);

		challenge = data.get("challenge name");

		 addEditChallengePage = availableChallengesPage.startChallenge(challenge);

//		//Weekly date range validation
//		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value2"));
//
		

//		Assert.assertEquals("Validating Week date", DateTimeUtils.getDifferenceinDaysBetweenDates(datesplit[0], datesplit[1].substring(1, datesplit[1].indexOf(',')), "MMMM dd"), 6);

		//Daily date range validation
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));

		String dateFromUI = addEditChallengePage.getDisplayDate();
		String dateExpected = DateTimeUtils.getCurrentTime("EEEEEEEE, MMMM d, yyyy");

		Assert.assertEquals("Validating date is equal to current date", dateExpected, dateFromUI);

		
		
		
		//Weekly date range validation
				addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value2"));

				dateFromUI = addEditChallengePage.getDisplayDate();
				String datesplit[] = dateFromUI.split("-");

				Assert.assertEquals("Validating Week date", DateTimeUtils.getDifferenceinDaysBetweenDates(datesplit[0], datesplit[1].substring(1, datesplit[1].indexOf(',')), "MMMM dd"), 6);

				
				
				
				
		addEditChallengePage.clickAddButton();

		addEditChallengePage.enterSteps("");

		Assert.assertEquals("Valdating error message when date is empty", addEditChallengePage.getAddStepsFieldError(), ChallengesConstants.CHALLENGES_DATE_TEXT_ERROR_MESSAGE);

		addEditChallengePage.enterSteps(data.get("steps"));

		addEditChallengePage.clickSubmit();

		Assert.assertEquals("Validating success message when valid date is entered", addEditChallengePage.getSuccessMessage(), ChallengesConstants.CHALLENGES_DATE_TEXT_SUCCESS_MESSAGE);

		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value2"));

		addEditChallengePage.enterSteps(data.get("steps"));

		//Daily date range validation
		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value1"));

//		Assert.assertEquals("Validating text in pop up field", addEditChallengePage.getConfirmationDialogMessage(), ChallengesConstants.CHALLENGES_POP_UP_MESSAGE);

		addEditChallengePage.handlePopUp(data.get("popup value"));

		addEditChallengePage.selectDailyWeeklyDropdown(data.get("dropdown value2"));

		addEditChallengePage.enterSteps(data.get("steps"));

		addEditChallengePage.enterSteps(data.get("steps"));

		addEditChallengePage.clickSubmit();

		Assert.assertEquals("Validating success message for weekly steps are added", addEditChallengePage.getSuccessMessage(), ChallengesConstants.CHALLENGES_DATE_TEXT_SUCCESS_MESSAGE);

		availableChallengesPage = addEditChallengePage.navigateBackToChallengesPage();


	}

	@Then("^Challene is successfull added and verified in Challenges page and Credit page$")
	public void challene_is_successfull_added_and_verified_in_Challenges_page_and_Credit_page() throws Throwable {

		String buttonText = availableChallengesPage.getButtonTextOfChallenge(challenge);

		Assert.assertEquals("Verfying whether get started button text changed to update in challenges page", buttonText, ChallengesConstants.UPDATE_BUTTON_TEXT);

		CreditPage creditPage = availableChallengesPage.openCreditPage();

		buttonText = creditPage.getButtonNameOfSmallCard(challenge);

		Assert.assertEquals("Verfying whether get started button text changed to update in challenges page", buttonText, ChallengesConstants.UPDATE_BUTTON_TEXT);

	}


}

