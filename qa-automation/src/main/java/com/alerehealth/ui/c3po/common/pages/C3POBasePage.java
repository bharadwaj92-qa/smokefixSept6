package com.alerehealth.ui.c3po.common.pages;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.selenium.common.SeleniumPage;

public abstract class C3POBasePage<T extends SeleniumPage<?>> extends SeleniumPage<T> {

    public C3POBasePage(){

        String url = Configuration.getConfiguration().getC3PO_Url();

        LoggerUtils.info("Navigating to URL :"+ url);

        getWebDriver().get(url);

        initPage();

        if(!isPageDisplayed()){

            throw new RuntimeException("Couldn't load page"+ this.getClass());
        }


    }


}
