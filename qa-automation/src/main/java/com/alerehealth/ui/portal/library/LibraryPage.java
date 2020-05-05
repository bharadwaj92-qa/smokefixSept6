package com.alerehealth.ui.portal.library;

import com.alerehealth.ui.portal.common.pages.PortalHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LibraryPage extends PortalHomePage {


    @FindBy(className = "nav-list")
    private WebElement topicsListContainer;

    @FindBy(id="breadcrumblist")
    private WebElement breadCrumbContainer;

    public String getTitle(){

       WebElement headerEle =  getWebDriver().findElement(By.xpath("//*[@class='card-header']//h1"));

       String headerText =  headerEle.getText().trim();

       headerText =  headerText.replace("import_contacts","");

       return headerText;

    }

    public String getNavigationFromBreadCrumb(){

        String completeNavigation = "";
        List<WebElement> navigationList =  breadCrumbContainer.findElements(By.tagName("li"));

        int counter = 0;

        for(WebElement navigation : navigationList){

            String temp = navigation.getText().trim();

            if(temp.isEmpty()){

                WebElement atag = navigation.findElement(By.tagName("a"));

                completeNavigation +=(atag.getText().trim());

            }else{

                completeNavigation+=temp;
            }

            if(counter<navigationList.size()-1){

                completeNavigation+=">";

                counter++;

            }

        }

        return completeNavigation;
    }

    public void scrollNavigationMenuIntoView(){

        scrollElementIntoView(navigationMenu);

    }

    @Override
    public boolean isDisplayed() {

        waitForElementToBeDisplayed(topicsListContainer);
        return topicsListContainer.isDisplayed();
    }
}
