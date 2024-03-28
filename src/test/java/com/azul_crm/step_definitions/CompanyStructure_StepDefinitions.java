package com.azul_crm.step_definitions;

import com.azul_crm.pages.CompanyStructurePage;
import com.azul_crm.pages.Home_ActivityStreamPage;
import com.azul_crm.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public class CompanyStructure_StepDefinitions {

    Home_ActivityStreamPage homePage = new Home_ActivityStreamPage();
    CompanyStructurePage companyStructurePage = new CompanyStructurePage();
    Faker faker = new Faker();
    String newDepartmentName;

    @When("user clicks Employees button from the menu")
    public void user_clicks_employees_button_from_the_menu() {
        homePage.employeesMenuButton.click();
    }

    @Then("user sees Company Structure")
    public void user_sees_company_structure() {
        Assert.assertTrue(companyStructurePage.companyStructureTree.isDisplayed());
    }

    @When("user click Add Department button")
    public void user_click_add_department_button() {
        companyStructurePage.addDepartmentButton.click();
    }

    @Then("user types department name in respective input box")
    public void user_types_department_name_in_respective_input_box() {
        newDepartmentName = faker.commerce().department();
        companyStructurePage.departmentNameInputBox.sendKeys(newDepartmentName);
    }

    @Then("user clicks Add")
    public void user_clicks_add() {
        companyStructurePage.addButton.click();
    }

    @Then("user sees the department is added to Company Structure tree")
    public void user_sees_the_department_is_added_to_company_structure_tree() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(companyStructurePage.getSecondLayerDepartmentsNames().contains(newDepartmentName));
        //deleting new department from the tree for clean up
        companyStructurePage.deleteDepartment(newDepartmentName);
    }

    @Then("user does not see Add Department button on Company Structure page")
    public void user_does_not_see_add_department_button_on_company_structure_page() {
        Assert.assertThrows(NoSuchElementException.class, () -> {
            companyStructurePage.addDepartmentButton.isDisplayed();
        });
    }


}
