@WBANavigations
Feature: WBA Save & Exit scenario

  @UI @UIRegression @Regression @WBARegression @SaveandExit
  Scenario: GetQuestionarrieDetails
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer some questions and click on Save and Exit button 


  @UI @UIRegression @Regression @WBARegression @SaveandExitforZeroCredits
  Scenario: Verify credit points for save and exit questionnaire in navigation header for credits
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer some questions and click on Save and Exit button 
    And verify zero credits points on the page
   
   
  @UI @UIRegression @Regression @WBARegression @Previousbutton
  Scenario: WBA Previous button scenario
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    And Answer some questions and click on previous button
    
   
   