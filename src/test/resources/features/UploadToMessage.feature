@B32G18-254
Feature: Default

	Background:
		#@B32G18-249
		Given "help desk" user is on Portal home page
		When user click to Message button
		When user click to Upload files icon



	

	Scenario: Verify that the user can upload files and pictures. 	 Supported file formats .pdf, .txt, .jpeg, .png, .docx
		Then user should be able to upload file



	Scenario: Verify that the user can insert the files and images into the text.
		Then user should be able to upload file
		Then verify that the user can insert the file into text after clicking on Insert In Text button



	Scenario: Verify that the user can remove files and images at any time before sending.
		Then user should be able to upload file
		Then verify that the user can remove file at any time before sending