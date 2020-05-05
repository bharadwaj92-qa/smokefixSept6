package com.alerehealth.ui.portal.settings;

import com.alerehealth.fwk.common.Constants;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.sun.corba.se.pept.transport.ContactInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SettingsBasePage extends PortalHomePage {


    @FindBy(xpath = "//*[contains(@class,'nav--architecture-set')]")
    protected WebElement leftNavigationMenuContainer;

    @FindBy(id="breadcrumblist")
    protected WebElement breadCrumbContainer;

    @FindBy(xpath = "//*[contains(@class,'col-md-9 col-sm-8 typography')]")
    protected WebElement profileContainer;

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(leftNavigationMenuContainer);

        return leftNavigationMenuContainer.isDisplayed();
    }


    public List<String> getLeftNavigationMenuLinks(){

        List<String> leftNavigationLinks = new ArrayList<String>();

        List<WebElement> navigationLinks = leftNavigationMenuContainer.findElements(By.tagName("a"));

        for(WebElement navigationLink: navigationLinks){

            leftNavigationLinks.add(navigationLink.getText().trim());

        }

        return leftNavigationLinks;
    }

    public String getNavigationFromBreadCrumb(){

        String completeNavigation = "";
        List<WebElement> navigationList =  breadCrumbContainer.findElements(By.tagName("li"));

        int counter = 0;
        for(WebElement navigation : navigationList){

            String temp = navigation.getText().trim();

            if(temp.isEmpty()){

                WebElement atag = navigation.findElement(By.tagName("a"));

                completeNavigation +=(atag.getText().trim());

            }else{

                completeNavigation+=temp;
            }

            if(counter<=navigationList.size()-1){

                completeNavigation+=">";

                counter++;

            }

        }

        return completeNavigation;
    }

    public CreateUpdateProfilePage clickOnUpdateProfileButton(){

        profileContainer.findElement(By.xpath(".//*[contains(@class,'btn btn--secondary')]")).click();

        return new CreateUpdateProfilePage();

    }

    public void clickLeftNavigationMenuLink(String linkName){

        WebElement navigationLink = leftNavigationMenuContainer.findElement(By.xpath(".//a[contains(text(),'"+linkName+"')]"));

        navigationLink.click();


    }

    public ContactInfoPage navigateToContactInfoPage(){

        clickLeftNavigationMenuLink(Constants.SETTINGS_CONTACT_INFO_LINK_TEXT);

        return new ContactInfoPage();


    }

    public CommunicationsPage navigateToCommunicationsPage(){


        clickLeftNavigationMenuLink(Constants.SETTINGS_COMMUNICATION_LINK_TEXT);

        return new CommunicationsPage();

    }
    
    public YourProgramPage navigateToYourProgramPage(){
    	
    	 clickLeftNavigationMenuLink(Constants.SETTINGS_YOURPROGRAM_LINK_TEXT);
    	 
    	 return new YourProgramPage();
    	
    }
    
    public IdAndPasswordPage navigateToIDandPasswordPage(){
    	
   	 clickLeftNavigationMenuLink(Constants.SETTINGS_IDPASSWORD_LINK_TEXT);
   	 
   	 return new IdAndPasswordPage();
   	
   }

    public DeviceAndAppsPage navigateToDeviceAndAppsPage(){

        clickLeftNavigationMenuLink(Constants.SETTINGS_DEVICES_APPS_LINK_TEXT);

        return new DeviceAndAppsPage();
    }

    public ProfilePage navigateToProfilePage(){

        clickLeftNavigationMenuLink(Constants.SETTINGS_PROFILE_LINK_TEXT);

        return new ProfilePage();

    }
    
    
}
