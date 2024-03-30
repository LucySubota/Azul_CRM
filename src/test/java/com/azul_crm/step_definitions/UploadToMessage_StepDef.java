package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.pages.MessagePage;
import com.azul_crm.utilities.BrowserUtils;
import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import com.google.common.io.Files;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.time.Duration;

public class UploadToMessage_StepDef {

    LoginPage loginPage = new LoginPage();
    MessagePage messagePage = new MessagePage();

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

    String path = ConfigurationReader.getProperty("file");
    @Given("{string} user is on Portal home page")
    public void user_is_on_portal_home_page(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageURL"));
        loginPage.login(userType);
    }


    @When("user clicks to Message button")
    public void user_clicks_to_message_button() {
        messagePage.message_btn.click();
    }

    @When("user click to Upload file icon")
    public void user_click_to_upload_file_icon() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='post-buttons-bottom'])[1]//span[@id='bx-b-uploadfile-blogPostForm']")));
        messagePage.uploadFiles_icon.click();
    }

    @Then("user should be able to upload {string}")
    public void user_should_be_able_to_upload(String fileName) {

        messagePage.sendFile(fileName);

    }

    @Then("verify that the user can insert the {string}  into text after clicking on Insert In Text button")
    public void verify_that_the_user_can_insert_the_into_text_after_clicking_on_insert_in_text_button(String fileType) {
        messagePage.insertInText(fileType);
        BrowserUtils.sleep(2);
        Driver.getDriver().switchTo().frame(messagePage.iframe);
        String lastElement = Files.getFileExtension(fileType);
        lastElement = "."+lastElement;

        switch (lastElement) {
            case ".txt":
            case ".docx":
            case ".pdf":
                String actualElement = messagePage.messageInputBox.getText();
                Assert.assertTrue( actualElement.contains(fileType));
                break;
            case ".png":
            case ".jpeg":
                String actualText = messagePage.imageAndPng.getAttribute("src");
                try {
                    String decoded = java.net.URLDecoder.decode(actualText, "UTF-8");
                    String[] arr = decoded.split("=");
                    String lastPartOfUrl = arr[arr.length - 1];
                    String extractedFilename = lastPartOfUrl.replaceAll("\\(\\d+\\)", "").trim();
                    extractedFilename = extractedFilename.replace(" ", "");
                    Assert.assertEquals(fileType, extractedFilename);

                }catch(UnsupportedEncodingException e){
                    e.printStackTrace();
                }
                break;
        }
        Driver.getDriver().switchTo().parentFrame();
    }

    @Then("verify that the user can remove  {string} at any time before sending")
    public void verify_that_the_user_can_remove_at_any_time_before_sending(String fileType) {
           // messagePage.removingVerify(fileType);
        try {
            messagePage.delete_uploaded_files.click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            Driver.getDriver().navigate().refresh();
            messagePage.message_btn.click();
            messagePage.uploadFiles_icon.click();
            messagePage.sendFile(fileType);
            messagePage.delete_uploaded_files.click();
            e.printStackTrace();
        }

        /////////////////////
        try {
            Assert.assertFalse(messagePage.emptyTable.isDisplayed());

        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("NOT displayed");
        }

    }




}
