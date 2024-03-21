package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "user-block")
    public WebElement accountNameIcon;

    @FindBy (linkText = "Log out")
    public WebElement logOutButton;

    @FindBy(linkText = "My Profile")
    public WebElement myProfile;

    public List<WebElement> getAccountNameDropdownOptions_as_WebElement(){
        List<WebElement> accountNameDropdownOptionsWithSpans = Driver.getDriver().findElements(By.xpath("//div[@class='menu-popup-items']/*/span"));
        List<WebElement> accountNameDropdownOptions = new ArrayList<>();
        for (int i = 1; i < accountNameDropdownOptionsWithSpans.size(); i+=2) {
            accountNameDropdownOptions.add(accountNameDropdownOptionsWithSpans.get(i));
        }
        return accountNameDropdownOptions;
    }

    public List<String> getAccountNameDropdownOptions_as_String(){
        List<WebElement> accountNameDropdownOptions = getAccountNameDropdownOptions_as_WebElement();
        List<String> accountNameDropdownOptionsAsString = new ArrayList<>();
        for (WebElement each : accountNameDropdownOptions) {
            accountNameDropdownOptionsAsString.add(each.getText());
        }
        return accountNameDropdownOptionsAsString;
    }



}
