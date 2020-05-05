package com.alerehealth.ui.stepdefenitions;

import org.junit.Assert;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.portal.common.pages.MobileTextMessagingPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.common.pages.TOUPage;
import com.alerehealth.ui.portal.common.pages.TermOfUsePageConstants;
import com.alerehealth.ui.portal.common.pages.PrintableTermsOfUsePage;
import com.alerehealth.ui.portal.library.LibraryConstants;
import com.alerehealth.ui.portal.common.pages.PrivacyPolicyPage;
import com.alerehealth.ui.portal.settings.TermsOfUsePage;
import com.alerehealth.ui.portal.common.pages.TextToQuitPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TermsOfUseStepDef {
	
	WBAQuestionnaireStepsDefinition portalusername;
	
	PortalHomePage portalHomePage = null;
	
	PortalLoginPage portalLoginPage = null;
	TOUPage touPage = null;
	PrintableTermsOfUsePage termsOfUsePrintPage = null;
	TextToQuitPage textToQuitPage = null;
	PrivacyPolicyPage privacyPolicyPage = null;
	MobileTextMessagingPage moileTextMessagingPage = null;
	
	
	PrivacyPolicyPage privacyPage = null;
	TermsOfUsePage termsOfUsePage = null ;
	TermsOfUsePage termsOfUsePage1 = null ;
	TextToQuitPage textQuitPage = null;
	

	String privacyPolicyTilteFromUI;
	String textToQuitTitleFromUI;
	String termsOfUseTitleFromUI;
	String mobileTextMessagingTitleFromUI;
	
	
	@Given("^Login to AlerePortal using C(\\d+) Created userName and Password navigate to TOU$")
	public void login_to_AlerePortal_using_C_Created_userName_and_Password_navigate_to_TOU(int arg1) throws Throwable {
	   
		PortalLoginPage portalLoginPage = new PortalLoginPage();

		LoggerUtils.info("Logging into Web portal using "+ portalusername.portalUserName + "/" + "asdf");
		
		touPage = portalLoginPage.submitLoginCredentials(portalusername.portalUserName, "asdf");
	}

	
	
	@When("^Click on Printable Verison Link and Privacy Link navigated to respective pages$")
	public void click_on_Printable_Verison_Link_and_Privacy_Link_navigated_to_respective_pages() throws Throwable {
	   
	
		Assert.assertTrue("Validating Terms of Use page is Displayed", touPage.isDisplayed());
		
		termsOfUsePrintPage = touPage.clickOnPrintableVersion();
		
		Assert.assertTrue("Terms of Use Print page is launched ",termsOfUsePrintPage.isDisplayed());
		
		Assert.assertTrue("Terms of Use Print page Bullet section is displayed ",termsOfUsePrintPage.isBulletsSectionDisplayed());
		
		Assert.assertTrue("Terms of Use Print page Bullet section is displayed ",termsOfUsePrintPage.isSupportedCarriersSectionDisplayed());
		
		termsOfUsePrintPage.closeTermsOfUsePrintWindow();
		
		touPage.switchBackToTermsOfUsePage();
		
		privacyPolicyPage = touPage.clickOnPrivacyPolicy();
		
		Assert.assertTrue("Terms of Use Privacy page  is launched ",privacyPolicyPage.isDisplayed());
		
		privacyPolicyTilteFromUI = privacyPolicyPage.getTitle();
		
		Assert.assertTrue("Privacy Policy page title is as expected",privacyPolicyTilteFromUI.contains(TermOfUsePageConstants.PRIVACY_POLICY_PAGE_TITLE));
		
		privacyPolicyPage.closePrivacyPolicyWindow();
		
		touPage.switchBackToTermsOfUsePage();
		
		Assert.assertTrue("Validating Terms of Use page is Displayed", touPage.isDisplayed());
		
	}

	@When("^Click on Mobile Text Messaging and Text (\\d+) Quit Link  navigated to respective Pages$")
	public void click_on_Mobile_Text_Messaging_and_Text_Quit_Link_navigated_to_respective_Pages(int arg1) throws Throwable {
		
		moileTextMessagingPage = touPage.clickOnMobileTextMessaging();
		
		Assert.assertTrue("Terms of Use MobileTerms Of Use page  is launched ",moileTextMessagingPage.isDisplayed());
		
		mobileTextMessagingTitleFromUI = moileTextMessagingPage.getTitle();
		
		Assert.assertTrue("MobileTerms Of Use page title is as expected",mobileTextMessagingTitleFromUI.contains(TermOfUsePageConstants.MOBILE_TEXT_MESSAGIN_PAGE_TITLE));
		
		moileTextMessagingPage.closeCurrentPage();
		
		touPage.switchBackToTermsOfUsePage();
		
		Assert.assertTrue("Validating Terms of Use page is Displayed", touPage.isDisplayed());
	  
		textToQuitPage = touPage.clickOnText2Quit();
		
		Assert.assertTrue("Terms of Use Text 2 Quit page  is launched ",textToQuitPage.isDisplayed());
		
		textToQuitTitleFromUI = textToQuitPage.getTitle();
		
		Assert.assertTrue("Text 2 Quit page title is as expected",textToQuitTitleFromUI.contains(TermOfUsePageConstants.TEXT_TO_QUIT_PAGE_TITLE));
	}

	@When("^Click on here link navigated to Terms of Use page$")
	public void click_on_here_link_navigated_to_Terms_of_Use_page() throws Throwable {
		
		termsOfUsePage = textToQuitPage.clickOnHere();
		
		Assert.assertTrue("Validating Terms of Use page is Displayed", termsOfUsePage.isDisplayed());
		
		termsOfUsePage.closeCurrentPage();
		
		textToQuitPage.switchBackToText2QuitPage();
		
		textToQuitPage.closeCurrentPage();
				
	}

	@When("^Click on Terms in Footer section of Terms of Use Page$")
	public void click_on_Terms_in_Footer_section_of_Terms_of_Use_Page() throws Throwable {
	     
		
		
        touPage.switchBackToTermsOfUsePage();
		
		termsOfUsePage = touPage.clickOnFooterTerms();
		
	}

	@Then("^Terms of Use page  should be displayed$")
	public void terms_of_Use_page_should_be_displayed() throws Throwable {
		
		Assert.assertTrue("Validating Terms of Use page is Displayed", termsOfUsePage.isDisplayed());
		
		
	}

	@When("^Click on Privacy Link navigated to Privacy Policy Page$")
	public void click_on_Privacy_Link_navigated_to_Privacy_Policy_Page() throws Throwable {
		
		privacyPage = termsOfUsePage.clickOnPrivacyPolicy();
		
		Assert.assertTrue("Terms of Use Privacy page  is launched ",privacyPage.isDisplayed());
		
		privacyPolicyTilteFromUI = privacyPage.getTitle();
		
		Assert.assertTrue("Privacy Policy page title is as expected",privacyPolicyTilteFromUI.contains(TermOfUsePageConstants.PRIVACY_POLICY_PAGE_TITLE));
		
		privacyPage.closeCurrentPage();

		
		touPage.switchBackToTermsOfUsePage();
		
		termsOfUsePage.navigateToBackPage();
				
		Assert.assertTrue("Validating Terms of Use page is Displayed", touPage.isDisplayed());
		
		
		  		
	
	}
	
	@When("^Click on Text (\\d+) Quit Link  Terms in footer navigated to Text to Quit Page$")
	public void click_on_Text_Quit_Link_Terms_in_footer_navigated_to_Text_to_Quit_Page(int arg1) throws Throwable {
		
		termsOfUsePage = touPage.clickOnFooterTerms();
        
		textQuitPage = termsOfUsePage.clickOnText2Quit();
		
		Assert.assertTrue("Terms of Use Text 2 Quit page  is launched ",textQuitPage.isDisplayed());
		
		textToQuitTitleFromUI = textQuitPage.getTitle();
		
		Assert.assertTrue("Text 2 Quit page title is as expected",textToQuitTitleFromUI.contains(TermOfUsePageConstants.TEXT_TO_QUIT_PAGE_TITLE));
	}
	
	
	@When("^Click on here link navigated to Terms of Use footer page$")
	public void click_on_here_link_navigated_to_Terms_of_Use_footer_page() throws Throwable {
		
		termsOfUsePage1 = textQuitPage.clickOnHere();
		
		Assert.assertTrue("Validating Terms of Use page is Displayed", termsOfUsePage1.isDisplayed());
		
		termsOfUsePage1.closeCurrentPage();
		

		textQuitPage.switchBackToText2QuitPage();
		
		textQuitPage.closeCurrentPage();
		
		
		touPage.switchBackToTermsOfUsePage();
		
		termsOfUsePage1.navigateToBackPage();
		
		termsOfUsePage1.navigateToBackPage();
				
				
		Assert.assertTrue("Validating Terms of Use page is Displayed", touPage.isDisplayed());
	
	}
	
	@When("^Accept TOU page and click continue$")
	public void accept_TOU_page_and_click_continue() throws Throwable {
		
		Assert.assertFalse("Continue Button is enabled", touPage.isContinueButtonEnabled());
		portalHomePage = touPage.acceptTerms();
	   
	}
	
	@Then("^Home page should be displayed$")
	public void home_page_should_be_displayed() throws Throwable {
	  
		Assert.assertTrue("Portal Home Page is displayed",portalHomePage.isDisplayed());
	}

	@Then("^Home page should be displayed click on Footer Terms$")
	public void home_page_should_be_displayed_click_on_Footer_Terms() throws Throwable {
	  
		Assert.assertTrue("Portal Home Page is displayed",portalHomePage.isDisplayed());
		
		termsOfUsePage = portalHomePage.clickFooterTerms();
		
		Assert.assertTrue("Validating Terms of Use page is Displayed", termsOfUsePage.isDisplayed());
		
		
	}
	
	

@Then("^Click on Text (\\d+) Quit Link which is navigated to TextQuitMobile page$")
public void click_on_Text_Quit_Link_which_is_navigated_to_TextQuitMobile_page(int arg1) throws Throwable {
   
	textQuitPage = termsOfUsePage.clickOnText2Quit();
	
	Assert.assertTrue("Terms of Use Text 2 Quit page  is launched ",textQuitPage.isDisplayed());
	
	textToQuitTitleFromUI = textQuitPage.getTitle();
	
	Assert.assertTrue("Text 2 Quit page title is as expected",textToQuitTitleFromUI.contains(TermOfUsePageConstants.TEXT_TO_QUIT_PAGE_TITLE));
	
}

@Then("^Click on here link which is navigated to Terms of use page$")
public void click_on_here_link_which_is_navigated_to_Terms_of_use_page() throws Throwable {
    
	termsOfUsePage1 = textQuitPage.clickOnHere();
	
	Assert.assertTrue("Validating Terms of Use page is Displayed", termsOfUsePage1.isDisplayed());
	
	termsOfUsePage1.closeCurrentPage();
	

	textQuitPage.switchBackToText2QuitPage();
	
	textQuitPage.closeCurrentPage();
	
	termsOfUsePage.switchBackToTermsOfUsePage();
	
	Assert.assertTrue("Validating Terms of Use page is Displayed", termsOfUsePage.isDisplayed());
	
	
}

@Then("^Click on Privacy Link navigated to Privacy Policy Page and navigate to Terms of use page$")
public void click_on_Privacy_Link_navigated_to_Privacy_Policy_Page_and_navigate_to_Terms_of_use_page() throws Throwable {
    

	privacyPage = termsOfUsePage.clickOnPrivacyPolicy();
	
	Assert.assertTrue("Terms of Use Privacy page  is launched ",privacyPage.isDisplayed());
	
	privacyPolicyTilteFromUI = privacyPage.getTitle();
	
	Assert.assertTrue("Privacy Policy page title is as expected",privacyPolicyTilteFromUI.contains(TermOfUsePageConstants.PRIVACY_POLICY_PAGE_TITLE));
	
	privacyPage.closeCurrentPage();

    termsOfUsePage.switchBackToTermsOfUsePage();
	
	Assert.assertTrue("Validating Terms of Use page is Displayed", termsOfUsePage.isDisplayed());
}


}
