package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.utilities.BrowserUtils;
import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageURL"));
    }

    @When("user enters valid {string} credentials")
    public void user_enters_valid_credentials(String userType) {
        loginPage.login(userType);
    }

    @Then("user should see home page")
    public void user_should_see_home_page() {
        BrowserUtils.verifyTitle("Portal");
    }

    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should see Incorrect username or password displayed")
    public void user_should_see_incorrect_username_or_password_displayed() {
        Assert.assertTrue(loginPage.incorrectUsernameOrPasswordMessage.isDisplayed());
        Assert.assertEquals(loginPage.incorrectUsernameOrPasswordMessage.getText(), ("Incorrect username or password"));
        // Bug:          Incorrect login or password
        // instead of:   Incorrect username or password
    }

}
