
Feature: Marketing page validations scenarios

   @Smoke @SmokeUI @UI @MarketingPage
   Scenario: Validate all links on marketing page

    Given Navigating to the Marketing page URL
    When User validating the Header, Logo and links navigation
    Then Validate the Get Started Now links in the marketing page