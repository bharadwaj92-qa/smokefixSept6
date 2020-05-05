package com.alerehealth.ui.portal.usermenu.phr;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;


public class PHRHealthRecordPage extends PortalHomePage{


	@FindBy(xpath="//div[contains(@class,'page--phr')]")
	private  WebElement phrPageContainer;

	public void clickContentCard(String contentCardTitle){

		String xpath = "//*[@class='header' and contains(text(),'"+contentCardTitle+"')]//ancestor::a[contains(@class,'tile--combo')]";

		getWebDriver().findElement(By.xpath(xpath)).click();

	}

	public PHRSearchAndAddDoctorPage addADoctor(){

		clickContentCard("Doctors");

		return new PHRSearchAndAddDoctorPage();


	}

	public boolean isContentCardPresent(String cardTitle){

		String xpath = "//a[contains(@class,'tile--combo')]//*[@class='header' and contains(text(),'"+cardTitle+"')]";

		try{

			getWebDriver().findElement(By.xpath(xpath));

			return true;
		}catch(Exception e){

			return false;
		}



	}


	public List<String> getAllContentCardNames(){

		List<String> contentCardNames = new ArrayList<String>();

		String xpath = "//a[contains(@class,'tile--combo')]//*[@class='header']";
		List<WebElement> contentCardHeaders = getWebDriver().findElements(By.xpath(xpath)) ;

		for(WebElement contentCard : contentCardHeaders){

			contentCardNames.add(contentCard.getText().trim());

		}

		return contentCardNames; 

	}

	public boolean isLeftNavLinkHighlighted(String leftNavLinkText){

		String xpath = "//li[@class='nav-list-item']//a[contains(text(),'"+leftNavLinkText+"') and @class='nav-link is-active']";


		List<WebElement> activeLinks =  getWebDriver().findElements(By.xpath(xpath));

		return (activeLinks.size()==1)? true : false; 

	}

	@Override
	public boolean isDisplayed() {
		return phrPageContainer.isDisplayed();
	}
}
