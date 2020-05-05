package com.alerehealth.ui.callcenter.mainmenu;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;




public class CallCenterEducationAndGoalsTab extends CallCenterHomePage{
	
	
	@FindBy(id="PegaGadget0Ifr")
	private WebElement Pega360PageIframe;
	
	@FindBy(id="f360i")
	private WebElement EducationAndGoalIframe;
	
	@FindBy(xpath = "//td[@nowrap='nowrap']/span[contains(text(),'Motivational Goals')]")
	private WebElement MotivationalGoalsText;
	
	@FindBy(xpath ="//div[@class='ellipse_GoalDisplay']")
	private List<WebElement> goals;
	
	@FindBy(xpath = "//td[@nowrap='nowrap']/span[text()='IGAO Filter']")
	private WebElement IGAOFilter;
	
	
	@FindBy(xpath = "//input[@value='InPlan' and @checked]")
	public WebElement inPlanRadio;
	
	@FindBy(id="BtnCalculateGaps")
	public WebElement calculateGapsButton;
	
	@FindBy(id="BtnRefreshGaps")
	public WebElement refreshButton;
	
	@FindBy(xpath="//span[text()='Care Gaps']//..//following-sibling::td[2]//span")
	public WebElement caregapsCount;
	
	// Goal manager In-Plan goals xpath
	
	public void verifyCareGaps(){
		//expand care gaps
		
		waitForElementToBeDisplayed(calculateGapsButton);
		javaScriptClick(calculateGapsButton);
	
		
	}
	
	
	public String getCaregapsCountInEducationGoals(){
		
		waitForElementToBeDisplayed(caregapsCount);
		String count = caregapsCount.getText().trim();
		System.out.println("Care gaps Count in Education Goals" + count);
		
		return count;
	}
	
	
	
	
	public void expandSection(String sectionName){
		
		String xpath = "//td[@nowrap='nowrap']/span[text()='"+sectionName+"']";
		WebElement section = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(section);
		javaScriptClick(section);
		LoggerUtils.info("Expanding "+sectionName+" section");
	}
	
	public List<String> getAllGoals(){
		
		List<String> allGoals = new LinkedList<>() ;
		waitForElementToBeDisplayed(IGAOFilter);		
		for (WebElement goal : goals) {
			System.out.println(goal.getText());
			allGoals.add(goal.getText());
		}
		return allGoals;
	}
	

	
	@Override
    public boolean isDisplayed() {
		
		getWebDriver().switchTo().defaultContent();
		switchToFrame(Pega360PageIframe);
		switchToFrame(EducationAndGoalIframe);
		waitForElementToBeDisplayed(MotivationalGoalsText);
		return MotivationalGoalsText.isDisplayed();
		
		
    }


	public void verifyInPlanCheckBox() {
		
		List<String> inPlanGoals = getAllGoals();
		
		String xpath = "//input[@checked]/ancestor::th/following-sibling::td[@class='dataValueRead']//div[@class='ellipse_GoalDisplay']";
		List<WebElement> checkedGoals = getWebDriver().findElements(By.xpath(xpath));
		
		Assert.assertEquals(inPlanGoals.size(), checkedGoals.size());
		
	}
	
	public CallCenterGapHistoryPage selectGapHistoryFromEducationPage(){
		
		getWebDriver().switchTo().defaultContent();
		switchToFrame(Pega360PageIframe);
		String xpath = "//td[@class='p360bar']//li/div[@title='Gap History']";
		WebElement pega360Tab = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(pega360Tab);
		//pega360Tab.click();
		javaScriptClick(pega360Tab);
		
		
		return new CallCenterGapHistoryPage();
		
		
	}
}
