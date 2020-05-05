package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.common.CallCenterConstants;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterLoginPage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterDeviceMonitoringPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeviceMonitoringStepDef {

	public static CallCenterHomePage callCenterHomePage;
	CallCenterOthersHomeMenuPage callCenterOthersHomeMenuPage = null;
	CallCenterParticipantHomePage callCenterParticipantHomePage=null;
	CallCenterDeviceMonitoringPage callCenterDeviceMonitoringPage=null;
	
	@When("^Navigating to Others tab and Validating Other tab loaded successfully$")
	public void navigating_to_Others_tab_and_Validating_Other_tab_loaded_successfully() throws Throwable {
		
		callCenterHomePage = new CallCenterHomePage();
		
		callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();
        
        Assert.assertTrue("Validating Others Home Page is available", callCenterOthersHomeMenuPage.isDisplayed());
        
        callCenterParticipantHomePage = callCenterOthersHomeMenuPage.searchParticipant("P-355267");
        
	}

	@When("^Verify the Device Monitoring tab is displaying on (\\d+) View$")
	public void verify_the_Device_Monitoring_tab_is_displaying_on_View(int arg1) throws Throwable {
        
		callCenterDeviceMonitoringPage = callCenterParticipantHomePage.selectDeviceMonitoring("Device Monitoring");
        
        String valueFromDeviceTransmissionUI = callCenterDeviceMonitoringPage.getTitleOfDeviceTransmission();
        
        Assert.assertEquals("Validating DeviceTransmission Text", valueFromDeviceTransmissionUI, CallCenterConstants.DEVICE_TRANSMISSION_PAGE_EXPECTEDTEXT);
        
        
	}

	@When("^Verify the Graph in Device Monitoring page$")
	public void verify_the_Graph_in_Device_Monitoring_page() throws Throwable {
		
		Assert.assertTrue("Validating Device Transmission Graph is available in the page", callCenterDeviceMonitoringPage.isDeviceTransmissionGraphPresent());
		
	}

	@Then("^Verify the Device Monitoring tab filter fileds Status,Range,Filter button$")
	public void verify_the_Device_Monitoring_tab_filter_fileds_Status_Range_Filter_button() throws Throwable {

		Assert.assertTrue("Validating Device Transmission StatusOption is available in the page", callCenterDeviceMonitoringPage.isDeviceTransmissionStatusOptionPresent());
        
        Assert.assertTrue("Validating Device Transmission RangeOption is available in the page", callCenterDeviceMonitoringPage.isDeviceTransmissionRangeOptionPresent());
        
        Assert.assertTrue("Validating Device Transmission FilterOption is available in the page", callCenterDeviceMonitoringPage.isDeviceTransmissionFilterOptionPresent());
        
        
	}

	@Then("^Verify Status drop down options All,Review Completed,Not Useful and Un-reviewed are displaying$")
	public void verify_Status_drop_down_options_All_Review_Completed_Not_Useful_and_Un_reviewed_are_displaying() throws Throwable {

		List<String> statusOptionUI = callCenterDeviceMonitoringPage.deviceTransmissionStatusList();
        
        String statusOptionsExpected[] = CallCenterConstants.DEVICE_TRANSMISSION_STATUSLIST_EXPECTEDTEXT.split(",");
        
        Assert.assertEquals("Validating DeviceTransmission StatusOptions", statusOptionUI, Arrays.asList(statusOptionsExpected));
        
	}

	@Then("^Verify Range drop down options Select,Period and Date are displaying$")
	public void verify_Range_drop_down_options_Select_Period_and_Date_are_displaying() throws Throwable {

		List<String> rangeOptionUI = callCenterDeviceMonitoringPage.deviceTransmissionRangeList();
        
        String rangeOptionsExpected[] = CallCenterConstants.DEVICE_TRANSMISSION_RANGELIST_EXPECTEDTEXT.split(",");
        
        Assert.assertEquals("Validating DeviceTransmission RangeOptions", rangeOptionUI, Arrays.asList(rangeOptionsExpected));
        
	}

	
}
