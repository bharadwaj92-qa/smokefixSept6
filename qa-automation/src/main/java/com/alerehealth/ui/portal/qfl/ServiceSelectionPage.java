package com.alerehealth.ui.portal.qfl;

import com.alerehealth.fwk.selenium.common.SeleniumPage;
import com.alerehealth.ui.portal.common.pages.SignUpPage;
import com.alerehealth.ui.portal.qfl.InterventionSelectionPage;
import com.alerehealth.ui.portal.qfl.QFLProgramServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServiceSelectionPage extends SeleniumPage<ServiceSelectionPage> {

    @FindBy(xpath = "//button[contains(@class,'btn--primary')]")
    private WebElement continueButton;
/*    public void checkServices(){

        String xpath = "//*[@type='checkbox']";

        List<WebElement> mycheckBox = getWebDriver().findElements(By.xpath(xpath));
        for(WebElement checkBox : mycheckBox){

//            if(checkBox.getAttribute("selected").equals("null")){

                //javaScriptClick(button);
                checkBox.click();
//                break;
 //           }
        }
    }*/
    public void clickSelectionContinueButton(String buttonText){

        String xpath = "//button[contains(@class,'btn--primary')]";

        List<WebElement> buttons = getWebDriver().findElements(By.xpath(xpath));

        for(WebElement button : buttons){

            if(button.getText().trim().contains(buttonText)){

                //javaScriptClick(button);
                button.click();
                break;
            }
        }
    }

    public void selectService(String serviceName){

        String xpath = "//*[@class='header' and text()='"+serviceName+"']/ancestor::a[contains(@class,'tile--bug')]//input[@type='checkbox']/../label";

        System.out.println(xpath);

        getWebDriver().findElement(By.xpath(xpath)).click();

    }

    public void selectAllServices(){

        for (QFLProgramServices qflService : QFLProgramServices.values()) {

            selectService(qflService.toString());

        }

    }


    public SignUpPage selectServices(){
        waitForElementToBeDisplayed(continueButton);
        selectAllServices();
//        checkServices();
        clickSelectionContinueButton("Continue");
        clickSelectionContinueButton("Continue");
        return new SignUpPage();
    }
    
    public SignUpPage selectIndividualService(String serviceName){
        
    	String xpath = "//*[@class='header' and text()='"+serviceName+"']/ancestor::a[contains(@class,'tile--bug')]//input[@type='checkbox']/../label";

        System.out.println(xpath);

        getWebDriver().findElement(By.xpath(xpath)).click();
        clickSelectionContinueButton("Continue");
        clickSelectionContinueButton("Continue");
        return new SignUpPage();
    }
    
    public boolean isAcceptChechBoxSelected(){
    	
    	String xpath = "//input[@id='acceptId']";
    	WebElement eleCheckbox = getWebDriver().findElement(By.xpath(xpath));
    	boolean value = eleCheckbox.isSelected();
    	System.out.println(value);
    	return eleCheckbox.isSelected();
    }
    
   

    @Override
    public boolean isDisplayed() {
        return continueButton.isDisplayed();
    }
}
