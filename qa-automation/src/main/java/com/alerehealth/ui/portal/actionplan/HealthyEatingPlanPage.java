package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HealthyEatingPlanPage extends PortalHomePage{

    @FindBy(name ="dailyCaloriesMealPlanData.heightInches")
    private WebElement heightInInchesTextField;

    @FindBy(id = "mealPlanStandard")
    private WebElement selectMealPlanRdioButton;

    @FindBy(xpath ="//*[contains(@class,'button btn-primary')]")
    private WebElement continueButton;


    public void selectMealPlan(String mealPlan){


        switch (mealPlan.toUpperCase()){

            case "STANDARD": {

                selectMealPlanRdioButton.click();

                break;
            }


        }


    }


    public void clickContinueButton(){
        String xpath = "//*[contains(@class,'button btn-primary')]";

        getWebDriver().findElement(By.xpath(xpath)).click();


    }

    public GoalSetUpPage clickOnContinueButton(){

        clickContinueButton();

        return new GoalSetUpPage();

    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(heightInInchesTextField);
        return heightInInchesTextField.isDisplayed();
    }
}
