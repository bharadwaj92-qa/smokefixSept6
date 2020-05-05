package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.selenium.common.SeleniumPage;

public abstract class SeleniumPortalPage extends SeleniumPage<SeleniumPortalPage> {

    public SeleniumPortalPage(){


        String url = ClientConfiguration.getClientConfiguration().getClientURL();
    	
        LoggerUtils.info("Navigating to URL :"+ url);

        getWebDriver().get(url);


        initPage();


    }

}
