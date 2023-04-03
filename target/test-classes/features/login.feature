Feature: Login feature
  Author - Aya
  Reviewer - Dana

  Background: Verify user is on the main page
    Given user entered correct URL
    Then verify the title of the webpage is Digital Bank
    And verify all sign-in text boxes and buttons are present

  Scenario: Verify user is able to login with valid credentials
    Given user enters valid username "<valid.username>" and password "<valid.password>"
    When user clicks on Sign In button
    Then verify user is successfully logged in to the account

  Scenario Outline: Verify user is not able to login with both invalid credentials
    Given user enters invalid username "<InvalidEmail>" and password "<InvalidPassword>"
    When user clicks on Sign In button
    Then verify user login failed with an error message
    Examples:
      | InvalidEmail         | InvalidPassword |
      | nicolesmithgmail.com | evbybtrb        |
      | mikefreeman@gmail    | oob4t8ubd       |
      | innamerlin@gmail.con | mgfjnjrtkv5555  |
      | hosna123@yahoocom    | JHBvbfhdsf2     |

  Scenario Outline: Verify user is not able to login with valid username and invalid password
    Given user enters valid username "<ValidEmail>" and invalid password "<InvalidPassword>"
    When user clicks on Sign In button
    Then verify user login failed with an error message
    Examples:
      | ValidEmail         | InvalidPassword |
      | megaadmin@mail.com | 4t8ubdfvds36    |
      | MEGAADMIN@MAIL.COM | mgfjnjrtkv55    |

  Scenario: Verify user is not able to login with invalid username and valid password
    Given user enters invalid username "<invalid.username>" and valid password "<valid.password>"
    When user clicks on Sign In button
    Then verify user login failed with an error message

  Scenario: verify user is not able to login with blank credentials
    Given user leaves username and password fields blank
    When user clicks on Sign In button
    Then verify user login failed with an error message

  Scenario: verify user is locked out after more than 3 unsuccessful attempts
    Given user had more than 3 unsuccessful login attempts
    When user clicks on Sign In button
    Then verify user login failed with an error message









