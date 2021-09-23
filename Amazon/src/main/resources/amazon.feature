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
      | https://www.amazon.com/ | phone   | 1                |

  Scenario Outline: Search results contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    Then User checks that first search results '<keyword>'
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | ASUS    |

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
      | homePage                | name   | phone      | password |
      | https://www.amazon.com/ | Myname | 1111111111 | 11       |


  Scenario Outline: User create new account with used email
    Given User opens '<homePage>' page
    And User opens Sign In page
    And User choose to create new Amazon account
    And User enter '<name>' in name field
    And User enter '<email>' in phone field
    And User enter '<password>' in password and re-enter password field
    When User click on verify button
    Then User see massage, that email is in use
    Examples:
      | homePage                | name   | email          | password |
      | https://www.amazon.com/ | Myname | test@gmail.com | 1111111  |


  Scenario Outline:User check the search price filter is working
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User set max price '<maxprice>'
    Then User check search first result is less then <maxprice>
    Examples:
      | homePage                | keyword | maxprice |
      | https://www.amazon.com/ | sofa    | 100      |

  Scenario Outline: User check the category name on search result
    Given User opens '<homePage>' page
    And User choose category books is search field
    When User makes search by keyword '<keyword>'
    Then User see, that first category name on search result page contains books
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | book    |


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


  Scenario Outline: User check that main category contains subcategory
    Given User opens '<homePage>' page
    And User opens main menu
    And wait
    And User click Sign In icon in top of menu
    Then User check that Sign In page is opened
    Examples:
      | homePage                |
      | https://www.amazon.com/ |


#работает, но оставляет открытой вкладку
  Scenario Outline: User check that covid-19 blog opens from covid-19 info
    Given User opens '<homePage>' page
    When User opens covid-19 blog
    Then User check that covid-19 blog is opened
    And User opens subscribe page
    Then User checked that email field is displayed
    Examples:
      | homePage                |
      | https://www.amazon.com/ |


# через раз после add to cart появляется попап, который долго грузится (товар не добавлен в корзину пока он не загрузится),
# и закрывает значек корзины.
  Scenario Outline: Check delete from shopping cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User opens first product page
    And User click add to cart
    And wait
    And User opens '<homePage>' page
    And User opens shopping cart
    When User delete item from shopping cart
    Then User checks that cart is empty
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | camera  |
