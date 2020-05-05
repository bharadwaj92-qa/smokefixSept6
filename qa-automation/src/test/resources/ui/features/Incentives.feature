@WBANavigations
Feature: WBA Incentives scenario

  @UI @UIRegression @Regression @WBARegression @Incentives
  Scenario: Incentives
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    Then Verify WBA Content Card and click on "Get started" button
    And Verify and click on "Get started" button in creditDetails page

  @UI @UIRegression @Regression @WBARegression @IncentivesTc2
  Scenario: Incentives
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    Then Verify WBA Content Card and click on "Get started" button
    And Verify and click on "Get started" button in creditDetails page
    And Verify WBA landing page and click on the button
    # When Answer WBA Questionnaire as per Sheet with WBA Validations
    #  | sheetname | Scenario 3 age = 50 |
    When Answer some questions and click on Save and Exit button
    And Click on client logo
    Then Verify WBA content Card "Finish Assessment" button name
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    And Verify and Click on "Resume" button
    And Verify and Click on "Resume" credit detail button

  @UI @UIRegression @Regression @WBARegression @validatingCreditScoreFromReward
  Scenario: validatingCreditScore in credits page under your credits section
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 3 age = 50 |
     And Click on client logo
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    And verify credits points on the credits page

  @UI @UIRegression @Regression @WBARegression @ValidatingCreditScore
  Scenario: validatingCreditScore in home page on top right corner of the page
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 3 age = 50 |
    And verify credits points on the page

  @UI @UIRegression @Regression @WBARegression @ValidatingCreditScoreonHistoryPage
  Scenario: validatingCreditScore in history page
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 3 age = 50 |
      #And Click on client logo
    When Click on "Rewards" Drop down from Top Navigation
    And Click on History link from sub drop down
    And verify credits points on the history page
