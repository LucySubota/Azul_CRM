package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "user-block")
    public WebElement accountNameDropdown;

    @FindBy (xpath = "//div[@class='menu-popup-items']/*")
    public List<WebElement> accountNameDropdownOptions;

    @FindBy (linkText = "Log out")
    public WebElement logOutButton;

}
