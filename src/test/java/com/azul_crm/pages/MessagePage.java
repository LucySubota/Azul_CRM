package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import com.google.common.io.Files;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.UnsupportedEncodingException;
import java.time.Duration;

public class MessagePage {


    public MessagePage() {
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


    @FindBy(xpath = "//body/img[contains(@src, 'filename')]")
    public WebElement imageAndPng;


    public void sendFile(String fileName) {
        String fileSeparator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + fileSeparator + "src/test/resources/files" + fileSeparator + fileName;
        uploadFilesAndImgBtn.sendKeys(path);
    }

    public void insertInText(String fileName)  {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        insertInText_btn.click();

    }

//    public void removingVerify(String file) {
//
//
//
//
//    }




}
