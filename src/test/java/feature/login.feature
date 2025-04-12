Feature: Login functionality check
  Background: for loading a login page
    Given User is on login page
  Scenario: Login check with valid credentials
    When User enters valid credentials
    Then User logged in successfully
