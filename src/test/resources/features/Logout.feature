@logout
Feature: Logout feature
  User Story:
  User should be able to log out

  User should be able to log out from the app after clicking the “Log Out” button.
  Users must be logged out if they are away from the keyboard for 3 minutes (AFK-away from the keyboard)
  (If the user does not do any mouse or keyboard action for 3 minutes)

  Background:
    Given user is on Portal home page

  Scenario: User should be able to see 5 options under the profile name
    When user clicks on profile name
    Then user sees five option dropdown manu

  Scenario: User should be able to click Log Out button and be logged out
    When user clicks on profile name
    And user click on Log Out button
    Then user is logged out

  Scenario:
    When user does not do any mouse or keyboard action for three minutes
    Then user is logged out