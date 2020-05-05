package com.alerehealth.ui.stepdefenitions;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterLoginPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterAdvancedSearchPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterSmartSearchPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeScreenSearchStepDef {

	CallCenterLoginPage callCenterLoginPage = null;
	CallCenterSmartSearchPage callCenterSmartSearchPage = null;
	CallCenterAdvancedSearchPage advancedSearchPage = null;
	public static CallCenterHomePage callCenterHomePage;
	
	@Then("^User navigates to search page and click on Advanced Search$")
	public void user_navigates_to_search_page_and_click_on_Advanced_Search() throws Throwable {

		callCenterSmartSearchPage.gotoHomePage();
		
		callCenterSmartSearchPage =  callCenterHomePage.openSearchPage();

        advancedSearchPage = callCenterSmartSearchPage.clickAdvancedSearch();
        
	}

	@Then("^Setting the OptumID and performing the search$")
	public void setting_the_OptumID_and_performing_the_search() throws Throwable {

		advancedSearchPage.setOptumID("9999999999");
		
		advancedSearchPage.clickSearchButton();
	}

	@When("^User navigates to search page and click on Smart Search$")
	public void user_navigates_to_search_page_and_click_on_Smart_Search() throws Throwable {
		
		callCenterHomePage = HomeScreenHeaderStepDef.callCenterHomePage;
		
		callCenterSmartSearchPage =  callCenterHomePage.openSearchPage();
				
	}

	@When("^Setting the PID and doing the smart search$")
	public void setting_the_PID_and_doing_the_smart_search() throws Throwable {

		 String p_id= "6795852";

	     callCenterSmartSearchPage.performSmartSearch(p_id);

	     callCenterSmartSearchPage.selectSearchResultFromAutoComplete(p_id);
	}

	@When("^Validating the PID search results$")
	public void validating_the_PID_search_results() throws Throwable {

		String pid = callCenterSmartSearchPage.getSearchResult("PID", 1);

        System.out.println(pid);
	}
	
}
