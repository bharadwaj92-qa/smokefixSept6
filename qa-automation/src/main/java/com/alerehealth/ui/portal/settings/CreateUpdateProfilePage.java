package com.alerehealth.ui.portal.settings;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUpdateProfilePage extends ProfilePage {

    @FindBy(id="profileUpdate_screenName")
    private WebElement screenName;

    @FindBy( xpath= "//*[contains(@class,'profile avatar hairs')]")
    private WebElement avatarSelector;

    @FindBy(xpath = "//*[contains(@class,'profile avatar expressions')]")
    private WebElement avatarExpressionSelector;

    @FindBy(xpath = "//*[contains(@class,'profile avatar colors')]")
    private WebElement avatarColorSelector;

    @FindBy(id="updateProfileId")
    private WebElement updateProfileButton;


//    public void setScreenName(String screenNameToEnter){
//
//        screenName.sendKeys(screenNameToEnter);
//        
//    }

    public void setScreenName(String screenNameToEnter){

        screenName.clear();

        boolean useLetters = true;
        boolean useNumbers = false;
        String screenNameToEnterInTextBox = RandomStringUtils.random(7, useLetters, useNumbers);
        screenName.sendKeys(screenNameToEnterInTextBox);
    }
    
    public void selectAvatar(int hairStyle){

        WebElement avatarHair = avatarSelector.findElement(By.xpath(".//label[@class='avatar h"+hairStyle+"']"));

        avatarHair.click();

    }

    public void selectExpression(int expression){

        WebElement expressionSelectorElement = avatarExpressionSelector.findElement(By.xpath(".//label[@class='avatar exp"+expression+"']"));

        expressionSelectorElement.click();

    }

    public void selectColor(int color){

        WebElement expressionSelectorElement = avatarColorSelector.findElement(By.xpath(".//label[@class='avatar avatar-color"+color+"']"));

        expressionSelectorElement.click();

    }

    public ProfilePage clickUpdateProfileButton(){

        updateProfileButton.click();

        return new ProfilePage();

    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(updateProfileButton);

        return updateProfileButton.isDisplayed();
    }
}
