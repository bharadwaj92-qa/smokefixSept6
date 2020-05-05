
@ActionPlan
Feature: Action Plan scenario

   @Smoke @SmokeUI @UI @New
   Scenario: Action Plan
    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)" 
    And Login to AlerePortal using C3 Created userName and Password
    And User navigate to Action Plan Page and clicking on Get Started
    When i complete the Action plan questionnaires from ActionPlan_Tobacco and validating the Focus areas    
    And Navigating to GoalDeadLine page and Entering to the GoalSetup Page
    And Setting all the fields in the GoalSetup page by using below values
    
     	| communication  			| Online 					|
      | timezone       			| CST    					|
      | email          			| pc@gmail.com   	|
      | primaryphone   			| (555) 123-1515 	|
      | primaryphonetype		| Mobile					|
      | tocallon   					| Weekdays				|
      | whentocall					|	Any time				|
      | preferredlanguage		|	Telugu					|
      | toquitinnext30days	|	Yes							|
      | eCigras							|	No							|
      | aboutthisprogram		|	Co-Worker				|
      
    And Navigating to GoalSetupSuccess, Validating Ation Plan banner and Handling GoalReminderPopup
    Then Navigating to Manage Goals Page and Validating the Added Goal
    And Validating the Cancel Goal in Manage Goals

  @SmokeUI @Smoke @downloadcertificate @UI @Fix
  Scenario: Action Plan To Do

    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    And User navigate to Action Plan Page,TODO and clicking on Get Started
    When i complete the Action plan questionnaires from ActionPlan TODO Tobacco and validating the Focus areas
    And Navigating to GoalDeadLine page and Add a coach to the Goal
    And Setting all the fields in the GoalSetup page after Adding a Coach by using below values

      | communication  			| Online 					|
      | timezone       			| CST    					|
      | email          			| pc@gmail.com   	|
      | primaryphone   			| (555) 123-1515 	|
      | primaryphonetype		| Mobile					|
      | tocallon   					| Weekdays				|
      | whentocall					|	Any time				|
      | preferredlanguage		|	Telugu					|

    And Navigating to GoalSetupSuccess, Validating TODO Action Plan banner and Handling GoalReminderPopup
    Then Navigating to Manage Goals Page and Validating the Health Diet Goal Added
    And Validating the download certificate button in Manage Goals page



  @Smoke @milestone @SmokeUI @UI @Fix
  Scenario: Action Plan milestone tracker updated

    Given Create Testuser in C3 tool with gender "Male" Age "50" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password
    And User navigate to Action Plan Page and clicking on Get Started
    When i complete the Action plan questionnaires from ActionPlan_Tobacco and validating the Focus areas
    And Navigating to GoalDeadLine page and Add a coach to the Goal
    And Setting all the fields in the GoalSetup page after Adding a Coach by using below values

      | communication  			| Online 					|
      | timezone       			| CST    					|
      | email          			| pc@gmail.com   	|
      | primaryphone   			| (555) 123-1515 	|
      | primaryphonetype		| Mobile					|
      | tocallon   					| Weekdays				|
      | whentocall					|	Any time				|
      | preferredlanguage		|	Telugu					|

    And Navigating to GoalSetupSuccess, Validating TODO Action Plan banner and Handling GoalReminderPopup
    Then Complete the week1 TODO, mark as complete and validate the Milestone Status