package com.alerehealth.ui.portal.progress.challenges;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalBasePage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class ChallengesCompletedPage extends ChallengesBasePage{
	
	
	@FindBy(xpath="//*[@id='challenge_completed']/div/h2")
	private WebElement completedPageVerfication;
	
	
	@FindBy(xpath="//div[@id='challenge_completed']//p")
	private WebElement completedPageContentVerfication;
	
	
	public String getCompletedPageVerficationText()
	{
	
		return completedPageVerfication.getText();
	}
	
	public String getCompletedPageContentVerficationText()
	{
	
		return completedPageContentVerfication.getText();
	}

}
