package stepdefinitions.seleniumuisteps;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReadTxt;
import utilities.WriteToTxt;
import java.util.List;
public class RegistrationSteps {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    Registrant registrant = new Registrant();
    String fileName =  ConfigReader.getProperty("file_name");
    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
    }
    @Given("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String ssn) {
        ssn = faker.idNumber().ssnValid();
        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn);
        registrant.setSsn(ssn);
    }
    @Then("user enters firstname and lastname as {string} and {string}")
    public void user_enters_firstname_and_lastname_as_and(String firstname, String lastname) {
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstname,5);
        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastname,7);
    }
    @Then("user provides a username {string}")
    public void user_provides_a_username(String username) {
        username = faker.name().username();
        registrant.setUsername(username);
        Driver.waitAndSendText( registrationPage.usernameTextbox,username,5);
    }
    @Then("user provides email id as {string}")
    public void user_provides_email_id_as(String email) {
        email = registrant.getFirstName() + registrant.getLastName()  + "@gmail.com";
        registrant.setEmail(email);
        Driver.waitAndSendText(registrationPage.emailTextbox,email,5);
    }
    @When("user enters the password as {string}")
    public void user_enters_the_password_as(String firstPassword) {
        Driver.sleep(1000);
        firstPassword = faker.internet().password(8, 15, true, true);
        registrant.setPassword(firstPassword);
        Driver.waitAndSendText( registrationPage.firstPasswordTextbox,firstPassword,5);
    }
    @When("user confirms the new password {string}")
    public void user_confirms_the_new_password(String secondPassword) {
        Driver.sleep(1000);
        secondPassword = registrant.getPassword();
        Driver.waitAndSendText(registrationPage.newPasswordTextbox,secondPassword,5);
    }
    @Then("user clicks on register button and sees the success message as {string}")
    public void user_clicks_on_register_button_and_sees_the_success_message_as(String expectedMessage) {
        Driver.waitAndClick(registrationPage.registerButton);
        Driver.sleep(1000);
        Assert.assertTrue("Registration has failed! ",registrationPage.successMessageToastContainer.isDisplayed());
        WriteToTxt.saveRegistrantData(fileName, registrant);
    }
    @Then("user reads all registrant data")
    public void user_reads_all_registrant_data() {


    }
}