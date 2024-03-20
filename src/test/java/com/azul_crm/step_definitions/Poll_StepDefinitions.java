package com.azul_crm.step_definitions;

import com.azul_crm.pages.Home_ActivityStreamPage;
import com.azul_crm.utilities.BrowserUtils;
import com.azul_crm.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Poll_StepDefinitions {

    Home_ActivityStreamPage homePage = new Home_ActivityStreamPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    Faker faker = new Faker();
    String messageTitle;

    @When("user clicks Poll button")
    public void user_clicks_poll_button() {
        homePage.pollButton.click();
    }
    @Then("user types {string}")
    public void user_types(String question) {
        question = faker.animal().name();
        homePage.questionOneInput.sendKeys(question);
    }

    @Then("user types {string} message")
    public void userTypesMessage(String message) {
        message = faker.artist().name();
        messageTitle = message;
        homePage.enterMessageInMessageTitleIframe(message);
    }

    @Then("user erases question")
    public void userErasesQuestion() {
        homePage.questionOneInput.clear();
    }

    @Then("user types {string} and {string}")
    public void user_types_and(String answer1, String answer2) {
        answer1 = faker.beer().name();
        answer2 = faker.cat().name();
        homePage.answersInputs.get(0).sendKeys(answer1);
        homePage.answersInputs.get(1).sendKeys(answer2);
    }

    @And("user sees the poll being posted")
    public void userSeesThePollBeingPosted() {
        BrowserUtils.sleep(2);
        Assert.assertEquals(homePage.mostRecentPostInActiveStream.getText(), messageTitle);
    }

    @Then("user clicks Send button")
    public void user_clicks_send_button() {
        homePage.sendButton.click();
    }


    @Then("user sees All Employees as delivery chosen by default")
    public void user_sees_all_employees_as_delivery_chosen_by_default() {
        Assert.assertTrue(homePage.allEmployeesRecipientTag.isDisplayed());
    }

    @Then("user can select the Allow multiple choice checkbox")
    public void user_can_select_the_allow_multiple_choice_checkbox() {
        Assert.assertTrue(homePage.allowMultipleChoiceCheckbox.isEnabled());
    }

    @Then("user sees {string} message")
    public void userSeesMessage(String message) {
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(homePage.errorMessagePopUp)));
        Assert.assertEquals(message, homePage.errorMessagePopUp.getText());
    }

    @Then("user deletes All employees as recipients")
    public void user_deletes_all_employees_as_recipients() {
        homePage.deleteAllEmployeesAsRecipientsButton.click();
    }


    @Then("user sees {string}.........{string} error3 message")
    public void userSeesErrorMessage(String beginning, String ending) {
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(homePage.errorMessagePopUp)));
        Assert.assertTrue(homePage.errorMessagePopUp.getText().startsWith(beginning) && homePage.errorMessagePopUp.getText().endsWith(ending));
    }


}
