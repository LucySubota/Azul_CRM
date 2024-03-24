package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CompanyStructurePage {

    public CompanyStructurePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "#bx_visual_structure")
    public WebElement companyStructureTree;

    @FindBy (xpath = "//span[.='Add department']/..")
    public WebElement addDepartmentButton;

    @FindBy (css = "#NAME")
    public WebElement departmentNameInputBox;

    @FindAll (@FindBy (xpath = "//tr[@class='bx-str-l2']/td/span//a[@data-role='department_name']"))
    public List<WebElement> secondLayerDepartments;

    @FindBy (xpath = "//span[.='Add']")
    public WebElement addButton;

    public void deleteDepartment(String departmentName){
        for (WebElement each : secondLayerDepartments) {
            if (each.getText().equals(departmentName)) {
                each.click();
                Driver.getDriver().findElement(By.xpath("//a[.='Delete department']")).click();
                Alert alert = Driver.getDriver().switchTo().alert();
                alert.accept();
                System.out.println("FOUND AND CLICKED DEPARTMENT TO DELETE");
                break;
            }
        }
    }

    public List<String> getSecondLayerDepartmentsNames(){
        List<String> names = new ArrayList<>();
        for(WebElement each : secondLayerDepartments){
            names.add(each.getText());
        }
        return names;
    }

}
