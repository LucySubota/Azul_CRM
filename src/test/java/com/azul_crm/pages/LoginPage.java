package com.azul_crm.pages;

import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "input[name='USER_LOGIN']")
    public WebElement usernameInputBox;

    @FindBy (css = "input[name='USER_PASSWORD']")
    public WebElement passwordInputBox;

    @FindBy (className = "login-btn")
    public WebElement loginButton;

    @FindBy (css = ".errortext")
    public WebElement incorrectUsernameOrPasswordMessage;

    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }

    public void login(String userType){ // help desk
        userType = userType.replace(" ", "_");
        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");
        login(username, password);
    }


}
