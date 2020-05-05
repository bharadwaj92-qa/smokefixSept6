package com.alerehealth.ui.portal.common.pages;


import com.alerehealth.fwk.common.LoggerUtils;
import org.openqa.selenium.By;

import com.alerehealth.fwk.selenium.common.SeleniumPage;


public class CustomURLLauncher extends SeleniumPage<CustomURLLauncher> {
	
	public CustomURLLauncher(String url){
		
        LoggerUtils.info("Navigating to URL :"+ url);

        getWebDriver().get(url);

        initPage();
		
	}
	
	public void clickLink(String link){
		
		getWebDriver().findElement(By.xpath("//a[contains(text(),'"+link+"')]")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean isDisplayed() {
		
		return true;
	}

}
