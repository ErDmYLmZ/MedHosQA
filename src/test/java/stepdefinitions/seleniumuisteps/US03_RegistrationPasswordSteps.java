package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.RegistrationPage;
import utilities.Driver;


public class US03_RegistrationPasswordSteps {

    CommonPageElements commonPageElements = new CommonPageElements();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("User goes to url")
    public void userGoesToUrl() {
        //Hooks
    }

    @Given("User navigates to Registration Page")
    public void user_navigates_to_registration_page() {
        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
        Driver.waitAndClick(commonPageElements.register);
    }

    @Given("user enters a new password as {string}")
    public void user_enters_a_new_password_as(String password) {
        registrationPage.firstPasswordTextbox.sendKeys(password);
    }

    @Then("Verify the strength bar is green")
    public void verify_the_strength_bar_is_green() {
        String strengthBarColor = registrationPage.strengthBar.getAttribute("style");
        Assert.assertFalse(strengthBarColor.contains("250"));
    }

    @Given("user is on the Registration page")
    public void user_is_on_the_registration_page() {
        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
        Driver.waitAndClick(commonPageElements.register);
    }
    @Given("user enters a password as {string}")
    public void user_enters_a_password_as(String password) {
        Driver.waitAndSendText(registrationPage.firstPasswordTextbox, password);
    }
    @Then("Verify Verify the strength bar is red")
    public void verify_verify_the_strength_bar_is_red() {
        String strengthBarColor = registrationPage.strengthBar.getAttribute("style");
        Assert.assertFalse(strengthBarColor.contains("255"));

    }



}
