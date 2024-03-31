@B32G18-254
Feature: Default

  Scenario Outline: Verify that the <user> can upload <file>
  Supported file formats .pdf, .txt, .jpeg, .png, .docx
    Given "<user>" is on Portal home page
    When user clicks to Message button
    When user click to Upload file icon
    Then user should be able to upload "<file>"

    Examples:
      | user      | file          |
      | help desk | 2971.pdf      |
      | hr        | booknotes.txt |
      | marketing | CAMP REG.docx |
      | help desk | image.jpeg    |
      | hr        | sign.png      |


  Scenario Outline: Verify that the <user> can insert the <file> into the text
    Given "<user>" is on Portal home page
    When user clicks to Message button
    When user click to Upload file icon
    Then user should be able to upload "<file>"
    Then verify that the user can insert the "<file>"  into text after clicking on Insert In Text button

    Examples:
      | user      | file          |
      | help desk | 2971.pdf      |
      | hr        | booknotes.txt |
      | marketing | CAMP REG.docx |
      | help desk | image.jpeg    |
      | hr        | sign.png      |


  Scenario Outline: Verify that the <user> can remove <file> before sending.
    Given "<user>" is on Portal home page
    When user clicks to Message button
    When user click to Upload file icon
    Then user should be able to upload "<file>"
    Then verify that the user can remove  "<file>" at any time before sending

    Examples:
      | user      | file          |
      | help desk | 2971.pdf      |
      | hr        | booknotes.txt |
      | marketing | CAMP REG.docx |
      | help desk | image.jpeg    |
      | hr        | sign.png      |

    #123
