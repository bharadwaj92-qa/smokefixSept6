package com.alerehealth.ui.stepdefenitions;


import java.sql.Timestamp;
import java.util.HashMap;

import org.junit.Assert;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.TOUPage;
import com.alerehealth.ui.portal.qfl.InterventionConfirmationPage;
import com.alerehealth.ui.portal.qfl.InterventionSelectionPage;
import com.alerehealth.ui.portal.qfl.NRTMedicationOrderPage;
import com.alerehealth.ui.portal.qfl.QFLInterventions;
import com.alerehealth.ui.portal.qfl.QFLStartupPage;
import com.alerehealth.ui.portal.qfl.SaveContactInfoPage;
import com.alerehealth.ui.portal.qfl.ServiceSelectionPage;
import com.alerehealth.ui.portal.registration.CreateLoginIDPage;
import com.alerehealth.ui.portal.settings.YourProgramPage;
import com.alerehealth.ui.portal.settings.CommunicationsPage;
import com.alerehealth.ui.portal.settings.SettingsBasePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ProgramUpgradeStepDef {
	
	
	CreateLoginIDPage createLoginIDPage=null;
    TOUPage touPage = null;
    InterventionConfirmationPage interventionConfirmationPage =null;
    SaveContactInfoPage saveContactInfoPage =null;
    public static ActionPlanQuestionnairePage actionPlanQuestionnairePage =null;
    PortalHomePage portalHomePage =null;
    NRTMedicationOrderPage nrtMedicationOrder = null;
    YourProgramPage yourProgramPage = null;
    SettingsBasePage settingsBasePage = null;
    ServiceSelectionPage serviceSelectionPage = null;
    InterventionSelectionPage interventionSelectionPage = null;
    QFLStartupPage qflStartupPage = null;
    CommunicationsPage communicationsPage = null;
    
    String programEnrolledInUI;
    String textQuitContentInUI;

    String AddressLine1Label= ClientConfiguration.getClientConfiguration().getAddressLine1Label();
    String AddressLine1Value=ClientConfiguration.getClientConfiguration().getAddressLine1Value();
    String CityLabel=ClientConfiguration.getClientConfiguration().getCityLabel();
    String CityValue=ClientConfiguration.getClientConfiguration().getCityValue();
    String StateLabel=ClientConfiguration.getClientConfiguration().getStateLabel();
    String StateValue=ClientConfiguration.getClientConfiguration().getStateValue();
    String ZipCodeLabel=ClientConfiguration.getClientConfiguration().getZipCodeLabel();
    String ZipCodeValue=ClientConfiguration.getClientConfiguration().getZipCodeValue();
    String PrimaryPhonePrefixLabel=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixLabel();
    String PrimaryPhonePrefixValue=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixValue();

   
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@When("^User fills Create your Login ID section details and click on accept TOU page$")
	public void user_fills_Create_your_Login_ID_section_details_and_click_on_accept_TOU_page(DataTable arg1) throws Throwable {
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
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
	        createLoginIDPage = new CreateLoginIDPage();
	        touPage = createLoginIDPage.fillLoginIDForm(loginID+""+timestamp.getTime()+""+"@gn.com", password, confirmPassword, securityQuestion1, answer1, hint1, securityQuestion2, answer2, hint2,securityQuestion3, answer3, hint3);
	        interventionConfirmationPage = touPage.accpetTermsAndNavigateToInterventionConfirmationScreen();
	        saveContactInfoPage = interventionConfirmationPage.clickContinueButton();
	        Assert.assertTrue("Contact Info Page is displayed",saveContactInfoPage.isDisplayed());
		
	}
	
	
	@When("^User enters Contact Info details click on continue Button$")
	public void user_enters_Contact_Info_details_click_on_continue_Button(DataTable arg1) throws Throwable {
	  
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
	

@Then("^User enters Contact Info details such as Address click on continue Button$")
public void user_enters_Contact_Info_details_such_as_Address_click_on_continue_Button() throws Throwable {
    
	 saveContactInfoPage.setTextField(AddressLine1Label, AddressLine1Value);
     saveContactInfoPage.setTextField(CityLabel, CityValue);
     saveContactInfoPage.setTextField(ZipCodeLabel, ZipCodeValue);
     saveContactInfoPage.setTextField(PrimaryPhonePrefixLabel, PrimaryPhonePrefixValue + HelperUtils.getRandomNumber(7));
     
     actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
}

	@Then("^User completes the Individual Enrollment Questionnaire Assessment$")
	public void user_completes_the_Individual_Enrollment_Questionnaire_Assessment(DataTable arg1) throws Throwable {
		
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	     String SheetName = (String) dataMap.get("sheetName");
		ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
        excelReader.setStartRow(1);
        nrtMedicationOrder = actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaireFromExcel(excelReader);

	}
	

@When("^Select No option click on continue Button StopMedication screen should be displayed$")
public void select_No_option_click_on_continue_Button_StopMedication_screen_should_be_displayed() throws Throwable {
	
	nrtMedicationOrder.selectNRTMedication("No");
	nrtMedicationOrder.clickNRTButton("Continue");
}

@Then("^Click on continue Button in pgmcondition and click on Done Button in Options Homepage$")  
public void click_on_continue_Button_in_pgmcondition_and_click_on_Done_Button_in_Options_Homepage() throws Throwable {
	
	yourProgramPage = nrtMedicationOrder.navigateToProgramConditionForIndividual();
	Assert.assertTrue("Your Program Page is displayed", yourProgramPage.isDisplayed());
}

@When("^click on Upgrade Webcoach Button enter Contact Info details$")
public void click_on_Upgrade_Webcoach_Button_enter_Contact_Info_details() throws Throwable {
       
	 saveContactInfoPage = yourProgramPage.clickUpgradeIntervention("Program Website");
	 Assert.assertTrue("Contact Info Page is displayed",saveContactInfoPage.isDisplayed()); 
     actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
}

@When("^Complete Enrollement Questionaire Assessment then select no option click on continue Button$")
public void complete_Enrollement_Questionaire_Assessment_then_select_no_option_click_on_continue_Button(DataTable arg1) throws Throwable {
      
	 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
     String SheetName = (String) dataMap.get("sheetName");
	 ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
     excelReader.setStartRow(1);
     nrtMedicationOrder = actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaireFromExcel(excelReader);
     nrtMedicationOrder.selectNRTMedication("No");
 	nrtMedicationOrder.clickNRTButton("Continue");
 	portalHomePage = nrtMedicationOrder.navigateToPortalHomePageForWebCoach();
 	Assert.assertTrue("PortalHome Page is displayed", portalHomePage.isDisplayed());
}

@When("^Click on settings in portal Homepage and select program from left navigation$")
public void click_on_settings_in_portal_Homepage_and_select_program_from_left_navigation() throws Throwable {
    
	settingsBasePage = portalHomePage.clickSettingsOfUser();
	Assert.assertTrue("Settings Page is displayed", settingsBasePage.isDisplayed());
	yourProgramPage = settingsBasePage.navigateToYourProgramPage();
	Assert.assertTrue("Your Program Page is displayed", yourProgramPage.isDisplayed());
}

@Then("^Validate whether Program confirmation page for enrolled service is displayed$")
public void validate_whether_Program_confirmation_page_for_enrolled_service_is_displayed(DataTable arg1) throws Throwable {
   
	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	 String programEnrolled = (String) dataMap.get("Intervention");
	 programEnrolledInUI = yourProgramPage.getEnrolledPlan();
	 Assert.assertTrue("Program Enrolled is displayed",programEnrolledInUI.contains(programEnrolled) );
	
}

@When("^Click on Upgrade Helpline enter contact info details and complete the enrollment Questionaire$")
public void click_on_Upgrade_Helpline_enter_contact_info_details_and_complete_the_enrollment_Questionaire(DataTable arg1) throws Throwable {
   
	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	 String SheetName = (String) dataMap.get("sheetName");
	saveContactInfoPage = yourProgramPage.clickUpgradeIntervention("Coaching Calls");
	 Assert.assertTrue("Contact Info Page is displayed",saveContactInfoPage.isDisplayed()); 
    actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
    ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
    excelReader.setStartRow(1);
    actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaire(excelReader);
    portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletedButton();
    Assert.assertTrue("Portal Home page is displayed",portalHomePage.isDisplayed() );
    
}

@When("^Click on Upgrade Helpline enter contact info details complete the enrollment Questionaire$")
public void click_on_Upgrade_Helpline_enter_contact_info_details_complete_the_enrollment_Questionaire(DataTable arg1) throws Throwable {
   
	saveContactInfoPage = yourProgramPage.clickUpgradeIntervention("Coaching Calls");
	 Assert.assertTrue("Contact Info Page is displayed",saveContactInfoPage.isDisplayed()); 
	 
	  HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	     String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
      String typeOfPhone = (String) dataMap.get("What type of phone is this?");
      String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
      String timeToCall = (String) dataMap.get("When to Call:");
      
      String SheetName = (String) dataMap.get("sheetName");
      
      saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
      saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
      saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
      saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
	 
    actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
    ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
    excelReader.setStartRow(1);
    actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaire(excelReader);
    portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletedButton();
    
}

@Then("^validate whether TextQuit section is displayed with signup button$")
public void validate_whether_TextQuit_section_is_displayed_with_signup_button() throws Throwable {
     
     settingsBasePage = portalHomePage.clickSettingsOfUser();
    
    communicationsPage = settingsBasePage.navigateToCommunicationsPage();
    
    Assert.assertTrue("Communications page is displayed",communicationsPage.isDisplayed());
    
	Assert.assertTrue("Text 2 Quit Section is displayed with signup button",communicationsPage.isText2QuitSectionDisplayed());
	
}

@Then("^validate whether TextQuit section is displayed with update button$")
public void validate_whether_TextQuit_section_is_displayed_with_update_button(DataTable arg1) throws Throwable {
    
	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	
    String content = (String) dataMap.get("textQuitContent");
    
    settingsBasePage = portalHomePage.clickSettingsOfUser();
    
    communicationsPage = settingsBasePage.navigateToCommunicationsPage();
    
    Assert.assertTrue("Communications page is displayed",communicationsPage.isDisplayed());
     
	textQuitContentInUI = communicationsPage.getTextQuitContentAfterEnroll();
	
	Assert.assertTrue("Text Quit content displayed correctly",textQuitContentInUI.contains(content));
	
	Assert.assertTrue("In Text2Quit section update btn is displayed",communicationsPage.isTextQuitUpdateBtnDisplayed());
	
	
}


@When("^User selects \"([^\"]*)\" Intervention$")
public void user_selects_Intervention(String arg1) throws Throwable {
    
	qflStartupPage = new QFLStartupPage();
	interventionSelectionPage = qflStartupPage.clickSignUp();
	serviceSelectionPage = interventionSelectionPage.chooseIndividualIntervention(QFLInterventions.IndividualServices);
	
}

@When("^Select Email service click on continue Button$")
public void select_Email_service_click_on_continue_Button() throws Throwable {
    
	serviceSelectionPage.selectService("Email Program");
	serviceSelectionPage.clickSelectionContinueButton("Continue");
	
}

@Then("^validate Notice of Email communication page accept checkbox already checked$")
public void validate_Notice_of_Email_communication_page_accept_checkbox_already_checked() throws Throwable {
   
	Assert.assertTrue("Accept checkbox is checked", serviceSelectionPage.isAcceptChechBoxSelected());
}

@When("^Select all services except Email service click on continue Button$")
public void select_all_services_except_Email_service_click_on_continue_Button() throws Throwable {
    
	serviceSelectionPage.selectService("Text2Quit");
	serviceSelectionPage.selectService("Medications");
	serviceSelectionPage.selectService("Welcome Kit");
	serviceSelectionPage.clickSelectionContinueButton("Continue");
}

@Then("^validate Notice of Email communication page accept checkbox is not checked$")
public void validate_Notice_of_Email_communication_page_accept_checkbox_is_not_checked() throws Throwable {
    
	Assert.assertFalse("Accept checkbox is checked", serviceSelectionPage.isAcceptChechBoxSelected());
}


}
