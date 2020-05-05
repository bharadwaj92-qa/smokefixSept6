package com.alerehealth.ui.portal.memberrescenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.library.LibraryPage;


public class MemberResourceCenterBasePage extends PortalHomePage {
	
	@FindBy(xpath = "//div[@class='filter-navigation']")
	private WebElement leftNavigation;
	
	private String mainWinHandle;
	
	public void clickLeftNavigationLink(String link ){
		
		String xpath = "//a[contains(text(),'"+link+"')]";
		WebElement  linkEle = getWebDriver().findElement(By.xpath(xpath)); 
		javaScriptClick(linkEle);
		
	}
	
	public boolean isLinkDisplayed(String section,String link){
		
		String xpath = "//h3[contains(text(),'"+section+"')]//following-sibling::ul//a[contains(text(),'"+link+"')]";
		WebElement  linkEle = getWebDriver().findElement(By.xpath(xpath)); 
		return linkEle.isDisplayed();
	}
	
	public String clickProgramOverviewLink(){
		
		clickLeftNavigationLink("Program Overview");
		
	   return  getWebDriver().getCurrentUrl();
	}
	
	public WellBeingAssessmentPage clickWellbeingAssessment(){
		
		clickLeftNavigationLink("Wellbeing Assessment");
		
		return new WellBeingAssessmentPage();
	}
	
	
    public MemberDiscountPage clickMemberDiscountLink(){
		
		 mainWinHandle = getWebDriver().getWindowHandle();

		 clickLeftNavigationLink("Member Discounts");

	      waitForNewWindowToOpen(1);

	      switchToNewWindow(mainWinHandle);
	      
	      return new MemberDiscountPage();
	}
    
    public SmokerHelpLinePage clickSmokerHelpLineLink(){
		
		 mainWinHandle = getWebDriver().getWindowHandle();

		 clickLeftNavigationLink("Smoker");

	      waitForNewWindowToOpen(1);

	      switchToNewWindow(mainWinHandle);
	      
	      return new SmokerHelpLinePage();
	}
    
    
    public Text4BabyPage clickText4BabyLink(){
		
		 mainWinHandle = getWebDriver().getWindowHandle();

		 clickLeftNavigationLink("Text4Baby");

	      waitForNewWindowToOpen(1);

	      switchToNewWindow(mainWinHandle);
	      
	      return new Text4BabyPage();
	}
    
    
    
    
    public void switchBackToMemberResourceCenterBasePage(){

        getWebDriver().switchTo().window(mainWinHandle);

    }
    
   
   /* 
    * Links used are Resources, Asthma,  Pain,  Diabetes,  Respiratory Disease,  Heart Problems
    */
   public LibraryPage navigateToLibraryPage(String link){
		
		clickLeftNavigationLink(link);
		
	   return  new LibraryPage();
	}
  

	public String getWelcomeMessage(){
		
		String xpath = "//div[@class='content library-content-header']//p ";
		WebElement msgEle = getWebDriver().findElement(By.xpath(xpath));
		
		return msgEle.getText().trim();
	}
	
	public boolean isDisplayed(){
		
		return leftNavigation.isDisplayed();
		
	}

}
