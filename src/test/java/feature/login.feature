Feature: Login functionality check
  Background: for loading a login page
    Given User is on login page
  Scenario: Login check with valid credentials
    When User enters valid credentials
    Then User logged in successfully

  Scenario Outline: Login check with invalid creadentials
    When user enters invalid username "<userName>" and password "<Password>"
    Then Uesr not able to login
    Examples:
      | userName | Password |
      | a        | 01234    |
      | b        | nivas123 |

