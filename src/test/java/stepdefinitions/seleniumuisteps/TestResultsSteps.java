package stepdefinitions.seleniumuisteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.Driver;

import java.util.List;
public class TestResultsSteps {
    LoginPage loginPage = new LoginPage();
    CommonPageElements cp = new CommonPageElements();
    PhysicianAppointmentPage pyhisicianApp = new PhysicianAppointmentPage();
    AppointmentUpdatePage appUpdate = new AppointmentUpdatePage();
    TestsPage testsPage = new TestsPage();
    TestResultsPage testResultsPage = new TestResultsPage();
    @Given("user goes to website with {string}")
    public void user_goes_to_website_with(String url) {
        Driver.navigateToUrl(url);
    }
    @Given("user click to sign in dropdown by clicking human icon at the top of the right")
    public void user_click_to_sign_in_dropdown_by_clicking_human_icon_at_the_top_of_the_right() {
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signIn);
    }
    @Given("user provides {string} and {string} credentials and clicks sign in button")
    public void user_provides_and_credentials_and_clicks_sign_in_button(String username, String password) {
        Driver.waitAndSendText(loginPage.username,username);
        Driver.waitAndSendText(loginPage.password,password);
        Driver.waitAndClick(loginPage.loginButton);
    }
    @Given("user clicks My Pages tap and selects My Appointments dropdown")
    public void user_clicks_my_pages_tap_and_selects_my_appointments_dropdown() {
        Driver.waitAndClick(cp.myPages);
        Driver.waitAndClick(cp.myAppointments);
    }
    @Given("user clicks Edit button of the the patient to navigate the appointment-update page")
    public void user_clicks_edit_button_of_the_the_patient_to_navigate_the_appointment_update_page() {
        Driver.waitAndClick(pyhisicianApp.edit);
    }
    @When("user clicks  Show Test Results item")
    public void user_clicks_show_test_results_item() {
        Driver.waitAndClick(appUpdate.showTestResults);
    }
    @When("user clicks View Results button to navigates tests info")
    public void user_clicks_view_results_button_to_navigates_tests_info() {
        Driver.waitAndClick(testsPage.viewResults);
    }
    @Then("user validates that test info is seen on the page")
    public void user_validates_that_test_info_is_seen_on_the_page() {
        //   List<String> infoListOfTests = ReusableMethods.getElementsText(By.xpath("//table//tbody//tr//td[2]"));
        List <WebElement> infoListOfTests = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[2]"));
        int row = 1;
        for (WebElement eachElement :infoListOfTests) {
            System.out.println(row-1 + ". ==> " + eachElement.getText());
            row++;
        }
        System.out.println("description list size = " + infoListOfTests.size());
        System.out.println(infoListOfTests.get(0).getText());
        Assert.assertTrue(infoListOfTests.get(0).getText().contains("Glucose"));
    }
    @When("user clicks Request Inpatient item")
    public void user_clicks_request_inpatient_item() {
        Driver.waitAndClick(cp.myPages,3);
        Driver.waitAndClick(cp.myAppointments,3);
        Driver.waitAndClick(pyhisicianApp.edit,3);
        Driver.waitAndClick(appUpdate.requestInpatient,3);
    }
    @Then("verify the pop-up message {string}")
    public void verify_the_pop_up_message(String string) {
        System.out.println(appUpdate.errorMessage.getText());
        Assert.assertFalse("A new in Patient is created",appUpdate.errorMessage.isDisplayed());
    }
    @Then("close the page")
    public void closeThePage() {
        Driver.closeDriver();
    }
}
