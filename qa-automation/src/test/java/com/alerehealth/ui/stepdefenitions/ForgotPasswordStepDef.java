package com.alerehealth.ui.stepdefenitions;

import java.util.HashMap;

import org.junit.Assert;

import com.alerehealth.fwk.common.Constants;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.common.pages.ResetPasswordPage;
import com.alerehealth.ui.portal.qfl.QFLStartupPage;
import com.alerehealth.ui.portal.settings.YourProgramPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ForgotPasswordStepDef {
	
	 QFLStartupPage qflStartupPage=null;
	 PortalLoginPage portalLoginPage =null;
	 PortalHomePage portalHomePage = null;
	 YourProgramPage yourProgramPage =null;
	 ResetPasswordPage resetPasswordPage = null;
	 
	 String passwordTooltipTextInUI;
	 String forgotPasswordInUI;
	 String forgotPasswordBelowMsgInUI;
	 String errorMsgInUI;
	 String ErrorMsgSecurityQtnInUI;
	 String ErrorMsgRegExPasswordInUI;
	 String ErrorMsgRegExConfirmPasswordInUI;
	 String ErrorMsgNotIdenticalInUI;
	 
	@Given("^Login to AlerePortal using userName$")
	public void login_to_AlerePortal_using_userName(DataTable arg1) throws Throwable {
		
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		
	    portalLoginPage = new PortalLoginPage();
		String loginId = dataMap.get("username");
		portalLoginPage.enterLoginID(loginId);
	
	}

	@Given("^Click Password tooltip it should be navigated to ResetPassword Page$")
	public void click_Password_tooltip_it_should_be_navigated_to_ResetPassword_Page() throws Throwable {
	    
		passwordTooltipTextInUI = portalLoginPage.getTooltipText("Password");
		Assert.assertTrue("Password Tooltip Text should be displayed correctly",passwordTooltipTextInUI.equals(Constants.TOOLTIP_PASSWORD));
		resetPasswordPage = portalLoginPage.clickPasswordTooltip();
		Assert.assertTrue("Reset password page should be displayed", resetPasswordPage.isDisplayed() );
		
	}

	@Given("^Validate Forgot password heading and its below Message , LoginId and its textBox is displayed$")
	public void validate_Forgot_password_heading_and_its_below_Message_LoginId_and_its_textBox_is_displayed() throws Throwable {
	  
		forgotPasswordInUI = resetPasswordPage.getForgotPasswordText();
		Assert.assertTrue("Forgot Password Text should be displayed correctly",forgotPasswordInUI.equals(Constants.PORTAL_FORGOTPASSWORD_TEXT));
		forgotPasswordBelowMsgInUI = resetPasswordPage.getForgotPasswordBelowMessage();
		Assert.assertTrue("Forgot Password Below Message should be displayed correctly",forgotPasswordBelowMsgInUI.equals(Constants.PORTAL_FORGOTPASSWORD_BELOWMESSAGE));
		Assert.assertTrue("LoginID and its textBox is displayed",resetPasswordPage.isLoginIDAndTextboxDisplayed());
	}

	@When("^User enter invalid LoginId Error Message should be displayed and click on Login Button$")
	public void user_enter_invalid_LoginId_Error_Message_should_be_displayed_and_click_on_Login_Button(DataTable arg1) throws Throwable {
	  
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String LoginIdInvalid = dataMap.get("usernameInvalid");
		String loginId = dataMap.get("username");
		resetPasswordPage.enterLogin(LoginIdInvalid);
		resetPasswordPage.clickContinue();
		errorMsgInUI= resetPasswordPage.getErrorMessage();
		Assert.assertTrue("Error Message should be displayed correctly",errorMsgInUI.equals(Constants.PORTAL_FORGOTPASSWORD_ERRORMESSAGE));
		portalLoginPage = resetPasswordPage.clickLoginButton();
		portalLoginPage.setUserName(loginId);
		resetPasswordPage = portalLoginPage.clickPasswordTooltip();
		Assert.assertTrue("Reset password page should be displayed", resetPasswordPage.isDisplayed());
	}

	@When("^Click on Continue Button without entering Login ID Error Message should be displayed$")
	public void click_on_Continue_Button_without_entering_Login_ID_Error_Message_should_be_displayed(DataTable arg1) throws Throwable {
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String loginId = dataMap.get("username");
       	
		resetPasswordPage.clickContinue();
		errorMsgInUI= resetPasswordPage.getErrorMessage();
		Assert.assertTrue("Error Message should be displayed correctly",errorMsgInUI.equals(Constants.PORTAL_FORGOTPASSWORD_ERRORMESSAGE));
		portalLoginPage = resetPasswordPage.clickLoginButton();
		portalLoginPage.setUserName(loginId);
		resetPasswordPage = portalLoginPage.clickPasswordTooltip();
		Assert.assertTrue("Reset password page should be displayed", resetPasswordPage.isDisplayed());
	}

	@When("^Click on Continue Button by entering valid Login Id Security Question Page should be displayed$")
	public void click_on_Continue_Button_by_entering_valid_Login_Id_Security_Question_Page_should_be_displayed(DataTable arg1) throws Throwable {
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String loginId = dataMap.get("username");
		resetPasswordPage.enterLogin(loginId);
		resetPasswordPage.clickContinue();
		Assert.assertTrue("Security Question 1 is displayed", resetPasswordPage.isSecurityQuestionPageDisplayed("Security Question 1"));
		
	}

	@When("^Without entering any data Click on Continue Button Error Message should display$")
	public void without_entering_any_data_Click_on_Continue_Button_Error_Message_should_display() throws Throwable {
		resetPasswordPage.clickContinue();
		ErrorMsgSecurityQtnInUI = resetPasswordPage.getErrorMessageInSecurityForEmptyData();
		Assert.assertTrue("Error Message should be displayed correctly",ErrorMsgSecurityQtnInUI.equals(Constants.SECURITY_WITHOUT_ENTERING_DATA));
	}

	@When("^Enter invalid input  Click on Continue Button again Security Question page should display$")
	public void enter_invalid_input_Click_on_Continue_Button_again_Security_Question_page_should_display(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String securityQuestion = dataMap.get("securityQuestion1");
		resetPasswordPage.enterSecurityAnswer(securityQuestion);
		resetPasswordPage.clickContinue();
	}

	@When("^Enter Valid Input Click on Continue Button then Password screen should display$")
	public void enter_Valid_Input_Click_on_Continue_Button_then_Password_screen_should_display(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String securityQuestion2 = dataMap.get("securityQuestion2");
		resetPasswordPage.enterSecurityAnswer(securityQuestion2);
		resetPasswordPage.clickContinue();
		Assert.assertTrue("Password screen should be diplayed",resetPasswordPage.isPasswordFieldDisplayed("password"));
	}

	@Then("^Validate Both Password and confirm Password fields displayed$")
	public void validate_Both_Password_and_confirm_Password_fields_displayed() throws Throwable {
		Assert.assertTrue("Password field should be diplayed",resetPasswordPage.isPasswordFieldDisplayed("password"));
		Assert.assertTrue("ConfirmPassword field should be diplayed",resetPasswordPage.isPasswordFieldDisplayed("confirmPassword"));
	}

	@Then("^Error message should be displayed if both password and confirm password fields are not same$")
	public void error_message_should_be_displayed_if_both_password_and_confirm_password_fields_are_not_same(DataTable arg1) throws Throwable {
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String Password = dataMap.get("password");
		String ConfirmPassword = dataMap.get("confirmPassword");
		resetPasswordPage.setPasswordAndConfirmPassword("password", Password);
		resetPasswordPage.setPasswordAndConfirmPassword("confirmPassword", ConfirmPassword);
		ErrorMsgNotIdenticalInUI = resetPasswordPage.getPasswordErrorMsg("confirmPassword", "Identical");
		Assert.assertTrue("Error Message should be displayed correctly",ErrorMsgNotIdenticalInUI.equals(Constants.NOTIDENTICAL_ERRORMESSAGE));
	}

	@Then("^Error message should be displayed if invalid combination password is provided$")
	public void error_message_should_be_displayed_if_invalid_combination_password_is_provided(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String Password = dataMap.get("invalidPassword");
		String ConfirmPassword = dataMap.get("invalidConfirmPwd");
		resetPasswordPage.clearFields("password", Password);
		resetPasswordPage.clearFields("confirmPassword", ConfirmPassword);
		resetPasswordPage.setPasswordAndConfirmPassword("password", Password);
		resetPasswordPage.setPasswordAndConfirmPassword("confirmPassword", ConfirmPassword);
		ErrorMsgRegExPasswordInUI = resetPasswordPage.getPasswordErrorMsg("password", "RegExpression");
		Assert.assertTrue("Error Message should be displayed correctly",ErrorMsgRegExPasswordInUI.equals(Constants.INVALID_COMBINATION_ERRORMESSAGE));
		ErrorMsgRegExConfirmPasswordInUI = resetPasswordPage.getPasswordErrorMsg("confirmPassword", "RegExpression");
		Assert.assertTrue("Error Message should be displayed correctly",ErrorMsgRegExConfirmPasswordInUI.equals(Constants.INVALID_COMBINATION_ERRORMESSAGE));
	}

	@Then("^Click on continue Button after Entering valid combination Password and confirm Password$")
	public void click_on_continue_Button_after_Entering_valid_combination_Password_and_confirm_Password(DataTable arg1) throws Throwable {
	  
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String Password = dataMap.get("password");
		String ConfirmPassword = dataMap.get("confirmPassword");
		resetPasswordPage.clearFields("password", Password);
		resetPasswordPage.clearFields("confirmPassword", ConfirmPassword);
		resetPasswordPage.setPasswordAndConfirmPassword("password", Password);
		resetPasswordPage.setPasswordAndConfirmPassword("confirmPassword", ConfirmPassword);
		portalLoginPage = resetPasswordPage.clickContinueButton();
		Assert.assertTrue("Portal Login Page is displayed",portalLoginPage.isDisplayed());
	}

	@Then("^Enter Login Id and new password credentials Portal Home page should be displayed$")
	public void enter_Login_Id_and_new_password_credentials_Portal_Home_page_should_be_displayed(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String Username = dataMap.get("username");
		String Password = dataMap.get("password");
		portalHomePage =portalLoginPage.doLogin(Username,Password);
		Assert.assertTrue("Portal Home Page is displayed",portalHomePage.isDisplayed());
	}
	

 

}
