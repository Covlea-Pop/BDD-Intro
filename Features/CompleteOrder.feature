Feature: As a user i can make an order of specific product
  Scenario: Complete an order
    Given I chose a product from the product list
    When I put the product on the shopping cart
    Then I can complete the order