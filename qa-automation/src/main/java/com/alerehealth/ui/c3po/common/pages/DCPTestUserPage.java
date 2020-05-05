package com.alerehealth.ui.c3po.common.pages;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.fwk.selenium.common.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DCPTestUserPage extends Element {



	@FindBy(xpath="(//*[@id='SL_Input']/input)[1]")
	private WebElement dob;

	@FindBy(name="$PDCPTestUsersRequestPage$pGender")
	private WebElement genderBox;

	@FindBy(id="Count")
	public WebElement quantity;

	@FindBy(id="RegisteredFlag")
	public WebElement registeredCheckBox;



	@FindBy(xpath="//button[contains(text(),'Create Test Users')]")
	public WebElement createTestUsersBtn;



	@FindBy(xpath="//table[@id='bodyTbl_right']/tbody/tr[2]/td[3]/div/span")
	public WebElement UserName;

	@FindBy(className="gridTable")
	public WebElement userListTable;


	@FindBy(name="$PDCPTestUsersRequestPage$pGender")
	private WebElement Gender;

	@FindBy(xpath=".//table[@id='bodyTbl_right']//tr//td[3]//span")
	private List<WebElement> usernameList;

	@FindBy(id="bodyTbl_right")
	private WebElement userTable;


	@FindBy(xpath=".//table[@id='bodyTbl_right']//tr//td[5]//span")
	private List<WebElement> populationList;


	@FindBy(xpath=".//table[@id='bodyTbl_right']//tr//td[2]//span")
	private List<WebElement> participaintList;


	@Override
	public boolean isDisplayed() {

		return quantity.isDisplayed();
	}



	public void entertheUsers(String arg1)
	{
		quantity.sendKeys(arg1);
	}

	public void selectGender(String arg1){

		Select Gender = new Select(genderBox);

		Gender.selectByVisibleText(arg1);


	}


	public void enterDob(String arg1) throws InterruptedException
	{
		Thread.sleep(5000);
		
		waitForElementToBeDisplayed(dob);
		
		dob.sendKeys(arg1);
	}

	public void clickOnRegisteredCheckBox()
	{
		waitForElementToBeDisplayed(registeredCheckBox);
		
		registeredCheckBox.click();
	}



	public void selectProgamCategory(String programCategoryName, String populationName) throws InterruptedException {
		// TODO : covert this thread.sleep to wait condition 
		Thread.sleep(8000);

		String programCategoryXpath = "//label[contains(text(),'"+programCategoryName+"')]/../../..//input[@type='checkbox']";


		WebElement programCategory = getWebDriver().findElement(By.xpath(programCategoryXpath));
		
		waitForElementToBeDisplayed(programCategory);
		
		programCategory.click();
		
		// TODO : covert this thread.sleep to wait condition 
		Thread.sleep(8000);

		String populationsXpath = "//label[contains(text(),'"+programCategoryName+"')]/../../..//select";

		WebElement populationsWebEle = getWebDriver().findElement(By.xpath(populationsXpath));

		waitForElementToBeDisplayed(populationsWebEle);

		Select populationSelect = new Select(populationsWebEle);


		if(populationName.isEmpty()){

			if(populationSelect.getFirstSelectedOption().getText().equalsIgnoreCase("No results were found.")){

				populationSelect.selectByIndex(0);

			}else{

				populationSelect.selectByIndex(1);
			}



		}else{

			populationSelect.selectByVisibleText(populationName);

		}
	}





	public void clickOnCreateTestUsers() throws InterruptedException
	{
		// TODO : covert this thread.sleep to wait condition 
		Thread.sleep(5000);

		waitForElementToBeDisplayed(createTestUsersBtn);
		createTestUsersBtn.click();
	}



	public void Alertaccept() throws InterruptedException {

		WebDriverWait WDwait = null;

		ArrayList<Class<? extends Exception>> exceptions = new ArrayList<>();
		exceptions.add(NoAlertPresentException.class);
		exceptions.add(UnhandledAlertException.class);

		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(getWebDriver());
		fluentWait.withTimeout(Duration.ofSeconds(120))
		.pollingEvery(Duration.ofSeconds(2))
		.ignoreAll(exceptions);

		Alert alert = fluentWait.until(ExpectedConditions.alertIsPresent());

		alert.accept();

		}


	public void getusersfromlist(int i)
	{


		String xpath ="//table[@id='bodyTbl_right']/tbody/tr/td[" + i + "]/div/span";

		List<WebElement> tablecol=getWebDriver().findElements(By.xpath(xpath));
		List<String> userName=new ArrayList<String>();
		for(int j=0;j<10;j++)
		{
			String Data=tablecol.get(j).getText();
			userName.add(Data);
		}



	}



	public List<String> getUserNames(int number){
		waitForElementToBeDisplayed(userTable);
		return getRequiredTextsFromList(number, usernameList);
	}

	public List<String> getPopulationId(int number){
		waitForElementToBeDisplayed(userTable);
		return getRequiredTextsFromList(number, populationList);
	}


	public List<String> getParticiapaintId(int number){
		waitForElementToBeDisplayed(userTable);
		return getRequiredTextsFromList(number, participaintList);
	}

	private List<String> getRequiredTextsFromList(int number,List<WebElement> element){
		List<String> requiredtexts = new ArrayList<String>();
		for(int i=0;i<number;i++){
			requiredtexts.add(element.get(i).getText().trim());
		}
		return requiredtexts;

	}

	public void selectDefaultValueInProgramCategory() throws InterruptedException{


		/*selectProgamCategory("Disease Management", "HNET.DM.HNET.UCCommercial.DM(1043)");
		selectProgamCategory("WCH", "HNET.WCH.HNET.Commercial.CA.WCH(1120)");
		selectProgamCategory("Coaching", "");
		selectProgamCategory("LC", "HNET.LC.HNET.CalpersMED.LC(2014)");
		selectProgamCategory("QFL", "HNET.Q4L.HNET.Medicare.Q4L(2964)");*/

		selectProgamCategory("Disease Management", "");
		selectProgamCategory("WCH", "");
		selectProgamCategory("Coaching", "");
		selectProgamCategory("LC", "");
		selectProgamCategory("QFL", "");

	}

	public String fillMandatoryFieldsAndGetOneUser (String gender,int age) throws InterruptedException{

		entertheUsers("1");
		selectGender(gender);
		enterDob(DateTimeUtils.getDOB(age));
		clickOnRegisteredCheckBox();
		selectDefaultValueInProgramCategory();
		clickOnCreateTestUsers();
		Alertaccept();

		return getUserNames(1).get(0);
	}

	public String fillMandatoryFieldsAndGetOneUserForUnregistered (String gender,int  age) throws InterruptedException{

		entertheUsers("1");
		selectGender(gender);
		enterDob(DateTimeUtils.getDOB(age));
		selectDefaultValueInProgramCategory();
		clickOnCreateTestUsers();
		Alertaccept();

		return getUserNames(1).get(0);
	}

}
