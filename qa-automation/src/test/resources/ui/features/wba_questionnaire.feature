@Questionnaire
Feature: WBA questionnaire scenarios

  @UI @UIRegression @Regression @Age=50
  Scenario: Complete WBA Questionnaire for Participant with age = 50
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 3 age = 50|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age=30
  Scenario: Complete WBA Questionnaire for Participant with age = 30
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario1-age is 30 M|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age64M
  Scenario: Complete WBA Questionnaire for Participant with age = 64
    Given Create Testuser in C3 tool with gender "Male" Age "64" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario1- age 64|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age65M
  Scenario: Complete WBA Questionnaire for Participant with age = 65
    Given Create Testuser in C3 tool with gender "Male" Age "66" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario2 - age >=65|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age50M
  Scenario: Complete WBA Questionnaire for Participant with age = 50
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 3 age = 50|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age59M
  Scenario: Complete WBA Questionnaire for Participant with age = 59
    Given Create Testuser in C3 tool with gender "Male" Age "59" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 4 age = 59|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age30F @SmokeUI
  Scenario: Complete WBA Questionnaire for Participant with age = 30
    Given Create Testuser in C3 tool with gender "Female" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 5 age =30 F|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age64F @SmokeUI
  Scenario: Complete WBA Questionnaire for Participant with age = 64
    Given Create Testuser in C3 tool with gender "Female" Age "64" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 5 age=64 F|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Female>=65
  Scenario: Complete WBA Questionnaire for Participant with age = 65
    Given Create Testuser in C3 tool with gender "Female" Age "66" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 6 F age>65|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Female50
  Scenario: Complete WBA Questionnaire for Participant with age = 50
    Given Create Testuser in C3 tool with gender "Female" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 7 - age 50 F|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age59F
  Scenario: Complete WBA Questionnaire for Participant with age = 59
    Given Create Testuser in C3 tool with gender "Female" Age "59" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 8 - age 59 F|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age54F
  Scenario: Complete WBA Questionnaire for Participant with age = 54
    Given Create Testuser in C3 tool with gender "Female" Age "54" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 9 - age 54 F|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Female40
  Scenario: Complete WBA Questionnaire for Participant with age = 40
    Given Create Testuser in C3 tool with gender "Female" Age "40" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 10 - age 40 F|
    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @Age40M
  Scenario: Complete WBA Questionnaire for Participant with age = 40
    Given Create Testuser in C3 tool with gender "Male" Age "40" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | Scenario 11 - age 40 M|
    Then i validate the reportSummary page header


#   @UI @UIRegression @Regression
# 	Scenario: Complete WBA Questionnaire for Participant with age = NA
#  	 Given Login to AlerePortal using userName and Password
#   	 | username  | test446330@gn.com |
#  		 | password   | asdf |
#		 Then Verify and Click on the WBA content Card
#    And Verify WBA landing page and click on the button
#    When Answer WBA Questionnaire as per Sheet with WBA Validations
#      | sheetname | Scenario 12 - age NA|
#    Then i validate the reportSummary page header

  @UI @UIRegression @Regression @QuestionnaireWithValidations @Age30M
  Scenario: Complete WBA Questionnaire for Participant with age = 30 with WBA_Text_Error_Validations
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    Given Login to AlerePortal using C3 Created userName and Password
    Then Verify and Click on the WBA content Card
    And Verify WBA landing page and click on the button
    When Answer WBA Questionnaire as per Sheet with WBA Validations
      | sheetname | WBA_Validations|
    Then i validate the reportSummary page header
    
     