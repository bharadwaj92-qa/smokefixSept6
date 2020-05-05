package com.alerehealth.ui.callcenter.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CallCenterAdministrativePage extends CallCenterBasePage<CallCenterHomePage> {
	
	@FindBy(xpath="//span[@class='titleBarLabelStyleExpanded' and text()='WorkBasket Urgency']")
	private WebElement txtWorkBasket;
	
	@FindBy(xpath= "//select[@id='pyCurrentApplication']")
	private WebElement roleDropDown;
	
	public void clickRoleSelectionDropdown(){
		
		waitForElementToBeDisplayed(roleDropDown);
		roleDropDown.click();
	}
	
	
	public void selectUserRole(String role){
		
		clickRoleSelectionDropdown();

		String roleXpath = "//select[@id='pyCurrentApplication']//following-sibling::option[contains(text(),'"+role+"')]";
		WebElement elementRole = getWebDriver().findElement(By.xpath(roleXpath));
		elementRole.click();
		
		waitForSpecifiedTime(10);
		
	}
	


	@Override
	public boolean isDisplayed() {
		
		waitForElementToBeDisplayed(txtWorkBasket);
		
		return txtWorkBasket.isDisplayed();
	}
	
	
	

}
