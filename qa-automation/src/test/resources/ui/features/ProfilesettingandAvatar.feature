  Feature: Profile Settings and Avatar

    @Smoke @SmokeUI @ProfileSettingsAvatar @UI
    Scenario: Validate message on saving prefernce

      Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
      And Login to AlerePortal using C3 Created userName and Password

      When User navigate to communication page
      Then Validate user can check check boxes and submit prefernces.

    @Smoke @SmokeUI @ProfileSettingsAvatar @UI
    Scenario: Validate navigation of ContactInfo Page

      Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
      And Login to AlerePortal using C3 Created userName and Password

      When User navigate to ContactInfoPage
      Then Validate the name on contactInfo Page

      @Smoke @SmokeUI @ProfileSettingsAvatar @UI
    Scenario: Validate links and add device button on device and apps page

      Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
      And Login to AlerePortal using C3 Created userName and Password
      When User navigate to device and apps page
      Then Validate links on page,check learn more functionality and check user can navigate to new window when clicking on add device button

       @Smoke @SmokeUI @ProfileSettingsAvatar @UI
    Scenario: Validate all links on Settings Page

      Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
      And Login to AlerePortal using C3 Created userName and Password

      When User navigate to Setting Page
      Then Validate all left links on settingpage

    @Smoke @SmokeUI @ProfileSettingsAvatar @UI
    Scenario: Validate profile avatar selection on profile page

      Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
      And Login to AlerePortal using C3 Created userName and Password
      When User navigate to EditProfile Page
      Then Validate profile avatar selection,check success message after selecting profile avatar

        |hairStyleNumber | 1 |
        |expressionNumber| 1 |
        |colorName       | 1 |