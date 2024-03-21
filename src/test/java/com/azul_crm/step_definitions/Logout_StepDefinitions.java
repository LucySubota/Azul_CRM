package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.pages.Home_ActivityStreamPage;
import com.azul_crm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Logout_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    Home_ActivityStreamPage homePage = new Home_ActivityStreamPage();

    @When("{string} is on Portal home page")
    public void is_on_portal_home_page(String userType) {
        loginPage.login(userType);
    }

    @When("user clicks on profile name")
    public void user_clicks_on_profile_name() {
        loginPage.accountNameIcon.click();
    }

    @Then("user sees five option dropdown manu")
    public void user_sees_five_option_dropdown_manu(List<String> dropdownOptions) {
        List<String> actualOption = homePage.getAccountNameDropdownOptions_as_String();
        Assert.assertEquals(dropdownOptions, actualOption);
        Assert.assertTrue(homePage.getAccountNameDropdownOptions_as_WebElement().get(0).isDisplayed());
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


}
