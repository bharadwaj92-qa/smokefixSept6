package com.alerehealth.ui.callcenter.mainmenu;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CallCenterMyTeamPage extends CallCenterHomePage {

    @FindBy(id="home_headerbar_icon_teamwork_b")
    private WebElement myteamIconHighLighted;


    @FindBy(id="TeamName")
    private WebElement teamName;

    @FindBy(id="PrimaryNurse")
    private WebElement user;

    @FindBy(id="MyTeamInteractionType")
    private WebElement myTeamInteractionType;

    @FindBy(id="View")
    private WebElement taskDate;

    @FindBy(id="AllStatesCheck")
    private WebElement showAllStatesCheckBox;

    @FindBy(id="RescheduledCalls")
    private WebElement rescheduledCallsCheckBox;

    @FindBy(id="EveningCalls")
    private WebElement eveningCallsCheckBox;

    @FindBy(id="WeekendCalls")
    private WebElement weekendCallsCheckBox;

    @FindBy(xpath = "//div[@class='pzbtn-mid' and contains(text(),'Reset')]/ancestor::button")
    private WebElement resetButton;

    @FindBy(id="TaskSearchBtn")
    private WebElement searchButton;


    public boolean isShowAllStatesCheckBoxChecked(){

        return showAllStatesCheckBox.isSelected();

    }


    public boolean isRescheduledCallsOnlyCheckBoxChecked(){

        return rescheduledCallsCheckBox.isSelected();

    }


    public boolean isEveningCallsCheckBoxChecked(){

        return eveningCallsCheckBox.isSelected();

    }

    public boolean isWeekendCallsCheckBoxChecked(){

        return weekendCallsCheckBox.isSelected();

    }


    public String getTeam(){

        Select teamSelect = new Select(teamName);

        String selectedTeam = teamSelect.getFirstSelectedOption().getText().trim();

        return selectedTeam;
    }


    public String getUser(){

        Select userSelect = new Select(user);

        String selectedUser = userSelect.getFirstSelectedOption().getText().trim();

        return selectedUser;
    }


    public String getTaskDate(){

        Select taskDateSelect = new Select(taskDate);

        String selectedtaskDate = taskDateSelect.getFirstSelectedOption().getText().trim();

        return selectedtaskDate;
    }

    public String getInteractionType(){

        Select myTeamInteractionTypeSelect = new Select(myTeamInteractionType);

        String selectedmyTeamInteractionType = myTeamInteractionTypeSelect.getFirstSelectedOption().getText().trim();

        return selectedmyTeamInteractionType;
    }


    public void selectTeam(String team){

        Select myTeamSelection = new Select(teamName);

        myTeamSelection.selectByVisibleText(team);


    }

    public void selectUser(String userName){

        Select myUserSelection = new Select(user);

        myUserSelection.selectByVisibleText(userName);

    }

    public void selectTaskDate(String taskDateToSelect){

        Select mytaskDateSelection = new Select(taskDate);

        mytaskDateSelection.selectByVisibleText(taskDateToSelect);

    }

    public void selectInteractionType(String interactionType){

        Select interaction = new Select(myTeamInteractionType);
        interaction.selectByVisibleText(interactionType);
    }

    public void clickResetButton(){

        waitForElementToBeDisplayed(resetButton);

        javaScriptClick(resetButton);
        waitForPageToLoad();
        waitForSpecifiedTime(30);
    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(myteamIconHighLighted);

        boolean isMyTeamPage = myteamIconHighLighted.isDisplayed();

        switchToFrame(home_results_iframe);

        return teamName.isDisplayed();


    }
}
