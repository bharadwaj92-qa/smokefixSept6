package com.alerehealth.ui.portal.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunicationsPage extends SettingsBasePage {

    @FindBy(className="communication")
    private WebElement communicationContainer;

    @FindBy(id="btnSavePreferences")
    private WebElement savePreferences;

    @FindBy(xpath = "//div[contains(@class,'message-success') and not(contains(@class,'hidden'))]")
    private WebElement successMsg;
    
    @FindBy(xpath="//a[@id='btnTxt2QuitSignup']")
    private WebElement signupBtn;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement saveBtn;


    //Note: There are 2 elements with same ID for below checkboxes. So use xpath instead of ID to avoid ElementNotVisibleException
    
    String featuresCheckBoxId = "checkbox-When Should We Email You?-Features and Updates";
    
    String yourHealthCheckBoxId = "checkbox-When Should We Email You?-To Your Health";
    
    String programHighlightsCheckBoxId = "checkbox-When Should We Email You?-Program Highlights";
    
    String stayinginTouchCheckBoxId = "checkbox-When Should We Email You?-Staying in Touch";
    

    public void selectAllCheckBoxes(){

        checkFeaturesandUpdatesCheckBox();

        checkToYourHealthCheckBox();

        clickProgramHighlightsCheckBox();

        clickStayinginTouchCheckBox();


    }
    
    public boolean isFeaturesandUpdatesCheckBoxChecked() {

    	String checkBoxXpath = "//input[@id='"+featuresCheckBoxId+"']";
        return  getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();
    }

    public void checkFeaturesandUpdatesCheckBox() {
    	    	
    	String checkBoxXpath = "//input[@id='"+featuresCheckBoxId+"']";
    	String labelXpath = "//label[@id='"+featuresCheckBoxId+"']";
    	
    	boolean isCheckBoxChecked = getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();

    	if(!isCheckBoxChecked){
    		
    		getWebDriver().findElement(By.xpath(labelXpath)).click();
    		
    	}
       
    }

    public boolean isToYourHealthCheckBoxChecked() {

    	String checkBoxXpath = "//input[@id='"+yourHealthCheckBoxId+"']";
        return  getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();
    }

    public void checkToYourHealthCheckBox() {

    	String checkBoxXpath = "//input[@id='"+yourHealthCheckBoxId+"']";
    	String labelXpath = "//label[@id='"+yourHealthCheckBoxId+"']";
    	
    	boolean isCheckBoxChecked = getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();

    	if(!isCheckBoxChecked){
    		
    		getWebDriver().findElement(By.xpath(labelXpath)).click();
    		
    	}
    	
     
    }

    public boolean isProgramHighlightsCheckBoxChecked() {

    	String checkBoxXpath = "//input[@id='"+programHighlightsCheckBoxId+"']";
        return  getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();
    }

    public void clickProgramHighlightsCheckBox() {

    	String checkBoxXpath = "//input[@id='"+programHighlightsCheckBoxId+"']";
    	String labelXpath = "//label[@id='"+programHighlightsCheckBoxId+"']";
    	
    	boolean isCheckBoxChecked = getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();

    	if(!isCheckBoxChecked){
    		
    		getWebDriver().findElement(By.xpath(labelXpath)).click();
    		
    	}
    	
      }

    public boolean isStayinginTouchCheckBox() {
    	String checkBoxXpath = "//input[@id='"+stayinginTouchCheckBoxId+"']";
        return  getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();
    }

    public void clickStayinginTouchCheckBox() {

    	String checkBoxXpath = "//input[@id='"+stayinginTouchCheckBoxId+"']";
    	String labelXpath = "//label[@id='"+stayinginTouchCheckBoxId+"']";
    	
    	boolean isCheckBoxChecked = getWebDriver().findElement(By.xpath(checkBoxXpath)).isSelected();

    	if(!isCheckBoxChecked){
    		
    		getWebDriver().findElement(By.xpath(labelXpath)).click();
    		
    	}
    	
       }

    @Override
    public boolean isDisplayed() {
        return communicationContainer.isDisplayed();
    }

    public void clickSavePreferences() {

        savePreferences.click();

    }

    public String getSuccessMessage(){

        waitForElementToBeDisplayed(successMsg);

        String successMessage = successMsg.findElement(By.tagName("p")).getText().trim();

        return successMessage;
    }
    
    public boolean isText2QuitSectionDisplayed(){
    	
    	String xpath = "//h3[contains(text(),'Text2Quit for Smokers ')]//.. ";
    	WebElement text2QuitSection = getWebDriver().findElement(By.xpath(xpath));
   
    	return text2QuitSection.isDisplayed();
    }
    
    
    public void clickSignupButton(){
    	
    	waitForElementToBeDisplayed(signupBtn);
    	javaScriptClick(signupBtn);
    	waitForSpecifiedTime(6);
    }
    
    public boolean isSignUpBtnDisplayed(){
    	
    	return signupBtn.isDisplayed();
    }
    
    
    public void enterTextFields(String answer,String data){
    	
    	String id = "";
    	answer = answer.toUpperCase(); 
    	
    	switch(answer){
    	
    	case "NUMBEROFCIGARETTES": {
    		        id = "field-for-OHC19A"; 
    	            break; }
    	
    	case "PACKSPRICE": {id = "field-for-OHC19B"; 
    	               break;}
    	
    	}
		
		String xpath = "//input[@id='"+id+"']";
		WebElement textAreaEle = getWebDriver().findElement(By.xpath(xpath));
		textAreaEle.sendKeys(data);

    }
    
    public void selectAcceptTermsCheckbox(){
    	
    	String xpath = "//input[@id='acceptTerms']";
    	WebElement ckeckboxEle = getWebDriver().findElement(By.xpath(xpath));
    	javaScriptClick(ckeckboxEle);
    }
    
    
    public void clickSaveButton(){
    	
    	javaScriptClick(saveBtn);
    	waitForSpecifiedTime(3);
    }
    
    public boolean isTextQuitUpdateBtnDisplayed(){
    	
    	String xpath="//div[@class='text2QuitPending']//following-sibling::div//a[@id='btnTxt2QuitSignup']";
    	WebElement updateBtn = getWebDriver().findElement(By.xpath(xpath));
    	
    	return updateBtn.isDisplayed();
    	
    }
    
    public String getTextQuitContentAfterEnroll(){
    	
    	String xpath = "//div[@class='text2QuitPending']//p";
    	WebElement content = getWebDriver().findElement(By.xpath(xpath));
    	return content.getText().trim();
    }
}
