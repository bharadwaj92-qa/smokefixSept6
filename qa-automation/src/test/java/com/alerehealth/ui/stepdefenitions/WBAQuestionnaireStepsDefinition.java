package com.alerehealth.ui.stepdefenitions;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.c3po.common.pages.C3POHomePage;
import com.alerehealth.ui.c3po.common.pages.C3POLoginPage;
import com.alerehealth.ui.c3po.common.pages.DCPTestUserPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.rewards.CreditPage;
import com.alerehealth.ui.portal.wba.entities.WBAConstants;
import com.alerehealth.ui.portal.wba.pages.ReportDetailsPage;
import com.alerehealth.ui.portal.wba.pages.ReportSummary;
import com.alerehealth.ui.portal.wba.pages.WBAHomePage;
import com.alerehealth.ui.portal.wba.pages.WBAQuestionnairePage;
import com.alerehealth.ui.portal.wba.pages.WBAStartingPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.Map;

import org.junit.Assert;

public class WBAQuestionnaireStepsDefinition {


	WBAStartingPage wbaStartingPage;
	public static PortalHomePage portalHomePage;
	WBAHomePage wbaHomePage;
	CreditPage creditPage;
	ReportSummary reportSummary;
	ReportDetailsPage reportDetails;
	C3POHomePage c3poHomePage;

	DCPTestUserPage dcpTestUserPage;

	public static String portalUserName;
	@Given("^Create Testuser in C(\\d+) tool with gender \"([^\"]*)\" Age \"([^\"]*)\" Client \"([^\"]*)\" and working population \"([^\"]*)\"$")
	public void create_Testuser_in_C_tool_with_gender_DOB_Client_and_working_population(int arg1, String gender, String age, String client, String workingPopulation) throws Throwable {

		C3POLoginPage c3pologinpage=new C3POLoginPage();

		c3poHomePage=c3pologinpage.doLogin(Configuration.getConfiguration().getC3UserName(), Configuration.getConfiguration().getC3Password());

		c3poHomePage.selectDropdownsInC3Page(client, workingPopulation);
		c3poHomePage.clickOnTestUsers();
		dcpTestUserPage = c3poHomePage.switchtoNewWindow();
		
		portalUserName = dcpTestUserPage.fillMandatoryFieldsAndGetOneUser(gender, Integer.parseInt(age));
		if(portalUserName!=null){
			
			LoggerUtils.info("UserName Created with C3 tool is : "+portalUserName);
			c3poHomePage.switchToMainWindow();
			c3poHomePage.clickLogOffButton();
		}
		else throw new Exception("UserId didn't got created");


	}

	@Given("^Login to AlerePortal using C(\\d+) Created userName and Password$")
	public void login_to_AlerePortal_using_C_Created_userName_and_Password(int arg1) throws Throwable {

		PortalLoginPage portalLoginPage = new PortalLoginPage();

		LoggerUtils.info("Logging into Web portal using "+ portalUserName + "/" + "asdf");

		portalHomePage = portalLoginPage.doLogin(portalUserName,"asdf");

	}

	@Given("^Login to AlerePortal using userName and Password$")
	public void login_to_AlerePortal_using_userName_and_Password(DataTable arg1) throws Throwable {

		PortalLoginPage portalLoginPage = new PortalLoginPage();

		Map dataMap = arg1.asMap(String.class, String.class);

		String userName = (String) dataMap.get("username");
		String password = (String) dataMap.get("password");

		LoggerUtils.info("Logging into Web portal using "+ userName + "/" + password);

		portalHomePage = portalLoginPage.doLogin(userName,password);
	}

	@Then("^Verify and Click on the WBA content Card$")
	public void verify_and_Click_on_the_WBA_content_Card() throws Throwable {
		wbaHomePage = portalHomePage.clickOnHealthRiskQuestionnaireContentCard();

	}

	@Then("^Verify WBA landing page and click on the button$")
	public void verify_WBA_landing_page_and_click_on_the_button() throws Throwable {

		wbaStartingPage = wbaHomePage.startQuestionnaire();
	}

	@When("^Answer all the Questions in Questionarrie$")
	public void answer_all_the_Questions_in_Questionarrie() throws Throwable {

		WBAQuestionnairePage questionnairePage = wbaStartingPage.startWBAQuestionnaire();

		ExcelReader excelReader = new ExcelReader("WBA_ AllConditions _ Questionaire.xlsx", "Scenario 3 age = 50");

		excelReader.setStartRow(3);

		questionnairePage.answerWBAQuestionsFromExcel(excelReader);

		// questionnairePage.clickQuestionarieButtons("Continue");

	}

	@When("^Answer WBA Questionnaire as per Sheet$")
	public void answer_WBA_Questionnaire_as_per_Sheet(DataTable arg1) throws Throwable {

		Map<String,String> dataMap = arg1.asMap(String.class, String.class);

		String sheetName = dataMap.get("sheetname");

		LoggerUtils.info("Reading from sheet"+ sheetName);

		WBAQuestionnairePage questionnairePage = wbaStartingPage.startWBAQuestionnaire();

		ExcelReader excelReader = new ExcelReader("WBA_ AllConditions _ Questionaire.xlsx", sheetName);

		excelReader.setStartRow(3);

		questionnairePage.answerWBAQuestionsFromExcel(excelReader);

		reportSummary = questionnairePage.clickQuestionarieFinalContinueButtons("Continue");

	}
	
	@When("^Answer WBA Questionnaire as per Sheet with WBA Validations$")
	public void answer_WBA_Questionnaire_as_per_Sheet_with_WBA_Validations(DataTable arg1) throws Throwable {

		Map<String,String> dataMap = arg1.asMap(String.class, String.class);

		String sheetName = dataMap.get("sheetname");

		
		LoggerUtils.info("Reading from sheet"+ sheetName);

		WBAQuestionnairePage questionnairePage = wbaStartingPage.startWBAQuestionnaire();

		ExcelReader excelReader = new ExcelReader("WBA_ AllConditions _ Questionaire.xlsx", sheetName);

		excelReader.setStartRow(3);

		questionnairePage.answerWBAQuestionsFromExcel_WBAValidations(excelReader);

		reportSummary = questionnairePage.answerWBAQuestionsFromExcel_WBAValidations(excelReader);

	}

	@Then("^i validate the OverAll WellBeingScore = \"([^\"]*)\"$")
	public void i_validate_the_OverAll_WellBeingScore(String score) throws Throwable {

		LoggerUtils.info("Navigated to Report Summay Page, Verifying the OverAll Score Summary text");

		LoggerUtils.info("OverAll Score Summary Text from UI ->"+reportSummary.getResultSummaryDescriptionFromUI().getText());

		Assert.assertTrue(reportSummary.getResultSummaryDescriptionFromUI().getText().contentEquals(reportSummary.getResultSummaryDescriptionFromConstant(score)));

	}

	/*
	 * WBA Navigations step definations Starts here
	 */

	@Then("^I navigate to WBA Landing page and verify the WBA text$")
	public void i_navigate_to_WBA_Landing_page_and_verify_the_WBA_text() throws Throwable {

		Assert.assertEquals("Take your "+ClientConfiguration.getClientConfiguration().getWBAName(), wbaHomePage.getWBALandingPageText());
		LoggerUtils.info("Verified WBA Landing Page text : "+wbaHomePage.WBALandingPageText.getText());
	}


	@When("^Click on \"([^\"]*)\" Drop down from Top Navigation$")
	public void click_on_Drop_down_from_Top_Navigation(String topNav) throws Throwable {

		switch (topNav) {

		case "ActionPlan":
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getActionPlan()+" from Top Nav");
			portalHomePage.clickDropDownfromTopNavigation(ClientConfiguration.getClientConfiguration().getActionPlan());
			break;
		case "Progress":
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getProgress()+" from Top Nav");
			portalHomePage.clickDropDownfromTopNavigation(ClientConfiguration.getClientConfiguration().getProgress());
			break;
		case "Rewards":
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getRewards()+" from Top Nav");
			portalHomePage.clickDropDownfromTopNavigation(ClientConfiguration.getClientConfiguration().getRewards());
			break;
		case "Coaching":
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getCoaching()+" from Top Nav");
			portalHomePage.clickDropDownfromTopNavigation(ClientConfiguration.getClientConfiguration().getCoaching());
			break;
		case "Library":
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getLibrary()+" from Top Nav");
			portalHomePage.clickDropDownfromTopNavigation(ClientConfiguration.getClientConfiguration().getLibrary());
			break;
		case "Community":
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getCommunity()+" from Top Nav");
			portalHomePage.clickDropDownfromTopNavigation(ClientConfiguration.getClientConfiguration().getCommunity());
			break;
		case "Member Resource Center":
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getMemberResourceCenter()+" from Top Nav");
			portalHomePage.clickDropDownfromTopNavigation(ClientConfiguration.getClientConfiguration().getMemberResourceCenter());


		}

	}

	@When("^Click on Credits link from sub drop down$")
	public void click_on_Credits_link_from_sub_drop_down() throws Throwable {

		creditPage = portalHomePage.openCreditPage();
		
		LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getCredits()+" from drop down");
	}


	@Then("^Verify WBA Content Card and click on \"([^\"]*)\" button$")
	public void verify_WBA_Content_Card_and_click_on_button(String button) throws Throwable {
		creditPage.verifyAndClickWideCardButton("Take your "+ClientConfiguration.getClientConfiguration().getWBAName(),button);
		LoggerUtils.info("Verified WBA content card "+"Take your "+ClientConfiguration.getClientConfiguration().getWBAName());
		LoggerUtils.info("Verified and clicked on button "+button);
	}

	@When("^Click on Health Risk Questionnaire link$")
	public void click_on_Health_Risk_Questionnaire_link() throws Throwable {
		wbaHomePage = portalHomePage.clickOnHRQLinkFromDropDown();
	}

	@When("^Click on \"([^\"]*)\" Drop down from Top Navigation and Click on \"([^\"]*)\" link$")
	public void click_on_Drop_down_from_Top_Navigation_and_Click_on_link(String arg1, String arg2) throws Throwable {
		portalHomePage.clickOnDropDownAndLink(arg1, arg2);
	}

	@Then("^Verify WBA Content Card and click on button$")
	public void Verify_WBA_Content_Card_and_click_on_button() throws Throwable {

	}

	@When("^Click on \"([^\"]*)\" link$")
	public void click_on_link(String arg1) throws Throwable {

	}


	/*
	 * WBA Navigations step definations ENDs here
	 */


	/*
	 * Steps for DomainReportValidations 
	 * Starts here
	 */


	@When("^I click on view report button$")
	public void i_click_on_view_report_button() throws Throwable {
		Assert.assertTrue(reportSummary.getViewReportButton().isDisplayed());
		LoggerUtils.info("View Report Button is Displayed and Clicking on View Report");
		reportDetails = reportSummary.clickOnViewReportButton();
	}

	@Then("^I validate the \"([^\"]*)\"domain score \"([^\"]*)\" and description$")
	public void i_validate_the_domain_score_and_description(String domain, String domainScore) throws Throwable {

		int score = Integer.parseInt(domainScore);
		String descriptionConstantText = "";    	

		if(score>=66 && score<=100){
			switch (domain.toLowerCase()) {
			case "emotional":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Emotional_Common+"\n"+WBAConstants.WBA_ReportDetails_Emotional_Strong;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "physical":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Physical_Common+"\n"+WBAConstants.WBA_ReportDetails_Physical_Strong;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "social":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Social_Common+"\n"+WBAConstants.WBA_ReportDetails_Social_Strong;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "financial":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Financial_Common+"\n"+WBAConstants.WBA_ReportDetails_Financial_Strong;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "spiritual":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Spiritual_Common+"\n"+WBAConstants.WBA_ReportDetails_Spiritual_Strong;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			default:
				break;
			}
		}

		else if(score>=33 && score<=65){
			switch (domain.toLowerCase()) {
			case "emotional":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Emotional_Common+"\n"+WBAConstants.WBA_ReportDetails_Emotional_Average;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "physical":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Physical_Common+"\n"+WBAConstants.WBA_ReportDetails_Physical_Average;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "social":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Social_Common+"\n"+WBAConstants.WBA_ReportDetails_Social_Average;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "financial":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Financial_Common+"\n"+WBAConstants.WBA_ReportDetails_Financial_Average;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "spiritual":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Spiritual_Common+"\n"+WBAConstants.WBA_ReportDetails_Spiritual_Average;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			default:
				break;
			}
		}

		else if(score>=0 && score<32){
			switch (domain.toLowerCase()) {
			case "emotional":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Emotional_Common+"\n"+WBAConstants.WBA_ReportDetails_Emotional_Poor;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "physical":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Physical_Common+"\n"+WBAConstants.WBA_ReportDetails_Physical_Poor;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "social":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Social_Common+"\n"+WBAConstants.WBA_ReportDetails_Social_Poor;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "financial":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Financial_Common+"\n"+WBAConstants.WBA_ReportDetails_Financial_Poor;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			case "spiritual":
				descriptionConstantText= WBAConstants.WBA_ReportDetails_Spiritual_Common+"\n"+WBAConstants.WBA_ReportDetails_Spiritual_Poor;
				descriptionConstantText = descriptionConstantText.replace("DomainScore", domainScore);
				break;
			default:
				break;
			}
		}
		LoggerUtils.info(domain+" Description from Constants :\n"+descriptionConstantText);
		LoggerUtils.info("Comparing "+domain+" Description with content from UI");
		Assert.assertEquals(descriptionConstantText, reportDetails.getDomainDescription(domain));
		LoggerUtils.info("Comparing Totao Score: "+domainScore+" with UI");
		Assert.assertEquals("Total Score: "+domainScore+" of 100", reportDetails.getDomainScore(domain, domainScore));



	}

	/*
	 * Steps for DomainReportValidations 
	 * Ends here
	 */



	//Save & Exit
	@When("^Answer some questions and click on Save and Exit button$")
	public void answer_some_questions_and_click_on_Save_and_Exit_button() throws Throwable {

		WBAQuestionnairePage questionnairePage = wbaStartingPage.startWBAQuestionnaire();

		ExcelReader excelReader = new ExcelReader("WBA_ AllConditions _ Questionaire.xlsx", "Scenario 3 age = 50");

		excelReader.setStartRow(3);

		questionnairePage.answerWBAQuestionsFromExcel_SaveandExit(excelReader);
		questionnairePage.clickQuestionarieButtons("Save & Exit");

	}


	/*
	 * Incentives
	 */

	/*@Then("^Verify and click on \"([^\"]*)\" button in creditDetails page$")
	public void verify_and_click_on_button_in_creditDetails_page(String buttonName) throws Throwable {
		wbaHomePage = creditPage.creditDetails(buttonName);
	}*/
	
	@Then("^Verify and click on \"([^\"]*)\" button in creditDetails page$")
	public void verify_and_click_on_button_in_creditDetails_page(String buttonText) throws Throwable {
	    Assert.assertTrue("Button name not matched with UI: " +buttonText, creditPage.getCreditDetailsPageButtonText(buttonText));
	    LoggerUtils.info("Verified button text in credit detail page.");
	    wbaHomePage = creditPage.creditDetails(buttonText);
	    	
	}

	@When("^Click on client logo$")
	public void click_on_client_logo() throws Throwable {
		Thread.sleep(3000);
		portalHomePage.clientLogo();
	}

	@When("^Verify and Click on \"([^\"]*)\" button$")
	public void verify_and_Click_on_button(String arg1) throws Throwable {
		creditPage.verifyAndClickWideCardButton("Finish your "+ClientConfiguration.getClientConfiguration().getWBAName()+"!",arg1);

	}

	@When("^Verify and Click on \"([^\"]*)\" credit detail button$")
	public void verify_and_Click_on_credit_detail_button(String arg1) throws Throwable {
		wbaHomePage = creditPage.creditDetails(arg1);
	}

	@Then("^Verify WBA content Card \"([^\"]*)\" button name$")
	public void verify_WBA_content_Card_button_name(String buttonText) throws Throwable {
		Assert.assertTrue("Text not found!",portalHomePage.getCardButtonText(buttonText));
    	LoggerUtils.info("Verified button text in WBA Home page.");
    	wbaHomePage = portalHomePage.verifyClickCardButtonText(buttonText);
	}

	/*
	 * WBA States
	 */
	@Then("^Verify WBA content Card and Click on \"([^\"]*)\" button name$")
	public void verify_WBA_content_Card_and_Click_on_button_name(String arg1) throws Throwable {
		wbaHomePage = portalHomePage.verifyClickCardButtonText(arg1);
	}

	@Then("^I navigate to WBA Landing page and verify the WBA text as Complete your questionnaire$")
	public void i_navigate_to_WBA_Landing_page_and_verify_the_WBA_text_as_Complete_your_questionnaire() throws Throwable {

		/*LoggerUtils.info("Verified WBA Landing Page text : "+wbaHomePage.WBALandingPageText.getText());
		Assert.assertEquals("Complete your "+ClientConfiguration.getClientConfiguration().getWBAName(), wbaHomePage.WBALandingPageText.getText());
*/
		LoggerUtils.info("Verified WBA Landing Page text : "+wbaHomePage.WBALandingPageTextForCompleteYourHRQ.getText());
    	Assert.assertEquals("Complete your "+ClientConfiguration.getClientConfiguration().getWBAName(), wbaHomePage.WBALandingPageTextForCompleteYourHRQ.getText());
	}
	
	@Then("^Verify and click on \"([^\"]*)\" button in homePage$")
	public void verify_and_click_on_button_in_homePage(String buttonText) throws Throwable {
		//wbaHomePage=creditPage.verifyClickButtonTextCompleteAss(arg1);
		Assert.assertTrue("Text not found!",wbaHomePage.getverifyCompleteAssButtonText(buttonText));
    	LoggerUtils.info("Verified button text for complete assessment in WBA Home page.");
    	wbaHomePage.verifyClickButtonTextCompleteAss(buttonText);

	}

	/*
	 * Report
	 */
	@Then("^Verify and click on \"([^\"]*)\" button in WBAhomePage$")
	public void verify_and_click_on_button_in_WBAhomePage(String arg1) throws Throwable {
		reportSummary=wbaHomePage.verifyClickReportButton(arg1);

	}

	//WBA Completed state

	@Then("^verify is Health Risk Questionnaire Content Card Display in RewardPage$")
	public void verify_is_Health_Risk_Questionnaire_Content_Card_Display_in_RewardPage() throws Throwable {
		Assert.assertTrue("Text not found!",creditPage.isHealthRiskQuestionnaireContentCardDisplayinRewardPage(ClientConfiguration.getClientConfiguration().getWBAName()));
		//Assert.assertFalse("Card not found", false);
		System.out.println("Content card not visible in UI");

	}

	@Then("^verify is Health Risk Questionnaire Content Card Display in HomePage$")
	public void verify_is_Health_Risk_Questionnaire_Content_Card_Display_in_HomePage() throws Throwable {
		Assert.assertFalse("Text not found!",portalHomePage.isHealthRiskQuestionnaireContentCardDisplayinHomePage(ClientConfiguration.getClientConfiguration().getWBAName()));
		System.out.println("Content card not visible in UI");
	}

	@Then("^verify is Health Risk Questionnaire Content Card Display in CreditHistoryPage$")
	public void verify_is_Health_Risk_Questionnaire_Content_Card_Display_in_CreditHistoryPage() throws Throwable {
		creditPage.historyQuestionCompletedStatus();

	}

	@When("^Click on \"([^\"]*)\" link from sub drop down$")
	public void click_on_link_from_sub_drop_down(String arg1) throws Throwable {
		creditPage = portalHomePage.clickRewardsSubDropDown(arg1);

	}


	@Then("^User can able to see \"([^\"]*)\" link$")
	public void user_can_able_see(String arg1) throws Throwable {

		Assert.assertTrue("Failed to find Link" + arg1,portalHomePage.verifyContentCardLinks(arg1));

	}

	@When("^Click on the \"([^\"]*)\" link$")
	public void click_on_the_link(String arg1) throws Throwable {
		portalHomePage.clickOnLink(arg1);
	}
	@When("^User able to see \"([^\"]*)\" button$")
	public void user_able_see_button(String arg1) throws Throwable {

		Assert.assertTrue("failed to find button " + arg1, portalHomePage.verifyButtonvisibile(arg1));
	}

	@Then("^Click on \"([^\"]*)\" on left nav in wba results details page$")
	public void click_on_on_left_nav_in_wba_results_details_page(String arg1) throws Throwable {
		reportDetails.reportDetailsWbaLeftNav(arg1);

	}

	@Then("^Verify \"([^\"]*)\" bullet Icon and Click on \"([^\"]*)\" bullet$")
	public void verify_bullet_Icon_and_Click_on_bullet(String bulletStatus, String bulletName) throws Throwable {
		Assert.assertTrue(reportDetails.verifyPhysicalBulletIcons(bulletName, bulletStatus));
		reportDetails.clickOnBullet(bulletName);
	}

	@Then("^Verify the \"([^\"]*)\" bullet Content when \"([^\"]*)\" range$")
	public void verify_the_bullet_Content_when_range(String bulletName, String condition) throws Throwable {
		Assert.assertEquals(reportDetails.getPhysicalBulletTextFromExcel(condition), reportDetails.getPhysicalBulletTextFromUI(bulletName));
	}

	/*@Then("^Verify domain summary name and individual bullets under \"([^\"]*)\" section and display it$")
	public void verify_domain_summary_name_and_individual_bullets_under_section_and_display_it(String domainBullets) throws Throwable {
		reportDetails.individualBullets(domainBullets);

	} */
	
	
	/*
	 * This method is used to verify bullet text for individual domains(Social,Spiritual,Emotional,Financial)
	 */
	@Then("^Verify the bullet points as per sheet for \"([^\"]*)\"$")
    public void verify_the_bullet_points_as_per_sheet_for(String arg1, DataTable arg2) throws Throwable {
    	//Assert.assertEquals(reportDetails.getIndividualDomainsBulletTextFromExcel(DataTable arg1), reportDetails.individualBullets(domainBullets));
    	reportDetails.getIndividualDomainsBulletTextFromExcel(arg2,arg1);
    }

	
	/*
	 * Additional Resources under individual domains of report page
	 */
	@Then("^Verify and Click on \"([^\"]*)\" link under \"([^\"]*)\" section$")
	public void verify_and_Click_on_link_under_section(String linkName, String domainName) throws Throwable {
		Assert.assertTrue(reportDetails.getAdditionalResourcesLinks(domainName,linkName));
		LoggerUtils.info("Verifying the links under "+domainName+" aditional resource");
		reportDetails.clickAdditionalResourceLink(domainName,linkName);
		reportDetails.browserBack();

	}

	@Then("^Verify and Click on \"([^\"]*)\" link under \"([^\"]*)\" section new$")
	public void verify_and_Click_on_link_under_section_new(String linkName, String domainName) throws Throwable {
		Assert.assertTrue(reportDetails.getAdditionalResourcesLinks(domainName,linkName));
		LoggerUtils.info("Verifying the links under "+domainName+" aditional resource in new");
		reportDetails.clickAdditionalResourceLink(domainName,linkName);
		reportDetails.windowsOrTabsHandle();

	}
	
	@Then("^i validate the reportSummary page header$")
	public void i_validate_the_reportSummary_page_header() throws Throwable {
	    System.out.println(reportSummary.getReportSummaryHeaderFromUI().getText());
	    System.out.println(ClientConfiguration.getClientConfiguration().getWBAName()+" Results Summary");
		Assert.assertEquals(ClientConfiguration.getClientConfiguration().getWBAName()+" Results Summary", reportSummary.getReportSummaryHeaderFromUI().getText());
	    
	}
	
    @Then("^verify credits points on the credits page$")
    public void verify_credits_points_on_the_credits_page() throws Throwable {
    	Assert.assertEquals(ClientConfiguration.getClientConfiguration().getWBACredits(),creditPage.getCreditScore());
    	LoggerUtils.info(" "+creditPage.getCreditScore()+" Credits is present");
    }
    @Then("^verify credits points on the history page$")
    public void verify_credits_points_on_the_history_page() throws Throwable {
    	Assert.assertEquals(ClientConfiguration.getClientConfiguration().getWBACredits(),creditPage.getHistoryCredits());
        LoggerUtils.info(" "+creditPage.getHistoryCredits()+" Credits is present");
    }
    
    @Then("^verify credits points on the page$")
    public void verify_credits_points_on_the_page() throws Throwable {
    	Assert.assertEquals(ClientConfiguration.getClientConfiguration().getWBACredits(),portalHomePage.getCreditScore());
    	LoggerUtils.info(" "+portalHomePage.getCreditScore()+" Credits is present");
    }
    
    @Then("^verify zero credits points on the page$")
    public void verify_zerocredits_points_on_the_page() throws Throwable {
    	Assert.assertEquals("0",portalHomePage.getCreditScore());
    	LoggerUtils.info(" "+portalHomePage.getCreditScore()+" Credits is present");
    }
    @When("^Click on History link from sub drop down$")
    public void click_on_History_link_from_sub_drop_down() throws Throwable {
        
			creditPage = portalHomePage.clickOnHistoryLinkFromDropDown();
			LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getHistory()+" from drop down");
		}
    
    @When("^Answer some questions and click on previous button$")
    public void answer_some_questions_and_click_on_previous_button() throws Throwable {
    	
    	  WBAQuestionnairePage questionnairePage = wbaStartingPage.startWBAQuestionnaire();

          ExcelReader excelReader = new ExcelReader("WBA_ AllConditions _ Questionaire.xlsx", "Scenario 3 age = 50");

          excelReader.setStartRow(3);

          questionnairePage.answerWBAQuestionsFromExcel_SaveandExit(excelReader);
          questionnairePage.clickQuestionarieButtons("Previous");
          excelReader.setStartRow(7);
          questionnairePage.answerWBAQuestionsFromExcel_SaveandExit(excelReader);
          questionnairePage.clickQuestionarieButtons("Previous");
          excelReader.setStartRow(6);
          questionnairePage.answerWBAQuestionsFromExcel_SaveandExit(excelReader);
          questionnairePage.clickQuestionarieButtons("Previous");
          questionnairePage.clickQuestionarieButtons("Save & Exit");
          

    }
}

