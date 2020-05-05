package com.alerehealth.ui.portal.memberrescenter;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

public class MemberDiscountPage extends SeleniumPage<MemberDiscountPage>{
	
	
  
	public String getMemberDiscountPdfUrl(){
		
		return  getWebDriver().getCurrentUrl();
	}
	
	
	@Override
	public boolean isDisplayed() {
		
		return false;
	}

}
