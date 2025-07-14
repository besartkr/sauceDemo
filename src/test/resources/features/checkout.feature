@regression @checkout
Feature: Complete the checkout flow of happyPath

  Scenario: User completes checkout
    Given user navigates to the login page
    And user logs in with valid credentials
    And user adds an item to the cart
    And user proceeds to checkout
    When user completes the customer details in checkout process
    And user selects Continue Checkout button
    And user selects Finish Checkout button
    Then user should see the confirmation message
    And logout from the application



  Scenario: User with username: problem_user cannot bypass the checkout process
    Given user navigates to the login page
    And user logs in with problem_username
    And user adds an item to the cart
    And user proceeds to checkout
    When user completes the customer details in checkout process
    And user selects Continue Checkout button
    Then user should see enter lastName error message
    And logout from the application

     Scenario: Complete Purchase and navigate back
       Given user navigates to the login page
       And user logs in with valid credentials
       When User adds a random product to the cart
       Then Product should be displayed in the cart
       And user selects cart icon
       And user proceeds to checkout
       When user completes the customer details in checkout process
       And user selects Continue Checkout button
       And user selects Finish Checkout button
       Then user should see the confirmation message
       And user can navigate back to products page
       And Then User should see the inventory page title as "Swag Labs"
       And logout from the application

#  Scenario Outline: Complete the checkout flow with all individual usernames - ensure correct privileges are applied
#    Given user navigates to the login page
#       When user logs in with valid username "<username>" and password as "<password>"
#       Then user should be logged in
#    And user adds an item to the cart
#    And user proceeds to checkout
#    When user completes the checkout process
#    Then user should see the confirmation message
#
#       Examples:
#         | username                | password     |
#         | standard_user           | secret_sauce |
#         | problem_user            | secret_sauce |
#         | performance_glitch_user | secret_sauce |
#         | error_user              | secret_sauce |
#         | visual_user             | secret_sauce |


#  Scenario: Checkout journey - Last Name and postcode are marked as mandatory
#    Given user navigates to the login page
#    When user logs in with valid <username> and <password> credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    And completes the FirstName
#    And the LastName and PostCode are blank
#    Then a warning message is displayed

  #    Examples: | username      | password     |
#    | standard_user | secret_sauce |
#    | problem_user | secret_sauce |
#    | performance_glitch_user | secret_sauce |


  #  Scenario: Checkout journey - First Name and postcode are marked as mandatory
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    And completes the LastName
#    And the First and PostCode are blank
#    Then a warning message is displayed

    #  Scenario: Checkout journey - First Name and LastName are marked as mandatory
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    And completes the postCode
#    And the First and LastName are blank
#    Then a warning message is displayed


    #  Scenario: Checkout journey - all fields are marked as mandatory
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    And the First, LastName and PostCode are blank
#    Then a warning message is displayed

      #  Scenario: Checkout journey - special char not permitted
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    And enters special char in Username / Password / postCode
#    Then a warning message is displayed

#
#  Scenario: Cancel item from the checkout
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    When user cancel the existing process
#    Then user should see  the Products Page
#    And the Item remains in the cart
#
#  Scenario: Cancel item from the checkout and add additional items to the cart
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    When user cancel the existing process
#    Then user should see  the Products Page
#    And the Item remains in the cart
#    And can add additional products to the cart

  #  Scenario: cancel item from the checkout and remain on the checkout screen
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#   Then user can remove the item from the checkout
#    And the user remains on the checkout screen

    #  Scenario: Complete the checkout and cancel journey on checkout: Overview
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#   And user proceeds to checkout overview
#  And the user can cancel the journey
#    Then user should see  the Products Page

      #  Scenario: Ensure order details cannot be changed
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#   And user proceeds to checkout overview
#  Then the order details cannot be changed
