package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CompanyPage extends BasePage {
    public CompanyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id=\"bx_left_menu_menu_about_sect\"]/a")
    public WebElement company;

    @FindBy(xpath = "//*[contains(@class, 'main-buttons-item-link')]")
    public List<WebElement>modules;

    public void selectModule(String module){

        String locator=  "//*[contains(@class, 'main-buttons-item-link')]//*[.='"+module+"']";

        WebElement optionEl = Driver.getDriver().findElement(By.xpath(locator));
        optionEl.click();


    }
}


