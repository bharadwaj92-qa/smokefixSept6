package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.LoggerUtils;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.qfl.NRTMedicationOrderViaActionPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionPlanBannerPage extends PortalHomePage{

    @FindBy(xpath = "//*[contains(@class,'card--message')]")
    private WebElement actionPlanBannerContainer;


    @FindBy(xpath = "//*[contains(@class, 'todo-reminder-container')]")
    private WebElement remainderContainer;

    @FindBy(id="arrow-top")
    private WebElement topArrow;

    @FindBy(xpath="//a[contains(@class,'btn--secondary') and not(contains(@class,'hidden'))]")
    private WebElement nrtGetStarted;

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(actionPlanBannerContainer);

        return super.isDisplayed();
    }


    public void scrollRemaindersIntoView(){

        scrollElementIntoView(remainderContainer);

    }

    public void clickOnTop(){

        scrollElementIntoView(topArrow);

        topArrow.click();
    }

    public void closeGoalReminderPopup(){

        try {

            waitForModelDialogToOpen();

            closeModalDialog();
            
            
        }catch (Exception e){

            LoggerUtils.warning("No Goal reminder popup is available");

        }


    }

    public void markTasksAsComplete(int taskNumber){

        List<WebElement> tasksList = getTasksToCompleteWebElement();

        WebElement taskToComplete = tasksList.get(taskNumber-1);

        WebElement taskToCompleteButton = taskToComplete.findElement(By.xpath(".//label[contains(@class,'mark-as-completed')]"));

        taskToCompleteButton.click();


    }

    private List<WebElement> getTasksToCompleteWebElement(){

        String xpath = "//*[@class='container--results']//*[contains(@class,'card--result')]";
        waitForComponentTobDisplayed(By.xpath(xpath));
        List<WebElement> tasksList =  getWebDriver().findElements(By.xpath(xpath));

        return tasksList;

    }


    private List<WebElement> getMileStoneCircleIconElements(){

        String xpath = "//*[@class='hp-mile-wrapper']/i";

        List<WebElement> mileStoneCircleIconsksList =  getWebDriver().findElements(By.xpath(xpath));

        return mileStoneCircleIconsksList;

    }

    public boolean isMileStoneComplete(int index){

        boolean isMileStoneComplete = true;

        List<WebElement> mileStoneCircleIconsksList = getMileStoneCircleIconElements();

        WebElement cirlceIcon = mileStoneCircleIconsksList.get(index-1);

        String classOfIcon =  cirlceIcon.getAttribute("className");
        String colorOfIcon = cirlceIcon.getCssValue("color");
        String bgColorOfIcon = cirlceIcon.getCssValue("background-color");

        if(colorOfIcon!=null &&!colorOfIcon.isEmpty()){

            System.out.println(colorOfIcon+" is color of icon");
            isMileStoneComplete= isMileStoneComplete&&(colorOfIcon.contains("#627D32")||colorOfIcon.contains("rgba(98, 125, 50, 1)"));

            System.out.println("Is color matching "+ isMileStoneComplete);


        }else if(!isMileStoneComplete) {

            System.out.println(classOfIcon+" is class name of icon");

            isMileStoneComplete= isMileStoneComplete||(classOfIcon.contains("milestone-circle-thin-dark"));

            System.out.println("Mile stone is complete on basis of class name" + isMileStoneComplete);

        }else{

            isMileStoneComplete = false;
        }

        return isMileStoneComplete;


    }


    public void clickHeroBannerButton(String button){


        String xpath = "//*[contains(@class,'hero')]//li[contains(@class,'cards__links-li";

        switch(button.toUpperCase()){

            case "SHARE": {
                xpath+="')]//a[contains(@class,'dropdown-toggle')]";

                break;
            }
            case "MANAGE GOALS" : {

                xpath+="')]//a[contains(@href,'managegoals')]";

                break;
            }
            default:{

                xpath+=" toggle-goal-accomplish')]//a";

            }
        }

        WebElement e= getWebDriver().findElement(By.xpath(xpath));
        javaScriptClick(e);
    }

    public void selectGoalReminderOptions(String ...options ){

        String optionsArray[] = options;

        String radioOption = (optionsArray[0].toLowerCase().contains("yes"))? "yes": (optionsArray[0].toLowerCase().contains("no"))?"no": "invalidoption";

        WebElement modalDialogElement = getModalDialogWebElement();

        WebElement radioButton =  modalDialogElement.findElement(By.xpath(".//input[contains(@id,'"+radioOption+"')]/.."));

        javaScriptClick(radioButton);

        if(optionsArray.length>1){

           WebElement endDate =  modalDialogElement.findElement(By.xpath(".//input[@id='goalEndDate-accomplish']"));

            endDate.sendKeys(optionsArray[1]);

        }



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

    public CongratulationOnGoalCompletionPage markCurrentGoalAsCompleteFromHeroBanner(){

        clickHeroBannerButton("I've reached this goal...");

        waitForModelDialogToOpen();

        selectGoalReminderOptions("Yes, I reached my goal on", DateTimeUtils.getCurrentTime("MM/dd/yyyy"));

        clickButtonInCancelGoalModalDialog("Continue");
        
        return new CongratulationOnGoalCompletionPage();
    }

    public NRTMedicationOrderViaActionPlan startNRTActionPlan(){

        selectFromBehaviourDropDown("Use Quit Medications");

        waitForElementToBeDisplayed(nrtGetStarted);

        nrtGetStarted.click();

        return new NRTMedicationOrderViaActionPlan();
    }

    public void selectFromBehaviourDropDown(String option){

        String xpath = "//*[@title='Behavior']";

        WebElement selectBoxEle = getWebDriver().findElement(By.xpath(xpath));

        Select select = new Select(selectBoxEle);

        select.selectByVisibleText(option);
    }



}
