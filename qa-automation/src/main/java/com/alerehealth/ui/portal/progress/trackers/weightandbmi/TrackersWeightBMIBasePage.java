package com.alerehealth.ui.portal.progress.trackers.weightandbmi;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alerehealth.ui.portal.progress.trackers.TrackersBasePage;

public class TrackersWeightBMIBasePage extends TrackersBasePage {

                @FindBy(xpath="//div[@class='segmented-bar clear']//li/a")
                private List<WebElement> weightBMIPageTabs;
                
                @FindBy(xpath="//div[@class='page columns-sidebar']//h1")
                private WebElement weightBMIPageVerficationText;
                
                private void selectTopNavigationTabs(String tab)
                {
                                for(WebElement element:weightBMIPageTabs)
                                {
                                                if(element.getText().equals(tab))
                                                                
                                                {
                                                                javaScriptClick(element);
                                                     break;
                                                }
                                }
                }
                
                public TrackersWeightBMITracPage navigateToTrackTab()
                {
                                selectTopNavigationTabs("Track");
                                return new TrackersWeightBMITracPage();
                                
                }
                
                /*public TrackersWeightBMIProgressPage navigateToProgressTab()
                {
                                selectTopNavigationTabs("Progress");
                                return new TrackersWeightBMIProgressPage();
                                
                }*/
                
                public TrackersWeightBMIJournalPage navigateToJournalTab()
                {
                                selectTopNavigationTabs("Journal");
                                return new TrackersWeightBMIJournalPage();
                                
                }
                
               /* public TrackersWeightBMIGoalPage navigateToGoalTab()
                {
                                selectTopNavigationTabs("Goal");
                                return new TrackersWeightBMIGoalPage();
                                
                }*/
                
                public List<String> getTopNavigationHeader()
                {
                                List<String> tabText=new ArrayList<>();
                                
                                for(WebElement element:weightBMIPageTabs)
                                {
                                tabText.add(element.getText().trim());                
                                }
                                
                                return tabText;
                }
                
                
                @Override
                public boolean isDisplayed() {
                                return getWebDriver().findElement(By.xpath("//a[@class='selected icon icon_checkmark'][text()='Weight & BMI  ']")).isDisplayed();
                                
                }
                
}
