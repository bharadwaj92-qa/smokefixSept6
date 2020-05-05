package com.alerehealth.ui.portal.progress.trackers.PeakFlow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class TrackersPeakFlowJournalBasePage extends TrackersPeakFlowBasePage {

	@FindBy(id = "peakFlowJournal_journalStartDate")
	private WebElement startDate;

	@FindBy(xpath = "//li[@id='journal_data_span']//a[@class='journal-edit']")
	private WebElement dataTableEditButton;

	@FindBy(xpath = "//li[@id='journal_data_span']//a[@class='journal-delete']")
	private WebElement dataTableDeleteButton;

	@FindBy(id = "peakFlowJournal_journalEndDate")
	private WebElement journalEndDate;

	@FindBy(id = "peakFlowJournal_journalStartDate")
	private WebElement journalStartDate;

	@FindBy(xpath = "//div[@id='myModal-journalEdit']//p[@class='para-color para-style-bold ']")
	private WebElement editDialougebox;

	@FindBy(xpath = "//div[@id='myModal-journalDelete']//p[@class='para-color para-style-bold ']")
	private WebElement deleteDialougebox;

	@FindBy(xpath = "//div[@id='myModal-journalEdit']//div[@class='buttons']//a[@class='button btn-primary button-edit']")
	private WebElement yesButtonAtEditPopup;

	@FindBy(xpath = "//div[@id='myModal-journalDelete']//div[@class='buttons']//a[@class='button btn-primary button-edit']")
	private WebElement yesButtonAtDeletePopup;

	@FindBy(xpath = "//div[@class='stacked-row'][1]//div[@class='stacked-table-content']//dd")
	private WebElement peakFlowinJournaltab;

	@FindBy(xpath = "//div[@class='stacked-row'][1]//div[@class='stacked-table-footer']//p")
	private WebElement notesinJournaltab;

	public String getPeakFlowText(String Date) {

		String xpath = "//div[@class='stacked-row']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"
				+ Date + "')]";

		String peakFlowXpath = xpath + "//..//..//..//div[@class='stacked-table-content']//dd";

		String peakFlowText = "";

		try {

			WebElement dateElement = getWebDriver().findElement(By.xpath(xpath));
			boolean elementPresent = dateElement.isDisplayed();
			if (elementPresent == true) {

				peakFlowText = getWebDriver().findElement(By.xpath(peakFlowXpath)).getText();

			} else {

				System.out.println("element is not displayed");
			}
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element Found - GetPeakFlowText");
		}

		return peakFlowText;

	}

	public String getNotesText(String Date) {

		String xpath = "//div[@class='stacked-row']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"
				+ Date + "')]";

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

	public String getNotesTextinJounralPage() {

		return notesinJournaltab.getText();
	}

	public String getPeakFlowinJounralPage() {

		return peakFlowinJournaltab.getText();
	}

	public boolean isTrackerDataShownInJournal() {

		try {

			return dataTableEditButton.isDisplayed();
		} catch (NoSuchElementException e) {

			System.out.println("Tracker Data entered is not showin in Journal Tab");
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

	public String getLastRecordDateText() {

		String xpath = "//div[@class='stacked-row']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')]";

		List<WebElement> dateElement = getWebDriver().findElements(By.xpath(xpath));

		int lastElement = dateElement.size();

		String lastDate = dateElement.get(lastElement - 1).getText();

		String[] substring = lastDate.split(" ");

		return substring[0];

	}

	public String getFirstRecordDateText() {

		String xpath = "//div[@class='stacked-row']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')]";

		List<WebElement> dateElement = getWebDriver().findElements(By.xpath(xpath));

		int firstElement = 0;

		String firstDate = dateElement.get(firstElement).getText();

		String[] substring = firstDate.split(" ");

		return substring[0];

	}

	public void editEntryFromJournal(String date) {

		String xpath = "//div[@class='stacked-row']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"
				+ date + "')]";

		String deleteXpath = xpath + "//..//li[@id='journal_data_span']//a[@class='journal-edit']";

		try {

			WebElement dateElement = getWebDriver().findElement(By.xpath(xpath));
			boolean elementPresent = dateElement.isDisplayed();
			if (elementPresent == true) {

				getWebDriver().findElement(By.xpath(deleteXpath)).click();

			} else {

				System.out.println("element is not displayed");
			}
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element Found - Edit Button");
		}

	}

	public void deleteEntryFromJournal(String date) {

		String xpath = "//div[@class='stacked-row']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')][contains(text(),'"
				+ date + "')]";

		String deleteXpath = xpath + "//..//li[@id='journal_data_span']//a[@class='journal-delete']";

		try {

			WebElement dateElement = getWebDriver().findElement(By.xpath(xpath));
			boolean elementPresent = dateElement.isDisplayed();
			if (elementPresent == true) {

				getWebDriver().findElement(By.xpath(deleteXpath)).click();

			} else {

				System.out.println("element is not displayed- Delete Button");
			}
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element Found - Delete Button");
		}

	}

	public String getEditBoxText() {

		return editDialougebox.getText();
	}

	public String getDeleteBoxText() {

		return deleteDialougebox.getText();
	}

	public void clickYesButtonDeleteDialouge() {

		yesButtonAtDeletePopup.click();
	}

	public TrackersPeakFlowTrackBasePage clickYesButtonEditDialouge() {

		yesButtonAtEditPopup.click();

		return new TrackersPeakFlowTrackBasePage();
	}

	public List<WebElement> getDatesofRecords() {

		String xpath = "//div[@class='stacked-row']//div[@class='stacked-table-header clear']//ul//li[not(@id='journal_data_span')][not(@class='bullet')]";

		List<WebElement> dateElement = getWebDriver().findElements(By.xpath(xpath));

		return dateElement;
	}

	public boolean isEditedRecordDisplayed(String Date) {

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

	@Override
	public boolean isDisplayed() {

		return startDate.isDisplayed();
	}

}
