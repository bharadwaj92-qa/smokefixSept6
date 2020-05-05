package com.alerehealth.ui.callcenter.mainmenu;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterSummaryPage extends CallCenterHomePage {
	
	@FindBy(xpath = "//*[contains(text(),'Participant Summary Dashboard')]")
	private WebElement participantSummaryDashboard360Tab;
	
    @FindBy(id="f360ms")
    protected WebElement SummaryPageIframe;
		
		public boolean summaryDashboard(String rulekey) {

		String memberSummaryXpath =	"(//*[@class='Leader_Link_Small' and text()='"+rulekey+"']/ancestor::div[contains(@class,'layout-content-stacked')])[last()]";
		
		WebElement elementMenu = getWebDriver().findElement(By.xpath(memberSummaryXpath));
		
		try {
			return elementMenu.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
				
		}

		
	@Override
	public boolean isDisplayed() {

		getWebDriver().switchTo().defaultContent();
		switchToFrame(pegaGadgetFrame360Tab);
		switchToFrame(SummaryPageIframe);
		waitForElementToBeDisplayed(participantSummaryDashboard360Tab);
		
		return participantSummaryDashboard360Tab.isDisplayed();
	}
}
		

