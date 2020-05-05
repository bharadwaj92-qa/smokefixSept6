package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alerehealth.ui.portal.settings.*;
import org.junit.Assert;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfilesettingandAvatarStepDefinition {
	
	PortalLoginPage portalLoginPage=null;
	PortalHomePage portalHomePage=null;
	SettingsBasePage basePage=null;
	CommunicationsPage communicationsPage=null;
	
	ContactInfoPage contactInfoPage=null;
	DeviceAndAppsPage deviceAndAppsPage=null;

	ProfilePage profilePage=null;
	CreateUpdateProfilePage createUpdateProfilePage=null;

	@Given("^Login to portal using userName and password$")
	public void login_to_portal_using_userName_and_password(DataTable arg1) throws Throwable {
	    
		 portalLoginPage = new PortalLoginPage();
	     portalHomePage = portalLoginPage.doLogin("test445873@gn.com","asdf");
	}

	@When("^User navigate to communication page$")
	public void user_navigate_to_communication_page() throws Throwable {
		
		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
		
		basePage = portalHomePage.clickSettingsOfUser();
        String breadCrumbFromUI = basePage.getNavigationFromBreadCrumb();
        String breadCrumbExpected = "Health Portal>Settings>Profile>";
        Assert.assertEquals("Validating whether breadCrumb is matching", breadCrumbFromUI,breadCrumbExpected );
	    
	}

	@Then("^Validate user can check check boxes and submit prefernces\\.$")
	public void validate_user_can_check_chec_boxes_and_submit_prefernces() throws Throwable {
		
		communicationsPage = basePage.navigateToCommunicationsPage();
        String communicationsBreadCrumbFromUI = communicationsPage.getNavigationFromBreadCrumb();
        String communicationBreadCrumbExpected = "Health Portal>Settings>Communication>";
        Assert.assertEquals("Validating whether breadCrumb is matching", communicationsBreadCrumbFromUI,communicationBreadCrumbExpected );
        
        communicationsPage.selectAllCheckBoxes();
        communicationsPage.clickSavePreferences();
        String successMsgFromUI = communicationsPage.getSuccessMessage();
        String successMsgExpected = "Got it! We saved your changes. Come back to this page to make updates any time.";
        Assert.assertEquals("Validating saving preferences msg", successMsgFromUI, successMsgExpected);
        Assert.assertTrue(communicationsPage.isFeaturesandUpdatesCheckBoxChecked());
        Assert.assertTrue(communicationsPage.isProgramHighlightsCheckBoxChecked());
        Assert.assertTrue(communicationsPage.isStayinginTouchCheckBox());
        Assert.assertTrue("",communicationsPage.isToYourHealthCheckBoxChecked());
	    
	}
	
	@When("^User navigate to Setting Page$")
	public void user_navigate_to_Setting_Page() throws Throwable {
	 
		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
		
		basePage = portalHomePage.clickSettingsOfUser();
	}

	@Then("^Validate all left links on settingpage$")
	public void validate_all_left_links_on_settingpage() throws Throwable {
		
		List<String> leftnavigationLinksFromUI = basePage.getLeftNavigationMenuLinks();

        String navLinks [] = new String[]{"Profile","Devices & Apps","Contact Info","Communication","Community Notifications"};

        List<String> leftnavigationLinksExpected = Arrays.asList(navLinks);
        
        Assert.assertTrue("Validating whether all the links are present", leftnavigationLinksFromUI.containsAll(leftnavigationLinksExpected));

        String breadCrumbFromUI = basePage.getNavigationFromBreadCrumb();

        String breadCrumbExpected = "Health Portal>Settings>Profile>";

        Assert.assertEquals("Validating whether breadCrumb is matching", breadCrumbFromUI,breadCrumbExpected );
	}
	
	
	
	@When("^User navigate to ContactInfoPage$")
	public void user_navigate_to_ContactInfoPage() throws Throwable {
		
		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
		
		basePage = portalHomePage.clickSettingsOfUser();
        String breadCrumbFromUI = basePage.getNavigationFromBreadCrumb();
        String breadCrumbExpected = "Health Portal>Settings>Profile>";
        Assert.assertEquals("Validating whether breadCrumb is matching", breadCrumbFromUI,breadCrumbExpected );
        contactInfoPage = basePage.navigateToContactInfoPage();   
	    
	}

	@Then("^Validate the name on contactInfo Page$")
	public void validate_the_name_on_contactInfo_Page() throws Throwable {
	   
		String nameOfContact =  contactInfoPage.getFieldValue("Name");

        Assert.assertFalse("Valdiating that name isnt empty", (nameOfContact!=null && nameOfContact.isEmpty()));

        String contactInfoBreadCrumbFromUI = contactInfoPage.getNavigationFromBreadCrumb();

        String contactInfoBreadCrumbExpected = "Health Portal>Settings>Contact Info>";

        Assert.assertEquals("Validating whether breadCrumb is matching", contactInfoBreadCrumbFromUI,contactInfoBreadCrumbExpected );
	    
	}
	
	
	@When("^User navigate to device and apps page$")
	public void user_navigate_to_device_and_apps_page() throws Throwable {
		
		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;
		
		basePage = portalHomePage.clickSettingsOfUser();

        String breadCrumbFromUI = basePage.getNavigationFromBreadCrumb();

        String breadCrumbExpected = "Health Portal>Settings>Profile>";

        Assert.assertEquals("Validating whether breadCrumb is matching", breadCrumbFromUI,breadCrumbExpected );

        deviceAndAppsPage = basePage.navigateToDeviceAndAppsPage();

        String devicesAppsBreadCrumbFromUI = deviceAndAppsPage.getNavigationFromBreadCrumb();

        String devicesAppsBreadCrumbExpected = "Health Portal>Settings>Devices & Apps>";

        Assert.assertEquals("Validating whether breadCrumb is matching", devicesAppsBreadCrumbFromUI,devicesAppsBreadCrumbExpected );
	
	}

	@Then("^Validate links on page,check learn more functionality and check user can navigate to new window when clicking on add device button$")
	public void validate_links_on_page_check_learn_more_functionality_and_check_user_can_navigate_to_new_window_when_clicking_on_add_device_button() throws Throwable {
		
        Assert.assertTrue("Valdiating Policy Link is present",deviceAndAppsPage.isprivacyPolicyLinkPresent());

        Assert.assertTrue("Valdiating TermsofUse Link is present",deviceAndAppsPage.isTermsOfUseLinkPresent());

        deviceAndAppsPage.expandByClickingLearnMore();

        String disclaimerText =  deviceAndAppsPage.getDisclaimerTextFromLearnMore();

        Assert.assertTrue("Validating Disclaimer link present",(disclaimerText!=null&&!disclaimerText.isEmpty()));

        deviceAndAppsPage.clickAddDevices();

        List<String> devicesList  = deviceAndAppsPage.getDevicesFromAddNewDeviceWindow();

        Assert.assertFalse("Valdiating whether devices list is empty",devicesList.isEmpty());

        deviceAndAppsPage.closeAddDevicesWindow();

	}

	@When("^User navigate to EditProfile Page$")
	public void userNavigateToEditProfilePage() throws Throwable {

		portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

		basePage = portalHomePage.clickSettingsOfUser();

		String breadCrumbFromUI = basePage.getNavigationFromBreadCrumb();

		String breadCrumbExpected = "Health Portal>Settings>Profile>";

		Assert.assertEquals("Validating whether breadCrumb is matching", breadCrumbFromUI,breadCrumbExpected );

		createUpdateProfilePage= basePage.clickOnUpdateProfileButton();
	}

	@Then("^Validate profile avatar selection,check success message after selecting profile avatar$")
	public void validateProfileAvatarSelectionCheckSuccessMessageAfterSelectingProfileAvatar(DataTable arg1) throws Throwable {
		String screenName=null;
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

		String hairstyle =  (String) dataMap.get("hairStyleNumber");
		String expression =  (String) dataMap.get("expressionNumber");
		String color =  (String) dataMap.get("colorName");

		int intHairstyle=Integer.parseInt(hairstyle);
		int intExpression=Integer.parseInt(expression);
		int intColor=Integer.parseInt(color);

		createUpdateProfilePage.setScreenName(screenName);

		createUpdateProfilePage.selectAvatar(intHairstyle);

		createUpdateProfilePage.selectExpression(intExpression);

		createUpdateProfilePage.selectColor(intColor);

		profilePage=createUpdateProfilePage.clickUpdateProfileButton();

		String messageContentFromUI=profilePage.getAlertMessageContent();

		Assert.assertEquals("Validating message content from UI","Saved. The changes you made were saved successfully.",messageContentFromUI);

		HashMap<String,String> details = profilePage.getAvatarDetails();

		Assert.assertEquals("Validating hairstyle from UI", details.get("hairstyle"), hairstyle);

		Assert.assertEquals("Validating expression from UI", details.get("expression"), expression);

		Assert.assertEquals("Validating color from UI", details.get("color"), color);
	}
}
