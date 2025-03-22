Feature: SauceDemo Login and Product Purchase

  Scenario: Successful Login with Valid Credentials
    Given I am on the SauceDemo login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should be redirected to the product page

  Scenario: Unsuccessful Login with Invalid Credentials
    Given I am on the SauceDemo login page
    When I enter username "locked_out_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Sorry, this user has been locked out."

  Scenario: Add a Product to the Cart
    Given I am logged into SauceDemo
    When I add the product "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1"

  Scenario: Checkout and Complete Purchase
    Given I have a product in my cart
    When I proceed to checkout
    And I enter first name "John"
    And I enter last name "Doe"
    And I enter postal code "12345"
    And I click continue
    And I click finish
    Then I should see a confirmation message "Thank you for your order!"
