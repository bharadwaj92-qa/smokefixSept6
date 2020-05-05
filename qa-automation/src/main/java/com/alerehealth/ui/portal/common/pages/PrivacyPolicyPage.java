package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.settings.TermsOfUsePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPolicyPage extends SeleniumPage {

    @FindBy( xpath="//*[@class='ogn__title__left']/*")
    public WebElement privacyheadertext;

    @FindBy(xpath="//div[@class= 'ogn__title__left']//following-sibling::h1")
    private WebElement  txtPrivacyPolicyTitle;


    public String  getTitleOfPrivacyPolicyPage(){
        return privacyheadertext.getText().trim();
    }


    public String getClientNameOptumHolderPara (String clientName)

    {
        String xpath = (clientName.toLowerCase().equals("Optum")) ? "//p[6]" : "//p[5]";

        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

        String paraContent = clientParagraph.getText().trim();

        System.out.println(paraContent);

        return paraContent;

    }
    
    
    public String getClientNamePronouncedHealthHolderPara (String clientName)

    {
        String xpath = (clientName.toLowerCase().equals("PronouncedHealth")) ? "//p[6]" : "//p[5]";

        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

        String paraContent = clientParagraph.getText().trim();

        System.out.println(paraContent);

        return paraContent;

    }
    
    public String getClientNameUnitedHealthHolderPara (String clientName)

    {
        String xpath = (clientName.toLowerCase().equals("unitedhealthcare")) ? "//p[6]" : "//p[5]";

        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

        String paraContent = clientParagraph.getText().trim();

        System.out.println(paraContent);

        return paraContent;

    }
    
    

    @Override
    public boolean isDisplayed() {
        waitForElementToBeDisplayed(privacyheadertext);
        return privacyheadertext.isDisplayed();
    }

    public String getTitle(){

        waitForElementToBeDisplayed(txtPrivacyPolicyTitle);

        String title = txtPrivacyPolicyTitle.getText().trim();

        return title;
    }

    public void closePrivacyPolicyWindow(){

        getWebDriver().close();

    }
    
   
    public TermsOfUsePage clickFooterTerms(){
    	
        String xpath = "//div[@class ='legal-bar']//a[contains(text(), 'Terms')]";
	     
	     WebElement element = getWebDriver().findElement(By.xpath(xpath));
	     
	     element.click();
	     
	     waitForSpecifiedTime(3);
    	
    	return new TermsOfUsePage();
    }


}