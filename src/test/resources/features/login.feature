@regression
Feature: Login valid / invalid scenarios

#  Scenario: Successful login
#    Given user navigates to the login page
#    When user logs in with valid credentials
#    Then user should be logged in
#
#  Scenario: Failed login with invalid credentials
#    Given user navigates to the login page
#    When user logs in with invalid credentials
#    Then user should see a error message

  Scenario Outline: Login with all available users
    Given user navigates to the login page
    When user logs in with valid username "<username>" and password as "<password>"
    Then user should be logged in
    And logout from the application
    Examples:
    | username                | password     |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |
    | error_user              | secret_sauce |
    | visual_user             | secret_sauce |


    #  Scenario: Failed login with correct UserName and incorrect Password
#    Given User is on login page
#    When User logs in with invalid credentials
#    Then User should see an error message

      #  Scenario: Failed login with incorrect Password and correct Password
#    Given User is on login page
#    When User logs in with invalid credentials
#    Then User should see an error message


    #  Scenario: Failed login without username/password
#    Given User is on login page
#    When User logs in with invalid credentials
#    Then User should see an error message
