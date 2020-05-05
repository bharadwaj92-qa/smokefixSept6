package com.alerehealth.ui.portal.actionplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class ActionPlanSetYourGoal extends PortalHomePage {

	@FindBy(xpath = "//div[contains(@class,'bts-container')]")
	private WebElement fixedListContainer;

	@FindBy(id = "updateGoalBtn")
	private WebElement continueButton;

	public void selectGoal(String goal){

		String xpath = "//div[@class='bts__items']//label[text()='"+goal+"']";

		getWebDriver().findElement(By.xpath(xpath)).click();
	}


	public GoalDeadLineSelectionPage clickContinueButton(){

		continueButton.click();

		return new GoalDeadLineSelectionPage();
	}

	public HealthyEatingPlanPage proceedToHealthyEatingPlan(){

		continueButton.click();

		return new HealthyEatingPlanPage();
	}

	@Override
	public boolean isDisplayed() {
		waitForElementToBeDisplayed(fixedListContainer);
		return fixedListContainer.isDisplayed();
	}

}
