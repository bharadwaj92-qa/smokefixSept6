package com.alerehealth.ui.stepdefenitions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;

import com.alerehealth.fwk.common.Configuration;
import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.c3po.common.pages.C3POHomePage;
import com.alerehealth.ui.c3po.common.pages.C3POLoginPage;
import com.alerehealth.ui.c3po.common.pages.DCPTestUserPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import com.alerehealth.ui.portal.common.pages.PortalLoginPage;
import com.alerehealth.ui.portal.usermenu.phr.PHRHealthRecordPage;
import com.alerehealth.ui.portal.usermenu.phr.PHRSearchAndAddDoctorPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PhrSearchAndAddDoctorPageStepDefenitions {
	
	C3POHomePage c3poHomePage;
	DCPTestUserPage dcpTestUserPage;
	
	PortalLoginPage portalLoginPage=null;
	PortalHomePage portalhomepage=null;
	PHRSearchAndAddDoctorPage phrSearchAndAddDoctorPage=null;
	PHRHealthRecordPage phrHealthRecordPage=null;

	String portalUserName = null;
	
	String doctorName = "";




	@When("^Navigating to Health Record Page for doctorsearch$")
	public void navigating_to_Health_Record_Page_for_doctorsearch() throws Throwable {

		portalhomepage = WBAQuestionnaireStepsDefinition.portalHomePage;

		phrHealthRecordPage=portalhomepage.openHealthRecordOfUser();

		phrSearchAndAddDoctorPage =phrHealthRecordPage.addADoctor();

		Assert.assertTrue(phrSearchAndAddDoctorPage.isAddDoctorPagePresent());

	}



	@When("^Searching for the Doctor with below information$")
	public void searching_for_the_Doctor_with_below_information(DataTable arg1) throws Throwable {

		HashMap<String, String> data=PhrSearchAndAddDoctorPageStepDefenitions.generateHashMapFromDataTable(arg1);
		phrSearchAndAddDoctorPage.clickAddDoctor();
		phrSearchAndAddDoctorPage.searchForDoctor(data);


	}

	@When("^Adding the doctor with below information$")
	public void adding_the_doctor_with_below_information(DataTable arg1) throws Throwable {

		HashMap<String, String> data=PhrSearchAndAddDoctorPageStepDefenitions.generateHashMapFromDataTable(arg1);

		phrSearchAndAddDoctorPage.clickAddDoctorInSearchResultPopUp();

		phrSearchAndAddDoctorPage.addCustomDoctor(data); 

		doctorName = data.get("SrcFirstname")+ " "+ data.get("SrcLastname");
		
		phrSearchAndAddDoctorPage.isDoctorPresentInGrid(doctorName);

	}

	@Then("^Verifying the Added doctor$")
	public void verifying_the_Added_doctor() throws Throwable {

		phrSearchAndAddDoctorPage.clickDeleteDoctorFromGrid(doctorName);

		Assert.assertTrue("Delete confirmation popup is displayed",phrSearchAndAddDoctorPage.isDisplayedDoctorDeleteMsgVerify());

		phrSearchAndAddDoctorPage.clickDeleteDoctorConfirmBtn();

		Assert.assertFalse("Doctor is deleted successfully ",phrSearchAndAddDoctorPage.isDoctorPresentInGrid(doctorName));


	}

	public static HashMap<String,String> generateHashMapFromDataTable(DataTable arg1)
	{
		List<Map<String, String>> data= arg1.asMaps(String.class, String.class);

		HashMap<String ,String> updateParameter = new HashMap<String, String>();

		Entry<String, String> entries;

		Set set;

		for(Map<String, String> list:data)
		{
			set=list.entrySet();

			Iterator itr= set.iterator();

			while(itr.hasNext())
			{

				entries=(Entry<String, String>) itr.next();

				updateParameter.put(entries.getKey(),entries.getValue());
			}
		}

		return updateParameter;
	}

}
