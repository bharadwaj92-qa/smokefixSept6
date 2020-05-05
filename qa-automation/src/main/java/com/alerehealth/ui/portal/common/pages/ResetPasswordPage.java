package com.alerehealth.ui.portal.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.selenium.common.SeleniumPage;


public class ResetPasswordPage extends SeleniumPage<ResetPasswordPage>{
   
	@FindBy(xpath="//div[@class='ogn__title__left' ]//following-sibling::h1[contains(text(),'Reset Password')]")
	private WebElement titleResetPwd;
	
	@FindBy(xpath="//h3[contains(text(),'Forgot your password?')]")
	private WebElement txtForgotPwd;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(xpath="//p[@class='three']")
	private WebElement txtMsgForgotPwd;
	
	public String getForgotPasswordText(){
		
		return txtForgotPwd.getText().trim();
		
	}
	
	public String getForgotPasswordBelowMessage(){
		
		return txtMsgForgotPwd.getText().trim();
	}
	
	public void clickContinue(){
		
		waitForElementToBeDisplayed(btnContinue);
		javaScriptClick(btnContinue);
		waitForSpecifiedTime(3);
	}
	
	public String getErrorMessageInSecurityForEmptyData(){
		
		String xpath = "//small[@data-fv-validator='notEmpty'] ";
		WebElement errorMsgEle = getWebDriver().findElement(By.xpath(xpath));
		return errorMsgEle.getText().trim();
	}
	
	public boolean isLoginIDAndTextboxDisplayed(){
		
		String xpath = "//span[contains(text(),'Login ID')]//following-sibling::input[@id='username']//..";
		WebElement loginIDTextBoxEle = getWebDriver().findElement(By.xpath(xpath));
		return loginIDTextBoxEle.isDisplayed();
	}
	
	public String getErrorMessage(){
		
		String xpath = "//div[@class='container typography content--width-auto error']//h2";
		WebElement msgEle = getWebDriver().findElement(By.xpath(xpath));
		return msgEle.getText().trim();
	}
	
	public boolean isSecurityQuestionPageDisplayed(String heading){
		
		String xpath = "//h3[contains(text(),'"+heading+"')]";
		WebElement pageEle = getWebDriver().findElement(By.xpath(xpath));
		
		return  pageEle.isDisplayed();
	}
	
	 public void enterSecurityAnswer(String answer) {
         
		    String xpath = "//input[@id='AlerePasswordRecoveryAnswer']";
			WebElement answerEle = getWebDriver().findElement(By.xpath(xpath));
			answerEle.sendKeys(answer);
	 }
	
	
	/*public boolean isResetPasswordPageDisplayed(){
		
		String xpath="//form[@action='resetPassword']";
		WebElement passwordEle = getWebDriver().findElement(By.xpath(xpath));
		
		return passwordEle.isDisplayed();
		
	}
	*/
	
	public boolean isPasswordFieldDisplayed(String field){
		
		String xpath = "//input[@name='"+field+"'] ";
		WebElement pwdEle = getWebDriver().findElement(By.xpath(xpath));
		
		return pwdEle.isDisplayed();
	}
	
	 public void setPasswordAndConfirmPassword(String field,String password) {
            
		    String xpath = "//input[@name='"+field+"'] ";
			WebElement passwordEle = getWebDriver().findElement(By.xpath(xpath));
			passwordEle.sendKeys(password);
	 }
	 
	 public void clearFields(String field,String password){
		 
		 String xpath = "//input[@name='"+field+"'] ";
			WebElement passwordEle = getWebDriver().findElement(By.xpath(xpath));
			passwordEle.clear();
			
	 }
	 
	 /*
	  * 
	  * Specing field as "password " or "confirmPassword"
	  */
	 public String getPasswordErrorMsg(String field,String value){
         
		 String id ="";
		 value=value.toUpperCase();
		 
		 switch(value){
		 
		 case "REGEXPRESSION": id="regexp";
		                       break;
		 case "IDENTICAL" : id= "identical";
		                    break;
		 
		 }
		 String xpath = "//input[@name='"+field+"']//..//following-sibling::small[@data-fv-validator='"+id+"']";
		 WebElement messageEle = getWebDriver().findElement(By.xpath(xpath));
		 
		 return messageEle.getText().trim();
	 }
	 
	 /*
	  *  Specifying field as "password " or "confirmPassword"
	  */
	 public void enterPassword(String field,String password){
		 
		 setPasswordAndConfirmPassword(field,password);
	 }
	 
	 public void enterLogin(String loginID){
		 
		 String xpath = "//span[contains(text(),'Login ID')]//following-sibling::input[@id='username']//..";
			WebElement loginIDTextBoxEle = getWebDriver().findElement(By.xpath(xpath));
			loginIDTextBoxEle.sendKeys(loginID);
	 }
	 
	 
     public PortalLoginPage clickContinueButton(){
		 
    	 waitForElementToBeDisplayed(btnContinue);
 		javaScriptClick(btnContinue);
		 
		 return new PortalLoginPage();
	 }
     
     public PortalLoginPage clickLoginButton(){
    	 
    	String xpath = "//a[@class='btn btn--secondary']";
    	WebElement btnLoginEle = getWebDriver().findElement(By.xpath(xpath));
    	waitForElementToBeDisplayed(btnLoginEle);
 		javaScriptClick(btnLoginEle);
 		
 		return new PortalLoginPage();
     }
	 
	 
	 
	
	@Override
	public boolean isDisplayed() {
		waitForElementToBeDisplayed(titleResetPwd);
		return titleResetPwd.isDisplayed();
	}

}
