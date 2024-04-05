package com.azul_crm.step_definitions;

import com.azul_crm.pages.Home_ActivityStreamPage;
import com.azul_crm.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Message_StepDefinitions {

    Home_ActivityStreamPage homePage = new Home_ActivityStreamPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    Faker faker = new Faker();

    @When("user clicks Message button")
    public void user_clicks_message_button() {
        homePage.messageButton.click();
    }

    @When("user clicks Upload File button")
    public void user_clicks_upload_file_button() {
        homePage.uploadFileButton.click();
    }

    @When("user clicks Upload files and images button and chooses {string} to upload")
    public void user_clicks_upload_files_and_images_button_and_chooses_to_upload(String filePath) {
        String path = new File(filePath).getAbsolutePath();
        homePage.uploadFilesAndImagesButton.sendKeys(path);
    }

    @Then("user sees file with {string} has being uploaded")
    public void user_sees_file_with_has_being_uploaded(String fileName) {
        Assert.assertTrue(homePage.firstUploadedFile.getText().contains(fileName));
    }

    @Then("user clicks Insert in text button")
    public void userClicksInsertInTextButton() {
        wait.until(ExpectedConditions.visibilityOf(homePage.insertInTextButton));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.insertInTextButton));
        homePage.insertInTextButton.click();
    }

    @Then("user sees file with {string} inserted in the Message box")
    public void userSeesFileWithInsertedInTheMessageBox(String fileName) {
        Assert.assertTrue(homePage.isThereFileInMessageInputBox(fileName));
    }

    @Then("user enters message text")
    public void userEntersMessageText() {
        homePage.enterMessageInMessageTitleIframe(faker.chuckNorris().fact());
    }

    @And("user deletes uploaded file")
    public void userDeletesUploadedFile() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.deleteUploadedFileIcon));
        homePage.deleteUploadedFileIcon.click();
    }

    @Then("user sees file with {string} has been deleted")
    public void userSeesFileWithHasBeenDeleted(String fileName) {
        Assert.assertThrows(NoSuchElementException.class, () -> {
            homePage.firstUploadedFile.isDisplayed();
        });
    }

    //hi
    // hi
    //hi
//hello

}



