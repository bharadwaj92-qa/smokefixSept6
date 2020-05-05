package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.ui.portal.common.pages.MarketingPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MarketingHeadersandFootersStepDef {
	MarketingPage marketingPage=null;
	
	@Given("^Launch the Marketing page$")
	public void launch_the_Marketing_page() throws Throwable {
		
		 marketingPage=new MarketingPage();
		
	}

	@Then("^i verify the footers \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" in marketing page$")
	public void i_verify_the_footers_in_marketing_page(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		
		String footerLinks[]={arg1,arg2,arg3,arg4};
		
		List<String> footerLinksFromUI=marketingPage.getFooterLinks();
		
		System.out.println("footerLinksFromUI"+footerLinksFromUI);
		
		List<String> footerLinksExpected = Arrays.asList(footerLinks);
		
    	Assert.assertTrue("Verifying footer links on MarketingPage",footerLinksFromUI.containsAll(footerLinksExpected));
	  
	   
	}

	@Then("^i verify the headers\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" in marketing page$")
	public void i_verify_the_headers_in_marketing_page(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		
		String marketingPageHeaderTitle = marketingPage.getMarketingPageHeaderTitle();
		String marketingPageHeaderTitleExpected = ClientConfiguration.getClientConfiguration().getMarketingPageTitle();
				
		Assert.assertEquals("Header title matches", marketingPageHeaderTitleExpected,marketingPageHeaderTitle);
		
		String headers[]={arg2,arg3};
		
		List<String> headerLinksFromUI=marketingPage.getHeaderLinks();
		
		System.out.println("headerLinksFromUI"+headerLinksFromUI);
		
		List<String> headerLinksExpected = Arrays.asList(headers);
		
		System.out.println("headerLinksExpected"+headerLinksExpected);
		
    	Assert.assertTrue("Verifying Header links on Login",headerLinksFromUI.containsAll(headerLinksExpected));
    	
    	Assert.assertTrue("Verifying the client logo is displayed",marketingPage.isClientLogoDisplayed());
	   
	}



}
