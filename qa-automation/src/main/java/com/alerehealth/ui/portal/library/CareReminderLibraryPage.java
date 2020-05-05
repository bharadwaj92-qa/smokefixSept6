package com.alerehealth.ui.portal.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.carereminders.CareReminderPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class CareReminderLibraryPage extends PortalHomePage{
	
	 @FindBy(id="breadcrumblist")
	 private WebElement breadCrumbContainer;

	    public String getCareReminderTitle(){

	       WebElement headerEle =  getWebDriver().findElement(By.xpath("//*[@class='mainevent-header']//h1"));

	       String headerText =  headerEle.getText().trim();

	       return headerText;

	    }
	    
	    public String getCareReminderNavigationFromBreadCrumb(){

	        String completeNavigation = "";
	        List<WebElement> navigationList =  breadCrumbContainer.findElements(By.tagName("li"));

	        int counter = 0;
	        for(WebElement navigation : navigationList){

	            String temp = navigation.getText().trim();

	            if(temp.isEmpty()){

	                WebElement atag = navigation.findElement(By.tagName("a"));

	                completeNavigation +=(atag.getText().trim());

	            }else{

	                completeNavigation+=temp;
	            }

	            if(counter<navigationList.size()-1){

	                completeNavigation+=">";

	                counter++;

	            }

	        }

	        return completeNavigation;
	    }
	    

	    public CareReminderPage navigateToCareReminderPage(){
	       	
	      	 navigateToBackPage();
	      	
	      	 return new CareReminderPage();
	      	 
	    }
	       
	    
	    public boolean isDisplayed(){
	    	
	    	waitForElementToBeDisplayed(breadCrumbContainer);
	    	return breadCrumbContainer.isDisplayed();
	    	
	    }

}
