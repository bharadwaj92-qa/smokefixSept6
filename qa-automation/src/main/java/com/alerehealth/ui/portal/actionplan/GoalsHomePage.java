package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoalsHomePage extends PortalHomePage {

    @FindBy(className = "program--focus--area")
    private WebElement focusAreaSection;


    @FindBy(partialLinkText = "Focus Area")
    private WebElement startCurrentFocus;

    public GoalDeadLineSelectionPage clickChooseCurrentFocus(){

        startCurrentFocus.click();

       return new GoalDeadLineSelectionPage();


    }

    public ActionPlanAddACoachPage clickOtherFocusArea(String focusArea){


        String focusAreaXpath = "//p[contains(text(),'"+focusArea+"')]/ancestor::li[@class='cbox__item']";

        WebElement focusAreaElement = getWebDriver().findElement(By.xpath(focusAreaXpath));

        Actions action = new Actions(getWebDriver());

        action.moveToElement(focusAreaElement).perform();

        String selectButtonXpath = focusAreaXpath+"//*[@class='button primary']";

        getWebDriver().findElement(By.xpath(selectButtonXpath)).click();

        return new ActionPlanAddACoachPage();


    }



    public List<String> getOtherFocusAreas(){

        List<String> focusAreas = new ArrayList<String>();

        //NOTE: When a focus area is unavailable ,li class="cbox__item choose-not-available" so item wont be listed

        String xpath = "//li[@class='cbox__item']//p";

        List<WebElement> focusAreaElements = getWebDriver().findElements(By.xpath(xpath));

        for(WebElement focusAreaEle: focusAreaElements){

            String focusAreaText = focusAreaEle.getText();

            //Incase More Info is returned in text replace it and remove whitespaces
            focusAreaText = focusAreaText.replace("More Info","").trim();

            focusAreas.add(focusAreaText);
        }

        return focusAreas;

    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(focusAreaSection);
        return focusAreaSection.isDisplayed();
    }
    
    public ActionPlanSetYourGoal clickAddCoachButton(String goal)  {
    
    String xpath="//h2[text()='"+goal+"']//..//div//following-sibling::a[contains(text(),'Add Coaching')]";
    WebElement btnAddCoach = getWebDriver().findElement(By.xpath(xpath));
    waitForElementToBeDisplayed(btnAddCoach);
    btnAddCoach.click();
    
    return new ActionPlanSetYourGoal();
    
   }
    
    
}
