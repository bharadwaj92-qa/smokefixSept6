package com.alerehealth.ui.callcenter.common.pages;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

public abstract class CallCenterBasePage <T extends SeleniumPage<?>> extends SeleniumPage<T> {
	
	
	  public CallCenterBasePage(){

	        initPage();

	        if(!isPageDisplayed()){

	            throw new RuntimeException("Couldn't load page"+ this.getClass());
	        }



	    }



}
