package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ActionPlanQuestionnaireStartingPage extends PortalHomePage {

    @FindAll({
            @FindBy(xpath = "//a[contains(@href,'chooseAssessment')]"),
            @FindBy(xpath = "//a[@href='/mve/healthcoach/miniAssessment']")
    })
    private WebElement startActionPlanButton;


    public ActionPlanQuestionnairePage startActionPlan(){

        startActionPlanButton.click();

        return new ActionPlanQuestionnairePage();
    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(startActionPlanButton);

        return startActionPlanButton.isDisplayed();
    }
}
