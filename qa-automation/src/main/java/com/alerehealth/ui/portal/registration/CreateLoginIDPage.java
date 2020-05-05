package com.alerehealth.ui.portal.registration;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.common.pages.TOUPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateLoginIDPage extends SeleniumPage<CreateLoginIDPage> {

    /**@FindBy(xpath = "//p[contains(text(),'Step 2 of  2')]")
    private WebElement signuppagenumber;*/

    @FindBy(id ="Email")
    private WebElement loginID;

    @FindBy(id ="ConfirmEmail")
    private WebElement confirmloginID;

    @FindBy(id ="PrimaryEmail")
    private WebElement emailAddr;

    @FindBy(id ="ConfirmPrimaryEmail")
    private WebElement confirmemailAddr	;

    @FindBy(id="Password")
    private WebElement password;

    @FindBy(id="ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id="FirstSecurityQuestion")
    private WebElement securityQuestion1;

    @FindBy(id="FirstSecurityAnswer")
    private WebElement answer1;

    @FindBy(id="FirstSecurityHint")
    private WebElement hint1;

    @FindBy(id="SecondSecurityQuestion")
    private WebElement securityQuestion2;

    @FindBy(id="SecondSecurityAnswer")
    private WebElement answer2;

    @FindBy(id="SecondSecurityHint")
    private WebElement hint2;

    @FindBy(id="ThirdSecurityQuestion")
    private WebElement securityQuestion3;

    @FindBy(id="ThirdSecurityAnswer")
    private WebElement answer3;

    @FindBy(id="ThirdSecurityHint")
    private WebElement hint3;

    @FindBy(xpath="//button[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath="//small[text()='Please provide a login ID.Needs to be in email format.'][1]")
    private WebElement errorMsgLoginID;

    @FindBy(xpath="//small[text()='Please enter your new password'][1]")
    private WebElement errorMsgPassword;

    @FindBy(xpath="//small[text()='Please enter your confirm password'][1]")
    private WebElement errorMsgConfirmPassword;

    @FindBy(xpath="//small[text()='Please select a question.'][1]")
    private WebElement errorMsgSecurityQuestion1;

    @FindBy(xpath="//small[text()='Please enter an answer.'][1]")
    private WebElement errorMsgSecurityAnswer1;

    @FindBy(xpath="//small[text()='Please provide a hint for your answer.'][1]")
    private WebElement errorMsgSecurityHint1;

    @FindBy(xpath="//small[text()='Please select a question.'][2]")
    private WebElement errorMsgSecurityQuestion2;

    @FindBy(xpath="//small[text()='Please enter an answer.'][2]")
    private WebElement errorMsgSecurityAnswer2;

    @FindBy(xpath="//small[text()='Please provide a hint for your answer.'][2]")
    private WebElement errorMsgSecurityHint2;


    @FindBy(xpath="//small[text()='Please select a question.'][3]")
    private WebElement errorMsgSecurityQuestion3;

    @FindBy(xpath="//small[text()='Please enter an answer.'][3]")
    private WebElement errorMsgSecurityAnswer3;

    @FindBy(xpath="//small[text()='Please provide a hint for your answer.'][3]")
    private WebElement errorMsgSecurityHint3;

    public String getTextOfLoginIDErrorMessage(){
        return errorMsgLoginID.getText().trim();
    }

    public String getTextOfPasswordErrorMessage(){
        return errorMsgPassword.getText().trim();
    }

    public String getTextOfConfirmPasswordErrorMessage(){
        return errorMsgConfirmPassword.getText().trim();
    }

    public String getTextOfSecurityQuestion1ErrorMessage(){
        return errorMsgSecurityQuestion1.getText().trim();
    }

    public String getTextOfSecurityAnswer1ErrorMessage(){
        return errorMsgSecurityAnswer1.getText().trim();
    }

    public String getTextOfSecurityHint1ErrorMessage(){
        return errorMsgSecurityHint1.getText().trim();
    }

    public String getTextOfSecurityQuestion2ErrorMessage(){
        return errorMsgSecurityQuestion2.getText().trim();
    }

    public String getTextOfSecurityAnswer2ErrorMessage(){
        return errorMsgSecurityAnswer2.getText().trim();
    }

    public String getTextOfSecurityHint2ErrorMessage(){
        return errorMsgSecurityHint2.getText().trim();
    }

    public String getTextOfSecurityQuestion3ErrorMessage(){
        return errorMsgSecurityQuestion3.getText().trim();
    }

    public String getTextOfSecurityAnswer3ErrorMessage(){
        return errorMsgSecurityAnswer3.getText().trim();
    }

    public String getTextOfSecurityHint3ErrorMessage(){
        return errorMsgSecurityHint3.getText().trim();
    }

    public void setLoginID(String loginIdToEnter)
    {
        loginID.sendKeys(loginIdToEnter);
    }

    public void setConfirmLoginID(String confirmloginIdToEnter)
    {
        confirmloginID.sendKeys(confirmloginIdToEnter);
    }

    public void setEmailAddr(String emailAddrToEnter)
    {
        emailAddr.sendKeys(emailAddrToEnter);
    }

    public void setEmailConfirmAddr(String confirmemailAddrToEnterToEnter)
    {
        confirmemailAddr.sendKeys(confirmemailAddrToEnterToEnter);
    }



    public void setPassword(String passwordToEnter)
    {
        password.sendKeys(passwordToEnter);
    }

    public void setConfirmPassword(String confirmPasswordToEnter)
    {
        confirmPassword.sendKeys(confirmPasswordToEnter);
    }

    public void selectSecurityQn1(String securityQn1ToSelect)
    {
        Select securityQuestion1DropDown = new Select(securityQuestion1);
        securityQuestion1DropDown.selectByVisibleText(securityQn1ToSelect);
    }

    public void setAnswer1(String answer1ToEnter)
    {
        answer1.sendKeys(answer1ToEnter);
    }

    public void setHint1(String hint1ToEnter)
    {
        hint1.sendKeys(hint1ToEnter);
    }

    public void selectSecurityQn2(String securityQn2ToSelect)
    {
        Select securityQuestion2DropDown = new Select(securityQuestion2);
        securityQuestion2DropDown.selectByVisibleText(securityQn2ToSelect);
    }

    public void setAnswer2(String answer2ToEnter)
    {
        answer2.sendKeys(answer2ToEnter);
    }

    public void setHint2(String hint2ToEnter)
    {
        hint2.sendKeys(hint2ToEnter);
    }

    public void selectSecurityQn3(String securityQn3ToSelect)
    {
        Select securityQuestion3DropDown = new Select(securityQuestion3);
        securityQuestion3DropDown.selectByVisibleText(securityQn3ToSelect);
    }

    public void setAnswer3(String answer3ToEnter)
    {
        answer3.sendKeys(answer3ToEnter);
    }

    public void setHint3(String hint3ToEnter)
    {
        hint3.sendKeys(hint3ToEnter);
    }

    public void clickContinueButton(){

        continueButton.click();

    }

    public void fillLoginIDSection(String loginID,String confirmloginID,String emailaddr,String confirmemailadd, String password, String confirmPassword){
        setLoginID(loginID);

        setConfirmLoginID(confirmloginID);
        setEmailAddr(emailaddr);
        setEmailConfirmAddr(confirmemailadd);

        setPassword(password);
        setConfirmPassword(confirmPassword);
    }
    public void fillLoginIDSection(String loginID, String password, String confirmPassword){
        setLoginID(loginID);
        setPassword(password);
        setConfirmPassword(confirmPassword);
    }

    public void fill1stSecurityQuestionSection(String securityQuestion1, String answer1, String hint1){
        selectSecurityQn1(securityQuestion1);
        setAnswer1(answer1);
        setHint1(hint1);
    }

    public void fill2ndSecurityQuestionSection(String securityQuestion2, String answer2, String hint2){
        selectSecurityQn2(securityQuestion2);
        setAnswer2(answer2);
        setHint2(hint2);
    }

    public void fill3rdSecurityQuestionSection(String securityQuestion3, String answer3, String hint3){
        selectSecurityQn3(securityQuestion3);
        setAnswer3(answer3);
        setHint3(hint3);
    }

    public TOUPage fillLoginIDForm(String loginID,String confirmloginID,String emailaddr,String confirmemailaddr, String password, String confirmPassword, String securityQuestion1, String answer1, String hint1, String securityQuestion2, String answer2, String hint2, String securityQuestion3, String answer3, String hint3){
        fillLoginIDSection(loginID,confirmloginID,emailaddr,confirmemailaddr, password,confirmPassword);
        fill1stSecurityQuestionSection(securityQuestion1, answer1, hint1);
        fill2ndSecurityQuestionSection(securityQuestion2, answer2, hint2);
        fill3rdSecurityQuestionSection(securityQuestion3, answer3, hint3);
        clickContinueButton();
        return new TOUPage();
    }

    public TOUPage fillLoginIDForm(String loginID, String password, String confirmPassword, String securityQuestion1, String answer1, String hint1, String securityQuestion2, String answer2, String hint2, String securityQuestion3, String answer3, String hint3){
        fillLoginIDSection(loginID, password,confirmPassword);
        fill1stSecurityQuestionSection(securityQuestion1, answer1, hint1);
        fill2ndSecurityQuestionSection(securityQuestion2, answer2, hint2);
        fill3rdSecurityQuestionSection(securityQuestion3, answer3, hint3);
        clickContinueButton();
        return new TOUPage();
    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(loginID);
        return loginID.isDisplayed();
    }


}
