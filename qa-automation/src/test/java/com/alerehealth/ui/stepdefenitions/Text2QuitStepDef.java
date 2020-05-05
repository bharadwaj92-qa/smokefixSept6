package com.alerehealth.ui.stepdefenitions;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.fwk.excel.ExcelReader;

import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;

import com.alerehealth.ui.portal.common.pages.AboutYouSignUpPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;
import com.alerehealth.ui.portal.common.pages.TOUPage;
import com.alerehealth.ui.portal.qfl.InterventionConfirmationPage;

import com.alerehealth.ui.portal.qfl.SaveContactInfoPage;

import com.alerehealth.ui.portal.registration.CreateLoginIDPage;
import com.alerehealth.ui.portal.settings.CommunicationsPage;
import com.alerehealth.ui.portal.settings.SettingsBasePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Text2QuitStepDef{
	
	
	    SignUpPage signUpPage=null;
	    AboutYouSignUpPage aboutYouSignUpPage=null;
	    CreateLoginIDPage createLoginIDPage = null;
	    TOUPage touPage = null;
	    InterventionConfirmationPage interventionConfirmationPage =null;
	    public static SaveContactInfoPage saveContactInfoPage =null;
	    ActionPlanQuestionnairePage actionPlanQuestionnairePage =null;
	    public static PortalHomePage portalHomePage =null;
	    SettingsBasePage settingsBasePage = null;
	    CommunicationsPage communicationsPage = null;
	    
	    String textQuitContentInUI;
	    
	    
	    
	    String AddressLine1Label= ClientConfiguration.getClientConfiguration().getAddressLine1Label();
	    String AddressLine1Value=ClientConfiguration.getClientConfiguration().getAddressLine1Value();
	    String CityLabel=ClientConfiguration.getClientConfiguration().getCityLabel();
	    String CityValue=ClientConfiguration.getClientConfiguration().getCityValue();
	    String ZipCodeLabel=ClientConfiguration.getClientConfiguration().getZipCodeLabel();
	    String ZipCodeValue=ClientConfiguration.getClientConfiguration().getZipCodeValue();
	    String PrimaryPhonePrefixLabel=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixLabel();
	    String PrimaryPhonePrefixValue=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixValue();

	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    
	    
	    @When("^User selects language options and Click on Continue Button$")
	    public void user_selects_language_options_and_Click_on_Continue_Button(DataTable arg1) throws Throwable {
	          
	    	signUpPage = new SignUpPage();
	    	  Map dataMap = (Map) arg1.asMap(String.class, String.class);
	          String language = (String) dataMap.get("language");
	          aboutYouSignUpPage = signUpPage.fillSignUpForm(language);
	    }
	    
	    @When("^User fills About You Section and Click on Continue Button$")
	    public void user_fills_About_You_Section_and_Click_on_Continue_Button(DataTable arg1) throws Throwable {
	      
	    	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	    	Thread.sleep(5000);
	    	String firstName = dataMap.get("firstName");
	    	String lastName = dataMap.get("lastName");
	    	String gender = dataMap.get("gender");
	    	String dob = dataMap.get("dob");
	    	String zipCode = dataMap.get("zipcode");
	    	
	    	createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormState(firstName+timestamp.getTime(),lastName, gender, dob, zipCode);
	    }

	    @Then("^User fills Create your Login ID section click Continue Button to navigate to TOU page$")
	    public void user_fills_Create_your_Login_ID_section_click_Continue_Button_to_navigate_to_TOU_page(DataTable arg1) throws Throwable {
	        
	    	Map dataMap = (Map) arg1.asMap(String.class, String.class);
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
	        System.out.println("User Email ID is: " + loginID+""+timestamp.getTime()+""+"@gn.com");
	        touPage = createLoginIDPage.fillLoginIDForm(loginID+""+timestamp.getTime()+""+"@gn.com", password, confirmPassword, securityQuestion1, answer1, hint1, securityQuestion2, answer2, hint2,securityQuestion3, answer3, hint3);
	        interventionConfirmationPage = touPage.accpetTermsAndNavigateToInterventionConfirmationScreen();
	        saveContactInfoPage = interventionConfirmationPage.clickContinueButton();
	    }
	    
	    @Then("^User enters HelpLine Contact Info details and click on continue Button$")
	    public void user_enters_HelpLine_Contact_Info_details_and_click_on_continue_Button(DataTable arg1) throws Throwable {
	      
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
	    }
	    
	    @Then("^User completes the HelpLine Intervention Enrollment Questionnaire Assessment$")
	    public void user_completes_the_HelpLine_Intervention_Enrollment_Questionnaire_Assessment(DataTable arg1) throws Throwable {
	          
	    	 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		     String SheetName = (String) dataMap.get("sheetName");
	    	  ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
              excelReader.setStartRow(1);
              actionPlanQuestionnairePage.answerEnrollmentQuestionnaire(excelReader);
              portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletionButton();
              Assert.assertTrue("Portal Home page is displayed",portalHomePage.isDisplayed());

	    }
	    
	   
	    @Then("^Click on Settings in Portal Home page and also click on communications$")
	    public void click_on_Settings_in_Portal_Home_page_and_also_click_on_communications() throws Throwable {
	       
	    	settingsBasePage = portalHomePage.clickSettingsOfUser();
            communicationsPage = settingsBasePage.navigateToCommunicationsPage();
            Assert.assertTrue("Communications page is displayed",communicationsPage.isDisplayed());
    
	    }

	    @Then("^validate whether TextToQuit section is displayed with signup button$")
	    public void validate_whether_TextToQuit_section_is_displayed_with_signup_button() throws Throwable {
	      
	    	 Assert.assertTrue("Text 2 Quit Section is displayed with signup button",communicationsPage.isText2QuitSectionDisplayed());
	    	 communicationsPage.clickSignupButton();
	    }
	    
	    @Then("^click on signupButton to get enrolled in to TextToQuit for Smokers$")
	    public void click_on_signupButton_to_get_enrolled_in_to_TextToQuit_for_Smokers(DataTable arg1) throws Throwable {
	     
	    	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	         String numberOfCigarettes = (String) dataMap.get("How many cigarettes do you smoke per day?");
	         String packsPrice = (String) dataMap.get("How much do you spend on a pack of cigarettes? (USD$)");
	    	
	    	communicationsPage.enterTextFields("NUMBEROFCIGARETTES", numberOfCigarettes);
	    	
	    	communicationsPage.enterTextFields("PACKSPRICE", packsPrice);
	    	
	    	communicationsPage.selectAcceptTermsCheckbox();
	    	
	    	communicationsPage.clickSaveButton();
	   
	    }


	    @Then("^validate whether TextToQuit section is displayed with update button$")
	    public void validate_whether_TextToQuit_section_is_displayed_with_update_button(DataTable arg1) throws Throwable {
	        
	    	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	    	
	        String content = (String) dataMap.get("textQuitContent");
	         
	    	textQuitContentInUI = communicationsPage.getTextQuitContentAfterEnroll();
	    	
	    	Assert.assertTrue("Text Quit content displayed correctly",textQuitContentInUI.contains(content));
	    	
	    	Assert.assertTrue("In Text2Quit section update btn is displayed",communicationsPage.isTextQuitUpdateBtnDisplayed());
	    	
	    	portalHomePage.clickSignOut();
	    }
	
}
