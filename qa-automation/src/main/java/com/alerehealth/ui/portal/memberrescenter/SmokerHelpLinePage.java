package com.alerehealth.ui.portal.memberrescenter;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

public class SmokerHelpLinePage extends SeleniumPage<SmokerHelpLinePage>{
	
	
	
	public String getSmokerHelplinePdfUrl(){
		
		return  getWebDriver().getCurrentUrl();
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
