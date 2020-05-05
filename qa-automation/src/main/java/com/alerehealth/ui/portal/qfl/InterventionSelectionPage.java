package com.alerehealth.ui.portal.qfl;

import com.alerehealth.fwk.selenium.common.SeleniumPage;

import com.alerehealth.ui.portal.common.pages.SignUpPage;
import org.openqa.selenium.By;

public class InterventionSelectionPage extends SeleniumPage<InterventionSelectionPage> {


    public SignUpPage chooseIntervention(QFLInterventions intervnetion){

       String xpath = "//*[@class='tile-header']/*[contains(text(),'"+intervnetion+"')]/ancestor::div[contains(@class,'tile-icon')]//a[contains(@href,'chooseIntervention')]";

        getWebDriver().findElement(By.xpath(xpath)).click();

        return new SignUpPage();
    }
    public ServiceSelectionPage chooseIndividualIntervention(QFLInterventions intervnetion){

        String xpath = "//*[@class='tile-header']/*[contains(text(),'"+intervnetion+"')]/ancestor::div[contains(@class,'tile-icon')]//a[contains(@href,'chooseIntervention')]";

        getWebDriver().findElement(By.xpath(xpath)).click();

        return new ServiceSelectionPage();
    }
    
    
   
    
    @Override
    public boolean isDisplayed() {
        return false;
    }
}
