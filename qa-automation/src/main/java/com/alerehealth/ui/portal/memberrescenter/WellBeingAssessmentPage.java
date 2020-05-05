package com.alerehealth.ui.portal.memberrescenter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

public class WellBeingAssessmentPage extends SeleniumPage<WellBeingAssessmentPage>{
	
	@FindBy(xpath="//h1[contains(text(),'Take your Wellbeing Assessment')]")
	private WebElement wellbeingAssessmentTitle;
	

	@Override
	public boolean isDisplayed() {
		
		return wellbeingAssessmentTitle.isDisplayed();
	}

}
