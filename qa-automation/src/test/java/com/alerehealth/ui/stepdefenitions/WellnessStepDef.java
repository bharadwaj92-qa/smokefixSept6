package com.alerehealth.ui.stepdefenitions;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.common.ClientConfiguration;
import com.alerehealth.fwk.excel.ExcelReader;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnaireStartingPage;
import com.alerehealth.ui.portal.actionplan.ActionPlanSetYourGoal;
import com.alerehealth.ui.portal.actionplan.GoalDeadLineSelectionPage;
import com.alerehealth.ui.portal.actionplan.GoalSetUpPage;
import com.alerehealth.ui.portal.actionplan.GoalSetupSuccessPage;
import com.alerehealth.ui.portal.actionplan.GoalsHomePage;
import com.alerehealth.ui.portal.coaching.MessageCenterPage;
import com.alerehealth.ui.portal.coaching.WellnessPage;
import com.alerehealth.ui.portal.coaching.WellnessPageConstants;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WellnessStepDef {
	
	
	PortalHomePage portalHomepage=null;
	WellnessPage wellnessPage = null;
	ActionPlanQuestionnaireStartingPage  actionPlanQuestionnaireStartingPage = null;
	ActionPlanQuestionnairePage questionnairePage=null;
	ExcelReader excelReader=null;
	GoalsHomePage goalsHomePage=null;
	ActionPlanSetYourGoal actionPlanSetYourGoal=null;
	GoalDeadLineSelectionPage goalDeadLineSelectionPage=null;
	GoalSetUpPage goalSetUpPage=null;
	GoalSetupSuccessPage goalSetupSuccessPage=null;
	MessageCenterPage messageCenterPage = null;
	String wellnessTitleInUI;
	String wellnessContentInUI;
	String contentQFLInUI;
	String contentWellnessInUI;
	String thumbnailCreditQFLInUI;
	String thumbnailCreditWellnessInUI;
	String thumbnailLinkQFLInUI;
	String thumbnailLinkWellnessInUI;
	String messageCenterTitleInUI;
	String secureMsgTitleInUI;
	String secureMsgContentInUI;
	String secureMsgButtonInUI;
	String moblieTextInUI;
	String coachingCallsTitleInUI;
	String hoverTxtINUI;
	List<String> coachingMenuItemsFromUI;
	List<String> coachingMenuItemsExpected;
	
	
	String dateToEnter = DateTimeUtils.getFutureDate("MM/dd/YYYY",10);

	@When("^User Navigates to Coaching page and validating the sub menu$")
	public void user_Navigates_to_Coaching_page_and_validating_the_sub_menu() throws Throwable {
	  
		portalHomepage = WBAQuestionnaireStepsDefinition.portalHomePage;
        
		 coachingMenuItemsFromUI = portalHomepage.getMenuItemsUnderMenu("Coaching");

         coachingMenuItemsExpected = ClientConfiguration.getClientConfiguration().getCoachingMenuItems();

        Assert.assertTrue("Coaching menu from UI matches with expected", coachingMenuItemsExpected.containsAll(coachingMenuItemsFromUI));
	}

	
	@Then("^User Click on Wellness tab it should navigate to Wellness Page$")
	public void user_Click_on_Wellness_tab_it_should_navigate_to_Wellness_Page() throws Throwable {
		
		
		 wellnessPage =  portalHomepage.openCoachingWellness();
		 Assert.assertTrue("Wellness page is displayed", wellnessPage.isDisplayed());
	}
	
	@Then("^User should be able to see appropriate title and content$")
	public void user_should_be_able_to_see_appropriate_title_and_content() throws Throwable {
	   
		
		wellnessTitleInUI = wellnessPage.getTitle();
		
		Assert.assertTrue("Wellness page title is as expected",wellnessTitleInUI.contains(WellnessPageConstants.WELLNESS_PAGE_TITLE));
		
		wellnessContentInUI = wellnessPage.getContent();
		
		Assert.assertTrue("Wellness page content is as expected",wellnessContentInUI.contains(WellnessPageConstants.WELLNESS_PAGE_CONTENT));
        
	}
	
	@Then("^User should be able to see Thumbnail image$")
	public void user_should_be_able_to_see_Thumbnail_image() throws Throwable {
	    
		Assert.assertTrue("Thumbnail image displayed",wellnessPage.isThumbnailImageDisplayed("Wellness Health Coaching"));
	}
	
	
	@Then("^User should be able to see appropriate content, credits ,start Today link below Thumbnail image$")
	public void user_should_be_able_to_see_appropriate_content_credits_start_Today_link_below_Thumbnail_image() throws Throwable {
	   
	    contentWellnessInUI=wellnessPage.getThumbnailsContent("Wellness Health Coaching");
		
		Assert.assertTrue("Wellness page content for Wellness Health Coaching is as expected",contentWellnessInUI.contains(WellnessPageConstants.WELLNESS_HEALTH_COACHING_CONTENT));
		
		thumbnailCreditWellnessInUI=wellnessPage.getThumbnailsCreditAndLink("Wellness Health Coaching","Credit");
		
		Assert.assertTrue("Wellness page credit for Wellness Health Coaching is as expected",thumbnailCreditWellnessInUI.contains(WellnessPageConstants.WELLNESS_PAGE_THUMBNAIL_CREDIT));
		
        thumbnailLinkWellnessInUI=wellnessPage.getThumbnailsCreditAndLink("Wellness Health Coaching","Link");
		
		Assert.assertTrue("Wellness page Start Today link for Wellness Health Coaching is as expected",thumbnailLinkWellnessInUI.contains(WellnessPageConstants.WELLNESS_PAGE_THUMBNAIL_LINK));
		
		 contentWellnessInUI=wellnessPage.getThumbnailsContent("Quit For Life");
			
			Assert.assertTrue("Wellness page content for Quit For Life is as expected",contentWellnessInUI.contains(WellnessPageConstants.WELLNESS_QFL_CONTENT));
			
			thumbnailCreditWellnessInUI=wellnessPage.getThumbnailsCreditAndLink("Quit For Life","Credit");
			
			Assert.assertTrue("Wellness page credit for Quit For Life is as expected",thumbnailCreditWellnessInUI.contains(WellnessPageConstants.WELLNESS_PAGE_THUMBNAIL_CREDIT));
			
	        thumbnailLinkWellnessInUI=wellnessPage.getThumbnailsCreditAndLink("Quit For Life","Link");
			
			Assert.assertTrue("Wellness page Start Today link for Quit For Life is as expected",thumbnailLinkWellnessInUI.contains(WellnessPageConstants.WELLNESS_PAGE_THUMBNAIL_LINK));
	}


	@Then("^User Click on Start Today Link navigating to ActionPlan page$")
	public void user_Click_on_Start_Today_Link_navigating_to_ActionPlan_page() throws Throwable {
	    
		actionPlanQuestionnaireStartingPage = wellnessPage.clickStartTodayLink("Wellness Health Coaching");
		
		Assert.assertTrue(actionPlanQuestionnaireStartingPage.isDisplayed());

	}
	
	@Then("^User completing mini assessment setting the goal and navigating to wellness page$")
	public void user_completing_mini_assessment_setting_the_goal_and_navigating_to_wellness_page(DataTable arg1) throws Throwable{
	  
		 Map dataMap = (Map) arg1.asMap(String.class, String.class);

	        String Communication = (String) dataMap.get("communication");
	        String TimeZone = (String) dataMap.get("timezone");
	        String Email = (String) dataMap.get("email");
	        String PrimaryPhone = (String) dataMap.get("primaryphone");
	        String PrimaryPhoneType = (String) dataMap.get("primaryphonetype");
	        String ToCallOnPrimaryPhone = (String) dataMap.get("tocallon");
	        String WhenToCall = (String) dataMap.get("whentocall");
	        String PreferredLanguage = (String) dataMap.get("preferredlanguage");
	       
		   questionnairePage = actionPlanQuestionnaireStartingPage.startActionPlan();
			
	       excelReader = new ExcelReader("Smoke_ActionPlan_Questionaire.xlsx","Wellness_Regression");
			
			excelReader.setStartRow(1);

	        goalsHomePage = questionnairePage.answerActionPlanQuestionsFromExcel(excelReader);
	        
	        actionPlanSetYourGoal = goalsHomePage.clickAddCoachButton("Healthy Weight");
	        
	        actionPlanSetYourGoal.selectGoal("Lose Weight");
	        
	        goalDeadLineSelectionPage = actionPlanSetYourGoal.clickContinueButton();
	        
	        goalDeadLineSelectionPage.setGoalAchievementDate(dateToEnter);
	        
	        goalSetUpPage = goalDeadLineSelectionPage.clickContinueButton();

	        goalSetUpPage.selectWorkBookCommunication(Communication);

	        goalSetUpPage.selectTimeZone(TimeZone);

	        goalSetUpPage.setEmail(Email);

	        goalSetUpPage.setPrimaryPhone(PrimaryPhone);

	        goalSetUpPage.setPrimaryPhoneType(PrimaryPhoneType);

	        goalSetUpPage.selectPreferedDayToCallOnPrimaryPhone(ToCallOnPrimaryPhone);

	        goalSetUpPage.selectWhenToCall(WhenToCall);

	        goalSetUpPage.selectPreferredLanguage(PreferredLanguage);
	        
        goalSetupSuccessPage = goalSetUpPage.clickContinueButton();
        
        wellnessPage = goalSetupSuccessPage.navigateCoachingToWellness();
        
 
	}
	
	
	@Then("^User should be able to see Wellness page updated content below Thumbnail Image$")
	public void user_should_be_able_to_see_Wellness_page_updated_content_below_Thumbnail_Image() throws Throwable {
	   
		Assert.assertTrue("Thumbnail image displayed",wellnessPage.isThumbnailImageDisplayed("Wellness Health Coaching"));
		
		contentWellnessInUI=wellnessPage.getThumbnailsContent("Wellness Health Coaching");
		
		Assert.assertTrue("Wellness page content for Wellness Health Coaching is as expected",contentWellnessInUI.contains(WellnessPageConstants.WELLNESS_HEALTH_COACHING_UPDATED_CONTENT));
		
		thumbnailCreditWellnessInUI=wellnessPage.getThumbnailsCreditAndLink("Wellness Health Coaching","Credit");
		
		Assert.assertTrue("Wellness page credit for Wellness Health Coaching is as expected",thumbnailCreditWellnessInUI.contains(WellnessPageConstants.WELLNESS_PAGE_THUMBNAIL_CREDIT));
		
		String moblieTextInUI = wellnessPage.isMobileNumberDisplayed();
				
	    Assert.assertTrue("Start Today Link is updated by Mobile number ", moblieTextInUI.equals(WellnessPageConstants.WELLNESS_PAGE_MOBILENUMBER));
	}

	@Then("^User should be able to see Coaching calls Title and Progress bar$")
	public void user_should_be_able_to_see_Coaching_calls_Title_and_Progress_bar() throws Throwable {
	  
       coachingCallsTitleInUI = wellnessPage.getCoachingCallTitle();
		
		Assert.assertTrue("Coaching Calls title should be displayed ", coachingCallsTitleInUI.equals(WellnessPageConstants.WELLNESS_COACHING_CALL_TITLE));
		
		Assert.assertTrue("Coaching Calls Progress Bar displayed",wellnessPage.isProgressBarDisplayed());
	}

	@Then("^content should be displayed when we hover on Question mark symbol$")
	public void content_should_be_displayed_when_we_hover_on_Question_mark_symbol() throws Throwable {
	 
		
	    hoverTxtINUI = wellnessPage.getTooltip();

		Assert.assertTrue("Text is displayed when we hover on Question mark symbol ", hoverTxtINUI.equals(WellnessPageConstants.WELLNESS_PAGE_HOVER_QUESTIONMARK));
	}

	
	@Then("^User should validate the Secure Message section$")
	public void user_should_validate_the_Secure_Message_section() throws Throwable {

		secureMsgTitleInUI = wellnessPage.getSecureSectionTitle("Secure Messages");
		 Assert.assertTrue("Secure Message section title is displayed ", secureMsgTitleInUI.equals(WellnessPageConstants.WELLNESS_SECURE_MESSAGE_TITLE));
		secureMsgContentInUI = wellnessPage.getSecureSectionContentAndButton("Secure Messages","Content");
		 Assert.assertTrue("Secure Message section content is displayed ", secureMsgContentInUI.equals(WellnessPageConstants.WELLNESS_SECURE_MESSAGE_CONTENT));
		secureMsgButtonInUI = wellnessPage.getSecureSectionContentAndButton("Secure Messages","Button");
		Assert.assertTrue("Secure Message section button is displayed ", secureMsgButtonInUI.equals(WellnessPageConstants.WELLNESS_SECURE_MESSAGE_BUTTON));
		Assert.assertTrue("Message Center Thumbnail image is displayed",wellnessPage.isMessageThumbnailDisplayed());
	}
	

	@Then("^Message Center page should be displayed when User click on Go to Messages$")
	public void message_Center_page_should_be_displayed_when_User_click_on_Go_to_Messages() throws Throwable {
	   
		messageCenterPage = wellnessPage.clickGoToMessages();
		Assert.assertTrue("Message Center page should be displayed",messageCenterPage.isDisplayed());
		messageCenterTitleInUI = messageCenterPage.getMessageCenterTitle();
		Assert.assertTrue("Message Center Title is displayed", messageCenterTitleInUI.equals(WellnessPageConstants.WELLNESS_MESSAGECENTER));
		
	}




}
