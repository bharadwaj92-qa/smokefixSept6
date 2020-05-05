package com.alerehealth.ui.portal.carereminders;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.library.CareReminderLibraryPage;

public class CareReminderPage extends PortalHomePage {
	
	
	
	public static int countOpenCR;
	
	public static String radioButtonOption;
	
	public static String optionText;
	
	
	 @FindBy(xpath ="//a[contains(@class,'btn--icon pull-right')]")	
     private WebElement txtPrintIcon;
	 
	 private String mainWinHandle;
	 

	 
	 //Using generic method
 @FindAll({
			@FindBy(xpath = "//div[@id='openAlerts']//following-sibling::details") })
		
		private List<WebElement> txtOpenCRMsg;
	 
	 @FindAll({
			@FindBy(xpath ="//details[@aria-expanded='true']//div[contains(@class,'careAlertsTxt')]//label[contains(text(),'')]")})
			
			private List<WebElement> answerOption;
	 
	 

	 @FindBy(xpath ="//div[@id='openAlerts']//following-sibling::h3[@class='pull-left']")
	 
     private WebElement txtOpenCare;
	 
	 
	 @FindBy(name="closedAlerts")
	
	 private WebElement txtClosed;
	 
	 @FindBy(xpath="//div[@id='closedAlerts']//following-sibling::h3[contains(text(),'Closed Care Reminders')]")
	
	 private WebElement textClosedCareReminders;
	 

     public int getOpenCRMsgCount(){
    	 
    	 return getRemindersCount("Open");
    	 
     }
     

       
       public boolean isDisplayed(){
    	   
    	   waitForElementToBeDisplayed(txtOpenCare);
    	   
    	   return txtOpenCare.isDisplayed();
    	   
       }
       
    
       	
       
    public  int  getRemindersCount(String reminderType){
    	
    	int openCareCount=0;
    	String id = "";
    	reminderType = reminderType.toUpperCase(); 
    	
    	switch(reminderType){
    	
    	case "OPEN": {
    		id = "openAlerts"; 
    	break; }
    	
    	case "CLOSED": {id = "closedAlerts"; 
    	               break;}
    	case "FAQ": {id= "faqAlerts"; 
    	             break;}
    	}
    	
    	String xpath = "//div[@id='" + id + "']//following-sibling::details"; 
    	
    	List<WebElement> reminderRows = getWebDriver().findElements( By.xpath(xpath));  
    	
    	openCareCount = reminderRows.size();
    	
    	return openCareCount;    	
    }
    
    
    public void expandReminder(String reminder){
    	
    	System.out.println("Clicking on Expand Button");
    	
    	String xpath = "//summary[contains(text(),'"+reminder+"')]/.." ;
    	
    	WebElement reminderContainer = getWebDriver().findElement(By.xpath(xpath));
    	
    	String expansionState = reminderContainer.getAttribute("aria-expanded");
    	
    	if(!expansionState.equals("true")){
    		
    		reminderContainer.click();
    		
    	}
    	
    }
    
    
    public CareReminderLibraryPage learnMoreAboutReminder(String reminder){
    	
    	String xpath = "//summary[contains(text(),'"+reminder+"')]//following-sibling::div//a[contains(text(),'"+reminder+"')]";
    	WebElement reminderContainer = getWebDriver().findElement(By.xpath(xpath));
    	
    	reminderContainer.click();
    	
    	return new CareReminderLibraryPage();
    	 	
    }
    
    public void clickSubmit(){
    	
    	System.out.println("Clicking on Submit Button");
    	
    	String xpath ="//details[@aria-expanded='true']//button[contains(@class,'Submit')]";
    			
    	WebElement reminderContainer = getWebDriver().findElement(By.xpath(xpath));
    	
    	reminderContainer.click();
    }
    
    
    public List<String>  getOpenCareAlerts(){
    	
        String xpath = "//div[@id='openAlerts']//following-sibling::details"; 
    	
    	List<WebElement> reminderRows = getWebDriver().findElements( By.xpath(xpath));
    	
    	List<String> careRemindersFromOpenPage = new ArrayList<String>();
    	
    	System.out.println("Open Care Reminders:");
    	
    	reminderRows.forEach(remdinder -> careRemindersFromOpenPage.add(remdinder.getText().trim()));
    	System.out.println(careRemindersFromOpenPage);

    	return careRemindersFromOpenPage;
    }
   
    
	 public CareReminderPrintPage clickPrintIcon(){

	      mainWinHandle = getWebDriver().getWindowHandle();

	      txtPrintIcon.click();

	      waitForNewWindowToOpen(1);

	      switchToNewWindow(mainWinHandle);
	      
	      return new CareReminderPrintPage();

	    }
	 
	
	 
	 public void clickOnRadioBtn(String radioButtonOption){
		 
		 
		 String xpath = "//details[@aria-expanded='true']//div[contains(@class,'careAlertsTxt')]//label[contains(text(),'"+radioButtonOption+"')]";
		 WebElement radioButton = getWebDriver().findElement(By.xpath(xpath)); 
		 
		 System.out.println("Clicking on Radio Button");
		 radioButton.click();
			       
    }
	 
	
   
     public boolean isSuccessDisplayed(){
    	 
    	 String xpath = "//details[@aria-expanded='true']//div[contains(@class,'success')]";
    	 
    	 WebElement txtSuccess = getWebDriver().findElement(By.xpath(xpath));
    	 
    	  waitForElementToBeDisplayed(txtSuccess);
    	  
    	  System.out.println("Success message" + txtSuccess.getText());
		  
    	  return txtSuccess.isDisplayed();
		  
     }
     
   
     
     public void clickOnLinkClosed(){
     	
     	
 		  waitForElementToBeDisplayed(txtClosed);
 		  System.out.println("Clicking on closed link");
 		  txtClosed.click();
 		  
     }	
     
    
     public boolean isClosedReminderDisplayed(){
    	 
 		  waitForElementToBeDisplayed(textClosedCareReminders);
 		 
 		  return textClosedCareReminders.isDisplayed();
 	
     }
     
     public boolean isClosedReminder(String reminder){
    	 
    	 System.out.println("Validating CareReminder submitted is displayed in Closed Care Reminders");
  	   
    	 String xpath = "//div[@id='closedAlerts']//summary[contains(text(),'"+reminder+"')]" ;
     	
     	 WebElement reminderContainer = getWebDriver().findElement(By.xpath(xpath));
  			
  		 return reminderContainer.isDisplayed();
  			 
  			
     }
     
 
     
     public String getSelectedAnswerOptionForClosedReminder(){
    	 
    	 String xpath = "//details[@aria-expanded='true']//div[contains(@class,'careAlertsTxt')]//input[@type='radio' and @checked]/../label";
    	 WebElement answerOptionSelected = getWebDriver().findElement(By.xpath(xpath));
    	 optionText = answerOptionSelected.getText().trim();
    	 System.out.println("Selected Answer option is:" + optionText);
    	 
    	 return optionText;
    	 
     }
				 
	
     
     public boolean isAllAnswerOptionsDisabled(){
    	     
    	    boolean isDisabled = false;
    	 
            String xpath = "//details[@aria-expanded='true']//div[contains(@class,'careAlertsTxt')]//label[contains(text(),'')]/..";
  	 	
   			List<WebElement> radioBtn = getWebDriver().findElements(By.xpath(xpath));
   			
   			System.out.println("Validating whether all Radio Buttons are disabled:");
   			
  			for (int iLoopCounter = 0; iLoopCounter < radioBtn.size(); iLoopCounter++) {
  				
  				 WebElement element = radioBtn.get(iLoopCounter);
  				 String classes = element.getAttribute("class");
  				 isDisabled = classes.contains("field-block careAlertsTxt radio disabled");
  				 System.out.println("Radio Button Option " +iLoopCounter+ "disabled"+isDisabled);
      	 
              }
  			
  			return isDisabled;
  			
  			
      	 }
      	
     
	 
	 /**
	     * Helper method to switch back to care reminder page
	 * @return 
	     */
	    public CareReminderPage switchBackToCareReminderPage(){

	        getWebDriver().switchTo().window(mainWinHandle);
	        
	        return new CareReminderPage();

	    }


 }
    	 
    	 
    	 
    	 
	 
     
     


    
 
     

	 
	 
	
