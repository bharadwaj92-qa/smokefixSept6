Feature: Challenges Functionality

  Background: 

   Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
   And Login to AlerePortal using C3 Created userName and Password
  
  @Regression @UI @ChallengesTC10And20 @Challenges1
  Scenario: Validating Challenges Attributes, learnmore or less link if present and popup should be displayed if we do not save data
    When Click on Challenges content card which is navigated to Available Challenges Page
    And Click on GetStarted Button in Available Challenges Page Back to Challenges link should display
      | challenge name | Step It Up Challenge |
    And Challenge Attributes such as date, credits earned should be displayed
    And validate whether mousehover on the Deadline link is displayed
    Then Add or Enter any data in Challenges DashBoard Page click on Back To Challenges without saving it
      | dropdown value1 | Daily |
      | steps           | 10000 |
    And Validation message should be displayed

  @Regression @ChallengesTC29 @Challenges1
  Scenario: Validating challenges pages such as Completed,  Missed,  and Upcoming challenges
    When Click on Challenges content card which is navigated to Available Challenges Page
    And Click on Completed Challenges link verify the message displayed
    And Click on Missed challenge link verify the Earning Activity displayed
    Then Upcoming challenges should display as Earning Activity

  @Regression @ChallengesTC43and44and35454647 @Challenges1
  Scenario: Validating challenges page textbox, cancel button, attributes, completing all credits, Update Button,Rewards Credit and History credit score
    When Click on Challenges content card which is navigated to Available Challenges Page
    And Click on GetStarted Button in Available Challenges Page Back to Challenges link should display
      | challenge name | Step It Up Challenge |
    And Challenge Attributes such as date, credits earned should be displayed
    And Click  on Add Button to validate textbox and cancel button
    And Click on Cancel Button where default view with Add Button should be displayed
    Then Start the Challenge
      | dropdown value1 | Daily   |
      | steps           |     800 |
      | steps1          | 100000 |
    And validate credits count and Update Button in Available Page
    And successfully complete all credits for an available challenge
      | challenge name  | Step It Up Challenge |
      | dropdown value2 | Weekly               |
      | steps           |                10000 |
    And Rewards Credit and History page where credit score should be same as credits in Challenge page

  @Regression @ChallengesTC4851and5059606137  @Challenges1
  Scenario: Validating all challenges pages,attributes,textbox and cancel,learn more,less links and mousehover on the Deadline link by navigating from Rewards
    When User click on Rewards it is navigated to Credits Page
    And Click on GetStarted Button in Join Challenge Card
    And Join Challenge content should be displayed
    And Click on Get started button in Join Challenge page to validate titles in Available Page
    And Click on Completed Challenges link verify the message displayed
    Then Click on Missed challenge link verify the Earning Activity displayed
    And Upcoming challenges should display as Earning Activity
    And Click on GetStarted Button in Available Challenges Page Back to Challenges link should display
      | challenge name | Step It Up Challenge |
    And Challenge Attributes such as date, credits earned should be displayed
    And validate whether mousehover on the Deadline link is displayed
    And Click  on Add Button to validate textbox and cancel button
   
   
  @Regression @ChallengesTc72  @Challenges1
  Scenario: Validating whether Save the data message displaying if user has not saved the data by clicking on Footer, Headerlinks,Datepicker,backarrow,Learmmore etc.
    When Click on Challenges content card which is navigated to Available Challenges Page
   And Click on GetStarted Button in Available Challenges Page Back to Challenges link should display
      | challenge name | 1st Quarter Physical Activity Tracking_Test |
    And validate learn more, less link and mousehover on the Deadline link is displayed
    Then Add or Enter any data in Challenges DashBoard Page toggle from Daily to weekly and back arrow confirm save data message should be displayed
      | dropdown value1 | Daily  |
      | dropdown value2 | Weekly |
      | Minutes         |     90 |
    And Click on learn more or less link confirm save data message should not be displayed
    And Click on all the drop downs from top navigation Like ActionPlan, Progress, library confirm save data message should be displayed
    And Click on Cient Name, Client Logo, Help, Credits Link, Credits Value, Avatar confirm save data message should be displayed
    And Click on Footer links such as contacts, privacy,Terms,Accessibility confirm save data message should be displayed
