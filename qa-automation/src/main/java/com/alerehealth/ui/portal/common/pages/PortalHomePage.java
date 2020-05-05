package com.alerehealth.ui.portal.common.pages;

import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.fwk.db.ConnectionManager;
import com.alerehealth.fwk.db.DBDataFetcher;
import com.alerehealth.fwk.db.JDBCConnector;
import com.alerehealth.ui.portal.actionplan.ActionPlanBannerPage;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnaireStartingPage;
import com.alerehealth.ui.portal.actionplan.ManageGoalsPage;
import com.alerehealth.ui.portal.carereminders.CareReminderPage;
import com.alerehealth.ui.portal.coaching.NurseAdviceLinePage;
import com.alerehealth.ui.portal.coaching.WellnessPage;
import com.alerehealth.ui.portal.community.ActivityFeedPage;
import com.alerehealth.ui.portal.library.LibraryPage;
import com.alerehealth.ui.portal.library.SearchandBrowselinkPage;
import com.alerehealth.ui.portal.memberrescenter.MemberResourceCenterBasePage;
import com.alerehealth.ui.portal.progress.challenges.AvailableChallengesPage;
import com.alerehealth.ui.portal.progress.challenges.ChallengesBasePage;
import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;
import com.alerehealth.ui.portal.rewards.CreditPage;
import com.alerehealth.ui.portal.rewards.HistoryPage;
import com.alerehealth.ui.portal.settings.SettingsBasePage;
import com.alerehealth.ui.portal.settings.TermsOfUsePage;
import com.alerehealth.ui.portal.usermenu.MessagesPage;
import com.alerehealth.ui.portal.usermenu.phr.PHRHealthRecordPage;
import com.alerehealth.ui.portal.wba.entities.WBAConstants;
import com.alerehealth.ui.portal.wba.pages.WBAHomePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PortalHomePage extends PortalBasePage<PortalHomePage> {
	
    @FindBy(className = "nav-list")
    protected WebElement navigationMenu;

    @FindBy(xpath = "//a[contains(@class,'tile tile--combo')]")
    private List<WebElement> contentCards;

    @FindAll({
    	@FindBy(xpath = "//a[contains(@class,'user--name')]"),
    	@FindBy(xpath = "//a[contains(@class,'has-notification-count dropbtn')]")
        })
    	private WebElement userMenu;

    @FindBy(xpath= "//a[contains(@class,'logo') and contains(@class,'header')]")
	protected WebElement clientLogo;

    private String LinkFromDropDown = "//li[contains(@class,'is-open')]//span[contains(text(),'XXXX')]";
	
	 @FindBy(xpath = "//span[@class='btn pull-right']")
	 private List<WebElement> statusLinks;

	 @FindBy(xpath = "//span[@class='points']")
	 private WebElement creditScore;

	@FindBy(xpath = "//div[contains(@class,'dpl-hero-container')]//h2[@class='h2']")
	private WebElement enrollmentText;
	

	String[] resultDB = null;
	
	String[] resultDB1 = null;
	
	String programStatus = null;
	
	String participantAnswer = null;

	public String getHeroBannerTitle() {

		return enrollmentText.getText().trim();
	}



	public void clickOnUserName(){

		userMenu.click();

		waitForComponentTobDisplayed(By.xpath("//li[contains(@class,'ogn-header-link-list__account') and not(contains(@class,'mobile'))]//ul[contains(@class,'menu-items account-items')]"));

	}

	public void clickOnUserNameMenuItem(String menuItem){

		clickOnUserName();

		String xpath = "//li[contains(@class,'ogn-header-link-list__account') and not(contains(@class,'mobile'))]//ul[contains(@class,'menu-items account-items')]"+"//a[text()='"+menuItem+"']";

//		String xpath = "//li[contains(@class,'ogn-header-link-list__account') and not(contains(@class,'mobile'))]//ul[contains(@class,'menu-items account-items')]//a[text()='"+menuItem+"']";
		
		getWebDriver().findElement(By.xpath(xpath)).click();

	}


	private void clickMenu(String menu){

		String menuXpath = "//span[@class='nav-link--text-container' and contains(text(),'"+menu+"')]/..";//..//ul[@aria-hidden='false']
		
		WebElement e = getWebDriver().findElement(By.xpath(menuXpath));
		javaScriptClick(e);

		String xpathOfSubMenu = "//span[@class='nav-link--text-container' and contains(text(),'"+menu+"')]/../..//ul[@aria-hidden='false']";

		waitForComponentTobDisplayed(By.xpath(xpathOfSubMenu));

	}

	private void clickMenuItem(String menuItem){

		String menuItemXpath = "//ul[@class='nav-sublist' and @aria-hidden='false']//span[@class='nav-sublink--text-container' and contains(text(),'"+menuItem+"')]/..";
	
//		getWebDriver().findElement(By.xpath(menuItemXpath)).click();

		WebElement e = getWebDriver().findElement(By.xpath(menuItemXpath));
		javaScriptClick(e);

	}


	public void navigateInTopMenu(String navigation){

		String [] menus = navigation.split(">");

		clickMenu(menus[0]);

		if(menus.length>2){

			for(int i =1; i<= menus.length-1; i++){

				clickMenuItem(menus[1]);

			}


			clickSubMenuItem(menus[menus.length-1]);

		}else{

			clickMenuItem(menus[1]);

		}


	}

	private void clickSubMenuItem(String subMenuItem){

		String menuItemXpath = "//span[@class='nav-sublink--text-container' and contains(text(),'"+subMenuItem+"')]/..";

		getWebDriver().findElement(By.xpath(menuItemXpath)).click();

	}


    public WBAHomePage clickOnHealthRiskQuestionnaireContentCard() throws Exception{

    	try{
       
    		clickContentCard(ClientConfiguration.getClientConfiguration().getWBAName());

            return new WBAHomePage();
    	}
    	catch(Exception e){
    		
    		String MainDropDownXpath = "//ul[@class='nav-list']//span[contains(text(),'Progress')]";
    		
    		WebElement DropDown = getWebDriver().findElement(By.xpath(MainDropDownXpath));
    		
    		waitForElementToBeEnabled(DropDown);
    		
    		javaScriptClick(DropDown);
    		
    		clickOnHRQLinkFromDropDown();
    		
    		return new WBAHomePage();
    	}

    }
    

    public boolean isHealthRiskQuestionnaireContentCardDisplayinHomePage(String imageCard){
    	
    	List<WebElement> list = getWebDriver().findElements(By.xpath("//a[contains(@class,'tile tile--combo')]//div[@class='tile-content']//h2[contains(text(),'"+imageCard+"')]"));
    	return list.size()>0 ? true : false;
    	
    }

	public void clickSignOut(){
		clickOnUserName();

		clickOnUserNameMenuItem("Sign Out");
		
		waitForSpecifiedTime(5);

	}



    /*
     * clickDropDownfromTopNavigation() : Clicks the Top Navigation
     * argument : Name of the topNav 
     */
    public void clickDropDownfromTopNavigation(String topNav) throws Exception{
    	Thread.sleep(3000);
    	String MainDropDownXpath = "//ul[@class='nav-list']//span[contains(text(),'"+topNav+"')]";
		WebElement DropDown = getWebDriver().findElement(By.xpath(MainDropDownXpath));
		waitForElementToBeEnabled(DropDown);
		
		javaScriptClick(DropDown);
	}
    /*
     * clickOnCreditsLinkFromDropDown() : clicks on the creditsLinkFromDropDown
     * returns new Object of CreditsPage()
     */
    public CreditPage clickOnCreditsLinkFromDropDown() throws Exception{
		
    	String xpath = "//li[contains(@class,'is-open')]//span[contains(text(),'"+ClientConfiguration.getClientConfiguration().getCredits()+"')]";
		WebElement LinkFmDropDown = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeEnabled(LinkFmDropDown);
		javaScriptClick(LinkFmDropDown);
		LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getWBAName()+" link from drop down");
		return new CreditPage();
	}
    
    /*
     * clickOnHRQLinkFromDropDown() : clicks on the HealthRiskQuestionaire link (it gets the questionaire name from Client property file)
     * returns new Object of WBAHomePage()
     */
    
    public WBAHomePage clickOnHRQLinkFromDropDown() throws Exception{
    	
    	String xpath = "//li[contains(@class,'is-open')]//span[contains(text(),'"+ClientConfiguration.getClientConfiguration().getWBAName()+"')]";
		WebElement LinkFmDropDown = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeEnabled(LinkFmDropDown);
		javaScriptClick(LinkFmDropDown);
		LoggerUtils.info("Clicking "+ClientConfiguration.getClientConfiguration().getWBAName()+" link from drop down");
		return new WBAHomePage();
		
    	
    }
    
    public void clickOnDropDownAndLink(String dropDn,String Link) throws Exception{
    	
    	clickDropDownfromTopNavigation(dropDn);
    	LoggerUtils.info("Clicking on "+dropDn+" from Top nav");
    	WebElement LinkFmDropDown = getWebElementWithDynamicXpath(LinkFromDropDown,Link);
    	waitForElementToBeEnabled(LinkFmDropDown);
    	javaScriptClick(LinkFmDropDown);
		LoggerUtils.info("Clicking "+Link+" link from "+dropDn+" drop down");
		
    }
    @Override
    public boolean isDisplayed() {
       return navigationMenu.isDisplayed();
    }
    
    public WBAHomePage verifyClickCardButtonText(String buttonNm) {
		
		String xpath = "//div[@class='tile-content']//span[2][contains(text(),'"+buttonNm+"')]";
    	
		getWebDriver().findElement(By.xpath(xpath)).click();
    	
		return new WBAHomePage();
	}
    
   public boolean getCardButtonText(String buttonNm) {
		
		String xpath = "//div[@class='tile-content']//span[2][contains(text(),'"+buttonNm+"')]";
    	
		return getWebDriver().findElement(By.xpath(xpath)).isDisplayed();  	
		
	}
    
    /*
     * clientLogo method will click on ClientLogo and navigate to home page
     */
   public void clientLogo() throws Exception{
        
	   //getWebDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   Thread.sleep(3000);
    	
	   WebElement HnetLogo = getWebDriver().findElement(By.xpath("//a[@class='logo--optum-header']"));
    	
	   HnetLogo.click();
 
    }
   
   public CreditPage clickRewardsSubDropDown(String arg1){
	   
	   String xpath = "//ul[@class='nav-list']/li[3]//ul[@class='nav-sublist']//*[contains(text(),'"+arg1+"')]";
	   Assert.assertEquals(arg1, getWebDriver().findElement(By.xpath(xpath)).getText());
	   getWebDriver().findElement(By.xpath(xpath)).click();
   	   LoggerUtils.info("Verified "+arg1+"under rewards dropdown and clicked " +getWebDriver().findElement(By.xpath(xpath)).getText());
   	   return new CreditPage();
	   
   }
   
   public boolean verifyContentCardLinks(String statuslink) throws InterruptedException{
		
		getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	    for(WebElement stlink : statusLinks){

	         {
	           
	            String stlinkTitle = stlink.getText();

	            if(stlinkTitle.contains(statuslink)){

	            	stlink.isDisplayed();
	                return true;

	                
	            }
	        }

	    }
		return false;


	}
    
   
   public void clickOnLink(String arg1)
   {
   	getWebDriver().findElement(By.partialLinkText(arg1)).click();
   	//getWebDriver().findElement(By.linkText(arg1)).click();
   	
   }
   
   public boolean verifyButtonvisibile(String arg1)
   {
    	try
    	{
    		String xpath = "//button[text()='" + arg1 + "']|//button[text()='" + arg1.toUpperCase() + "']";	
    		getWebDriver().findElement(By.xpath(xpath)).isDisplayed();
    		LoggerUtils.info("Verified the  button name "+getWebDriver().findElement(By.xpath(xpath)).getText());
        	
    	}
    	catch(StaleElementReferenceException e)
    	{
    		String xpath = "//button[text()='" + arg1 + "']|//button[text()='" + arg1.toUpperCase() + "']";
    		getWebDriver().findElement(By.xpath(xpath)).isDisplayed();
    		LoggerUtils.info("Verified the  button name "+getWebDriver().findElement(By.xpath(xpath)).getText());
        	
    	}
    	catch(Exception e)
    	{
    		return false ;
    	}
		return true;
    	
    	
}
   public String getCreditScore()
   {
	  waitForElementToBeDisplayed(creditScore); 
	   return creditScore.getText();
   }
   public CreditPage clickOnHistoryLinkFromDropDown(){
		
   	String xpath = "//li[contains(@class,'is-open')]//span[contains(text(),'"+ClientConfiguration.getClientConfiguration().getHistory()+"')]";
		WebElement LinkFmDropDown = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeEnabled(LinkFmDropDown);
		javaScriptClick(LinkFmDropDown);
		
		return new CreditPage();
	}


	public PortalHomePage clickClientLogo(){

   		clientLogo.click();

   		return new PortalHomePage();

	}

	public PHRHealthRecordPage openHealthRecordOfUser()
	{
		clickOnUserNameMenuItem("Health Record");

		return new PHRHealthRecordPage();
	}

	public ChallengesBasePage navigateToChallengesPage(){

		String navigation = ClientConfiguration.getClientConfiguration().getChallengesNavigation();

		navigateInTopMenu(navigation);

		return new ChallengesBasePage();

	}

	public com.alerehealth.ui.portal.rewards.CreditPage openCreditPage(){

		String navigation = ClientConfiguration.getClientConfiguration().getCreditsPageNavigation();

		navigateInTopMenu(navigation);

		return new com.alerehealth.ui.portal.rewards.CreditPage();

	}

	public TrackersBasePage openTrackersPage(){

		String navigation = ClientConfiguration.getClientConfiguration().getTrackesPageNavigation();

		navigateInTopMenu(navigation);

		return new TrackersBasePage();

	}


	public ActionPlanQuestionnairePage clickOnHeroBanner(){

		String xpath = "//div[contains(@class,'dpl-hero-container')]//div[contains(@class,'btn--groups')]/*";

		getWebDriver().findElement(By.xpath(xpath)).click();

		return new ActionPlanQuestionnairePage();

	}

	public WellnessPage clickOnWellnessCoachingContentCard(){

		clickContentCard(WBAConstants.WELLNESS_COACHING_CONTENT_CARD_TITLE);

		return new WellnessPage();

	}

	public AvailableChallengesPage clickOnChallengesContentCard(){

		clickContentCard(WBAConstants.CHALLENGES_CONTENT_CARD_TITLE);

		return new AvailableChallengesPage();
	}

	public void clickContentCard(String contentCardTitle){

		String contentCardTitles[] = contentCardTitle.split("\\|\\|");

		boolean isContentCardMatched = false;

		for(WebElement contentCard : contentCards){

			{
				WebElement title = contentCard.findElement(By.xpath(".//*[@class='header']"));

				String contentCardTitleContent = title.getText();

				for(String contentcardTitle: contentCardTitles){

					if(contentCardTitleContent.contains(contentcardTitle)){

						contentCard.click();

						isContentCardMatched = true;

						break;
					}
				}

				if(isContentCardMatched){

					break;
				}

			}

		}


	}

	public void clickLinkInMemberResourceCenterBulletinBoard(String link){

		String xpath ="//div[contains(@class,'bboard')]//a[contains(text(),'"+link+"')]";

		getWebDriver().findElement(By.xpath(xpath)).click();

	}


	public CreditPage clickFeedbackSurveyInMRCBulletinBoard(){

		clickLinkInMemberResourceCenterBulletinBoard("Feedback Survey");

		return new CreditPage();

	}

	public MemberResourceCenterBasePage clickViewAllInMRCBulletinBoard(){

		clickLinkInMemberResourceCenterBulletinBoard("View All");

		return new MemberResourceCenterBasePage();
	}

	public NurseAdviceLinePage navigateToNurseAdviceLinePage(){

		String navigation = ClientConfiguration.getClientConfiguration().getNurseAdviceLineNavigation();

		navigateInTopMenu(navigation);

		return new NurseAdviceLinePage();

	}
	public ActivityFeedPage openActivityFeed(){

		String navigation = ClientConfiguration.getClientConfiguration().getActivityFeedPageNavigation();

		navigateInTopMenu(navigation);

		return new ActivityFeedPage();

	}

	public List<String> getMenuItemsUnderMenu(String menu)
	{

		clickMenu(menu);

		String xpath = "//ul[@class='nav-sublist' and @aria-hidden='false']//span[@class='nav-sublink--text-container']";

		List<WebElement> allmenus = getWebDriver().findElements(By.xpath(xpath));

		List<String> subMenuText=new ArrayList<String>();

		allmenus.forEach(menuEle ->subMenuText.add(menuEle.getText().trim()) );

		return subMenuText;
	}




	public LibraryPage navigateToWellnessUnderLibrary(){

		String navigation = ClientConfiguration.getClientConfiguration().getLibraryWellnessNavigation();

		return navigateToLibraryPages(navigation);

	}

	public LibraryPage navigateToConditionsUnderLibrary(){

		String navigation = ClientConfiguration.getClientConfiguration().getLibraryConditionsNavigation();

		return navigateToLibraryPages(navigation);

	}

	public LibraryPage navigateToTobaccoFreeUnderLibrary(){

		String navigation = ClientConfiguration.getClientConfiguration().getLibraryTobaccoFreeNavigation();

		return navigateToLibraryPages(navigation);

	}

	public LibraryPage navigateToPregnancyAndBabyUnderLibrary(){

		String navigation = ClientConfiguration.getClientConfiguration().getLibraryPregnancyAndBabyNavigation();

		return navigateToLibraryPages(navigation);

	}

	private LibraryPage navigateToLibraryPages(String navigation){

		navigateInTopMenu(navigation);
		return new LibraryPage();

	}

	
	public ActionPlanQuestionnaireStartingPage openActionPlan(){

        String navigation = ClientConfiguration.getClientConfiguration().getActionPlanNavigation();

        navigateInTopMenu(navigation);

		return new ActionPlanQuestionnaireStartingPage();

	}
	
	public ManageGoalsPage navigateToManageGoals(){

		navigateInTopMenu("Health Promotion Programs>Manage Goals");

		return new ManageGoalsPage();

	}

	public ActionPlanBannerPage openActiveGoals(){

		String navigation = ClientConfiguration.getClientConfiguration().getActionPlanNavigation();

		navigateInTopMenu(navigation);
		return new ActionPlanBannerPage();

	}
	
	public SettingsBasePage clickSettingsOfUser(){

		clickOnUserNameMenuItem("Settings");

		return new SettingsBasePage();


	}

	public WellnessPage openCoachingWellness(){

		navigateInTopMenu("Coaching>Wellness");

		return new WellnessPage();

	}

	public SearchandBrowselinkPage openLibraryBrowse(){

		navigateInTopMenu("Library>Search & Browse");

		return new SearchandBrowselinkPage();

	}

	public NurseAdviceLinePage openNurseAdviceLineFromZone3(){

		clickTileFromZone3(Zone3Constants.NurseAdviceLine.toString());

		return new NurseAdviceLinePage();

	}

	private void clickTileFromZone3(String title){

		String xpath = "//div[@data-ng-controller='HomepageTier3Ctrl']//*[contains(@class,'header') and text()='"+title+"']/ancestor::a[contains(@class,'tile--bug')]";

		getWebDriver().findElement(By.xpath(xpath)).click();

	}

	public int getCareReminderNotificationCount(){

		int notificationCount = 0;

		String xpath = "//a[contains(@href,'CareAlerts')]/following-sibling::span[@class='notification-count']";
		try{

			WebElement careReminderNotificationCount = getWebDriver().findElement(By.xpath(xpath));


			String txtCount1 = careReminderNotificationCount.getText();
			notificationCount = Integer.parseInt(txtCount1.trim());
			System.out.println("Care Reminders notification Count:" + notificationCount);

		}

		catch(NoSuchElementException e){


		}

		return notificationCount;
	}

	public CareReminderPage openCareReminders(){

		clickOnUserNameMenuItem("Care Reminders");

		return new CareReminderPage();
	}

	public MessagesPage openMessages(){

		clickOnUserNameMenuItem("Messages");

		return new MessagesPage();
	}
	
	
	public AvailableChallengesPage clickJoinChallengeContentCard(){
		
		String xpath = "//span[contains(text(),'Join Challenge')] ";
		WebElement joinChallengeLink = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(joinChallengeLink);
		
		return new AvailableChallengesPage();
	}

        public HistoryPage openHistoryPage(){

		String navigation = ClientConfiguration.getClientConfiguration().getHistoryPageNavigation();

		navigateInTopMenu(navigation);

		return new HistoryPage();

	}
	
	public void clickOnFooterItems(String Item){
	     
	     String xpath = "//div[@class ='legal-bar']//a[contains(text(), '"+Item+"')]";
	     
	     WebElement element = getWebDriver().findElement(By.xpath(xpath));
	     
	     element.click();
	     
	     waitForSpecifiedTime(5);
   }
	
	//anchor tag for Help and span tag for Credits
	public void clickOnHelpOrCredits(String tagValue,String link){
		

		String id = "";
    	tagValue = tagValue.toUpperCase(); 
    	
    	switch(tagValue){
    	
    	case "HELP": {id = "a"; 
    	               break;}
    	case "CREDITS": {id = "span"; 
                      break;}
    	
    	}
		
		String xpath = "//ul[@class='ogn__header-link-list dropdown']//li//"+id+"[contains(text(),'"+link+"')]";
		WebElement attributeValue = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(attributeValue);
		javaScriptClick(attributeValue);
		
	}
	
	public String getParticipantIdForLoggedInUser()
	{
	return getWebDriver().findElement(By.xpath("//a[@class='js-profile']")).getAttribute("data-pid");
	}
	
	  public String validateProgramStatusFromDB() throws Throwable{
		  
		 String  pdashid = getParticipantIdForLoggedInUser();
		 
		 System.out.println(pdashid);
		 
		 String dbQuery = "select PRIMARYPROGRAMID from participant_program where participantid='"+pdashid+"'";
		 //System.out.println(dbQuery);
	    	 
   	   ConnectionManager.getPRPCDBConnection();
   	    
   	    resultDB = DBDataFetcher.getRowDataForQueryFromPRPCDB(dbQuery);
   	  
   	 
   	    for(int i=0; i< resultDB.length ; i++){
   	    	
   	    	programStatus = resultDB[i];
   	    	System.out.println("programStatus value from DB is " + programStatus);
   	    }
   	    
   		JDBCConnector.closeConnection();	
   		
   		return programStatus;
	
	  }
	  
	  
	  public String validateParticipantAnswerFromDB() throws Throwable{
		  
			 String  pdashid = getParticipantIdForLoggedInUser();
			 
			 System.out.println(pdashid);
			 
			 String dbQuery1 = "select answer from participant_program where participantid='"+pdashid+"'";
			 System.out.println(dbQuery1);
		    	 
	   	   ConnectionManager.getPRPCDBConnection();
	   	    
	   	    resultDB1 = DBDataFetcher.getRowDataForQueryFromPRPCDB(dbQuery1);
	   	  
	   	 
	   	    for(int i=0; i< resultDB1.length ; i++){
	   	    	
	   	    	participantAnswer = resultDB1[i];
	   	    	System.out.println("Participant answer value from DB is " + participantAnswer);
	   	    }
	   	    
	   		JDBCConnector.closeConnection();	
	   		
	   		return participantAnswer;
		
		  }
		  
	  
	  public TermsOfUsePage clickFooterTerms(){
		  
		  clickOnFooterItems("Terms");
		  
		  return new TermsOfUsePage();
	  }
	  
   public PrivacyPolicyPage clickFooterPrivacy(){
		  
		  clickOnFooterItems("Privacy");
		  
		  return new PrivacyPolicyPage();
	  }


}
