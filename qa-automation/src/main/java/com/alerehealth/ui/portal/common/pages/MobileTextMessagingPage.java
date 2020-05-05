package com.alerehealth.ui.portal.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileTextMessagingPage extends TOUPage{



	@FindBy(xpath="//div[@class= 'ogn__title__left']//following-sibling::h1")
	private WebElement  txtMobileMessagingTitle;



	public static String title;

	public boolean isDisplayed(){

		waitForElementToBeDisplayed(txtMobileMessagingTitle);

		return txtMobileMessagingTitle.isDisplayed();
	}

	public String getTitle(){

		waitForElementToBeDisplayed(txtMobileMessagingTitle);

		title = txtMobileMessagingTitle.getText().trim();

		//System.out.println(title);

		return title;
	}


	 public String getClientNameOptumHolderPara (String clientName)

	    {
	        String xpath = (clientName.toLowerCase().equals("Optum")) ? "//p[1]" : "//p[2]";

	        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

	        String paraContent = clientParagraph.getText().trim();

	        System.out.println(paraContent);

	        return paraContent;

	    }
	    
	    
	    public String getClientNamePronouncedHealthHolderPara (String clientName)

	    {
	        String xpath = (clientName.toLowerCase().equals("PronouncedHealth")) ? "//p[1]" : "//p[2]";

	        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

	        String paraContent = clientParagraph.getText().trim();

	        System.out.println(paraContent);

	        return paraContent;

	    }
	    
	    public String getClientNameUnitedHealthHolderPara (String clientName)

	    {
	        String xpath = (clientName.toLowerCase().equals("unitedhealthcare")) ? "//p[1]" : "//p[2]";

	        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

	        String paraContent = clientParagraph.getText().trim();

	        System.out.println(paraContent);

	        return paraContent;

	    }
	    
	    
	    
}
