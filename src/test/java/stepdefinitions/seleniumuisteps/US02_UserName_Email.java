package stepdefinitions.seleniumuisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPageElements;
import pages.RegistrationPage;
import utilities.Driver;


public class US02_UserName_Email {
    CommonPageElements commonPageElements = new CommonPageElements();
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Given("User goes to the URL {string}")
    public void user_goes_to_the_url(String url) {
        Driver.navigateToUrl(url);
    }
    @Given("User navigates to the registration page")
    public void user_navigates_to_the_registration_page() {
        commonPageElements.signInAndRegistrationPortal.click();
        commonPageElements.registrationTab.click();

    }
    @Given("User enters required data up to username field")
    public void user_enters_required_data_up_to_username_field() {
        registrationPage.ssnTextbox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstnameTextbox.sendKeys(faker.name().firstName());
        registrationPage.lastnameTextbox.sendKeys(faker.name().lastName());

    }
    @Given("User leaves the username field blank {string}")
    public void user_leaves_the_username_field_blank(String username) {
        registrationPage.usernameTextbox.sendKeys(username, Keys.ENTER);
    }
    @Then("User verifies the error massage")
    public void user_verifies_the_error_massage() {
        Assert.assertTrue(registrationPage.userNameRequiredText.isDisplayed());

    }
    @Given("User enters a valid username {string}")
    public void user_enters_a_valid_username(String userName) {

        registrationPage.usernameTextbox.sendKeys(faker.name().username());
    }
    @Given("User enters an invalid blank email {string}")
    public void user_enters_an_invalid_blank_email(String blankEmail) {
        registrationPage.emailTextbox.sendKeys(blankEmail,Keys.ENTER);
    }

    @Then("User verifies the email error massage")
    public void user_verifies_the_email_error_massage() {
        Assert.assertTrue(registrationPage.emailRequiredText.isDisplayed());
    }
    @Given("User enters an invalid email without @ {string}")
    public void user_enters_an_invalid_email_without (String invalidEmail) {
        registrationPage.emailTextbox.sendKeys(invalidEmail,Keys.ENTER);

    }
    @Given("User enters an invalid email without .com {string}")
    public void user_enters_an_invalid_email_without_com(String invalidEmail) {
        registrationPage.emailTextbox.sendKeys(invalidEmail,Keys.ENTER);

    }
    @Given("User enters a valid email {string} and {string}")
    public void user_enters_a_valid_email_and(String validEmail, String password) {
        registrationPage.emailTextbox.sendKeys(faker.internet().emailAddress());
        registrationPage.firstPasswordTextbox.sendKeys(password);
        registrationPage.newPasswordTextbox.sendKeys(password);
    }
    @Given("user clicks on register button and sees the success message")
    public void user_clicks_on_register_button_and_sees_the_success_message() {
        Driver.waitAndClick(registrationPage.registerButton,3);
        registrationPage.registerButton.click();
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
        Driver.waitAndClick(registrationPage.registerButton,3);
    }


    @Then("User close the application")
    public void user_close_the_application() {
   Driver.closeDriver();

    }
}
