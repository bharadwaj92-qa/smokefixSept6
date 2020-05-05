package com.alerehealth.ui.stepdefenitions;

import java.util.List;
import java.util.Map;

import com.alerehealth.fwk.common.Constants;
import com.alerehealth.ui.portal.common.pages.*;
import cucumber.api.DataTable;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MarketingPageValidationStepDef {

	MarketingPage marketingpage=null;
	PortalLoginPage portalLoginPage=null;
	SignUpPage signupPage = null;
	PortalHomePage portalHomePage = null ;
	WBAQuestionnaireStepsDefinition usercreation;

	CustomURLLauncher customUrl;
	PrivacyPolicyPage privacyPolicyPage;

	@Given("^Navigating to the Marketing page URL$")
	public void navigating_to_the_Marketing_page_URL() throws Throwable {

		marketingpage=new MarketingPage();

	}

	@When("^User validating the Header, Logo and links navigation$")
	public void user_validating_the_Header_Logo_and_links_navigation() throws Throwable {

		List<String> headerLinks = marketingpage.getHeaderLinks();

		String spanishLink = "Español";
	
		Assert.assertTrue("Spanish Link is displaying", headerLinks.contains(spanishLink));
		Assert.assertTrue("Help Link is displaying", headerLinks.contains("Help"));
		Assert.assertTrue("Sign Up Link is displaying", headerLinks.contains("Sign Up"));
		Assert.assertTrue("Log In Link is displaying", headerLinks.contains("Log In"));


		Assert.assertTrue("Client logo is displaying", marketingpage.isClientLogoDisplayed());

		String marpageHeaderText = marketingpage.getMarketingPageHeaderTitle();
		String marpageHeaderTextExpected = "The smart way to practice healthy living.";
		Assert.assertEquals("Header Text is matching", marpageHeaderTextExpected, marpageHeaderText);

		CommonHelpPage helpPage= marketingpage.clickOnHelpLink();

		Assert.assertTrue("Help page is displayed", helpPage.isDisplayed());

		SignUpPage signupPage = helpPage.clickSignUp();
				
		Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());


	}

	@Then("^Validate the Get Started Now links in the marketing page$")
	public void validate_the_Get_Started_Now_links_in_the_marketing_page() throws Throwable {

		marketingpage=new MarketingPage();

		SignUpPage signupPage = marketingpage.clickGetStartedOfSection("HeroBanner");

		Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());

		signupPage.navigateToBackPage();

		signupPage = marketingpage.clickGetStartedOfSection("Do More");

		Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());


	}

	@Then("^Enter invalid credentials and verify error messages$")
	public void enter_invalid_credentials_and_verify_error_messages(DataTable arg1) throws Throwable {
		portalLoginPage = marketingpage.clickLoginLink();

		Map dataMap = (Map) arg1.asMap(String.class, String.class);
		String Username = (String) dataMap.get("username");
		String Password = (String) dataMap.get("password");

		String errormessage = Constants.PORTAL_INVALID_ERROR_MESSAGE;

		portalLoginPage.doLoginInvalidCred(Username,Password);
		String strActualErrorMessage = portalLoginPage.getTextOfLoginErrorMessage();
		System.out.println(strActualErrorMessage);
		System.out.println(errormessage);
		Assert.assertTrue("Validating Error messages with invalid credentials.",strActualErrorMessage.contains(errormessage));

	}

	@Then("^Enter invalid username and verify error message\\.$")
	public void enter_invalid_username_and_verify_error_message(DataTable arg1) throws Throwable {
		portalLoginPage.emptyCredLogin();
		Map dataMap = (Map) arg1.asMap(String.class, String.class);
		String Username = (String) dataMap.get("username");
		String Password = (String) dataMap.get("password");
		String errormessage = (String) dataMap.get("Error Message");
		portalLoginPage.invalidUserLogin(Username,Password);
		String strUsernameActualError = portalLoginPage.getUserNameFieldErrorMessage();
		Assert.assertEquals("Validating Error message for Username", strUsernameActualError, errormessage);
	}


	@Then("^without username and password verify error message\\.$")
	public void without_username_and_password_verify_error_message(DataTable arg1) throws Throwable {
		portalLoginPage.emptyCredLogin();
		Map dataMap = (Map) arg1.asMap(String.class, String.class);
		String strUsernameActualError = portalLoginPage.getUserNameFieldErrorMessage();
		String usererrormessage = (String) dataMap.get("Username Error Message");
		Assert.assertEquals("Validating Error message for Empty Username", strUsernameActualError, usererrormessage);
		String strPwdActualError = PortalLoginPage.getPasswordFieldErrorMessage();
		String passworderrormessage = (String) dataMap.get("Password Error Message");
		Assert.assertEquals("Validating Error message for Empty Password", strPwdActualError, passworderrormessage);

	}

	@Then("^Validate top links by clicking each link and verifying pages to which navigation$")
	public void validate_top_links_by_clicking_each_link_and_verifying_pages_to_which_navigation() throws Throwable {
		portalLoginPage = marketingpage.clickLoginLink();
		String loginActualText = portalLoginPage.getLoginPageTitle();
		String loginExpText = Constants.PORTAL_LOGINHEADER_TEXT;
		Assert.assertEquals("Validating Login page", loginActualText, loginExpText);

		signupPage = portalLoginPage.clickSignUp();
		String signupActualText = signupPage.getSignupPageTitle();
		String signupExpText = Constants.PORTAL_SIGNUPPAGE_TEXT;
		Assert.assertEquals("Validating SignUp page", signupActualText, signupExpText);

		portalLoginPage = signupPage.clickLoginLink();
		String loginSignupActualText = portalLoginPage.getLoginPageTitle();
		Assert.assertEquals("Validating Login page from Signup page", loginSignupActualText, loginExpText);

		signupPage = portalLoginPage.clickCreateOneNow();
		String signupCreatenowActualText = signupPage.getSignupPageTitle();
		Assert.assertEquals("Validating SignUp page", signupCreatenowActualText, signupExpText);


	}

	@Then("^Enter the valid credentials and verify that login is susccessfull$")
	public void enter_the_valid_credentials_and_verify_that_login_is_susccessfull() throws Throwable {
		portalLoginPage = marketingpage.clickLoginLink();
		portalHomePage = portalLoginPage.doLogin(usercreation.portalUserName,"asdf");
		Assert.assertTrue("Validating with valid credentials.", portalHomePage.isDisplayed());
	}

	@Given("^Launch url of client \"([^\"]*)\"$")
	public void launch_url_of_client(String arg1) throws Throwable {

		customUrl = new CustomURLLauncher(arg1);

	}

	@When("^User clicks on Privacy Link and Naivgates to privacy page$")
	public void user_clicks_on_Privacy_Link_and_Naivgates_to_privacy_page() throws Throwable {

		customUrl.clickLink("Privacy");

		privacyPolicyPage = new PrivacyPolicyPage();

	}

	@Then("^validate the \"([^\"]*)\" in Privacy page$")
	public void validate_the_in_Privacy_page(String arg1) throws Throwable {

		String clientParaContent = privacyPolicyPage.getClientNameUnitedHealthHolderPara(arg1);

		Assert.assertTrue("Client name is present", clientParaContent.contains(arg1));
	}

}
