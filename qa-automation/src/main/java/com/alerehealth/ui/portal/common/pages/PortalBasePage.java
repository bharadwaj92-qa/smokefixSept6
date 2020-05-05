package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.selenium.common.SeleniumPage;

public abstract class PortalBasePage <T extends SeleniumPage<?>> extends SeleniumPage<T> {


    public PortalBasePage(){

        initPage();

        if(!isPageDisplayed()){

            throw new RuntimeException("Couldn't load page"+ this.getClass());
        }



    }




}
