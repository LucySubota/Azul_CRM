
  @sn
  Feature: As a user, I should be able to access the Company page
    @B32G18-274
 Scenario Outline: Verify that the <usertype> can see the following modules on the Company page shown as design
      Given user enters valid credentials as "<userType>"
      When user can click Company button
    Then user sees modulesList on the header of page

      | Official Information   |
      | Our Life |
      | About Company |
      | Photo Gallery |
      | Video |
      | Career |
      | Business News (RSS) |
      | More |

      Examples:
        | userType  |
        | hr        |
        | help desk |
        | marketing |
