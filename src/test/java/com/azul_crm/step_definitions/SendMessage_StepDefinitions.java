package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.pages.SendMessagePage;
import com.azul_crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendMessage_StepDefinitions {

    SendMessagePage sendMessagePage = new SendMessagePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    LoginPage loginPage = new LoginPage();

    @When("{string} is on Portal page")
    public void is_on_portal_page(String user) {

        loginPage.login(user);
    }
    @When("user click Message button")
    public void user_click_message_button() {

        sendMessagePage.messageButton.click();
    }


    @And("user click Send button")
    public void userClickSendButton() {

        sendMessagePage.sendButton.click();
    }

    @Then("user see {string} message")
    public void userSeeMessage(String messageA) {

        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(sendMessagePage.errorMessageA)));
        Assert.assertEquals(messageA, sendMessagePage.errorMessageA.getText());
    }

    @Then("user delete All employees as recipients")
    public void userDeleteAllEmployeesAsRecipients() {

        sendMessagePage.deleteAllEmployees.click();

    }

    @Then("user can see {string} message")
    public void userCanSeeMessage(String messageB) {

        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(sendMessagePage.errorMessageB)));
        Assert.assertEquals(messageB, sendMessagePage.errorMessageB.getText());
    }


    @Then("user see All employees by default")
    public void userSeeAllEmployeesByDefault() {

        sendMessagePage.allEmployees.isDisplayed();
    }

    @And("user see Cancel button")
    public void userSeeCancelButton() {

        sendMessagePage.cancelButton.isDisplayed();
    }

    @Then("user click Cancel button")
    public void userClickCancelButton() {

        sendMessagePage.cancelButton.click();
    }
}
