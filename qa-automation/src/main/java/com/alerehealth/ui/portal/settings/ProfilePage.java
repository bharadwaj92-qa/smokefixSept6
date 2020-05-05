package com.alerehealth.ui.portal.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class ProfilePage extends SettingsBasePage {

    @FindBy(xpath="//a[contains(@href,'Avatar')]")
    private WebElement createUpdateProfile;

    @FindBy(xpath = "//div[@class='message-info alert alert-success']")
    private WebElement alertMessages;

    @FindBy(xpath = "//a[@href='termsofuse']")
    private WebElement termsOfUseLink;

    @FindBy(xpath = "//a[@href='showCommunityGuidelines']")
    private WebElement communityGuideLinesLink;

    @FindBy(xpath = "//*[contains(@class,'user-avatar')]//span")
    private WebElement avatarIcon;
    
   
    public CreateUpdateProfilePage clickUpdateProfile(){

        createUpdateProfile.click();

        return new CreateUpdateProfilePage();

    }


    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(createUpdateProfile);

        return createUpdateProfile.isDisplayed();
    }


    public void clickCloseButtonInAlertMsg(){

        alertMessages.findElement(By.xpath(".//button")).click();

    }

    public CommunityGuideLinesPage clickOncommunityGuideLines(){

        communityGuideLinesLink.click();

       return new CommunityGuideLinesPage();

    }

    public TermsOfUsePage clickOnTermsOfUse(){

        termsOfUseLink.click();

       return new TermsOfUsePage();

    }

    public String getAlertMessageContent(){

        String alertMessageContent = alertMessages.findElement(By.xpath(".//p")).getText().trim();

        return alertMessageContent;
    }


    public HashMap<String,String> getAvatarDetails(){

        String classAttribute = avatarIcon.getAttribute("className");
        
        System.out.println(classAttribute);

        String []content = classAttribute.split(" ");


        HashMap<String,String> avatarDetails = new HashMap<String, String>();

        String avtarDetails = content[1];

        String hairStyleNumber = ""+avtarDetails.charAt(avtarDetails.indexOf("h")+1);
        String expression = ""+avtarDetails.charAt(avtarDetails.indexOf("exp")+"exp".length());
        String color = ""+avtarDetails.charAt(avtarDetails.indexOf("clr")+"clr".length());

        avatarDetails.put("hairstyle",hairStyleNumber);
        avatarDetails.put("expression",expression);
        avatarDetails.put("color",color);

        return avatarDetails;

    }
}
