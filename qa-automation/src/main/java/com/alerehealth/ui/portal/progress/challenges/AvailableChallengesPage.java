package com.alerehealth.ui.portal.progress.challenges;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class AvailableChallengesPage extends PortalHomePage{
	
	@FindBy(xpath="//li[contains(text(),'Max. Steps/day:')]/strong")
	private WebElement maxStepsPerDayValue;

	@FindBy(xpath="//div[@id='challenge_avaliable']//h2")
	private WebElement availablePageVerfication;
	
	@FindBy(xpath="//div[@class='modal-footer para-modal-footer']/div/button")
	private List<WebElement> popupBoxButtons;
	
	@FindBy(partialLinkText="Back to Challenges")
	private WebElement challengesPageLink;

    @FindBy(id="dateEntered")
	private WebElement displayDate;
	

	@FindBy(xpath="//*[@class='button btn-secondary addBtn' and contains(text(),'Add')]")
	private WebElement addStepsBtn;
	
	@FindBy(xpath="//input[contains(@class,'small validation-message haserror')]/following-sibling::small/span")
	private WebElement addTextFieldError;
	
	@FindBy(id="saveChallenge")
	private WebElement submitButton;
	
	@FindBy(xpath="//*[@id='statusCodeZero']/h1")
	private WebElement successMsgValidation;
	
	
//	@FindBy(id="confirmMessage")
	@FindBy(xpath="//*[contains(@class,'rich-message')]")
	private WebElement popUpText;
	

	@FindBy(xpath="//ul[@class='tabs']//a[text()='Available' and contains(@class,'icon_checkmark')]")
	private WebElement availableLinkHighlighted;
	
	
	public List<String> getAvailablePageTitlesVerficationText()
	{   
		 String xpath = "//div[@id='challenge_avaliable']//h2"; 
	    	
	    	List<WebElement> availableTitleele = getWebDriver().findElements( By.xpath(xpath));
	    	
	    	List<String> availableChallengeTitles = new ArrayList<String>();
	    	
	    	availableTitleele.forEach(availableTitles -> availableChallengeTitles.add(availableTitles.getText().trim()));

	    	return availableChallengeTitles;
	}
	
	public void clickAddButton()
	{
		scrollElementIntoView(addStepsBtn);
		
		javaScriptClick(addStepsBtn);
		
	}
	
	public void enterDateInTextBox(String text)
	{
		String xpath = "//input[contains(@class,'smallInput addTextBox small')]";
		
		WebElement addStepsEditBox = getWebDriver().findElement(By.xpath(xpath));
		
		scrollElementIntoView(addStepsEditBox);
		
		if(text.isEmpty())
		{
			
			addStepsEditBox.sendKeys(Keys.ENTER);
		}
		
		else
		{
		
			try{
				
				addStepsEditBox.sendKeys(text);
				
			}catch(ElementNotVisibleException e){
		
			javaScriptSendKeys(addStepsEditBox,text);
			}
		}
		}
	
	public String getAddStepsFieldError()
	{
		waitForElementToBeDisplayed(addTextFieldError);
		return addTextFieldError.getText();
	}
	
	public void selectDailyWeeklyDropdown(String value)
	{
		
		javaScriptClick(getWebDriver().findElement(By.xpath("//div[@class='dropdown-menu open']//span[text()='"+value+"']")));
		
	}
	
	public void clickSubmit()
	{
		scrollElementIntoView(submitButton);
		javaScriptClick(submitButton);
	}
	
	public String getSuccessMessageAfterSubmit()
	{
		waitForElementToBeDisplayed(successMsgValidation);
		scrollElementIntoView(successMsgValidation);
		return successMsgValidation.getText();
	}
	
	public void handlePopUp(String action)
	{
		
		
		for(WebElement elememt:popupBoxButtons)
		{
			if(action.equals(elememt.getText()))
			{
				elememt.click();
				break;
			}
		}
	}
	
	public String getDisplayDate()
	{
		return displayDate.getText();
	}
	
	public String getMaxStepsPerDayText()
	{
		
		return maxStepsPerDayValue.getText();
	}
	
	public String getPopUpText()
	{
		
		waitForElementToBeDisplayed(popUpText);
		return popUpText.getText();
	}
	
	public ChallengesBasePage navigateBackToChallengesPage()
	{
			javaScriptClick(challengesPageLink);
			return new ChallengesBasePage();
		
	}
	


	public String getButtonTextOfChallenge(String challenge){

		WebElement challengeContainer = getChallengeContainerElement( challenge);

		WebElement button = challengeContainer.findElement(By.xpath(".//a[@role='button']"));

		return button.getText().trim();
	}

	public AddEditChallengePage startChallenge(String challenge){

		WebElement challengeContainer = getChallengeContainerElement(challenge);

		challengeContainer.findElement(By.xpath(".//a[@role='button']")).click();

		return new AddEditChallengePage();
	}

	private WebElement getChallengeContainerElement(String challenge){

		String xpath = "//div[@id='challenge_avaliable']//*[@class='cs-heading' and contains(text(),'"+challenge+"')]/ancestor::div[@class='media-object']";

		WebElement challengeContainer = getWebDriver().findElement(By.xpath(xpath));

		return challengeContainer;

	}
	
	@Override
	public boolean isDisplayed() {
		return availableLinkHighlighted.isDisplayed();
	}

	
	
	
}
