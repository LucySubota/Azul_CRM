@sn
#put your test execution id from zira like @B32G18-235
Feature: As a user, I should be able to access my profile page.

 # Background:
		#@B32G18-234
  #  Given user is on Portal home page
   # And user clicks on profile name

    #User Story 3: As a user, I should be able to access my profile page.
    #Acceptance Criteria 1: Verify that the user can view the following options on My Profile page.
      #General
      #Drive
      #Tasks
      #Calendar
      #Conversations
  @B32G18-238
  Scenario: AC1_Verify that the a help desk user can view the following mentioned options on My Profile page.
    Given help desk user is on Portal home page
    And user clicks on profile name
    When help desk user clicks my profile link text
    Then help desk user sees below mentioned myProfileOptions on screen
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
@B32G18-237
  Scenario: AC1_Verify that the a HR user can view the following mentioned options on My Profile page.
    Given HR user is on Portal home page
    And user clicks on profile name
    When HR user clicks my profile link text
    Then HR user sees below mentioned myProfileOptions on screen
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
  @B32G18-239
  Scenario: AC1_Verify that the a marketing user can view the following mentioned options on My Profile page.
    Given marketing user is on Portal home page
    And user clicks on profile name
    When marketing user clicks my profile link text
    Then marketing user sees below mentioned myProfileOptions on screen
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |

    # AC2: Verify that the email under the General tab is the same as the user’s account.

  #put your test case is from zira like   @B32G18-233
  @B32G18-240
  Scenario: AC2_Verify that the email under the General tab is the same as the HR user’s account.
    Given HR user is on Portal home page
    And user clicks on profile name
    When HR user clicks my profile link text
    Then email under general tab is same as HR user's account

#put your test case is from zira like   @B32G18-233
  @B32G18-241
  Scenario: AC2_Verify that the email under the General tab is the same as the help desk user’s account.
    Given help desk user is on Portal home page
    And user clicks on profile name
    When help desk user clicks my profile link text
    Then email under general tab is same as help desk user's account

#put your test case is from zira like   @B32G18-233
  @B32G18-242
  Scenario: AC2_Verify that the email under the General tab is the same as the marketing user’s account.
    Given marketing user is on Portal home page
    And user clicks on profile name
    When marketing user clicks my profile link text
    Then email under general tab is same as marketing user's account
