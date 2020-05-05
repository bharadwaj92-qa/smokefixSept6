package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

public class ManageGoalsPage extends PortalHomePage {

    @FindBy(xpath = "//a[contains(@href,'chooseAssessment')]")
    private WebElement addGoalLink;

    @FindBy(className = "container--base")
    private WebElement manageGoalsContainer;

    @FindBy(xpath = "//*[contains(@href,'downloadCert')]")
    private WebElement downloadCertificateButton;

    public boolean isDownloadCertificateLinkIsPresent(){

        try {
            return downloadCertificateButton.isDisplayed();
        }catch(NoSuchElementException nse){

            return false;
        }
    }



    public List<String> getActivePlans(){

        List<String> activeGoals = new ArrayList<String>();

        String xpath = "//*[contains(@class,'card--result card-with-image')]//*[@class='card-header']/*";

        List<WebElement> headers = getWebDriver().findElements(By.xpath(xpath));

        headers.forEach(header -> activeGoals.add(header.getText().trim()));

        return activeGoals;

    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(manageGoalsContainer);

        return manageGoalsContainer.isDisplayed();
    }

    public void cancelGoal(String goal) {

        WebElement goalSection = getGoalSectionWebElement(goal);

        String cancelButtonXpath = "//a[contains(@data-target,'#myModal-goal-cancel')]";

        goalSection.findElement(By.xpath(cancelButtonXpath)).click();

        waitForModelDialogToOpen();

        selectOptionInCancelGoalModalDialog("Yes");

        clickButtonInCancelGoalModalDialog("Continue");

    }

    private WebElement getGoalSectionWebElement(String goal){

        String xpath = "//*[text()='"+goal+"']//ancestor::section[contains(@class,'card--result card-with-image')]";

        WebElement goalSection = getWebDriver().findElement(By.xpath(xpath));

        return goalSection;

    }


    public void selectOptionInCancelGoalModalDialog(String option){

       String value = option.contains("Yes")?"yes": "no";

       WebElement modalDialogElement =  getModalDialogWebElement();

       String xpath = ".//input[@type='radio' and @value='cancel-goal-"+value+"']/..";

       modalDialogElement.findElement(By.xpath(xpath)).click();

    }

    public void clickButtonInCancelGoalModalDialog(String button){

        String buttonXpath = "";

        button = button.toLowerCase();

        if(button.contains("continue")){

            buttonXpath = ".//button[contains(text(),'Continue')]";

        }else if(button.contains("cancel")){

            buttonXpath = ".//a[contains(text(),'Cancel')]";

        }else{

            buttonXpath = ".//button[@class='close']";

        }

        WebElement modalDialogElement =  getModalDialogWebElement();

        modalDialogElement.findElement(By.xpath(buttonXpath)).click();


    }

    public ActionPlanSetYourGoal clickAddGoalButton(){

        addGoalLink.click();

        return new ActionPlanSetYourGoal();
    }




    public boolean isAddGoalsOptionPresent() {
        try {
            addGoalLink.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
