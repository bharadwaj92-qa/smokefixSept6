package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.settings.TermsOfUsePage;

public class PrintableTermsOfUsePage extends SeleniumPage<PrintableTermsOfUsePage>{
	
	
	public void closeTermsOfUsePrintWindow(){

		getWebDriver().close();

	}

	
	@FindBy(xpath ="//a[contains(@href,'touprivacy')]")
    private WebElement privacyPolicyLink;

    @FindBy(className = "has-bullets")
    private WebElement text2QuitBulletpoints;

    @FindBy(id="table-grid")
    private WebElement supportedCarriesTable;

    @Override
    public boolean isDisplayed() {

    	waitForElementToBeDisplayed(privacyPolicyLink);
    	
        return privacyPolicyLink.isDisplayed();
    }

    public boolean isBulletsSectionDisplayed(){

        try{

            return text2QuitBulletpoints.isDisplayed();
        }catch (NoSuchElementException nse){

            return false;
        }

    }

    public boolean isSupportedCarriersSectionDisplayed(){

        try{

            return supportedCarriesTable.isDisplayed();
        }catch (NoSuchElementException nse){

            return false;
        }

    }
    
    
    

}
