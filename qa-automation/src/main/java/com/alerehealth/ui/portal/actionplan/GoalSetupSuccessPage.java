package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.coaching.WellnessPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoalSetupSuccessPage extends PortalHomePage{


    @FindBy(xpath = "//div[contains(@class,'hero-bg')]")
    private WebElement heroCardContainer;

    @FindBy(xpath = "//a[contains(text(),'Go to Action Plan')]")
    private WebElement gotoActionPlanLink;

    public ActionPlanBannerPage clickonGoToActionPlan(){

        gotoActionPlanLink.click();

        return new ActionPlanBannerPage();


    }
    
    public WellnessPage navigateCoachingToWellness(){
    	
    	 getMenuItemsUnderMenu("Coaching");
    	 openCoachingWellness();
    	 
    	return new WellnessPage();
    }
    

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(heroCardContainer);
        return heroCardContainer.isDisplayed();
    }
}
