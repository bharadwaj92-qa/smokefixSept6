package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.settings.YourProgramPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PortalLoginPage extends SeleniumPortalPage {


    @FindBy(xpath="//li[contains(@class,'ogn-header-link-list')]//a[@href='startRegistration']")
    private WebElement createOneNow;

    @FindBy(xpath="//h1[text()='Log In']")
    public WebElement textLogin;

    @FindBy(id="login_username")
    public WebElement userName;

    @FindBy(xpath="//div[@role='alert']")
    public WebElement errorMsgLogin;

    @FindBy(id="login_password")
    public WebElement password;

    @FindBy(xpath ="//button[text()='Sign In']")
    private WebElement signinButton;

    @FindBy(xpath="//*[@id='login_username']/ancestor::div[contains(@class,'form-group')]/small[not(contains(@style,'none'))]")
    public WebElement userNameFieldErrorMsg;

    @FindBy(xpath="//*[@id='login_password']/ancestor::div[contains(@class,'form-group')]/small[not(contains(@style,'none'))]")
    public static WebElement pwdFieldErrorMsg;

    @FindBy(xpath="//li[contains(@class,'ogn-header-link-list')]//a[@href='startRegistration']")
    private WebElement signUpLink;
    
    @FindBy(xpath="//a[@href='forgotPassword']")
    private WebElement passwordTooltip;

    public SignUpPage clickSignUp(){

        signUpLink.click();

        return new SignUpPage();
    }

    public void setUserName(String userName) {

        this.userName.sendKeys(userName);
    }

    public void setPassword(String password) {

        this.password.sendKeys(password);
    }

    public void clickSiginInButton(){

        signinButton.click();
    }
    

    public PortalHomePage doLogin(String username, String password){

        PortalHomePage portalHomePage = null;

        setUserName(username);
        setPassword(password);

        clickSiginInButton();

        try{

            TOUPage touPage = new TOUPage();

            portalHomePage = touPage.acceptTerms();

        }catch(Exception e){

            //e.printStackTrace();

            portalHomePage = new PortalHomePage();

        }

        return portalHomePage;

    }

    public void doLoginInvalidCred(String username, String password){

        setUserName(username);
        setPassword(password);

        clickSiginInButton();

    }
    
    public void enterLoginID(String username){
    	
    	setUserName(username);
    }
    
    public YourProgramPage doLoginValidCred(String username, String password){

        setUserName(username);
        setPassword(password);

        clickSiginInButton();
        
        return new YourProgramPage();

    }


    public String  getTextOfLoginErrorMessage(){
        return errorMsgLogin.getText().substring(1).trim();
    }

    public void emptyCredLogin(){

        getWebDriver().navigate().refresh();
        clickSiginInButton();

    }

    public void invalidUserLogin(String username, String password){

        setUserName(username);
        setPassword(password);

    }

    public static String getPasswordFieldErrorMessage(){
        return pwdFieldErrorMsg.getText().trim();
    }

    public String  getUserNameFieldErrorMessage(){
        return userNameFieldErrorMsg.getText().trim();
    }

    public String getLoginPageTitle(){
        return textLogin.getText().trim();
    }

    public SignUpPage clickCreateOneNow(){

        createOneNow.click();

        return new SignUpPage();
    }

    public TOUPage submitLoginCredentials(String username, String password){

        setUserName(username);
        setPassword(password);

        clickSiginInButton();

        return new TOUPage();
    }
    
    public ResetPasswordPage clickPasswordTooltip(){
    	
    	waitForElementToBeDisplayed(passwordTooltip);
    	
    	//javaScriptClick(passwordTooltip);
    	
    	passwordTooltip.click();
    	
    	return new ResetPasswordPage();
    	
    }
    
    /*
     * To get tooltip text for Login or Password
     */
    public String getTooltipText(String field){
    	
    	String id ="";
    	field=field.toUpperCase();
		 
		 switch(field){
		 
		 
		 
		 case "LOGIN": id="forgotUsername";
		                       break;
		 case "PASSWORD" : id= "forgotPassword";
		                    break;
		 
		 }
		 String xpath = "//a[@href='"+id+"']//span[@class='sr-only']";
		 WebElement tooltipEle = getWebDriver().findElement(By.xpath(xpath));
		 
		 return tooltipEle.getText().trim();
    }
    
    
    
    

    @Override
    public boolean isDisplayed() {
        return userName.isDisplayed();
    }
}
