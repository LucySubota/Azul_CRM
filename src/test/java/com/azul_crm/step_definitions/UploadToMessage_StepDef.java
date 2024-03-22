package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.pages.MessagePage;
import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    @Then("verify that the user can remove  {string} at any time before sending")
    public void verify_that_the_user_can_remove_at_any_time_before_sending(String fileType) {
        messagePage.removingVerify(fileType);
    }






}
