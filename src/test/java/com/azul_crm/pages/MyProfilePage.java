package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyProfilePage extends BasePage{


    public MyProfilePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public List<String> myProfileOptionsAsString(){

        List<WebElement> actualMyProfileOptionsAsMenu = Driver.getDriver().findElements(By.xpath("//div[@id='profile-menu-filter']/a"));
        List<String> actualMyProfileOptionsAsString = new ArrayList<>();
        for (WebElement each : actualMyProfileOptionsAsMenu) {
            actualMyProfileOptionsAsString.add(each.getText());
        }

        return actualMyProfileOptionsAsString;
    }

    @FindBy(xpath = "//td[@class='user-profile-nowrap-second']/a")
    public WebElement emailAtMyProfile;
}
