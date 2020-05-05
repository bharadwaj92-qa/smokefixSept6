package com.alerehealth.ui.callcenter.mainmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterUtilizationPage extends CallCenterHomePage{

	@FindBy(xpath="//*[contains(@title,'Add Provider') and contains(@class,'buttonTdButton')]")
	public WebElement provider;
	
	@FindBy(id="PegaGadget0Ifr")
    public WebElement Pega360PageIframe;
	
	@FindBy(xpath="//*[@id='Cont_Refresh All']")
	public WebElement utilizationPage;
	
	
	@FindBy(id="f360e")
    public WebElement utilizationTabFrame;
	
	public void providerClick() throws InterruptedException{
		Thread.sleep(2000);
		javaScriptClick(provider);
	} 
	
	
	@Override
	public boolean isDisplayed() {
		getWebDriver().switchTo().defaultContent();
		switchToFrame(pegaGadgetFrame360Tab);
		switchToFrame(utilizationTabFrame);
		waitForElementToBeDisplayed(utilizationPage);
		return utilizationPage.isDisplayed();

	}
}
