package com.alerehealth.ui.callcenter.common.pages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.and;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class CallCenterTrackersPage extends CallCenterHomePage{

	@FindBy(id = "PegaGadget0Ifr")
    public WebElement iframe1;
	
	@FindBy(xpath="//span[contains(text(),'Participant Summary Dashboard')]")
	public WebElement threesixtytabSummaryText;
	
	@FindBy(xpath="//div[@title='Trackers' and @class='Tracker360b']")
	public WebElement trackersTab;
	
	@FindBy(xpath="//*[contains(@name,'$PHDTrackerPage$pTrackerGoals$l1$pGoalType') and contains(@value,'Distance')]")
	public WebElement activityDistance;
	
	
	@FindBy(xpath="//select[@name='$PHDTrackerPage$pTrackerGoals$l1$pMilesPerWeek']")
	public WebElement milesEachWeek;
	
	@FindBy(xpath="//select[@name='$PHDTrackerPage$pTrackerGoals$l1$pNumberOfWeeks']")
	public WebElement noOfWeeks;
	
	/*@FindBy(xpath = "//button//div[contains(text(),'Save Goal')]")
	public WebElement saveGoalbtn;*/
	
	@FindBy(xpath = "//select[@name='$PHDTrackerPage$pDurationHours']")
	public WebElement durationHours;
	
	@FindBy(xpath = "//select[@name='$PHDTrackerPage$pDurationMinutes']")
	public WebElement durationMints;
	
	@FindBy(xpath = "//*[contains(@name,'TrackerSectionWrapper')]//*[contains(text(),'Save')]")
	public WebElement saveTrackbtn;
			
	@FindBy(xpath="//span[contains(text(),'Tracker History')]")
	public WebElement trackerHistoryHeading;
	
	@FindBy(id="f360ms")
    protected WebElement SummaryPageIframe;
	
	@FindBy(xpath="(//table[@summary='TrackerGoalHistory'])[1]//tr[@id='$PHDTrackerPage$pTrackerHistory$l1']")
	public WebElement trackerHistoryRow;
	
	@FindBy(id="convIframe")
	public WebElement convIframe1;
	
	@FindBy(id="convIframe_sub")
	public WebElement convIframeSub1;
	
	@FindBy(id="f360s")
    public WebElement trackersTabFrame;
	
	@FindBy(xpath="//span[contains(text(),'Trackers')]")
	public WebElement trackersText;
	
	@FindBy(xpath="//*[contains(@name,'$PHDTrackerPage$pTrackerGoals$l1$pGoalType') and contains(@value,'Distance-Weekly')]")
	public WebElement distanceWeeklyradiobtn;
	
	@FindBy(xpath = "//select[@id='PortalVersion']")
	public WebElement portalVersionDropDwn;
	
	@FindBy(xpath = "//*[contains(@name,'$PHDTrackerPage$pTrackerGoals$l1$pGoalType') and contains(@value,'Fruts_Fats_Vegetables')]")
	public WebElement nutritionGoalRadioBtn;
	
	@FindBy(xpath = "//input[@id='FruitGoalFlag1' and contains(@name,'$PHDTrackerPage$pTrackerGoals$l1$pFruitGoalFlag')]")
	public WebElement fruitGoalcheckbox;
	
	@FindBy(xpath = "(//*[contains(text(),'fruit a day for')]/../..//preceding-sibling::td)[last()]//select")
	public WebElement fruitDropDwn;
	
	@FindBy(xpath = "//select[contains(@name,'NumberOfWeeksFruit')]")
	public WebElement noOfWeeksFruitsDropDwn;
	
	@FindBy(xpath = "//*[contains(@name,'measurementDate') and contains(@validationtype,'datetime')]")
	public WebElement trackDateFromUI;
	
	@FindBy(xpath = "//select[contains(@title,'Vegetables')]")
	public WebElement veggiesTrackDropDwn;
	
	@FindBy(xpath = "//select[contains(@title,'Fruits')]")
	public WebElement fruitsTrackDropDwn;
	
	
	public void getFrame(){
		
		WebDriver webDriver = getWebDriver();
				
		webDriver.switchTo().defaultContent();
		
		webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		List<WebElement> mainFrames = webDriver.findElements(By.tagName("iframe"));
		
		System.out.println("Main frames count" + mainFrames.size());
		
		for(WebElement iframe: mainFrames){
			
			try{
				
				System.out.println("Inside try");
				
				System.out.println("frame id =" + iframe.getAttribute("id") +" name ="+ iframe.getAttribute("name") );
				
				webDriver.switchTo().frame(iframe);
				
				iframe.findElement(By.xpath("//div[@data-node-id='TrackerGoal_NextGen']//input[@value='Distance']"));
				
				System.out.println("Element found");
				System.out.println("id = "+ iframe.getAttribute("id"));
				System.out.println("name ="+ iframe.getAttribute("name"));
				
				return;
				
				
			}catch(Exception e){
				
				try{
				List<WebElement>frmesLvl1 = webDriver.findElements(By.tagName("iframe"));
				
				for(WebElement lvl1frame : frmesLvl1){
					
					if(isElementPresent(lvl1frame)){
						
						System.out.println("Element found");
						
						System.out.println("id = "+ lvl1frame.getAttribute("id"));
						System.out.println("name ="+ lvl1frame.getAttribute("name"));
						
						
					} 
					
					
				}
				
			}catch(Exception a){
			
				a.printStackTrace();
			}try{
				List<WebElement>frmesLvl2 = webDriver.findElements(By.tagName("iframe"));
				
				for(WebElement lvl2frame : frmesLvl2){
					
					if(isElementPresent(lvl2frame)){
						
						System.out.println("Element found");
						
						System.out.println("id = "+ lvl2frame.getAttribute("id"));
						System.out.println("name ="+ lvl2frame.getAttribute("name"));
						
						
					} 
					
					
				}
				
			}catch(Exception a){
			
				a.printStackTrace();
			}
				finally{
					
					webDriver.switchTo().parentFrame();
				}
			}
			
			
		}
		
		
	}
	
	public boolean isElementPresent(WebElement frame){
		
		WebDriver webDriver = getWebDriver();
		
		
		
		try{
			
		System.out.println("frame id =" + frame.getAttribute("id") +" name ="+ frame.getAttribute("name") );
		webDriver.switchTo().frame(frame);
		
		webDriver.findElement(By.xpath("//div[@data-node-id='TrackerGoal_NextGen']//input[@value='Distance']")); 
		
		System.out.println("Found element in frame id =" + frame.getAttribute("id") +" name ="+ frame.getAttribute("name") );
		
		return true;
				
		}catch(Exception e)
		{
			
			webDriver.switchTo().parentFrame();
			
			return false;
		}
		
	}
	
	
	public void clickOnTrackers() throws InterruptedException{
		
		waitForPageToLoad();
		
		Thread.sleep(2000);
		
		javaScriptClick(activityDistance);
		
		/*WebDriverWait wait = new WebDriverWait(getWebDriver(),20);
		wait.until(ExpectedConditions.visibilityOf(activityDistance));*/
		//javaScriptClick(activityDistance);

	}
	
	public void navigatingClient360Tab(String tabName) {

		switchToDefault();
		switchToFrame(iframe1);
		String tab360 ="//*[@id='360"+tabName+"']";
		WebElement element360TabClick = getWebDriver().findElement(By.xpath(tab360));
		javaScriptClick(element360TabClick);

		}

	
	/*
	 * Provide tracker type as ActivityLog,NutritionIntake,Sleep,StressLevel,Tobacco,BMI
	 */
	public void clickOnTrackerType(String trackertype){

		String trackerLeftPanel = "//*[@trackertype='"+trackertype+"']";
		
		WebElement loadTrackerLeftPanel = getWebDriver().findElement(By.xpath(trackerLeftPanel));
		
		javaScriptClick(loadTrackerLeftPanel);

	}
	
	public void distanceGoal() throws InterruptedException{
		
		Thread.sleep(2000);
			
		Select portalVersion = new Select(portalVersionDropDwn);
		
		portalVersion.selectByVisibleText("Next Gen Portal");
		
        String selectedOption = portalVersion.getAllSelectedOptions().get(0).getText();
		
		System.out.println("Selected portal version dropdown as: "+selectedOption);
			
		javaScriptClick(activityDistance);
		
		/*if(distanceWeeklyradiobtn.isDisplayed()){
			
		javaScriptClick(distanceWeeklyradiobtn);
		
		}*/
		
		WebDriverWait wait = new WebDriverWait(getWebDriver(),45);

        wait.until(ExpectedConditions.and((not(ExpectedConditions.stalenessOf(milesEachWeek))),ExpectedConditions.visibilityOf(milesEachWeek)));
        
		Select milesSelection = new Select(milesEachWeek);
		milesSelection.selectByValue("5.0");
		
		System.out.println("Miles per week selected as :" +milesSelection);
		
		Select totalWeeks = new Select(noOfWeeks);
		totalWeeks.selectByValue("9");
		
		System.out.println("weeks selected.");
		
	
	}
	
	/*
	 * Change goal values for distance again for to verify change goal functionality
	 */
    public void distanceChangeGoal() throws InterruptedException{
		
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(getWebDriver(),45);

        wait.until(ExpectedConditions.and((not(ExpectedConditions.stalenessOf(milesEachWeek))),ExpectedConditions.visibilityOf(milesEachWeek)));
        
		Select milesSelection = new Select(milesEachWeek);
		milesSelection.selectByValue("4.0");
		
		System.out.println("Miles per week selected as :" +milesSelection);
		
		Select totalWeeks = new Select(noOfWeeks);
		totalWeeks.selectByValue("8");
		
		System.out.println("weeks selected.");
	
	}
	
	public void saveOrChangeGoal(String saveChangeGoal) throws Exception{
		
		String activitySaveChangeGoal = "//button//div[contains(text(),'"+saveChangeGoal+"')]";
		
		WebElement activitySaveChangeGoalbtn = getWebDriver().findElement(By.xpath(activitySaveChangeGoal));
		
		javaScriptClick(activitySaveChangeGoalbtn);
		
		Thread.sleep(2000);
		
		waitForPageToLoad();
		
	}
	public void durationTrack() throws InterruptedException{
		//navigatingClient360Tab("s");  //remove it when u r running in a flow.
		waitForPageToLoad();
		
		Select durationTrackHr = new Select(durationHours);
		
		durationTrackHr.selectByVisibleText("3");
		
		Thread.sleep(2000);
		try{
		
			Select durationTrackMins = new Select(durationMints);
		
			durationTrackMins.selectByVisibleText("30");
		
		}catch(Exception e){
		
			staleIssue(durationMints);
		}
		
		waitForPageToLoad();
		
		javaScriptClick(saveTrackbtn);
		
		waitForPageToLoad();
		
	}
	
	public WebElement gettrackerHistorytext(){
		
		return trackerHistoryHeading;
		
	}
	
	public boolean trackerHistory(){
		
		System.out.println("Verified saved data.Row is added.");
		
		waitForPageToLoad();
		
		return trackerHistoryRow.isDisplayed();
		
	}
	
	
	/*
	 * Nutrition In take first time for Save Goal
	 * 
	 */
	public void nutritionGoal() throws InterruptedException{
		
        Thread.sleep(2000);
        
		Select portalVersion = new Select(portalVersionDropDwn);
		
		portalVersion.selectByVisibleText("Next Gen Portal");
		
        String selectedOption = portalVersion.getAllSelectedOptions().get(0).getText();
		
		System.out.println("Selected portal version dropdown as: "+selectedOption);
			
        waitForPageToLoad();
		
		javaScriptClick(nutritionGoalRadioBtn);
		
		System.out.println("Clicked on Nutrition goal radio button for fruits, fats/oils, veggies");
		
		javaScriptClick(fruitGoalcheckbox);
		
		Select fruitListDropDwn = new Select(fruitDropDwn);
		
		fruitListDropDwn.selectByValue("3");
		
		waitForPageToLoad();
		
		Select weeksListDropDwn = new Select(noOfWeeksFruitsDropDwn);
		
		weeksListDropDwn.selectByValue("3");
		
		getWebDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	
	/*
	 * Nutrition In take modify again for Change Goal
	 * 
	 */
	public void nutritionChangeGoal(){
		
		waitForPageToLoad();
		
	//	javaScriptClick(fruitGoalcheckbox);
		
		Select fruitListDropDwn = new Select(fruitDropDwn);
		
		fruitListDropDwn.selectByValue("5");
		
		waitForPageToLoad();
		
		Select weeksListDropDwn = new Select(noOfWeeksFruitsDropDwn);
		
		weeksListDropDwn.selectByValue("5");
		
		waitForSpecifiedTime(10);
		
	}
	
	/*public boolean verifyDate(){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH::MM ");
		LocalDateTime localDate = LocalDateTime.now(ZoneId.of("CST"));
		
		LocalDateTime sysDate= localDate.minusMinutes(2);
		
		//WebElement UI = trackDateFromUI;
		Date fromWebPage = (Date) trackDateFromUI;
		
		if(sysDate.equals(fromWebPage)){	
			System.out.println("Date matched");
			return true;
		}
		else{
			return false;
		}
	}*/	
	
	public void nutritionTrack() throws Exception{
		
		waitForPageToLoad();
		
		Select veggiesDropDown = new Select(veggiesTrackDropDwn);
		
		veggiesDropDown.selectByValue("6");
		
		waitForPageToLoad();
		
		Select fruitsDropDown = new Select(fruitsTrackDropDwn);
		
		fruitsDropDown.selectByValue("5");
		
		waitForPageToLoad();
		
		javaScriptClick(saveTrackbtn);
		
		waitForPageToLoad();
		
		Thread.sleep(2000);
		
	}
		
	
	
	
	
	
	
	
	
	@Override
    public boolean isDisplayed() {

		waitForPageToLoad();
		
		switchToDefault();
        
		switchToFrame(iframe1);
		
		switchToFrame(trackersTabFrame);
		
		waitForPageToLoad();
		
		return trackersText.isDisplayed();

    }



	
}
