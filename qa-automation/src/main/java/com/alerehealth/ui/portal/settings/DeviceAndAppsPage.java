package com.alerehealth.ui.portal.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DeviceAndAppsPage extends SettingsBasePage{


    @FindBy(id="adddevices_0")
    private WebElement addDevices;


    @FindBy(partialLinkText = "Terms of Use")
    private WebElement termsOfUseLink;

    @FindBy(partialLinkText = "Privacy Policy")
    private WebElement privacyPolicyLink;

    @FindBy(xpath="//*[@class='card-header']")
    private WebElement learnMoreLink;

    @FindBy(xpath = "//*[contains(@class,'card--help')]")
    private WebElement contentContainer;



    private String devicesAndAppWindowHandle;


    public boolean isTermsOfUseLinkPresent(){

        return termsOfUseLink.isDisplayed();
    }

    public boolean isprivacyPolicyLinkPresent(){

        return privacyPolicyLink.isDisplayed();
    }

    private void clickLearnMore(){

        learnMoreLink.click();
    }

    public void expandByClickingLearnMore(){

        String expansion = contentContainer.getAttribute("aria-expanded");

        boolean isExpanded = (expansion.trim().contains("true"))? true: false;

        if(!isExpanded){

            clickLearnMore();

        }

    }

    public void collapseByClickingLearnMore(){

        String expansion = contentContainer.getAttribute("aria-expanded");

        boolean isExpanded = (expansion.trim().contains("true"))? true: false;

        if(isExpanded){

            clickLearnMore();

        }

    }

    public String getDisclaimerTextFromLearnMore(){

        WebElement contentEle = contentContainer.findElement(By.tagName("p"));
        String content = contentEle.getText();

        return content;
    }


    public void clickAddDevices(){

        String windowHandle = getWebDriver().getWindowHandle();

        setDevicesAndAppWindowHandle(windowHandle);

        addDevices.click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(windowHandle);


    }

    public void closeAddDevicesWindow(){

        Set<String> windowHandles = getWebDriver().getWindowHandles();

        for(String window: windowHandles){

            if(window.equals(getDevicesAndAppWindowHandle())){

//                getWebDriver().switchTo().window(window);

                getWebDriver().close();

            }

        }

        getWebDriver().switchTo().window(getDevicesAndAppWindowHandle());

    }


    public List<String> getDevicesFromAddNewDeviceWindow(){

        List<String> devicesList = new ArrayList<String>();

        List<WebElement> devicesHeaders = getWebDriver().findElements(By.xpath("//*[@class='row main']//div[@class='modal-header']//h3"));

        for(WebElement deviceHeader : devicesHeaders){

           String deviceName =  deviceHeader.getText().trim();

           devicesList.add(deviceName);

        }
        return devicesList;
    }

    public String getDevicesAndAppWindowHandle() {
        return devicesAndAppWindowHandle;
    }

    public void setDevicesAndAppWindowHandle(String devicesAndAppWindowHandle) {
        this.devicesAndAppWindowHandle = devicesAndAppWindowHandle;
    }

    @Override
    public boolean isDisplayed() {

        return addDevices.isDisplayed();
    }
}
