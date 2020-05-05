package com.alerehealth.ui.callcenter.mainmenu;

import com.alerehealth.fwk.db.ConnectionManager;
import com.alerehealth.fwk.db.DBDataFetcher;
import com.alerehealth.fwk.db.JDBCConnector;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterToDosPage;
import com.alerehealth.ui.callcenter.common.pages.ProgramEnrollmentPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallCenterOthersHomeMenuPage extends CallCenterHomePage {


    @FindBy(xpath = "//a[@id='home_headerbar_icon_other_b']//i")
    private WebElement otherIconHighlighted;

    @FindBy(id="home_results_iframe")
    public WebElement othersPageIframe;

    @FindBy(xpath="//input[@name='$PCreateInt$pParticipantID']")
    public WebElement participantSearch;


    @FindBy(xpath="//button[@title='Create Interaction']")
    public WebElement participantInteractionCreatebutton;
    
    
    @FindBy(xpath = "//input[@id='WarmTransferHIPAA']")
    public WebElement warmTransfer;
    
    @FindBy(xpath = "//button[@id='submitButton']")
    public WebElement submitbtn;
    
    @FindBy(xpath = "//div[@class='p360down']")
    public WebElement threesixtytabminimizingdownArrow;
    
    @FindBy(xpath = "//div[@class='p360up']")
    public WebElement threesixtytabmaxUpArrow;
    
    @FindBy(id = "PegaGadget0Ifr")
    public WebElement iframe1;
    
    @FindBy(id = "convIframe")
    public WebElement iframe2;
    
    @FindBy(name = "actionIFrame")
    public WebElement actioniframe;
    
    @FindBy(id = "convIframe_sub")
    public WebElement convsubframe;
    
 

    public CallCenterParticipantHomePage searchParticipant(String p_id){

        switchToFrame(othersPageIframe);

        waitForElementToBeDisplayed(participantSearch);

        participantSearch.clear();

        participantSearch.sendKeys(p_id);
        
        javaScriptClick(participantInteractionCreatebutton);
        
        return new CallCenterParticipantHomePage();
//        participantInteractionCreatebutton.Click();

    }

    
    
    public CallCenterToDosPage searchParticipants(String p_id){

        switchToFrame(othersPageIframe);

        waitForElementToBeDisplayed(participantSearch);

        participantSearch.clear();

        participantSearch.sendKeys(p_id);
        
        javaScriptClick(participantInteractionCreatebutton);
        
        return new CallCenterToDosPage();
//        participantInteractionCreatebutton.Click();

    }

    
    
    
    
    
    
    
    /*
     * Minimizing 360 tab
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
    
    public void interactionCallInToDo(String programName) throws Exception{
    		
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
    	
    }

    public ProgramEnrollmentPage clickOnWarmTransfer() throws Exception{
        
    	WebDriverWait WDwait = new WebDriverWait(getWebDriver(), 65);
    	
    	try{
    	switchToDefault();
    	
    	switchToFrame(iframe1);
    	
    	waitForPageToLoad();
    	
    	switchToFrame(convsubframe);
    	
    	System.out.println("convframe: "+convsubframe);
    	
    	waitForPageToLoad();
    	
    	switchToFrame(actioniframe);
    	
    	System.out.println("ActionIframe: "+actioniframe);
    	
    	waitForPageToLoad();
    
    	Thread.sleep(5000);
    	System.out.println("waiting for warm transfer");
    	WDwait.until(ExpectedConditions.visibilityOf(warmTransfer));
    	System.out.println("warm transfer waiting for click");
    	javaScriptClick(warmTransfer);

    	System.out.println("Clicked on Warm Trasfer checkbox");
    	
    	waitForPageToLoad();
    	
    	//submitbtn.click();
    	}catch (UnhandledAlertException f) {
    	    try {
    	        Alert alert = getWebDriver().switchTo().alert();
    	        String alertText = alert.getText();
    	        System.out.println("Alert data: " + alertText);
    	        alert.accept();
    	    } catch (NoAlertPresentException e) {
    	        e.printStackTrace();
    	    }
    		//WDwait.until(ExpectedConditions.alertIsPresent());
    	}
    	 
		WDwait.until(ExpectedConditions.visibilityOf(submitbtn));
    	
		Thread.sleep(3000);
		javaScriptClick(submitbtn);
    	
    	System.out.println("clicked on submit button");
    	
    	//Implicitwait();
    	
    	waitForSpecifiedTime(60);
    	//waitForPageToLoad();
    	
    	return new ProgramEnrollmentPage();
    	
    }
    
   
    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(otherIconHighlighted);
        return otherIconHighlighted.isDisplayed();

    }
}
