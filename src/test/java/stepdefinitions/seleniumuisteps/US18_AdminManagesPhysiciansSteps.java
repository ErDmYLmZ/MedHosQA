package stepdefinitions.seleniumuisteps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPageElements;
import pages.LoginPage;
import pages.PhysiciansCreateEditPage;
import pages.PhysiciansPage;
import utilities.Driver;

import java.util.List;

public class US18_AdminManagesPhysiciansSteps {

     PhysiciansPage physiciansPage = new PhysiciansPage();
     PhysiciansCreateEditPage physiciansCreateEditPage = new PhysiciansCreateEditPage();
     LoginPage loginPage = new LoginPage();
     CommonPageElements commonPageElements = new CommonPageElements();

    @Given("user goes to the website with {string}")
    public void userGoesToTheWebsiteWith(String url) {

        Driver.navigateToUrl(url);
    }
    @Given("admin should click to sign in dropdown by clicking humon icon at the top of the right")
    public void admin_should_click_to_sign_in_dropdown_by_clicking_humon_icon_at_the_top_of_the_right() {

       Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
       Driver.waitAndClick(commonPageElements.signIn);
    }

    @Given("admin provides {string} and {string} credentials and clicks sign in button")
    public void admin_provides_and_credentials_and_clicks_sign_in_button(String username, String password) {

        Driver.waitAndSendText(loginPage.username,username);
        Driver.waitAndSendText(loginPage.password,password);
        Driver.waitAndClick(loginPage.loginButton);


    }
    @Given("admin clicks on items&titles dropdown")
    public void admin_clicks_on_items_titles_dropdown() {

        Driver.waitAndClick(commonPageElements.itemsAndTitles);
    }
    @Given("admin clicks on physician")
    public void admin_clicks_on_physician() {
        Driver.waitAndClick(commonPageElements.physician);

    }

    @When("admin clicks on Create a new Physician button")
    public void admin_clicks_on_create_a_new_physician_button() {
        Driver.waitAndClick(physiciansPage.createANewPhysician);
    }
    @When("admin enters an existing SSN id in SSN box")
    public void admin_enters_an_existing_ssn_id_in_ssn_box() {
        Driver.waitAndClick(commonPageElements.itemsAndTitles);
        Driver.waitAndClick(commonPageElements.physician);
        List<WebElement> column1Data = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[2]"));
        int row = 1;
        for (WebElement eachElement :column1Data) {
            System.out.println(row-1 + ". ==> " + eachElement.getText());
            row++;
        }

        System.out.println(column1Data.get(0).getText());
        String ssnId = column1Data.get(0).getText();
        Driver.waitAndClick(physiciansPage.createANewPhysician);
        Driver.waitAndSendText(physiciansCreateEditPage.ssnBox,ssnId);
    }
    @Then("admin clicks on Search user and verifies the pop-up message as an {string}")
    public void admin_clicks_on_search_user_and_verifies_the_pop_up_message_as_an(String string) {

        Driver.waitAndClick(physiciansCreateEditPage.searchUserButton);
        Assert.assertTrue(physiciansCreateEditPage.successMessage.isDisplayed());
    }


    @Then("admin marks use search checkbox and verifies the doctor's info such as firstname, lastname,birth date etc. is populated")
    public void adminMarksUseSearchCheckboxAndVerifiesTheDoctorSInfoSuchAsFirstnameLastnameBirthDateEtcIsPopulated() {

        Driver.waitAndClick(physiciansCreateEditPage.useSearchCheckbox);


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

    }


    @Then("admin clicks on view portal and and verifies all Physicians' info populated on view portal")
    public void admin_clicks_on_view_portal_and_and_verifies_all_physicians_info_populated_on_view_portal() {

    }

    @When("admin clicks on edit portal")
    public void admin_clicks_on_edit_portal() {

    }
    @Then("admin types new data for existing Physicians' info and verifies the pop-up meassage {string}")
    public void admin_types_new_data_for_existing_physicians_info_and_verifies_the_pop_up_meassage(String string) {

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

    }
    @Then("Validate the data by using Database")
    public void validate_the_data_by_using_database() {

    }

}
