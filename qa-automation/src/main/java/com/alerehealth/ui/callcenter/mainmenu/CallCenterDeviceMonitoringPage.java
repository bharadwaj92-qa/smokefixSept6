package com.alerehealth.ui.callcenter.mainmenu;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterDeviceMonitoringPage extends CallCenterHomePage {

    @FindBy(xpath = "//*[contains(text(),'First Device Transmission:')]")
    private WebElement deviceTransmissionPage;
    
    @FindBy(id="f360j")
    protected WebElement deviceMonitoringIframe;
    
    @FindBy(id = "chart__1")
    private WebElement deviceTransmissionGraph;

    @FindBy(id = "measurementStatus")
    private WebElement deviceTransmissionStatusOption;
    
    @FindBy(id = "PeriodFilter")
    private WebElement deviceTransmissionRangeOption;
        
    @FindBy(id = "filterSubmitButtonID")
    private WebElement deviceTransmissionFilterOption;
    
  
    public List<String> deviceTransmissionStatusList(){
    	
    	String xpath = "measurementStatus";
    	WebElement selectElement = getWebDriver().findElement(By.id(xpath));

    	List<String> options = new ArrayList<String>(); 
    	
        Select selectBox = new Select(selectElement);

        List<WebElement> StatusOptions = selectBox.getOptions();
        
        StatusOptions.forEach( option -> options.add(option.getText().trim()));

		return options;
        
    }
    
    public List<String> deviceTransmissionRangeList(){
    	
    	String xpath = "PeriodFilter";
    	WebElement selectElement = getWebDriver().findElement(By.id(xpath));

    	List<String> options = new ArrayList<String>(); 
    	
        Select selectBox = new Select(selectElement);

        List<WebElement> StatusOptions = selectBox.getOptions();
        
        StatusOptions.forEach( option -> options.add(option.getText().trim()));

		return options;
        
    }
    
    
    public boolean isDeviceTransmissionFilterOptionPresent() {

		try {
			return deviceTransmissionFilterOption.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
    
    public boolean isDeviceTransmissionStatusOptionPresent() {

		try {
			return deviceTransmissionStatusOption.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
    
    public boolean isDeviceTransmissionRangeOptionPresent() {

		try {
			return deviceTransmissionRangeOption.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
    
    public String  getTitleOfDeviceTransmission(){
    	
        return deviceTransmissionPage.getText().trim();
    }
    
    public boolean isDeviceTransmissionGraphPresent() {

		try {
			return deviceTransmissionGraph.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
	
	
	@Override
	public boolean isDisplayed() {
		getWebDriver().switchTo().defaultContent();
		switchToFrame(pegaGadgetFrame360Tab);
		switchToFrame(deviceMonitoringIframe);
		waitForElementToBeDisplayed(deviceTransmissionPage);
		return deviceTransmissionPage.isDisplayed();

	}
    
}
