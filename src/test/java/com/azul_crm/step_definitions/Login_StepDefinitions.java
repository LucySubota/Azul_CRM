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


    @When("user enters valid credentials as {string}")
    public void user_enters_valid_credentials_as(String userType) {
        loginPage.login(userType);
    }

    @When("user enters valid {string}")
    public void user_enters_valid(String input) {
        if(input.equals("username")){
            loginPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("hr_username"));
        }else{
            loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("hr_password"));
        }
    }
    @When("user clicks Log In button")
    public void user_clicks_log_in_button() {
        loginPage.loginButton.click();
    }
    @Then("user sees {string} pop up")
    public void user_sees_pop_up(String popUp) {
        Assert.assertTrue(loginPage.pleaseFillOutThisFieldPopUp.isDisplayed());
    }

    @Then("user can see and click Remember me on this computer checkbox")
    public void user_can_see_and_click_remember_me_on_this_computer_checkbox() {
        Assert.assertTrue(loginPage.rememberMeCheckbox.isEnabled() && loginPage.rememberMeText.isDisplayed());
    }

    @When("user enters password")
    public void user_enters_password() {
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("hr_password"));
    }
    @Then("user sees it being in bullet signs")
    public void user_sees_it_being_in_bullet_signs() {
        Assert.assertEquals(loginPage.passwordInputBox.getAttribute("type"), "password");
    }

}
