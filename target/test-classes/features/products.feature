@regression
Feature: Add and Remove item from the cart

  Scenario:  Add Item to the cart and remove it
    Given user navigates to the login page
    And user logs in with valid credentials
    When User adds a random product to the cart
    And user selects cart icon
    Then Product should be displayed in the cart
#    Then user can remove the item from the cart
    And logout from the application

  #  Scenario:  View Product details
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user selects a product
#    Then Product Details are displayed


#  Scenario: Add Item to the cart and login as a different user
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    When I log in with as a different usr
#    The item will not be displayed

#  Scenario: Add Item to the cart, then login and logout
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    When I log out from my account
#    And user re-logs in with valid credentials
#    The item is still displayed in the cart

 #  Scenario: Ensure non-available products are not displayed in the products page
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And user adds an item to the cart
#    And user proceeds to checkout
#    When user completes the checkout process
#    Then user should see the confirmation message
#    And the item is not longer displayed in the products page

#  Scenario: Multiple Products can be added to the cart
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    And can adds multiple item to the cart


  #  Scenario: Rearrange products by Name (Z to A)
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    When I rearrange products by Name (Z to A)
#  Then the list of products will reflect on the page

    #  Scenario: Rearrange products by Name (A to Z)
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    When I rearrange products by Name (A to Z)
#  Then the list of products will reflect on the page

      #  Scenario: Rearrange products by Price (low to high)
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    When I rearrange products by  Price (low to high)
#  Then the list of products will reflect on the page

       #  Scenario: Rearrange products by Price (high to low)
#    Given user navigates to the login page
#    And user logs in with valid credentials
#    When I rearrange products by  Price (high to low)
#  Then the list of products will reflect on the page



 #  Scenario: Ensure all the links on the website are working
#    Given user navigates to the login page
#    When user logs in with valid <username> and <password> credentials
#    Then user selects <pages>
#    Examples: | username      | password     | pages
#    | standard_user | secret_sauce | Privacy Policy |
#    | problem_user | secret_sauce | About |
#    | performance_glitch_user | secret_sauce | Logout |
#    | visual_user | secret_sauce | Terms of Service |
