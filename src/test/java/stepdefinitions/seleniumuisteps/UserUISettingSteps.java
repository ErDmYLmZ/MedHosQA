package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.UserSettingsPage;
import utilities.Driver;

public class UserUISettingSteps {

    CommonPageElements cp = new CommonPageElements();
    UserSettingsPage us = new UserSettingsPage();

    @Given("user navigate page {string}")
    public void user_navigate_page(String string) {
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.settings);

    }

    @When("Change firstname lastname")
    public void change_firstname_lastname() {

        us.firstNameTb.clear();
        us.lastNameTb.clear();
        Driver.waitAndSendText(us.firstNameTb, "Ahmet");
        Driver.waitAndSendText(us.lastNameTb, "Koyuncu");
        Driver.waitAndClick(us.saveBtn);

    }
    @Then("verify if they are changed")
    public void verify_if_they_are_changed() throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertTrue(us.alert.getText().contains("Settings saved!"));

    }
}
