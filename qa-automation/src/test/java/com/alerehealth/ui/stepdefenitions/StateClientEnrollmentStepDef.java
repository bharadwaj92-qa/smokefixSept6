package com.alerehealth.ui.stepdefenitions;


import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.*;
import com.alerehealth.ui.portal.common.pages.*;
import com.alerehealth.ui.portal.qfl.*;
import com.alerehealth.ui.portal.registration.CreateLoginIDPage;
import java.sql.Timestamp;
import java.util.Map;

public class StateClientEnrollmentStepDef {

    QFLStartupPage qflStartupPage=null;
    InterventionSelectionPage interventionSelectionPage=null;
    SignUpPage signUpPage=null;
    AboutYouSignUpPage aboutYouSignUpPage=null;
    CreateLoginIDPage createLoginIDPage=null;
    TOUPage touPage = null;
    InterventionConfirmationPage interventionConfirmationPage =null;
    SaveContactInfoPage saveContactInfoPage =null;
    ActionPlanQuestionnairePage actionPlanQuestionnairePage =null;
    PortalHomePage portalHomePage =null;
    ManageGoalsPage manageGoalsPage =null;
    ActionPlanSetYourGoal actionPlanSetYourGoal=null;
    GoalDeadLineSelectionPage goalDeadLineSelectionPage=null;
    ServiceSelectionPage serviceSelectionPage =null;
    NRTMedicationOrderPage nrtMedicationOrder = null;
    ActionPlanBannerPage actionPlanBannerPage =null;
    NRTMedicationOrderViaActionPlan nrtMedicationOrderViaActionPlan=null;

    String ClientType=ClientConfiguration.getClientConfiguration().getClientType();
    String FirstName=ClientConfiguration.getClientConfiguration().getFirstName();
    String LastName=ClientConfiguration.getClientConfiguration().getLastName();
    String Gender=ClientConfiguration.getClientConfiguration().getGender();
    String DOB=ClientConfiguration.getClientConfiguration().getDOB();
    String ZipCode=ClientConfiguration.getClientConfiguration().getZipCode();
    String QFLKeyCode=ClientConfiguration.getClientConfiguration().getQFLKeyCode();
    String Medicaid=ClientConfiguration.getClientConfiguration().getMedicaid();
    String MedicaidID=ClientConfiguration.getClientConfiguration().getMedicaidID();
    String QFLkeycodeValue=ClientConfiguration.getClientConfiguration().getQFLkeycodeValue();
    String AddressLine1Label= ClientConfiguration.getClientConfiguration().getAddressLine1Label();
    String AddressLine1Value=ClientConfiguration.getClientConfiguration().getAddressLine1Value();
    String CityLabel=ClientConfiguration.getClientConfiguration().getCityLabel();
    String CityValue=ClientConfiguration.getClientConfiguration().getCityValue();
    String ZipCodeLabel=ClientConfiguration.getClientConfiguration().getZipCodeLabel();
    String ZipCodeValue=ClientConfiguration.getClientConfiguration().getZipCodeValue();
    String PrimaryPhonePrefixLabel=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixLabel();
    String PrimaryPhonePrefixValue=ClientConfiguration.getClientConfiguration().getPrimaryPhonePrefixValue();
/*    String LeaveMesasgeLabel=ClientConfiguration.getClientConfiguration().getLeaveMesasgeLabel();
    String LeaveMesasgeValue=ClientConfiguration.getClientConfiguration().getLeaveMesasgeValue();
    String TypeOfPhoneLabel=ClientConfiguration.getClientConfiguration().getTypeOfPhoneLabel();
    String TypeOfPhoneValue=ClientConfiguration.getClientConfiguration().getTypeOfPhoneValue();
    String DayToCallLabel=ClientConfiguration.getClientConfiguration().getDayToCallLabel();
    String DayToCallValue=ClientConfiguration.getClientConfiguration().getDayToCallValue();
    String TimeToCallLabel=ClientConfiguration.getClientConfiguration().getTimeToCallLabel();
    String TimeToCallValue=ClientConfiguration.getClientConfiguration().getTimeToCallValue();*/
    String QFLEnrollmentHelpLineSheetName=ClientConfiguration.getClientConfiguration().getQFLEnrollmentHelpLineSheetName();
    String QFLEnrollmentWebCoachSheetName=ClientConfiguration.getClientConfiguration().getQFLEnrollmentWebCoachSheetName();
    String QFLEnrollmentIndividualSheetName=ClientConfiguration.getClientConfiguration().getQFLEnrollmentIndividualSheetName();
    String QFLNRTFromActionPlanSheetName= ClientConfiguration.getClientConfiguration().getQFLNRTFromActionPlanSheetName();
    String QFLNRTDirectSheetName=ClientConfiguration.getClientConfiguration().getQFLNRTDirectSheetName();


    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Given("^User Navigate to QFL State Client URL$")
    public void user_Navigate_to_QFL_State_Client_URL() throws Throwable {
        qflStartupPage = new QFLStartupPage();
    }

    @When("^User selects \"([^\"]*)\" Intervention and proceed$")
    public void user_selects_Intervention_and_proceed(String Intervention) throws Throwable {
        if (ClientType.equals("PreEligibility")){
            interventionSelectionPage = qflStartupPage.clickSignUp("Uninsured");
        }else {
        	interventionSelectionPage = qflStartupPage.clickSignUp();
        }


        switch (Intervention) {

            case "HelpLine": {

                signUpPage = interventionSelectionPage.chooseIntervention(QFLInterventions.Helpline);
                break;
            }
            case "WebCoach": {
                signUpPage = interventionSelectionPage.chooseIntervention(QFLInterventions.WebCoach);
                break;
            }
            case "Individual": {
                serviceSelectionPage = interventionSelectionPage.chooseIndividualIntervention(QFLInterventions.IndividualServices);
                signUpPage = serviceSelectionPage.selectServices();
                break;
            }
        }
    }
    @When("^User selects language options$")
    public void user_selects_language_options(DataTable arg1) throws Throwable {
        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String language = (String) dataMap.get("language");
        aboutYouSignUpPage = signUpPage.fillSignUpForm(language,"");
    }

    @When("^User fills About You Section$")
    public void user_fills_About_You_Section(DataTable arg1) throws Throwable {
        String firstName=null;
        String lastName=null;
        String gender=null;
        String dob=null;
        String clientZip=null;
        Boolean hasMedicaid=Boolean.FALSE;
        String medicaidID=null;
        String keyCode=null;
        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        if (FirstName.equals("Yes")){
            firstName = (String) dataMap.get("firstName")+timestamp.getTime();
        }
        if (LastName.equals("Yes")){
            lastName = (String) dataMap.get("lastName")+timestamp.getTime();
        }
        if (Gender.equals("Yes")){
            gender = (String) dataMap.get("gender");
        }
        if (DOB.equals("Yes")){
            dob = (String) dataMap.get("dob");
        }
        if (ZipCode.equals("Yes")){
            clientZip = ZipCodeValue;
        }
        if (Medicaid.equals("Yes")){
            if (MedicaidID!=null && !MedicaidID.isEmpty() && !MedicaidID.equals("NA")) {
                hasMedicaid = Boolean.TRUE;
                medicaidID = MedicaidID;
            }else {
                hasMedicaid=Boolean.FALSE;
                medicaidID=MedicaidID;
            }
        }else if (Medicaid.equals("No")){
            hasMedicaid=Boolean.FALSE;
            medicaidID=null;
        }
        if (QFLKeyCode.equals("Yes")){
            keyCode=QFLkeycodeValue;
        }else if(QFLKeyCode.equals("No")){
            keyCode=null;
        }
        System.out.println(hasMedicaid);
        System.out.println(medicaidID);
        createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormCombined(firstName,lastName,gender,dob,clientZip,hasMedicaid,medicaidID,keyCode);
    }

    @Then("^User fills Create your Login ID section and agreement to TOU$")
    public void user_fills_Create_your_Login_ID_section_and_agreement_to_TOU(DataTable arg1) throws Throwable {
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

    @Then("^User enters \"([^\"]*)\" Contact Info details$")
    public void user_enters_Contact_Info_details$(String Intervention, DataTable arg1) throws Throwable {

        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
        String typeOfPhone = (String) dataMap.get("What type of phone is this?");
        String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
        String timeToCall = (String) dataMap.get("When to Call:");

        saveContactInfoPage.setTextField(AddressLine1Label, AddressLine1Value);
        saveContactInfoPage.setTextField(CityLabel, CityValue);
        saveContactInfoPage.setTextField(ZipCodeLabel, ZipCodeValue);
        saveContactInfoPage.setTextField(PrimaryPhonePrefixLabel, PrimaryPhonePrefixValue + HelperUtils.getRandomNumber(7));

        switch (Intervention) {


            case "WebCoach": {

                break;
            }
            default: {
                saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
                saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
                saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
                saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
                break;
            }
        }
        actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
    }

    @Then("^User completes the \"([^\"]*)\" Intervention Enrollment Questionnaire$")
    public void user_completes_the_Intervention_Enrollment_Questionnaire(String Intervention) throws Throwable {
        if (ClientType.equals("PreEligibility")){
            Intervention= "HelpLine";
        }
        switch (Intervention) {

            case "HelpLine": {

                ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLEnrollmentHelpLineSheetName);
                excelReader.setStartRow(1);
                actionPlanQuestionnairePage.answerEnrollmentQuestionnaire(excelReader);
                portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletedButton();
                break;
            }
            case "WebCoach": {
                ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLEnrollmentWebCoachSheetName);
                excelReader.setStartRow(1);
                nrtMedicationOrder = actionPlanQuestionnairePage.answerEnrollmentQuestionnaireFromExcel(excelReader);
                break;
            }
            case "Individual": {
                ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLEnrollmentIndividualSheetName);
                excelReader.setStartRow(1);
                nrtMedicationOrder = actionPlanQuestionnairePage.answerEnrollmentQuestionnaireFromExcel(excelReader);
                break;
            }
        }

    }

    @Then("^User completes NRT Medication Questionnaire for \"([^\"]*)\" Intervention$")
    public void user_completes_NRT_Medication_Questionnaire(String Intervention) throws Throwable {
        if (ClientType.equals("PreEligibility")){
            Intervention= "HelpLine";
        }
        switch (Intervention) {

            case "HelpLine": {
 //               portalHomePage=nrtMedicationOrder.startNRTActionPlan();
                actionPlanBannerPage = portalHomePage.openActiveGoals();
                nrtMedicationOrderViaActionPlan = actionPlanBannerPage.startNRTActionPlan();

                ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLNRTFromActionPlanSheetName);
                excelReader.setStartRow(1);

                nrtMedicationOrderViaActionPlan.completeNRTActionPlan(excelReader);
                break;
            }
            case "WebCoach": {
                ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLNRTDirectSheetName);
                excelReader.setStartRow(1);

                portalHomePage =  nrtMedicationOrder.nrtQuestionairreSubmit(excelReader);
                break;
            }
            case "Individual": {
                ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLNRTDirectSheetName);
                excelReader.setStartRow(1);

                nrtMedicationOrder.nrtQuestionairreSubmit(excelReader);
//                nrtMedicationOrder.clickEnrollmentCompletedButton();
                break;
            }
        }
    }

    @Then("^User Add Goal \"([^\"]*)\" in Managed Goals Page for \"([^\"]*)\" Intervention$")
    public void user_Add_Goal_in_Managed_Goals_Page_for_Intervention(String GoalType, String Intervention) throws Throwable {
        if (ClientType.equals("PreEligibility")){
            Intervention= "HelpLine";
        }
        switch (Intervention) {

            case "HelpLine": {
                manageGoalsPage = portalHomePage.navigateToManageGoals();
                actionPlanSetYourGoal = manageGoalsPage.clickAddGoalButton();
                actionPlanSetYourGoal.selectGoal(GoalType);
                goalDeadLineSelectionPage = actionPlanSetYourGoal.clickContinueButton();
                goalDeadLineSelectionPage.setGoalAchievementDate(DateTimeUtils.getFutureDate("MM/dd/yyyy",0));
                actionPlanBannerPage= goalDeadLineSelectionPage.clickContinueButtonToGoToBannerPage();
                break;
            }
            case "WebCoach": {
                manageGoalsPage = portalHomePage.navigateToManageGoals();
                actionPlanSetYourGoal = manageGoalsPage.clickAddGoalButton();
                actionPlanSetYourGoal.selectGoal(GoalType);
                goalDeadLineSelectionPage = actionPlanSetYourGoal.clickContinueButton();
                goalDeadLineSelectionPage.setGoalAchievementDate(DateTimeUtils.getFutureDate("MM/dd/yyyy",0));
                goalDeadLineSelectionPage.clickOnContinueButton();
                portalHomePage = goalDeadLineSelectionPage.clickEnrollmentCompletedButton();
                break;
            }
            case "Individual": {
                break;
            }
        }
    }
    @When("^User clicks I have reached my Goal for \"([^\"]*)\" Intervention$")
    public void user_clicks_I_have_reached_my_Goal_for_Intervention(String Intervention) throws Throwable {
        if (ClientType.equals("PreEligibility")){
            Intervention= "HelpLine";
        }
        switch (Intervention) {

            case "HelpLine": {
                actionPlanBannerPage = portalHomePage.openActiveGoals();
                CongratulationOnGoalCompletionPage congratulationOnGoalCompletionPage = actionPlanBannerPage.markCurrentGoalAsCompleteFromHeroBanner();

                congratulationOnGoalCompletionPage.clickClientLogo();
                break;
            }
            case "WebCoach": {
                actionPlanBannerPage = portalHomePage.openActiveGoals();
                CongratulationOnGoalCompletionPage congratulationOnGoalCompletionPage = actionPlanBannerPage.markCurrentGoalAsCompleteFromHeroBanner();

                congratulationOnGoalCompletionPage.clickClientLogo();
                break;
            }
            case "Individual": {
                break;
            }
        }
    }
}
