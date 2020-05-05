package com.alerehealth.ui.portal.rewards;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class HistoryPage extends PortalHomePage{
	
	@FindBy(xpath="//section[@class='card card--result two-column inline']")
	private WebElement history;
	
	
	public String getChallengeCreditsInHistory(String challengeName){

	String xpath = "//h2[contains(text(),'"+challengeName+"')]//..//..//span[@class='points-credit']";
	WebElement eleCredits = getWebDriver().findElement(By.xpath(xpath));
	waitForElementToBeDisplayed(eleCredits);
	
	return eleCredits.getText().trim();
	}
	
	public void selectHistoryDropdown(String historyValue){
		
		String xpath="//select[@id='pointsHistoryCard']//option[contains(text(),'"+historyValue+"')]";
		WebElement drpDownValues = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(drpDownValues);
		javaScriptClick(drpDownValues);
		
	}
	
	public List<String> getMissedChallengeTitlesFromHistory(){
		
		selectHistoryDropdown("Missed");
		
		String xpath = "//div[@id='points-history-missed']//h2";
		List<WebElement> missedTitleElements = getWebDriver().findElements(By.xpath(xpath));
		List<String> missedTitlesInHistory = new ArrayList<String>();
		
		missedTitleElements.forEach(titles -> missedTitlesInHistory.add(titles.getText().trim()));
		return missedTitlesInHistory ;
	}
	
	
	
	
	@Override
	public boolean isDisplayed(){
		waitForElementToBeDisplayed(history);
		return history.isDisplayed();
	}

}
