#Author: Devika V

@Incentives
Feature: Incentives scenarios

@Smoke @SmokeUI @UI @Incentives-Login
  Scenario: Under Rewards credits dropdown and content card validation
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    And Login to AlerePortal using C3 Created userName and Password
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    Then Verify WBA Content Card and click on "Get started" button
    And Verify and click on "Get started" button in creditDetails page
    
@Smoke @SmokeUI @UI @UI @UIRegression @Regression @WBARegression @validatingCreditScoreFromReward
  Scenario: validatingCreditScore in credits page under your credits section
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    And verify credits points on the credits page
    
@Smoke @SmokeUI @UI @UI @UIRegression @Regression @WBARegression @ValidatingCreditScore
  Scenario: validatingCreditScore in home page on top right corner of the page
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    And verify credits points on the page