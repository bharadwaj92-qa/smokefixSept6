package com.alerehealth.ui.callcenter.common.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alerehealth.fwk.db.ConnectionManager;
import com.alerehealth.fwk.db.DBDataFetcher;
import com.alerehealth.fwk.db.JDBCConnector;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterMyTeamPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterSmartSearchPage;

public class CallCenterHomePage extends CallCenterBasePage<CallCenterHomePage> {

	@FindBy(xpath= "//select[@id='pyCurrentApplication']")
	private WebElement roleDropDown;
	
	@FindBy(className="main-menu")
	private WebElement leftSideNavMenu;
	
	@FindBy(xpath= "//*[@class='logo']")
    public WebElement clientLogo;
		
	@FindBy(xpath= "//a[text()='Phrases']")
    public WebElement headerPhrases;

	@FindBy(xpath="//*[@id='IsOnGetNext']/..")
    public WebElement headerGetNext;

	@FindBy(xpath="//*[@id='IsAvailableToWork']/..")
    public WebElement headerIsAvailableToWork;
	
	@FindBy(xpath= "//*[@class='fa fa-warning']/..")
    public WebElement headerReportIssue;
	
	@FindBy(xpath= "//*[@class='log-out']")
    public WebElement headerLogoff;
	
	@FindBy(xpath= "//*[@class='user-avatar']/.")
    public WebElement headerUserName;
		
	@FindBy(xpath="//*[@id='IsOnGetNext']")
    public WebElement headerGetNextCheckBox;

	@FindBy(xpath="//*[@id='IsAvailableToWork']")
    public WebElement headerIsAvailableToWorkCheckBox;
	
	@FindBy(id="home_criteria_table_sub_iframe")
	public WebElement searchCriteriaIframe;
	
	@FindBy(id="home_results_iframe")
	protected WebElement home_results_iframe;
	
	@FindBy(id = "PegaGadget0Ifr")
	protected WebElement pegaGadgetFrame360Tab;
	
	
	 //Added code  

		String[] resultDB = null;
		
		String txtParticipant = null;
		
		String participantDB = null;
		 ConnectionManager dbcon = new ConnectionManager();
		 DBDataFetcher dbData = new DBDataFetcher();
		 JDBCConnector jdbccon = new JDBCConnector();
		 
		 String dbQuery ="select p.participantid from "+
"PRPC.PARTICIPANT_PROGRAM pp, PRPC.RFPROGRAM_CDR r, PRPC.PARTICIPANTS p where programcategoryid = 1 and targetdate is not null "
+"and pp.participantid=p.participantid and pp.primaryprogramid=r.programid " +
"and pp.programstatusid='ENR' and clientid='4000075' order by clientid DESC, targetdate desc";
	
    public CallCenterReportIssuePage clickReportIssueLink(){
    	
    	String xpath= "//*[@class='fa fa-warning']/..";
    	WebElement headerReportIssue= getWebDriver().findElement(By.xpath(xpath));
        javaScriptClick(headerReportIssue);
		return new CallCenterReportIssuePage();   	

    }
    
	public void clickGetNextCheckBox(){
		
		String xpath= "//*[@id='IsOnGetNext']";
    	WebElement getNextCheckBox= getWebDriver().findElement(By.xpath(xpath));
        javaScriptClick(getNextCheckBox);
   
	}
    
	public boolean isGetNextCheckBoxPresent() {

		try {
			return headerGetNextCheckBox.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
	
	public boolean isAvailableToWorkCheckBoxCheckBoxPresent() {

		try {
			return headerIsAvailableToWorkCheckBox.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
	
    public String  getTitleOfheaderUserName(){
        return headerUserName.getText().trim();
    }
    
    public String  getTitleOfheaderLogoff(){
        return headerLogoff.getText().trim();
    }
    
    public String  getTitleOfheaderReportIssue(){
        return headerReportIssue.getText().trim();
    }
    	
    public String  getTitleOfheaderIsAvailableToWork(){
        return headerIsAvailableToWork.getText().trim();
    }
    
    public String  getTitleOfheaderGetNext(){
        return headerGetNext.getText().trim();
    }
    
    public String  getTitleOfheaderPhrases(){
    	waitForElementToBeDisplayed(headerPhrases);
        return headerPhrases.getText().trim();
    }
	
	public void clickRoleSelectionDropdown(){
		
		waitForElementToBeDisplayed(roleDropDown);
		roleDropDown.click();
	}
	
    
	public boolean isClientLogoIsPresent() {

		try {

			return clientLogo.isDisplayed();
						
		} catch (NoSuchElementException e) {

			return false;
		}
	}
    
//	public void selectUserRole(String role){
//		
//		clickRoleSelectionDropdown();
//
//		String roleXpath = "//select[@id='pyCurrentApplication']//following-sibling::option[contains(text(),'"+role+"')]";
//		WebElement elementRole = getWebDriver().findElement(By.xpath(roleXpath));
//		elementRole.click();
//		
//		waitForSpecifiedTime(10);
//		
//	}
	
//	public void clickRightNavigation(String menu) {
//
//		String menuXpath = "//ul[@class='main-menu']//*[contains(text(),'" + menu + "')]";
//
//		WebElement elementMenu = getWebDriver().findElement(By.xpath(menuXpath));
//
//		waitForElementToBeDisplayed(elementMenu);
//
//		
//		javaScriptClick(elementMenu);
//		waitForSpecifiedTime(4);
//		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
//		String readyState = js.executeScript("return document.readyState").toString();
//
//		if (readyState.equals("complete")) {
//
//			System.out.println("Inside javascript click failed");
//			
//			WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), 30);
//			webDriverWait.until(ExpectedConditions.elementToBeClickable(elementMenu));
//
//			Actions actions = new Actions(getWebDriver());
//			actions.moveToElement(elementMenu).click(elementMenu).perform();	
//
//		}
//
//		waitForSpecifiedTime(45);
//
//	}
	
	public void selectUserRole(String role){

		waitForElementToBeDisplayed(roleDropDown);

		Select roleSelection = new Select(roleDropDown);

		roleSelection.selectByVisibleText(role);

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)getWebDriver();

		javascriptExecutor.executeScript("$(arguments[0]).onchange;", roleDropDown);

		roleDropDown.sendKeys(Keys.RETURN);

		waitForPageToLoad();
//		waitForSpecifiedTime(120);

		}
	
	public void clickRightNavigation(String menu) {


		String menuXpath = "//ul[@class='main-menu']//*[contains(text(),'"+menu+"')]";

		WebElement elementMenu = getWebDriver().findElement(By.xpath(menuXpath));

		waitForElementToBeDisplayed(elementMenu);

		WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(),30);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(elementMenu));

		Actions actions = new Actions(getWebDriver());
		actions.moveToElement(elementMenu).click(elementMenu).perform();

		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		String readyState = js.executeScript("return document.readyState").toString();

		if(readyState.equals("complete")){

		System.out.println("Inside javascript click");
		javaScriptClick(elementMenu);

		}

		waitForSpecifiedTime(45);

		}
	

	public CallCenterSmartSearchPage openSearchPage(){

		System.out.println("Navigating to Search page");

		clickRightNavigation("Search");

		waitForPageToLoad();

		waitForSpecifiedTime(60);

		return new CallCenterSmartSearchPage();


	}
	
	public CallCenterMyWorkBasketPage openMyWorkPage(){

		System.out.println("Navigating to My Work page");

		clickRightNavigation("My Work");

		waitForPageToLoad();

		waitForSpecifiedTime(60);
		
		return new CallCenterMyWorkBasketPage();


	}
	
	public CallCenterOthersHomeMenuPage openOtherPage(){

		System.out.println("Navigating to Other page");

		clickRightNavigation("Other");

		waitForPageToLoad();

		waitForSpecifiedTime(60);

		return new CallCenterOthersHomeMenuPage();


	}
	
	public CallCenterMyTeamPage openMyTeamPage(){

		System.out.println("Navigating to Search page");

		clickRightNavigation("My Team");

		waitForPageToLoad();

		waitForSpecifiedTime(60);

		return new CallCenterMyTeamPage();

		}
	
	@Override
	public boolean isDisplayed() {
		
      waitForElementToBeDisplayed(leftSideNavMenu);
		
		return leftSideNavMenu.isDisplayed();
	}

	public boolean duedateISDisplayed() {
		return true;
		// TODO Auto-generated method stub
		
	}
	
	
	 //Added code
    public String getParticipantIDFromDb() throws Throwable{
   	 
        
  	   ConnectionManager.getPRPCDBConnection();
  	    
  	    System.out.println("Database values");
  	    
  	   // System.out.println(dbQuery);
  	    
     resultDB = DBDataFetcher.getRowDataForQueryFromPRPCDB(dbQuery);
  	  
  	 
  	    for(int i=0; i< resultDB.length ; i++){
  	    	
  	    	txtParticipant = resultDB[i];
  	    	System.out.println("Participant ID value from DB is " + txtParticipant);
  	    }
  	    
  		JDBCConnector.closeConnection();	
          
        return txtParticipant;
     }
      
    

}
