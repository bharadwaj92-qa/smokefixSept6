Feature: Progress>Challenges flow

  @smokePC @SmokeUI @UI @Smoke @Challenges
  Scenario: Validating challenges page
    #Given I login into portal with logid as "test448515@gn.com",password as "asdf" and navigate to challenges
    
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    
    When I validate all left navigation links are working
    And i start a challenge
      | challenge name       | Step It Up Challenge |
      | dropdown value1      | Daily                |
      | dropdown value2      | Weekly               |
      | steps                | 10                   |
      | popup value          | NO                   |
      | max step/day section | 10000                |
    Then Challene is successfull added and verified in Challenges page and Credit page

