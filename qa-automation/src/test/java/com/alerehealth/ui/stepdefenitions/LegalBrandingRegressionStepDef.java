package com.alerehealth.ui.stepdefenitions;

import org.junit.Assert;

import com.alerehealth.fwk.common.Constants;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.portal.common.pages.MobileTextMessagingPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.common.pages.PrivacyPolicyPage;
import com.alerehealth.ui.portal.common.pages.TextToQuitPage;
import com.alerehealth.ui.portal.settings.TermsOfUsePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LegalBrandingRegressionStepDef {
	
	PortalHomePage portalHomePage = null;
	PrivacyPolicyPage privacyPolicyPage = null;
	MobileTextMessagingPage mobileTextMessagingPage = null;
	int keyWordCountInPrivacyPolicy;
	TermsOfUsePage termsOfUsePage = null ;
	TextToQuitPage textToQuitPage = null;
	

	
	@Given("^Click on Privacy link from Footer section, optum keyword should be displayed$")
	public void click_on_Privacy_link_from_Footer_section_optum_keyword_should_be_displayed() throws Throwable {
	  
		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
		privacyPolicyPage = portalHomePage.clickFooterPrivacy();
		/*keyWordCountInPrivacyPolicy = privacyPolicyPage.getKeywordCount("Optum");
		Assert.assertEquals("Count is same",keyWordCountInPrivacyPolicy,Constants.PRIVACY_PAGE_KEYWORD_COUNT);*/
		
		String clientParaContent = privacyPolicyPage.getClientNameOptumHolderPara("Optum");

		Assert.assertTrue("Client name is present", clientParaContent.contains("Optum"));
		
		
	}

	@When("^Click on HIPAA Notice of Privacy link from Privacy page, optum keyword should be displayed$")
	public void click_on_HIPAA_Notice_of_Privacy_link_from_Privacy_page_optum_keyword_should_be_displayed() throws Throwable {
	   
	}

	@When("^Click on Terms link from Footer section, optum keyword should be displayed$")
	public void click_on_Terms_link_from_Footer_section_optum_keyword_should_be_displayed() throws Throwable {
	    
		termsOfUsePage = privacyPolicyPage.clickFooterTerms();
		
		String clientParaContent = termsOfUsePage.getClientNameOptumHolderPara("Optum");

		Assert.assertTrue("Client name is present", clientParaContent.contains("Optum"));

	}

	@When("^Click on Text Messaging link from TOU page, optum keyword should be displayed$")
	public void click_on_Text_Messaging_link_from_TOU_page_optum_keyword_should_be_displayed() throws Throwable {
	   
		textToQuitPage = termsOfUsePage.clickOnText2Quit();
		
		String clientParaContent = textToQuitPage.getClientNameOptumHolderPara("Optum");

		Assert.assertTrue("Client name is present", clientParaContent.contains("Optum"));
	}
	
	@Then("^Click on Text Quit link from TOU page, optum keyword should be displayed$")
	public void click_on_Text_Quit_link_from_TOU_page_optum_keyword_should_be_displayed() throws Throwable {
	   
		termsOfUsePage = textToQuitPage.clickOnHere();
		
		String clientParaContent = termsOfUsePage.getClientNameOptumHolderPara("Optum");

		Assert.assertTrue("Client name is present", clientParaContent.contains("Optum"));
		termsOfUsePage.closeCurrentPage();
		textToQuitPage.switchBackToText2QuitPage();
		textToQuitPage.closeCurrentPage();
		 termsOfUsePage.switchBackToTermsOfUsePage();
		
		
	}
    

	@Then("^Click on Mobile Text Messaging from  TOU page, optum keyword should be displayed$")
	public void click_on_Mobile_Text_Messaging_from_TOU_page_optum_keyword_should_be_displayed() throws Throwable {
	 
		mobileTextMessagingPage = termsOfUsePage.clickOnMobileTextMessaging();
		
		String clientParaContent = mobileTextMessagingPage.getClientNameOptumHolderPara("Optum");

		Assert.assertTrue("Client name is present", clientParaContent.contains("Optum"));
		
		mobileTextMessagingPage.closeCurrentPage();
		 termsOfUsePage.switchBackToTermsOfUsePage();
		
	}

	

@Given("^Click on Privacy link from Footer section, PronoucedHealth keyword should be displayed$")
public void click_on_Privacy_link_from_Footer_section_PronoucedHealth_keyword_should_be_displayed() throws Throwable {
   
}

@When("^Click on HIPAA Notice of Privacy link from Privacy page, Pronounced Health keyword should be displayed$")
public void click_on_HIPAA_Notice_of_Privacy_link_from_Privacy_page_Pronounced_Health_keyword_should_be_displayed() throws Throwable {
   
}

@When("^Click on Terms link from Footer section, Pronounced Health keyword should be displayed$")
public void click_on_Terms_link_from_Footer_section_Pronounced_Health_keyword_should_be_displayed() throws Throwable {
  
}

@When("^Click on Text Messaging link from TOU page, Pronounced Health keyword should be displayed$")
public void click_on_Text_Messaging_link_from_TOU_page_Pronounced_Health_keyword_should_be_displayed() throws Throwable {
    
}

@Then("^Click on Mobile Text Messaging from  TOU page, Pronounced Health keyword should be displayed$")
public void click_on_Mobile_Text_Messaging_from_TOU_page_Pronounced_Health_keyword_should_be_displayed() throws Throwable {
    
}

@Then("^Click on Text Quit link from TOU page, Pronounced Health keyword should be displayed$")
public void click_on_Text_Quit_link_from_TOU_page_Pronounced_Health_keyword_should_be_displayed() throws Throwable {
   
}

@Given("^Click on Privacy link from Footer section, United Health care keyword should be displayed$")
public void click_on_Privacy_link_from_Footer_section_United_Health_care_keyword_should_be_displayed() throws Throwable {
    
}

@When("^Click on HIPAA Notice of Privacy link from Privacy page, United Health care keyword should be displayed$")
public void click_on_HIPAA_Notice_of_Privacy_link_from_Privacy_page_United_Health_care_keyword_should_be_displayed() throws Throwable {
   
}

@When("^Click on Terms link from Footer section, United Health care keyword should be displayed$")
public void click_on_Terms_link_from_Footer_section_United_Health_care_keyword_should_be_displayed() throws Throwable {
  
}

@When("^Click on Text Messaging link from TOU page, United Health care keyword should be displayed$")
public void click_on_Text_Messaging_link_from_TOU_page_United_Health_care_keyword_should_be_displayed() throws Throwable {
  
}

@Then("^Click on Mobile Text Messaging from  TOU page, United Health care keyword should be displayed$")
public void click_on_Mobile_Text_Messaging_from_TOU_page_United_Health_care_keyword_should_be_displayed() throws Throwable {
  
}

@Then("^Click on Text Quit link from TOU page, United Health care keyword should be displayed$")
public void click_on_Text_Quit_link_from_TOU_page_United_Health_care_keyword_should_be_displayed() throws Throwable {
   
}

}
