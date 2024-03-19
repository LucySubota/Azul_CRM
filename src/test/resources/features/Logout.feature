@B32G18-235
Feature: Default

  Background:
		#@B32G18-234
    Given user is on Portal home page
		

	#*US_* As a user, I should be able to log out
	#
	#*AC1_* Verify that the user can log out from the app after clicking the “Log out” button.
  @B32G18-233
  Scenario: AC1_Verify that the user can log out from the app after clicking the “Log out” button.
    When user clicks on profile name
    And user click on Log Out button
    Then user is logged out

	#{*}US_{*}As a user, I should be able to log out
	#
	#{*}AC2_{*}Verify that the user can see 5 options under the profile name.
	#
	#My Profile
	#Edit Profile Settings
	#Themes
	#Configure notifications
	#Log out
  @B32G18-236
  Scenario: AC2_Verify that the user can see 5 options under the profile name.
    When user clicks on profile name
    Then user sees five option dropdown manu
      | My Profile              |
      | Edit Profile Settings   |
      | Themes                  |
      | Configure notifications |
      | Log out                 |