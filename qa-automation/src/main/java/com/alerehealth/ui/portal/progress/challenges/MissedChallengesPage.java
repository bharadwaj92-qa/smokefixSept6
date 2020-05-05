package com.alerehealth.ui.portal.progress.challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MissedChallengesPage extends ChallengesBasePage {


	@FindBy(xpath="//ul[@class='tabs']//a[text()='Missed' and contains(@class,'icon_checkmark')]")
	private WebElement missedLinkHighlighted;


	@Override
	public boolean isDisplayed() {
		return missedLinkHighlighted.isDisplayed();
	}


	public List<String> getMissedChallengesTitles(){

		List<String> missedChallenges = new ArrayList<String>();

		String xpath = "//*[@id='challenge_missed']/div[@class='media-object']//*[@class='cs-heading']";

		List<WebElement> missedChallengesElemetns = getWebDriver().findElements(By.xpath(xpath));

		for(WebElement missedChallenge : missedChallengesElemetns){

			missedChallenges.add(missedChallenge.getText().trim());

		}

		return missedChallenges;
	}



}
