#Author: Mohammed Najeebuddin
@DomainReporting
Feature: WBA OverAllReportSummary scenarios

@UI @UIRegression @Regression @OverAllWellBeing=(66-100)
  Scenario: Complete WBA Questionnaire for Participant so that OverAllWellBeing is in Range=(66-100)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(66-100)|
    Then i validate the OverAll WellBeingScore = "82"

@UI @UIRegression @Regression @OverAllWellBeing=(33-65)
  Scenario: Complete WBA Questionnaire for Participant so that OverAllWellBeing is in Range=(33-65)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(33-65)|
    Then i validate the OverAll WellBeingScore = "45"

@UI @UIRegression @Regression @OverAllWellBeing=(0-32)
  Scenario: Complete WBA Questionnaire for Participant so that OverAllWellBeing is in Range=(0-32)
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | OverAllScore=(0-32)|
    Then i validate the OverAll WellBeingScore = "11"