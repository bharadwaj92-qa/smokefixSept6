Feature: Terms Of Use Regression


  @UI @TOUReg @Regression
  Scenario: Validate Terms of Use page Mobile Text messaging, Privacy, Text2Quit ,Printable version,Terms footer section, AcceptTOU and again Click on Footer Terms
    Given Create Testuser in C3 tool with gender "Male" Age "45" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password navigate to TOU
    When Click on Printable Verison Link and Privacy Link navigated to respective pages
    And Click on Mobile Text Messaging and Text 2 Quit Link  navigated to respective Pages
    And Click on here link navigated to Terms of Use page
    And Click on Terms in Footer section of Terms of Use Page
    Then Terms of Use page  should be displayed
    And Click on Privacy Link navigated to Privacy Policy Page
    And Click on Text 2 Quit Link  Terms in footer navigated to Text to Quit Page
    And Click on here link navigated to Terms of Use footer page
    And Accept TOU page and click continue
    And Home page should be displayed click on Footer Terms
    And Click on Text 2 Quit Link which is navigated to TextQuitMobile page
    And Click on here link which is navigated to Terms of use page
    And Click on Privacy Link navigated to Privacy Policy Page and navigate to Terms of use page