@login
Feature: Login feature
  User Story:
  As a user, I should be able to log in with valid credentials and land on the home page after successful login.
  "Incorrect username or password." message should be displayed for invalid login attempt.
  Accounts are: hr, help desk, marketing

  Background:
    Given user is on the login page

  Scenario: Login as hr
    When user enters valid "hr" credentials
    Then user should see home page

  Scenario: Login as help desk
    When user enters valid "help desk" credentials
    Then user should see home page

  Scenario: Login as marketing
    When user enters valid "marketing" credentials
    Then user should see home page

  Scenario Outline: Login with invalid credentials
    When user enters invalid "<username>" and "<password>"
    Then user should see Incorrect username or password displayed
    Examples:
      | username            | password |
      | whatever@gmail.com  | UserUser |
      | helpdesk1@cydeo.com | Useruser |
      | helpdesk1@cydeo.com | abc      |
      | abc                 | abc      |