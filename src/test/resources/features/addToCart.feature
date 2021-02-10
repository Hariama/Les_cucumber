Feature: Webshop

  Scenario: Navigate to a site
    When I navigate to the site "http://automationpractice.com/index.php"
    Then I am on the homepage

  Scenario: Search For Dress
    Given I navigate to the site "http://automationpractice.com/index.php"
    When I enter "dress" in the searchbalk and click on the search button
    And I click on product 2
    Then I can see the the details of the product on the redirected site

  Scenario: Add product from the front page to the Cart
    Given I navigate to the site "http://automationpractice.com/index.php"
    When I hover over the second product
    And I click on the add to cart button of product 2 and I click on "proceed to checkout"
    Then I should see the checkout page with the added products

  Scenario: Add product from it's detail page to the Cart
    Given I navigate to the site "http://automationpractice.com/index.php"
    When I enter "dress" in the searchbalk and click on the search button
    And I hover over the second product
    And I click on the add to cart button of product 4 and I click on "proceed to checkout"
    Then I should see the checkout page with the added products
