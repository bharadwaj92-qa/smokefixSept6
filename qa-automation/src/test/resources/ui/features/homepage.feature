Feature: Home page features

   @SmokeUI @Smoke @HomePage
   Scenario: Validate feedback survey form
     Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
     And Login to AlerePortal using C3 Created userName and Password
    When User navigate to Trackers Page and validating
    And Navigates to Rewards page and validating the sub list
    And Navigates to Coaching page and validating the sub list
    And Navigates to library page and validating the sub list
    Then Navigates to homepage and validating home page


   @SmokeUI @Smoke @HomePage
   Scenario: Validate links on homepage community
      Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
      And Login to AlerePortal using C3 Created userName and Password
      When i navigates to Community AcitivityFeed page and validate
      And i Navigates to Community Forum page and validate
      Then i Navigates to Community Notification Page and validate



   @SmokeUI @Smoke @HomePage
   Scenario: Validate links on homepage nurse
      Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
      And Login to AlerePortal using C3 Created userName and Password
      When i navigates to NurseAdviceLine from Coaching
      And i Validate Nurse chat window and close chat window
      Then i Switching back to NurseAdviceLinePage and validate MessageCenter Link


   @SmokeUI @Smoke @HomePage
   Scenario: Validate links on homemain page
     Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
     And Login to AlerePortal using C3 Created userName and Password
     When User navigate to Questionariespart
     Then Validate the zone pages navigation
    
    