package com.alerehealth.ui.stepdefenitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alerehealth.fwk.common.LoggerUtils;
import com.alerehealth.ui.c3po.common.pages.C3POHomePage;
import com.alerehealth.ui.c3po.common.pages.C3POLoginPage;

import com.alerehealth.ui.c3po.common.pages.DCPTestUserPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WBAC3ToolUserCreationStepsDefination {

	C3POHomePage c3poHomePage;
	 DCPTestUserPage dcpTestUserPage;
	
	
    String firstName = "";
    @Given("^Login to C3ToolPortal using userName and Password$")
    public void login_to_C3ToolPortal_using_userName_and_Password(DataTable arg1) throws Throwable {

       
    	C3POLoginPage c3pologinpage=new C3POLoginPage();

        Map dataMap = arg1.asMap(String.class, String.class);

        String userName = (String) dataMap.get("username");
        String password = (String) dataMap.get("password");
        
        LoggerUtils.info("Logging into Web portal using "+ userName + "/" + password);

        
        c3poHomePage=c3pologinpage.doLogin(userName, password);
    }
    
    @Then("^User Switches to the frame$")
    public void user_Switches_to_the_frame() throws Throwable {
    	c3poHomePage.switchtoframe();
    	
    	
    }
    
    @Then("^user enters the \"([^\"]*)\" and \"([^\"]*)\" in text box$")
    public void user_enters_in_Clinet_text_(String drpdwnlnk,String menuItem) throws Throwable {
    	
    	
    	
    	c3poHomePage.expandDropdown(drpdwnlnk);
    	
    	c3poHomePage.selectMenuItem(menuItem);
    	
    	
    	
        
    }
    
    
  
    
    @Then("^User click on TestUsers$")
    public DCPTestUserPage user_click_on_TestUsers() throws Throwable {
    	
    	
    	c3poHomePage.clickOnTestUsers();
    	
    	return new DCPTestUserPage();
    	
    
        
    }
    
  
  
    
    
    
    @Then("^User Clicks on Enter$")
    public void User_Clicks_on_Enter() throws Throwable {
    	c3poHomePage.clickOnEnter();
    	
    }
    
    
    @Then("^User enters required number \"([^\"]*)\" in quanity field$")
    public void user_enters_required_number(String arg1) throws Throwable {
    	
    	
    	dcpTestUserPage.entertheUsers(arg1);
    	
        
    }
    
    @Then("^User selects the gender field as \"([^\"]*)\"$")
    public void user_selects_the_gender(String arg1) throws Throwable {
    	
    	dcpTestUserPage.selectGender(arg1);
    	
    	
        
    }
    
    
    @Then("^User enters dob as \"([^\"]*)\" in dob field$")
    public void User_sends_the_dob(String arg1) throws Throwable {
    	dcpTestUserPage.enterDob(arg1);
        
    }
    
   
    

    @Then("^User clicks on registered button$")
   public void user_clicks_on_registered_button() throws Throwable {
    	
    	dcpTestUserPage.clickOnRegisteredCheckBox();
    	
    	
        
    }
    
    @Then("^User selects program category name as \"([^\"]*)\" and population as \"([^\"]*)\"$")
    public void user_selects_program_categorys_field(String programCategoryName,String populationName) throws Throwable {
    	
    	//dcpTestUserPage.selectProgramCategory();
    	
    	
    	dcpTestUserPage.selectProgamCategory(programCategoryName, populationName);
    	
    	
        
    }
    
    @Then("^User click on createuser button$")
    public void user_click_on_createuser() throws Throwable {
    	
    	dcpTestUserPage.clickOnCreateTestUsers();
    	
    	
        
    }
    
    

    
    
    
    @Then("^User switches to DCPTestCreation window$")
    public void User_switches_to_DCPTestCreation() throws Throwable {
    	
    	
    	
    	dcpTestUserPage=c3poHomePage.switchtoNewWindow();
    	
        
    }

   
    @Then("^User click on Alert accept button$")
    public void user_click_on_Alert_accept_button() throws Throwable {
    	dcpTestUserPage.Alertaccept();
    	
    	
    	
        
    }
    
    
    @Then("^gets the \"([^\"]*)\" created users$")
    public void gets_created_users(int i) throws Throwable {
    	
    	//dcpTestUserPage.getusersfromlist();
    	//dcpTestUserPage.entertheUsers(arg1);
    	List<String> userNames = new ArrayList<String>();
    	
    	//String dd=dcpTestUserPage.dynamicxpath(i);
    	userNames=dcpTestUserPage.getUserNames(i);
    	for(String s:userNames)
    		System.out.println(s);
    	
        
    }
    
    
    
   
   
 

   
}

