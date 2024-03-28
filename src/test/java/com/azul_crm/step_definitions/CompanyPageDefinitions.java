package com.azul_crm.step_definitions;

import com.azul_crm.pages.LoginPage;
import com.azul_crm.pages.CompanyPage;
import com.azul_crm.pages.MyProfilePage;
import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import com.azul_crm.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CompanyPageDefinitions {

    LoginPage loginPage = new LoginPage();

    CompanyPage companyPage = new CompanyPage();

    @Given("user is on main home page")
    public void userIsOnMainHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageURL"));
        loginPage.login("user");
    }



        @When("user can click Company button")
    public void user_can_click_Company_button() {
        companyPage.company.click();
    }


    @Then("user sees modulesList on the header of page")
    public void user_sees_modules_list_on_the_header_of_page(List<String> expectedModulesList) {

    }



}


