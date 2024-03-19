package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.pages.MyProfilePage;
import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyProfileDefinitions {

    LoginPage loginPage = new LoginPage();
    MyProfilePage myProfilePage = new MyProfilePage();


    @Given("HR user is on Portal home page")
    public void hrUserIsOnPortalHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageURL"));
        loginPage.login("hr");
    }

    @When("HR user clicks my profile link text")
    public void hr_user_clicks_my_profile_link_text() {
        loginPage.myProfile.click();
    }

    @Then("HR user sees below mentioned myProfileOptions on screen")
    public void hrUserSeesBelowMentionedMyProfileOptionsOnScreen(List<String> expectedMyProfileOptions) {
        Assert.assertEquals(expectedMyProfileOptions, myProfilePage.myProfileOptionsAsString());

    }


    @Given("help desk user is on Portal home page")
    public void helpDeskUserIsOnPortalHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageURL"));
        loginPage.login("help desk");
    }

    @When("help desk user clicks my profile link text")
    public void helpDeskUserClicksMyProfileLinkText() {
        loginPage.myProfile.click();
    }

    @Then("help desk user sees below mentioned myProfileOptions on screen")
    public void helpDeskUserSeesBelowMentionedMyProfileOptionsOnScreen(List<String> expectedMyProfileOptions) {
        Assert.assertEquals(expectedMyProfileOptions, myProfilePage.myProfileOptionsAsString());

    }

    @Given("marketing user is on Portal home page")
    public void marketingUserIsOnPortalHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageURL"));
        loginPage.login("marketing");
    }

    @When("marketing user clicks my profile link text")
    public void marketingUserClicksMyProfileLinkText() {
        loginPage.myProfile.click();

    }

    @Then("marketing user sees below mentioned myProfileOptions on screen")
    public void marketingUserSeesBelowMentionedMyProfileOptionsOnScreen(List<String> expectedMyProfileOptions) {
        Assert.assertEquals(expectedMyProfileOptions, myProfilePage.myProfileOptionsAsString());

    }

    @Then("email under general tab is same as HR user's account")
    public void emailUnderGeneralTabIsSameAsHRUserSAccount() {
        Assert.assertTrue(myProfilePage.emailAtMyProfile.getText().equals(ConfigurationReader.getProperty("hr_username")));
    }

    @Then("email under general tab is same as help desk user's account")
    public void emailUnderGeneralTabIsSameAsHelpDeskUserSAccount() {
        Assert.assertTrue(myProfilePage.emailAtMyProfile.getText().equals(ConfigurationReader.getProperty("help_desk_username")));
    }

    @Then("email under general tab is same as marketing user's account")
    public void emailUnderGeneralTabIsSameAsMarketingUserSAccount() {
        Assert.assertTrue(myProfilePage.emailAtMyProfile.getText().equals(ConfigurationReader.getProperty("marketing_username")));
    }
}
