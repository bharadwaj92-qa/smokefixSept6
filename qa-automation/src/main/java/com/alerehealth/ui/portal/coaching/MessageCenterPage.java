package com.alerehealth.ui.portal.coaching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class MessageCenterPage extends PortalHomePage {
     
   
	 @FindBy(id="breadcrumblist")
	 private WebElement breadCrumbContainer;
	 
	 @FindBy(xpath="//button[@id='submitBtn']")
	 private WebElement btnSend;
	 
	   public String getMessageCenterTitle(){

	       WebElement headerEle =  getWebDriver().findElement(By.xpath("//*[@id='breadcrumblist']//li[contains(text(),'Messages')]"));

	       String headerText =  headerEle.getText().trim();

	       return headerText;

	    }
	   
	   
	   
	    
	
	   public boolean isDisplayed(){
	    	
	    	waitForElementToBeDisplayed(breadCrumbContainer);
	    	
	    	waitForElementToBeDisplayed(btnSend);
	    	
	    	return breadCrumbContainer.isDisplayed() && btnSend.isDisplayed();
	    	
	    }
}
