package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PortalHomePage extends BasePage{

    public PortalHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
