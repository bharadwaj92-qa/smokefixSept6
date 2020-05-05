package com.alerehealth.ui.stepdefenitions;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.fwk.db.ConnectionManager;
import com.alerehealth.fwk.db.DBDataFetcher;
import com.alerehealth.fwk.db.JDBCConnector;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.common.pages.AboutYouSignUpPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;
import com.alerehealth.ui.portal.common.pages.TOUPage;
import com.alerehealth.ui.portal.qfl.InterventionConfirmationPage;
import com.alerehealth.ui.portal.qfl.InterventionSelectionPage;
import com.alerehealth.ui.portal.qfl.QFLInterventions;
import com.alerehealth.ui.portal.qfl.QFLPreSignupPage;
import com.alerehealth.ui.portal.qfl.QFLStartupPage;
import com.alerehealth.ui.portal.qfl.SaveContactInfoPage;
import com.alerehealth.ui.portal.qfl.ServiceSelectionPage;
import com.alerehealth.ui.portal.registration.CreateLoginIDPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QflProgramStepDef {
	
	QFLStartupPage qflStartupPage = null;
	QFLPreSignupPage qflPreSignupPage = null;
	SignUpPage signUpPage=null;
	 AboutYouSignUpPage aboutYouSignUpPage=null;
	    CreateLoginIDPage createLoginIDPage=null;
	    TOUPage touPage = null;
	    InterventionConfirmationPage interventionConfirmationPage =null;
	    SaveContactInfoPage saveContactInfoPage =null;
	    ActionPlanQuestionnairePage actionPlanQuestionnairePage =null;
	    PortalHomePage portalHomePage =null;
	    InterventionSelectionPage interventionSelectionPage = null;
	    
	   
		 
		 String programStatusIdActual;
		 
		 String participantAnswerFromDB;
		 
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
	    
	    String participantID;
	
	@When("^User selects Role and Click on Continue Button$")
	public void user_selects_Role_and_Click_on_Continue_Button() throws Throwable {
		
		qflStartupPage = new QFLStartupPage();
		signUpPage = qflStartupPage.clickSignUpLink();
		signUpPage.selectRole("as a Member");
		aboutYouSignUpPage = signUpPage.clickContinueBtn();
	}

	@When("^User fills insurance card info and Click on Continue Button$")
	public void user_fills_insurance_card_info_and_Click_on_Continue_Button(DataTable arg1) throws Throwable {
	  
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String firstName = dataMap.get("firstName");
    	String lastName = dataMap.get("lastName");
    	String dob = dataMap.get("dob");
    	String groupnumber = dataMap.get("groupNumber");
    	String subscriberid = dataMap.get("subscriberId");
    	createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormClient(firstName+timestamp.getTime(), lastName, dob, groupnumber, subscriberid);
		
	}
	
	@When("^User fills Create your Login ID section click on Continue Button to navigate to TOU page$")
	public void user_fills_Create_your_Login_ID_section_click_on_Continue_Button_to_navigate_to_TOU_page(DataTable arg1) throws Throwable {
	   
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
	        touPage = createLoginIDPage.fillLoginIDForm(loginID+""+timestamp.getTime()+""+"@gn.com", password, confirmPassword, securityQuestion1, answer1, hint1, securityQuestion2, answer2, hint2,securityQuestion3, answer3, hint3);
	        saveContactInfoPage = touPage.acceptTermsAndNavigateToContactInfoPage();
	       
	}
	
	@When("^User enters Contact Info details and click on continue Button$")
	public void user_enters_Contact_Info_details_and_click_on_continue_Button(DataTable arg1) throws Throwable {
	  
		     HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		     String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
	         String typeOfPhone = (String) dataMap.get("What type of phone is this?");
	         String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
	         String timeToCall = (String) dataMap.get("When to Call:");
	         
	         saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
             saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
             saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
             saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
             
             actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
	}

	@Then("^program status should be displayed in DB for the participant$")
	public void program_status_should_be_displayed_in_DB_for_the_participant(DataTable arg1) throws Throwable {
		
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	    String programIDExpected = dataMap.get("programID");
	    
		programStatusIdActual = portalHomePage.validateProgramStatusFromDB();
		
		Assert.assertTrue("Program ID is enrolled as expected", programStatusIdActual.contains(programIDExpected) );
		
		participantAnswerFromDB = portalHomePage.validateParticipantAnswerFromDB();
		
		System.out.println(participantAnswerFromDB);
		
	
	}
	
	@When("^User navigate to PreSignup page and answer all questions click continue Button$")
	public void user_navigate_to_PreSignup_page_and_answer_all_questions_click_continue_Button(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	    String  companySponsered = dataMap.get("companySponsered");
	    String  benefitEligible = dataMap.get("benefitEligible");
	    String  unionEmployee = dataMap.get("union employee");
	    String  contractEmployee = dataMap.get("contract employee");
		qflStartupPage = new QFLStartupPage();
		qflPreSignupPage = qflStartupPage.clickSignUpBtn();
		
		qflPreSignupPage.selectRadioButton("company", companySponsered);
		qflPreSignupPage.selectRadioButton("benefit", benefitEligible);
		qflPreSignupPage.selectRadioButton("Union", unionEmployee);
		qflPreSignupPage.selectRadioButton("Contract", contractEmployee);
		signUpPage = qflPreSignupPage.clickContinueBtn();
	}

	@When("^User selects  language , Role and Click on Continue Button$")
	public void user_selects_language_Role_and_Click_on_Continue_Button() throws Throwable {

		aboutYouSignUpPage = signUpPage.fillSignUpForm("english", "as an Employee");
		aboutYouSignUpPage = signUpPage.clickContinueBtn();
	}
	
	@When("^User enters Contact Info details such as country residence and click on continue Button$")
	public void user_enters_Contact_Info_details_such_as_country_residence_and_click_on_continue_Button(DataTable arg1) throws Throwable {
	  
		     HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		     
		     String countryResidence = (String) dataMap.get("CountryResidence");
		     String countryCode = (String) dataMap.get("Country code");
		     String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
	         String typeOfPhone = (String) dataMap.get("What type of phone is this?");
	         String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
	         String timeToCall = (String) dataMap.get("When to Call:");
	         
	         saveContactInfoPage.selectDropDown("Country of Residence:", countryResidence);
	         saveContactInfoPage.selectDropDown("Country Code:", countryCode);
	         saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
             saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
             saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
             saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
             
             actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
	}
	

	
	@Given("^User Navigate to QFL commercial Client URL$")
	public void user_Navigate_to_QFL_commercial_Client_URL() throws Throwable {
	   
		qflStartupPage = new QFLStartupPage();
		
	}

	@When("^User selects  language and Click on Continue Button$")
	public void user_selects_language_and_Click_on_Continue_Button(DataTable arg1) throws Throwable {
	    
		signUpPage = qflStartupPage.clickSignUpLink();
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
         String language = (String) dataMap.get("language");
         aboutYouSignUpPage = signUpPage.fillSignUpForm(language);
	}

	@When("^User fills details  and Click on Continue Button$")
	public void user_fills_details_and_Click_on_Continue_Button(DataTable arg1) throws Throwable {
	    
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
    	Thread.sleep(5000);
    	String firstName = dataMap.get("firstName");
    	String lastName = dataMap.get("lastName");
    	String gender = dataMap.get("gender");
    	String dob = dataMap.get("dob");
    	String relationship = dataMap.get("relationship");
    	
    	createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormCommercial(firstName+timestamp.getTime(), lastName, gender, dob, relationship);
		
	}
	
	@When("^User fills Create your Login ID section click on Continue Button to navigate to TOU page to accept Terms$")
	public void user_fills_Create_your_Login_ID_section_click_on_Continue_Button_to_navigate_to_TOU_page_to_accept_Terms(DataTable arg1) throws Throwable {
		
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
        saveContactInfoPage = touPage.acceptTermsAndNavigateToContactInfoPage();
	
	}
	

	@Then("^User enters Contact Info details such as Address and click on continue Button$")
	public void user_enters_Contact_Info_details_such_as_Address_and_click_on_continue_Button(DataTable arg1) throws Throwable {
	
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		String State = (String) dataMap.get("state");
        String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
        String typeOfPhone = (String) dataMap.get("What type of phone is this?");
        String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
        String timeToCall = (String) dataMap.get("When to Call:");

        saveContactInfoPage.setTextField(AddressLine1Label, AddressLine1Value);
        saveContactInfoPage.setTextField(CityLabel, CityValue);
        saveContactInfoPage.selectDropDown("State", State);
        saveContactInfoPage.setTextField(ZipCodeLabel, ZipCodeValue);
        saveContactInfoPage.setTextField(PrimaryPhonePrefixLabel, PrimaryPhonePrefixValue + HelperUtils.getRandomNumber(7));
        
        saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
        saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
        saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
        saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
        
        actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
	}
	
	
	@Then("^User completes Enrollment Questionnaire for Commercial Client$")
	public void user_completes_Enrollment_Questionnaire_for_Commercial_Client(DataTable arg1) throws Throwable {
	 
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String SheetName = (String) dataMap.get("sheetName");
		 ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
		    excelReader.setStartRow(1);
		    actionPlanQuestionnairePage.answerEnrollmentQuestionnaire(excelReader);
	        portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletionButton();
	}
	
	
	@When("^User navigate to PreSignup page and answer the question click continue Button$")
	public void user_navigate_to_PreSignup_page_and_answer_the_question_click_continue_Button(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	    String  ageValue = dataMap.get("Are you 18years of age or older");
	    qflStartupPage = new QFLStartupPage();
		qflPreSignupPage = qflStartupPage.clickSignUpBtn();
		
		qflPreSignupPage.selectRadioButton("Are you 18 years of age or older? ", ageValue);
		
		signUpPage = qflPreSignupPage.clickContinueBtn();
	}
	
	
	@When("^User navigate to PreSignup page answer the question click continue Button$")
	public void user_navigate_to_PreSignup_page_answer_the_question_click_continue_Button(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	    String  ageValue = dataMap.get("Are you 18years of age or older");
	    String healthInsurance = dataMap.get("Do you have Health Insurance");
	    String healthPlan = dataMap.get("What Health plan do you have");
	    String   tobaccoCounselling  = dataMap.get("Do you have access to Tobacco Cessation Counselling");
	    String nicotineTherapy = dataMap.get("Do you have access to Nicotine Replacement Therapy");
	    
	    qflStartupPage = new QFLStartupPage();
		qflPreSignupPage = qflStartupPage.clickSignUpBtn();
		
		qflPreSignupPage.selectRadioButton("Are you 18 years of age or older? ", ageValue);
		qflPreSignupPage.selectRadioButton("Do you have Health Insurance through the state? ", healthInsurance);
		qflPreSignupPage.selectDropdown("What health insurance or health plan do you have? ", healthPlan);
		qflPreSignupPage.selectRadioButton("Do you have access to Tobacco Cessation Counseling through your health plan? ", tobaccoCounselling);
		qflPreSignupPage.selectDropdown("Do you have access to Nicotine Replacement Therapy ", nicotineTherapy);
		
		signUpPage = qflPreSignupPage.clickContinueBtn();
	}
	
	@When("^User selects  language Click on Continue Button$")
	public void user_selects_language_Click_on_Continue_Button(DataTable arg1) throws Throwable {
	    
		
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
         String language = (String) dataMap.get("language");
         aboutYouSignUpPage = signUpPage.fillSignUpForm(language);
	}

	@When("^User fills details Click on Continue Button$")
	public void user_fills_details_Click_on_Continue_Button(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
    	Thread.sleep(5000);
    	String firstName = dataMap.get("firstName");
    	String lastName = dataMap.get("lastName");
    	String gender = dataMap.get("gender");
    	String dob = dataMap.get("dob");
    	String zipCode = dataMap.get("zipcode");
    	
    	createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormState(firstName+timestamp.getTime(), lastName, gender, dob, zipCode);
	}
	
	@Then("^User enters the Contact Info details such as Address and click on continue Button$")
	public void user_enters_the_Contact_Info_details_such_as_Address_and_click_on_continue_Button(DataTable arg1) throws Throwable {
	
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

	@Then("^User completes the Enrollment Questionnaire Assessment for Female pregnant participant age less than eighteen$")
	public void user_completes_the_Enrollment_Questionnaire_Assessment_for_Female_pregnant_participant_age_less_than_eighteen(DataTable arg1) throws Throwable {
	     
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String SheetName = (String) dataMap.get("sheetName");
		 ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
		    excelReader.setStartRow(1);
		    actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaire(excelReader);
	        portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletionButton();
		    Assert.assertTrue("Portal Home page is displayed",portalHomePage.isDisplayed());
		
	}

	@Then("^User completes the Enrollment Questionnaire Assessment for Participant$")
	public void user_completes_the_Enrollment_Questionnaire_Assessment_for_Participant(DataTable arg1) throws Throwable {
	     
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String SheetName = (String) dataMap.get("sheetName");
		 ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
		    excelReader.setStartRow(1);
		    actionPlanQuestionnairePage.answerMultipleEnrollmentQuestionnaire(excelReader);
	        portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletionButton();
		    Assert.assertTrue("Portal Home page is displayed",portalHomePage.isDisplayed());
		
	}
	
	
	@Then("^User completes the Enrollment Questionnaire Assessment for this client$")
	public void user_completes_the_Enrollment_Questionnaire_Assessment_for_this_client(DataTable arg1) throws Throwable {
	   
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
		 String SheetName = (String) dataMap.get("sheetName");
		 ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",SheetName);
        excelReader.setStartRow(1);
        actionPlanQuestionnairePage.answerEnrollmentQuestionnaire(excelReader);
        portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletedButton();
	}
	
	
	@When("^User navigate to PreSignup page and answer the question click continue Button should navigate to Intervention page$")
	public void user_navigate_to_PreSignup_page_and_answer_the_question_click_continue_Button_should_navigate_to_Intervention_page(DataTable arg1) throws Throwable {
	    

		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
	    String  companyEmployer = dataMap.get("Who is your employer?");
	    String healthInsurance = dataMap.get("What health insurance or health plan do you have?");
	    
	    qflStartupPage = new QFLStartupPage();
	    qflPreSignupPage = qflStartupPage.clickSignUpBtn();
	    qflPreSignupPage.selectDropdown("Who is your employer?", companyEmployer);
		qflPreSignupPage.selectDropdown("What health insurance or health plan do you have?", healthInsurance);
		interventionSelectionPage = qflPreSignupPage.clickContinueButton();
	    
	    
	}

	@When("^User selects All Access Intervention and proceed$")
	public void user_selects_All_Access_Intervention_and_proceed() throws Throwable {

		signUpPage = interventionSelectionPage.chooseIntervention(QFLInterventions.AllAccess);
	}
	
	@When("^User fills About you details and Click on Continue Button$")
	public void user_fills_About_you_details_and_Click_on_Continue_Button(DataTable arg1) throws Throwable {
		
		HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);
    	Thread.sleep(5000);
    	String firstName = dataMap.get("firstName");
    	String lastName = dataMap.get("lastName");
    	String gender = dataMap.get("gender");
    	String dob = dataMap.get("dob");
    	
    	
    	createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormForKeyCode(firstName+timestamp.getTime(), lastName,gender, dob);
   
	}
	


     
}
