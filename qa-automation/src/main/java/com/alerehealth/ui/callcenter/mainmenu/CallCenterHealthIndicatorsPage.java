package com.alerehealth.ui.callcenter.mainmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterHealthIndicatorsPage extends CallCenterHomePage{

	@FindBy(xpath="//*[contains(text(),'BMI')]")
	public WebElement healthIndicatorBMI;
	
	@FindBy(id = "PegaGadget0Ifr")
	protected WebElement pegaGadgetFrame360Tab;
	
	@FindBy(id="f360f")
    public WebElement healthIndicatorsTabFrame;
	
	@FindBy(id="HDSummarySectionID")
    public WebElement healthindicatorsPage;
	
	public void clickHealthIndicatorBMI() throws InterruptedException{
		
		Thread.sleep(2000);
		javaScriptClick(healthIndicatorBMI);
	}
	
	@Override
	public boolean isDisplayed() {
		getWebDriver().switchTo().defaultContent();
		switchToFrame(pegaGadgetFrame360Tab);
		switchToFrame(healthIndicatorsTabFrame);
		waitForElementToBeDisplayed(healthindicatorsPage);
		return healthindicatorsPage.isDisplayed();

	}
}
