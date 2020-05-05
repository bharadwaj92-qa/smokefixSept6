package com.alerehealth.ui.portal.settings;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactInfoPage extends SettingsBasePage{


    @FindBy(xpath="//*[@class='module contact-info']")
    private WebElement contactinfoContainer;



    @FindBy(xpath="//h5[@class='header' and contains(text(),'Name')]//following-sibling::p")
    private WebElement ContatcName;


    public String getFieldValue(String fieldLabel){

        String xpath = ".//*[@class='header' and contains(text(),'"+fieldLabel+"')]//following-sibling::p";

        String fieldValue = "";

        List<WebElement> labelValues =  contactinfoContainer.findElements(By.xpath(xpath));

        for(WebElement labelValue : labelValues){

            fieldValue+=(labelValue.getText().trim());

        }

        return fieldValue;
    }


    @Override
    public boolean isDisplayed() {

        return contactinfoContainer.isDisplayed();
    }
}
