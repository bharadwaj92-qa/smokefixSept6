#Author: Mohammed Najeebuddin
@DomainReporting
Feature: WBA DomainReportSocial scenarios

@UI @UIRegression @Regression @SocialScore=(66-100)
  Scenario: Verification of report for Social category - Strong in Range (66-100)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(66-100)|
    And I click on view report button
    Then I validate the "social"domain score "81" and description
    
@UI @UIRegression @Regression @SocialScore=(33-65)
  Scenario: Verification of report for Social category - Average in Range (33-65)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(33-65)|
    And I click on view report button
    Then I validate the "social"domain score "48" and description
    
@UI @UIRegression @Regression @SocialScore=(0-32)
  Scenario: Verification of report for Social category - Poor in Range (0-32)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(0-32)|
    And I click on view report button
    Then I validate the "social"domain score "22" and description
    

    