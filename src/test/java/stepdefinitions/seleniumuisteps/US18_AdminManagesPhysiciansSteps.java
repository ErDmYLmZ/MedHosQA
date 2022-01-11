package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.*;
import lombok.extern.java.Log;
import pages.CommonPageElements;
import pages.LoginPage;
import pages.PhysiciansCreateEditPage;
import pages.PhysiciansPage;
import utilities.Driver;

public class US18_AdminManagesPhysiciansSteps {

    PhysiciansPage physiciansPage = new PhysiciansPage();
    PhysiciansCreateEditPage physiciansCreateEditPage = new PhysiciansCreateEditPage();
    CommonPageElements commonPageElements = new CommonPageElements();
    LoginPage loginPage = new LoginPage();

    @Given("user goes to the website")
    public void userGoesToTheWebsite() {
        //We are using Hooks class method to go to the url
        //Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Given("admin should click to sign in dropdown by clicking humon icon at the top of the right")
    public void admin_should_click_to_sign_in_dropdown_by_clicking_humon_icon_at_the_top_of_the_right() {
        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
        Driver.waitAndClick(commonPageElements.signIn);
    }

    @Given("admin provides {string} and {string} credentials and clicks sign in button")
    public void admin_provides_and_credentials_and_clicks_sign_in_button(String string, String string2) {
//           Driver.waitAndSendText(loginPage.username);
    }
    @Given("admin clicks on items&titles dropdown")
    public void admin_clicks_on_items_titles_dropdown() {


    }
    @Given("admin clicks on physician")
    public void admin_clicks_on_physician() {


    }

    @When("admin clicks on Create a new Physician button")
    public void admin_clicks_on_create_a_new_physician_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("admin enters an existing SSN id in SSN box")
    public void admin_enters_an_existing_ssn_id_in_ssn_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("admin clicks on Search user and verifies the pop-up message as an {string}")
    public void admin_clicks_on_search_user_and_verifies_the_pop_up_message_as_an(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("admin enters an existing SSN id in SSN box and vefiries the doctor's info such as firstname, lastname,birth date etc. is populated")
    public void admin_enters_an_existing_ssn_id_in_ssn_box_and_vefiries_the_doctor_s_info_such_as_firstname_lastname_birth_date_etc_is_populated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();

    }
    @Then("admin types a specialty in the Speciality Box for the doctor and verifies the physician's specialty is provided")
    public void admin_types_a_specialty_in_the_speciality_box_for_the_doctor_and_verifies_the_physician_s_specialty_is_provided() {


    }
    @Then("admin clicks on Choose file Button and uploads the picture for the doctor and verifies the physician's image is provided")
    public void admin_clicks_on_choose_file_button_and_uploads_the_picture_for_the_doctor_and_verifies_the_physician_s_image_is_provided() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    //    @When("???")
//    public void () {
//
//    }
    @Then("admin clicks on Exam Fee Box and types an amount of exam fee of the doctor and verifies the exam fee is provided")
    public void admin_clicks_on_exam_fee_box_and_types_an_amount_of_exam_fee_of_the_doctor_and_verifies_the_exam_fee_is_provided() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("admin clicks on view portal and and verifies all Physicians' info populated on view portal")
    public void admin_clicks_on_view_portal_and_and_verifies_all_physicians_info_populated_on_view_portal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("admin clicks on edit portal")
    public void admin_clicks_on_edit_portal() {

    }
    @Then("admin types new data for existing Phisicians' info and verifies the pop-up meassage {string}")
    public void admin_types_new_data_for_existing_phisicians_info_and_verifies_the_pop_up_meassage(String string) {

    }


    @Then("admin clicks on delete portal and verifies the pop-up meassage {string}")
    public void admin_clicks_on_delete_portal_and_verifies_the_pop_up_meassage(String string) {

    }


    @When("Connect with the Api")
    public void connect_with_the_api() {

    }
    @Then("Validate the data by using get request")
    public void validate_the_data_by_using_get_request() {

    }

    @When("Connect the DB with the JDBC")
    public void connect_the_db_with_the_jdbc() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Validate the data by using Database")
    public void validate_the_data_by_using_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}