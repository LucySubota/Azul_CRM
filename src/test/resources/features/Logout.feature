@B32G18-235
	@smoke
Feature: Default

	#*US_* As a user, I should be able to log out
	#
	#*AC1_* Verify that the user can log out from the app after clicking the “Log out” button.
	@B32G18-233
	Scenario Outline: AC1_Verify that the user can log out from the app after clicking the “Log out” button.
		When "<user>" is on Portal home page
		And user clicks on profile name
		And user click on Log Out button
		Then user is logged out
		Examples:
		|user|
		|hr|
		|help desk|
		|marketing|	

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
	Scenario Outline: AC2_Verify that the user can see 5 options under the profile name.
		When "<user>" is on Portal home page
		And user clicks on profile name
		Then user sees five option dropdown manu
		|My Profile|
		|Edit Profile Settings|
		|Themes|
		|Configure notifications|
		|Log out|
		Examples:
		|user|
		|hr|
		|help desk|
		|marketing|