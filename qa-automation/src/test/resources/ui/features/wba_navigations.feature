#Author: Mohammed Najeebuddin
@WBANavigations
Feature: WBA Navigations validations
Background: Login from WBA QA
		 Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
     Given Login to AlerePortal using C3 Created userName and Password
@HomePage @UI @UIRegression @Regression @WBANavigation_TC_01
Scenario: Verification of WBA Navigation from Home Page content card
		When Verify and Click on the WBA content Card
		Then I navigate to WBA Landing page and verify the WBA text
@Rewards @UI @UIRegression @Regression @WBANavigation_TC_02
Scenario: Verification of WBA Navigation from Rewards Page
		When Click on "Rewards" Drop down from Top Navigation
		And Click on Credits link from sub drop down
		Then Verify WBA Content Card and click on "Get started" button 
@Progress @UI @UIRegression @Regression @WBANavigation_TC_03
Scenario: Verification of WBA Navigation from Progress drop down
		When Click on "Progress" Drop down from Top Navigation
		And Click on Health Risk Questionnaire link
		Then I navigate to WBA Landing page and verify the WBA text
@MemberResourceCenter @UI @UIRegression @Regression @WBANavigation_TC_04
Scenario: Verification of WBA Navigation from Member Resource Center drop down
		When Click on "Member Resource Center" Drop down from Top Navigation and Click on "Wellness Resources" link
		And Click on Health Risk Questionnaire link
		Then I navigate to WBA Landing page and verify the WBA text