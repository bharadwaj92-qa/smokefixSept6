package com.alerehealth.ui.stepdefenitions;


import org.junit.Assert;

import com.alerehealth.fwk.common.Constants;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;

import com.alerehealth.ui.portal.library.LibraryConstants;
import com.alerehealth.ui.portal.library.LibraryPage;

import com.alerehealth.ui.portal.memberrescenter.MemberDiscountPage;
import com.alerehealth.ui.portal.memberrescenter.MemberResourceCenterBasePage;
import com.alerehealth.ui.portal.memberrescenter.SmokerHelpLinePage;
import com.alerehealth.ui.portal.memberrescenter.Text4BabyPage;
import com.alerehealth.ui.portal.memberrescenter.WellBeingAssessmentPage;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MemberResourceCenterStepDef {
   
	PortalHomePage portalHomePage = null;
	MemberResourceCenterBasePage memberResourceCenterBasePage = null;
	PortalLoginPage portalLoginPage = null;
	MemberDiscountPage memberDiscountPage = null;
	SmokerHelpLinePage smokerHelpLinePage = null;
	LibraryPage libraryPage = null;
	Text4BabyPage text4BabyPage = null;
	WellBeingAssessmentPage wellBeingAssessmentPage = null;
	
	String welcomeMessageInUI;
	String programOverviewURL;
	String memberDiscountURL;
	String smokerHelplineURL;
	String text4BabyURL;
	
	String tobaccoFreeTitleInUI;
	String asthmaTitleInUI;
	String backPainTitleInUI;
	String diabetesTitleInUI;
	String heartProblemsTitleInUI;
	String respiratoryTitleInUI;
	String preconceptionTitleInUI;
	String maternityTitleInUI;
	
/*	@Given("^Login to Alere portal with username and password$")
	public void login_to_Alere_portal_with_username_and_password(DataTable arg1) throws Throwable {
	   
		 portalLoginPage = new PortalLoginPage();

		Map dataMap = arg1.asMap(String.class, String.class);

		String userName = (String) dataMap.get("username");
		String password = (String) dataMap.get("password");

		LoggerUtils.info("Logging into Web portal using "+ userName + "/" + password);

		portalHomePage = portalLoginPage.doLogin(userName,password);
	}
*/
  
  @When("^Click on ViewAll link beside Bulletin Board$")
  public void click_on_ViewAll_link_beside_Bulletin_Board() throws Throwable {
	  
	  portalHomePage = new PortalHomePage();
	  memberResourceCenterBasePage = portalHomePage.clickViewAllInMRCBulletinBoard();
	  Assert.assertTrue("Member Resource Center page is displayed", memberResourceCenterBasePage.isDisplayed());
	  
  }
  
  @Then("^Validate the Welcome Message displayed in Member Resource Center page$")
  public void validate_the_Welcome_Message_displayed_in_Member_Resource_Center_page() throws Throwable {
      
	  welcomeMessageInUI = memberResourceCenterBasePage.getWelcomeMessage();
	  Assert.assertTrue("Welcome Message is displayed",  welcomeMessageInUI.contains(Constants.MEMBERRESOURCECENTER_WELCOME_PAGE));
  }

  @When("^Verify all the names are displayed correctly under different sections in MemberResourceCenter Page$")
  public void verify_all_the_names_are_displayed_correctly_under_different_sections_in_MemberResourceCenter_Page() throws Throwable {
     
	  Assert.assertTrue("Program Overview link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Wellness Resources","Program Overview"));
	  Assert.assertTrue("Member Discounts link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Wellness Resources","Member Discounts"));
	  Assert.assertTrue("Wellbeing Assessment link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Wellness Resources","Wellbeing Assessment"));
	  Assert.assertTrue("Smokers Helpline link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Smoking Cessation","Smoker"));
	  Assert.assertTrue("Resources link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Smoking Cessation","Resources"));
	  Assert.assertTrue("Asthma link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Diseases and Conditions","Asthma"));
	  Assert.assertTrue("Back Pain link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Diseases and Conditions","Back Pain"));
	  Assert.assertTrue("Diabetes link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Diseases and Conditions","Diabetes"));
	  Assert.assertTrue("Heart Problems link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Diseases and Conditions","Heart Problems"));
	  Assert.assertTrue("Respiratory Disease link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Diseases and Conditions","Respiratory Disease"));
	  Assert.assertTrue("Text4Baby link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Having a Baby?","Text4Baby"));
	  Assert.assertTrue("Planning for a Healthy Pregnancy link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Having a Baby?","Planning for a Healthy Pregnancy"));
	  Assert.assertTrue("Pregnancy Learning Center link is displayed",memberResourceCenterBasePage.isLinkDisplayed("Having a Baby?","Pregnancy Learning Center"));
	  
  }

  @When("^Click on All links under Wellness Resources section which should be navigated to repective pages$")
  public void click_on_All_links_under_Wellness_Resources_section_which_should_be_navigated_to_repective_pages() throws Throwable {
    
	  programOverviewURL = memberResourceCenterBasePage.clickProgramOverviewLink();
	  Assert.assertTrue("Program View Pdf is displayed", programOverviewURL.contains("FlexStart_ProgramOverview_2018.pdf"));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
	  memberDiscountPage = memberResourceCenterBasePage.clickMemberDiscountLink();
	  memberDiscountURL = memberDiscountPage.getMemberDiscountPdfUrl();
	  Assert.assertTrue("Member Discount  Pdf is displayed", memberDiscountURL.contains("member-discounts_040118.pdf"));
	  memberDiscountPage.closeCurrentPage();
	  memberResourceCenterBasePage.switchBackToMemberResourceCenterBasePage();
	  
	  wellBeingAssessmentPage = memberResourceCenterBasePage.clickWellbeingAssessment();
	  Assert.assertTrue("WellBeing Assessment Page is displayed", wellBeingAssessmentPage.isDisplayed());
	  memberResourceCenterBasePage.navigateToBackPage();
	  
  }

  @When("^Click on All links under Smoking Cessation section which should be navigated to respective pages$")
  public void click_on_All_links_under_Smoking_Cessation_section_which_should_be_navigated_to_respective_pages() throws Throwable {
      
	  smokerHelpLinePage = memberResourceCenterBasePage.clickSmokerHelpLineLink();
	  smokerHelplineURL = smokerHelpLinePage.getSmokerHelplinePdfUrl();
	  Assert.assertTrue("Smoker HelpLine Pdf is displayed", smokerHelplineURL.contains("Final.smoking-cessation-programs-0118.pdf"));
	  smokerHelpLinePage.closeCurrentPage();
	  memberResourceCenterBasePage.switchBackToMemberResourceCenterBasePage();
	  
	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Resources");
	  Assert.assertTrue("Tobacco Free Page is displayed", libraryPage.isDisplayed());
	  tobaccoFreeTitleInUI = libraryPage.getTitle();
	  Assert.assertTrue("Tobacco free title is displayed", tobaccoFreeTitleInUI.contains(LibraryConstants.LIBRARY_TOBACOO_FREE_PAGE_TITLE));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
  }

  @Then("^Click on All links under Diseases and Conditions section which should be navigated to respective pages$")
  public void click_on_All_links_under_Diseases_and_Conditions_section_which_should_be_navigated_to_respective_pages() throws Throwable {
     
	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Asthma");
	  asthmaTitleInUI =libraryPage.getTitle();
	  Assert.assertTrue("Asthma title is displayed", asthmaTitleInUI.contains(LibraryConstants.LIBRARY_ASTHMA_PAGE_TITLE));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Pain");
	  backPainTitleInUI =libraryPage.getTitle();
	  Assert.assertTrue("BackPain title is displayed", backPainTitleInUI.contains(LibraryConstants.LIBRARY_BACKPAIN_PAGE_TITLE));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
	  
	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Diabetes");
	  diabetesTitleInUI =libraryPage.getTitle();
	  Assert.assertTrue("Diabetes title is displayed", diabetesTitleInUI.contains(LibraryConstants.LIBRARY_DIABETES_PAGE_TITLE));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
	  
	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Heart Problems");
	  heartProblemsTitleInUI =libraryPage.getTitle();
	  Assert.assertTrue("Heart Problems Title is displayed", heartProblemsTitleInUI.contains(LibraryConstants.LIBRARY_HEARTPROBLEM_PAGE_TITLE));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
	  
	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Respiratory Disease");
	  respiratoryTitleInUI =libraryPage.getTitle();
	  Assert.assertTrue("Respiratory Disease Title is displayed", respiratoryTitleInUI.contains(LibraryConstants.LIBRARY_RESPIRATORY_PAGE_TITLE));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
  }

  @Then("^Click on All links under Having a baby section which should be navigated to respective pages$")
  public void click_on_All_links_under_Having_a_baby_section_which_should_be_navigated_to_respective_pages() throws Throwable {
     
	  text4BabyPage = memberResourceCenterBasePage.clickText4BabyLink();
	  text4BabyURL = text4BabyPage.getText4BabyUrl();
	  Assert.assertTrue("Text4Baby page is displayed", text4BabyURL.contains("www.text4baby.org"));
	  text4BabyPage.closeCurrentPage();
	  memberResourceCenterBasePage.switchBackToMemberResourceCenterBasePage();

	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Planning for a Healthy Pregnancy");
	  preconceptionTitleInUI =libraryPage.getTitle();
	  Assert.assertTrue("Preconception Title is displayed", preconceptionTitleInUI.contains(LibraryConstants.LIBRARY_PLANNING_HEALTHY_PREGNANCY_PAGE_TITLE ));
	  memberResourceCenterBasePage.navigateToBackPage();
	  

	  libraryPage = memberResourceCenterBasePage.navigateToLibraryPage("Pregnancy Learning Center");
	  maternityTitleInUI =libraryPage.getTitle();
	  Assert.assertTrue("Maternity Title is displayed", maternityTitleInUI.contains(LibraryConstants.LIBRARY_PREGNANCY_LEARNING_CENTER_PAGE_TITLE));
	  memberResourceCenterBasePage.navigateToBackPage();
	  
  }

	
}
