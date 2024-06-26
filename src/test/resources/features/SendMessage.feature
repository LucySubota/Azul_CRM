@B32G18-214
Feature: As a user, I should be able to send messages by clicking on Message tab in the Activity Stream.

  @MH1.1
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

  @MH1.2
  Scenario Outline: AC2_Verify that the message delivery is to 'All employees' by default.
    When "<user>" is on Portal page
    And user click Message button
    Then user see All employees by default

    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |

  @MH1.3
  Scenario Outline: AC3_Verify that the user can cancel sending message at any time before sending.
    When "<user>" is on Portal page
    And user click Message button
    And user see Cancel button
    Then user click Cancel button

    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |
