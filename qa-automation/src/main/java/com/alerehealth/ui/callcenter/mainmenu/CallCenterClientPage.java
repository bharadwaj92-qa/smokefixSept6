package com.alerehealth.ui.callcenter.mainmenu;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.selenium.common.TableHelper;
import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;

public class CallCenterClientPage extends CallCenterHomePage{
	
	@FindBy(xpath = "//*[@class='cursordefault titleBarLabelStyleExpanded']")
	private WebElement titleBarClient360Tab;

    @FindBy(id="f360k")
    protected WebElement clientPageIframe;
    
	@FindBy(xpath = "//*[@class='titleBarIconSPANNoExpand']")
	private WebElement expandmodeInsuranceDetails;
	
	@FindBy(id="convIframe")
	public WebElement convIframe1;

	@FindBy(id="convIframe_sub")
	public WebElement convIframeSub1;
	
	public boolean isDisplayed() {

		getWebDriver().switchTo().defaultContent();
		switchToFrame(pegaGadgetFrame360Tab);
		switchToFrame(clientPageIframe);
		waitForElementToBeDisplayed(titleBarClient360Tab);
		return titleBarClient360Tab.isDisplayed();

	}
	
	public void selectNRTTab(String tabName) {
		getWebDriver().switchTo().defaultContent();
		switchToFrame(pegaGadgetFrame360Tab);
		String xpath = "//td[@class='p360bar']//li/div[@title='"+tabName+"']";
		WebElement pega360Tab = getWebDriver().findElement(By.xpath(xpath));
		waitForElementToBeDisplayed(pega360Tab);
		//pega360Tab.click();
		javaScriptClick(pega360Tab);
		// return new CallCenterDevicesPage();
	}

	public String clientInsurancedetailssection(String option){
		String insuranceDetailSectionXpath = "//*[contains(@class,'dataLabelWrite')]//label[text()='"+option+"']";
		WebElement elementInsuranceSectionOptions = getWebDriver().findElement(By.xpath(insuranceDetailSectionXpath));
		
		return elementInsuranceSectionOptions.getText().trim();
		
	}
	
    public String  getTitleOfClientPage(){
    	
        return titleBarClient360Tab.getText().trim();
    }
    
	public boolean isexpandmodeInsuranceDetailsPresent() {

		try {
			return expandmodeInsuranceDetails.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
	
	
	public boolean isclientLabelExpand(String expandLabel) {

		String clientExpandXpath = "//*[contains(@class,'titleBarLabelStyle') and contains(text(),'"+expandLabel+"')]/ancestor::td[contains(@class,'titleBarBackground')]/preceding-sibling::td[@class='titleBarIconExpanded']";

		try {
			WebElement elementclientExpand = getWebDriver().findElement(By.xpath(clientExpandXpath));
			return elementclientExpand.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}
	
	/**
	 * Method to expand or collapse a Section in Clients tab. 
	 * @param sectionLabel to expand
	 * @param action: pass expand to expand the section, collapse to collapse 
	 */
	
	public void expandOrCollapseSection(String sectionLabel, String action){
				
		boolean labelExpand = isclientLabelExpand(sectionLabel); 
		
		if(action.toLowerCase().contains("expand")){
			
			if(!labelExpand){
				
				String clientcollapseXpath = "//*[contains(@class,'titleBarLabelStyle') and contains(text(),'"+sectionLabel+"')]/ancestor::td[contains(@class,'titleBarBackground')]/preceding-sibling::td[@class='titleBarIconCollapsed']";
				WebElement elementclientcollapse = getWebDriver().findElement(By.xpath(clientcollapseXpath));
				System.out.println("Clicking collapse");
				javaScriptClick(elementclientcollapse);
				
			}
			
		}
		else{
			
			if(labelExpand){
				
				//TODO: Write code to collapse
				
			}
			
			
		}
		
		
	}
	
	
    public List<String>  getTitlesOfClientDetailsEditSection(){
    	
    	String xpath = "//*[@id='EXPAND-INNERDIV']//td[@class='dataValueWrite']//table//b[starts-with(text(),'C')]";

		List<WebElement> clientInsuranceDetailsEditSection = getWebDriver().findElements(By.xpath(xpath));

		List<String> sectionMenuText=new ArrayList<String>();

		clientInsuranceDetailsEditSection.forEach(menuEle ->sectionMenuText.add(menuEle.getText().trim()) );

		return sectionMenuText;

    }
    
    
	@FindBy(id = "PopulationAssignmentList.pxResults1")
	private WebElement programCategoryClientName;
    
    public String getTitleprogramCategoryClientName(){
    	
    	return programCategoryClientName.getText().trim();
    	
    }
    
    
  //Added Elements
  	@FindBy(xpath="//table[@summary='ConfigOptions']")
  	private  WebElement configTableElement;

      List<String> configOptionNamesDetails = new ArrayList<String>();

  	List<Integer> value;

  	List<String>  configValues;

  	private TableHelper tableHelper ;
  	
  	
  	
  	
  //Added code
    public List<String>  getConfigOptionColumnNames(){
     
     setTableHelper(new TableHelper(getWebDriver(), configTableElement));
     
     List<String> cols = tableHelper.getColumnNames();
     
     System.out.println("Config Options Column Names:" + cols);
     
     return cols;
  
    }
    
    
    
    public List<String> getConfigRowDataValue(String colName,String colValue, String colName1, String colName2){
     
     List<Integer> value = tableHelper.getMultiRowNumber(colName,colValue);
     System.out.println("Row numbers:" + value);
     
     List<String>  configValues = new ArrayList<String>();
    
     for(Integer row: value){
     
     System.out.println(colName + ":" + colValue);
     configValues.add(tableHelper.getCellValue(colName1, row));
     configValues.add(tableHelper.getCellValue(colName2, row));
     //configValues.add(tableHelper.getCellValue(colName3, row));

     }
     
     System.out.println(configValues);
     
     return configValues;
    }
  
    public TableHelper getTableHelper() {
	return tableHelper;
	}

	public void setTableHelper(TableHelper tableHelper) {
	this.tableHelper = tableHelper;
	}
    	
}
