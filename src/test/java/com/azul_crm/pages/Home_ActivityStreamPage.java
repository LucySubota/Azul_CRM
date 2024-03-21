package com.azul_crm.pages;

import com.azul_crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_ActivityStreamPage extends BasePage{

    public Home_ActivityStreamPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Left Side Menu Buttons

    @FindBy (xpath = "//a[@title='Activity Stream']")
    public WebElement activityStreamMenuButton;

    @FindBy (xpath = "//a[@title='Tasks']")
    public WebElement tasksMenuButton;

    @FindBy (xpath = "//a[@title='Chat and Calls']")
    public WebElement chatAndCallsMenuButton;

    @FindBy (xpath = "//a[@title='Workgroups']")
    public WebElement workgroupsMenuButton;

    @FindBy (xpath = "//a[@title='Drive']")
    public WebElement driveMenuButton;

    @FindBy (xpath = "//a[@title='Calendar']")
    public WebElement calendarMenuButton;

    @FindBy (xpath = "//a[@title='Mail']")
    public WebElement mailMenuButton;

    @FindBy (xpath = "//a[@title='Contact Center']")
    public WebElement contactCenterMenuButton;

    @FindBy (xpath = "//a[@title='Time and Reports']")
    public WebElement timeAndReportsMenuButton;

    @FindBy (xpath = "//a[@title='Services']")
    public WebElement servicesMenuButton;

    @FindBy (xpath = "//a[@title='Employees']")
    public WebElement employeesMenuButton;

    @FindBy (xpath = "//a[@title='Company']")
    public WebElement companyMenuButton;


    // WebElements and Methods for Poll functionality

    @FindBy (css = "#feed-add-post-form-tab-vote")
    public WebElement pollButton;

    @FindBy (css = "#question_0")
    public WebElement questionOneInput;

    @FindAll({@FindBy (xpath = "(//ol[@class='vote-answers']/li)/input[1]")})
    public List<WebElement> answersInputs;

    @FindBy (css = "#blog-submit-button-save")
    public WebElement sendButton;

    @FindBy (xpath = "(//div[@class='feed-wrap'])[2]/div[1]//div[contains(@id,'blog_post_body_')]")
    public WebElement mostRecentPostInActiveStream;

    @FindBy (css = ".feed-add-post-destination-text")
    public WebElement allEmployeesRecipientTag;

    @FindBy (css = "#multi_0")
    public WebElement allowMultipleChoiceCheckbox;

    @FindBy (xpath = "//div[@id='feed-add-post-form-notice-blockblogPostForm']/div/span[2]")
    public WebElement errorMessagePopUp;

    @FindBy (css = ".feed-add-post-del-but")
    public WebElement deleteAllEmployeesAsRecipientsButton;

    @FindBy (css = ".bx-editor-iframe")
    public WebElement messageInputIframe;

    public void enterMessageInMessageTitleIframe(String message){
        Driver.getDriver().switchTo().frame(messageInputIframe);
        Driver.getDriver().findElement(By.xpath("//html/body[@contenteditable]")).sendKeys(message);
        Driver.getDriver().switchTo().parentFrame();
    }

// WebElements for Message functionality

    @FindBy(xpath = "//span[.='Message']")
    public WebElement messageLink;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement linkIcon;

    @FindBy(xpath = "//input[@placeholder='Link text']")
    public WebElement linkText;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    public WebElement linkURL;

    @FindBy(xpath = "//input[@id='undefined']")
    public WebElement saveButton ;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendMessage;

    @FindBy(xpath = "//div[@class='feed-post-text-block-inner-inner']/a")
    public WebElement postedLinkText;
}
