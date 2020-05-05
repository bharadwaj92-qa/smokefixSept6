package com.alerehealth.ui.portal.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

public class CommonHelpPage extends SeleniumPage<CommonHelpPage> {
	
	@FindBy(xpath = "//*[contains(@class,'page--help')]")
	private WebElement helpContainer;

	@FindBy(xpath = "//ul[@class='ogn__header-link-list dropdown']//a[@href='startRegistration']")
	private WebElement signupLink;
	
	public SignUpPage clickSignUp(){
		
		signupLink.click();
		
		return new SignUpPage();
		
	}
	
	@Override
	public boolean isDisplayed() {

		return helpContainer.isDisplayed();
	}
	
	
	
}
