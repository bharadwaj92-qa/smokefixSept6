package com.alerehealth.ui.portal.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.qfl.SaveContactInfoPage;

public class YourProgramPage extends SeleniumPage<YourProgramPage>{

	@FindBy(xpath="//h1[contains(text(),'Program')]")
	private WebElement headingProgramCondition;
	
	
	/*
	 * value should be taken from Upgrade plan section headings such as Program Website, Coaching Calls 
	 * 
	 */
	public SaveContactInfoPage clickUpgradeIntervention(String value){
		
		String xpath = "//strong[contains(text(),'"+value+"')]//..//following-sibling::a";
		WebElement interventionBtn = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(interventionBtn);
		
		return new SaveContactInfoPage();
		
	}
	
	
	public String getEnrolledPlan(){
		
		String xpath ="//h3[@class='h3']//following-sibling::span";
		WebElement planEle = getWebDriver().findElement(By.xpath(xpath));
		
		return planEle.getText().trim();
	}
	
	public boolean isServiceEnrolledButtonEnabled(String service){
		
		String xpath = "//strong[contains(text(),'"+service+"')]//..//following-sibling::td//button[contains(text(),'Enrolled')] ";
		WebElement button =  getWebDriver().findElement(By.xpath(xpath));
		return button.isEnabled();
	}
	
	public SaveContactInfoPage clickAddThisButton(String service){
		
		String xpath="//strong[contains(text(),'"+service+"')]//..//following-sibling::td//a";
		WebElement button = getWebDriver().findElement(By.xpath(xpath));
		button.click();
		
		return new SaveContactInfoPage();
		
	}
	
	
	@Override
	public boolean isDisplayed() {
		
		return headingProgramCondition.isDisplayed();
		
	}

}
