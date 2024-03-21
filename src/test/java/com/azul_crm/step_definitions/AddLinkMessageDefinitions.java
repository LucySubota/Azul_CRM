package com.azul_crm.step_definitions;

import com.azul_crm.pages.Home_ActivityStreamPage;
import com.azul_crm.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AddLinkMessageDefinitions {

    Home_ActivityStreamPage homePage = new Home_ActivityStreamPage();
    String msgText = "INOX";
    String msgLink = "https://www.google.com/";


    @And("user clicks MESSAGE link text")
    public void userClicksMESSAGELinkText() {

        homePage.messageLink.click();
    }

    @And("user clicks link icon")
    public void userClicksLinkIcon() {

        homePage.linkIcon.click();
    }

    @And("user types text in link text box")
    public void userTypesTextInLinkTextBox() {

        homePage.linkText.sendKeys(msgText);
    }

    @And("user types valid web link in link text box")
    public void userTypesValidWebLinkInLinkTextBox() {

        homePage.linkURL.sendKeys(msgLink);
    }

    @And("user clicks save button")
    public void userClicksSaveButton() {

        homePage.saveButton.click();
    }

    @Then("user user clicks send button")
    public void userUserClicksSendButton() {

        homePage.sendMessage.click();
    }

    @And("user sees provided link is attached to the specified text")
    public void userSeesProvidedLinkIsAttachedToTheSpecifiedText() {

        BrowserUtils.sleep(2);
        Assert.assertTrue(homePage.postedLinkText.getText().equals(msgText));

    }

    @And("user can navigate to the correct URL")
    public void userCanNavigateToTheCorrectURL() {
        Assert.assertTrue(homePage.postedLinkText.getAttribute("href").equals(msgLink));
    }

    @And("provided link opens in new tab")
    public void providedLinkOpensInNewTab() {

        Assert.assertTrue(homePage.postedLinkText.getAttribute("target").equals("_blank"));
    }
}
