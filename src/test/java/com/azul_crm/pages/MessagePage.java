package com.azul_crm.pages;

import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {

    public MessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Message']")
    public WebElement message_btn;

    @FindBy(xpath = "(//div[@id='post-buttons-bottom'])[1]//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFiles_icon;


    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadFilesAndImgBtn;

    @FindBy(xpath = "//span[text()='Insert in text']")
    public WebElement insertInText_btn;

    @FindBy(xpath = "//td[@class='files-del-btn']/span")
    public WebElement delete_uploaded_files;

    @FindBy(css = ".bx-editor-iframe")
    public WebElement iframe;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageInputBox;

    @FindBy(css = ".files-name")
    public WebElement emptyTable;

public void mainSteps(){
    message_btn.click();
   uploadFiles_icon.click();
    String path = ConfigurationReader.getProperty("file");
    uploadFilesAndImgBtn.sendKeys(path);
}



}
