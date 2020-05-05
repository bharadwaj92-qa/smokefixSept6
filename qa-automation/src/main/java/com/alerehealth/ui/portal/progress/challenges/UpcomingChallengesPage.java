package com.alerehealth.ui.portal.progress.challenges;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpcomingChallengesPage extends ChallengesBasePage {
	

	@FindBy(xpath="//ul[@class='tabs']//a[text()='Upcoming' and contains(@class,'icon_checkmark')]")
	private WebElement upcomingLinkHighlighted;


	@Override
	public boolean isDisplayed() {
		return upcomingLinkHighlighted.isDisplayed();
	}
	
	
	public List<String> getUpcomingChallengesTitlesOld(){
		
		String xpath = " //div[@id='challenge_upcoming']//h2";
		WebElement ele = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(ele);
		String headingText = ele.getText().trim();
		System.out.println(headingText);
		
		List<String> upcomingChallenges = new ArrayList<String>();
		
		if(!(ele.isDisplayed())) {
		
			String xpath1 = "//*[@id='challenge_upcoming']/div[@class='media-object']//*[@class='cs-heading']";

			List<WebElement> upcomingChallengesElemetns = getWebDriver().findElements(By.xpath(xpath1));

			for(WebElement upcomingChallenge : upcomingChallengesElemetns){

				upcomingChallenges.add(upcomingChallenge.getText().trim());
			}	
		}
		
		System.out.println("Upcoming challenges" + upcomingChallenges);
		return upcomingChallenges;
	}
	
	
	
   public List<String> getUpcomingChallengesTitles(){
	
		List<String> upcomingChallenges = new ArrayList<String>();
		
			String xpath1 = "//*[@id='challenge_upcoming']/div[@class='media-object']//*[@class='cs-heading']";

			List<WebElement> upcomingChallengesElemetns = getWebDriver().findElements(By.xpath(xpath1));

			for(WebElement upcomingChallenge : upcomingChallengesElemetns){

				upcomingChallenges.add(upcomingChallenge.getText().trim());
			}	
	
		   int upcomingChallengesSize = upcomingChallenges.size();
		   
		   if(upcomingChallengesSize==0){
			   
			   String xpath = " //div[@id='challenge_upcoming']//h2";
				WebElement ele = getWebDriver().findElement(By.xpath(xpath));
				waitForElementToBeDisplayed(ele);
				String headingText = ele.getText().trim();
				System.out.println(headingText);
			   
		   }
		   
		   else {
			  
			   System.out.println("Displayed Upcoming challenges are:" + upcomingChallenges);
		   }
		
		
		return upcomingChallenges;
	}
		
  }		
	

