package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.registration.ProgramEligibility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.alerehealth.ui.portal.registration.CreateLoginIDPage;
import org.openqa.selenium.support.ui.Select;

public class AboutYouSignUpPage extends SeleniumPage<AboutYouSignUpPage> {



    @FindBy(id="FirstName")
    private WebElement firstName;

    @FindBy(id="LastName")
    private WebElement lastName;

    @FindBy(id="UniqueID" )
    private WebElement uniqueId;

    @FindBy(id="register_currentPage_fields_'Gender'__value2")
    private WebElement female;

    @FindBy(id="register_currentPage_fields_'Gender'__value1")
    private WebElement male;

    @FindBy(id="Birthdate")
    private WebElement dob;

    @FindBy(id="KeyCode" )
    private WebElement keyCode;

    @FindBy(xpath="//button[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath="//small[text()='Please enter your first name.'][1]")
    private WebElement errorMsgFirstName;

    @FindBy(xpath="//small[text()='Please enter your last name.'][1]")
    private WebElement errorMsgLastName;

    //@FindBy(xpath="//p[text()='Health Net Associates:  Enter your Associate ID, followed by ""MM1"" if you are male or ""FM1"" if you are female (no spaces).']")
    private WebElement uniqueID;

    @FindBy(xpath="//small[text()='Please enter your gender.'][1]")
    private WebElement errorMsgGender;

    @FindBy(xpath="//small[text()='Please enter a value']")
    private WebElement errorMsgDateOfBirth;

    @FindBy(xpath="//p[text()='Congratulations on taking this step to better health! You may have additional benefits available to you. Please call 800-893-5597 to complete your enrollment and speak to a Coach today. (Error code R016)']")
    private WebElement errorMsgWrongUniqueID;

    @FindBy(xpath="//small[text()='Participants must be at least 18 years old to use this site.']")
    private WebElement errorMsgAgeLessThan18;

    @FindBy(xpath="//select[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'relationship']")
    private WebElement relationship;

    @FindBy( id="SubcriberID")
    private WebElement medicalAidTextField;

    @FindBy(id="CompanySponsoredHealthplan")
    private WebElement medicalAidDropDown;

    @FindBy(xpath="//input[@id='ContractNumber']")
    private WebElement groupnumber;

    @FindBy(xpath="//input[@id='SubcriberID']")
    private WebElement SubcriberID;


    public String  getTextOfFirstNameErrorMessage(){
        return errorMsgFirstName.getText().trim();
    }

    public String  getTextOfLastNameErrorMessage(){
        return errorMsgLastName.getText().trim();
    }

    public String  getTextOfGenderErrorMessage(){
        return errorMsgGender.getText().trim();
    }

    public String  getTextOfDateOfBirthErrorMessage(){
        return errorMsgDateOfBirth.getText().trim();
    }

    public String getTextOfWrongUniqueIDErrorMessage(){ return errorMsgWrongUniqueID.getText().trim(); }

    public String getTextOfAgeLessThan18ErrorMessage(){ return errorMsgAgeLessThan18.getText().trim(); }

    public CreateLoginIDPage fillAboutYouForm(String firstName, String lastName, String uniqueID, String gender, String dob){

        setFirstName(firstName);

        setLastName(lastName);

        setUniqueId(uniqueID);

        if(gender.toLowerCase().equals("male")|| gender.toLowerCase().equals("m")){

            setMale();
        }else{

            setFemale();
        }

        setDob(dob);

        clickContinueButton();

        return new CreateLoginIDPage();

    }

    public CreateLoginIDPage fillAboutYouFormForKeyCode(String firstName, String lastName, String gender, String dob){

        fillLoginFormFields(firstName,lastName,gender,dob);

        clickContinueButton();

        return new CreateLoginIDPage();


    }
    public void setFirstName(String firstNameToEnter) {
        firstName.clear();
        firstName.sendKeys(firstNameToEnter);
    }

    public void setLastName(String lastNameToEnter) {
        lastName.clear();
        lastName.sendKeys(lastNameToEnter);
    }

    public void setUniqueId(String uniqueIdToEnter) {
        uniqueId.clear();
        uniqueId.sendKeys(uniqueIdToEnter);
    }

    public void setFemale() {

        javaScriptClick(female);
        //female.click();
    }

    public void setMale() {

        javaScriptClick(male);
        // male.click();
    }
    

    public void setDob(String dobOfUser) {
        dob.clear();
        dob.sendKeys(dobOfUser);
        dob.sendKeys(Keys.TAB);
    }

    public void clickContinueButton(){

        javaScriptClick(continueButton);

        //continueButton.click();
    }

    public void refreshPage(){

        lastName.sendKeys(Keys.F5);
    }

    public void enterKeyCode(String KeyCode){

        keyCode.sendKeys(KeyCode);

    }

    public ProgramEligibility fillAboutYouFormForKeyCodeNew(String firstName, String lastName, String gender, String dob) {

        fillLoginFormFields(firstName,lastName,gender,dob);

        clickContinueButton();


        return new ProgramEligibility();
    }


    public CreateLoginIDPage fillAboutYouFormCommercial(String firstName, String lastName, String gender, String dob, String relationship ){

        fillLoginFormFields(firstName,lastName,gender,dob);

        selectRelationship(relationship);

        clickContinueButton();

        return new CreateLoginIDPage();
    }
    
    public CreateLoginIDPage fillAboutYouFormState(String firstName, String lastName, String gender, String dob, String zipCode ){

    	System.out.println(firstName);
    	
    	 if(firstName!=null&&!firstName.isEmpty()) {
             setFirstName(firstName);
         }

         if(lastName!=null&&!lastName.isEmpty()) {
             setLastName(lastName);
         }

         if(gender!=null&&!gender.isEmpty()) {


             if(gender.toLowerCase().equals("male")|| gender.toLowerCase().equals("m")){

                 setMale();
             }else{

                 setFemale();
             }
         }
         setDob(dob);
        
        if(zipCode!=null&&!zipCode.isEmpty()) {
            setZipCode(zipCode);
        }


        clickContinueButton();

        return new CreateLoginIDPage();
    }

    private void fillLoginFormFields(String firstName, String lastName, String gender,String dob){

        setFirstName(firstName);

        setLastName(lastName);

        if(gender!=null&&!gender.isEmpty()) {


            if(gender.toLowerCase().equals("male")|| gender.toLowerCase().equals("m")){

                setMale();
            }else{

                setFemale();
            }
        }
        setDob(dob);


    }

    public CreateLoginIDPage fillAboutYouFormCombined(String firstName, String lastName, String gender, String dob, String ZipCode, boolean hasMedicalAid, String medicalAid, String KeyCode){
        if(firstName!=null&&!firstName.isEmpty()) {
            setFirstName(firstName);
        }

        if(lastName!=null&&!lastName.isEmpty()) {
            setLastName(lastName);
        }
        if(gender!=null&&!gender.isEmpty()) {
            if(gender.toLowerCase().equals("male")|| gender.toLowerCase().equals("m")){

                setMale();
            }else{

                setFemale();
            }
        }

        if(dob!=null&&!dob.isEmpty()) {
            setDob(dob);
        }

        if(ZipCode!=null&&!ZipCode.isEmpty()) {
            setZipCode(ZipCode);
        }

        if(medicalAid!=null&&!medicalAid.isEmpty()) {
            selectMedicalAid(hasMedicalAid);
        }

        if(medicalAid!=null&&!medicalAid.isEmpty()) {
            setMedicalAid(medicalAid);
        }

        if(KeyCode!=null&&!KeyCode.isEmpty()) {
            enterKeyCode( KeyCode);
        }
        clickContinueButton();

        return new CreateLoginIDPage();
    }



    public void selectRelationship(String option){

        Select selectMedical = new Select(relationship);

        selectMedical.selectByVisibleText(option);

    }

    public void setZipCode(String ZipCode){

        String xpath = "//input[@id='Addrstreet1']";

        WebElement textField = getWebDriver().findElement(By.xpath(xpath));

        textField.clear();
        textField.sendKeys(ZipCode);
    }

    public void setMedicalAid(String medicalAid){

        medicalAidTextField.sendKeys(medicalAid);

    }

    public void selectMedicalAid(boolean hasMedicalAid){

        Select selectMedical = new Select(medicalAidDropDown);

        if(hasMedicalAid){

            selectMedical.selectByVisibleText("Yes");
        }else {

            selectMedical.selectByVisibleText("No");
        }


    }

    public void setgroupnumber(String groupnumbertoenter){
        groupnumber.clear();
        groupnumber.sendKeys(groupnumbertoenter);
    }
    public void setsubscriberid(String subscriberidtoenter){

        SubcriberID.clear();
        SubcriberID.sendKeys(subscriberidtoenter);
    }


    public CreateLoginIDPage fillAboutYouFormnocdb(String firstName, String lastName, String gender, String dob, String groupnumber, String subscriberid) throws InterruptedException{

        fillLoginFormFields(firstName,lastName,gender,dob);

        setgroupnumber(groupnumber);
        setsubscriberid(subscriberid);
        clickContinueButton();

        return new CreateLoginIDPage();
    }
    
    public CreateLoginIDPage fillAboutYouFormClient(String firstName, String lastName, String dob, String groupnumber, String subscriberid) throws InterruptedException{

    	  setFirstName(firstName);

          setLastName(lastName);
          
          setDob(dob);

        setgroupnumber(groupnumber);
        setsubscriberid(subscriberid);
        clickContinueButton();

        return new CreateLoginIDPage();
    }
    
    @Override
    public boolean isDisplayed() {
        return continueButton.isDisplayed();
    }
}
