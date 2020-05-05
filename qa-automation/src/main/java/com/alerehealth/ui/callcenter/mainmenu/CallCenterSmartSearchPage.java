package com.alerehealth.ui.callcenter.mainmenu;

import com.alerehealth.ui.callcenter.common.pages.CallCenterHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CallCenterSmartSearchPage extends CallCenterHomePage{

    @FindBy(xpath = "//a[@id='home_headerbar_icon_search_b']//i")
    protected WebElement searchIconHighlighted;


    @FindBy(id="home_results_iframe")
    protected WebElement othersPageIframe;

    @FindBy(id="home_criteria_table_sub_iframe")
    protected WebElement searchCriteriaIframe;


    @FindBy(xpath="//div[@id='CT' and not(contains(@style,'display: none'))]//*[@name='$PSearchCriteria$pSmartSearchTerm']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='CT' and not(contains(@style,'display:none'))]//div[text()='Advanced Search']/ancestor::button")
    private WebElement advancedSearchButton;

    public void performSmartSearch(String search){


        switchToFrame(othersPageIframe);

        waitForElementToBeDisplayed(searchField);

        searchField.clear();

        searchField.sendKeys(search);

        searchField.sendKeys(Keys.ENTER);


    }


    public void selectSearchResultFromAutoComplete(String resultContent){

        String xpath = "//ul[contains(@class,'ui-autocomplete') ]//*[contains(text(),'"+resultContent+"')]/ancestor::a";

        waitForComponentTobDisplayed(By.xpath(xpath));

        WebElement result = getWebDriver().findElement(By.xpath(xpath));

        javaScriptClick(result);



    }

    private int getColumnIndexOfSearchResults(String columnName){

        String xpath = "//*[@id='bodyTbl_right']//th//*[contains(@class,'cellIn')]";

        waitForComponentTobDisplayed(By.xpath(xpath));

        List<WebElement> columnElements = getWebDriver().findElements(By.xpath(xpath));

        int index = 1;

        for(WebElement col: columnElements){

            if(col.getText().trim().equals(columnName)){

                break;
            }
            index++;

        }

        return index;
    }


    public String getSearchResult(String columnName, int rowNum){

        int columnNum = getColumnIndexOfSearchResults(columnName);

        String xpath = "//*[@id='bodyTbl_right']//tr["+(rowNum+1)+"]//td["+(columnNum)+"]";

        System.out.println(xpath);

        WebElement searchResultEle = getWebDriver().findElement(By.xpath(xpath));

        String fieldValue = searchResultEle.getText().trim();

        return fieldValue;
    }

    public CallCenterAdvancedSearchPage clickAdvancedSearch(){

        switchToFrame(othersPageIframe);

        waitForElementToBeDisplayed(advancedSearchButton);

        javaScriptClick(advancedSearchButton);

        waitForSpecifiedTime(35);

        return new CallCenterAdvancedSearchPage();
    }

    public CallCenterHomePage gotoHomePage(){
    	
    	CallCenterHomePage homePage = null;
    	
    	getWebDriver().switchTo().defaultContent();
    	    	
    	WebElement homepageclick= getWebDriver().findElement(By.id("home_headerbar_icon_home_a"));
        javaScriptClick(homepageclick);
        
    	waitForSpecifiedTime(10);
    	
    	homePage = new CallCenterHomePage();
    	
    	return homePage;   	
    }
    
    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(searchIconHighlighted);
        return searchIconHighlighted.isDisplayed();
    }
}
