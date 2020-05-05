package com.alerehealth.ui.stepdefenitions;

import org.junit.Assert;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterDeviceMonitoringPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterDevicesPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Devices360StepDef {

	public static CallCenterHomePage callCenterHomePage;
	CallCenterOthersHomeMenuPage callCenterOthersHomeMenuPage = null;
	CallCenterParticipantHomePage callCenterParticipantHomePage=null;
	CallCenterDevicesPage callCenterDevicesPage=null;
		
	@When("^Navigating to Others tab and Validating Other tab loaded successfully in devices (\\d+)$")
	public void navigating_to_Others_tab_and_Validating_Other_tab_loaded_successfully_in_devices(int arg1) throws Throwable {

		callCenterHomePage = new CallCenterHomePage();
		
		callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();
        
        Assert.assertTrue("Validating Others Home Page is available", callCenterOthersHomeMenuPage.isDisplayed());
        
        callCenterParticipantHomePage = callCenterOthersHomeMenuPage.searchParticipant("P-355267");
        
	}

	@When("^Verify the Devices tab is displaying on (\\d+) View$")
	public void verify_the_Devices_tab_is_displaying_on_View(int arg1) throws Throwable {
        
		callCenterDevicesPage = callCenterParticipantHomePage.selectDevicesTab("Devices");
        
	}

	@When("^Verify Devices and Refresh button are displaying$")
	public void verify_Devices_and_Refresh_button_are_displaying() throws Throwable {
        
        Assert.assertTrue("Validating Devices Tab available or not",callCenterDevicesPage.isDeviceOptionPresent());
        
        Assert.assertTrue("Validating Refresh Button available or not",callCenterDevicesPage.isDeviceRefreshButtonPresent());
        
	}


	@Then("^Verify the sections under Devices widget$")
	public void verify_Verify_the_sections_under_Devices_widget() throws Throwable {
		
		Thread.sleep(2000);

      Assert.assertTrue("Validating Device Troubleshooting History Tab displaying or not",callCenterDevicesPage.isDisplayedDevicesTitleBarLabel("titleBarLabelStyle", "Device Troubleshooting History"));
      
      Assert.assertTrue("Validating Device History Tab displaying or not",callCenterDevicesPage.isDisplayedDevicesTitleBarLabel("titleBarLabelStyle", "Device History"));
      
      Assert.assertTrue("Validating Measurement Criteria Tab displaying or not",callCenterDevicesPage.isDisplayedDevicesTitleBarLabel("titleBarLabelStyle", "Measurement Criteria"));
      
      Assert.assertTrue("Validating List Score Tab displaying or not",callCenterDevicesPage.isDisplayedDevicesTitleBarLabel("titleBarLabelStyle", "List Score"));
      
      Assert.assertTrue("Validating Validic Devices Tab displaying or not",callCenterDevicesPage.isDisplayedDevicesTitleBarLabel("titleBarLabelStyle", "Validic Devices"));
      
      Assert.assertTrue("Validating Validic Devices Tab displaying or not",callCenterDevicesPage.isDisplayedDevicesTitleBarLabel("cursordefault titleBarLabelStyleExpanded", "Device List"));
      
      Assert.assertTrue("Validating Validic Devices Tab displaying or not",callCenterDevicesPage.isDisplayedDevicesTitleBarLabel("titleBarLabelStyleExpanded", "Temporary Absences"));
      
      
	}
	
}
