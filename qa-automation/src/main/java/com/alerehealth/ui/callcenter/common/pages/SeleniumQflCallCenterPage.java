package com.alerehealth.ui.callcenter.common.pages;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.selenium.common.SeleniumPage;

public abstract class SeleniumQflCallCenterPage extends SeleniumPage<SeleniumQflCallCenterPage> {

    public SeleniumQflCallCenterPage(){


        String url = Configuration.getConfiguration().getCallcenter_url();

       //LoggerUtils.info("Navigating to URL :"+ url);

        getWebDriver().get(url);


        initPage();


    }

}
