package com.alerehealth.ui.stepdefenitions;

import com.alerehealth.fwk.common.Constants;
import com.alerehealth.fwk.common.HelperUtils;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.progress.constants.TrackersConstants;
import com.alerehealth.ui.portal.progress.trackers.TrackerA1CTrackPage;
import com.alerehealth.ui.portal.progress.trackers.TrackersA1CBasePage;
import com.alerehealth.ui.portal.progress.trackers.TrackersA1cJournalPage;
import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.HashMap;

public class TrackersStepDefenition {

    PortalHomePage portalHomePage = null;

    TrackersBasePage trackersBasePage;

    TrackersA1CBasePage trackersA1CBasePage;

    TrackersA1cJournalPage trackersA1cJournalPage;

    @When("^User navigate to Trackers page and update progress of Tracker$")
    public void user_navigate_to_Trackers_page_and_update_progress_of_Tracker(DataTable arg1) throws Throwable {

        portalHomePage = WBAQuestionnaireStepsDefinition.portalHomePage;

        trackersBasePage =	portalHomePage.openTrackersPage();

        trackersA1CBasePage = trackersBasePage.navigateToA1cPage();

        TrackerA1CTrackPage trackerA1CTrackPage = trackersA1CBasePage.navigateToTrackTab();

        HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);

        String reading = dataMap.get("Reading");
        String notes = dataMap.get("Notes");

        trackerA1CTrackPage.enterA1cReadings(reading);

        trackersA1cJournalPage=trackerA1CTrackPage.clickSaveButton();

        Assert.assertEquals(trackersA1cJournalPage.getSelectedTabText(),TrackersConstants.JOURNALS_PAGE_VALIDATION);

    }

    @When("^user updates previous readings of user from Journal page$")
    public void user_updates_previous_readings_of_user_from_Journal_page(DataTable arg1) throws Throwable {

        HashMap<String,String> dataMap = HelperUtils.convertDataTableToHashMap(arg1);

        String reading = dataMap.get("Reading");
        String notes = dataMap.get("Notes");

        //trackersA1cJournalPage.

    }

    @Then("^validate tracker values are reflected in Journal page$")
    public void validate_tracker_values_are_reflected_in_Journal_page() throws Throwable {

    }

    @Then("^user can successfully delete the entry from Journal page$")
    public void user_can_successfully_delete_the_entry_from_Journal_page() throws Throwable {

    }

    @Then("^validate tracker values are updated for the entry in Journal page$")
    public void validate_tracker_values_are_updated_for_the_entry_in_Journal_page(DataTable arg1) throws Throwable {

    }

    @Then("^successfully delete the entry from Journal page$")
    public void successfully_delete_the_entry_from_Journal_page() throws Throwable {

    }

    @Given("^user logs in with user created from C(\\d+)tool and navigates to Trackers$")
    public void user_logs_in_with_user_created_from_C_tool_and_navigates_to_Trackers(int arg1) throws Throwable {

    }

    @When("^user tries to enter invalid values for mandatory fields error messages are shown$")
    public void user_tries_to_enter_invalid_values_for_mandatory_fields_error_messages_are_shown(DataTable arg1) throws Throwable {

    }
}
