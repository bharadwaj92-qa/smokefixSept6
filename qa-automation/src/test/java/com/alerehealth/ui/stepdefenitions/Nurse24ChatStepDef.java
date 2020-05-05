package com.alerehealth.ui.stepdefenitions;

import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.ui.portal.coaching.Nurse24ChatWindowPage;
import com.alerehealth.ui.portal.coaching.NurseAdviceLinePage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Nurse24ChatStepDef {

	PortalHomePage portalHomePage=null;
	NurseAdviceLinePage nurseAdviceLinePage=null;
	Nurse24ChatWindowPage nurse24ChatWindowPage=null;

	@When("^User navigate to Nurse Advice Line page from submenu$")
	public void user_navigate_to_Nurse_Advice_Line_page_from_submenu() throws Throwable {
    	
    	portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
    	
    	List<String> coachingMenuItemsFromUI = portalHomePage.getMenuItemsUnderMenu("Coaching");

        List<String> coachingMenuItemsExpected = ClientConfiguration.getClientConfiguration().getCoachingMenuItems();

        Assert.assertTrue("Coaching menu from UI matches with expected", coachingMenuItemsExpected.containsAll(coachingMenuItemsFromUI));

        nurseAdviceLinePage = portalHomePage.navigateToNurseAdviceLinePage();

        Assert.assertTrue("Nurse 24 Landing page is displayed", nurseAdviceLinePage.isDisplayed());

        String nurse24PageLandingTextFromUI = nurseAdviceLinePage.getNurse24PageWelcomeText();

        String nurse24PageLandingTextExpected = ClientConfiguration.getClientConfiguration().getNurse24LandingPageWelcomeText();

        Assert.assertTrue("Appropriate Welcome message is displayed", nurse24PageLandingTextFromUI.contains(nurse24PageLandingTextExpected) );


        
    }

    @Then("^Validate navigation to StartChat window and check validation message$")
    public void validate_navigation_to_StartChat_window_and_check_validation_message() throws Throwable {
    	

         nurse24ChatWindowPage = nurseAdviceLinePage.clickStartChat();
    	
    	Assert.assertTrue("Chat Window is opened", nurseAdviceLinePage.isChatWindowOpened());
       
    	nurse24ChatWindowPage.clickOnStartChatButton();
        
        String nurseStartChatValidationMesssageFromUI=nurse24ChatWindowPage.getStartChatValidationMessage();
        
        String nurseStartChatValidationMesssageExpected=ClientConfiguration.getClientConfiguration().getStartChatValidationMessage();
        
        Assert.assertTrue("Appropriate validation message is displayed",nurseStartChatValidationMesssageFromUI.contains(nurseStartChatValidationMesssageExpected));
        
        nurse24ChatWindowPage.closeChatWindow();
        
        nurseAdviceLinePage.switchBackToNurseAdviceLinePage();
        
        nurseAdviceLinePage.clickClientLogo();
        
       
        
    }
    
    
    @When("^User navigate to Nurse Advice Line page from zone(\\d+) section$")
    public void user_navigate_to_Nurse_Advice_Line_page_from_zone_section(int arg1) throws Throwable {
    	
    	portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
    	
    	nurseAdviceLinePage = portalHomePage.openNurseAdviceLineFromZone3();
       
    }

    @Then("^Validate welcome message on Nurse Advice Line page$")
    public void validate_welcome_message_on_Nurse_Advice_Line_page() throws Throwable {
        
    	String nurse24PageLandingTextFromUI=nurseAdviceLinePage.getNurse24PageWelcomeText();
    	
    	String nurse24PageLandingTextExpected = ClientConfiguration.getClientConfiguration().getNurse24LandingPageWelcomeText();

        Assert.assertTrue("Appropriate Welcome message is displayed", nurse24PageLandingTextFromUI.contains(nurse24PageLandingTextExpected));
        
    }



}
