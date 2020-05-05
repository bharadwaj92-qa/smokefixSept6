
Feature: Library Search and Browse

  @Library @SmokeUI @Smoke @UI
  Scenario: Library Search and Browse and contentcards validations
  
     Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
     And Login to AlerePortal using C3 Created userName and Password
     When user navigates to Library Search page and Validate the content cards
     Then Validate all content cards in library search page
     
     
     