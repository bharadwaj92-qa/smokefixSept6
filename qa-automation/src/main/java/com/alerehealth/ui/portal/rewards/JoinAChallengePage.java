package com.alerehealth.ui.portal.rewards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.progress.challenges.AvailableChallengesPage;
import com.alerehealth.ui.portal.progress.challenges.ChallengesBasePage;

public class JoinAChallengePage extends PortalHomePage {
	
	@FindBy(xpath="//div[@class='card-content header-margin']//h3[contains(text(),'Join a challenge.')]")
	private WebElement titleJoinChallenge;
	

	@FindBy(xpath="//p[@class='moretext']")
	private WebElement contentJoinChallenge;
	
	
	@FindBy(xpath="//a[@class='btn btn--secondary pull-right']")
	private WebElement btnGetStarted;
	
	@Override
	public  boolean isDisplayed(){
		
		return titleJoinChallenge.isDisplayed();
	}
	
	
	public String getContentJoinChallenge(){
		
		waitForElementToBeDisplayed(contentJoinChallenge);
		
		
		return contentJoinChallenge.getText().trim();
	}
	
	public ChallengesBasePage clickGetStartedBtn(){
		
		waitForElementToBeDisplayed(btnGetStarted);
		
		btnGetStarted.click();
		
		return new ChallengesBasePage();
	}
	
	
	
	 
}
