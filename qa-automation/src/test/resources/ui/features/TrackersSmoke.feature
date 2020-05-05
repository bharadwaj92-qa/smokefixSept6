Feature: Smoke scenarios for Tracker feature

  @Smoke @SmokeUI @UI @Trackers
  Scenario: Update and validate the readings and notes section of Track tab in A1C page
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    When User navigate to Trackers page and update progress of Tracker
    |Reading     |13|
    |Notes       |test|
    And user updates previous readings of user from Journal page
      |Reading     |16|
      |Notes       |update test|
    Then validate tracker values are reflected in Journal page
    And user can successfully delete the entry from Journal page

  @Smoke @SmokeUI @UI @Trackers
  Scenario: Validate errors for Mandatory fields and timestamp of entries created
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    When user tries to enter invalid values for mandatory fields error messages are shown
      |Reading| This field is required. |
      |hour| Please enter a time in hours. |
      |minute| Please enter a time in minutes. |
      |date|Please choose a date.|
      |Notes|Whoops! Your note has to be less than 500 characters.|
    Then validate tracker values are updated for the entry in Journal page
      |Reading     |16|
      |Notes       |update test|
    And successfully delete the entry from Journal page

