package com.alerehealth.ui.portal.usermenu.phr;

import java.util.HashMap;

import com.alerehealth.ui.portal.usermenu.phr.PHRHealthRecordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PHRSearchAndAddDoctorPage extends PHRHealthRecordPage {



	@FindBy(id="btnAdd")
	private WebElement phrAddDoctorButtonClick;


	//*************Search Doctor window controls*********************************
	@FindBy(id = "firstName")
	private WebElement phrDoctorFirstName;

	@FindBy(id = "lastName")
	private WebElement phrDoctorLastName;

	@FindBy(id = "city")
	private WebElement phrDoctorCity;

	@FindBy(id = "zipcode")
	private WebElement phrDoctorZipCode;

	@FindBy(id = "state")
	private WebElement phrDoctorState;

	@FindBy(id = "phr-search-button")
	private WebElement phrSearchDoctorBtn;
	//*****************************************************************************

	@FindBy(id = "phr-addcustom-button")
	private WebElement phrSearchResultPopUpAddDoctor;

	@FindBy(id = "address1")
	private WebElement phrSearchAddress1;

	@FindBy(id = "providerCity")
	private WebElement phrSearchDoctorProviderCity;

	@FindBy(id = "providerState")
	private WebElement phrSearchDoctorProviderState;

	@FindBy(id = "providerZip")
	private WebElement phrSearchDoctorProviderZipCode;

	@FindBy(id = "phone")
	private WebElement phrSearchDoctorProviderPhone;

	@FindBy(id = "saveCustomProvider")
	private WebElement phrSearchDoctorSaveBtn;


	///Doctor Deletion test case XPaths


	@FindBy(xpath = "//*[contains(text(),'Are you sure you want to delete this entry?')]")
	private WebElement phrDoctorDeleteMsgVerify;

	@FindBy(xpath = "//*[@class='btn btn--primary button-delete']")
	private WebElement phrDoctorDeleteConfirmBtn;

	public boolean isAddDoctorPagePresent() {  	

		return isLeftNavLinkHighlighted("Doctor");
	}

	public void clickAddDoctor() {

		phrAddDoctorButtonClick.click();

		waitForModelDialogToOpen();

	}

	public boolean isSearchDoctorPagePresent() {  	

		String title = getModalDialogTitle();

		boolean isSearchDoctorWindowOpened = title.toLowerCase().contains("search doctor");

		return isSearchDoctorWindowOpened; 
	}

	public void enterDoctorFirstName(String DoctorFirstName){
		
		waitForElementToBeDisplayed(phrDoctorFirstName);
		phrDoctorFirstName.clear();
		
		waitForElementToBeDisplayed();
		
		phrDoctorFirstName.sendKeys(DoctorFirstName);
	}

	public void enterDoctorLastName(String DoctorLastName){
		phrDoctorLastName.sendKeys(DoctorLastName);
	}

	public void enterDoctorCity(String DoctorCity){
		phrDoctorCity.sendKeys(DoctorCity);
	}

	public void enterDoctorZipCode(String DoctorZipCode){
		phrDoctorZipCode.sendKeys(DoctorZipCode);
	}

	public void selectState(String state)
	{
		Select s=new Select(phrDoctorState);

		s.selectByVisibleText(state);
	}

	public void clickSearchDoctorBtn() {
		phrSearchDoctorBtn.click();
	}


	public void searchForDoctor(String firstName, String lastName, String city,  String state,String zipCode){

		enterDoctorFirstName(firstName);

		enterDoctorLastName(lastName);

		enterDoctorCity(city);

		selectState(state);

		enterDoctorZipCode(zipCode);

		clickSearchDoctorBtn();

		waitForModalDialogTitleToChange("Doctor Search Results");


	}

	public void searchForDoctor(HashMap<String,String> doctorData){


		String firstName = doctorData.get("Firstname");
		String lastName =doctorData.get("Lastname");
		String cityName =doctorData.get("City");
		String zipCode =doctorData.get("Zipcode");
		String state = doctorData.get("State");

		searchForDoctor(firstName, lastName,cityName,state, zipCode);


	}


	public void addCustomDoctor(HashMap<String,String> doctorData){



		String firstName =doctorData.get("SrcFirstname");
		String lastName = doctorData.get("SrcLastname");
		String DoctorAddress1 = doctorData.get("SrcAddress");
		String cityName= doctorData.get("SrcCity");
		String state= doctorData.get("SrcState");
		String DoctorSearchZipCode= doctorData.get("SrcZipCode");
		String phoneNumber = doctorData.get("SrcPhonenum");

		enterDoctorFirstName(firstName);

		enterDoctorLastName(lastName);

		enterCustomDoctorAddress1(DoctorAddress1);

		enterCustomDoctorProviderCity(cityName);

		selectCustomDoctorState(state);

		enterCustomDoctorZipCode(DoctorSearchZipCode);

		enterCustomDoctorPhone(phoneNumber);

		clickCustomDoctorBtnSave();


	}



	public void clickAddDoctorInSearchResultPopUp() {
		phrSearchResultPopUpAddDoctor.click();

		waitForModalDialogTitleToChange("Add Custom Doctor");
	}

	public void enterSearchDoctorFirstName(String DoctorFirstName){
		phrDoctorFirstName.sendKeys(DoctorFirstName);
	}

	public void enterSearchDoctorLastName(String DoctorLastName){
		phrDoctorLastName.sendKeys(DoctorLastName);
	}

	public void enterCustomDoctorAddress1(String DoctorAddress1){
		phrSearchAddress1.sendKeys(DoctorAddress1);
	}

	public void enterCustomDoctorProviderCity(String ProviderCity){
		phrSearchDoctorProviderCity.sendKeys(ProviderCity);
	}

	public void selectCustomDoctorState(String providerState)
	{
		Select s=new Select(phrSearchDoctorProviderState);

		s.selectByVisibleText(providerState);
	}

	public void enterCustomDoctorZipCode(String DoctorSearchZipCode){
		phrSearchDoctorProviderZipCode.sendKeys(DoctorSearchZipCode);
	}



	public void enterCustomDoctorPhone(String ProviderPhone){
		phrSearchDoctorProviderPhone.sendKeys(ProviderPhone); 
	}

	public void clickCustomDoctorBtnSave() {
		phrSearchDoctorSaveBtn.click();
	}




	///Doctor Deletion test case Scenario

	public void clickDeleteDoctorFromGrid(String doctorName) {

		String icon = "Delete";

		clickActionsOfDoctor( doctorName,  icon);

		waitForModelDialogToOpen();

	}


	public void clickActionsOfDoctor(String doctorName, String icon){

		WebElement doctorGridRow =  getDoctorRowElementInGrid( doctorName);

		String iconXpath = ".//a[contains(@class,'material-icons') and contains(@class,'phr";

		if(icon.contains("Info")){

			iconXpath+="Info')]";
		}
		else{

			iconXpath+="Delete')]";
		}

		doctorGridRow.findElement(By.xpath(iconXpath)).click();


	}
	public boolean isDoctorDeleteMsgVerify() {  	
		return phrDoctorDeleteMsgVerify.isDisplayed();
	}

	public void clickDeleteDoctorConfirmBtn() {
		phrDoctorDeleteConfirmBtn.click();
	}

	public boolean isDoctorPresentInGrid(String doctor){


		try{

			getDoctorRowElementInGrid(doctor);

			return true;

		}catch(NoSuchElementException e){

			return false;

		}


	}



	public boolean isDisplayedDoctorDeleteMsgVerify() {
		
		waitForElementToBeDisplayed(phrDoctorDeleteMsgVerify);
		
		return phrDoctorDeleteMsgVerify.isDisplayed();
	}



	@Override
	public boolean isDisplayed() {
		return phrAddDoctorButtonClick.isDisplayed();
	}


	private WebElement getDoctorRowElementInGrid(String doctorName){

		String xpath = "//section[@class='layout-table']//td[@data-th='Name' and contains(text(),'"+doctorName+"')]/..";

		WebElement gridRow = getWebDriver().findElement(By.xpath(xpath));


		return gridRow;

	}


}
