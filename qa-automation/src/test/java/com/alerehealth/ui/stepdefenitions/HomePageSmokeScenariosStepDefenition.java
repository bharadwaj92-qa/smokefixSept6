package com.alerehealth.ui.stepdefenitions;

import com.alerehealth.fwk.common.Constants;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnairePage;
import com.alerehealth.ui.portal.coaching.Nurse24ChatWindowPage;
import com.alerehealth.ui.portal.coaching.NurseAdviceLinePage;
import com.alerehealth.ui.portal.coaching.WellnessPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.community.ActivityFeedPage;
import com.alerehealth.ui.portal.community.CommunityNotificationsPage;
import com.alerehealth.ui.portal.community.ForumPage;
import com.alerehealth.ui.portal.library.LibraryConstants;
import com.alerehealth.ui.portal.library.LibraryPage;
import com.alerehealth.ui.portal.memberrescenter.MemberResourceCenterBasePage;
import com.alerehealth.ui.portal.progress.challenges.AvailableChallengesPage;
import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;
import com.alerehealth.ui.portal.rewards.CreditPage;
import com.alerehealth.ui.portal.usermenu.MessagesPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HomePageSmokeScenariosStepDefenition {

    String userName;
    PortalLoginPage portalLoginPage=null;
    PortalHomePage portalhomepage=null;
    NurseAdviceLinePage nurseAdviceLinePage=null;
    Nurse24ChatWindowPage nurse24ChatWindowPage=null;
    MessagesPage messagesPage=null;
    ActivityFeedPage activityFeedPage=null;
    ForumPage forumPage=null;
    CommunityNotificationsPage communityNotificationsPage=null;
    LibraryPage libraryPage = null;
    @When("^User navigate to Questionariespart$")
    public void user_navigate_to_Questionariespart() throws Throwable {

        userName = WBAQuestionnaireStepsDefinition.portalUserName;
        portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;

        ActionPlanQuestionnairePage actionPlanQuestionairePage = portalhomepage.clickOnHeroBanner();

        Assert.assertTrue("Action plan questionnaire page is displayed", actionPlanQuestionairePage.isDisplayed());

        portalhomepage = actionPlanQuestionairePage.clickClientLogo();
    }

    @Then("^Validate the zone pages navigation$")
    public void validate_the_zone_pages_navigation() throws Throwable {


        WellnessPage wellnessPage = portalhomepage.clickOnWellnessCoachingContentCard();

        Assert.assertTrue("Wellness page is displayed", wellnessPage.isDisplayed());

        portalhomepage = wellnessPage.clickClientLogo();

        AvailableChallengesPage availableChallengesPage = portalhomepage.clickOnChallengesContentCard();

        Assert.assertTrue("Challenges page is displayed", availableChallengesPage.isDisplayed());

        portalhomepage = availableChallengesPage.clickClientLogo();

        CreditPage creditPage = portalhomepage.clickFeedbackSurveyInMRCBulletinBoard();

        Assert.assertTrue("Credit page is displayed", creditPage.isDisplayed());

        portalhomepage = creditPage.clickClientLogo();

        MemberResourceCenterBasePage mrcPage = portalhomepage.clickViewAllInMRCBulletinBoard();

        Assert.assertTrue("Member resource center page is displayed", mrcPage.isDisplayed());

    }




    @When("^i navigates to NurseAdviceLine from Coaching$")
    public void i_navigates_to_NurseAdviceLine_from_Coaching() throws Throwable {
        userName = WBAQuestionnaireStepsDefinition.portalUserName;

        portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;

        nurseAdviceLinePage = portalhomepage.navigateToNurseAdviceLinePage();
    }

    @When("^i Validate Nurse chat window and close chat window$")
    public void i_Validate_Nurse_chat_window_and_close_chat_window() throws Throwable {

        nurse24ChatWindowPage = nurseAdviceLinePage.clickStartChat();

        nurse24ChatWindowPage.closeChatWindow();
    }

    @Then("^i Switching back to NurseAdviceLinePage and validate MessageCenter Link$")
    public void i_Switching_back_to_NurseAdviceLinePage_and_validate_MessageCenter_Link() throws Throwable {

        nurseAdviceLinePage.switchBackToNurseAdviceLinePage();

        messagesPage = nurseAdviceLinePage.openMessageCenter();
    }


    @When("^i navigates to Community AcitivityFeed page and validate$")
    public void i_navigates_to_Community_AcitivityFeed_page_and_validate() throws Throwable {

        userName = WBAQuestionnaireStepsDefinition.portalUserName;
        portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;

        activityFeedPage = portalhomepage.openActivityFeed();

        activityFeedPage.clickTab(Constants.ACTIVITY_FEED_TAB_RECENT_DISCUSSIONS_TAB);

        activityFeedPage.clickTab(Constants.ACTIVITY_FEED_TAB_YOUR_COMMUNITY_TAB);

        activityFeedPage.clickTab(Constants.ACTIVITY_FEED_TAB_POPULAR_DISCUSSIONS_TAB);

    }

    @When("^i Navigates to Community Forum page and validate$")
    public void i_Navigates_to_Community_Forum_page_and_validate() throws Throwable {

        forumPage = activityFeedPage.openForum();

        forumPage.clickTab(Constants.FORUM_TABS_ALL_FORUMS_TAB);

        forumPage.clickTab(Constants.FORUM_TABS_FAV_FORUMS_TAB);

    }

    @Then("^i Navigates to Community Notification Page and validate$")
    public void i_Navigates_to_Community_Notification_Page_and_validate() throws Throwable {

        communityNotificationsPage = forumPage.openCommunityNotificationsPage();

        communityNotificationsPage.clickTab(Constants.COMMUNITY_NOTIFICATIONS_TABS_FRIEND_REQUEST_TAB);

        communityNotificationsPage.clickTab(Constants.COMMUNITY_NOTIFICATIONS_TABS_NOTIFICATION_TAB);
    }


    public void xx(){









        libraryPage.scrollNavigationMenuIntoView();


    }


    @When("^User navigate to Trackers Page and validating$")
    public void user_navigate_to_Trackers_Page_and_validating() throws Throwable {

        portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;

        TrackersBasePage trackersBasePage =  portalhomepage.openTrackersPage();

        String trackerHeaderPageTextFromUI = trackersBasePage.getTrackerHeaderText();

        Assert.assertEquals("Header Text is matching", trackerHeaderPageTextFromUI, Constants.TRACK_YOUR_PROGRESS_TEXT);

        portalhomepage = trackersBasePage.clickClientLogo();
    }

    @When("^Navigates to Rewards page and validating the sub list$")
    public void navigates_to_Rewards_page_and_validating_the_sub_list() throws Throwable {

        List<String> rewardsMenuItemsFromUI=portalhomepage.getMenuItemsUnderMenu("Rewards");
        String rewardsString[]={"Credits","Details","History"};
        Assert.assertTrue("All menu items are present under Rewards menu",rewardsMenuItemsFromUI.containsAll(Arrays.asList(rewardsString)));

    }

    @When("^Navigates to Coaching page and validating the sub list$")
    public void navigates_to_Coaching_page_and_validating_the_sub_list() throws Throwable {

        List<String> coachingMenuItemsFromUI=portalhomepage.getMenuItemsUnderMenu("Coaching");
        String coachingString[]={"Wellness","Condition","Nurse Advice Line"};
        Assert.assertTrue("All menu items are present under Coaching menu",coachingMenuItemsFromUI.containsAll(Arrays.asList(coachingString)));

    }

    @When("^Navigates to library page and validating the sub list$")
    public void navigates_to_library_page_and_validating_the_sub_list() throws Throwable {


        List<String> libraryMenuItemsFromUI=portalhomepage.getMenuItemsUnderMenu("Library");
        
        System.out.println("getMenuItemsUnderMenu"+libraryMenuItemsFromUI);
        
        String libraryString[]={"Wellness","Conditions","Pregnancy & Baby","Tobacco Free"};
        Assert.assertTrue("All menu items are present under Library menu",libraryMenuItemsFromUI.containsAll(Arrays.asList(libraryString)));

    }

    @Then("^Validating library sub pages are loading$")
    public void validating_library_sub_pages_are_loading() throws Throwable {

        libraryPage = portalhomepage.navigateToConditionsUnderLibrary();

        String libraryPageTitleFromUI = libraryPage.getTitle();

        Assert.assertTrue("Conditions page title is as expected",libraryPageTitleFromUI.contains(LibraryConstants.LIBRARY_CONDITIONS_PAGE_TITLE));

        libraryPage.scrollNavigationMenuIntoView();

        libraryPage = libraryPage.navigateToPregnancyAndBabyUnderLibrary();

        libraryPageTitleFromUI = libraryPage.getTitle();

        Assert.assertTrue("Pregnancy & Baby page title is as expected",libraryPageTitleFromUI.contains(LibraryConstants.LIBRARY_PRGEGNANCY_BABY_PAGE_TITLE));

        libraryPage.scrollNavigationMenuIntoView();

        libraryPage = libraryPage.navigateToTobaccoFreeUnderLibrary();

        libraryPageTitleFromUI = libraryPage.getTitle();

        Assert.assertTrue("Tobacco Free title is as expected",libraryPageTitleFromUI.contains(LibraryConstants.LIBRARY_TOBACOO_FREE_PAGE_TITLE));

    }

    @Then("^Navigates to homepage and validating home page$")
    public void navigates_to_homepage_and_validating_home_page() throws Throwable {
    	
    	if(libraryPage!=null){
        portalhomepage = libraryPage.clickClientLogo();
    	}

        Assert.assertTrue("Portal Home page is loaded",portalhomepage.isDisplayed());

    }
}


