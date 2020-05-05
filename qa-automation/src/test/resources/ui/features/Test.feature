Feature: Home Screen Header TC_01_04_10
    
  @UIHomeScreenHeader @Smoke @SmokeUI @UI
  Scenario: Validate the Home Screen Header options
    When Navigating to Others tab and Validating Other tab loaded successfully in devices 360 
    And Verify the Devices tab is displaying on 360 View
    And Verify Devices and Refresh button are displaying
    Then Clicking on the Refresh button
    And Verify Verify the sections under Devices widget
