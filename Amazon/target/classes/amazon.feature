Feature: Amazon tests
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check add product to shopping cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User opens first product page
    And User click add to cart
    Then User checks that amount of products in cart icon '<amountOfProducts>' and list of products is visible
  Examples:
    | homePage                | keyword | amountOfProducts |
    | https://www.amazon.com/ | phone   | 1     |

  Scenario Outline: Search results contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    Then User checks that first search results '<keyword>'
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | ASUS |

  Scenario Outline: User create new account with invalid password
    Given User opens '<homePage>' page
    And User opens Sign In page
    And User choose to create new Amazon account
    And User enter '<name>' in name field
    And User enter '<phone>' in phone field
    And User enter '<password>' in password and re-enter password field
    When User click on verify button
    Then User see massage, that password invalid
    Examples:
      | homePage                | name   | phone     | password |
      | https://www.amazon.com/ | Myname | 1111111111| 11       |


  Scenario Outline: User check checkboxlabel
    Given User opens '<homePage>' page
    And User opens main menu
    And User opens menu item Electronic
    And User opens menu item Home audio
    When User check in check box Climat Friendly
    Then label of check box is changed
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

