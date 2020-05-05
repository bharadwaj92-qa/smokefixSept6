package com.alerehealth.ui.portal.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.qfl.QFLStartupPage;

public class IdAndPasswordPage extends SeleniumPage<IdAndPasswordPage>{
	
	PortalHomePage portalHomePage = new PortalHomePage();
	
	@FindBy(xpath="//button[@id='createnewpassword']")
	private WebElement saveChangesBtn;
	
	@FindBy(xpath="//a[@id='cancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//h3[text()='Change Password']")
	private WebElement changePasswordTitle;
	
	@FindBy(xpath="//h3[contains(text(),'Password & Security Questions')]")
	private WebElement idPasswordPage;
	
	public void clickChangeButton(String value){
		
		String id="";
		
		value=value.toUpperCase();
		
		switch(value){
		
		case "LOGIN":  {id = "Change Login ID";
		              break;}
		              
		case "PASSWORD" : {id = "Change Password";   
		                break;}
		}
		
		String xpath = "//a[@class='btn btn--secondary' and contains(text(),'"+id+"')]";
		WebElement btnEle = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(btnEle);
	}
	
	/*
	 * 
	 * Field should be currentPassword,  createNewPassword, confirmNewPassword
	 */
	 public void setPassword(String value,String password) {
		 
		 String field="";
			
			value=value.toUpperCase();
			
			switch(value){
			
			 case "CURRENTPASSWORD" :  field = "currentPassword";
	                                  break;
	          
	         case "NEWPASSWORD" :  field = "createNewPassword";
                                       break;
    
	        case "CONFIRMNEWPASSWORD" :  field = "confirmNewPassword";
                                       break;
    
		 
			}
		    String xpath = "//input[@name='"+field+"'] ";
			WebElement passwordEle = getWebDriver().findElement(By.xpath(xpath));
			passwordEle.sendKeys(password);
	 }
	 
	 /*
		 * 
		 * Field should be currentPassword,  createNewPassword, confirmNewPassword,question_1,question_2,question_3
		 */
	 public boolean isPasswordQuestionFieldDisplayed(String value) {
		 
		 String field = " ";
		 value=value.toUpperCase();
		 
		 switch(value){
		 
		 case "CURRENTPASSWORD" :  field = "currentPassword";
		          break;
		          
		 case "NEWPASSWORD" :  field = "createNewPassword";
                   break;
         
		 case "CONFIRMNEWPASSWORD" :  field = "confirmNewPassword";
                   break;
         
		 case "QUESTION1" :  field = "question_1";
                  break;
         
		 case "QUESTION2" :  field = "question_2";
                  break;
         
		 case "QUESTION3" :  field = "question_3";
                   break;
		 
		 }
		    String xpath = "//label[@for='"+field+"'] ";
			WebElement fieldEle = getWebDriver().findElement(By.xpath(xpath));
			
			return fieldEle.isDisplayed();
	 }
	 
	 
	 public void clearFields(String value){
		 
		 String field="";
			
			value=value.toUpperCase();
			
			switch(value){
			
			 case "CURRENTPASSWORD" :  field = "currentPassword";
	                                  break;
	          
	         case "NEWPASSWORD" :  field = "createNewPassword";
                                    break;
 
	        case "CONFIRMNEWPASSWORD" :  field = "confirmNewPassword";
                                    break;
 
		 
			}
		    String xpath = "//input[@name='"+field+"'] ";
			WebElement passwordEle = getWebDriver().findElement(By.xpath(xpath));
			passwordEle.clear();
		 
	 }
	 
	
	 public boolean isSaveChangesButtonDisplayed(){
		 
		 return saveChangesBtn.isDisplayed();
	 }
	
    public boolean isCancelButtonDisplayed(){
		 
		 return cancelBtn.isDisplayed();
	 }
    
    
    public void clickSaveChangesButton(){
    	
    	javaScriptClick(saveChangesBtn);
    	waitForSpecifiedTime(2);
    }
    
 public void clickCancelButton(){
    	
    	javaScriptClick(cancelBtn);
    	waitForSpecifiedTime(2);
    }
	 
    public String getErrorMessageInChangePassword(String value){
    	
    	 String id ="";
    	 String field = " ";
		 value=value.toUpperCase();
		 
		 switch(value){
		 
		 case "NEWPASSWORDEMPTY": id="notEmpty";
		                       field="createNewPassword";
		                       break;
		 case "CURRENTPASSWORDEMPTY" : id= "notEmpty";
		                     field = "currentPassword";
		                    break;
		                    
		 case "NEWPASSWORDREGEX": id="regexp";
                              field="createNewPassword";
                               break;
                               
		 case "PASSWORDIDENTICAL": id="identical";
                             field="confirmNewPassword";
                             break;                       

		 }
		 String xpath = "//small[@data-fv-validator ='"+id+"' and  @data-fv-for='"+field+"']";
		 WebElement messageEle = getWebDriver().findElement(By.xpath(xpath));
		 
		 return messageEle.getText().trim();
    	
    }
    
    public QFLStartupPage clickSignoutButton(){
    	
    	portalHomePage.clickSignOut();
  
    	return new QFLStartupPage();
    	
    }
	

	
	public boolean isChangePasswordDisplayed() {

		return changePasswordTitle.isDisplayed();
	}

	@Override
	public boolean isDisplayed() {
		
		return idPasswordPage.isDisplayed();
	}
	
	
	

}
