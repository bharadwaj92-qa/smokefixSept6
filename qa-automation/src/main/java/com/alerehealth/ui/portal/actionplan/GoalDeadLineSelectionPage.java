package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoalDeadLineSelectionPage extends PortalHomePage{


    @FindBy(id="date-field")
    private WebElement achievementDateField;

    @FindBy(id="updateGoalBtn")
    private WebElement continueButton;

    @FindBy(xpath="//a[contains(@class,'btn--primary')]")
    private WebElement enrollmentCompletedButton;


    public GoalSetUpPage clickContinueButton(){

        continueButton.click();

        return new GoalSetUpPage();

    }

    public void setGoalAchievementDate(String achievementDate){

        achievementDateField.clear();

        achievementDateField.sendKeys(achievementDate);

    }

    public String getGoalAchievementDate(){

        String dateValue = achievementDateField.getAttribute("value");

        return dateValue;
    }

    public ActionPlanBannerPage clickContinueButtonToGoToBannerPage(){

        continueButton.click();

        return new ActionPlanBannerPage();

    }

    public void clickOnContinueButton(){

        continueButton.click();

    }

    public PortalHomePage clickEnrollmentCompletedButton(){

        enrollmentCompletedButton.click();
        return new PortalHomePage();
    }
    
 

    @Override
    public boolean isDisplayed() {
        return achievementDateField.isDisplayed();
    }
}
