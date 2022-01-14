package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.Driver.waitForVisibility;

public class US04_Login_Validity_Check {

    LoginPage loginPage = new LoginPage();
    CommonPageElements commonPageElements = new CommonPageElements();
    AdminPage adminPage=new AdminPage();
    DoctorPage doctorPage=new DoctorPage();
    PatientPage patientPage=new PatientPage();
    StaffPage staffPage=new StaffPage();
    UserPage userPage=new UserPage();
    DrAppointmentsPage drAppointmentsPage=new DrAppointmentsPage();
    @Given("user navigates to landing page")
    public void user_navigates_to_landing_page() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

    }
    @Then("admin click sign in button")
    public void admin_click_sign_in_button() {
        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
        Driver.waitAndClick(commonPageElements.signIn);
    }
    @Then("admin enters username {string}")
    public void admin_enters_username(String admin_username) {
        Driver.waitAndSendText(loginPage.username, admin_username);
    }
    @Then("admin user enters password {string}")
    public void admin_user_enters_password(String admin_password) {
        Driver.waitAndSendText(loginPage.password, admin_password);
    }
    @Then("admin clicks on login button")
    public void admin_clicks_on_login_button() {
        Driver.waitAndClick(loginPage.loginButton);
    }
    @Then("admin checks administration menu exist")
    public void admin_checks_administration_menu_exist() {
        String text=adminPage.administrationDropdown.getText();
        System.out.println(text);
        Assert.assertEquals("Administration",text);
    }
    @Then("admin logs out the page")
    public void admin_logs_out_the_page() {
        Driver.sleep(1);
        adminPage.accountMenu.click();
        Driver.sleep(3);
        adminPage.signOut.click();

    }

    @Then("staff enters username {string}")
    public void staff_enters_username(String staff_username ) {
        Driver.waitAndSendText(loginPage.username, staff_username);
        Driver.sleep(3);
    }

    @Then("staff user enters password {string}")
    public void staff_user_enters_password(String staff_password) {
        Driver.sleep(3);
        Driver.waitAndSendText(loginPage.password, staff_password);


    }

    @Then("staff goes to My Pages and Search Patient")
    public void staff_goes_to_my_pages_and_search_patient() {
        Driver.waitAndClick(staffPage.staffMyPage);
        Driver.sleep(3);
        Driver.waitAndClick(staffPage.staffSearchPatient);
    }
    @Then("staff searches a patient with {string}")
    public void staff_searches_a_patient_with(String patient_ssn) {
        Driver.sleep(3000);
        Driver.waitAndSendText(staffPage.ssnInputBox,patient_ssn);
        Driver.sleep(1000);
    }

    @Then("staff clicks edit and verify {string} and {string}")
    public void staff_clicks_edit_and_verify_and(String patient_name, String patient_surname){
        Driver.waitAndClick(staffPage.editButton);
        Driver.sleep(1000);
        String name=staffPage.patientFirstName.getAttribute("value");
        System.out.println(name);
        String surname=staffPage.patientLastName.getAttribute("value");
        System.out.println(surname);
        Driver.sleep(1000);
        Assert.assertEquals(name,patient_name);
        Assert.assertEquals(surname,patient_surname);
    }
    @Then("staff logs out the page")
    public void staff_logs_out_the_page() {
        adminPage.accountMenu.click();
        Driver.sleep(1000);
        adminPage.signOut.click();
    }

    @Then("doctor goes to My Pages and verify Appointments")
    public void doctor_goes_to_my_pages_and_verify_appointments() {
        doctorPage.myPagesDropdown.click();
        Driver.waitAndClick(doctorPage.myAppointments);
        Driver.sleep(1000);
        String appointment=drAppointmentsPage.appointmentTextVerify.getText();
        System.out.println(appointment);
        Assert.assertEquals("Appointments",appointment);
    }
    @Then("doctor logs out the page")
    public void doctor_logs_out_the_page() {
       doctorPage.accountMenu.click();
      doctorPage.signOutButton.click();
    }

    @Then("admin checks login failed message")
    public void admin_checks_login_failed_message() {

        waitForVisibility(loginPage.failedLogin,3);
        String failedLogin=loginPage.failedLogin.getText();

        System.out.println(failedLogin);
        Assert.assertTrue(failedLogin.contains("Authentication information not correct"));
    }
    @Then("admin click register a new account")
    public void admin_click_register_a_new_account() {
        Driver.sleep(1000);
        loginPage.proceedToRegistration.click();
    }
    @Then("admin verifies registration text")
    public void admin_verifies_registration_text() {

        String verifyText=loginPage.registerVerify.getText();
        System.out.println( verifyText);
        Assert.assertTrue(verifyText.contains("Registration"));

    }

    @Then("admin clicks remember me button")
    public void admin_clicks_remember_me_button() {
        loginPage.rememberMeCheckmark.click();

    }
    @Then("checkbox of remember me")
    public void checkbox_of_remember_me() {

        boolean rememberMeCheckValueSelected=loginPage.rememberMeCheckValue.isSelected();
        System.out.println(rememberMeCheckValueSelected);
        if (!rememberMeCheckValueSelected){
            try {

                waitForVisibility(loginPage.loginTitle,3);
                ReusableMethods.getScreenshot("rememberMeIsNotSelected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Then("user verifies if username and password area is filled")
    public void user_verifies_if_username_and_password_area_is_filled() {
        boolean usernameEmpty=loginPage.username.getAttribute("value").isEmpty();
        System.out.println(usernameEmpty);
        if(usernameEmpty){
            waitForVisibility(loginPage.username,3);
            try {
                ReusableMethods.getScreenshot("username field is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Then("admin clicks cancel button")
    public void admin_clicks_cancel_button() {
        Driver.wait(1);
        loginPage.cancelButton.click();

    }
}
