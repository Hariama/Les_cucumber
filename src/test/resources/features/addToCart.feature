Feature: Webshop

  Scenario: Navigate to a site
    When I navigate to the site "http://automationpractice.com/index.php"
    Then I am on the homepage

  Scenario: Search For Dress
    Given I am on the site http://automationpractice.com/index.php
    When I enter <dress> in the searchbalk and click on the search button
    And I click on a product
    Then I can see the the details of the product on the redirected site

  Scenario: Add product from the front page to the Cart
    Given I am on the site http://automationpractice.com/index.php
    When I scroll down to a product
    And I click on the "add to cart" button of a product
    And I click on "proceed to checkout"
    Then I should see the checkout page with the added products

  Scenario: Add product from it's detail page to the Cart
    Given I am on the homepage
    When I search for a product in the searchbalk and click on the search button
    And I click on a product on the result page
    And I click on the "add to cart" button
    And I click on "proceed to checkout"
    Then I should see the checkout page with the added products
