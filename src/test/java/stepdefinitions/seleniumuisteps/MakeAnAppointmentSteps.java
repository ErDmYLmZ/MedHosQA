package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.LoginPage;
import pages.MakeAnAppointmentPage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MakeAnAppointmentSteps {

    CommonPageElements commonPageElements = new CommonPageElements();
    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();
    MakeAnAppointmentPage makeAnAppointmentPage = new MakeAnAppointmentPage();


    @Given("user goes to webpage")
    public void user_goes_to_webpage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));


    }
    @Given("user select make an appointment button")
    public void user_select_make_an_appointment_button() {
        Driver.waitAndClick(makeAnAppointmentPage.makeAnAppointmentButton);

    }
    @Given("user enters firstname")
    public void user_enters_firstname() {
        Driver.waitAndSendText(makeAnAppointmentPage.firstnameButton,"Ali");


    }
    @Then("user verify the first name box is not blank")
    public void user_verify_the_first_name_box_is_not_blank() {
        Assert.assertFalse(makeAnAppointmentPage.firstnameButton.getAttribute("value").isEmpty());

    }
    @Given("user enters SSN")
    public void user_enters_ssn() {
        Driver.waitAndSendText(makeAnAppointmentPage.SsnButton,"123-65-3098");

    }
    @Then("user verify the ssn box is not blank")
    public void user_verify_the_ssn_box_is_not_blank() {
        Assert.assertFalse(makeAnAppointmentPage.SsnButton.getAttribute("value").isEmpty());

    }
    @Given("user enters lastname")
    public void user_enters_lastname() {
        Driver.waitAndSendText(makeAnAppointmentPage.lastnameButton,"Ciftci");

    }
    @Then("user verify the lastname box is not blank")
    public void user_verify_the_lastname_box_is_not_blank() {
        Assert.assertFalse(makeAnAppointmentPage.lastnameButton.getAttribute("value").isEmpty());

    }
    @Given("user enters email")
    public void user_enters_email() {
        Driver.waitAndSendText(makeAnAppointmentPage.emailButton,"Alis@gmail.com");

    }
    @Then("user verify the email box is not blank")
    public void user_verify_the_email_box_is_not_blank() {
        Assert.assertFalse(makeAnAppointmentPage.emailButton.getAttribute("value").isEmpty());

    }
    @Given("user enters phone")
    public void user_enters_phone() {
        Driver.waitAndSendText(makeAnAppointmentPage.phoneButton,"1234567889");

    }
    @Then("Then user verify the email box is not blank")
    public void then_user_verify_the_email_box_is_not_blank() {
        Assert.assertFalse(makeAnAppointmentPage.emailButton.getAttribute("value").isEmpty());

    }
    @Given("user click send an appointment request button")
    public void user_click_send_an_appointment_request_button() {

        Driver.waitAndClick(makeAnAppointmentPage.sendAnAppointmentRequestButton);

    }
    @Given("User goes register dropdown and click register button")
    public void user_goes_register_dropdown_and_click_register_button() {
        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
  //      registrationPage.registerDropDownMenu.click();//?

    }
    @Given("user enters same ssn")
    public void user_enters_same_ssn() {
        Driver.waitAndSendText(registrationPage.ssnTextbox,"123-65-3098");


    }
    @Given("user enters same firstname")
    public void user_enters_same_firstname() {
        Driver.waitAndSendText(registrationPage.firstnameTextbox,"Ali");

    }
    @Given("ser enters same lastname")
    public void ser_enters_same_lastname() {
        Driver.waitAndSendText(registrationPage.lastnameTextbox,"Ciftci");

    }
    @Given("user enters username")
    public void user_enters_username() {
        Driver.waitAndSendText(registrationPage.usernameTextbox,"Alis");

    }
    @Given("user enters same email")
    public void user_enters_same_email() {
        Driver.waitAndSendText(registrationPage.emailTextbox,"Alis@gmail.com");

    }
    @Given("user enters password")
    public void user_enters_password() {
        Driver.waitAndSendText(registrationPage.firstPasswordTextbox,"123Alis.");

    }
    @Given("user enters confirm password again")
    public void user_enters_confirm_password_again() {
        Driver.waitAndSendText(registrationPage.newPasswordTextbox,"123Alis.");

    }
    @Given("user click register button")
    public void user_click_register_button() {
        Driver.waitAndClick(registrationPage.registerButton);

    }
    @Given("user goes sign in dropdown and click sign in button")
    public void user_goes_sign_in_dropdown_and_click_sign_in_button() {
        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal); //??
   //     Driver.waitAndClick(loginPage.signInDropDown);


    }
    @Given("user click sign in button")
    public void user_click_sign_in_button() {
        Driver.waitAndClick(commonPageElements.signIn);

    }
    @Then("Verify user sees all information")
    public void verify_user_sees_all_information() {

        System.out.println("silinecek sati");

    }









}
