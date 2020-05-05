package com.alerehealth.ui.portal.rewards;

import java.util.List;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

import com.alerehealth.ui.portal.wba.pages.WBAHomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditPage extends PortalHomePage {


    @FindBy(xpath= "//*[contains(@class,'incentive-card-small')]")
    private WebElement smallGridsContainer;

    @FindBy(xpath = "//div[contains(@class,'interactiv-cards-wide')]")
    private WebElement wideCardContainer;

    @FindBy(xpath = "//*[@class='card-content power-points-bgc']//p[2]")
    private WebElement creditsScore;

    @FindBy(xpath = "//p[@class='center-align points-label-lg']")
    private WebElement yourCredits;

    @FindBy(xpath = "(//span[@class='points-credit'])[1]")
    private WebElement historyCredits;
  
    @FindBy(xpath = "//a[contains(text(),'View Earning History')]")
    private WebElement earningHistory;
    
    

    String buttonName;


    public void clickSmallCard(String title){

        WebElement navigationLink = smallGridsContainer.findElement(By.xpath(".//*[@class='cs-heading credits-default-card-title' and contains(text(),'"+title+"')]/ancestor::section//a"));

        navigationLink.click();

    }

    public void verifyWideCardText(String title){
        String xpath = ".//*[@class='header' and contains(text(),'"+title+"')]";

        Assert.assertEquals(title, wideCardContainer.findElement(By.xpath(xpath)).getText());
        LoggerUtils.info("Verified the CreditPage Content Card "+wideCardContainer.findElement(By.xpath(xpath)).getText());
    }
    public void clickOnWideCard(String title){

        String xpath = ".//*[@class='header' and contains(text(),'"+title+"')]/../..//a";

        wideCardContainer.findElement(By.xpath(xpath)).click();

    }

    /*
     * verifyAndClickWideCardButton() : Verifies the contentCard with title and buttonName,
     * Then it clicks on the button.
     */
    public void verifyAndClickWideCardButton(String title,String buttonName){

        String xpath = ".//*[@class='header' and contains(text(),'"+title+"')]/../..//a[contains(text(),'"+buttonName+"')]";
        wideCardContainer.findElement(By.xpath(xpath)).click();
    }

    /*
     * Clicks on GetStarted button in credits page
     */
    public WBAHomePage creditDetails(String buttonName){

        String xpath = "//a[contains(text(),'"+buttonName+"')]";

        getWebDriver().findElement(By.xpath(xpath)).click();

        return new WBAHomePage();

    }

    public boolean getCreditDetailsPageButtonText(String buttonName){

        String xpath = "//a[contains(text(),'"+buttonName+"')]";

        return getWebDriver().findElement(By.xpath(xpath)).isDisplayed();

    }


    /*
     * History page validation
     */
    public void historyQuestionCompletedStatus(){

        try{

            WebElement expected = getWebDriver().findElement(By.xpath("//div[@class='card-content']//h2[contains(text(),'Health Risk Questionnaire')]"));

            LoggerUtils.info("History questionner card: "+expected.getText());

            /*
             * Check icon for those user questionnaire completed in History page for image card
             */

            WebElement checkIcon = getWebDriver().findElement(By.xpath("//div[@class='card-content']/div[2]/p//i[contains(@class,'fa-check-circle')]"));

            checkIcon.isDisplayed();

            System.out.println("Check icon was displayed on card");
        }
        catch(Exception e){

            System.out.println("Questionnaire is not completed for this user, so content card is not displaying in History page.");
        }
    }

    public boolean isHealthRiskQuestionnaireContentCardDisplayinRewardPage(String imageCard){

        List<WebElement> list = getWebDriver().findElements(By.xpath("//div[contains(@class,'interactiv-cards-wide')]//*[contains(text(),'"+imageCard+"')]"));
        return list.size()>0 ? true : false;

    }

    public String getCreditScore()
    {

        return yourCredits.getText();
    }

    public String getHistoryCredits()
    {

        return historyCredits.getText();

    }

    public String getButtonNameOfSmallCard(String title){

        WebElement smallCard = getSmallCardElement(title);

        WebElement button = smallCard.findElement(By.xpath(".//a"));

        return button.getText().trim();

    }


    private WebElement getSmallCardElement(String title){

        WebElement smallCard = getWebDriver().findElement(By.xpath("//*[contains(@class,'incentive-card-small')]//*[@class='cs-heading credits-default-card-title' and contains(text(),'"+title+"')]/ancestor::section"));

        return smallCard;

    }
    
    //Added code
    public void clickSmartCardGetStartedButton(String title){
    	
    	 WebElement smallCard = getSmallCardElement(title);
    	 
    	 WebElement button = smallCard.findElement(By.xpath(".//a"));
    	 
    	 waitForElementToBeDisplayed(button);
    	 
    	 button.click();
    	
    	
    }
    
    public JoinAChallengePage navigateToJoinChallenge(){
    	
    	clickSmartCardGetStartedButton("Join a challenge.");
    	
    	return new JoinAChallengePage();
    	
    }
    
    public HistoryPage clickEarningHistory(){
    	
    	waitForElementToBeDisplayed(earningHistory);
    	earningHistory.click();
    	
    	return new HistoryPage();
    	
    }
    
    

   
}
