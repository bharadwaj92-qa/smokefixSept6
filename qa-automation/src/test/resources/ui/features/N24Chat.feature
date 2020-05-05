Feature: N24Chat features

  @Smoke @Nurse24 @SmokeUI @Fix
  Scenario: Validate navigation to nurse advice line page from submenu and check navigation to start chat window
   Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
   And Login to AlerePortal using C3 Created userName and Password
   When User navigate to Nurse Advice Line page from submenu
   Then Validate navigation to StartChat window and check validation message

  @Smoke @Nurse24 @SmokeUI
  Scenario: Validate navigation to nurse advice line page from homepage zone3 section

   Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
   And Login to AlerePortal using C3 Created userName and Password
   When User navigate to Nurse Advice Line page from zone3 section
   Then Validate welcome message on Nurse Advice Line page
   
 

