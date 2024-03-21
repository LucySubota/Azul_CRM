#As a user, I should be able to upload files and pictures as messages
#1. Verify that the user can upload files and pictures.
#Supported file formats .pdf, .txt, .jpeg, .png, .docx
#2. Verify that the user can insert the files and images into the text.
#3. Verify that the user can remove files and images at any time before sending.
@msg
Feature: Messages functionality

  Scenario Outline: 1. Verify that the user can upload files and pictures.
    Given "<user>" is on Portal home page
    When user clicks Message button
    And user clicks Upload File button
    And user clicks Upload files and images button and chooses "<file>" to upload
    Then user sees file with "<name>" has being uploaded

    Examples:
      | user      | file                               | name |
      | hr        | src/test/resources/files/Test.pdf  | Test |
      | hr        | src/test/resources/files/Test.txt  | Test |
      | hr        | src/test/resources/files/Test.jpeg | Test |
      | hr        | src/test/resources/files/Test.png  | Test |
      | hr        | src/test/resources/files/Test.docx | Test |
      | help desk | src/test/resources/files/Test.pdf  | Test |
      | help desk | src/test/resources/files/Test.txt  | Test |
      | help desk | src/test/resources/files/Test.jpeg | Test |
      | help desk | src/test/resources/files/Test.png  | Test |
      | help desk | src/test/resources/files/Test.docx | Test |
      | marketing | src/test/resources/files/Test.pdf  | Test |
      | marketing | src/test/resources/files/Test.txt  | Test |
      | marketing | src/test/resources/files/Test.jpeg | Test |
      | marketing | src/test/resources/files/Test.png  | Test |
      | marketing | src/test/resources/files/Test.docx | Test |


  Scenario Outline: 2. Verify that the user can insert the files and images into the text.
    Given "<user>" is on Portal home page
    When user clicks Message button
    And user clicks Upload File button
    And user clicks Upload files and images button and chooses "<file>" to upload
    Then user clicks Insert in text button
    Then user sees file with "<name>" inserted in the Message box

    Examples:
      | user      | file                               | name      |
      | hr        | src/test/resources/files/Test.pdf  | Test.pdf  |
      | hr        | src/test/resources/files/Test.txt  | Test.txt  |
      | hr        | src/test/resources/files/Test.jpeg | Test.jpeg |
      | hr        | src/test/resources/files/Test.png  | Test.png  |
      | hr        | src/test/resources/files/Test.docx | Test.docx |
      | help desk | src/test/resources/files/Test.pdf  | Test.pdf  |
      | help desk | src/test/resources/files/Test.txt  | Test.txt  |
      | help desk | src/test/resources/files/Test.jpeg | Test.jpeg |
      | help desk | src/test/resources/files/Test.png  | Test.png  |
      | help desk | src/test/resources/files/Test.docx | Test.docx |
      | marketing | src/test/resources/files/Test.pdf  | Test.pdf  |
      | marketing | src/test/resources/files/Test.txt  | Test.txt  |
      | marketing | src/test/resources/files/Test.jpeg | Test.jpeg |
      | marketing | src/test/resources/files/Test.png  | Test.png  |
      | marketing | src/test/resources/files/Test.docx | Test.docx |

  Scenario Outline: 3. Verify that the user can remove files and images at any time before sending.
    Given "<user>" is on Portal home page
    When user clicks Message button
    And user clicks Upload File button
    And user clicks Upload files and images button and chooses "<file>" to upload
    Then user enters message text
    And user deletes uploaded file
    Then user sees file with "<name>" has been deleted

    Examples:
      | user      | file                               | name |
      | hr        | src/test/resources/files/Test.pdf  | Test |
      | hr        | src/test/resources/files/Test.txt  | Test |
      | hr        | src/test/resources/files/Test.jpeg | Test |
      | hr        | src/test/resources/files/Test.png  | Test |
      | hr        | src/test/resources/files/Test.docx | Test |
      | help desk | src/test/resources/files/Test.pdf  | Test |
      | help desk | src/test/resources/files/Test.txt  | Test |
      | help desk | src/test/resources/files/Test.jpeg | Test |
      | help desk | src/test/resources/files/Test.png  | Test |
      | help desk | src/test/resources/files/Test.docx | Test |
      | marketing | src/test/resources/files/Test.pdf  | Test |
      | marketing | src/test/resources/files/Test.txt  | Test |
      | marketing | src/test/resources/files/Test.jpeg | Test |
      | marketing | src/test/resources/files/Test.png  | Test |
      | marketing | src/test/resources/files/Test.docx | Test |