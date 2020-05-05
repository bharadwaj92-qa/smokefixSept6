package com.alerehealth.ui.portal.qfl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;

public class QFLPreSignupPage extends SeleniumPage<QFLPreSignupPage>{
	
	@FindBy(id="continue")
    private WebElement continueBtn;
	
	
	public void selectRadioButton(String question,String value){
		String xpath = "//label[contains(text(),'"+question+"')]//..//..//..//div//following-sibling::input[@value='"+value+"'] ";
		WebElement ansEle = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(ansEle);
	}
	
	
	public void selectDropdown(String question,String option){
		
		String xpath = "//span[contains(text(),'"+question+"')]//..//select";
		WebElement dropDownEle = getWebDriver().findElement(By.xpath(xpath));
		
		 Select select = new Select(dropDownEle);

	        select.selectByVisibleText(option);
	}
	
	public SignUpPage clickContinueBtn(){
		
		javaScriptClick(continueBtn);
		
		return new SignUpPage();
	}
	
	
	public InterventionSelectionPage clickContinueButton(){
		
		javaScriptClick(continueBtn);
		
		return new InterventionSelectionPage();
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return continueBtn.isDisplayed();
	}

}
