package com.alerehealth.ui.portal.progress.trackers.nutrition;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackersNutritionProgressPage extends TrackersNutritionBasePage {
	
	@FindBy(xpath="//div[@class='content']//p")
	private WebElement progressPage;
	
	

	public void selectDate(String month,String day){
		
		String xpath = "//td[@data-month='"+month+"']//a[contains(text(),'"+day+"')]";
		WebElement dateEle = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(dateEle);
		javaScriptClick(dateEle);
	}
	
	
	public void selectServingDropdown(String serving){
		
		String xpath = "//ul[@class='dropdown-menu dropdown-primary']//label[contains(text(),'"+serving+"')]";
		WebElement serveEle = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(serveEle);
		
	}
	
	
   public boolean isGraphDisplayed(String servingValue){
		
    	String id = "";
    	servingValue = servingValue.toUpperCase(); 
    	
    	switch(servingValue){
    	
    	case "FRUITS": {
    		id = "containerFruits"; 
    	break; }
    	
    	case "VEGGIES": {id = "containerVegetables"; 
    	               break;}
    	case "WHOLEGRAINS": {id= "containerWholeGrains"; 
    	             break;}
    	
    	case "PROTEIN": {
    		id = "containerProtein"; 
    	break; }
    	
    	case "DAIRY": {id = "containerDairy"; 
    	               break;}
    	case "FATS": {id= "containerFats"; 
    	             break;}
    	
    	case "NUTS": {
    		id = "containerNuts"; 
    	break; }
    	
    	case "SWEETS": {id = "containerSweets"; 
    	               break;}
 
    	}
    	
    	String graphXpath = "//div[@id='"+id+"']"; 
    	
    	WebElement graphEle = getWebDriver().findElement(By.xpath(graphXpath));
    	
    	waitForElementToBeDisplayed(graphEle);
    	    	
    	
    	return graphEle.isDisplayed();    
	}
	
	

	public boolean isTimeLineDisplayed(String servingValue,String timelineValue){
		
    	String id = "";
    	servingValue = servingValue.toUpperCase(); 
    	
    	switch(servingValue){
    	
    	case "FRUITS": {
    		id = "containerFruits"; 
    	break; }
    	
    	case "VEGGIES": {id = "containerVegetables"; 
    	               break;}
    	case "WHOLEGRAINS": {id= "containerWholeGrains"; 
    	             break;}
    	
    	case "PROTEIN": {
    		id = "containerProtein"; 
    	break; }
    	
    	case "DAIRY": {id = "containerDairy"; 
    	               break;}
    	case "FATS": {id= "containerFats"; 
    	             break;}
    	
    	case "NUTS": {
    		id = "containerNuts"; 
    	break; }
    	
    	case "SWEETS": {id = "containerSweets"; 
    	               break;}
 
    	}
    	    	
    	String timelineXpath = "//div[@id='"+id+"']//*[name()='text' and text()='"+timelineValue+"'] ";
    	
        WebElement timeLineEle = getWebDriver().findElement(By.xpath(timelineXpath));
    	
    	waitForElementToBeDisplayed(timeLineEle);
    	
    	
    	return  timeLineEle.isDisplayed();    
	}
	
	public String getProgressContent(){
		
		waitForElementToBeDisplayed(progressPage);
		
		return progressPage.getText().trim();
	}
	
	@Override
	public boolean isDisplayed(){
		
		return progressPage.isDisplayed();
	}


}
