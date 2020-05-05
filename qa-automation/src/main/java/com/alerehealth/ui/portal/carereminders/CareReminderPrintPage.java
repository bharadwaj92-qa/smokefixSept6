package com.alerehealth.ui.portal.carereminders;

import java.util.ArrayList;
import java.util.List;

import com.alerehealth.ui.portal.carereminders.CareReminderPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;



public class CareReminderPrintPage extends CareReminderPage {
	
	
	public static List<String>  careRemindersFromPrintPage = new ArrayList<String>();
	
	
	 
	 @FindBy(xpath ="//div[@class='care-alerts-print main-header']")	
     private WebElement txtPrintCare;
	 
	 
	 @FindAll({
			@FindBy(xpath = "//div[@class='print-top-border']//following-sibling::h4") })
		
		private List<WebElement> txtPrintCRMsg;
	 
	 

	 private boolean isPrintReminderWindowOpen = false;
	 


	    public boolean isPrintReminderWindowOpened(){

	        return isPrintReminderWindowOpen;

	    }
	    
	    
	    
	    public List<String> getPrintCareReminders(){
	    	 
	    		
	 			List<WebElement> msgCount1 = txtPrintCRMsg;
	 			
				 
				System.out.println("Print Care Reminders:");
				for (int iLoopCounter = 0; iLoopCounter < msgCount1.size(); iLoopCounter++) {
					WebElement element = msgCount1.get(iLoopCounter);
					String msgText = element.getText().trim();
					System.out.println(msgText);
					careRemindersFromPrintPage.add(msgText);
					
				}
					return careRemindersFromPrintPage;
											
	    	
	     }
	    
	    
	    public  int  getPrintRemindersCount(){
	    	
	    	List<WebElement> reminderRows = txtPrintCRMsg;  
	    	
	    	return reminderRows.size() ;
	    }
	     
	    
	    
	    
	    public boolean isDisplayed(){
	    	
	    	waitForElementToBeDisplayed(txtPrintCare);
	    	return txtPrintCare.isDisplayed();
	    }
	    

}
