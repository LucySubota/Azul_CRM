@B32G18-228
  @smoke
Feature: Default

	#*US_* As a user, I should be able to login
	#
	#*AC1_* Verify that the user can log in with valid credentials and land on the home page after successful login.
	#   (We have 3 types of users such as HR user, Marketing user, and Helpdesk user).
  @B32G18-226
  Scenario Outline: AC1_Verify that the user can log in with valid credentials
    When user enters valid credentials as "<userType>"
    Then user should see home page
    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |

	#{*}US_{*}As a user, I should be able to login
	#
	#*AC2_* Verify that "Incorrect login or password" error message is displayed for invalid (valid username-invalid password and invalid username-valid password) credentials.
  @B32G18-227
  Scenario Outline: AC2_Verify that "Incorrect login or password" error message is displayed for invalid credentials.
    When user enters invalid "<username>" and "<password>"
    Then user should see Incorrect username or password displayed
    Examples:
      | username            | password |
      | whatever@gmail.com  | UserUser |
      | helpdesk1@cydeo.com | Useruser |
      | helpdesk1@cydeo.com | abc      |
      | abc                 | abc      |

	#{*}US_{*}As a user, I should be able to login
	#
	#*AC3_* Verify that the "Please fill out this field" error message is displayed if the password or username is empty.
  @B32G18-229
  Scenario Outline: AC3_Verify that the "Please fill out this field" error message is displayed if the password or username is empty.
    When user enters valid "<input>"
    And user clicks Log In button
    Then user sees "Please fill out this field" pop up
    Examples:
      | input    |
      | username |
      | password |

	#{*}US_{*}As a user, I should be able to login
	#*AC4_* Verify that the "Remember me on this computer" link exists and is clickable on the login page.
  @B32G18-230
  Scenario: AC4_Verify that the "Remember me on this computer" link exists and is clickable on the login page.
    Then user can see and click Remember me on this computer checkbox

	#*US_* As a user, I should be able to login
	#
	#*AC5_* Verify that the password is in bullet signs by default.
  @B32G18-231
  Scenario: AC5_Verify that the password is in bullet signs by default.
    When user enters password
    Then user sees it being in bullet signs