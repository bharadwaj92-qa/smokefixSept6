package com.alerehealth.ui.portal.progress.trackers.weightandbmi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.fwk.api.utils.DateTimeUtils;
import com.alerehealth.ui.portal.progress.constants.TrackersConstants;
import com.alerehealth.ui.portal.progress.trackers.activity.TrackersActivityBasePage;


public class TrackersWeightBMITracPage extends TrackersWeightBMIBasePage {
                
	@FindBy(xpath = "//a[contains(text(),'Activity')]")
	private WebElement lnkactivity;
	
                @FindBy(xpath="//fieldset[@class='track']//li")
                private WebElement trackRadioButton;
                
                @FindBy(id="dateEntered")
                private WebElement date;
                
                @FindBy(id="hour")
                private WebElement hour;
                
                @FindBy(id="minutes")
                private WebElement minutes;
                
                @FindBy(id="weight")
                private WebElement weight;
                
                @FindBy(xpath="//button[@data-id='heightFeet']")
     private WebElement feet;
                
                @FindBy(xpath="//button[@data-id='heightInches']")
    private WebElement inches;
                
                @FindBy(id="comments")
                private WebElement notesField;
                
                @FindBy(xpath="//*[@id='buttons save_tracker']/button")
                private WebElement saveButton;
                
                @FindBy(xpath="//div[@class='validation-message']")
                private WebElement fieldErrors;
                

                @FindBy(xpath="//div[@class='btn-group bootstrap-select custom-select ampm']//button")
                private WebElement amPmDropDown;
                
                
                public void clearText(String fieldName)
                {
                                
                switch(fieldName){
                                
                                case "notes":
                                                notesField.clear();
                                                break;
                                                
                                case "date":
                                                date.clear();
                                                break;
                                                
                                case "hour":
                                                  hour.clear();
                                                  break;
                                                
                                case "minute":
                                                   actionSendKeys(Keys.chord(Keys.CONTROL,"a"), minutes);
                                       actionSendKeys(Keys.BACK_SPACE);
                                                   break;
                                                   
                                case "weight":
                                                  weight.clear();
                                                  break;                    
                
                }
                }
                
                
                public void enterDate(String date)
                {
                                try{
                                if(!date.isEmpty())
                                {
                                                
                                                clearText("date");
                                                waitForSpecifiedTime(3);
                                                this.date.sendKeys(date);
                                }
                                }
                                
                                catch (NullPointerException e) {
                                                
                                }
                }
                
                
                public void enterTime(String time)
                {
                                
                                clearText("hour");
                                clearText("minute");
                                String splitTime[]=time.split(":");
                                hour.sendKeys(splitTime[0]);
                                minutes.sendKeys(splitTime[1].substring(0, 2));
                                
                                
        String amPm=time.substring(time.length()-2,time.length());
                                
        if(amPm.equals("PM"))
                                                amPmDropDown.sendKeys("PM",Keys.ENTER);
                                else 
                                                amPmDropDown.sendKeys("AM",Keys.ENTER);
                }
                
                
                public void enterWeight(String weight)
                {
                                clearText("weight");
                                this.weight.sendKeys(weight);
                }

                public void enterHeight(String feet,String inches)
                {
                                this.feet.sendKeys(feet,Keys.ENTER);
                                this.inches.sendKeys(inches,Keys.ENTER);
                }
                
                public void enterNotes(String notes)
                {
                                clearText("notes");
                notesField.sendKeys(notes);
                }
                

                public void clickSaveButton()
                {
                                javaScriptClick(saveButton);
                                
                }
                
                public TrackersWeightBMIJournalPage saveTrackEntry()
                {
                                javaScriptClick(saveButton);
                                return new TrackersWeightBMIJournalPage();
                                
                }
                
                
                public String getFieldError(String fieldName)
                                {
                                
                List<WebElement> errorFields=getWebDriver().findElements(By.xpath("//div[@class='validation-message']"));
                
   for(WebElement element:errorFields)
                {
                                String elementId=element.getAttribute("id");
                     if(elementId.contains(fieldName))
                                 return element.getText();
                }
                
                return null;
}              
                 
                 public Map<String, String> getAllFieldErrors()
                {
                                Map<String, String> errors=new HashMap<>();
                                errors.put("Date",getFieldError("date"));
                                errors.put("Hour",getFieldError("hour"));
                                errors.put("Minute",getFieldError("minutes"));
                                errors.put("Weight",getFieldError("weight"));
                                errors.put("Feet",getFieldError("heightFeet"));
                                errors.put("Inch",getFieldError("heightInches"));
                                errors.put("Notes",getFieldError("comments"));
                                
                                 return errors;
                                
                 }
                 
                 public TrackersActivityBasePage navigateToActivityPage(){
                	 
                	 javaScriptClick(lnkactivity);
                	 
                	 return new TrackersActivityBasePage();
                 }
                
                

                @Override
                public boolean isDisplayed() {
                
                                return date.isDisplayed();
                }
}
