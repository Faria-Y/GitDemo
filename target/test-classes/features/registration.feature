Feature:This feature will allow user to successfully create an account
  Author - Aya
  Reviewer - Dana

  Background: Verify Sign Up Here link redirects the user to the Sign Up page
    Given user entered correct URL
    When user clicks on sign Up Here link
    Then verify user is on the registration page

  Scenario Outline: Verify user is able to choose a proper title from the drop-down window
    #Given user is on the Registration page
    When user click on "<Title>" field
    Then verify user can see the drop-down window with title options
    When user clicks on proper "<selection>"
    Then verify chosen selection appears in the Title field
    Examples:
      | Title | selection |
      | Ms.   | Ms.       |
      | Mr.   | Mr.       |
      | Mrs.  | Mrs.      |


  Scenario: Verify user can enter first name
    When user enters "<First Name>" in first name field
    Then verify first name is displayed in the first name field


  Scenario: Verify user can enter last name

    When user enters "<Last Name>" in last name
    Then verify Last Name is displayed in the last name field

  Scenario Outline: Verify user can select gender
    When user clicks on proper "<Intended Selection>"
    Then active radio button displays "<Displayed Radio Button>"
    Examples:
      | Intended Selection | Displayed Radio Button |
      | M                  | M                      |
      | F                  | F                      |

  @dobValid
  Scenario Outline: Verify user can enter correct date of birth
    Given user clicks on DOB field
    When user types correct "<month>", "<day>", "<year>" format
    Then verify DOB is displayed  in the corresponding field
    Examples:
      | month | day | year |
      | 01    | 03  | 2000 |
      | 12    | 01  | 1995 |
      | 08    | 15  | 1967 |

  @dobInvalid
  Scenario Outline: Verify user can not enter invalid date of birth
    Given user clicks on DOB field
    When user types incorrect "<InvalidMonth>", "<InvalidDay>", "<InvalidYear>" format
    Then verify user gets an error message "Please match the requested format"
    Examples:
      | InvalidMonth | InvalidDay | InvalidYear |
      | 13           | 32         | 2023        |
      | 12           | 01         | 1867        |
      | 02           | 30         | 1998        |
      | 12           | 06         | 2050        |

  Scenario Outline:  Verify user is able to enter correct SSN
    Given user clicks on SSN field
    When user types in correct "<SSN>" format
    Then SSN is displayed in the SSN field
    Examples:
      | SSN         |
      | 123-45-6789 |
      | 123456789   |
      | 003-45-7777 |

  Scenario Outline:  Verify user is not able to enter incorrect SSN
    Given user clicks on SSN field
    When user types incorrect "<InvalidSSN>" format
    Then error message is displayed prompting to enter correct format SSN
    Examples:
      | InvalidSSN   |
      | 123456789999 |
      | 123$567*900  |
      | 00-000-0000  |
      | 123$567*900  |
      | 0a-000-j000  |


  Scenario Outline: Verify user is able to enter valid Email address
    When user enters  valid "<Email>" in the Email field
    Then verify email is displayed in the email field
    Examples:
      | Email                 |
      | nicolesmith@gmail.com |
      | NICOLESMITH@GMAIL.COM |

  Scenario Outline: Verify user is not able to enter invalid Email address
    When user enters   "<InvalidEmail>" in the Email field
    Then verify user gets "Please match requested format" error
    Examples:
      | InvalidEmail         |
      | nicolesmithgmail.com |
      | mikefreeman@gmail    |
      | innamerlin@gmail.con |
      | hosna123@yahoocom    |


  Scenario: Verify user enters valid Password in requested format
    When user enters "<ValidPassword>" to the password field
    Then verify password is hidden
      | ValidPassword   |
      | NicoleSmith123! |


  Scenario Outline: Verify user sees error message when enters invalid Password format
    When user enters "<InValidPassword>" to the password field
    Then verify user gets "Please match requested format" error
    Examples:
      | InValidPassword |
      | NicoleSmith123  |
      | NicoleSmith*    |

#  Scenario: verify user puts same password in the Confirm Password field
#    When user enters password to both fields
#    Then verify "<First Password>" and "<Second Password>" are the same
#      | First Password  | Second Password |
#      | NicoleSmith123! | NicoleSmith123! |









