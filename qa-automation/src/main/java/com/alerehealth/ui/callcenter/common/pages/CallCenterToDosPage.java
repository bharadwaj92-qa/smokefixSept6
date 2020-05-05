package com.alerehealth.ui.callcenter.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallCenterToDosPage extends CallCenterHomePage {
	
	
	 @FindBy(id = "PegaGadget0Ifr")
	 public WebElement iframe1;
	 
	 @FindBy(id = "convIframe")
	 public WebElement iframe2;
	
	 @FindBy(xpath = "//div[@class='p360down']")
	 public WebElement threesixtytabminimizingdownArrow;
	 
	 @FindBy(xpath = "//div[@class='p360up']")
	 public WebElement threesixtytabmaxUpArrow;
	 
	 @FindBy(xpath = "//button[contains(@title,'Refresh ToDo list')]")
	 public WebElement verifyParticipantRefreshPage;
	
	 @FindBy(id="PegaGadget0Ifr")
	 public WebElement Pega360PageIframe;
	 
	 @FindBy(id = "f360ms")
	 public WebElement frameHeader;
	 
	 @FindBy(xpath = "//span[contains(@class,'leader_text') and contains(text(),'Participant Summary Dashboard')]")
	 public WebElement summaryTab;
	 
	 
	 
	/*
     *  Minimizing 360 tab
     */
        
   public void threeSixtytabMinimizing(){
   	
   	switchToDefault();
   	
   	switchToFrame(iframe1);
   	
   	waitForPageToLoad();
   	
   	WebDriverWait wait = new WebDriverWait(getWebDriver(),45);
   	
   	wait.until(ExpectedConditions.visibilityOf(threesixtytabminimizingdownArrow));
   	
   	javaScriptClick(threesixtytabminimizingdownArrow);
   	
   	System.out.println("Minimized 360 tab");
   	
   }
   
   
    /*
     * Maximizing 360 tab
     * 
     */
   
   public void threeSixtytabMaximizing(){
   	
   	switchToDefault();
   	
   	switchToFrame(iframe1);
   	
   	javaScriptClick(threesixtytabmaxUpArrow);
   	
   	System.out.println("Maximizing 360 tab");
   	
   }
   

   /*
    * InteractionCall in ToDos after providing P-Id and targeted to LC
    * Provide program name as LC, DM like that pass from feature file
    */
   
   public HIPAAScreenPage interactionCallInToDo(String programName) throws Exception{
   		
   	try{
   	
   		threeSixtytabMinimizing();
   	
   	}catch(Exception e){
   	
   		System.out.println("Enter in catch to minimize 360 tab");
   		
   		threeSixtytabMinimizing();
   	}
   	
   	waitForPageToLoad();
   	
   	switchToDefault();
   	
   	switchToFrame(iframe1);
   	
   	switchToFrame(iframe2);
   	
   	waitForPageToLoad();
   	
   	System.out.println("Switched to TODO's frame");
   	
   	String interactionName = "//a[contains(@onclick,'INTERACTIONROUTE') and contains(text(),'"+programName+"')]";
   	
   	Thread.sleep(2000);
   	
   	WebElement interactionCall = getWebDriver().findElement(By.xpath(interactionName));
   	
   	javaScriptClick(interactionCall);
   	
   	waitForPageToLoad();
   	
   	System.out.println("Clicked on interaction call");
   	
	return new HIPAAScreenPage();
   	
   }

   
   @Override
   public boolean isDisplayed() {

       /*waitForElementToBeDisplayed(verifyParticipantRefreshPage);
       return verifyParticipantRefreshPage.isDisplayed();*/
	   
	   waitForPageToLoad();
		
	   getWebDriver().switchTo().defaultContent();
		
	   waitForPageToLoad();
		
	   switchToFrame(Pega360PageIframe);
		
	   waitForPageToLoad();
	   
	   switchToFrame(frameHeader);
	   
       waitForElementToBeDisplayed(summaryTab);
       
       return summaryTab.isDisplayed();

   }
   
   
}
