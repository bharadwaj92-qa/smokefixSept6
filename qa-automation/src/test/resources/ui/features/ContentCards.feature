@WBANavigations
Feature: Content Card scenario

  @UI @UIRegression @Regression @WBARegression @ZeroStateContentinRewardspage
  Scenario: Verification of WBA Zero State content card in Rewards Page
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    Then Verify WBA Content Card and click on "Get started" button

  @UI @UIRegression @Regression @WBARegression @WBAEngagedStateinHomePage
  Scenario: Verification of WBA Engaged  State content card in Home Page
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer some questions and click on Save and Exit button
    And Click on client logo
    And User can able to see "Finish Assessment" link
    Then Click on the "Finish Assessment" link
    Then User able to see "Complete Assessment" button
