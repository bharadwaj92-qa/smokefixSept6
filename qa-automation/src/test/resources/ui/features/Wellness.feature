Feature: Wellness Functionality

  Background: 
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password

  @Wellness  @Regression @WellnessTC01
  Scenario: Validate whether Welllness page from Coaching Tab and its content below Thumbnail Image
    When User Navigates to Coaching page and validating the sub menu
    And User Click on Wellness tab it should navigate to Wellness Page
    Then User should be able to see appropriate title and content
    And User should be able to see Thumbnail image
    And User should be able to see appropriate content, credits ,start Today link below Thumbnail image

  @Wellness @Regression @WellnessTC12
  Scenario: Validate Wellness page updated content after completion of an Assessment
    When User Navigates to Coaching page and validating the sub menu
    And User Click on Wellness tab it should navigate to Wellness Page
    And User Click on Start Today Link navigating to ActionPlan page
    And User completing mini assessment setting the goal and navigating to wellness page
      | communication      | Online         |
      | timezone           | CST            |
      | email              | pc@gmail.com   |
      | primaryphone       | (555) 123-1515 |
      | primaryphonetype   | Mobile         |
      | tocallon           | Weekdays       |
      | whentocall         | Any time       |
      | preferredlanguage  | English        |
      
    Then User should be able to see Wellness page updated content below Thumbnail Image
    And User should be able to see Coaching calls Title and Progress bar
    And content should be displayed when we hover on Question mark symbol

  @Wellness @Regression @WellnessTC19
  Scenario: Validate whether Wellness page Secure Message section after completion of Assessment
    When User Navigates to Coaching page and validating the sub menu
    And User Click on Wellness tab it should navigate to Wellness Page
    Then User Click on Start Today Link navigating to ActionPlan page
    And User completing mini assessment setting the goal and navigating to wellness page
      | communication      | Online         |
      | timezone           | CST            |
      | email              | pc@gmail.com   |
      | primaryphone       | (555) 123-1515 |
      | primaryphonetype   | Mobile         |
      | tocallon           | Weekdays       |
      | whentocall         | Any time       |
      | preferredlanguage  | English        |
    And User should validate the Secure Message section
    And Message Center page should be displayed when User click on Go to Messages
