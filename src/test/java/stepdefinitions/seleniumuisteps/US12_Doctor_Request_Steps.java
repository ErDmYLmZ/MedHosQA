package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.DoctorPage;
import pages.LoginPage;
import utilities.Driver;

public class US12_Doctor_Request_Steps {

    LoginPage loginPage = new LoginPage();
    CommonPageElements commonPageElements = new CommonPageElements();
    DoctorPage doctorPage = new DoctorPage();


    @Given("Doctor goes to url")
    public void doctor_goes_to_url() {
        //We are using Hooks class method to go to the url
        //Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Given("Doctor navigates to sign in page")
    public void doctor_navigates_to_sign_in_page() {
        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
    }
    @Given("Doctor clicks on sign in button")
    public void doctor_clicks_on_sign_in_button() {
        Driver.waitAndClick(commonPageElements.signIn);
    }
    @Given("Doctor enters username {string}")
    public void doctor_enters_username(String username) {
        Driver.waitAndSendText(loginPage.username, username);
    }
    @Given("Doctor enters password {string}")
    public void doctor_enters_password(String password) {
        Driver.waitAndSendText(loginPage.password, password);
    }
    @Given("Doctor clicks sign in button")
    public void doctor_clicks_sign_in_button() {
        Driver.waitAndClick(loginPage.loginButton);
    }
    @Given("Doctor clicks My Pages dropdown and clicks My Appointments")
    public void doctor_clicks_my_pages_dropdown_and_clicks_my_appointments() {
        Driver.waitAndClick(doctorPage.myPagesDropdown);
        Driver.waitAndClick(doctorPage.myAppointments);
    }
    @Given("Doctor clicks Edit button of the patient and navigates to Create or Edit Appointments page")
    public void doctor_clicks_edit_button_of_the_patient_and_navigates_to_create_or_edit_appointments_page() {
        Driver.waitAndClick(doctorPage.editButtonForNewPatient);
        Assert.assertTrue(doctorPage.createOrEditAnAppointmentPageText.isDisplayed());
    }
    @Given("Doctor clicks Request a test item")
    public void doctor_clicks_request_a_test_item() {

        Driver.clickWithJS(doctorPage.requestATestButton);
    }
    @Then("Doctor navigates to Test Items page and verifies the text of the page")
    public void doctor_navigates_to_test_items_page_and_verifies_the_text_of_the_page() {

        Assert.assertTrue(doctorPage.testItemsPageText.getText().equals("Test Items"));
    }

    @Given("Doctor is on the Test Items Page")
    public void doctor_is_on_the_test_items_page() {
        Assert.assertTrue(doctorPage.testItemsPageText.getText().contains("Test Items"));
    }
    @Given("Doctor puts checkmark to the options {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void doctor_puts_checkmark_to_the_options(String glucose, String urea, String creatinine, String sodium, String potassium, String totalProtein, String albumin, String hemoglobin) {
        Driver.waitAndClick(doctorPage.glucose);
        Driver.waitAndClick(doctorPage.urea);
        Driver.waitAndClick(doctorPage.creatinine);
        Driver.waitAndClick(doctorPage.sodium);
        Driver.waitAndClick(doctorPage.potassium);
        Driver.waitAndClick(doctorPage.totalProtein);
        Driver.waitAndClick(doctorPage.albumin);
        Driver.waitAndClick(doctorPage.hemoglobin);
    }
    @Given("Doctor clicks save button")
    public void doctor_clicks_save_button() {
        Driver.waitAndClick(doctorPage.saveButton);
    }
    @Then("Doctor verifies success message and Create or edit an Appointment text as navigates back to that page")
    public void doctor_verifies_success_message_and_create_or_edit_an_appointment_text_as_navigates_back_to_that_page() {
        Driver.wait(2);
        Assert.assertTrue(doctorPage.successMessageForTestCreation.isDisplayed());
        Driver.wait(2);
        Assert.assertTrue(doctorPage.createOrEditAnAppointmentPageText.isDisplayed());
    }


}
