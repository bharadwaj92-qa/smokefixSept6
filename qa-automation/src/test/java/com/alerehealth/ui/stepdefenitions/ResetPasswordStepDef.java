package com.alerehealth.ui.stepdefenitions;

import java.sql.Timestamp;
import java.util.HashMap;

import org.junit.Assert;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.Constants;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.common.pages.AboutYouSignUpPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.common.pages.TOUPage;
import com.alerehealth.ui.portal.qfl.InterventionConfirmationPage;
import com.alerehealth.ui.portal.qfl.QFLStartupPage;
import com.alerehealth.ui.portal.qfl.SaveContactInfoPage;
import com.alerehealth.ui.portal.registration.CreateLoginIDPage;
import com.alerehealth.ui.portal.settings.IdAndPasswordPage;
import com.alerehealth.ui.portal.settings.SettingsBasePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ResetPasswordStepDef {
	
	 QFLStartupPage qflStartupPage=null;
	 PortalLoginPage portalLoginPage =null;
	 PortalHomePage portalHomePage =null;
	 SettingsBasePage settingsBasePage = null;
	 IdAndPasswordPage idAndPasswordPage =null;
	 CreateLoginIDPage createLoginIDPage = null;
	 AboutYouSignUpPage aboutYouSignUpPage=null;
	    TOUPage touPage = null;
	    InterventionConfirmationPage interventionConfirmationPage =null;
	    SaveContactInfoPage saveContactInfoPage =null;
	    ActionPlanQuestionnairePage actionPlanQuestionnairePage =null;
	    
	    String emailIdGenerated;
	 
	 String regexErrorMsgInUI;
	 
	 String emptyDataErrorMsgInUI;
	 
	 String notIdenticalErrorMsgInUI;
	 
	 
	    String AddressLine1Label= ClientConfiguration.getClientConfiguration().getAddressLine1Label();
	    String AddressLine1Value=ClientConfiguration.getClientConfiguration().getAddressLine1Value();
	    String CityLabel=ClientConfiguration.getClientConfiguration().getCityLabel();
	    String CityValue=ClientConfiguration.getClientConfiguration().getCityValue();
	    String ZipCodeLabel=ClientConfiguration.getClientConfiguration().getZipCodeLabel();
	    String ZipCodeValue=ClientConfiguration.getClientConfiguration().getZipCodeValue();
	    String PrimaryPhonePrefixLabel=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixLabel();
	    String PrimaryPhonePrefixValue=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixValue();

	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    
	 
	@Given("^Login to AlerePortal using userName and password it should be navigated to Portal Home Page$")
	public void login_to_AlerePortal_using_userName_and_password_it_should_be_navigated_to_Portal_Home_Page(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		qflStartupPage = new QFLStartupPage();
		portalLoginPage = qflStartupPage.clickLoginLink();
		String Username = dataMap.get("username");
		String Password = dataMap.get("password");
		portalHomePage =portalLoginPage.doLogin(Username,Password);
		Assert.assertTrue("Portal Home Page is displayed",portalHomePage.isDisplayed());
		
	}

	@Given("^Click on ID and Password Link in settings it should display change Password Button$")
	public void click_on_ID_and_Password_Link_in_settings_it_should_display_change_Password_Button() throws Throwable {
	    
		settingsBasePage = portalHomePage.clickSettingsOfUser();
		idAndPasswordPage = settingsBasePage.navigateToIDandPasswordPage();
        Assert.assertTrue("Id and Password page is displayed",idAndPasswordPage.isDisplayed());
	}

	@When("^Click on Change Password Button it should navigate to Change Password screen$")
	public void click_on_Change_Password_Button_it_should_navigate_to_Change_Password_screen() throws Throwable {
	  
		idAndPasswordPage.clickChangeButton("PASSWORD");
		Assert.assertTrue("Change Password Title is displayed",idAndPasswordPage.isChangePasswordDisplayed());
	}

	@When("^Validate all fields and Buttons are present in Change Password Screen$")
	public void validate_all_fields_and_Buttons_are_present_in_Change_Password_Screen() throws Throwable {
	    
		Assert.assertTrue(idAndPasswordPage.isPasswordQuestionFieldDisplayed("currentPassword"));
		Assert.assertTrue(idAndPasswordPage.isPasswordQuestionFieldDisplayed("NewPassword"));
		Assert.assertTrue(idAndPasswordPage.isPasswordQuestionFieldDisplayed("confirmNewPassword"));
		Assert.assertTrue(idAndPasswordPage.isPasswordQuestionFieldDisplayed("question1"));
		Assert.assertTrue(idAndPasswordPage.isPasswordQuestionFieldDisplayed("question2"));
		Assert.assertTrue(idAndPasswordPage.isPasswordQuestionFieldDisplayed("question3"));
		Assert.assertTrue(idAndPasswordPage.isSaveChangesButtonDisplayed());
		Assert.assertTrue(idAndPasswordPage.isCancelButtonDisplayed());
	}

	@When("^Error msgs should be displayed for empty data, invalid combination and not identical$")
	public void error_msgs_should_be_displayed_for_empty_data_invalid_combination_and_not_identical(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String invalidNewPassword = dataMap.get("NewPasswordInvalid");
		String currentPassword = dataMap.get("CurrentPassword");
		String newPassword = dataMap.get("NewPassword");
		String ConfirmNewPasswordNotIdentical = dataMap.get("ConfirmNewPasswordNotIdentical");
		idAndPasswordPage.clickSaveChangesButton();
		emptyDataErrorMsgInUI=idAndPasswordPage.getErrorMessageInChangePassword("CURRENTPASSWORDEMPTY");
		Assert.assertTrue("Error Message should be displayed correctly",emptyDataErrorMsgInUI.equals(Constants.CURRENT_PASSWORD_EMPTY_ERRORMSG));
		emptyDataErrorMsgInUI =idAndPasswordPage.getErrorMessageInChangePassword("NEWPASSWORDEMPTY");
		Assert.assertTrue("Error Message should be displayed correctly",emptyDataErrorMsgInUI.equals(Constants.NEW_PASSWORD_EMPTY_ERRORMSG));
		idAndPasswordPage.setPassword("CurrentPassword", currentPassword);
		idAndPasswordPage.setPassword("NEWPASSWORD", invalidNewPassword);
		regexErrorMsgInUI =idAndPasswordPage.getErrorMessageInChangePassword("NEWPASSWORDREGEX");
		Assert.assertTrue("Error Message should be displayed correctly",regexErrorMsgInUI.equals(Constants.CHANGE_PASSWORS_REGEX_ERRORMSG));
		idAndPasswordPage.clearFields("NEWPASSWORD");
		idAndPasswordPage.setPassword("NEWPASSWORD", newPassword);
		idAndPasswordPage.setPassword("CONFIRMNEWPASSWORD", ConfirmNewPasswordNotIdentical);
		notIdenticalErrorMsgInUI = idAndPasswordPage.getErrorMessageInChangePassword("PASSWORDIDENTICAL");
		Assert.assertTrue("Error Message should be displayed correctly",notIdenticalErrorMsgInUI.equals(Constants.CHANGE_PASSWORD_NOTIDENTICAL_ERRORMSG));
	}

	@When("^enter current password, new password ,confirm new password then click on Save changes Button$")
	public void enter_current_password_new_password_confirm_new_password_then_click_on_Save_changes_Button(DataTable arg1) throws Throwable {
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String currentPassword = dataMap.get("CurrentPassword");
		String newPassword = dataMap.get("NewPassword");
		String ConfirmNewPassword = dataMap.get("ConfirmNewPassword");
		idAndPasswordPage.clearFields("CURRENTPASSWORD");
		idAndPasswordPage.clearFields("NEWPASSWORD");
		idAndPasswordPage.clearFields("CONFIRMNEWPASSWORD");
		idAndPasswordPage.setPassword("CurrentPassword", currentPassword);
		idAndPasswordPage.setPassword("NEWPASSWORD", newPassword);
		idAndPasswordPage.setPassword("CONFIRMNEWPASSWORD", ConfirmNewPassword);
		idAndPasswordPage.clickSaveChangesButton();
		
	}

	@Then("^click on Signout and enter valid login credentials with changed Password which should be accepted$")
	public void click_on_Signout_and_enter_valid_login_credentials_with_changed_Password_which_should_be_accepted(DataTable arg1) throws Throwable {
		
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		qflStartupPage=idAndPasswordPage.clickSignoutButton();
		portalLoginPage = qflStartupPage.clickLoginLink();
		String Password = dataMap.get("password");
		
		portalHomePage =portalLoginPage.doLogin(emailIdGenerated,Password);
		Assert.assertTrue("Portal Home Page is displayed",portalHomePage.isDisplayed());

	}
	
	@Given("^User fills About You Section  and fills Create your LoginID section click Continue Button to navigate to TOU page$")
	public void user_fills_About_You_Section_and_fills_Create_your_LoginID_section_click_Continue_Button_to_navigate_to_TOU_page(DataTable arg1) throws Throwable {
      
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
    	Thread.sleep(5000);
    	String firstName = dataMap.get("firstName");
    	String lastName = dataMap.get("lastName");
    	String gender = dataMap.get("gender");
    	String dob = dataMap.get("dob");
    	String zipCode = dataMap.get("zipcode");
    	String loginID = (String) dataMap.get("loginID");
        String password = (String) dataMap.get("password");
        String confirmPassword = (String) dataMap.get("confirmpwd");
        String securityQuestion1 = (String) dataMap.get("securityque1");
        String answer1 = (String) dataMap.get("securityans1");
        String hint1 = (String) dataMap.get("securityhint1");
        String securityQuestion2 = (String) dataMap.get("securityque2");
        String answer2 = (String) dataMap.get("securityans2");
        String hint2 = (String) dataMap.get("securityhint2");
        String securityQuestion3 = (String) dataMap.get("securityque3");
        String answer3 = (String) dataMap.get("securityans3");
        String hint3 = (String) dataMap.get("securityhint3");
        aboutYouSignUpPage = new AboutYouSignUpPage();
        createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormState(firstName+timestamp.getTime(),lastName, gender, dob, zipCode);
        emailIdGenerated=loginID+""+timestamp.getTime()+""+"@gn.com";
        System.out.println("User Email ID is: " + loginID+""+timestamp.getTime()+""+"@gn.com");
        touPage = createLoginIDPage.fillLoginIDForm(loginID+""+timestamp.getTime()+""+"@gn.com", password, confirmPassword, securityQuestion1, answer1, hint1, securityQuestion2, answer2, hint2,securityQuestion3, answer3, hint3);
        interventionConfirmationPage = touPage.accpetTermsAndNavigateToInterventionConfirmationScreen();
        saveContactInfoPage = interventionConfirmationPage.clickContinueButton();
	}
	
	@Given("^User enters HelpLine Contact Info details, completes the Helpline Intervention$")
	public void user_enters_HelpLine_Contact_Info_details_completes_the_Helpline_Intervention(DataTable arg1) throws Throwable {
		
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
        String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
        String typeOfPhone = (String) dataMap.get("What type of phone is this?");
        String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
        String timeToCall = (String) dataMap.get("When to Call:");

        saveContactInfoPage.setTextField(AddressLine1Label, AddressLine1Value);
        saveContactInfoPage.setTextField(CityLabel, CityValue);
        saveContactInfoPage.setTextField(ZipCodeLabel, ZipCodeValue);
        saveContactInfoPage.setTextField(PrimaryPhonePrefixLabel, PrimaryPhonePrefixValue + HelperUtils.getRandomNumber(7));
        
        saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
        saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
        saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
        saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
        
        actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
        
        String SheetName = (String) dataMap.get("sheetName");
  	    ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
        excelReader.setStartRow(1);
        actionPlanQuestionnairePage.answerEnrollmentQuestionnaire(excelReader);
        portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletionButton();
        Assert.assertTrue("Portal Home page is displayed",portalHomePage.isDisplayed());
	}


}
