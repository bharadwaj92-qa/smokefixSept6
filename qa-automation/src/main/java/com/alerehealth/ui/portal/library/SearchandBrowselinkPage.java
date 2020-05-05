package com.alerehealth.ui.portal.library;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.actionplan.ActionPlanQuestionnaireStartingPage;
import com.alerehealth.ui.portal.coaching.WellnessPage;
import com.alerehealth.ui.portal.common.pages.PortalHomePage;

public class SearchandBrowselinkPage extends PortalHomePage {
	
    @FindBy(xpath = "//*[contains(text(),'How can we help you?')]")
    private WebElement searchBrowseLinkPage;
  
    @FindBy(xpath = "//*[@class='card-content']")
    private WebElement wellnessPage;
    
    @FindBy(xpath = "//*[@class='tile-header']//h1[contains(text(),'Seminar: D')]")
    private WebElement seminarLink;
  
    @FindBy(id="ognBreadcrums")
    protected WebElement breadCrumbContainerlist;
    
    @FindBy(id="searchEntry")
    private WebElement searchField; 
    
  
 
	public void clickLibraryContentCard(String contentCardTitle){
		
		String xpath = "//*[@class='header' and text()='"+contentCardTitle+"']/ancestor::a[@class='tile tile-image-icon has-image']";
//		String xpath = "//*[@class='tile tile-image-icon has-image']//div//h1[text()='"+contentCardTitle+"']";
		
		WebElement libraryContentCardsBtn = getWebDriver().findElement(By.xpath(xpath));
		
		libraryContentCardsBtn.click();

	}
	
	public LibraryPage clickWellnessTab(){

		clickLibraryContentCard(LibraryConstants.LIBRARY_WELLNESS_PAGE_TITLE);

		return new LibraryPage();

	}
	
	public LibraryPage clickConditionsTab(){

		clickLibraryContentCard(LibraryConstants.LIBRARY_CONDITIONS_PAGE_TITLE);

		return new LibraryPage();

	}
	
	public LibraryPage clickPregnancyBabyTab(){

		clickLibraryContentCard(LibraryConstants.LIBRARY_PRGEGNANCY_BABY_PAGE_TITLE);

		return new LibraryPage();

	}
	
	public LibraryPage clickTobaccoFreeTab(){

		clickLibraryContentCard(LibraryConstants.LIBRARY_TOBACOO_FREE_PAGE_TITLE);
		
		return new LibraryPage();

	}
	

	
	@Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(searchField);

        return searchField.isDisplayed();
    }


  
    public String getNavigationFromBreadCrumb(){

        String completeNavigation = "";
        List<WebElement> navigationList =  breadCrumbContainerlist.findElements(By.tagName("li"));

        int counter = 0;
        for(WebElement navigation : navigationList){

            String temp = navigation.getText().trim();

            if(temp.isEmpty()){

                WebElement atag = navigation.findElement(By.tagName("a"));

                completeNavigation +=(atag.getText().trim());

            }else{

                completeNavigation+=temp;
            }

            if(counter<=navigationList.size()-1){

                completeNavigation+=">";

                counter++;

            }

        }

        return completeNavigation;
    }




}
