package com.alerehealth.ui.portal.registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

public class ProgramEligibility extends SeleniumPage<ProgramEligibility> {

	@FindBy(name="submitWtAssessment")
	private WebElement assessmentForm; 
	
	
	 @FindBy(xpath = "//label[@for='field-for-eClinical3Yes']")
	 private WebElement pregnantYes;
	 
	 @FindBy(xpath = "//label[@for='field-for-eClinical3No']")
	 private WebElement pregnantNo;
	
	 @FindBy(xpath = "//label[@for='field-for-eClinical4Yes']")
	 private WebElement dialysisYes;
	 
	 @FindBy(xpath = "//label[@for='field-for-eClinical4No']")
	 private WebElement dialysisNo;
	 
	 @FindBy(xpath ="//label[@for='field-for-eClinical6Yes']")
	 private WebElement weighLossSurgeryisYes;
	 
	 @FindBy(xpath ="//label[@for='field-for-eClinical6No']")
	 private WebElement weighLossSurgeryisNo;
	 
	 @FindBy(xpath ="//label[@for='field-for-eClinical7Yes']")
	 private WebElement surgeryInLast12MonthsisYes;
	 
	 @FindBy(xpath ="//label[@for='field-for-eClinical7No']")
	 private WebElement surgeryInLast12MonthsisNo;

	 @FindBy(xpath ="//select[@class='custom-select dropdown-enroll']")
	 private WebElement selectDiabetesType;
	 
	 @FindBy(id ="height-feet")
	 private WebElement enterHeightFeet;
	 
	 @FindBy(id = "height-inches")
	 private WebElement enterHeightInches;
	 
	 @FindBy(id = "weight")
	 private WebElement enterWeight;
	 
	 @FindBy(xpath = "//button[@class='btn btn--primary']")
	 private WebElement clickContinue;
	 
	 @FindBy(xpath = "//div[@class='container typography content--width-auto']/p")
	 private WebElement errorMessage;
	 
	 @FindBy(xpath = "//button[@class='btn btn--primary']")
	 private WebElement backButtonOnErrorPage;
	 
	 @FindBy(xpath = "//button[@onclick='assessmentCancel();']")////button[@onclick='assessmentCancel();']
	 private WebElement closeButtonAtErrorMessagePage;
	 
	 
	 public void clickCloseButtonOnErrorMessage(){
		 
		 closeButtonAtErrorMessagePage.click();
	 }
	 
	 
	 public void clickBackButtonOnErrorPage(){
		 
		 backButtonOnErrorPage.click();
		
	 }
	 
	 public String getErrorMessageText(){
		
		return errorMessage.getText().trim(); 
	 }
	 
	 public void selectDialysis(String ans){
		 
		 if(ans.toLowerCase().equals("yes") && !dialysisYes.isSelected()){
			   
			 dialysisYes.click();
		 }
		 else if(ans.toLowerCase().equals("no") && !dialysisYes.isSelected()){
			 
			 dialysisNo.click();
		 }
	 }
	 
	 public void selectWeightLossSurgery(String ans){
		 
		 if(ans.toLowerCase().equals("yes") && !weighLossSurgeryisYes.isSelected()){
			   
			 weighLossSurgeryisYes.click();
		 }
		 else if(ans.toLowerCase().equals("no") && !weighLossSurgeryisYes.isSelected()){
			 
			 weighLossSurgeryisNo.click();
		 }
	 }
	 
	 public void WeightLossSurgeryInLast12Months(String ans){
		 
		 if(ans.toLowerCase().equals("yes") && !surgeryInLast12MonthsisYes.isSelected()){
			   
			 surgeryInLast12MonthsisYes.click();
		 }
		 else if(ans.toLowerCase().equals("no") && !surgeryInLast12MonthsisNo.isSelected()){
			 
			 surgeryInLast12MonthsisNo.click();
		 }
	 }
	 
	 
	 public void selectDiabetesType(String ans){

		Select selectDiabetesDropDown = new Select(selectDiabetesType);
		selectDiabetesDropDown.selectByVisibleText(ans);
	 }
	
	 
	 public void enterHeightFeet(String feet){
		 
		 enterHeightFeet.sendKeys(feet);
	 }
	 
	 public void enterHeightInches(String inches){
		 
		 enterHeightInches.sendKeys(inches);
	 }
	 
	 public void enterWeight(String weight){
		 
		 enterWeight.sendKeys(weight);
	 }
	  
	 public CreateLoginIDPage clickContinueButton(){
		 
		 clickContinue.click();
		 
		 return new CreateLoginIDPage();
	 }
	 
	 public void selectPregnancy(String ans){
		 
		 if(ans.toLowerCase().equals("yes") && !dialysisYes.isSelected()){
			   
			 pregnantYes.click();
		 }
		 else if(ans.toLowerCase().equals("no") && !dialysisYes.isSelected()){
			 
			 pregnantNo.click();
		 }
		  
	 }
	 
	 public void clickOnContinueButton(){
		 
		 
		 clickContinue.click();
		 
		 
	 }
	 
	@Override
	public boolean isDisplayed() {

		waitForElementToBeDisplayed(assessmentForm);
		
		return assessmentForm.isDisplayed();
	}
	
}
