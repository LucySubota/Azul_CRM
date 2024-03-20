package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessagePage {

    public SendMessagePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//span[@id='feed-add-post-form-tab-message']" )

    public WebElement messageButton;

    @FindBy (css = "#blog-submit-button-save")

    public WebElement sendButton;

    @FindBy (xpath = "//div[@class='feed-add-error']/span[2]")

    public WebElement errorMessageA;

    @FindBy (xpath = "//span[@class='feed-add-post-del-but']")

    public WebElement deleteAllEmployees;

    @FindBy (xpath = "//span[@class='feed-add-info-text']")

    public WebElement errorMessageB;

    @FindBy (xpath = "//span[@data-id='UA']/span[1]")
    public WebElement allEmployees;

    @FindBy (xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelButton;


}
