package com.alerehealth.ui.portal.common.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.settings.TermsOfUsePage;

public class TextToQuitPage extends TOUPage{


	@FindBy(xpath="//div[@class= 'ogn__title__left']//following-sibling::h1")
	private WebElement  txtQuitTitle;

	@FindBy(xpath="//a[@class='logo--optum-header']")
	private WebElement logoHealth;


	@FindBy(xpath="//a[contains(text(),'here')]")
	private WebElement txtHere;

	private String mainWinHandle;

	

	public boolean isDisplayed(){

		waitForElementToBeDisplayed(txtQuitTitle);

		return txtQuitTitle.isDisplayed();
	}

	public String getTitle(){

		waitForElementToBeDisplayed(txtQuitTitle);

		String title = txtQuitTitle.getText().trim();

		return title;
	}

	public TermsOfUsePage clickOnHere(){


		mainWinHandle = getWebDriver().getWindowHandle();

		Set<String> winHandles = getWebDriver().getWindowHandles();

		List<String> parentWinHandles = new ArrayList<String>();

		parentWinHandles.addAll(winHandles);

		txtHere.click();

		waitForNewWindowToOpen(2);

		switchToNewWindow(parentWinHandles);

		return new TermsOfUsePage();


	}

	public void switchBackToText2QuitPage(){

		getWebDriver().switchTo().window(mainWinHandle);

	}
	
	
	 public String getClientNameOptumHolderPara (String clientName)

	    {
	        String xpath = (clientName.toLowerCase().equals("Optum")) ? "//p[1]" : "//p[6]";

	        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

	        String paraContent = clientParagraph.getText().trim();

	        System.out.println(paraContent);

	        return paraContent;

	    }
	    
	    
	    public String getClientNamePronouncedHealthHolderPara (String clientName)

	    {
	        String xpath = (clientName.toLowerCase().equals("PronouncedHealth")) ? "//p[6]" : "//p[1]";

	        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

	        String paraContent = clientParagraph.getText().trim();

	        System.out.println(paraContent);

	        return paraContent;

	    }
	    
	    public String getClientNameUnitedHealthHolderPara (String clientName)

	    {
	        String xpath = (clientName.toLowerCase().equals("unitedhealthcare")) ? "//p[6]" : "//p[1]";

	        WebElement clientParagraph = getWebDriver().findElement( By.xpath(xpath));

	        String paraContent = clientParagraph.getText().trim();

	        System.out.println(paraContent);

	        return paraContent;

	    }
	    
	    
	    

}
