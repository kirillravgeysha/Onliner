Feature: As a user
  I want to get ability to add product to cart
  So that I can

  Background:
    Given the user opens Onliner website

  Scenario Outline: Product should be added to cart
    When the user set "<productCategory>" in search menu
    And the user clicks on the product offer button
    And the user clicks on the AddToCart button
    And the user opens Cart page
    Then product is displayed on cart
    And the user verify product name

    Examples:
      | productCategory |
      | Наушники        |
      | Телевизоры      |