package com.alerehealth.ui.stepdefenitions;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.alerehealth.fwk.common.CallCenterConstants;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;

import com.alerehealth.ui.callcenter.mainmenu.CallCenterInteractionsPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InteractionStepDef {
	
	CallCenterParticipantHomePage callCenterParticipantHomePage = null;
	CallCenterInteractionsPage callCenterInteractionsPage = null;
	public static CallCenterHomePage callCenterHomePage;
	CallCenterOthersHomeMenuPage callCenterOthersHomeMenuPage = null;
	
	String valueFromInteractionHeaderUI;
	String participantID;
	List<String> interactionLogColNames;
	List<String> interactionResult;
	
	@Given("^Retrieve the Enrolled Participant ID from PRPC DataBase$")
	public void retrieve_the_Enrolled_Participant_ID_from_PRPC_DataBase() throws Throwable {
		
		  callCenterHomePage = new CallCenterHomePage();
		
		  participantID =  callCenterHomePage.getParticipantIDFromDb();              
 	
	}

	@When("^Other tab loaded successfully enter Participant Id of the client from Db$")
	public void other_tab_loaded_successfully_enter_Participant_Id_of_the_client_from_Db() throws Throwable {
	    
		   
			callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();
	        
	        Assert.assertTrue("Validating Others Home Page is Displayed", callCenterOthersHomeMenuPage.isDisplayed());
	        
	        callCenterParticipantHomePage = callCenterOthersHomeMenuPage.searchParticipant(participantID);
		
	}

 	
	@When("^Click on Interactions on three sixty tab to verify the Interaction Logs Search Input Section$")
	public void click_on_Interactions_on_three_sixty_tab_to_verify_the_Interaction_Logs_Search_Input_Section() throws Throwable {
	   
		 callCenterInteractionsPage = callCenterParticipantHomePage.selectInteractionsTab();
		 Assert.assertTrue("Interactions page is displayed",callCenterInteractionsPage.isDisplayed());

		 valueFromInteractionHeaderUI = callCenterInteractionsPage.getTitleOfInteractionPage();
	        	
	      Assert.assertEquals("Validating Interaction Log Search Input Title in Interaction Page", valueFromInteractionHeaderUI, CallCenterConstants.INTERACTIONS_PAGE_INTERACTIONLOG_EXPECTEDTEXT);
	      
	     // callCenterInteractionsPage.clickReset();	
		 
	}

	@When("^Click on Search Button by selecting status, channel, Recipient and Timeperiod$")
	public void click_on_Search_Button_by_selecting_status_channel_Recipient_and_Timeperiod() throws Throwable {
		
		  	
		    callCenterInteractionsPage.selectCheckBoxOfSection("Status:","Success");
		
		    callCenterInteractionsPage.selectCheckBoxOfSection("Channel:", "Phone");
		    callCenterInteractionsPage.selectCheckBoxOfSection("Recipient:", "Participant");
		  
		   callCenterInteractionsPage.selectDropDownValueOfSection("Time Period:","ALL");
		    callCenterInteractionsPage.clickSearch();
		   

	}
	
	@Then("^User should be able to see search interactions$")
	public void user_should_be_able_to_see_search_interactions() throws Throwable {
	   
		   Assert.assertTrue("Interaction log search Inputs section is displayed",callCenterInteractionsPage.isLabelExpand("Interaction Log Results"));
		  callCenterInteractionsPage.getInteractionLogColumnNames();
		  //Assert.assertTrue(interactionLogColNames.containsAll(Arrays.asList(" ","PPID" , "REC" ,"CH" , "Interaction" , "Status" , "Completed Tasks" , "Reason" , "Open" , "Completed" , "Due" , "Completed By")));   

	}

	@Then("^User should be able to see search interactions displayed correctly$")
	public void user_should_be_able_to_see_search_interactions_displayed_correctly() throws Throwable {
	    
		 Assert.assertTrue("Interaction log search Inputs section is displayed",callCenterInteractionsPage.isLabelExpand("Interaction Log Results"));
		 interactionLogColNames=callCenterInteractionsPage.getInteractionLogColumnNames();
		// Assert.assertTrue(interactionLogColNames.containsAll(Arrays.asList(" " ," PPID "," REC "," CH "," Interaction "," Status "," Completed Tasks "," Reason "," Open "," Completed "," Due "," Completed By "," "," "," "))); 
		 interactionResult = callCenterInteractionsPage.getInteractionLogResultsRowDataValue("Status", "Success", "Interaction","Reason");
	}

}
