package com.alerehealth.ui.portal.memberrescenter;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

public class Text4BabyPage extends SeleniumPage<Text4BabyPage>{
	
	
  
	public String getText4BabyUrl(){
		
		return  getWebDriver().getCurrentUrl();
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
	
