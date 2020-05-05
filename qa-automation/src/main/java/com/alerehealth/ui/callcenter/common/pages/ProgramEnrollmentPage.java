package com.alerehealth.ui.callcenter.common.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alerehealth.ui.callcenter.mainmenu.CallCenterOthersHomeMenuPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.and;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;


public class ProgramEnrollmentPage extends CallCenterOthersHomeMenuPage {
	
   //LC enrollment page for to complete assessment to enroll to the LC program
	
	@FindBy(xpath = "//div[@id='EXPAND-INNERDIV']//tr[5]//p[contains(text(),\"If you're interested I can get you started in the coaching program today.\")]")
	public WebElement assessmentQ1;
	
	//div[@id='EXPAND-INNERDIV']//tr[5]//p[contains(text(),'If you're interested I can get you started in the coaching program today.')]

	@FindBy(xpath = "//p[@class='Assessment_Question' and contains(text(),'Do you currently use email?')]")
	public WebElement assessmentQ2Yes;
	
	@FindBy(xpath = "(//*[@id='EXPAND-INNERDIV']/table//tr[2]//input[@type='radio'])[1]")
	public WebElement Q2answerasYes;
	
	@FindBy(xpath = "//input[@value='Print']")
	public WebElement printCheckboxIfYes;
	
	@FindBy(xpath = "//select[@name = '$PpyWorkPage$pEnrollmentDisposition']")
	public WebElement dropDownOfEnrollmentDisposition;
	
	@FindBy(xpath = "//button[@id='submitButton']")
	public WebElement submitBtn;
	
	
	
	public WebElement getAssessmentQ1(){
		
        switchToDefault();
		
		waitForPageToLoad();
        
		switchToFrame(iframe1);
    	
		switchToFrame(convsubframe);
    
		switchToFrame(actioniframe);
		
		return assessmentQ1;
	}
	
	public void assessmentQuesLCEnroll() throws InterruptedException{
		
		List<WebElement> radiobtns = getWebDriver().findElements(By.xpath("//*[@id='EXPAND-INNERDIV']/table//tr[7]/td/div/input"));
		
		int radioSize = radiobtns.size();
		
		for(int i=0; i<=radioSize; i++){
			
			String optionsValue = radiobtns.get(i).getAttribute("value");
			
			if(optionsValue.equalsIgnoreCase("Yes")){
				
				waitForPageToLoad();
			
				try{
				  
					radiobtns.get(i).click();
				
				}catch(Exception e){
				
					System.out.println("In catch");
					radiobtns.get(i).click();
					
				}
				
				try{
				System.out.println("User selected yes radio button for Q1: "+assessmentQ1.getText()+ "so Q2 is dislaying as: "+assessmentQ2Yes.getText());
				
				waitForPageToLoad();
				
					javaScriptClick(Q2answerasYes);
				
				}catch(Exception e){
					
					System.out.println("In catch");
					System.out.println("User selected yes radio button for Q1: "+assessmentQ1.getText()+ "so Q2 is dislaying as: "+assessmentQ2Yes.getText());
					waitForPageToLoad();
					javaScriptClick(Q2answerasYes);
					staleIssue(Q2answerasYes);
				
				}
				
				System.out.println("Clicked on yes for email question.");
				
				/*
				 * click on print checkbox if yes was selected for Q1
				 */
				
				waitForSpecifiedTime(30);
				
				try{
					System.out.println("IN try");
					
					javaScriptClick(printCheckboxIfYes);
				
				}catch(Exception e){
					
					System.out.println("In catch");
					staleIssue(printCheckboxIfYes);
				}
				
				break;
			}
				
		} 
		
		
		/*
		 * Select Enrollment disposition as Accept from dropdown
		 */
		
		waitForPageToLoad();
        
		//WebDriverWait WDwait = new WebDriverWait(getWebDriver(), 30);
		
		//WebElement enrollmentdropdwn = WDwait.until(ExpectedConditions.elementToBeClickable(dropDownOfEnrollmentDisposition));
		
		WebDriverWait wait = new WebDriverWait(getWebDriver(),30);
		Select enrollmentDispositionDropDownValues;
		try{
        
			wait.until(ExpectedConditions.and((not(ExpectedConditions.stalenessOf(dropDownOfEnrollmentDisposition))),ExpectedConditions.visibilityOf(dropDownOfEnrollmentDisposition)));
		
			enrollmentDispositionDropDownValues = new Select(dropDownOfEnrollmentDisposition);
			
		}catch(Exception e){
		
			System.out.println("In catch");
		
			enrollmentDispositionDropDownValues = new Select(dropDownOfEnrollmentDisposition);
		}
		waitForPageToLoad();
		
		Thread.sleep(2000);
		
		enrollmentDispositionDropDownValues.selectByVisibleText("Accept");
		
		waitForPageToLoad();
		
		System.out.println("Clicked dropdown and selected.");
		
		
		/*
		 * Click on submit button to complete enrollment to LC
		 */
		javaScriptClick(submitBtn);
		
	}
	
	@Override
    public boolean isDisplayed() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		switchToDefault();
		
		waitForPageToLoad();
        
		switchToFrame(iframe1);
    	
		switchToFrame(convsubframe);
    
		switchToFrame(actioniframe);
    	
		WebDriverWait WDwait = new WebDriverWait(getWebDriver(), 50);
		
		WDwait.until(ExpectedConditions.visibilityOf(assessmentQ1));
        
		return assessmentQ1.isDisplayed();

    }
	
	
}
