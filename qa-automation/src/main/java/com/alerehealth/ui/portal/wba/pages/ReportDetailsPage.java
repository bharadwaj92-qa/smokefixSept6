package com.alerehealth.ui.portal.wba.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.excel.ExcelReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import cucumber.api.DataTable;
import java.util.Map;

public class ReportDetailsPage extends ReportSummary{

	@FindBy(xpath = "//span[@class='wba--icons Icon-check wba--results-icons']")
	private WebElement WbaResultsIconCheckIn;

	@FindBy(xpath = "//span[@class='wba--icons Icon-circle wba--results-icons']")
	private WebElement WbaResultsIconUncheck;

	@FindBy(xpath = "//span[contains(text(),'Overall Wellbeing : ')]")
	private WebElement HeaderTextinResultsDetailsPage; 

	
	String wbaResultLinksPage="";

	//Creating the JavascriptExecutor interface object by Type casting		
    JavascriptExecutor js = (JavascriptExecutor)getWebDriver();
    
	
	/*
	 * getDomainDescription - This Method returns the DomainDescription from UI
	 * argument - domain Name
	 */
	public String getDomainDescription(String domain) {

		String xpath = "//div[@id='activity-"+domain+"']/../../following-sibling::div";
		WebElement domainDescription = getWebDriver().findElement(By.xpath(xpath));
		LoggerUtils.info(domain+" Description from UI :\n"+domainDescription.getText());
		
		return domainDescription.getText();

	}

	/*
	 * getDomainScore - This Method returns the domainScore from UI
	 * argument - domain Name, Score
	 */
	public String getDomainScore(String domain,String score) {
		
		String xpath = "//div[@id='activity-"+domain+"']/following-sibling::h4[contains(text(),'Total Score: "+score+" of 100')]";
		WebElement domainScore = getWebDriver().findElement(By.xpath(xpath));
		LoggerUtils.info(domain+" Score from UI :\n"+domainScore.getText());
		
		return domainScore.getText();
	}

	/*
	 * Individual bullets and left Navigation validation
	 * 
	 */
	public void reportDetailsWbaLeftNav(String domainName){

		String xpath = "//nav[contains(@class,'activity-details')]/ul/li/a";
		
		List<WebElement> navList = getWebDriver().findElements(By.xpath(xpath));
		
		System.out.println("Left nav lift size:" +navList.size());
		
		for(WebElement textList: navList){

			String domainLeftNav = textList.getText();
		
			if(domainLeftNav.contains(domainName)){
			
				getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				textList.click();
				
				System.out.println("Clicked on "+domainName+" in left nav.");
				
				WebElement domainText = getWebDriver().findElement(By.xpath("//div[contains(@class,'wba--summary-description')]/h2[contains(text(),'"+domainName+"')]"));
				
				System.out.println("Domain Header name: "+domainText.getText());
			}
			
		}

	}

	
	/*
	 * To retrieve bullets points for both check and uncheck circles for Emotional,Social,Financial,Spiritual Domains.
	 */
	public String individualBullets(String domainBullets, int index){
		
		String BulletList=null;
		
		WebElement domainTextinScore = getWebDriver().findElement(By.xpath("//div[contains(@class,'wba--mobile-nopadding')]/section[@id='"+domainBullets+"']//div[contains(@class,'activity-selected')]/h4"));
		
		System.out.println("Domain Header name: "+domainTextinScore.getText());
		
		String xpath = "//div[contains(@class,'wba--mobile-nopadding')]/section[@id='"+domainBullets+"']//div[@class='wba--summary-content']/section//h3";
		
		List<WebElement> individualBullets = getWebDriver().findElements(By.xpath(xpath));
		
		System.out.println("Count of Individual Bullets under "+domainBullets+" section is:" +individualBullets.size());
		
		if(WbaResultsIconCheckIn.isEnabled()? true : WbaResultsIconUncheck.isDisplayed()){
			
		BulletList = individualBullets.get(index).getText();
		
		System.out.println("Verified icons");
		
		}
		else{
			
			LoggerUtils.error("Unable to provide bullets as check icon is not able to find: " +domainBullets);
		}

		return BulletList;
		
	}
	
	
	/*
	 * To validate the texts of individual bullets for Emotional,Spiritual,Social & Financial Domains.
	 */
	public void getIndividualDomainsBulletTextFromExcel(DataTable arg1,String domainBullets){
		
		Map<String,String> dataMap = arg1.asMap(String.class, String.class);

        String sheetName = dataMap.get("sheetname");

        LoggerUtils.info("Reading from sheet: "+ sheetName);
        
        ExcelReader excelReader = new ExcelReader("ReportPageTextValidationData.xlsx", sheetName);

        excelReader.setStartRow(1);

        int index = 0;
        
		for (int i = excelReader.getStartRow()+1; i < excelReader.getRowCount(); i++) {
			 
			String statusTextFromUI = individualBullets(domainBullets,index);
			System.out.println("Question from UI is:" + statusTextFromUI);

            String statusTextFromExcel = excelReader.getCellValue("StatusText", i+1);
            System.out.println("Question from excel is:" + statusTextFromExcel);
            
            if (!statusTextFromUI.contentEquals(statusTextFromExcel)) {

                LoggerUtils.error("BulletText text from UI doesnt match with excel");
                LoggerUtils.warning("bulletTextFromUI:" + statusTextFromUI);
                LoggerUtils.warning("bulletTextFromExcel:" + statusTextFromExcel);

            }
			
			index++;
		}
		
		
	}
	
	/*
	 * Additional Resources under individual domains of report page
	 */
	public boolean getAdditionalResourcesLinks(String domainName,String LinkName) throws Exception{
	    
		String AditionalResourceCollapse = "//div[@data-target='#"+domainName+"additionalResources']";

		String AdditionalResourceLinks = "//div[@id='"+domainName+"additionalResources']//p/a[contains(text(),'"+LinkName+"')]";

		getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement AdditionalRsrcCollapseLink = getWebDriver().findElement(By.xpath(AditionalResourceCollapse));

		waitForElementToBeDisplayed(AdditionalRsrcCollapseLink);
		
		scrollElementIntoView(AdditionalRsrcCollapseLink);

		try{
		
			waitForComponentTobDisplayed(By.xpath("//div[@class='collapse in' and @id='"+domainName+"additionalResources' and @aria-expanded='true']"));
		
		}
		catch(Exception e){

			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			javaScriptClick(AdditionalRsrcCollapseLink);
			
		}
	
		WebElement linksNavListUnderAdditionalRsrc = getWebDriver().findElement(By.xpath(AdditionalResourceLinks));

		System.out.println("link is: " +linksNavListUnderAdditionalRsrc.isEnabled());
		
		getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return linksNavListUnderAdditionalRsrc.isDisplayed();
	
	}


	public void clickAdditionalResourceLink(String domainName,String LinkName) throws Exception{

		String linkName = "//div[@id='"+domainName+"additionalResources']//p/a[contains(text(),'"+LinkName+"')]";

		getWebDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		WebElement clickAdditionalLinks = getWebDriver().findElement(By.xpath(linkName));

		System.out.println(" Text is: "+clickAdditionalLinks.getText());

		wbaResultLinksPage = getWebDriver().getWindowHandle();
		
		System.out.println("Parent winow: Wba results page, where additional resource links are present: " +wbaResultLinksPage);
		
		waitForElementToBeDisplayed(clickAdditionalLinks);
		
		getWebDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		javaScriptClick(clickAdditionalLinks);
		
		System.out.println("Clicked on " +LinkName+ " link.");
		
        
	}

	public void AdditionalResourceWbaResultsPage(String AddiotionalRsrcdomainName){
		
		String xpath = "//div[@data-target='#"+AddiotionalRsrcdomainName+"additionalResources']";
		WebElement AdditionalRsrcLink = getWebDriver().findElement(By.xpath(xpath));
		AdditionalRsrcLink.click();

	}

	/*
	 * clickOnBullet - This method clicks on the bullet in reportDetails Page
	 * arguments - bulletName
	 */
	public void clickOnBullet(String bulletName){
		
		String xpath = "//h3[contains(.,'"+bulletName+"')]";
		LoggerUtils.info("Clicking the "+bulletName+" bullet");
		WebElement bulletXpath = getWebDriver().findElement(By.xpath(xpath));
		LoggerUtils.info("bulletXpath is - "+bulletXpath);
		javaScriptClick(bulletXpath);
		//getWebDriver().findElement(By.xpath(bulletXpath)).click();
	}

	/*
	 * verifyPhysicalBulletIcons - This method verifies the Physical domain bullets
	 * arguments - bulletName, Status - [check, circle]
	 */
	public boolean verifyPhysicalBulletIcons(String bulletName,String Status){

		String xpath = "//h3[contains(.,'"+bulletName+"')]/span[contains(@class,'Icon-"+Status.toLowerCase()+"')]";
		return getWebDriver().findElement(By.xpath(xpath)).isDisplayed();

	}
	
	/*
	 * getPhysicalBulletTextFromExcel - returns the physicalBulletTextFromExcel (excel - ReportPageTextValidationData.xlsx)
	 * arguments - bullet Display Condition.
	 */
	public String getPhysicalBulletTextFromExcel(String bulletCondition){

		ExcelReader excelReader = new ExcelReader("ReportPageTextValidationData.xlsx", "BulletText");
		excelReader.setStartRow(1);
		String textFromExcel = "";
		for (int i = excelReader.getStartRow()+2; i <= excelReader.getRowCount(); i++) {
			//System.out.println("Data from Excel - "+excelReader.getCellValue("BulletName", i));

			if(excelReader.getCellValue("BulletName", i).equalsIgnoreCase(bulletCondition)){
				//System.out.println(excelReader.getCellValue("StatusText", i));
				textFromExcel = excelReader.getCellValue("StatusText", i);
				break;
			}
		}
		textFromExcel = textFromExcel.replace("firstname", getLoggedInUserID()).trim();
		LoggerUtils.info("Text for "+bulletCondition+" is\n"+textFromExcel);
		
		return textFromExcel;

	}
	
	/*
	 * getPhysicalBulletTextFromUI - returns the PhysicalBullet Text from UI
	 * arguments - bulletName
	 */
	public String getPhysicalBulletTextFromUI(String bulletName){
		
		String xpath = "//h3[contains(.,'"+bulletName+"')]/ancestor::section[@class='tile layout--drawer-control']//div[@class='collapse in']//div";
		String bulletText = getWebDriver().findElement(By.xpath(xpath)).getText();
		bulletText = bulletText.split("Data", 2)[0].trim();
		LoggerUtils.info("Text from "+bulletName+" bullet from UI is\n"+bulletText);
		
		return bulletText;
	}
	
	/*
	 * getLoggedInUserID - returns the UserID of LoggedIn user
	 */
	public String getLoggedInUserID(){
		
		String xpath = "//li[@class='ogn-header-link-list__account']/a";
		String userID = getWebDriver().findElement(By.xpath(xpath)).getText();
		System.out.println("User ID from Ui"+userID);
		userID = userID.split(" ",2)[0];
		LoggerUtils.info("UserID for LoggedIn User :"+userID);
		
		return userID;
	}
	
	/*
	 * windowsOrTabsHandle(): This method is used to handle windows or tabs.
	 */
    public void windowsOrTabsHandle(){
		
		Set<String> totalNumactiveSessions = getWebDriver().getWindowHandles();

	    System.out.println("opeened sessions or tabs or windows " +totalNumactiveSessions.size());
	
	    Iterator<String> itr = totalNumactiveSessions.iterator();
	
	   while(itr.hasNext()){
		
		String childSessions = itr.next();
		
		if(!wbaResultLinksPage.equals(childSessions)){
		
		getWebDriver().switchTo().window(childSessions);
		
		System.out.println(getWebDriver().switchTo().window(childSessions).getTitle());
		
		jsVerificationMethods();
		
		getWebDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		getWebDriver().close();
	   
		}
	}
	
	getWebDriver().switchTo().window(wbaResultLinksPage);
		
	}
		
	/*
	 * To navigate back in browser
	 */
	public void browserBack(){
			
		getWebDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		getWebDriver().navigate().back();
		
		System.out.println("Clicked on browser back button.");
		
	}

	/*
	 * Different JavaScript usages for retrieving domain,URL,title of the pages
	 */
	public void jsVerificationMethods(){
		//Fetching the Domain Name of the site.
		
		String externalDomainName = js.executeScript("return document.domain;").toString();			
        
		System.out.println("Domain name of the site = "+externalDomainName);
	    
        //Fetching URL of the site
        
		String  externalDomainUrl = js.executeScript("return document.URL;").toString();
		
		System.out.println("URL of is: " +externalDomainUrl);
		
		//Fetch the Title name of the site
		
		String externalDomainTitle = js.executeScript("return document.title;").toString();
		
		System.out.println("Title of the is: " +externalDomainTitle);	
	}
	
	@Override
    public boolean isDisplayed() {
		
		waitForElementToBeDisplayed(HeaderTextinResultsDetailsPage);
        
		return true;
    }




}
