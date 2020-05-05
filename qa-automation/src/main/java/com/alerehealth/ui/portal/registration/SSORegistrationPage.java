package com.alerehealth.ui.portal.registration;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SSORegistrationPage  extends SeleniumPage<SSORegistrationPage> {


    @FindBy(name="TARGET")
    private WebElement target;

    @FindBy(name="UniqueId")
    private WebElement uniqueID;

    @FindBy(name="FirstName")
    private WebElement firstName;

    @FindBy(name="LastName")
    private WebElement lastName;


    @FindBy(name="DateOfBirth")
    private WebElement dOB;

    @FindBy(name="Gender")
    private WebElement gender;

    @FindBy(xpath="//input[@name='Submit'][1]")
    private WebElement submitButton;

    @FindBy(xpath="//button[text()='Continue']")
    private WebElement continueButton;



    public void setTargetURL(String targetURL)
    {
        target.clear();
        target.sendKeys(targetURL);
    }

    public void setUniqueID(String uniqueIDToEnter){
        uniqueID.clear();
        uniqueID.sendKeys(uniqueIDToEnter);
    }

    public void setFirstName(String firstNameToEnter){
        firstName.clear();
        firstName.sendKeys(firstNameToEnter);
    }

    public void setLastName(String lastNameToEnter){
        lastName.clear();
        lastName.sendKeys(lastNameToEnter);
    }

    public void setDOB(String dateOfBirthToEnter){
        dOB.clear();
        dOB.sendKeys(dateOfBirthToEnter);
    }

    public void setGender(String genderToEnter){
        gender.clear();
        gender.sendKeys(genderToEnter);
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public void clickContinue(){
        continueButton.click();
    }

    public void fillSSOForm(String target, String uniqueID, String firstName, String lastName, String dOB, String gender){

        setTargetURL(target);
        setUniqueID(uniqueID);
        setFirstName(firstName);
        setLastName(lastName);
        setDOB(dOB);
        setGender(gender);
        clickSubmit();
        clickContinue();


    }

    @Override
    public boolean isDisplayed() {
        return uniqueID.isDisplayed();
    }
}
