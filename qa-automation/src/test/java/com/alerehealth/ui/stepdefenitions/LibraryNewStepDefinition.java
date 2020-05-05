package com.alerehealth.ui.stepdefenitions;

import java.util.Map;

import org.junit.Assert;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.library.LibraryPage;
import com.alerehealth.ui.portal.library.SearchandBrowselinkPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LibraryNewStepDefinition {
	
	PortalLoginPage portalLoginPage=null;
	PortalHomePage portalhomepage=null;
	LibraryPage librarypage = null;
	
	SearchandBrowselinkPage searchandBrowselinkPage = null;

	@When("^user navigates to Library Search page and Validate the content cards$")
	public void user_navigates_to_Library_Search_page_and_Validate_the_content_cards() throws Throwable {
		
		portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;
		
		 searchandBrowselinkPage = portalhomepage.openLibraryBrowse();

	}

	@Then("^Validate all content cards in library search page$")
	public void Validate_all_content_cards_in_library_Search_page() throws Throwable {

		librarypage =searchandBrowselinkPage.clickWellnessTab();
        
        String breadCrumbNavigationFromUIWellness = librarypage.getNavigationFromBreadCrumb();
                
        String breadCrumbNavigationFromExpectedWellness = "home Health Portal>Library>Wellness";
        
        Assert.assertTrue("Validating whether Wellness Page present", breadCrumbNavigationFromUIWellness.contains(breadCrumbNavigationFromExpectedWellness));
        
        librarypage.scrollNavigationMenuIntoView();
        
        searchandBrowselinkPage =  librarypage.openLibraryBrowse();
        
        librarypage = searchandBrowselinkPage.clickConditionsTab();
        
        String breadCrumbNavigationFromUIConditions = librarypage.getNavigationFromBreadCrumb();
        
        String breadCrumbNavigationFromExpectedConditions = "home Health Portal>Library>Conditions";
		
        Assert.assertTrue("Validating whether Conditions Page present", breadCrumbNavigationFromUIConditions.contains(breadCrumbNavigationFromExpectedConditions));
        
        librarypage.scrollNavigationMenuIntoView();
        
        searchandBrowselinkPage =  librarypage.openLibraryBrowse();
        
        LibraryPage pregnancyPage = searchandBrowselinkPage.clickPregnancyBabyTab();
        
        String breadCrumbNavigationFromUIpregnancy = pregnancyPage.getNavigationFromBreadCrumb();
        
        String breadCrumbNavigationFromExpectedpregnancy = "home Health Portal>Library>Pregnancy & Baby";
        
        Assert.assertTrue("Validating whether Wellness Page present", breadCrumbNavigationFromUIpregnancy.contains(breadCrumbNavigationFromExpectedpregnancy));
        
        librarypage.scrollNavigationMenuIntoView();
         
        searchandBrowselinkPage =  librarypage.openLibraryBrowse();
        
        LibraryPage tobaccoPage = searchandBrowselinkPage.clickTobaccoFreeTab();
        
        String breadCrumbNavigationFromUItobacco = tobaccoPage.getNavigationFromBreadCrumb();
        
        String breadCrumbNavigationFromExpectedtobacco = "home Health Portal>Library>Tobacco Free";
        
        Assert.assertTrue("Validating whether Wellness Page present", breadCrumbNavigationFromUItobacco.contains(breadCrumbNavigationFromExpectedtobacco));
        
        librarypage.scrollNavigationMenuIntoView();
        
	}

}
