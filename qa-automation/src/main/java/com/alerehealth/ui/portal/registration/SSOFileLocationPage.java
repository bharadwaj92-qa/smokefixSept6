package com.alerehealth.ui.portal.registration;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.selenium.common.SeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SSOFileLocationPage extends SeleniumPage<SSOFileLocationPage> {

    @FindBy(xpath="//div[contains(@class,'well-sm')]")
    private WebElement clientContainer;

    public SSOFileLocationPage(){

        String url = Configuration.getConfiguration().getSso_file_url();
        LoggerUtils.info("Navigating to URL :"+ url);
        getWebDriver().get(url);
        initPage();

    }

    public SSORegistrationPage launchClientPage(String client, String fileName){

        String mainWinHandle =  getWebDriver().getWindowHandle();

        String xpath = "(//div[@class='col-sm-2' and text()='"+client+"']/../following-sibling::div[@class='row'])[1]";

        WebElement linksContainer = getWebDriver().findElement(By.xpath(xpath));

        linksContainer.findElement(By.xpath(".//a[text()='"+fileName+"']")).click();

        waitForNewWindowToOpen(1);

        switchToNewWindow(mainWinHandle);

        return new SSORegistrationPage();

    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(clientContainer);

        return clientContainer.isDisplayed();
    }
}
