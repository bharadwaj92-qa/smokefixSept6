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

public class CommercialClientEnrollmentStepDef {
    QFLStartupPage qflStartupPage =null;
    SignUpPage signUpPages =null;
    AboutYouSignUpPage aboutYouSignUpPage =null;
    CreateLoginIDPage createLoginIDPage =null;
    TOUPage touPage =null;
    SaveContactInfoPage saveContactInfoPage =null;
    ActionPlanQuestionnairePage actionPlanQuestionnairePage =null;
    PortalHomePage portalHomePage =null;
    ManageGoalsPage manageGoalsPage =null;
    ActionPlanSetYourGoal actionPlanSetYourGoal =null;
    GoalDeadLineSelectionPage goalDeadLineSelectionPage =null;
    ActionPlanBannerPage actionPlanBannerPage=null;
    NRTMedicationOrderViaActionPlan nrtMedicationOrderViaActionPlan =null;

    String registeringAs= ClientConfiguration.getClientConfiguration().getregisteringAs();
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
    String QFLEnrollmentHelpLineSheetName=ClientConfiguration.getClientConfiguration().getQFLEnrollmentHelpLineSheetName();
    String QFLNRTFromActionPlanSheetName= ClientConfiguration.getClientConfiguration().getQFLNRTFromActionPlanSheetName();

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @Given("^User Navigate to QFL Commercial Client URL$")
    public void user_Navigate_to_QFL_Commercial_Client_URL() throws Throwable {
        qflStartupPage = new QFLStartupPage();
        signUpPages = qflStartupPage.clickSignUpLink();
    }

    @When("^User selects language options and Registering as for Commercial Client$")
    public void user_selects_language_options_and_Registering_as_for_Commercial_Client(DataTable arg1) throws Throwable {

       //TODO: Pass registering as from data table and remove from client config
        aboutYouSignUpPage = signUpPages.fillSignUpForm("English",registeringAs);
    }

    @When("^User fills About You Section for Commercial Client$")
    public void user_fills_About_You_Section_for_Commercial_Client(DataTable arg1) throws Throwable {
        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String firstName = (String) dataMap.get("firstName")+timestamp.getTime();
        String lastName = (String) dataMap.get("lastName")+timestamp.getTime();
        String gender = (String) dataMap.get("gender");
        String dob = (String) dataMap.get("dob");
        String relationship = (String) dataMap.get("relationship");
        createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormCommercial(firstName,lastName,gender,dob,relationship);
    }

    @Then("^User fills Create your Login ID section and agreement to TOU for Commercial Client$")
    public void user_fills_Create_your_Login_ID_section_and_agreement_to_TOU_for_Commercial_Client(DataTable arg1) throws Throwable {
        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String loginID = (String) dataMap.get("loginID")+timestamp.getTime()+""+"@gn.com";
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

        touPage = createLoginIDPage.fillLoginIDForm(loginID, password, confirmPassword, securityQuestion1, answer1, hint1, securityQuestion2, answer2, hint2,securityQuestion3, answer3, hint3);
        saveContactInfoPage = touPage.acceptTermsAndNavigateToContactInfoPage();
    }

    @Then("^User enters Contact Info details for Commercial Client$")
    public void user_enters_Contact_Info_details_for_Commercial_Client(DataTable arg1) throws Throwable {

        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String messageOnMobile = (String) dataMap.get("May we leave a message at this number");
        String typeOfPhone = (String) dataMap.get("What type of phone is this?");
        String dateToCall = (String) dataMap.get("When is the best time to reach you at this number?");
        String timeToCall = (String) dataMap.get("When to Call:");

        saveContactInfoPage.setTextField(AddressLine1Label, AddressLine1Value);
        saveContactInfoPage.setTextField(CityLabel, CityValue);
        saveContactInfoPage.selectDropDown(StateLabel, StateValue);
        saveContactInfoPage.setTextField(ZipCodeLabel, ZipCodeValue);
        saveContactInfoPage.setTextField(PrimaryPhonePrefixLabel, PrimaryPhonePrefixValue + HelperUtils.getRandomNumber(7));
        saveContactInfoPage.selectRadioOption("May we leave a message at this number", messageOnMobile);
        saveContactInfoPage.selectDropDown("What type of phone is this?", typeOfPhone);
        saveContactInfoPage.selectDropDown("When is the best time to reach you at this number?", dateToCall);
        saveContactInfoPage.selectDropDown("When to Call:", timeToCall);
        actionPlanQuestionnairePage = saveContactInfoPage.clickContinue();
    }

    @Then("^User completes the Enrollment Questionnaire for Commercial Client$")
    public void user_completes_the_Enrollment_Questionnaire_for_Commercial_Client() throws Throwable {
        ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLEnrollmentHelpLineSheetName);
        excelReader.setStartRow(1);
        actionPlanQuestionnairePage.answerEnrollmentQuestionnaire(excelReader);
        portalHomePage =  actionPlanQuestionnairePage.clickEnrollmentCompletedButton();
    }

    @Then("^User Add Goal \"([^\"]*)\" in Managed Goals Page for Commercial Client$")
    public void user_Add_Goal_in_Managed_Goals_Page_for_Commercial_Client(String GoalType) throws Throwable {
        manageGoalsPage = portalHomePage.navigateToManageGoals();
        actionPlanSetYourGoal = manageGoalsPage.clickAddGoalButton();
        actionPlanSetYourGoal.selectGoal(GoalType);
        goalDeadLineSelectionPage = actionPlanSetYourGoal.clickContinueButton();
        goalDeadLineSelectionPage.setGoalAchievementDate(DateTimeUtils.getFutureDate("MM/dd/yyyy",0));
        actionPlanBannerPage= goalDeadLineSelectionPage.clickContinueButtonToGoToBannerPage();

    }

    @Then("^User completes NRT Medication Questionnaire for Commercial Client$")
    public void user_completes_NRT_Medication_Questionnaire_for_Commercial_Client() throws Throwable {
        actionPlanBannerPage = portalHomePage.openActiveGoals();
        nrtMedicationOrderViaActionPlan = actionPlanBannerPage.startNRTActionPlan();

        //TODO: Pass the sheet name from Data table
        ExcelReader excelReader = new ExcelReader("QFLEnrollmentQuestionnaire.xlsx",QFLNRTFromActionPlanSheetName);
        excelReader.setStartRow(1);

        actionPlanBannerPage = nrtMedicationOrderViaActionPlan.completeNRTActionPlan(excelReader);

        portalHomePage = actionPlanBannerPage.clickClientLogo();
    }

    @When("^User clicks I have reached my Goal for Commercial Client$")
    public void user_clicks_I_have_reached_my_Goal_for_Commercial_Client() throws Throwable {
        actionPlanBannerPage = portalHomePage.openActiveGoals();
        CongratulationOnGoalCompletionPage congratulationOnGoalCompletionPage = actionPlanBannerPage.markCurrentGoalAsCompleteFromHeroBanner();

        congratulationOnGoalCompletionPage.clickClientLogo();


    }
}
