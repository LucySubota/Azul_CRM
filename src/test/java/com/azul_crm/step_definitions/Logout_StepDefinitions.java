package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.pages.BasePage;
import com.azul_crm.utilities.BrowserUtils;
import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(185));

    @Given("user is on Portal home page")
    public void user_is_on_portal_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageURL"));
        loginPage.login("marketing");
    }

    @When("user clicks on profile name")
    public void user_clicks_on_profile_name() {
        loginPage.accountNameDropdown.click();
    }

    @Then("user sees five option dropdown manu")
    public void user_sees_five_option_dropdown_manu() {
        Assert.assertEquals(5, loginPage.accountNameDropdownOptions.size());
        Assert.assertTrue(loginPage.accountNameDropdownOptions.get(0).isDisplayed());
    }

    @When("user click on Log Out button")
    public void user_click_on_log_out_button() {
        loginPage.logOutButton.click();
    }

    @Then("user is logged out")
    public void user_is_logged_out() {
        BrowserUtils.verifyTitle("Authorization");
        // Bug: user is not logged out after 3 minutes
    }

    @When("user does not do any mouse or keyboard action for three minutes")
    public void user_does_not_do_any_mouse_or_keyboard_action_for_three_minutes() {
        wait.until(ExpectedConditions.titleIs("Authorization"));
    }


}
