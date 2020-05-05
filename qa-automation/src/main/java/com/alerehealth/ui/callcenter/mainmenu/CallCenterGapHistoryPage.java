package com.alerehealth.ui.callcenter.mainmenu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.selenium.common.TableHelper;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterGapHistoryPage extends CallCenterHomePage {
	
	
	private TableHelper tableHelper ;
	
	  @FindBy(id="f360q")
	    protected WebElement gapHistoryPageIframe;
	  
	  @FindBy(xpath = "//span[@class='titleBarLabelStyleExpanded' and contains(text(),'Participant Gaps')]")
		private WebElement titleBarGapHistory360Tab;
	  
	  @FindBy(xpath="//div[@id='lvdata']")
		 private WebElement participantGapTableElement;
	  
	  
	  @FindBy(xpath="//button[@class='buttonTdButton']")
		 private  WebElement participantGapRefreshBtn;
	  
	  
	  @FindBy(xpath="//select[@id='SELECT']")
	  private  WebElement drpDown;
	  
	  
	  @FindBy(xpath="//td[contains(text(),'Displaying')]")
	  private  WebElement txtDisplayingRecords;
	  
	  @FindBy(xpath="//td[@id='1_1']//img[@title='Display Care Gap History']")
	  private  WebElement glassIconParticipantGaps;
	
	
	
	  public TableHelper getTableHelper() {
			return tableHelper;
		}

		public void setTableHelper(TableHelper tableHelper) {
			this.tableHelper = tableHelper;
		}
		

		public boolean isDisplayed() {

			getWebDriver().switchTo().defaultContent();
			switchToFrame(pegaGadgetFrame360Tab);
			switchToFrame(gapHistoryPageIframe);
			waitForElementToBeDisplayed(titleBarGapHistory360Tab);
			return titleBarGapHistory360Tab.isDisplayed();

		}
		
		
		
		 public List<String>  getParticipantGapsColumnNames(){
		    	
		    	//setTableHelper(new TableHelper(getWebDriver(), participantGapTableElement));
		    	
		    	List<String> cols = tableHelper.getColumnNames();
		    	
		    	System.out.println("Participant Gaps Column Names:" + cols);
		    	
		    	waitForElementToBeDisplayed(glassIconParticipantGaps); 
		    	
		    	glassIconParticipantGaps.isDisplayed();
		    	
		    	return cols;
	
		    }
		 
		 
		 public CallCenterGapHistoryPage clickRefreshButton(){
			 
			 waitForElementToBeDisplayed(participantGapRefreshBtn);
			 participantGapRefreshBtn.isDisplayed();
			 javaScriptClick(participantGapRefreshBtn);
			 
			 return new CallCenterGapHistoryPage();
		 }
		 
		 
		 public boolean isPaginationIconDisplayed(String arrowName){
			 
			try{
				String partcipantArrowXpath = "//input[@title='"+arrowName+"']//..";
				WebElement partcipantArrow = getWebDriver().findElement(By.xpath(partcipantArrowXpath));
				waitForElementToBeDisplayed(partcipantArrow);
				partcipantArrow.isDisplayed();
				return true;
				
			}	catch (NoSuchElementException e) {

					return false;
				}
			 
			
		 }
		 
		 
		 public boolean isPaginationDropDownDisplayed(){
			 
			try{ 
				
				 waitForElementToBeDisplayed(drpDown);
				 drpDown.isDisplayed();	
				 
				 return  true;
				
			}
			
			catch (NoSuchElementException e) {

				return false;
			}

		 }
		 
		
		 public boolean validateDisplayingRecordsTxt(){
			 
			 
				try{ 
					
					 waitForElementToBeDisplayed(txtDisplayingRecords);
					 txtDisplayingRecords.isDisplayed();	
					 
					 return  true;
					
				}
				
				catch (NoSuchElementException e) {

					return false;
				}
		 }
		 
		 
		 
		 public String  getTitleOfGapHistoryPage(){
		    	
		        return titleBarGapHistory360Tab.getText().trim();
		    }
		    
		 
		 public String getGapCount(){
			 
			 
			 setTableHelper(new TableHelper(getWebDriver(), participantGapTableElement));		 
				List<Integer> value = tableHelper.getMultiRowNumber("Value","Y");
		    	System.out.println("Row numbers:" + value);
		    	
		    	int values = value.size();
			
			
			    String countValue = Integer.toString(values);
			 
			 return countValue;
		 }
		 
	

}
