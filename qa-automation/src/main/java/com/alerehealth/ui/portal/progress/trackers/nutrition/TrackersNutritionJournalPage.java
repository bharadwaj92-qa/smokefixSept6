package com.alerehealth.ui.portal.progress.trackers.nutrition;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class TrackersNutritionJournalPage extends TrackersNutritionBasePage{

	@FindBy(xpath = "//li[@id='journal_data_span']//a[@class='journal-edit']")
	private WebElement dataTableEditButton;

	@FindBy(xpath = "//li[@id='journal_data_span']//a[@class='journal-delete']")
	private WebElement dataTableDeleteButton;

	@FindBy(id = "nutritionJournal_journalEndDate")
	private WebElement journalEndDate;

	@FindBy(id = "nutritionJournal_journalStartDate")
	private WebElement journalStartDate;

	@FindBy(xpath = "//div[@id='myModal-journalEdit']//p[@class='para-color para-style-bold ']")
	private WebElement editDialougebox;

	@FindBy(xpath = "//div[@id='myModal-journalDelete']//p[@class='para-color para-style-bold ']")
	private WebElement deleteDialougebox;

	@FindBy(xpath = "//div[@id='myModal-journalEdit']//div[@class='buttons']//a[@class='button btn-primary button-edit']")
	private WebElement yesButtonAtEditPopup;

	@FindBy(xpath = "//div[@id='myModal-journalDelete']//div[@class='buttons']//a[@class='button btn-primary button-edit']")
	private WebElement yesButtonAtDeletePopup;

	@FindBy(xpath = "//div[@class='stacked-table-footer']//p")
	private WebElement notesinJournaltab;
	
	@FindBy(xpath = "//div[@class='tables']//p")
	private WebElement journalContent;
	
	public String getJournalContent(){
		
	return journalContent.getText().trim();
		
	}
	
	

	public String getServingsData(String dateValue,String servingValue){
		
		String xpath = "//div[@class='stacked-table']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"+dateValue+"')]";
		
		String servingXpath = xpath + "//..//..//following-sibling::div//dt[contains(text(),'"+servingValue+"')]//following-sibling::dd ";
		
		String serveValueText = " ";
		
		String serveValue = " ";
		
		try {

			WebElement dateElement = getWebDriver().findElement(By.xpath(xpath));
			boolean elementPresent = dateElement.isDisplayed();
			if (elementPresent == true) {

				serveValueText = getWebDriver().findElement(By.xpath(servingXpath)).getText();
				
				String[] serveValueText1 = serveValueText.split(" ");
				serveValue = serveValueText1[0];
		

			} else {

				System.out.println("element is not displayed");
			}
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element Found - GetNotesText");
		}

		return serveValue;
	
	}

	public String getNotesText(String Date) {

		String xpath = "//div[@class='stacked-table']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"+Date+"')]";

		String notesXpath = xpath + "//..//..//..//div[@class='stacked-table-footer']//p";

		String notesText = "";

		try {

			WebElement dateElement = getWebDriver().findElement(By.xpath(xpath));
			boolean elementPresent = dateElement.isDisplayed();
			if (elementPresent == true) {

				notesText = getWebDriver().findElement(By.xpath(notesXpath)).getText();

			} else {

				System.out.println("element is not displayed");
			}
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element Found - GetNotesText");
		}

		return notesText;

	}


	public boolean isTrackerDataShownInJournal() {

		try {

			return dataTableEditButton.isDisplayed();
		} catch (NoSuchElementException e) {

			System.out.println("Tracker Data entered is not showing in Journal Tab");
			return false;
		}
	}

	public void enterStartDateJournalTab(String date) {

		journalStartDate.clear();
		waitForSpecifiedTime(2);
		journalStartDate.sendKeys(date);
	}

	public void enterEndDateJournalTab(String date) {

		journalEndDate.clear();
		waitForSpecifiedTime(2);
		journalEndDate.sendKeys(date);
	}

	
	public void editEntryFromJournal(String date) {

		String xpath = "//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"
				+ date + "')]";

		String editXpath = xpath + "//..//li[@id='journal_data_span']//a[@class='journal-edit']";

		try {

			WebElement dateElement = getWebDriver().findElement(By.xpath(xpath));
			boolean elementPresent = dateElement.isDisplayed();
			if (elementPresent == true) {

				WebElement editEle = getWebDriver().findElement(By.xpath(editXpath));
				waitForElementToBeDisplayed(editEle);
				javaScriptClick(editEle);

			} else {

				System.out.println("element is not displayed");
			}
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element Found - Edit Button");
		}

	}

	public void deleteEntryFromJournal(String date) {

		String xpath = "//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"
				+ date + "')]";

		String deleteXpath = xpath + "//..//li[@id='journal_data_span']//a[@class='journal-delete']";

		try {

			WebElement dateElement = getWebDriver().findElement(By.xpath(xpath));
			boolean elementPresent = dateElement.isDisplayed();
			if (elementPresent == true) {

				WebElement deleteEle = getWebDriver().findElement(By.xpath(deleteXpath));
				waitForElementToBeDisplayed(deleteEle);
				javaScriptClick(deleteEle);

			} else {

				System.out.println("element is not displayed- Delete Button");
			}
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element Found - Delete Button");
		}

	}

	public String getEditBoxText() {
		
		waitForSpecifiedTime(5);

		return editDialougebox.getText().trim();
	}

	public String getDeleteBoxText() {
		
		waitForSpecifiedTime(5);

		return deleteDialougebox.getText().trim();
	}

	public  TrackersNutritionJournalPage clickYesButtonDeleteDialogue() {

		
		javaScriptClick(yesButtonAtDeletePopup);
		
		return new TrackersNutritionJournalPage();
	}

	public TrackersNutritionTrackPage clickYesButtonEditDialouge() {

		javaScriptClick(yesButtonAtEditPopup);

		return new TrackersNutritionTrackPage();
	}

	
    public int getJournalRecordCount()
    {
        return getWebDriver().findElements(By.xpath("//div[@class='stacked-table-header clear']")).size();
    }
    
    
    public List<String> getJournalEntriesTimeStamp(String startDate,String endDate)

    {
                    List<String> entries=new ArrayList<>();
                    this.journalStartDate.clear();
                    this.journalEndDate.clear();
                    this.journalStartDate.sendKeys(startDate);
                    this.journalEndDate.sendKeys(endDate,Keys.TAB);

                    List<WebElement> journalEntries = getWebDriver().findElements(By.xpath(("//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')]")));
 
                    journalEntries.forEach(dateEle -> entries.add(dateEle.getText().trim()));
                    
                    return entries;
                    
    }
    

    public List<WebElement> getDatesofRecords() {

		String xpath = "//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')]";

		List<WebElement> dateElement = getWebDriver().findElements(By.xpath(xpath));

		return dateElement;
	}


	public boolean isRecordDisplayed(String Date) {

		boolean flag = false;
		List<WebElement> recordDates = getDatesofRecords();

		for (WebElement dates : recordDates) {

			String dateTime = dates.getText();

			if (dateTime.equals(Date)) {

				flag = true;

			} else {

				flag = false;
			}
		}

		return flag;
	}
	
	/*
	 * To click ProgramCategory or GoalHistory dropdown
	 */
	public void selectTrackerDropDown(String value){
		
		String xpath = "//a[contains(text(),'"+value+"')]";
		WebElement dropDownEle = getWebDriver().findElement(By.xpath(xpath));
		javaScriptClick(dropDownEle);
	}
	
	
	public boolean isGoalDisplayed(){
		
		String xpath = "//div[@class='stacked-table-content']";
		WebElement goalEle = getWebDriver().findElement(By.xpath(xpath));

		return goalEle.isDisplayed();
		
	}
	
	
	public String getDateFromGoalhistory(){
		
		String xpath = "//div[@class='stacked-table-content']//following-sibling::dt[contains(text(),'Date')]//following-sibling::dd ";
		WebElement element = getWebDriver().findElement(By.xpath(xpath));
		return element.getText().trim();
		
	}
	
	
	public String getGoalHistoryData(String data){
		
		String xpath = "//div[@class='stacked-table-content']//following-sibling::dt[contains(text(),'Goal')]//following-sibling::dd//p[contains(text(),'"+data+"')] ";
		WebElement element = getWebDriver().findElement(By.xpath(xpath));
		
		return element.getText().trim();
	}

	@Override
	public boolean isDisplayed() {

		return journalStartDate.isDisplayed();
	}
}
