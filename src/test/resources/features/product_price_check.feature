Feature: Check product price on G2A

  Scenario: Verify that the product price in the cart matches the product page
    Given I am on the homepage
    When I search for the product
    And I record the price of the product
    And I add the product to the cart
    Then the price in the cart should be the same as the product page
