@companyStructure
Feature: Company Structure functionality


#  1. Verify that the Company Structure is visible for all user types.
#  2. Verify that the HR user can add a department from the Company Structure.
#  3. Verify that the “ADD DEPARTMENT” button is not displayed for Helpdesk and Marketing users.

  Scenario Outline: 1. Verify that the Company Structure is visible for all user types.
    When "<user>" is on Portal home page
    And user clicks Employees button from the menu
    Then user sees Company Structure

    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |

   Scenario: 2. Verify that the HR user can add a department from the Company Structure.
    When "hr" is on Portal home page
    And user clicks Employees button from the menu
    And user click Add Department button
    Then user types department name in respective input box
    And user clicks Add
    Then user sees the department is added to Company Structure tree


  Scenario Outline: 3. Verify that the “ADD DEPARTMENT” button is not displayed for Helpdesk and Marketing users.
    When "<user>" is on Portal home page
    And user clicks Employees button from the menu
    Then user does not see Add Department button on Company Structure page

    Examples:
      | user      |
      | help desk |
      | marketing |
