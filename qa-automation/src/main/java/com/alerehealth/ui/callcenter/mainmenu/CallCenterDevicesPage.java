package com.alerehealth.ui.callcenter.mainmenu;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterDevicesPage extends CallCenterHomePage{

	@FindBy(xpath="//*[@class='buttonTdButton' and contains(text(),'Request Device Troubleshooting Call')]")
	public WebElement devicesRequestCallButton;
		
	@FindBy(id="f360g")
    public WebElement devicesTabFrame;

	@FindBy(xpath="(//*[@class='cursordefault titleBarLabelStyleExpanded' and contains(text(),'Devices')])[1]")
	public WebElement devicesHeaderTab;
	
	@FindBy(id="HeaderButtonIconsTDId")
    public WebElement devicesRefreshButton;
	
	@FindBy(xpath="(//*[contains(text(),'Reload')])[1]")
    public WebElement clickdevicesRefreshButton;
	
	public void clickDevicesTabRefreshButton(){
		
		javaScriptClick(clickdevicesRefreshButton);
		
	}
	
	public boolean collapseDevicesTitleBar(){
		
		expandOrCollapseSection("Device Troubleshooting History", "expand");
		
		return true;
	}
	
	
	
	public boolean isDisplayedDevicesTitleBarLabel(String className,String tabName){
		
		String devicesTabxpath = "//*[@class='"+className+"' and contains(text(),'"+tabName+"')]";
		WebElement devicesTitleBar = getWebDriver().findElement(By.xpath(devicesTabxpath));
		
		try {
			return devicesTitleBar.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
			
	}
	
	
    public boolean isDeviceRefreshButtonPresent() {

		try {
			return devicesRefreshButton.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
    
    public boolean isDeviceOptionPresent() {

		try {
			return devicesHeaderTab.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
    
    
	@Override
	public boolean isDisplayed() {
		getWebDriver().switchTo().defaultContent();
		switchToFrame(pegaGadgetFrame360Tab);
		switchToFrame(devicesTabFrame);
		waitForElementToBeDisplayed(devicesRequestCallButton);
		return devicesRequestCallButton.isDisplayed();

	}
	
}
