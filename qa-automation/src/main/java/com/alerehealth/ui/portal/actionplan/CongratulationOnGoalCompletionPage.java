package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CongratulationOnGoalCompletionPage extends PortalHomePage {

    @FindBy(xpath ="//*[contains(@class,'card card--congratulations')]")
    private WebElement congratulationWinContainer;


    public boolean isDownloadCertificateButtonPresent(){

        String xpath = "//*[contains(@href,'downloadCert')]";

        try{

            getWebDriver().findElement(By.xpath(xpath));

            return true;

        }catch(NoSuchElementException nse){

            return false;

        }



    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(congratulationWinContainer);

        return congratulationWinContainer.isDisplayed();
    }
}
