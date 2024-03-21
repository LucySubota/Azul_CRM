@B32G18-256
Feature: Default

	#{*}US_{*}As a user, I should be able to create a poll by clicking on Poll tab under Activity Stream
	#
	#*AC2_* Verify that the user can create a poll by adding questions and multiple answers
  @B32G18-255
  Scenario Outline: AC2_Verify that the user can create a poll by adding questions and multiple answers
    When "<user>" is on Portal home page
    And user clicks Poll button
    Then user types "message title" message
    And user types "question"
    And user types "answer1" and "answer2"
    Then user clicks Send button
    And user sees the poll being posted
    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |

	#US:
	#
	#*AC1_* Verify that the delivery is 'All employees' by default.
  @B32G18-250
  Scenario Outline: AC1_Verify that the delivery is 'All employees' by default.
    When "<user>" is on Portal home page
    And user clicks Poll button
    Then user sees All Employees as delivery chosen by default
    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |

	#*US_* As a user, I should be able to create a poll by clicking on Poll tab under Activity Stream
	#
	#*AC3_* Verify that the user can select the “Allow multiple choice” checkbox.
  @B32G18-257
  Scenario Outline: AC3_Verify that the user can select the “Allow multiple choice” checkbox.
    When "<user>" is on Portal home page
    And user clicks Poll button
    Then user can select the Allow multiple choice checkbox
    Examples:
      | user      |
      | hr        |
      | help desk |
      | marketing |

	#*US_* As a user, I should be able to create a poll by clicking on Poll tab under Activity Stream
	#
	#*AC4_* Verify the corresponding error messages for the mandatory fields.
	#Mandatory fields: Message title, recipient, 1 question, 1 answer
	#Error message: "The message title is not specified"
	#Error message: "Please specify at least one person."
	#Error message: "The question text is not specified."
	#Error message: "The question "........." has no answers."
  @B32G18-258
  Scenario Outline: AC4_Verify the corresponding error messages for the mandatory fields.
    When "<user>" is on Portal home page
    And user clicks Poll button
    And user clicks Send button
    Then user sees "<error1>" message
    Then user deletes All employees as recipients
    And user clicks Send button
    Then user sees "<error2>" message
    Then user types "message" message
    And user types "question"
    Then user clicks Send button
    Then user sees "The question "........." has no answers." error3 message
    Then user erases question
    And user types "answer1" and "answer2"
    And user clicks Send button
    Then user sees "<error4>" message

    Examples:
      | user      | error1                             | error2                              | error4                              |
      | hr        | The message title is not specified | Please specify at least one person. | The question text is not specified. |
      | help desk | The message title is not specified | Please specify at least one person. | The question text is not specified. |
      | marketing | The message title is not specified | Please specify at least one person. | The question text is not specified. |