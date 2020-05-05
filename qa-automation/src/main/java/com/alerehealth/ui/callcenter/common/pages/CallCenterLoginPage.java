package com.alerehealth.ui.callcenter.common.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class CallCenterLoginPage extends SeleniumQflCallCenterPage {
	
		@FindBy(id="txtUserID")
	    public WebElement userID;


	    @FindBy(id="txtPassword")
	    public WebElement password;

	    @FindBy(xpath ="//button[@class='button' and  @title='Log in to PegaRULES.']")
	    private WebElement loginButton;


	    public void setUserName(String userName) {

	        this.userID.sendKeys(userName);
	    }

	    public void setPassword(String password) {

	        this.password.sendKeys(password);
	    }

	    public void clickLoginButton(){

			System.out.println("Clicking on Login button");

			loginButton.sendKeys(Keys.ENTER);

	    }


	    
	    
	    public CallCenterHomePage doLogin(String username, String password, String role){

	    	CallCenterHomePage callCenterHomePage = null;
	    	CallCenterAdministrativePage callCenterAdminPage = null;

	        setUserName(username);
	        setPassword(password);

	        clickLoginButton();

	        try{


				callCenterHomePage =  new CallCenterHomePage();

				callCenterHomePage.selectUserRole(role);


	        }catch(Exception e){

	        	e.printStackTrace();
	          


				callCenterAdminPage =  new CallCenterAdministrativePage();
				callCenterAdminPage.isDisplayed();

				callCenterAdminPage.selectUserRole(role);

				callCenterHomePage = new CallCenterHomePage();

				callCenterHomePage.selectUserRole(role);

	        }

	        return callCenterHomePage;

	    }


	    @Override
	    public boolean isDisplayed() {

	        return userID.isDisplayed();
	    }
	    
	    
	  

}
