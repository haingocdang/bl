@user_login
Feature: User
  As a Admin User I want to login to System

  Scenario: Login into System with valid account
    Given I open Login page
    When I input "TEST" into username textbox
    And I input "12341234" into password textbox
    And I click Login button
    Then Home Page appears
    
    
