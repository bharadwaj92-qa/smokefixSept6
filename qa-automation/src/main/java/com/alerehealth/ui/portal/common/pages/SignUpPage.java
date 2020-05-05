package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import  com.alerehealth.fwk.common.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends SeleniumPage<MarketingPage> {

    @FindBy( xpath="//label[@class='field-label' and text()='English']")
    private WebElement englishRadioButton;

    @FindBy( id="radio2")
    private WebElement spanishRadioButton;

    @FindBy(id="affiliationId")
    private WebElement role;

    @FindBy(id="registeringAs_0")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='registeringAs']//button[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath="//h1[text()='Sign Up']")
    private WebElement signUpHeaderText;

    @FindBy(xpath="//small[@class='help-block language-message error has-error']")
    private WebElement errorMsgLanguage;

    @FindBy(xpath="//small[@class='help-block affiliation-message']")
    private WebElement errorMsgAffiliation;

    @FindBy(xpath="//p[text()='The keycode you entered is not valid. Please try again or contact Customer Care at 877-719-9004 or at corpfeedback@pronouncedhealth.com.(Error Code R003)']")
    private WebElement errorMsgWrongKeyCode;

    @FindBy(id="KeyCode")
    private WebElement keycode;

    @FindBy(xpath="//small[text()='Please enter your keycode.']")
    private WebElement errorMsgKeyCode;

    @FindBy(xpath="//select[@id='affiliationId']/option")
    private WebElement roleList;


    @FindBy(xpath="//li[contains(@class,'ogn-header-link-list')]//a[@href='login']")
    private WebElement loginLink;

    @FindBy(xpath="//li[contains(@class,'ogn-header-link-list')]//a[@href='startRegistration']")
    private WebElement signUpLink;
    
    @FindBy(xpath= "//a[contains(@class,'logo') and contains(@class,'header')]")
    protected WebElement clientLogo;

    public SignUpPage clickSignUp(){

        signUpLink.click();

        return new SignUpPage();
    }
    
 public PortalLoginPage clickClientLogo(){
    	
    	javaScriptClick(clientLogo);
    	
    	return new PortalLoginPage();
    }





    public PortalLoginPage clickLoginLink(){

        loginLink.click();

        return new PortalLoginPage();
    }


    public void clickEnglishRadioButton(){

         javaScriptClick(englishRadioButton);

       // englishRadioButton.click();

    }

    public void clickSpanishRadioButton(){


        javaScriptClick(spanishRadioButton);
       // spanishRadioButton.click();
    }


    public void selectRole(String roleToSelect){

        Select roleDropDown = new Select(role);

        roleDropDown.selectByVisibleText(roleToSelect);


    }



    public List<String> getRoleList(){


        List<String> roleList = new ArrayList<String>();

        List<WebElement> roles = getWebDriver().findElements(By.xpath("//select[@id='affiliationId']/option"));

        for(WebElement role : roles){

            roleList.add(role.getText().trim());

        }

        return roleList;

    }



    public void clickContinueButton(){

       WebElement continueButton = getWebDriver().findElement(By.xpath("//button[contains(@class,'btn--primary')]"));

        continueButton.click();

    }
    
    public AboutYouSignUpPage clickContinueBtn(){

        WebElement continueButton = getWebDriver().findElement(By.xpath("//button[contains(@class,'btn--primary')]"));

         continueButton.click();
         
         return new AboutYouSignUpPage();

     }

    public void clickCancelButton(){

        cancelButton.click();
    }
    
    public MarketingPage clickCancel(){
    	
    	String xpath = "//button[@class='btn btn--secondary']";
    	WebElement cancelBtn = getWebDriver().findElement(By.xpath(xpath));
    	
    	cancelBtn.click();
    	
    	return new MarketingPage();
    }

    public String  getTextOfLanguageErrorMessage(){
        return errorMsgLanguage.getText().trim();
    }


    public String getTextOfAffiliationErrorMessage(){
        return errorMsgAffiliation.getText().trim();
    }

    public String getTextOfKeyCodeErrorMessage(){
        return errorMsgKeyCode.getText().trim();
    }

    public String getTextOfWrongKeyCodeErrorMessage(){
        return errorMsgWrongKeyCode.getText().trim();
    }

    public AboutYouSignUpPage signUpAsAnEnglishKeyCodeUser(){

        clickEnglishRadioButton();

        selectRole(Constants.SIGN_UP_DROPDOWN_KEYCODE_TEXT);

        clickContinueButton();

        return new AboutYouSignUpPage();
    }

    public AboutYouSignUpPage fillSignUpForm(String language, String registeringAs ){

        if(language.toLowerCase().equals("english")){

            clickEnglishRadioButton();
        }else{

            clickSpanishRadioButton();
        }

        selectRole(registeringAs);

        clickContinueButton();

        return new AboutYouSignUpPage();
    }
    
    

    public AboutYouSignUpPage fillSignUpForm(String language){
    	
    	 if(language.toLowerCase().equals("english")){

             clickEnglishRadioButton();
         }else{

             clickSpanishRadioButton();
         }
    	 
    	 clickContinueButton();

         return new AboutYouSignUpPage();

    	
    }
    

    public void setKeycode(String keycodeToEnter)
    {
        keycode.clear();
        keycode.sendKeys(keycodeToEnter);
    }

    public AboutYouSignUpPage fillKeyCodeForm(String keycode)
    {
        setKeycode(keycode);
        clickContinueButton();
        return new AboutYouSignUpPage();
    }

    public String getSignupPageTitle(){
        return signUpHeaderText.getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return englishRadioButton.isDisplayed();
    }
}
