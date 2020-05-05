package com.alerehealth.fwk.selenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by venkata.chunduri on 26/05/18.
 */
public abstract class SeleniumPage<T extends SeleniumPage<?>> extends Element {



    public SeleniumPage(){

        initialize();

    }



    public void initPage(){

        PageFactory.initElements(getWebDriver(), this);

    }

    public WebDriver getWebDriver(){

        return WebDriverManager.getWebDriverInstance();
    }

    public void initialize(){

        try {

           WebDriverManager.getWebDriverInstance();

        }catch (Exception e){


            throw new RuntimeException("Exception while creating driver object" + e.getMessage());


        }
    }




    public boolean isPageDisplayed(){

        return isDisplayed();
    }



}
