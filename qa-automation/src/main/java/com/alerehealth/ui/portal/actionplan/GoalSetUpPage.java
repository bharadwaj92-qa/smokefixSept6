package com.alerehealth.ui.portal.actionplan;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GoalSetUpPage extends PortalHomePage {



    @FindBy(id="field-for-TIMEZONE")
    private WebElement timeZoneSelection;

    @FindBy(id="field-for-EMAIL")
    private WebElement email;

    @FindBy(id="field-for-PRIMARYPHONE")
    private WebElement primaryPhone;

    @FindBy(id="field-for-PRIMARYPHONETYPE")
    private WebElement primaryPhoneType;

    @FindBy(id="field-for-PRIAMRYCALLPREF_DAYS")
    private WebElement primaryPhonePreferedDay;

    @FindBy(id="field-for-PRIAMRYCALLPREF_PERIOD")
    private WebElement whenToCall;

    @FindBy(id="field-for-PRIAMRYCALLPREF_TIMES")
    private WebElement primaryPhonePreferedTime;

    @FindBy(id="field-for-OHC15")
    private WebElement preferredLanguage;

    @FindBy(id="field-for-OHC34")
    private WebElement howDidYouListenAboutThisProgram;

    @FindBy(className = "dateBox")
    private WebElement dateFieldSection;


    @FindBy(id="section-for-OHC36")
    private WebElement healthConditionsSection;

    @FindBy(xpath = "//input[@name='userResponses[2].answer']")
    private WebElement enterAddress;

    @FindBy(xpath = "//input[@name='userResponses[4].answer']")
    private WebElement enterCity;

    @FindBy(xpath = "//select[@id='field-for-STATE']")
    private WebElement selectState;

    @FindBy(xpath = "//input[@name='userResponses[6].answer']")
    private WebElement enterZip;

    @FindBy(xpath = "//select[@id='field-for-COUNTRY']")
    private WebElement selectCountry;


    public void selectWorkBookCommunication(String communicationMode){

        selectRadioButtonOfSection("question-WORKBOOK",communicationMode);


    }
    public void selectTimeZone(String timezone){

        Select timeZoneSelect = new Select(timeZoneSelection);

        timeZoneSelect.selectByVisibleText(timezone);

    }

    public void enterZipCode(String zip){

        enterZip.sendKeys(zip);
    }

    public void selectCountry(String country){

        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
    }


    public void selectState(String state){

        Select select = new Select(selectState);
        select.selectByVisibleText(state);
    }

    public void enterAddress(String addressText){

        enterAddress.sendKeys(addressText);

    }

    public void enterCity(String cityName){

        enterCity.sendKeys(cityName);
    }

    public void setEmail(String emailToEnter){

        email.clear();

        email.sendKeys(emailToEnter);

    }

    public void setPrimaryPhone(String primaryPhoneNumberToEnter){

        primaryPhone.clear();

        primaryPhone.sendKeys(primaryPhoneNumberToEnter);
    }

    public void setPrimaryPhoneType(String primaryPhoneTypeToSelect) {

        Select primaryPhoneTypeSelect = new Select(primaryPhoneType);

        primaryPhoneTypeSelect.selectByVisibleText(primaryPhoneTypeToSelect);
    }

    public void selectPreferredLanguage(String language){

       Select preferredLanguageSelector = new Select(preferredLanguage);

       preferredLanguageSelector.selectByVisibleText(language);
    }

    public void selectPreferedDayToCallOnPrimaryPhone(String preferredDay){

        Select primaryPhonePreferedDaySelector = new Select(primaryPhonePreferedDay);

        primaryPhonePreferedDaySelector.selectByVisibleText(preferredDay);

    }

    public void selectWhenToCall(String callOption){

        Select whenToCallSelector = new Select(whenToCall);

        whenToCallSelector.selectByVisibleText(callOption);
    }

    public void selectPreferedTimeToCallOnPrimaryPhone(String preferredTime){

        Select primaryPhonePreferedTimeSelector= new Select(primaryPhonePreferedTime);

        primaryPhonePreferedTimeSelector.selectByVisibleText(preferredTime);
    }

    public void setDate(String date){

        String xpath = ".//input[@type='text']";

        dateFieldSection.findElement(By.xpath(xpath)).sendKeys(date);

    }

    public void areYouPlanningToQuitInNext30Days(String option){

        selectRadioButtonOfSection("question-OHC23", option);
    }

    public void doYouUseECigras(String option){

        selectRadioButtonOfSection("question-OHC26", option);
    }

    public void selectHealthConditions(List<String> healthConditions){

        for(String healthCondition : healthConditions) {

            String xpath = ".//span[@class='checkbox-description' and text()='"+healthCondition+"']";

            healthConditionsSection.findElement(By.xpath(xpath)).click();

        }

    }

    public void doULikeToReceiveText2QuitMessages(String option){

        selectRadioButtonOfSection("question-OHC16", option);
    }

    public void howDidYouListenAboutThisProgram(String option){

        Select howDidYouListenAboutThisProgramSelector = new Select(howDidYouListenAboutThisProgram);

        howDidYouListenAboutThisProgramSelector.selectByVisibleText(option);

    }

    private void selectRadioButtonOfSection(String sectionID , String option){

        String value = option;

        String xpath = "//*[@id='"+sectionID+"']//input[@type='radio' and @value='"+value+"']";

        try {

            getWebDriver().findElement(By.xpath(xpath)).click();
        }
        catch (ElementNotVisibleException elementNotVisibleException){

            xpath = "//*[@id='"+sectionID+"']//input[@type='radio' and @value='"+value+"']/following-sibling::label";

            getWebDriver().findElement(By.xpath(xpath)).click();
        }


    }


    public GoalSetupSuccessPage clickContinueButton(){

        String xpath = "//button[@type='submit']";

        getWebDriver().findElement(By.xpath(xpath)).click();

        return new GoalSetupSuccessPage();

    }
}
