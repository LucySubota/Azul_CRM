package com.azul_crm.pages;

import com.azul_crm.utilities.ConfigurationReader;
import com.azul_crm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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


    public void sendFile(String fileName){
        String fileSeparator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + fileSeparator + "src/test/resources/files" + fileSeparator + fileName;
        uploadFilesAndImgBtn.sendKeys(path);
    }

    public void insertInText(String fileName){
        String fileSeparator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + fileSeparator + "src/test/resources/files" + fileSeparator + fileName;
        uploadFilesAndImgBtn.sendKeys(path);

        insertInText_btn.click();

        Driver.getDriver().switchTo().frame(iframe);

        String[] arr = path.split("/");
        String lastElement = arr[arr.length - 1];

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(messageInputBox));
        String actualElement = messageInputBox.getText();

            Assert.assertTrue(actualElement.contains(lastElement));
        Driver.getDriver().switchTo().parentFrame();

    }

    public void removingVerify(String file){


        try {
            delete_uploaded_files.click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            Driver.getDriver().navigate().refresh();
            message_btn.click();
            uploadFiles_icon.click();
            sendFile(file);
            delete_uploaded_files.click();
            e.printStackTrace();
        }

        /////////////////////
        try {
            Assert.assertFalse(emptyTable.isDisplayed());

        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("NOT displayed");
        }


    }






}
