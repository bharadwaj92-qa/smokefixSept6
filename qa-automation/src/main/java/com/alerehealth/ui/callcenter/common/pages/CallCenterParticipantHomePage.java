package com.alerehealth.ui.callcenter.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterClientPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterDeviceMonitoringPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterDevicesPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterEducationAndGoalsTab;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterGapHistoryPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterInteractionsPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterMedicationsPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterSummaryPage;

public class CallCenterParticipantHomePage extends CallCenterHomePage{
		
	@FindBy(id="headerCloseCall")
    public WebElement closeParticipant;
	
	@FindBy(id="PegaGadget0Ifr")
    public WebElement Pega360PageIframe;

	@FindBy(xpath="//td[@class='p360bar']//li/div[@title='Summary' and @class='summary360b']")
	public WebElement summaryTab;
	
	public void select360tab(String tabName){
		
		String xpath = "//td[@class='p360bar']//li/div[@title='"+tabName+"']";
		WebElement pega360Tab = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(pega360Tab);
		//pega360Tab.click();
		javaScriptClick(pega360Tab);
//		LoggerUtils.info("Clicked on the "+tabName+" tab from 360Tabs");
	}
	
	
	//Added
	public CallCenterGapHistoryPage selectGapHistory(){
        
		select360tab("Gap History");
        
        return new CallCenterGapHistoryPage();
        
	}
	
  public CallCenterInteractionsPage selectInteractionsTab(){
        
		select360tab("Interactions");
        
        return new CallCenterInteractionsPage();
        
	}
	
    public CallCenterEducationAndGoalsTab selectEducationAndGoals(){
        
		select360tab("Education and Goals");
        
        return new CallCenterEducationAndGoalsTab();
        
	}


	
	public CallCenterDeviceMonitoringPage selectDeviceMonitoring(String tabName){
		
		select360tab(tabName);
		return new CallCenterDeviceMonitoringPage();
	} 
	
	public CallCenterClientPage selectClientTab(){
		
		select360tab("Client");
		return new CallCenterClientPage();
	} 
	
	public CallCenterMedicationsPage selectMedicationsTab(String tabName){
		
		select360tab(tabName);
		return new CallCenterMedicationsPage();
	} 
	
	public CallCenterDevicesPage selectDevicesTab(String tabName){
		
		select360tab(tabName);
		return new CallCenterDevicesPage();
	} 
	
	public CallCenterSummaryPage selectSummaryTab(String tabName){
		
		select360tab(tabName);
		return new CallCenterSummaryPage();
	}
	
	
	
	@Override
    public boolean isDisplayed() {
		getWebDriver().switchTo().defaultContent();
		switchToFrame(Pega360PageIframe);
        waitForElementToBeDisplayed(summaryTab);
        return summaryTab.isDisplayed();

    }
	
}
