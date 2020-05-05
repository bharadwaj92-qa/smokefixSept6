package com.alerehealth.ui.stepdefenitions;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.Constants;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.db.DBDataFetcher;
import com.alerehealth.ui.c3po.common.pages.C3POHomePage;
import com.alerehealth.ui.c3po.common.pages.C3POLoginPage;
import com.alerehealth.ui.c3po.common.pages.DCPTestUserPage;
import com.alerehealth.ui.portal.common.pages.*;
import com.alerehealth.ui.portal.registration.CreateLoginIDPage;
import com.alerehealth.ui.portal.registration.SSOFileLocationPage;
import com.alerehealth.ui.portal.registration.SSORegistrationPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NormalAndSSORegistrationStepDefenition {
    SSOFileLocationPage ssoFileLocationPage = null;
    SSORegistrationPage ssoRegistrationPage = null;
    SignUpPage signUpPage = null;
    TOUPage tOUPage = null;
    String FirstName = null;
    PortalHomePage portalHomePage; 
    String dobDBInCorrectFormat = null;
    String firstName = null;
    String lastName = null;
    String dateOfBirth = null;
    String genderDB = null;
    String uniqueId = null;
    String relationshipId =null;
    String age;
    String [] dateParts;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    AboutYouSignUpPage aboutYouSignUpPage = null;
    

    @Given("^Create an unregistered user  in C(\\d+) tool with gender \"([^\"]*)\" Age \"([^\"]*)\" Client \"([^\"]*)\" and working population \"([^\"]*)\"$")
    public void create_an_unregistered_user_in_C_tool_with_gender_Age_Client_and_working_population(int arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {

        C3POLoginPage c3pologinpage=new C3POLoginPage();
        C3POHomePage c3poHomePage=c3pologinpage.doLogin(Configuration.getConfiguration().getC3UserName(), Configuration.getConfiguration().getC3Password());
        //Given Create Testuser in C3 tool with gender "Male" DOB "6/7/1988" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
        String client = arg4;
        String workingPopulation = arg5;
        c3poHomePage.selectDropdownsInC3Page(client, workingPopulation);
        c3poHomePage.clickOnTestUsers();
        DCPTestUserPage dcpTestUserPage = c3poHomePage.switchtoNewWindow();
        String gender = arg2;
        age = arg3;
        String  portalUserName = dcpTestUserPage.fillMandatoryFieldsAndGetOneUserForUnregistered(gender,Integer.parseInt( age));
        System.out.println("Portal Username : "+portalUserName);
        if(portalUserName!=null){
        	LoggerUtils.info("UserName Created with C3 tool is : "+portalUserName);
        	//commented 'switchToMainWindow()' in the method switchToMainWindow()
        	c3poHomePage.switchToMainWindow();
        	c3poHomePage.clickLogOffButton();
        	}
    }

    @Given("^Obtain unregistered user details from DB$")
    public void obtain_unregistered_user_details_from_DB() throws Exception {

        String dob = DateTimeUtils.getDOB(Integer.parseInt(age));
        dateParts = dob.split("/");

        String dobDB = DateTimeUtils.changeDateFormat("MM/dd/yyyy",dob,"dd-MMM-yy");
        String todaysDate = DateTimeUtils.getCurrentTime("yyyy-MM-dd 00:00:00");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date date = new Date();
        String todayDate = dateFormat.format(date);
        DBDataFetcher dBDataFetcher = new DBDataFetcher();
        String rowData[] = dBDataFetcher.getRowDataForQueryFromCDRDB("Select Distinct MS.FName, MS.LName, MS.DOB as DOB, MS.GENDER, MEV.ELIG_SSN_NBR,ME.relationshipid,MS.RUNID from CDR.Membership MS left outer join CDR.MEMBERELIGVAL MEV on MS.PID=MEV.PID left outer join CDR.MemberElig ME on MS.PID=ME.PID Where ME.clientid = 500010 and DOB='"+dobDB+"' and MS.PID < 0 and MS.INSERTDATETIME >= to_date('"+todayDate+"','YYYY-MM-DD HH24:MI:SS') order by MS.RUNID desc");
         firstName = rowData[0];
         lastName = rowData[1];
         dateOfBirth = rowData[2];
    
         dobDBInCorrectFormat = DateTimeUtils.changeDateFormat("yyyy-MM-dd 00:00:00",dateOfBirth,"MM/dd/yyyy");
         genderDB = rowData[3];
         uniqueId = rowData[4];
         relationshipId = rowData[5];
         System.out.println("User Details"+firstName+lastName+dateOfBirth+genderDB+uniqueId+relationshipId);
    }
    @Given("^Language and affiliation option$")
    public void language_and_affiliation_option(DataTable arg1) throws Throwable {
            Map dataMap = (Map) arg1.asMap(String.class, String.class);
            String Affiliation = (String) dataMap.get("affiliation");
            String Language =  (String) dataMap.get("language");
            MarketingPage marketingPage = new MarketingPage();
            marketingPage.isDisplayed();
            signUpPage = marketingPage.clickSignUp();
            signUpPage.clickEnglishRadioButton();
            signUpPage.selectRole(Affiliation);
            signUpPage.clickContinueButton();
            aboutYouSignUpPage = signUpPage.fillKeyCodeForm(ClientConfiguration.getClientConfiguration().getKeyCode());

            }
    @When("^User proceeds with LoginID form using below details$")
    public void user_proceeds_with_LoginID_form_using_below_details(DataTable arg1) throws Throwable {

            Map dataMap = (Map) arg1.asMap(String.class, String.class);
        
            String LoginID = (String) dataMap.get("loginId");
            
            String confirmloginID = (String) dataMap.get("confirmloginID");
            String emailaddr = (String) dataMap.get("emailaddr");
            String confirmemailaddr = (String) dataMap.get("confirmemailaddr");
            
            String Password = (String) dataMap.get("password");
            String Confirmpwd = (String) dataMap.get("confirmpwd");
            String Securityque1 = (String) dataMap.get("securityque1");
            String Securityans1 = (String) dataMap.get("securityans1");
            String Securityhint1 = (String) dataMap.get("securityhint1");
            String Securityque2 = (String) dataMap.get("securityque2");
            String Securityans2 = (String) dataMap.get("securityans2");
            String Securityhint2 = (String) dataMap.get("securityhint2");
            String Securityque3= (String) dataMap.get("securityque3");
            String Securityans3 = (String) dataMap.get("securityans3");
            String Securityhint3 = (String) dataMap.get("securityhint3");
            
            
         
            aboutYouSignUpPage.fillAboutYouFormForKeyCode(firstName,lastName,genderDB, dobDBInCorrectFormat);
            
            CreateLoginIDPage createLoginIDPage = new CreateLoginIDPage();
            tOUPage = createLoginIDPage.fillLoginIDForm(LoginID+""+timestamp.getTime()+""+"@gn.com",confirmloginID+""+timestamp.getTime()+""+"@gn.com",emailaddr,confirmemailaddr, Password, Confirmpwd, Securityque1, Securityans1, Securityhint1, Securityque2, Securityans2, Securityhint2,Securityque3, Securityans3, Securityhint3);

    }
    @Given("^Affiliation as keycode$")
    public void affiliation_as_keycode(DataTable arg1) throws Throwable {

        Map dataMap = (Map) arg1.asMap(String.class, String.class);

        String Affiliation = (String) dataMap.get("affiliation");
        String Language =  (String) dataMap.get("language");
        MarketingPage marketingPage = new MarketingPage();
        marketingPage.isDisplayed();
        signUpPage = marketingPage.clickSignUp();
        signUpPage.clickContinueButton();
        String strAffiliationActualError = signUpPage.getTextOfAffiliationErrorMessage();
        String strAffiliationExpectedError = Constants.ERROR_MESSAGE_AFFILIATION;
        Assert.assertEquals("Validating affiliation error msg", strAffiliationActualError, strAffiliationExpectedError);
        signUpPage.clickEnglishRadioButton();
        signUpPage.selectRole(Affiliation);
        signUpPage.clickContinueButton();
    }

    @When("^User proceeds with Validation of error messages and filling loginId form using below details$")
    public void user_proceeds_with_Validation_of_error_messages_and_filling_loginId_form_using_below_details(DataTable arg1) throws Throwable {

        Map dataMap = (Map) arg1.asMap(String.class, String.class);
      
        String LoginID = (String) dataMap.get("loginId");
        
        String confirmloginID = (String) dataMap.get("confirmloginID");
        String emailaddr = (String) dataMap.get("emailaddr");
        String confirmemailaddr = (String) dataMap.get("confirmemailaddr");
        
        String Password = (String) dataMap.get("password");
        String Confirmpwd = (String) dataMap.get("confirmpwd");
        String Securityque1 = (String) dataMap.get("securityque1");
        String Securityans1 = (String) dataMap.get("securityans1");
        String Securityhint1 = (String) dataMap.get("securityhint1");
        String Securityque2 = (String) dataMap.get("securityque2");
        String Securityans2 = (String) dataMap.get("securityans2");
        String Securityhint2 = (String) dataMap.get("securityhint2");
        String Securityque3= (String) dataMap.get("securityque3");
        String Securityans3 = (String) dataMap.get("securityans3");
        String Securityhint3 = (String) dataMap.get("securityhint3");

        signUpPage.clickContinueButton();
        String strKeyCodeActualError = signUpPage.getTextOfKeyCodeErrorMessage();
        String strKeyCodeExpectedError = Constants.ERROR_MESSAGE_KEYCODE;
        Assert.assertEquals("Validating affiliation error msg", strKeyCodeActualError, strKeyCodeExpectedError);
        AboutYouSignUpPage aboutYouSignUpPage1 = signUpPage.fillKeyCodeForm("12345");
        aboutYouSignUpPage1.clickContinueButton();
        String strWrongKeyCodeActualError = signUpPage.getTextOfWrongKeyCodeErrorMessage();
        String strWrongKeyCodeExpectedError = Constants.ERROR_MESSAGE_WRONG_KEYCODE;
        Assert.assertEquals("Validating affiliation error msg", strWrongKeyCodeActualError, strWrongKeyCodeExpectedError);
        signUpPage.clickContinueButton();
        AboutYouSignUpPage aboutYouSignUpPage = signUpPage.fillKeyCodeForm(ClientConfiguration.getClientConfiguration().getKeyCode());
        aboutYouSignUpPage.clickContinueButton();
        String strFirstNameActualError = aboutYouSignUpPage.getTextOfFirstNameErrorMessage();
        String strFirstNameExpectedError = Constants.ERROR_MESSAGE_FIRSTNAME;
        Assert.assertEquals("Validating first name error msg", strFirstNameActualError, strFirstNameExpectedError);
        String strLastNameActualError = aboutYouSignUpPage.getTextOfLastNameErrorMessage();
        String strLastNameExpectedError = Constants.ERROR_MESSAGE_LASTNAME;
        Assert.assertEquals("Validating last name error msg", strLastNameActualError, strLastNameExpectedError);
        String strGenderActualError = aboutYouSignUpPage.getTextOfGenderErrorMessage();
        String strGenderExpectedError = Constants.ERROR_MESSAGE_GENDER;
        Assert.assertEquals("Validating gender error msg", strGenderActualError, strGenderExpectedError);
        String strDOBActualError = aboutYouSignUpPage.getTextOfDateOfBirthErrorMessage();
        String strDOBExpectedError = Constants.ERROR_MESSAGE_DATEOFBIRTH;
        Assert.assertEquals("Validating DOB error msg", strDOBActualError, strDOBExpectedError);
        CreateLoginIDPage createLoginIDPage = aboutYouSignUpPage.fillAboutYouFormForKeyCode(firstName,lastName,genderDB, dobDBInCorrectFormat);
        createLoginIDPage.clickContinueButton();
        String strLoginIDActualError = createLoginIDPage.getTextOfLoginIDErrorMessage();
        String strLoginIDExpectedError = Constants.ERROR_MESSAGE_LOGINID;
        Assert.assertEquals("Validating LoginID error msg", strLoginIDActualError, strLoginIDExpectedError);
        String strPasswordActualError = createLoginIDPage.getTextOfPasswordErrorMessage();
        String strPasswordExpectedError = Constants.ERROR_MESSAGE_PASSWORD;
        Assert.assertEquals("Validating Password error msg", strPasswordActualError, strPasswordExpectedError);
        String strConfirmPasswordActualError = createLoginIDPage.getTextOfConfirmPasswordErrorMessage();
        String strConfirmPasswordExpectedError = Constants.ERROR_MESSAGE_CONFIRMPASSWORD;
        Assert.assertEquals("Validating Confirm Password error msg", strConfirmPasswordActualError, strConfirmPasswordExpectedError);
        String strSecurityQuestion1ActualError = createLoginIDPage.getTextOfSecurityQuestion1ErrorMessage();
        String strSecurityQuestion1ExpectedError = Constants.ERROR_MESSAGE_SECURITYQUESTION;
        Assert.assertEquals("Validating Security Question 1 error msg", strSecurityQuestion1ActualError, strSecurityQuestion1ExpectedError);
        String strSecurityAnswer1ActualError = createLoginIDPage.getTextOfSecurityAnswer1ErrorMessage();
        String strSecurityAnswer1ExpectedError = Constants.ERROR_MESSAGE_SECURITYANSWER;
        Assert.assertEquals("Validating Security Answer 1 error msg", strSecurityAnswer1ActualError, strSecurityAnswer1ExpectedError);
        String strSecurityHint1ActualError = createLoginIDPage.getTextOfSecurityHint1ErrorMessage();
        String strSecurityHint1ExpectedError = Constants.ERROR_MESSAGE_SECURITYHINT;
        Assert.assertEquals("Validating Security Hint 1 error msg", strSecurityHint1ActualError, strSecurityHint1ExpectedError);
        String strSecurityQuestion2ActualError = createLoginIDPage.getTextOfSecurityQuestion1ErrorMessage();
        String strSecurityQuestion2ExpectedError = Constants.ERROR_MESSAGE_SECURITYQUESTION;
        Assert.assertEquals("Validating Security Question 2 error msg", strSecurityQuestion2ActualError, strSecurityQuestion2ExpectedError);
        String strSecurityAnswer2ActualError = createLoginIDPage.getTextOfSecurityAnswer1ErrorMessage();
        String strSecurityAnswer2ExpectedError = Constants.ERROR_MESSAGE_SECURITYANSWER;
        Assert.assertEquals("Validating Security Answer 2 error msg", strSecurityAnswer2ActualError, strSecurityAnswer2ExpectedError);
        String strSecurityHint2ActualError = createLoginIDPage.getTextOfSecurityHint1ErrorMessage();
        String strSecurityHint2ExpectedError = Constants.ERROR_MESSAGE_SECURITYHINT;
        Assert.assertEquals("Validating Security Hint 2 error msg", strSecurityHint2ActualError, strSecurityHint2ExpectedError);
        String strSecurityQuestion3ActualError = createLoginIDPage.getTextOfSecurityQuestion1ErrorMessage();
        String strSecurityQuestion3ExpectedError = Constants.ERROR_MESSAGE_SECURITYQUESTION;
        Assert.assertEquals("Validating Security Question 3 error msg", strSecurityQuestion3ActualError, strSecurityQuestion3ExpectedError);
        String strSecurityAnswer3ActualError = createLoginIDPage.getTextOfSecurityAnswer1ErrorMessage();
        String strSecurityAnswer3ExpectedError = Constants.ERROR_MESSAGE_SECURITYANSWER;
        Assert.assertEquals("Validating Security Answer 3 error msg", strSecurityAnswer3ActualError, strSecurityAnswer3ExpectedError);
        String strSecurityHint3ActualError = createLoginIDPage.getTextOfSecurityHint1ErrorMessage();
        String strSecurityHint3ExpectedError = Constants.ERROR_MESSAGE_SECURITYHINT;
        Assert.assertEquals("Validating Security Hint 3 error msg", strSecurityHint3ActualError, strSecurityHint3ExpectedError);
        tOUPage =createLoginIDPage.fillLoginIDForm(LoginID+""+timestamp.getTime()+""+"@gn.com",confirmloginID+""+timestamp.getTime()+""+"@gn.com",emailaddr,confirmemailaddr, Password, Confirmpwd, Securityque1, Securityans1, Securityhint1, Securityque2, Securityans2, Securityhint2,Securityque3, Securityans3, Securityhint3);


    }
    @Then("^user is successfully registered and able to see home page of portal$")
    public void user_is_successfully_registered_and_able_to_see_home_page_of_portal() throws Throwable {

            tOUPage.acceptTerms();
            PortalHomePage portalHomePage = new PortalHomePage();
            portalHomePage.isDisplayed();
            portalHomePage.clickSignOut();

            }


    @When("^User proceeds with registration using below details$")
    public void user_proceeds_with_registration_using_below_details(DataTable arg1) throws Throwable {

        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String Language =  (String) dataMap.get("language");
        String Affiliation = (String) dataMap.get("affiliation");
        String FirstName = (String) dataMap.get("firstName");
        String Password = (String) dataMap.get("password");
        String Confirmpwd = (String) dataMap.get("confirmpwd");
        String Securityque1 = (String) dataMap.get("securityque1");
        String Securityans1 = (String) dataMap.get("securityans1");
        String Securityhint1 = (String) dataMap.get("securityhint1");
        String Securityque2 = (String) dataMap.get("securityque2");
        String Securityans2 = (String) dataMap.get("securityans2");
        String Securityhint2 = (String) dataMap.get("securityhint2");
        String Securityque3= (String) dataMap.get("securityque3");
        String Securityans3 = (String) dataMap.get("securityans3");
        String Securityhint3 = (String) dataMap.get("securityhint3");

        MarketingPage marketingPage = new MarketingPage();
        marketingPage.isDisplayed();
        SignUpPage signUpPage = marketingPage.clickSignUp();
        List<String> roleslist = signUpPage.getRoleList();
        String rowData1[][] = DBDataFetcher.getMultiRowDataOnPRPCDB("select objectname from PRPC.affiliation where clientid='500010'");
        String affiliations[] = new String[rowData1.length];
        for(int i = 0; i<rowData1.length; i++) {
            affiliations[i] = rowData1[i][0];
        }
        for (String s : affiliations) {
            if ((roleslist.contains("Select, ")) & (roleslist.contains(s))){
                Assert.assertEquals("Validating each affiliation Id's "+s+"form db and user", affiliations, roleslist);
            }
        }

        AboutYouSignUpPage aboutYouSignUpPage = signUpPage.fillSignUpForm(Language, Affiliation);
        String [] datePartsDob = dateOfBirth.split(" ");
        dateOfBirth = datePartsDob[0];
        String [] datePart = dateOfBirth.split("-");
        String stryear = datePart[0];
        String strmonth = datePart[1];
        String strdate = datePart[2];
        dateOfBirth = strmonth+"/"+strdate+"/"+stryear;
        CreateLoginIDPage createLoginIDPage = aboutYouSignUpPage.fillAboutYouForm(firstName,lastName, uniqueId,genderDB, dateOfBirth);

        tOUPage = createLoginIDPage.fillLoginIDForm(firstName+FirstName, Password, Confirmpwd, Securityque1, Securityans1, Securityhint1, Securityque2, Securityans2, Securityhint2,Securityque3, Securityans3, Securityhint3);




    }

    @Then("^user is successfully registered and able to sigin and signout of portal$")
    public void user_is_successfully_registered_and_able_to_sigin_and_signout_of_portal() throws Throwable {
        portalHomePage = tOUPage.acceptTerms();
        portalHomePage.isDisplayed();
        portalHomePage.clickSignOut();
    }

    @When("^User proceeds with registration by validating error messages and using below details$")
    public void user_proceeds_with_registration_by_validating_error_messages_and_using_below_details(DataTable arg1) throws Throwable {

        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String Language =  (String) dataMap.get("language");
        String Affiliation = (String) dataMap.get("affiliation");
        String FirstName = (String) dataMap.get("firstName");
        String Password = (String) dataMap.get("password");
        String Confirmpwd = (String) dataMap.get("confirmpwd");
        String Securityque1 = (String) dataMap.get("securityque1");
        String Securityans1 = (String) dataMap.get("securityans1");
        String Securityhint1 = (String) dataMap.get("securityhint1");
        String Securityque2 = (String) dataMap.get("securityque2");
        String Securityans2 = (String) dataMap.get("securityans2");
        String Securityhint2 = (String) dataMap.get("securityhint2");
        String Securityque3= (String) dataMap.get("securityque3");
        String Securityans3 = (String) dataMap.get("securityans3");
        String Securityhint3 = (String) dataMap.get("securityhint3");


        MarketingPage marketingPage = new MarketingPage();
        marketingPage.isDisplayed();
        SignUpPage signUpPage = marketingPage.clickSignUp();
        signUpPage.clickContinueButton();
        String strLanguageActualError = signUpPage.getTextOfLanguageErrorMessage();
        String strLanguageExpectedError = Constants.ERROR_MESSAGE_LANGUAGE;
        Assert.assertEquals("Validating Language selection error msg", strLanguageActualError, strLanguageExpectedError);
        String strAffiliationActualError = signUpPage.getTextOfAffiliationErrorMessage();
        String strAffiliationExpectedError = Constants.ERROR_MESSAGE_AFFILIATION;
        Assert.assertEquals("Validating affiliation error msg", strAffiliationActualError, strAffiliationExpectedError);
        AboutYouSignUpPage aboutYouSignUpPage = signUpPage.fillSignUpForm("English", "as a Subscriber");
        aboutYouSignUpPage.isDisplayed();
        aboutYouSignUpPage.clickContinueButton();
        String strFirstNameActualError = aboutYouSignUpPage.getTextOfFirstNameErrorMessage();
        String strFirstNameExpectedError = Constants.ERROR_MESSAGE_FIRSTNAME;
        Assert.assertEquals("Validating first name error msg", strFirstNameActualError, strFirstNameExpectedError);
        String strLastNameActualError = aboutYouSignUpPage.getTextOfLastNameErrorMessage();
        String strLastNameExpectedError = Constants.ERROR_MESSAGE_LASTNAME;
        Assert.assertEquals("Validating last name error msg", strLastNameActualError, strLastNameExpectedError);
        String strGenderActualError = aboutYouSignUpPage.getTextOfGenderErrorMessage();
        String strGenderExpectedError = Constants.ERROR_MESSAGE_GENDER;
        Assert.assertEquals("Validating gender error msg", strGenderActualError, strGenderExpectedError);
        String strDOBActualError = aboutYouSignUpPage.getTextOfDateOfBirthErrorMessage();
        String strDOBExpectedError = Constants.ERROR_MESSAGE_DATEOFBIRTH;
        Assert.assertEquals("Validating DOB error msg", strDOBActualError, strDOBExpectedError);
        String [] datePartsDob = dateOfBirth.split(" ");
        dateOfBirth = datePartsDob[0];
        String [] datePart = dateOfBirth.split("-");
        String stryear = datePart[0];
        String strmonth = datePart[1];
        String strdate = datePart[2];
        dateOfBirth = strmonth+"/"+strdate+"/"+stryear;
        aboutYouSignUpPage.fillAboutYouForm(firstName,lastName, uniqueId,genderDB, dateOfBirth);
        CreateLoginIDPage createLoginIDPage = new CreateLoginIDPage();
        createLoginIDPage.isDisplayed();
        createLoginIDPage.clickContinueButton();
        String strLoginIDActualError = createLoginIDPage.getTextOfLoginIDErrorMessage();
        String strLoginIDExpectedError = Constants.ERROR_MESSAGE_LOGINID;
        Assert.assertEquals("Validating LoginID error msg", strLoginIDActualError, strLoginIDExpectedError);
        String strPasswordActualError = createLoginIDPage.getTextOfPasswordErrorMessage();
        String strPasswordExpectedError = Constants.ERROR_MESSAGE_PASSWORD;
        Assert.assertEquals("Validating Password error msg", strPasswordActualError, strPasswordExpectedError);
        String strConfirmPasswordActualError = createLoginIDPage.getTextOfConfirmPasswordErrorMessage();
        String strConfirmPasswordExpectedError = Constants.ERROR_MESSAGE_CONFIRMPASSWORD;
        Assert.assertEquals("Validating Confirm Password error msg", strConfirmPasswordActualError, strConfirmPasswordExpectedError);
        String strSecurityQuestion1ActualError = createLoginIDPage.getTextOfSecurityQuestion1ErrorMessage();
        String strSecurityQuestion1ExpectedError = Constants.ERROR_MESSAGE_SECURITYQUESTION;
        Assert.assertEquals("Validating Security Question 1 error msg", strSecurityQuestion1ActualError, strSecurityQuestion1ExpectedError);
        String strSecurityAnswer1ActualError = createLoginIDPage.getTextOfSecurityAnswer1ErrorMessage();
        String strSecurityAnswer1ExpectedError = Constants.ERROR_MESSAGE_SECURITYANSWER;
        Assert.assertEquals("Validating Security Answer 1 error msg", strSecurityAnswer1ActualError, strSecurityAnswer1ExpectedError);
        String strSecurityHint1ActualError = createLoginIDPage.getTextOfSecurityHint1ErrorMessage();
        String strSecurityHint1ExpectedError = Constants.ERROR_MESSAGE_SECURITYHINT;
        Assert.assertEquals("Validating Security Hint 1 error msg", strSecurityHint1ActualError, strSecurityHint1ExpectedError);
        String strSecurityQuestion2ActualError = createLoginIDPage.getTextOfSecurityQuestion1ErrorMessage();
        String strSecurityQuestion2ExpectedError = Constants.ERROR_MESSAGE_SECURITYQUESTION;
        Assert.assertEquals("Validating Security Question 2 error msg", strSecurityQuestion2ActualError, strSecurityQuestion2ExpectedError);
        String strSecurityAnswer2ActualError = createLoginIDPage.getTextOfSecurityAnswer1ErrorMessage();
        String strSecurityAnswer2ExpectedError = Constants.ERROR_MESSAGE_SECURITYANSWER;
        Assert.assertEquals("Validating Security Answer 2 error msg", strSecurityAnswer2ActualError, strSecurityAnswer2ExpectedError);
        String strSecurityHint2ActualError = createLoginIDPage.getTextOfSecurityHint1ErrorMessage();
        String strSecurityHint2ExpectedError = Constants.ERROR_MESSAGE_SECURITYHINT;
        Assert.assertEquals("Validating Security Hint 2 error msg", strSecurityHint2ActualError, strSecurityHint2ExpectedError);
        String strSecurityQuestion3ActualError = createLoginIDPage.getTextOfSecurityQuestion1ErrorMessage();
        String strSecurityQuestion3ExpectedError = Constants.ERROR_MESSAGE_SECURITYQUESTION;
        Assert.assertEquals("Validating Security Question 3 error msg", strSecurityQuestion3ActualError, strSecurityQuestion3ExpectedError);
        String strSecurityAnswer3ActualError = createLoginIDPage.getTextOfSecurityAnswer1ErrorMessage();
        String strSecurityAnswer3ExpectedError = Constants.ERROR_MESSAGE_SECURITYANSWER;
        Assert.assertEquals("Validating Security Answer 3 error msg", strSecurityAnswer3ActualError, strSecurityAnswer3ExpectedError);
        String strSecurityHint3ActualError = createLoginIDPage.getTextOfSecurityHint1ErrorMessage();
        String strSecurityHint3ExpectedError = Constants.ERROR_MESSAGE_SECURITYHINT;
        Assert.assertEquals("Validating Security Hint 3 error msg", strSecurityHint3ActualError, strSecurityHint3ExpectedError);
        tOUPage = createLoginIDPage.fillLoginIDForm(firstName+"@gn.com", "Password@1", "Password@1", "What is your city of birth?", "asdf", "as", "What was the name of your elementary school?", "qwer", "qw", "What is your favorite book?", "zxcv", "zx");
      
    }



    @Then("^validate error messages of Age and uniqued ID$")
    public void validate_error_messages_of_Age_and_uniqued_ID() throws Throwable {

        MarketingPage marketingPage = new MarketingPage();
        marketingPage.isDisplayed();
        SignUpPage signUpPage = marketingPage.clickSignUp();
        AboutYouSignUpPage aboutYouSignUpPage = signUpPage.fillSignUpForm("English", "as a Subscriber");
        String under18DOB = DateTimeUtils.getDOB(17);  //thIS WILL GET UDob of less than 18yrs
        aboutYouSignUpPage.fillAboutYouForm(firstName,lastName, uniqueId,genderDB, under18DOB);
        String strAgeLessThan18ActualError =  aboutYouSignUpPage.getTextOfAgeLessThan18ErrorMessage();
        String strAgeLessThan18ExpectedError = Constants.ERROR_MESSAGE_AGE_LESS_THAN_18;
        Assert.assertEquals("Validating error msg of age less than 18", strAgeLessThan18ActualError, strAgeLessThan18ExpectedError);
        aboutYouSignUpPage.fillAboutYouForm(firstName,lastName, "000"+uniqueId,genderDB, dobDBInCorrectFormat);
        String strWrongUniqueIDActualError =  aboutYouSignUpPage.getTextOfWrongUniqueIDErrorMessage();
        String strWrongUniqueIDExpectedError = Constants.ERROR_MESSAGE_WRONG_UNIQUE_ID;
        Assert.assertEquals("Validating error msg of Wrong Unique ID", strWrongUniqueIDActualError, strWrongUniqueIDExpectedError);
         String greaterThan65DOB = DateTimeUtils.getDOB(66);
        aboutYouSignUpPage.fillAboutYouForm(firstName,lastName, uniqueId,genderDB, greaterThan65DOB);
        String strAgeGreaterThan65ActualError =  aboutYouSignUpPage.getTextOfWrongUniqueIDErrorMessage();
        String strAgeGreaterThan65ExpectedError = Constants.ERROR_MESSAGE_WRONG_UNIQUE_ID;
        Assert.assertEquals("Validating error msg of age greater than 65", strAgeGreaterThan65ActualError, strAgeGreaterThan65ExpectedError);

    }

    @When("^User proceeds with SSO file form using below details$")
    public void user_proceeds_with_SSO_file_form_using_below_details(DataTable arg1) throws Throwable {

        Map dataMap = (Map) arg1.asMap(String.class, String.class);
        String Target = (String) dataMap.get("targetUrl");
        String ClientName = (String) dataMap.get("client");
        String FileName = (String) dataMap.get("fileName");
        ssoFileLocationPage = new SSOFileLocationPage();
        ssoRegistrationPage= ssoFileLocationPage.launchClientPage(ClientName, FileName);
        String dobDB = DateTimeUtils.changeDateFormat("yyyy-MM-dd 00:00:00",dateOfBirth,"yyyyMMdd");
        ssoRegistrationPage.fillSSOForm(Target,uniqueId,firstName,lastName,dobDB, genderDB);

    }

    @Then("^user is successfully registered from SSO file and able to see home page of portal$")
    public void user_is_successfully_registered_from_SSO_file_and_able_to_see_home_page_of_portal() throws Throwable {

        PortalHomePage portalHomePage =  tOUPage.acceptTerms();

        portalHomePage.isDisplayed();
        portalHomePage.clickSignOut();

        String rowData[] = DBDataFetcher.getRowDataForQueryFromPRPCDB("select INSERTDATE,LASTUPDATEDATE from prpc.person where firstname='"+FirstName+"'");
        String insertDate = rowData[0];
        String lastUpdatedDate = rowData[1];
        Assert.assertEquals("Validating insert date and last updated time for the user", insertDate, lastUpdatedDate);


    }



}
