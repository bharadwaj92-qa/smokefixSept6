package com.alerehealth.ui.callcenter.mainmenu;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterMedicationsPage extends CallCenterHomePage {

	@FindBy(xpath="//td[@class='p360bar']//li/div[@title='Medications' and @class='medications360b']")
	public WebElement medicationsTab;
	
	@FindBy(id="PegaGadget0Ifr")
    public WebElement Pega360PageIframe;
	
	@FindBy(id="f360d")
    public WebElement medications360PageIframe;
	
	@FindBy(id="medSearchAutoCompleteInput")
    public WebElement searchMedications;

	@FindBy(xpath="//*[contains(text(),'Medication Name:')]/..//following-sibling::td/span")
	public WebElement addedMedications;
	
	@FindBy(xpath="//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")
	public WebElement frequencyIcon;
	
	@FindBy(xpath="//*[@class='custom-combobox']")
	public WebElement frequencyComboBox;
	
	@FindBy(id="btnSaveMedication")
    public WebElement addEditMedSave;
		
	@FindBy(id="MedTabView")
    public WebElement addedMedicationUI;
	
	@FindBy(id="adherenceStatus")
    public WebElement medicinestatusComboBox;
	
	@FindBy(id="IsMedicationSelected")
    public WebElement medicineCheckBox;
	
	@FindBy(id="BtnMedGaps")
    public WebElement calculateMedicationGapsButton;
		
	public boolean clickCalculateMedicationGaps(){
		
		javaScriptClick(calculateMedicationGapsButton);
		
		try {
			return calculateMedicationGapsButton.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
		
	}
	
	public void isMedsTabSelected(String tabName){
		
		String MedTabxpath = "//*[contains(text(),'"+tabName+"')]";
		WebElement medTabSelect = getWebDriver().findElement(By.xpath(MedTabxpath));
		javaScriptClick(medTabSelect);
		
	}
	
	public void isMedicinesCheckBoxSelected(){
		
		javaScriptClick(medicineCheckBox);
		
	}
	
	public void selectMedicationValueinListTab(String buttonName) {

		String xpath = "//*[@class='buttonTdButton' and contains(@title,'"+buttonName+"')]";
		switchToFrame(medications360PageIframe);
		WebElement listTabMedicationValue = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(listTabMedicationValue);
		javaScriptClick(listTabMedicationValue);

	}
	
	public void saveRefreshButtonMedicationTab(String buttonName) {

		String xpath = "//*[@class='buttonTdButton' and contains(@title,'"+buttonName+"')]";
		WebElement saveMedicationStatus = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(saveMedicationStatus);
		javaScriptClick(saveMedicationStatus);

	}
	
	public void searchMedicationsAndAdd(String medicationvalue) throws InterruptedException{
		
		Thread.sleep(2000);
		waitForElementToBeDisplayed(searchMedications);
		searchMedications.sendKeys(""+medicationvalue+"");
		searchMedications.sendKeys(Keys.RETURN);
	}
	
	public String addedMedicationValue(){
		
		return addedMedications.getText().trim();
	}
	
	public void selectFrequencyAddEditMedication(String frequencyValue){
				
		frequencyComboBox.sendKeys(frequencyValue);
		javaScriptClick(frequencyIcon);
		String frequencyValuexpath = "//*[contains(@class,'ui-corner-all') and contains(text(),'"+frequencyValue+"')]";
		WebElement frequencySelection = getWebDriver().findElement(By.xpath(frequencyValuexpath));
		javaScriptClick(frequencySelection);
		
	}
	
	public String medicineStatusSelected() throws InterruptedException{
		
		Thread.sleep(2000);
		Select select = new Select(getWebDriver().findElement(By.id("adherenceStatus")));
		String optionselected = select.getAllSelectedOptions().get(0).getText();
		return optionselected;
			
	}
	
	public void selectMedicinestatus(String medicinestatus) throws InterruptedException{
		
		Thread.sleep(1000);
		waitForElementToBeDisplayed(medicinestatusComboBox);
		javaScriptClick(medicinestatusComboBox);
		medicinestatusComboBox.sendKeys(medicinestatus);
		
	}
	
    public void selectSearchResultFromAutoComplete(String resultContent){

        String xpath = "//ul[contains(@class,'ui-autocomplete') ]//*[contains(text(),'"+resultContent+"')]";

        waitForComponentTobDisplayed(By.xpath(xpath));

        WebElement result = getWebDriver().findElement(By.xpath(xpath));

        javaScriptClick(result);

    }
	
	public void addEditMedicationsSave(){
		
		javaScriptClick(addEditMedSave);
	}
		
	public String addedMedications(){
		
		return addedMedicationUI.getText().trim();
	}
	
	@Override
    public boolean isDisplayed() {
		getWebDriver().switchTo().defaultContent();
		switchToFrame(Pega360PageIframe);
        waitForElementToBeDisplayed(medicationsTab);
        return medicationsTab.isDisplayed();

    }

}
