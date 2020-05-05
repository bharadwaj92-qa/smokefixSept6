package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.alerehealth.fwk.common.CallCenterConstants;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterClientPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CallCenterDMA3StepDef {

	CallCenterParticipantHomePage callCenterParticipantHomePage;
	CallCenterClientPage callCenterClientPage = null;
	

	String valueFromClientHeaderUI;
	List<String> configOptiondetails ;

	List<String>  configRowData497;
	List<String>  configRowData498;
	
	
	@When("^Verify the Clients tab is displaying on (\\d+) View$")
	public void verify_the_Clients_tab_is_displaying_on_View(int arg1) throws Throwable {
		
		callCenterParticipantHomePage = new CallCenterParticipantHomePage();
                      
		  callCenterClientPage = callCenterParticipantHomePage.selectClientTab();
		 
		  Assert.assertTrue("Validating Client Page is Displayed", callCenterClientPage.isDisplayed());
			
	       valueFromClientHeaderUI = callCenterClientPage.getTitleOfClientPage();
			
	        Assert.assertEquals("Validating Insurance Details Text as Title in Client Page", valueFromClientHeaderUI, CallCenterConstants.CLIENT_PAGE_INSURANCEDETAILS_EXPECTEDTEXT);
	}

	@When("^Expand the Config Options section$")
	public void expand_the_Config_Options_section() throws Throwable {
              
        callCenterClientPage.expandOrCollapseSection("Config Options","expand");
        
        Assert.assertTrue("Validating Config Options section with Expand and collapse option", callCenterClientPage.isclientLabelExpand("Config Options")); 
	}


	
	@Then("^Config Options Names Monitoring Mobile App should be displayed$")
	public void config_Options_Names_Monitoring_Mobile_App_should_be_displayed(DataTable arg1) throws Throwable {
	  
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

        String OptionName = (String) dataMap.get("optionName");
        String OptionValue = (String) dataMap.get("optionValue");
        
        
        configOptiondetails=callCenterClientPage.getConfigOptionColumnNames();
        Assert.assertTrue(configOptiondetails.containsAll(Arrays.asList("Vendor ID", "App ID", "Prg Cat Code", "Prg ID", "Prg Name", "Option ID","Option Name","Option Value","Option Value Description")));
		
		configRowData497 = callCenterClientPage.getConfigRowDataValue("Option ID","497", "Option Name", "Option Value");
		
		Assert.assertTrue(configRowData497.containsAll(Arrays.asList(OptionName,OptionValue)));
	}

	@Then("^Config Options Names Monitoring Mobile App Delivery should be displayed$")
	public void config_Options_Names_Monitoring_Mobile_App_Delivery_should_be_displayed(DataTable arg1) throws Throwable {
	    
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

        String OptionName = (String) dataMap.get("optionName");
        String OptionValue = (String) dataMap.get("optionValue");
        
        configRowData498 = callCenterClientPage.getConfigRowDataValue("Option ID","498", "Option Name", "Option Value");;
		
		Assert.assertTrue(configRowData498.containsAll(Arrays.asList(OptionName,OptionValue)));
	}



}
