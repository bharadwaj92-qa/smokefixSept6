package com.alerehealth.ui.stepdefenitions;

import org.junit.Assert;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.usermenu.phr.PHRHealthRecordPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PHRStepDefenition {

		PortalLoginPage portalLoginPage=null;
		PortalHomePage portalhomepage=null;
		PHRHealthRecordPage phrHealthRecordPage=null;

		@When("^Navigating to Health Record Page$")
		public void navigating_to_Health_Record_Page() throws Throwable {
			
			portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;
			
			phrHealthRecordPage=portalhomepage.openHealthRecordOfUser();
		}

		@Then("^Validate the Health Record profile$")
		public void validate_the_Health_Record_profile() throws Throwable {
			
			String contentCards[]= new String []{"Doctors","Hospitals","Pharmacies","Tests / Procedures","Conditions","Medications","Allergies","Hospital Stays","Vaccines","General Physical","Eye Exams","Dental Exams","Foot Exams"};
			
			for(String contentCard: contentCards){
				
				Assert.assertTrue(contentCard + " is present", phrHealthRecordPage.isContentCardPresent(contentCard));
			}
			
		}
}
