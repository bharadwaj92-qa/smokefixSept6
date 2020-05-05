package com.alerehealth.ui.portal.progress.challenges;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class ChallengesBasePage extends PortalHomePage {

    @FindBy(xpath = "//*[@title='Home']")
    private WebElement navigateToHomepage;

    @FindBy(xpath = "//*[@class='ogn__title__left']/h1")
    private WebElement welcomeMsgChallenges;

    @FindBy(partialLinkText = "Available")
    private WebElement availableLink;

    @FindBy(partialLinkText = "Completed")
    private WebElement completedLink;

    @FindBy(partialLinkText = "Missed")
    private WebElement missedLink;

    @FindBy(partialLinkText = "Upcoming")
    private WebElement upcomingLink;


    public AvailableChallengesPage navigateToAvailablePage() {
    	
        availableLink.click();

        return new AvailableChallengesPage();

    }

    public MissedChallengesPage navigateToMissedPage() {
        missedLink.click();

        return new MissedChallengesPage();
    }

    public UpcomingChallengesPage navigateToUpcomingPage() {

        upcomingLink.click();

        return new UpcomingChallengesPage();
    }


    public ChallengesCompletedPage navigateToCompletedPage() {
        completedLink.click();
        return new ChallengesCompletedPage();
    }

    public String getChallengesPageVerficationText() {
        return welcomeMsgChallenges.getText();
    }
    
    
    //Added code
    
    public List<String> isChallengesNavigationBarDisplayed(){
    	
    	String xpath = "//div[@class='filter-wrapper ']//li//a";
    	
    	List<String> challengesDisplayed = new ArrayList<String>();
    	
    	List<WebElement>  sideNavigation = getWebDriver().findElements(By.xpath(xpath));
    	
    	sideNavigation.forEach(challenges -> challengesDisplayed.add(challenges.getText().trim()));
    	
    	System.out.println(challengesDisplayed);

    	return challengesDisplayed;
   
    }
    
    
    
    public boolean isDisplayed(){
    	
    	waitForElementToBeDisplayed(welcomeMsgChallenges);
    	return  welcomeMsgChallenges.isDisplayed();
    }
    
	

}
