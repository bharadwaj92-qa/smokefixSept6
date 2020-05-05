Feature: Regression scenarios for Trackers Activity Feature

  
  @Smoke @SmokeUI @UI @TrackersTC14415
  Scenario: Validate Activity Journal Page with and without updating goal,errormsgs Goal and GoalHistory in Journal Page
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
  And Login to AlerePortal using C3 Created userName and Password
    When User navigate to Activity Trackers Page validate the tabs displayed
    And Click on Journal tab to validate its content without adding any Goal
    And User navigate to Activity Goal Page and validate the content
    And Click on Edit button Validate the content of three goals and also verify the dropdowns
      | Distance | I want to be physically active a total of miles each week for week(s).              |
      | Duration | I want to be active days each week, for minutes. I'll reach this goal in week(s).   |
      | Steps    | I want to be active days each week, steps per day. I'll reach this goal in week(s). |
    Then Set the Distance Goal and Click on Save Button which should be changed to Edit Button
      | Miles | 50 |
      | Weeks | 8 |
    And Click on Journal Tab to verify the added goal details displayed in GoalsHistory
      | Miles | 50 |
      | Weeks | 8 |

  @Smoke @SmokeUI @UI @TrackersTC251620212223
  Scenario: Validate Activity track page error messages, Save the track and edit the Added record and delete the record in Journalpage
   Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
  And Login to AlerePortal using C3 Created userName and Password
    When User click on Track tab to navigate to Activity Track page and Click on Ok Button
    And Enter all Data in WeightBMI track page and navigate to Actvity Track page
    |Weight|  55 |
    |Feet| 5|
    |Inches| 4|
    And User click on save Button without entering data to validate error messages in all fields
    And Save all data in Activity Track page by clicking on save button which should be navigated to Journal page
      | Activity        | Basketball                   |
      | DateEntered     | 11/25/2018                   |
      | Time            | 8:30 PM                      |
      | DurationHours   |                            2 |
      | DurationMinutes |                           30 |
      | Notes           | Adding Data in Activity page |
    And Validate All records should be displayed based on the entry criteria in Journal Page
      | StartDate | 10/24/2018 |
    And Click on Edit Link of the record to click Yes button on Edit popup
      | DateEntered | 11/25/2018 |
    And validate whether edited record displayed in Journal Page
      | Steps        |                               1000 |
      | Notes        | Adding again Data in Activity page |
      | RecordEdited | 11/25/2018                         |
    And click on Delete Link of the record to click Yes Button to validate deleted record is not displayed in Journal Page
      | DeletedRecord | 11/25/2018 |
      
      
    