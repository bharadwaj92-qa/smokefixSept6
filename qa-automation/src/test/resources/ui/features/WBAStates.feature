@WBANavigations
Feature: WBA Navigations validations

 @UI @UIRegression @Regression @WBARegression @AcceptToUPage_PortalLogin
  Scenario: Portal Login
  #The below line will handle TOU page after login 
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    
  
 @UI @UIRegression @Regression @WBARegression @WBAZeroStateHomePage
  Scenario: WBA Zero State  in content card  in home page
     Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
     Given Login to AlerePortal using C3 Created userName and Password
     When Verify and Click on the WBA content Card
		 Then I navigate to WBA Landing page and verify the WBA text  
  
 @UI @UIRegression @Regression @WBARegression @WBAZeroStateincontentcard
  Scenario: WBA Zero State  in content card  in Reward page
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password  
    When Click on "Rewards" Drop down from Top Navigation
		And Click on Credits link from sub drop down
    Then Verify WBA Content Card and click on "Get started" button
    And Verify and click on "Get started" button in creditDetails page
    Then I navigate to WBA Landing page and verify the WBA text
    
 @UI @UIRegression @Regression @WBARegression @WBAEngagedStateHomepage  
  Scenario:  WBA Engaged  State content card in Home Page
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password 
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer some questions and click on Save and Exit button
    And Click on client logo
    Then Verify WBA content Card and Click on "Finish Assessment" button name
    Then I navigate to WBA Landing page and verify the WBA text as Complete your questionnaire
    And Verify and click on "Complete Assessment" button in homePage
     

 @UI @UIRegression @Regression @WBARegression @WBAEngagedStateinRewardPage	 
   Scenario:  WBA Engaged  State content card in Rewards Page
     Given Login to AlerePortal using userName and Password
      | username  | test446978@gn.com |
      | password   | asdf |
		When Click on "Rewards" Drop down from Top Navigation
		And Click on Credits link from sub drop down
		And  Verify and Click on "Resume" button
		And  Verify and Click on "Resume" credit detail button
		And Verify and click on "Complete Assessment" button in homePage
		
 @UI @UIRegression @Regression @WBARegression @WBACompletedStateinHomePage
   Scenario: WBA Completed State in home page 
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password 
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario1-age is 30 M|
    And Click on client logo
    Then verify is Health Risk Questionnaire Content Card Display in HomePage
    
 
 @UI @UIRegression @Regression @WBARegression @WBACompletedStateinRewardPage  
   Scenario: WBA Completed State in home page for questionnaire completed
     Given Login to AlerePortal using userName and Password
      | username  | test446041@gn.com |
      | password   | asdf |
     When Click on "Rewards" Drop down from Top Navigation
     And Click on Credits link from sub drop down
     Then verify is Health Risk Questionnaire Content Card Display in RewardPage
 
 @UI @UIRegression @Regression @WBARegression @WBACompletedStateinProgressDropdown
   Scenario: WBA Completed  State in Progress dropdown  
     Given Login to AlerePortal using userName and Password
      | username  | test446041@gn.com |
      | password   | asdf |
     When Click on "Progress" Drop down from Top Navigation
     And Click on Health Risk Questionnaire link
     And Verify and click on "View Report" button in WBAhomePage
 
  @UI @UIRegression @Regression @WBARegression @WBACompletedStateinReward-HistoryPage
   Scenario: WBA completed  State Content card moved to history module in the rewards section after completing WBA
     Given Login to AlerePortal using userName and Password
      | username  | test446041@gn.com |
      | password   | asdf |
     When Click on "Rewards" Drop down from Top Navigation
     And Click on "History" link from sub drop down
     Then verify is Health Risk Questionnaire Content Card Display in CreditHistoryPage
     
 
     
		