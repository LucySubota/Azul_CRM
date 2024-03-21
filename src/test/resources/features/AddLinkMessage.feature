#Jira Id

Feature: User Story#6 : As a user, I should be able to add link in message.

 # Acceptance Criteria:
  # AC1:Verify that the user can attach a link to the specified text.
  #AC2:Verify that by clicking on the link the user can navigate to the correct URL.
  #AC3:Verify that the link is opened in a new tab.

#@B32G18-264
  @snn
  Scenario Outline: AC1:Verify that the user can attach a link to the specified text
    When "<user>" is on Portal home page
    And user clicks MESSAGE link text
    And user clicks link icon
    And user types text in link text box
    And user types valid web link in link text box
    And user clicks save button
    Then user user clicks send button
    And user sees provided link is attached to the specified text
    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |
  @B32G18-265
  Scenario Outline: AC2:Verify that by clicking on the link the user can navigate to the correct URL
    When "<user>" is on Portal home page
    And user clicks MESSAGE link text
    And user clicks link icon
    And user types text in link text box
    And user types valid web link in link text box
    And user clicks save button
    Then user user clicks send button
    And user can navigate to the correct URL
    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |
  @B32G18-266
  Scenario Outline: AC3:Verify that the link is opened in a new tab.
    When "<user>" is on Portal home page
    And user clicks MESSAGE link text
    And user clicks link icon
    And user types text in link text box
    And user types valid web link in link text box
    And user clicks save button
    Then user user clicks send button
    And provided link opens in new tab
    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |