Feature: GapHistory Participant Gaps Functionality

  @UIGapHistory @Smoke @SmokeUI @UI
  Scenario: Validate GapHistory Participant Gaps Functionality
  
  Given Login to the CallCenter application with below valid credentials and select specific role
      | username | devivxa      |
      | password | Reset!1234567 |
      | role     | Health Coach |
   And Retrieve the Enrolled Participant ID from PRPC DataBase   
   When Other tab loaded successfully enter Participant Id of the client from Db
    And calculate the caregaps in Education Goals
    And Click on Gaphistory on three sixty tab to verify the Participant Gaps column Names
    Then pagination icons and related text should be displayed
    And Verify the collapse and Expand mode in ParticipantGaps section
    And Clicking on Refresh Button in Participant Gaps section should navigate to Gap History Page

    
   
    
    