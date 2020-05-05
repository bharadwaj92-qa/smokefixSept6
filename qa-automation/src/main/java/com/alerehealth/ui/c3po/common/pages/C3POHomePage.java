package com.alerehealth.ui.c3po.common.pages;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.ui.c3po.common.pages.DCPTestUserPage;
import com.alerehealth.ui.c3po.common.pages.C3POLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class C3POHomePage extends C3POLoginPage {


	private static final long FRAMES_WAIT_DURATION_SECONDS = 30;
	
	@FindBy(xpath="//a[@aria-label='Test Users']")
	private WebElement testUsers;

	@FindBy(xpath="//img[@src='desktopimages/dialogprofilegreenhueimage.gif']")
	private WebElement createTestUsers;

	@FindBy(xpath="//td//label[contains(text(),'Program Category')]/../../..//select[@id='ClientXProgCatID']/following-sibling::span/input")
	private WebElement programCategory;

	@FindBy(xpath="//a[contains(text(),'Log off')]")
	private WebElement logoffBtn;

	public String mainwindow;



	public void clickLogOffButton() {

		
		javaScriptClick(logoffBtn);

	}

	public void switchtoframe()
	{

		getWebDriver().switchTo().frame("PR_Ifr");


	}

	public void clickOnTestUsers()
	{

		testUsers.click();

		createTestUsers.click();

	}



	public void Alertaccept() {

		getWebDriver().switchTo().alert().accept();
	}


	public void expandDropdown(String drpdwnlnk) throws InterruptedException
	{

		String xpath="//select[@id='" + drpdwnlnk + "']/following-sibling::span/a";
       // TODO : covert this thread.sleep to wait condition 
		
		Thread.sleep(5000);
//		waitForPageToLoad();
		
		WebElement clientandWorkingpopulationDropdown = getWebDriver().findElement(By.xpath(xpath));
		
		waitForElementToBeDisplayed(clientandWorkingpopulationDropdown);

		javaScriptClick(clientandWorkingpopulationDropdown);
	}


//		public void waitForPageToLoad(){
//   
//        long startTime = System.currentTimeMillis();
//
//        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), FRAMES_WAIT_DURATION_SECONDS);
//
//        webDriverWait.until((ExpectedCondition<Boolean>) wd ->
//                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
//
//        webDriverWait.until((ExpectedCondition<Boolean>) wd ->
//                (Boolean) ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
//
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime-startTime)/1000);
//
//        
//    }

	public void clickOnEnter()
	{
		
		if(Configuration.getConfiguration().getBrowser().equalsIgnoreCase("Firefox")){
		programCategory.sendKeys(Keys.ENTER);
		}
	}


	public void selectMenuItem(String menuItem) throws InterruptedException{

		String xpath ="//ul[contains(@class,'ui-autocomplete') and contains(@style,'display: block')]//li[contains(text(),'" + menuItem + "')]";

		WebElement selectMenuList = getWebDriver().findElement(By.xpath(xpath));
		
		waitForElementToBeDisplayed(selectMenuList);
		
		selectMenuList.click();

	}

	/*
	 * selectDropdownsInC3Page - Selects the drop downs from C3 page
	 * parameters - clientName, workingPopulation
	 */

	public void selectDropdownsInC3Page(String client,String workingPopulation) throws InterruptedException{

		switchtoframe();
		expandDropdown("Client");

		selectMenuItem(client);
		clickOnEnter();

		expandDropdown("WorkingPopulation");

		selectMenuItem(workingPopulation);

		expandDropdown("Mode");

		selectMenuItem("Active");
		
	}

	public DCPTestUserPage switchtoNewWindow()
	{
		mainwindow=getWebDriver().getWindowHandle();

		Set<String> allWindowHandles = getWebDriver().getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {


			if (!currentWindowHandle.equals(mainwindow)) {
				getWebDriver().switchTo().window(currentWindowHandle);


			}
		}
		getWebDriver().manage().window().maximize();
		return new DCPTestUserPage();
	}

	public void switchToMainWindow(){

		getWebDriver().close();
		getWebDriver().switchTo().window(mainwindow);
		getWebDriver().switchTo().defaultContent();


	}

	@Override
	public boolean isDisplayed() {

		return logoffBtn.isDisplayed();
	}

}
