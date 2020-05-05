package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.selenium.common.SeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MarketingPage extends SeleniumPage<MarketingPage> {

    @FindBy(className ="dpl-hero-container")
    private WebElement adContainer;

    @FindBy(xpath= "//button[@class='button btn-primary btn-alternate icon-right caret_next']")
    private WebElement getStartedNowButton;

    @FindBy(id="focusTabs")
    private WebElement focusAreasContainer;

    @FindBy(xpath="//li[contains(@class,'ogn-header-link-list')]//a[@href='startRegistration']")
    private WebElement signUpLink;

    @FindBy(xpath="//div[@class='legal-bar']//a")
    private List<WebElement> footerLink;

    @FindBy(xpath= "//a[contains(@class,'logo') and contains(@class,'header')]")
    protected WebElement clientLogo;

    @FindBy(xpath="//*[@class='ogn__header-site-title']")
    private WebElement marketingPageTitle;

    @FindBy(xpath="//li[contains(@class,'ogn-header-link-list')]//a[@href='login']")
    private WebElement loginLink;

    public MarketingPage(){


        String url =  ClientConfiguration.getClientConfiguration().getClientURL();//Configuration.getConfiguration().getPortal_url();

        url = url.replace("login","");


        LoggerUtils.info("Navigating to URL :"+ url);

        getWebDriver().get(url);


        initPage();


    }

    public String getFocusAreaContent(){

        String xpath = "//*[@id='focusTabsContent']//*[@class='tab-pane active']//div[@class='featured-content']//p";

        WebElement webElement = getWebDriver().findElement(By.xpath(xpath));

        String focusAreaContent = webElement.getText().trim();

        return focusAreaContent;
    }

    public String getFocusedAreaTitleInContentSection(){

        String xpath = "//*[@id='focusTabsContent']//*[@class='tab-pane active']//div[@class='featured-content']//h3";

        WebElement webElement = getWebDriver().findElement(By.xpath(xpath));

        String focusAreaContent = webElement.getText().trim();

        return focusAreaContent;

    }

    public List<String> getFocusAreas(){

        List<String> focusAreas  = new ArrayList<String>();

        List<WebElement> tabs = getFocusAreaElements();

        for(WebElement tab: tabs){

            String text = tab.getText().replaceAll("\\r\\n|\\r|\\n", " ").trim();

            focusAreas.add(text);

        }

        return focusAreas;
    }
    
    
    
    public SignUpPage clickGetStartedFocusArea(){
    	
    	String xpath = "//*[@id='focusTabsContent']//*[@class='tab-pane active']//div[@class='featured-content']//button";
    	
    	WebElement getStartedBtn = getWebDriver().findElement(By.xpath(xpath));
    	
    	javaScriptClick(getStartedBtn);
    	return new SignUpPage();
    }

    public SignUpPage clickGetStarted(){

        WebElement getStartedButton = adContainer.findElement(By.tagName("button"));
        
        javaScriptClick(getStartedButton);

        return new SignUpPage();
    }
    
    
    public boolean isGetStartedButtonDisplayed(){
    	
    	  WebElement getStartedButton = adContainer.findElement(By.tagName("button"));
    	  
    	  return getStartedButton.isDisplayed();
    	
    }

    public SignUpPage clickSignUp(){

        signUpLink.click();

        return new SignUpPage();
    }


    public void clickFocusArea(String focusArea){

        List<WebElement> tabs = getFocusAreaElements();


        for(WebElement tab: tabs){

            String text = tab.getText().trim();

            if(text.contains(focusArea)){

                tab.click();

                break;
            }

        }

    }

    private List<WebElement> getFocusAreaElements(){

        String xpath = "//div[@class='desktop']//ul[@id='focusTabs']//following-sibling::a";

        List<WebElement> tabs = getWebDriver().findElements(By.xpath(xpath));

        return tabs;
    }


    public SignUpPage clickGetStartedOfSection(String section){

        String classOfContainer = "";


        if(section.contains("Hero")){

            classOfContainer = "dpl-hero";

        }else if(section.contains("How This Works"))
        {

            classOfContainer = "how-it-works";

        }else if(section.contains("Do More")){

            classOfContainer = "do-more";

        }else{

            classOfContainer = "tab-pane active";

        }


        String xpath = "//*[contains(@class,'"+classOfContainer+"')]//button[text()='Get Started Now']";

        getWebDriver().findElement(By.xpath(xpath)).click();

        return new SignUpPage();

    }
    
    
    public boolean isGetStartedButtonDisplayed(String section){
    	
    	String classOfContainer = "";


        if(section.contains("Hero")){

            classOfContainer = "dpl-hero";

        }else if(section.contains("How This Works"))
        {

            classOfContainer = "how-it-works";

        }else if(section.contains("Do More")){

            classOfContainer = "do-more";

        }else{

            classOfContainer = "tab-pane active";

        }


        String xpath = "//*[contains(@class,'"+classOfContainer+"')]//button[text()='Get Started Now']";
        
        WebElement btnEle = getWebDriver().findElement(By.xpath(xpath));
        
        return btnEle.isDisplayed();
        
    }

    public List<String> getHeaderLinks(){

        List<String> headerLinksText = new ArrayList<String>();

        List<WebElement> headerLinks = getHeaderLinkElements();

        for(WebElement headerLink: headerLinks){

            headerLinksText.add(headerLink.getText().trim());

        }

        return headerLinksText;

    }

    private List<WebElement> getHeaderLinkElements(){


        String xpath = "//ul[@class='ogn__header-link-list dropdown']//a";

        List<WebElement> headerLinks = getWebDriver().findElements(By.xpath(xpath));

        return headerLinks;

    }

    public List<String> getFooterLinks(){

        List<String> footerLinks = new ArrayList<String>();

        String footerLinksXpath = "//div[@class='legal-bar']//a";

        List<WebElement> footerLinksEle = getWebDriver().findElements(By.xpath(footerLinksXpath));

        footerLinksEle.forEach(footerLinkEle -> footerLinks.add(footerLinkEle.getText().trim()));

        return footerLinks;

    }

    public SignUpPage clickOnSignUpLink(){

        clickHeaderLink("Help");

        return new SignUpPage();
    }
    
    
    public void clickOnLanguageLink(String lang){
    	
    	clickHeaderLink(lang);
    	
    }
    
    
    public boolean isHeaderLinkDisplayed(String link){
    	
    	 String xpath = "//ul[@class='ogn__header-link-list dropdown']//a[contains(text(),'"+link+"')]";
    	 WebElement linkEle = getWebDriver().findElement(By.xpath(xpath));
    	 
    	return linkEle.isDisplayed();
    }

    public CommonHelpPage clickOnHelpLink(){

        clickHeaderLink("Help");

        return new CommonHelpPage();
    }

    public String getMarketingPageHeaderTitle(){

        return marketingPageTitle.getText().trim();
    }

    public boolean isClientLogoDisplayed() {

        return clientLogo.isDisplayed();
    }
    
    public PortalLoginPage clickClientLogo(){
    	
    	javaScriptClick(clientLogo);
    	
    	return new PortalLoginPage();
    }

    public void clickHeaderLink(String link){

        String xpath = "//ul[@class='ogn__header-link-list dropdown']//a[contains(text(),'"+link+"')]";

        getWebDriver().findElement(By.xpath(xpath)).click();

    }

    public SignUpPage clickGetStartedButton(){

        getStartedNowButton.click();

        return new SignUpPage();

    }

    public PortalLoginPage clickLoginLink(){

        loginLink.click();

        return new PortalLoginPage();
    }
    
    
    public String getZone1Content(){
    	
    	String xpath = "//div[@class='dpl-hero-container']//following-sibling::h2";
    	WebElement content = getWebDriver().findElement(By.xpath(xpath));
    	return content.getText().trim() ;
    }
    
    public boolean isDoMoreSectionDisplayed(){
    	
         String xpath="//h1[contains(text(),'Do More. Achieve More!')]";
         WebElement headingEle = getWebDriver().findElement(By.xpath(xpath));
         
         return headingEle.isDisplayed();
    }
    
    
    public List<String> getDoMoreContentTitle(){
    	
     String xpath = "//div[@class='container do-more']//following-sibling::h5[@class='header']"; 
    	
    	List<WebElement> titleEle = getWebDriver().findElements( By.xpath(xpath));
    	
    	List<String> titlesDoMoreSection = new ArrayList<String>();
    	    	
    	titleEle.forEach(title -> titlesDoMoreSection.add(title.getText().trim()));

    	return titlesDoMoreSection;
    }
    
    /*
     * Specify the title value as Track progress, health library, personal message center,fitness device
     */
    
    
    public String getDoMoreContent(String title){
    	
    	String xpath = "//div[@class='container do-more']//following-sibling::h5[contains(text(),'"+title+"')]//following-sibling::p";
    	WebElement titleEle = getWebDriver().findElement( By.xpath(xpath));
    	
    	return titleEle.getText().trim();
    }
    
    
    
    
    public void clickHowThisWorkSectionLink(String link){
 
    	String value="";
    	link = link.toUpperCase();
    	switch(link){
    	
    	case "FOCUSAREA" :  value = "focus area";
    	                    break;
    	case "HEALTHCOACH" :  value = "health coach";
                            break;
        
    	case "ACTIONPLAN" :  value = "action plan";
                             break;
    	                    
    	}
 
    	String xpath="//a[@class='btn links question' and contains(text(),'"+value+"')]";
    	WebElement linkEle = getWebDriver().findElement(By.xpath(xpath));
    	javaScriptClick(linkEle);
    }
    

    
    public String getHowThisWorkContent(String link){
    	
    	
    	String value="";
    	link = link.toUpperCase();
    	switch(link){
    	
    	case "FOCUSAREA" :  value = "tileDescription1";
    	                    break;
    	case "HEALTHCOACH" :  value = "tileDescription2";
                            break;
        
    	case "ACTIONPLAN" :  value = "tileDescription3";
                             break;
    	                    
    	}
    	
    	String xpath = "//div[@id='"+value+"']//following-sibling::p";
    	WebElement contentEle = getWebDriver().findElement(By.xpath(xpath));
    	
    	return contentEle.getText().trim();
    }


    @Override
    public boolean isDisplayed() {
        return adContainer.isDisplayed();
    }



}
