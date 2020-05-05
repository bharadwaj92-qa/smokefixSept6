package com.alerehealth.ui.stepdefenitions;

import java.util.HashMap;

import org.junit.Assert;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;
import com.alerehealth.ui.portal.qfl.InterventionSelectionPage;
import com.alerehealth.ui.portal.qfl.NRTMedicationOrderPage;
import com.alerehealth.ui.portal.qfl.QFLInterventions;
import com.alerehealth.ui.portal.qfl.QFLStartupPage;
import com.alerehealth.ui.portal.qfl.SaveContactInfoPage;
import com.alerehealth.ui.portal.qfl.ServiceSelectionPage;
import com.alerehealth.ui.portal.settings.YourProgramPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationRegressionStepDef {
	
	QFLStartupPage qflStartupPage=null;
	InterventionSelectionPage interventionSelectionPage = null;
	ServiceSelectionPage serviceSelectionPage = null;
	SignUpPage signUpPage = null;
	SaveContactInfoPage saveContactInfoPage = null;
	ActionPlanQuestionnairePage actionPlanQuestionnairePage = null;
	PortalHomePage portalHomePage =null;
	NRTMedicationOrderPage nrtMedicationOrder = null;
	YourProgramPage yourProgramPage = null;
	
	String programEnrolledInUI;
	 
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
   
	@When("^User select More Quit Tools Intervention$")
	public void user_select_More_Quit_Tools_Intervention() throws Throwable {
	    
		qflStartupPage = new QFLStartupPage();
		interventionSelectionPage = qflStartupPage.clickSignUp();
		serviceSelectionPage = interventionSelectionPage.chooseIndividualIntervention(QFLInterventions.MoreQuitTools);
		
	}

	@When("^click on continue Button after selecting only Email Service$")
	public void click_on_continue_Button_after_selecting_only_Email_Service() throws Throwable {
	    
		
		signUpPage = serviceSelectionPage.selectIndividualService("Email Program");
	}
	
	@When("^User enters More Quick Tools Contact Info details and click on continue Button$")
	public void user_enters_More_Quick_Tools_Contact_Info_details_and_click_on_continue_Button() throws Throwable {
	    
		saveContactInfoPage = Text2QuitStepDef.saveContactInfoPage;
		saveContactInfoPage.setTextField(PrimaryPhonePrefixLabel, PrimaryPhonePrefixValue + HelperUtils.getRandomNumber(7));
		actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
	}

	@Then("^User completes the Intervention Enrollment Questionnaire Assessment$")
	public void user_completes_the_Intervention_Enrollment_Questionnaire_Assessment(DataTable arg1) throws Throwable {
	  
		 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	     String SheetName = (String) dataMap.get("sheetName");
    	  ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
          excelReader.setStartRow(1);
          actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaire(excelReader);
          yourProgramPage =  actionPlanQuestionnairePage.clickEnrollCompleteButton();
          Assert.assertTrue("Your Florida Quit Line Program page is displayed",yourProgramPage.isDisplayed());
   
	}
	
	@Then("^Validate Enrolled button which is displayed is disabled for Email Program$")
	public void validate_Enrolled_button_which_is_displayed_is_disabled_for_Email_Program(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
    	 String programEnrolled = (String) dataMap.get("Intervention");
    	 programEnrolledInUI = yourProgramPage.getEnrolledPlan();
    	 Assert.assertTrue("Program Enrolled is displayed",programEnrolledInUI.contains(programEnrolled) );
    	 Assert.assertFalse("Enrolled Button for Email Program is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Email Program"));
    	
    	 
	}
	

@Then("^Click Add Button beside TextQuit Service it should be navigated to Contact Info Page$")
public void click_Add_Button_beside_TextQuit_Service_it_should_be_navigated_to_Contact_Info_Page() throws Throwable {
  
	saveContactInfoPage = yourProgramPage.clickAddThisButton("Text2Quit");
	Assert.assertTrue("Contact Info Page is displayed",saveContactInfoPage.isDisplayed());
	
}

@Then("^Click on Continue Button after entering Contact Info details$")
public void click_on_Continue_Button_after_entering_Contact_Info_Details(DataTable arg1) throws Throwable {
    
	 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
 
  String typeOfPhone = (String) dataMap.get("What type of phone is this?");
  String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
  String timeToCall = (String) dataMap.get("When to Call:");

  saveContactInfoPage.setTextField(AddressLine1Label, AddressLine1Value);
  saveContactInfoPage.setTextField(CityLabel, CityValue);
  saveContactInfoPage.setTextField(ZipCodeLabel, ZipCodeValue);
 
  saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
  saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
  saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
  actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
	
}

@Then("^Validate Enrolled button which is displayed is disabled for TextQuit and Email Program$")
public void validate_Enrolled_button_which_is_displayed_is_disabled_for_TextQuit_and_Email_Program(DataTable arg1) throws Throwable {
  
	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	 String programEnrolled = (String) dataMap.get("Intervention");
	 programEnrolledInUI = yourProgramPage.getEnrolledPlan();
	 Assert.assertTrue("Program Enrolled is displayed",programEnrolledInUI.contains(programEnrolled) );
	 Assert.assertFalse("Enrolled Button for Email Program is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Email Program"));
	 Assert.assertFalse("Enrolled Button for Text2Quit is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Text2Quit"));
}

@Then("^Click on Medications Add this Button enter contact info Details click on continue$")
public void click_on_Medications_Add_this_Button_enter_contact_info_Details_click_on_continue(DataTable arg1) throws Throwable {
    
	 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
     String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
	saveContactInfoPage = yourProgramPage.clickAddThisButton("Medications");
	Assert.assertTrue("Contact Info Page is displayed",saveContactInfoPage.isDisplayed());
	 saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
	 actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
	
}

@Then("^User completes the Medications Intervention Enrollment Questionnaire Assessment$")
public void user_completes_the_Medications_Intervention_Enrollment_Questionnaire_Assessment(DataTable arg1) throws Throwable {
    
	 HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
     String SheetName = (String) dataMap.get("sheetName");
	  ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
      excelReader.setStartRow(1);
      nrtMedicationOrder = actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaireFromExcel(excelReader);
      nrtMedicationOrder.selectNRTMedication("No");
  	  nrtMedicationOrder.clickNRTButton("Continue");
  	  yourProgramPage = nrtMedicationOrder.navigateToProgramConditionForIndividual();
      Assert.assertTrue("Your Florida Quit Line Program page is displayed",yourProgramPage.isDisplayed());
	
}

@Then("^Validate Enrolled button which is displayed is disabled for TextQuit, Email Program , Medications$")
public void validate_Enrolled_button_which_is_displayed_is_disabled_for_TextQuit_Email_Program_Medications(DataTable arg1) throws Throwable {
   
	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	 String programEnrolled = (String) dataMap.get("Intervention");
	 programEnrolledInUI = yourProgramPage.getEnrolledPlan();
	 Assert.assertTrue("Program Enrolled is displayed",programEnrolledInUI.contains(programEnrolled) );
	 Assert.assertFalse("Enrolled Button for Email Program is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Email Program"));
	 Assert.assertFalse("Enrolled Button for Text2Quit is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Text2Quit"));
	 Assert.assertFalse("Enrolled Button for Medications is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Medication"));
	 
}

@Then("^Click on Welcome Kit Add this Button enter contact info Details click on continue$")
public void click_on_Welcome_Kit_Add_this_Button_enter_contact_info_Details_click_on_continue() throws Throwable {
  
	saveContactInfoPage = yourProgramPage.clickAddThisButton("Welcome Kit");
	Assert.assertTrue("Contact Info Page is displayed",saveContactInfoPage.isDisplayed());
	actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
}

@Then("^Validate Enrolled button which is displayed is disabled for TextQuit, Email Program , Medications,WelcomeKit$")
public void validate_Enrolled_button_which_is_displayed_is_disabled_for_TextQuit_Email_Program_Medications_WelcomeKit(DataTable arg1) throws Throwable {
    
	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	 String programEnrolled = (String) dataMap.get("Intervention");
	 programEnrolledInUI = yourProgramPage.getEnrolledPlan();
	 Assert.assertTrue("Program Enrolled is displayed",programEnrolledInUI.contains(programEnrolled) );
	 Assert.assertFalse("Enrolled Button for Email Program is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Email Program"));
	 Assert.assertFalse("Enrolled Button for Text2Quit is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Text2Quit"));
	 Assert.assertFalse("Enrolled Button for Medications is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Medication"));
	 Assert.assertFalse("Enrolled Button for Medications is disabled", yourProgramPage.isServiceEnrolledButtonEnabled("Welcome Kit"));
	 
}

@Then("^Enter Contact info details and click on continue Button$")
public void enter_Contact_info_details_and_click_on_continue_Button(DataTable arg1) throws Throwable {
	HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	 String typeOfPhone = (String) dataMap.get("What type of phone is this?");
	  String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
	  String timeToCall = (String) dataMap.get("When to Call:");
	  String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
	  
	  saveContactInfoPage = Text2QuitStepDef.saveContactInfoPage;
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

@Given("^click on continue Button after selecting all services$")
public void click_on_continue_Button_after_selecting_all_services() throws Throwable {
	
	signUpPage = serviceSelectionPage.selectServices();
}



}
