Feature: Care Reminders

  Background: 
    Given Create Testuser in C3 tool with gender "Male" Age "72" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password

  @UICareReminder @Smoke @SmokeUI @UI
  Scenario: Validate the count and messages of Care Reminders is matching with Open Care Reminders and Print Care Reminders
    When Click on "Test User Profile"  navigate to CareReminders Page
    Then Count of Care Reminders should match with Open Care Reminders
    And Click on Print Icon in Open Care Reminders
    Then Count of Print Care Reminders should match with Open Care Reminders

  @UICareReminder @Smoke @SmokeUI @UI
  Scenario: Validate the Open and Closed Care Reminders
    When User is in Open Care Reminders page
    And Click on Expand button and Learn more about link navigate to expand BP page
    And Select any of the answer option and click on Submit button
      | Radiobutton | I do not plan to have this test/immunization. |
    Then Above answer option is not present in careList
    And Click on Closed Care Reminders option
    Then Above answered BP CR is displayed under closed care Reminder
    And Click on Expand button related to BP closed
    Then same answer option should be selected and All answer options should not be editable
