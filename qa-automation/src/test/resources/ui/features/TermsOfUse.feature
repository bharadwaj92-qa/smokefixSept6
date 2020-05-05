Feature: Terms Of Use

  @UITerms @Smoke @SmokeUI @UI
  Scenario: Validate Terms of Use page Mobile Text messaging, Privacy, Text2Quit ,Printable version,Terms footer section and Accept TOU
    Given Create Testuser in C3 tool with gender "Male" Age "45" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password navigate to TOU
    When Click on Printable Verison Link and Privacy Link navigated to respective pages
    And Click on Mobile Text Messaging and Text 2 Quit Link  navigated to respective Pages
    And Click on here link navigated to Terms of Use page
    And Click on Terms in Footer section of Terms of Use Page
    Then Terms of Use page  should be displayed
    When Click on Privacy Link navigated to Privacy Policy Page
    And Click on Text 2 Quit Link  Terms in footer navigated to Text to Quit Page
    And Click on here link navigated to Terms of Use footer page
    And Accept TOU page and click continue
    Then Home page should be displayed
