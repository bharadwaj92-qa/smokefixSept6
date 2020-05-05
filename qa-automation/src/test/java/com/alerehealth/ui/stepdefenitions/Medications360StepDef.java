package com.alerehealth.ui.stepdefenitions;

import java.util.Map;

import org.junit.Assert;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import com.alerehealth.ui.callcenter.common.pages.CallCenterParticipantHomePage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterMedicationsPage;
import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Medications360StepDef {

	public static CallCenterHomePage callCenterHomePage;
	CallCenterOthersHomeMenuPage callCenterOthersHomeMenuPage = null;
	CallCenterParticipantHomePage callCenterParticipantHomePage=null;
	CallCenterMedicationsPage callCenterMedicationsPage=null;
		
	String addedMedicationsValueFromUI;
	String AddedMedicationUI;
	
	@When("^User navigates to other page and Search for the medications participant$")
	public void user_navigates_to_other_page_and_Search_for_the_medications_participant() throws Throwable {

		callCenterHomePage = new CallCenterHomePage();
		
		callCenterOthersHomeMenuPage = callCenterHomePage.openOtherPage();
        
        Assert.assertTrue("Validating Others Home Page is available", callCenterOthersHomeMenuPage.isDisplayed());
        
        callCenterParticipantHomePage = callCenterOthersHomeMenuPage.searchParticipant("P-355267");
        
	}

	@When("^Navigates to Medications tab and click on Add Medication$")
	public void navigates_to_Medications_tab_and_click_on_Add_Medication() throws Throwable {
	        
		 callCenterMedicationsPage=callCenterParticipantHomePage.selectMedicationsTab("Medications");
	        	        
	     callCenterMedicationsPage.selectMedicationValueinListTab("Add Medication");
	        
	     Thread.sleep(2000);
	        
	}

	@When("^Search for Medication and add the medication,set the frequency$")
	public void search_for_Medication_and_add_the_medication_set_the_frequency(DataTable arg1) throws Throwable {
		
		Map dataMap = (Map) arg1.asMap(String.class, String.class);

        String Medication = (String) dataMap.get("medication");
        String Frequency = (String) dataMap.get("frequency");
        
		callCenterMedicationsPage.searchMedicationsAndAdd(Medication);
        
        callCenterMedicationsPage.selectSearchResultFromAutoComplete(Medication);       
        
        addedMedicationsValueFromUI = callCenterMedicationsPage.addedMedicationValue();
        
        System.out.println(addedMedicationsValueFromUI);
        
        callCenterMedicationsPage.selectFrequencyAddEditMedication(Frequency);
        
        callCenterMedicationsPage.addEditMedicationsSave();
        
	}

	@When("^Validate the Added medication in the medication page$")
	public void validate_the_Added_medication_in_the_medication_page() throws Throwable {

		AddedMedicationUI = callCenterMedicationsPage.addedMedications();
        
        System.out.println(AddedMedicationUI);
                
        Assert.assertTrue("Validating medications is added successfully",AddedMedicationUI.contains(addedMedicationsValueFromUI));
        
	}

	@Then("^Update the medication status and save,Refresh the page and verify the saved status details$")
	public void update_the_medication_status_and_save(DataTable arg1) throws Throwable {

		Map dataMap = (Map) arg1.asMap(String.class, String.class);

        String MedicationStatus = (String) dataMap.get("medicationstatus");
        
		callCenterMedicationsPage.isMedicinesCheckBoxSelected();
        
        String MedicinestatusSelectUI = MedicationStatus;
        
        callCenterMedicationsPage.selectMedicinestatus(MedicinestatusSelectUI);
        
        callCenterMedicationsPage.saveRefreshButtonMedicationTab("Save Participant Medications");
        
		String MedicinesStatusAfterRefresh = callCenterMedicationsPage.medicineStatusSelected();
        
        System.out.println(MedicinesStatusAfterRefresh);
        
        Assert.assertEquals("Validating MedicineStatus Section after refreshing the page", MedicinestatusSelectUI,MedicinesStatusAfterRefresh);
        
	}

	@Then("^Navigate to Gaps tab and Verify the Calculate Medication Gaps button$")
	public void navigate_to_Gaps_tab_and_Verify_the_Calculate_Medication_Gaps_button() throws Throwable {

		callCenterMedicationsPage.isMedsTabSelected("Gaps");
        
        Assert.assertTrue("Validating Calculate Medication Gaps button is displayed",callCenterMedicationsPage.clickCalculateMedicationGaps());
        
	}

	@Then("^Navigates back to List tab and verify the added medication$")
	public void navigates_back_to_List_tab_and_verify_the_added_medication() throws Throwable {

		callCenterMedicationsPage.isMedsTabSelected("List  ");
        
        Assert.assertTrue("Validating medications is still exists",AddedMedicationUI.contains(addedMedicationsValueFromUI));
        
	}

	@Then("^Discontinue the added Medications$")
	public void discontinue_the_added_Medications() throws Throwable {

		 callCenterMedicationsPage.isMedicinesCheckBoxSelected();
	     Thread.sleep(1000);
	     callCenterMedicationsPage.saveRefreshButtonMedicationTab("Discontinue Medications");
	        
	}
	
}
