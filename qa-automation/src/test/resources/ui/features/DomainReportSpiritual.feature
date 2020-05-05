#Author: Mohammed Najeebuddin
@DomainReporting
Feature: WBA DomainReportSpiritual scenarios

@UI @UIRegression @Regression @SpiritualScore=(66-100)
  Scenario: Verification of report for Spiritual category - Strong in Range (66-100)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(66-100)|
    And I click on view report button
    Then I validate the "spiritual"domain score "100" and description
    
@UI @UIRegression @Regression @SpiritualScore=(33-65)
  Scenario: Verification of report for Spiritual category - Average in Range (33-65)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(33-65)|
    And I click on view report button
    Then I validate the "spiritual"domain score "37" and description
    
@UI @UIRegression @Regression @SpiritualScore=(0-32)
  Scenario: Verification of report for Spiritual category - Poor in Range (0-32)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(0-32)|
    And I click on view report button
    Then I validate the "spiritual"domain score "7" and description
    

    