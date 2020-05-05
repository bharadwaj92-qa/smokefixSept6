package com.alerehealth.ui.portal.wba.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WBASummaryPage extends WBAHomePage<WBASummaryPage> {


    @FindBy(xpath = "//*[@id='activity']//*[contains(@class,'highcharts-data-labels')]")
    private WebElement wbaScore;

    public String  getWBAOverallScore()
    {

        String wbaScoreText = wbaScore.getText();

        return wbaScoreText;
    }

    @Override
    public boolean isDisplayed() {


        return wbaScore.isDisplayed();
    }
}
