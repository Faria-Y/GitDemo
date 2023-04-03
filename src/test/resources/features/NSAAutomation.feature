#1. Savings field under BANKING ACCOUNTS section is displayed
#clicking on 'Savings' dropdown should be displayed with following options: View Savings, New Savings
#2. Clicking on 'New Savings' option, should redirect user to "http://dbankdemo.com/account/savings-add"
####(Note: Click on 'New Savings' and try to open it in new tab)
#3. "New Savings Account" is displayed.
#4. "Select Savings Account Type" with the following radio button options: Savings, Money Market is Displayed.
# All Radio buttons should be unchecked by default.
#On the New Savings account creation page:
#5. A label "Select Account Ownership" is displayed with the following radio button options: Individual, Joint.
#All Radio buttons should be unchecked by default
#6. An Input filed "Account Name" is displayed.
#Accepts alphanumeric and special characters.
# 7. An Input field "Initial Deposit Amount" is displayed.
#Minimum opening deposit is $2500.00. Accepts numeric whole or decimal values.
#8. 'Submit' button is displayed, clicking on it should successfully create an account and user will be redirected to page to view saving account.
#9. 'Reset' button is displayed, clicking on it should reset all filled values to default state.
Feature: This feature file describes scenarios to verify successful navigation to New Savings Account creation page
  and validate all fields on New Savings account page.
  Author: Swati
  Reviewer: Dana


  Background: User is logged in to DigitalBank page with valid credentials and is on Banking Accounts page.
    Given user entered correct URL
    And user enters valid username "<valid.username>" and password "<valid.password>"
    And user clicks on Sign In button

  @nsa1-4
  Scenario: Verify Savings field is displayed under BANKING ACCOUNTS section and it has View Savings, New Savings
  options available
    Given user is successfully logged in to the account
    Then Savings field is displayed under BANKING ACCOUNTS section
    When user clicks on Savings field
    Then View Savings and New Savings options are displayed

    @nsa1-4
    Scenario: Verify New Savings Account header is displayed and Radio buttons are displayed unchecked
      Given user clicks on Savings field
      When user right clicks on New Savings option and chooses open in new tab
      Then Page title "New Savings Account" is displayed
      And Select Savings Account Type field is displayed
      And Radio button options: Savings, Money Market are displayed
      But Radio button options: Savings, Money Market are unchecked

    @nsa7-9
  Scenario: verify user is able to create an account and redirected to page to view saving account
    Given user clicks on Savings field
    When user right clicks on New Savings option and chooses open in new tab
    Then user filled the fields
    When user clicks on the Submit button
    Then verify user is redirected to page to view saving account

   @nsa7-9
  Scenario: verify user can click on Reset button
    Given user clicks on Savings field
    When user right clicks on New Savings option and chooses open in new tab
    Then user filled the fields
    When user clicks on the Reset button
    Then verify all the filled values are reset to default




