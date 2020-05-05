Feature: Regression scenarios for Trackers Nutrition Feature

  Background: 
    Given Create Testuser in C3 tool with gender "Male" Age "30" Client "Health Net (500010)" and working population "HNET - CalPERS (1022678)"
    And Login to AlerePortal using C3 Created userName and Password

  @Smoke @SmokeUI @UI @TrackersTC73
  Scenario: Validate Progress Page, then Add and edit the track data to verify whether edited record displayed in journal page
    When User navigate to Trackers page Click on Progress tab it should be navigated to Progress Page
    And Save all data in Track page by clicking on save button which should be navigated to Journal page
      | DateEntered | 11/29/2018                                          |
      | Time        | 8:30 AM                                             |
      | Fruits      |                                                   6 |
      | Veggies     |                                                   7 |
      | Wholegrains |                                                   5 |
      | LeanMeat    |                                                  10 |
      | LowFat      |                                                  15 |
      | Fats        |                                                  10 |
      | Nuts        |                                                   5 |
      | Sweets      |                                                  10 |
      | Notes       | Saving Serving Data in Trackers Nutrition Track Tab |
    And validate the record data that is present in journal should be same as the entered data in Track
      | DateEntered | 11/29/2018                                          |
      | Fruits      |                                                   6 |
      | Veggies     |                                                   7 |
      | Wholegrains |                                                   5 |
      | LeanMeat    |                                                  10 |
      | LowFat      |                                                  15 |
      | Fats        |                                                  10 |
      | Nuts        |                                                   5 |
      | Sweets      |                                                  10 |
      | Notes       | Saving Serving Data in Trackers Nutrition Track Tab |
    And Click on Edit Link of the record it should display edit popup
    Then Click on Yes button in Edit popup which should be navigated to Track page
    And Reenter the values click on saveButton record should be present in Journal Page
      | DateEntered | 11/30/2018                                                     |
      | Time        | 8:30 AM                                                        |
      | Fruits      |                                                              4 |
      | Veggies     |                                                              8 |
      | Wholegrains |                                                              7 |
      | LeanMeat    |                                                             12 |
      | LowFat      |                                                             11 |
      | Fats        |                                                             12 |
      | Nuts        |                                                              8 |
      | Sweets      |                                                             12 |
      | Notes       | Saving Serving Data once again in Trackers Nutrition Track Tab |
    And Validate edited Record is displayed in the journal page
      | RecordEdited | 11/30/2018 |

  @Smoke @SmokeUI @UI @TrackersTC7072747576
  Scenario: Validate Progress Page before and after adding the track,then verfiy whether deleted record is not displayed in Journal page
    When User navigate to Trackers page Click on Progress tab it should be navigated to Progress Page
    And Save all data in Track page by clicking on save button which should be navigated to Journal page
      | DateEntered | 11/25/2018                                          |
      | Time        | 8:30 AM                                             |
      | Fruits      |                                                   6 |
      | Veggies     |                                                   7 |
      | Wholegrains |                                                   5 |
      | LeanMeat    |                                                  10 |
      | LowFat      |                                                  15 |
      | Fats        |                                                  10 |
      | Nuts        |                                                   5 |
      | Sweets      |                                                  10 |
      | Notes       | Saving Serving Data in Trackers Nutrition Track Tab |
    And click on Progress tab to validate generated graph, dateRange and timeline
    And Validate All records should be displayed based on the entry criteria
      | StartDate | 10/24/2018 |
      | EndDate   | 1/12/2019  |
    Then Click on delete Link of the record it should display delete popup
      | Date | 11/25/2018 |
    And Click on Yes button in Delete popup which should be navigated to Journal page
    And Validate whether record is deleted in Journal page
      | DeletedRecord | 11/25/2018 |

  @Smoke @SmokeUI @UI @TrackersTC77
  Scenario: Validate Nutrition track page error messages
    When User navigate to Nutrition Track page
    Then User click on save Button to validate error messages in Nutrition track page
      | date   | Please choose a date.                                 |
      | hour   | Please enter a time in hours.                         |
      | minute | Please enter a time in minutes.                       |
      | notes  | Whoops! Your note has to be less than 500 characters. |

  @Smoke @SmokeUI @UI @TrackersTC67
  Scenario: Validate Nutrition Goal page by Adding and Editing the Goal
    When User navigate to Nutrition Goal select the Goal
    And User should Add the Goal in the Goal Page
      | feet                                  |                                 5 |
      | inches                                |                                 6 |
      | weight                                |                               140 |
      | How Active are you?                   | Sedentary (little or no exercise) |
      | Do you have any physical Limitations? | Yes, amputee                      |
      | Choose your meal plan                 | Vegetarian                        |
      | Calories                              |                              1200 |
      | Weeks                                 |                                 6 |
    Then User should Edit the Goal which is added in the Goal Page
      | feet                                  |                                                      5 |
      | inches                                |                                                      6 |
      | weight                                |                                                    160 |
      | How Active are you?                   | Lightly active (light exercise / sports 1-3 days/week) |
      | Do you have any physical Limitations? | Yes, amputee                                           |
      | Choose your meal plan                 | Vegetarian                                             |
      | Calories                              |                                                   1800 |
      | Weeks                                 |                                                      7 |

  @Smoke @SmokeUI @UI @TrackersTC145
  Scenario: Validate Nutrition Journal Page with and without updating goal,errormsgs in Daily Calories Goal and GoalHistory in Journal Page
    When User navigate to Trackers page Click on Journal tab it should be navigated to Journal Page
    And User navigate to Nutrition Goal select the Goal
    And Click on Save Button without entering data in Step page error message should be displayed
      | height   | Please enter your height.     |
      | weight   | Please enter your weight.     |
      | mealplan | Please choose your meal plan. |
    And User should Add the Goal in the Goal Page and also able to see back Button
      | feet                                  |                                 5 |
      | inches                                |                                 6 |
      | weight                                |                               140 |
      | How Active are you?                   | Sedentary (little or no exercise) |
      | Do you have any physical Limitations? | Yes, amputee                      |
      | Choose your meal plan                 | Vegetarian                        |
    And Click on Save Button it should be navigated to Second page
      | Calories | 1200 |
      | Weeks    |    6 |
    And Click on Save Button it should be navigated to third page
    Then verfiy Goal summary page
      | Calories | 1200 |
      | Weeks    |    6 |
    And Click on Journal Tab to verify the goal details
      | Calories | 1200 |

  @Smoke @SmokeUI @UI @TrackersTC146
  Scenario: Validate Nutrition Journal Page with and without updating goal,errormsgs in Daily Servings Goal and GoalHistory in Journal Page
    When User navigate to Trackers page Click on Journal tab it should be navigated to Journal Page
    And User navigate to Nutrition Goal select the Goal Fruits and Veggies and validate the content
    And Click on Save Button without selecting any goal error message should be displayed
      | goal | Please choose a nutrition goal. |
    And Add all the three goals and also able to see back button
      | FruitsServings  | 3 |
      | FruitsWeeks     | 7 |
      | VeggiesServings | 4 |
      | VeggiesWeeks    | 8 |
      | FatsServings    | 2 |
      | FatsWeeks       | 5 |
    Then Click on Save Button it should be navigated to GoalSummary Page with the added goals displayed
      | FruitsServings  | 3 |
      | FruitsWeeks     | 7 |
      | VeggiesServings | 4 |
      | VeggiesWeeks    | 8 |
      | FatsServings    | 2 |
      | FatsWeeks       | 5 |
    And Click on Journal Tab to verify the added goal details in GoalsHistory
      | FruitsServings  | 3 |
      | FruitsWeeks     | 7 |
      | VeggiesServings | 4 |
      | VeggiesWeeks    | 8 |
      | FatsServings    | 2 |
      | FatsWeeks       | 5 |
