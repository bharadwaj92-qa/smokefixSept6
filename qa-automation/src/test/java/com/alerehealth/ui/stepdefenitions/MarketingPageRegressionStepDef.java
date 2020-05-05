package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.common.Constants;
import com.alerehealth.ui.portal.common.pages.CommonHelpPage;
import com.alerehealth.ui.portal.common.pages.MarketingPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MarketingPageRegressionStepDef {
	
	PortalLoginPage portalLoginPage=null;
	MarketingPage marketingPage = null ;
	SignUpPage signupPage = null;
	CommonHelpPage helpPage = null;
	List<String>  FocusAreaElementInUI;
	List<String>  DoMoreSectionTitleInUI;
	
	String zone1ContentInUI;
	String focusArea1ContentInUI;
	String focusArea2ContentInUI;
	String focusArea3ContentInUI;
	String focusArea4ContentInUI;
	String focusArea5ContentInUI;
	String focusArea6ContentInUI;
	
	String howThisWorks1ContentInUI;
	String howThisWorks2ContentInUI;
	String howThisWorks3ContentInUI;
	
	String doMoreSection1ContentInUI;
	String doMoreSection2ContentInUI;
	String doMoreSection3ContentInUI;
	String doMoreSection4ContentInUI;
	
	
	
	@When("^User validating the Header Logo and links navigation$")
	public void user_validating_the_Header_Logo_and_links_navigation() throws Throwable {
		
		marketingPage = new MarketingPage();

		List<String> headerLinks = marketingPage.getHeaderLinks();

		String spanishLink = "Español";
	
		String englishLink="English";
		
		Assert.assertTrue("Spanish Link is displaying", headerLinks.contains(spanishLink));
		
		marketingPage.clickOnLanguageLink("Español");
		
		Assert.assertTrue("English Link is displaying",marketingPage.isHeaderLinkDisplayed(englishLink));
		
		marketingPage.clickOnLanguageLink("English");
		
		Assert.assertTrue("Spanish Link is displaying", headerLinks.contains(spanishLink));
		Assert.assertTrue("Help Link is displaying", headerLinks.contains("Help"));
		Assert.assertTrue("Sign Up Link is displaying", headerLinks.contains("Sign Up"));
		Assert.assertTrue("Log In Link is displaying", headerLinks.contains("Log In"));


		Assert.assertTrue("Client logo is displaying", marketingPage.isClientLogoDisplayed());

		String marpageHeaderText = marketingPage.getMarketingPageHeaderTitle();
		String marpageHeaderTextExpected = "The smart way to practice healthy living.";
		Assert.assertEquals("Header Text is matching", marpageHeaderTextExpected, marpageHeaderText);
		
		
		CommonHelpPage helpPage= marketingPage.clickOnHelpLink();

		Assert.assertTrue("Help page is displayed", helpPage.isDisplayed());

		 signupPage = helpPage.clickSignUp();
				
		Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());


	}
	
	@Then("^Click on clientLogo it should be navigated to Login page$")
	public void click_on_clientLogo_it_should_be_navigated_to_Login_page() throws Throwable {
	   
		
		portalLoginPage = signupPage.clickClientLogo();
		Assert.assertTrue("Portal Login page is displayed",portalLoginPage.isDisplayed());
	}
	
	
	
   @Given("^Validate the content and button displayed in Zone(\\d+) in Marketing page$")
   public void validate_the_content_and_button_displayed_in_Zone_in_Marketing_page(int arg1) throws Throwable {
       
	      marketingPage = new MarketingPage();
		  zone1ContentInUI= marketingPage.getZone1Content();
		  Assert.assertTrue("Content is displayed",zone1ContentInUI.contains(Constants.MARKETINGPAGE_ZONE1_CONTENT));
		  Assert.assertTrue("GetStartedNow Button is displayed",marketingPage.isGetStartedButtonDisplayed());
   }

   @When("^Click on GetStarted Button in Zone(\\d+) it should navigate to Signup page$")
   public void click_on_GetStarted_Button_in_Zone_it_should_navigate_to_Signup_page(int arg1) throws Throwable {
       
	   signupPage = marketingPage.clickGetStarted();
	   Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
	   marketingPage = signupPage.clickCancel();
	   Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
   }

   @When("^Validate the content, labels and click on GetStarted Button of each Focus Area which should be navigated to Signup page$")
   public void validate_the_content_labels_and_click_on_GetStarted_Button_of_each_Focus_Area_which_should_be_navigated_to_Signup_page() throws Throwable {
          
	   
	     FocusAreaElementInUI = marketingPage.getFocusAreas();
		 Assert.assertTrue(FocusAreaElementInUI.containsAll(Arrays.asList("Reach a Healthy Weight", "Be More Active", "Feel Less Stress", "Improve Your Diet", "Live Tobacco Free", "Take Charge of Your Health")));
	
		  Assert.assertTrue("GetStarted Button is displayed in How this works section",marketingPage.isGetStartedButtonDisplayed("How This Works"));
	      marketingPage.clickFocusArea("Reach a Healthy Weight");
		  focusArea1ContentInUI = marketingPage.getFocusAreaContent();
		  Assert.assertTrue("FocusArea1 content displayed correctly",focusArea1ContentInUI.contains(Constants.MARKETINGPAGE_FOCUSAREA1));
		  signupPage=marketingPage.clickGetStartedFocusArea();
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
		  
		  marketingPage.clickFocusArea("More Active");
		  focusArea2ContentInUI = marketingPage.getFocusAreaContent();
		  Assert.assertTrue("FocusArea2 content displayed correctly",focusArea2ContentInUI.contains(Constants.MARKETINGPAGE_FOCUSAREA2));
		  signupPage=marketingPage.clickGetStartedFocusArea();
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
		  
		  marketingPage.clickFocusArea("Less Stress");
		  focusArea3ContentInUI = marketingPage.getFocusAreaContent();
		  Assert.assertTrue("FocusArea3 content displayed correctly",focusArea3ContentInUI.contains(Constants.MARKETINGPAGE_FOCUSAREA3));
		  signupPage=marketingPage.clickGetStartedFocusArea();
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
		  
		  marketingPage.clickFocusArea("Your Diet");
		  focusArea4ContentInUI = marketingPage.getFocusAreaContent();
		  Assert.assertTrue("FocusArea4 content displayed correctly",focusArea4ContentInUI.contains(Constants.MARKETINGPAGE_FOCUSAREA4));
		  signupPage=marketingPage.clickGetStartedFocusArea();
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
		  
		  marketingPage.clickFocusArea("Tobacco Free");
		  focusArea5ContentInUI = marketingPage.getFocusAreaContent();
		  Assert.assertTrue("FocusArea5 content displayed correctly",focusArea5ContentInUI.contains(Constants.MARKETINGPAGE_FOCUSAREA5));
		  signupPage=marketingPage.clickGetStartedFocusArea();
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
		  
		  marketingPage.clickFocusArea("Take Charge");
		  focusArea6ContentInUI = marketingPage.getFocusAreaContent();
		  Assert.assertTrue("FocusArea6 content displayed correctly",focusArea6ContentInUI.contains(Constants.MARKETINGPAGE_FOCUSAREA6));
		  signupPage=marketingPage.clickGetStartedFocusArea();
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
   }

   @When("^Validate the content and labels in How this works section$")
   public void validate_the_content_and_labels_in_How_this_works_section() throws Throwable {
      
	      marketingPage.clickHowThisWorkSectionLink("FocusArea");
		  
		  marketingPage.clickHowThisWorkSectionLink("HealthCoach");
		  
		  marketingPage.clickHowThisWorkSectionLink("ActionPlan");
		  
		  howThisWorks1ContentInUI = marketingPage.getHowThisWorkContent("FocusArea");
		  Assert.assertTrue("How this works section1 content displayed correctly",howThisWorks1ContentInUI.contains(Constants.MARKETINGPAGE_HOWTHISWORKS_CONTENT1));
		  
		  howThisWorks2ContentInUI = marketingPage.getHowThisWorkContent("HealthCoach");
		  Assert.assertTrue("How this works section2 content displayed correctly",howThisWorks2ContentInUI.contains(Constants.MARKETINGPAGE_HOWTHISWORKS_CONTENT2));
		  
		  howThisWorks3ContentInUI = marketingPage.getHowThisWorkContent("ActionPlan");
		  Assert.assertTrue("How this works section3 content displayed correctly",howThisWorks3ContentInUI.contains(Constants.MARKETINGPAGE_HOWTHISWORKS_CONTENT3));
   }

   @Then("^Click on GetStarted Button in How this works section which should be navigated to Signup page$")
   public void click_on_GetStarted_Button_in_How_this_works_section_which_should_be_navigated_to_Signup_page() throws Throwable {
      
	      signupPage = marketingPage.clickGetStartedOfSection("How This Works");
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
   }

   @Then("^Validate the content and Titles in Do More section$")
   public void validate_the_content_and_Titles_in_Do_More_section() throws Throwable {
     
	      Assert.assertTrue("GetStarted Button is displayed in Do more Achieve More section",marketingPage.isGetStartedButtonDisplayed("Do More"));
		  DoMoreSectionTitleInUI = marketingPage.getDoMoreContentTitle();
		  Assert.assertTrue(DoMoreSectionTitleInUI.containsAll(Arrays.asList("Track progress from anywhere.","Search our health library.","Get a personal message center.","Link up your fitness device.")));
		  
		  doMoreSection1ContentInUI = marketingPage.getDoMoreContent("Track progress");
		  Assert.assertTrue("DoMore section1 content displayed correctly",doMoreSection1ContentInUI.contains(Constants.MARKETINGPAGE_DOMORE_CONTENT1));
		  
		  doMoreSection2ContentInUI = marketingPage.getDoMoreContent("health library");
		  Assert.assertTrue("DoMore section2 content displayed correctly",doMoreSection2ContentInUI.contains(Constants.MARKETINGPAGE_DOMORE_CONTENT2));
		  
		  doMoreSection3ContentInUI = marketingPage.getDoMoreContent("message center");
		  Assert.assertTrue("DoMore section3 content displayed correctly",doMoreSection3ContentInUI.contains(Constants.MARKETINGPAGE_DOMORE_CONTENT3));
		  
		  doMoreSection4ContentInUI = marketingPage.getDoMoreContent("fitness device");
		  Assert.assertTrue("DoMore section4 content displayed correctly", doMoreSection4ContentInUI.contains(Constants.MARKETINGPAGE_DOMORE_CONTENT4));
		  
		  
   }

   @Then("^Click on GetStarted Button in Do More section which should be navigated to Signup page$")
   public void click_on_GetStarted_Button_in_Do_More_section_which_should_be_navigated_to_Signup_page() throws Throwable {
     
	      signupPage = marketingPage.clickGetStartedOfSection("Do More");
		  Assert.assertTrue("Signup page is displayed", signupPage.isDisplayed());
		  marketingPage = signupPage.clickCancel();
		  Assert.assertTrue("Marketing page is displayed", marketingPage.isDisplayed());
   }

	
	
}
