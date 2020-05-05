package com.alerehealth.ui.c3po.common.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class C3POLoginPage extends C3POBasePage<C3POLoginPage> {


    @FindBy(id="txtUserID")
    private WebElement userName;

    @FindBy(id="txtPassword")
    private WebElement password;


    @FindBy(name="pyActivity=Code-Security.Login")
    private WebElement loginButton;
    
    

    public void setUserName(String userName) {
    	
        this.userName.sendKeys(userName);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
    	waitForElementToBeEnabled(this.loginButton);
    	 
        this.loginButton.click();
        
        
        explictwaitForTitle("Client Configuration Center");
        
       
     
      
    }
    
    

public C3POHomePage doLogin(String username,String pass) 
{
	
    setUserName(username);
    
    setPassword(pass);
    
    clickLoginButton();
    
    
    return new C3POHomePage();
	
	
}
    
    
    
    @Override
    public boolean isDisplayed() {

        return userName.isDisplayed();
    }
}
