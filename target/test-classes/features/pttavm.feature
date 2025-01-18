Feature: PttAVM Website Testing

  Scenario: User navigates through PttAVM website
    Given user is on the PttAVM homepage
    When user accepts cookies
    And user clicks on login button
    Then login page should be displayed

  Scenario: User searches for a product
    Given user is on the PttAVM homepage
    When user searches for "telefon"
    Then search results should be displayed

  Scenario: User adds product to cart
    Given user is on a product page
    When user clicks add to cart button
    And user navigates to shopping cart
    Then product should be visible in cart
