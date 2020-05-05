package com.alerehealth.ui.portal.coaching;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnaireStartingPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class WellnessPage extends PortalHomePage{
	
	@FindBy(xpath="//div[contains(@class,'tier2 call-tracker')]")
	private WebElement wellnessContainer;

    @FindBy(xpath = "//b[@class='max-count']")
    private WebElement maxCoachingCalls;
    
    @FindBy(xpath="//div[@class='ogn__title__left']")
    private WebElement wellnessTitle;
    
    @FindBy(xpath="//div[@class='']")
    private WebElement wellnessContent;
    
    @FindBy(xpath="//div[@class='progress-bar']")
    private WebElement progressBar;
    
    @FindBy(xpath="//div[@class='calls-container']//h1")
    private WebElement txtCoachingCall;
    
    @FindBy(xpath="//span[@id='tip-text']")
    private WebElement txtTooltip;
    
    @FindBy(xpath="//div[@class='buttons right']")
    private WebElement txtMobilenum;
    
    @FindBy(xpath="//a[contains(text(),'Go to Messages ')]")
    private WebElement lnkGoToMsg;
    
    @FindBy(xpath="//div[@class='progress-bar-container']//span[@class='pb-summary-heading']")
    private WebElement coachingCallNumber;
    
   
    @FindBy(xpath="//div[@class='coaching-chat-messageCenter']//span[@class='icon progress_tips']")
    private WebElement thumbnailMessageSection;

    public String maxCoachingCallnumber(){

        return maxCoachingCalls.getText();
    }

	public boolean isDisplayed() {

       waitForElementToBeDisplayed(wellnessContainer);
       
       return wellnessContainer.isDisplayed();
    }
	
	
	public boolean isThumbnailImageDisplayed(String content){
		
		String xpath="//strong[contains(text(),'"+content+"')]//..//..//..//span";
		WebElement image = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(image);
		
		return image.isDisplayed();
		
		
	}
	
	
	public String getThumbnailsContent(String content){
		
		String xpath = "//strong[contains(text(),'"+content+"')]//..";
		WebElement contentTxt = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(contentTxt);
		contentTxt.isDisplayed();
		
		return contentTxt.getText().trim();

	}
	
	/*
	 * Content value can be "Wellness Being" or "QFL"
	 * In ContentType use value "credit" for retrieving credit value +10
	 * In ContentType use value "Link" for retrieving Start Today Link value
	 * 
	 */
	
	public String getThumbnailsCreditAndLink(String content,String contentType){
		
		String data;
    	String tag = "";
    	
    	contentType = contentType.toUpperCase(); 

    	switch(contentType){
    
    	
    	case "CREDIT": {tag = "p"; 
    	               break;}
    	case "LINK": {tag = "a"; 
    	             break;}
    	}	
    	
	String xpath = "//strong[contains(text(),'"+content+"')]//..//..//div//"+tag+"";
	WebElement creditLinkTxt = getWebDriver().findElement(By.xpath(xpath));
	waitForElementToBeDisplayed(creditLinkTxt);
	creditLinkTxt.isDisplayed();
	
	data=creditLinkTxt.getText().trim();
	
	return data;
	}
	

	public String getTitle(){
		
		waitForElementToBeDisplayed(wellnessTitle);
		wellnessTitle.isDisplayed();
		return wellnessTitle.getText().trim();
	}
	
	public String getContent(){
		
		waitForElementToBeDisplayed(wellnessContent);
		wellnessContent.isDisplayed();

		return wellnessContent.getText().trim()  ;
	}
	
	public ActionPlanQuestionnaireStartingPage clickStartTodayLink(String content){
		
		String xpath = "//strong[contains(text(),'"+content+"')]//..//..//div//a";
		WebElement linkTxt = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(linkTxt);
		linkTxt.click();
		
		return new ActionPlanQuestionnaireStartingPage();
	}
	
	  public boolean isProgressBarDisplayed(){
		  
		  waitForElementToBeDisplayed(progressBar);
		  
		  return progressBar.isDisplayed();
	  }
	  
	
	  
	  public String getTooltip(){
		  
        waitForElementToBeDisplayed(txtTooltip);
        
        txtTooltip.isDisplayed();
		  
		  return  txtTooltip.getText().trim();
	  }
	  
	  
	  public String getCoachingCallTitle(){
		  
		  waitForElementToBeDisplayed(txtCoachingCall);
	        
		  txtCoachingCall.isDisplayed();
			  
		  return  txtCoachingCall.getText().trim();
	  }
	
	
	
	public String isMobileNumberDisplayed(){
		
		 waitForElementToBeDisplayed(txtMobilenum);
		  
		return txtMobilenum.getText().trim();
	}
	
	
	
	public MessageCenterPage clickGoToMessages(){
		
		 waitForElementToBeDisplayed(lnkGoToMsg);
		 lnkGoToMsg.click();
		
		return new MessageCenterPage();
	}
	
	/*
	 * 
	 * Section can be  "Secure Messages "  or "Secure Chat"
	 * In SectionType use value "Content" for retrieving title from SecureMessages section
	 * In SectionType use value "Button" for retrieving title from SecureMessages section
	 */
	 public  String  getSecureSectionContentAndButton(String section,String sectionType){
	    	
	    	String txtSection;
	    	String tag = "";
	    	sectionType = sectionType.toUpperCase(); 
	    	
	    	switch(sectionType){
	    	
	    	case "CONTENT": {tag = "p"; 
	    	               break;}
	    	case "BUTTON": {tag = "a"; 
	    	             break;}
	    	}
	    	
	    	String xpath = "//h2[contains(text(),'"+section+"')]/..//..//"+tag+""; 
	    	WebElement sectionXpath = getWebDriver().findElement(By.xpath(xpath));
			waitForElementToBeDisplayed(sectionXpath);
			
			txtSection = sectionXpath.getText().trim();

	    	return txtSection;    	
    }
	 
	 
	 public  String  getSecureSectionTitle(String sectionType){
		 
		 String xpath = "//div[@class='coaching-chat-messageCenter']//h2[contains(text(),'"+sectionType+"')]";
		 WebElement sectionXpath = getWebDriver().findElement(By.xpath(xpath));
	     waitForElementToBeDisplayed(sectionXpath);
			
		String	txtSection = sectionXpath.getText().trim();
			
		 return  txtSection;
		 
	 }
	 
   
	 
	 public boolean isMessageThumbnailDisplayed(){
		 waitForElementToBeDisplayed(thumbnailMessageSection);
		 
		 return thumbnailMessageSection.isDisplayed();
	 }
	 
	 
	 
}
