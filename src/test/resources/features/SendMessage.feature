Feature: As a user, I should be able to send messages by clicking on Message tab in the Activity Stream.

#  Background: For all scenarios
#    When user enters valid credentials as "<userType>"
#    Then user should see home page
@MH
  Scenario Outline: AC1_Verify that the user can send a message by filling in the mandatory fields.
    When "<user>" is on Portal page
    And user click Message button
    And user click Send button
    Then user see "<errorA>" message
    Then user delete All employees as recipients
    And user click Send button
    Then user can see "<errorB>" message

    Examples:
      | user      | errorA                             | errorB                              |
      | hr        | The message title is not specified | Please specify at least one person. |
      | help desk | The message title is not specified | Please specify at least one person. |
      | marketing | The message title is not specified | Please specify at least one person. |