package com.alerehealth.ui.portal.progress.challenges;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AddEditChallengePage extends PortalHomePage {


    @FindBy(xpath="//*[@class='button btn-secondary addBtn']")
    private WebElement addStepsBtn;

    @FindBy(id="dateEntered")
    private WebElement displayDate;

    @FindBy(xpath="//input[contains(@class,'small validation-message haserror')]/following-sibling::small/span")
    private WebElement addTextFieldError;

    @FindBy(id="saveChallenge")
    private WebElement submitButton;

    @FindBy(xpath="//*[@id='statusCodeZero']/h1")
    private WebElement successMsgValidation;

    @FindBy(partialLinkText="Back to Challenges")
    private WebElement challengesPageLink;

    @FindBy(xpath="//div[@class='modal-footer para-modal-footer']/div/button")
    private List<WebElement> confirmationDialogButtons;
    
	@FindBy(xpath="//input[contains(@id,'textbox_chd_Challenge Physical Activity_StepsSubactivityIntDeviceTracker')]")
	private WebElement addTextBox;
	
	@FindBy(xpath="//button[@class='button btn-secondary addBtn' and contains(text(),'Cancel')]")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//a[@class='learn-more']")
	private WebElement lnkLearnMore;
	
	@FindBy(xpath="//a[@class='learn-more-less']")
	private WebElement lnkLess;
	
	@FindBy(xpath="//button[@class='button btn-secondary caret_previous']")
	private WebElement backArrowDate;

	   @FindAll({
    @FindBy(id="confirmMessage"),
    @FindBy(xpath="//*[contains(@class,'rich-message')]")
	   })
    private WebElement confirmationDialogMessage;
    
    @FindBy(xpath="//h2[contains(text(),'Way to go!')]")
    private WebElement txtProgressChallengePopup;
    
    @FindBy(xpath="//p[@id='confirmMessage']//following-sibling::a[@class='icon_close close']")
    private WebElement closeConfirmPopup;
    
   PortalHomePage portalHomePage = new PortalHomePage();
    
	public static List<String>  challengeAttributes = new ArrayList<String>();


    public String getDisplayDate()
    {
        return displayDate.getText();
    }

    public void clickAddButton()
    {
        scrollElementIntoView(addStepsBtn);

        javaScriptClick(addStepsBtn);
  

    }

    public void selectDailyWeeklyDropdown(String value)
    {

        javaScriptClick(getWebDriver().findElement(By.xpath("//div[@class='dropdown-menu open']//span[text()='"+value+"']")));

    }


    public void enterSteps(String text)
    {
        String xpath = "//input[contains(@class,'smallInput addTextBox small')]";

        WebElement addStepsEditBox = getWebDriver().findElement(By.xpath(xpath));

        scrollElementIntoView(addStepsEditBox);

        if(text.isEmpty())
        {
            addStepsEditBox.sendKeys(Keys.ENTER);
        }

        else
        {
            	
            	javaScriptSendKeys(addStepsEditBox,text);
            }
        
    }

   
    public int getMaxDigitsInFormField(){
    	
    	String xpath = "//td[@class='first-col']";
    	WebElement digits = getWebDriver().findElement(By.xpath(xpath));
    	waitForElementToBeDisplayed(digits);
    	String digitsText = digits.getText().trim();
    	int maxCharacters = digitsText.length();
    	
    	return maxCharacters;
    	
    }
    
    
    public String getAddStepsFieldError()
    {
        waitForElementToBeDisplayed(addTextFieldError);
        return addTextFieldError.getText();
    }

    public void clickSubmit()
    {
        scrollElementIntoView(submitButton);

       // javaScriptClick(submitButton);
        
        submitButton.click();
        
        waitForSpecifiedTime(4);

        waitForElementToBeDisplayed(successMsgValidation);
    }

    @Override
    public boolean isDisplayed() {
        return addStepsBtn.isDisplayed();
    }

    public String getSuccessMessage()
    {
        waitForElementToBeDisplayed(successMsgValidation);
        scrollElementIntoView(successMsgValidation);
        return successMsgValidation.getText();
    }


    public void handlePopUp(String action)
    {


        for(WebElement elememt: confirmationDialogButtons)
        {
            if(action.equals(elememt.getText()))
            {
                elememt.click();
                break;
            }
        }
    }

  

    public String getConfirmationDialogMessage()
    {

        waitForElementToBeDisplayed(confirmationDialogMessage);
        return confirmationDialogMessage.getText().trim();
    }
    
    
    public boolean isConfirmationDialogDisplayed(){
    	
    	 waitForElementToBeDisplayed(confirmationDialogMessage);
    	 
    	 return confirmationDialogMessage.isDisplayed();
    }
    
    public AddEditChallengePage closeConfirmationDialogMessage(){
    	
    	waitForElementToBeDisplayed(closeConfirmPopup);
    	javaScriptClick(closeConfirmPopup);
    	waitForSpecifiedTime(5);
    	
    	return new AddEditChallengePage();
    }
    
    public AddEditChallengePage clickButtonInConfirmationPopup(String btnValue){
    	
    	String id ="";
    	btnValue = btnValue.toUpperCase();
    	switch(btnValue){
    	
    	case "YES" :
    		          id="confirmbtn";
    		          break;
    	case "NO" : id="cancel";
    	          break;
    	
    	}
    	
    	String xpath = "//button[@id='"+id+"']";
    	WebElement btnEle = getWebDriver().findElement(By.xpath(xpath));
    	javaScriptClick(btnEle);
    	waitForSpecifiedTime(3);
    	
    	return new AddEditChallengePage();
    }
    
    
    public String getConfirmChangesPopupByClickingBackToChallenges(){
    	
    	waitForElementToBeDisplayed(challengesPageLink);
    	javaScriptClick(challengesPageLink);
    	String confirmPopup = getConfirmationDialogMessage();
    	
    	return confirmPopup;
    }
    
    

	
	public String getChallengeAttributes(String attrValue){
		
		
		String id = "";
    	attrValue = attrValue.toUpperCase(); 
    	
    	switch(attrValue){
    	
    	case "DATE": {id = "Date:"; 
    	               break;}
    	case "MAXSTEPSPERDAY": {id = "Max. Steps/day:"; 
                      break;}
    	case "STEPSENTRYDEADLINE": {id = "Steps entry deadline:"; 
                      break;}
    	}
		
		String xpath = "//ul[@class='no-bullets']//li[contains(text(),'"+id+"')]//strong";
		WebElement attributeValue = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(attributeValue);
		return attributeValue.getText().trim();
	
	}
	
	
	public String getMouseHoverText(){
		
		String xpath = "//span[@class='icon icon_help_link']//span";
		WebElement textHover = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(textHover);
		
		return textHover.getText().trim();
		
	}
	
	
	public String getCredits(){
		
		String xpath = "//span[@id='creditsEarnedCheckbox']";
		WebElement txtCredit = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(txtCredit);
		return txtCredit.getText().trim();
		
		
	}
	
	//footer1 for 1st day,  footer2 for 2nd day......
	public String getTotalCreditsFooter(String footer){
		
		String xpath = "//div[@id='"+footer+"']//span";
		WebElement txtCredit = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(txtCredit);
		return txtCredit.getText().trim();
		
		
	}
	
    public boolean isTextboxAndCancelBtnDisplayed(){
		
		return addTextBox.isDisplayed() && cancelBtn.isDisplayed();
	}
	
   public void clickCancelBtn(){
		
		waitForElementToBeDisplayed(cancelBtn);
		javaScriptClick(cancelBtn);
		
	}
   
   
	public void clickLearnMoreOrLess(String text){
		
		String xpath = "//a[contains(text(),'"+text+"')]";
		WebElement linkText = getWebDriver().findElement(By.xpath(xpath));
		
		if(linkText.isDisplayed()){
			
		linkText.click();
		
		}
		else{
			
			System.out.println("Learn more or less link is not available for this challenge");
		
		}
	}
	
	public void enterStepsToCompleteCredits(String text){
		
		System.out.println("started");
		
		 String xpath = "//input[contains(@class,'smallInput addTextBox small')]";

	      for(int i=1; i<=10; i++){
            
		  List<WebElement> addStepsEditBox = getWebDriver().findElements(By.xpath(xpath));
          System.out.println("steps added" + i);
		  
	        for (int iLoopCounter = 0; iLoopCounter < addStepsEditBox.size(); iLoopCounter++) {
	        	
				WebElement addSteps = addStepsEditBox.get(iLoopCounter);
	
                javaScriptSendKeys(addSteps,text);

	        }
	        
	        clickSubmit();
	        
	        waitForSpecifiedTime(5);
	           
	        if(txtProgressChallengePopup.isDisplayed()){
	        	
	        	
		        clickOkayButton("progress");
		        clickBackArrowOrDatePicker("Backarrow");
	        	
	        }else{


	        	  String message = getCreditsCompletionMessage();
	        	  System.out.println(message);
	        	  clickOkayButton("completed");
	        }
	

	      }
	    
   }


	
	public void clickBackArrowOrDatePicker(String value){
		
		String classValue = "";
		value = value.toUpperCase();
		
		switch(value){
		
		case "BACKARROW": {classValue = "button btn-secondary caret_previous"; 
        break;}
        case "DATEPICKER": {classValue = "ui-datepicker-trigger icon_datepicker"; 
       break;}
		
		}
		
		String xpath = "//button[@class='"+classValue+"']";
	    WebElement elementArrowDate = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(elementArrowDate);
		javaScriptClick(elementArrowDate);
		waitForSpecifiedTime(5);
	}
	
	public void clickOkayButton(String challengestatus){
		
		String id = "";
		challengestatus = challengestatus.toUpperCase(); 
    	
    	switch(challengestatus){
    	
    	case "PROGRESS": {id = "myModal-challenge-progress"; 
    	               break;}
    	case "COMPLETED": {id = "myModal-challenge-complete"; 
                      break;}
    	
    	}
		
		
		String xpath="//div[@id='"+id+"']//div[@class='buttons']//a[contains(text(),'Okay')]";
		WebElement okButn = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(okButn);
		javaScriptClick(okButn);
		
	
	}
	
	public String getCreditsCompletionMessage(){
		
		String xpath = "//p[@id='maxTierDesc']";
		WebElement message = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(message);

		return message.getText().trim();
	}
	

    public AvailableChallengesPage navigateBackToChallengesPage()
    {   
        javaScriptClick(challengesPageLink);
        return new AvailableChallengesPage();

    }
    
    
    public boolean isBackToChallengesLnkDisplayed(){
    	
    	waitForElementToBeDisplayed(challengesPageLink);
    	
    	return challengesPageLink.isDisplayed();
    }
    
    public boolean isLearnMoreDescriptionDisplayed(){
    	
    	String xpath = "//div[@class='learn-more-description']//p";
    	WebElement desc = getWebDriver().findElement(By.xpath(xpath));
    	waitForElementToBeDisplayed(desc);
    	
    	return desc.isDisplayed();
    }
    
    public void selectCurrentDate(){
    	
    	String xpath = "//td[contains(@class,'ui-datepicker-current-day ui-datepicker-today')]";
    	WebElement dateValue = getWebDriver().findElement(By.xpath(xpath));
    	waitForElementToBeDisplayed(dateValue);
    	javaScriptClick(dateValue);
    	waitForSpecifiedTime(3);
    	
    }
    
	
}
