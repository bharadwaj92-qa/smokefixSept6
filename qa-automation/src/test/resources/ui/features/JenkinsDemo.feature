#Author: Devika V

Feature: WBA Scenarios

 @DemoUIRegression @Questionnaire_malelessthan55-asthma
  Scenario: Complete WBA Questionnaire for Participant with age = 50
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet
      | sheetname | Scenario 3 age = 50|
    Then i validate the reportSummary page header  
    
 
 @DemoUIRegression @Femaleoverweight @UI @SmokeUI
  Scenario: Questionarrie for Female agelessthan55 ,OverWeight
    Given Create Testuser in C3 tool with gender "Female" Age "56" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet
      | sheetname | Scenario F age>55 overweight |
    Then i validate the reportSummary page header  
    
  @DemoUIRegression @Pediatricdiabetes
  Scenario: Questionarrie for Male agelessthan21 ,pediatric - diabetes
    Given Create Testuser in C3 tool with gender "Male" Age "20" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet
      | sheetname | Scenario1-age is <21 M |
    Then i validate the reportSummary page header
    
  @DemoUIRegression @validatingCreditScoreFromRewardPage
  Scenario: validatingCreditScore in credits page under your credits section
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet
      | sheetname | Scenario 3 age = 50 |
     And Click on client logo
    When Click on "Rewards" Drop down from Top Navigation
    And Click on Credits link from sub drop down
    And verify credits points on the credits page
    
  
  @DemoUIRegression @PreviousbuttonPageforDemo
  Scenario: WBA Previous button scenario
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    And Answer some questions and click on previous button
    
    
 @DemoUIRegression @AdditionalResource_Spiritualfordemo
  Scenario: Verification of additional resource under spiritual
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Spiritual" on left nav in wba results details page
    And Verify and Click on "Spirituality and Your Health" link under "spiritual" section
    And Verify and Click on "Prayer" link under "spiritual" section
    
  @DemoUIRegression @AdditionalResource_Financialfordemo
  Scenario: Verification of additional resource under financial
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet
      | sheetname | IndividualBullets-Report |
    And I click on view report button
    Then Click on "Financial" on left nav in wba results details page
    And Verify and Click on "Saving Money on Medicine" link under "financial" section
    And Verify and Click on "Practical Money Skills" link under "financial" section new
    And Verify and Click on "Consumer Financial Protection Bureau" link under "financial" section new
    And Verify and Click on "Federal Trade Commission" link under "financial" section new
    And Verify and Click on "America Saves" link under "financial" section new
    And Verify and Click on "USA.Gov" link under "financial" section new
    And Verify and Click on "FINRA Investor Education Foundation" link under "financial" section new

  @DemoUIRegression, @WBANavigationMemberresourcedropdown
  Scenario: Verification of WBA Navigation from Member Resource Center drop down
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    When Click on "Member Resource Center" Drop down from Top Navigation and Click on "Wellness Resources" link
    And Click on Health Risk Questionnaire link
    Then I navigate to WBA Landing page and verify the WBA text